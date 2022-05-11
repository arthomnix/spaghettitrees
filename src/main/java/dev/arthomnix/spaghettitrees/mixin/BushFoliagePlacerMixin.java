package dev.arthomnix.spaghettitrees.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.FoliagePlacerType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;
import java.util.function.BiConsumer;

@Mixin(BushFoliagePlacer.class)
public class BushFoliagePlacerMixin extends BlobFoliagePlacer {
    public BushFoliagePlacerMixin(IntProvider radius, IntProvider offset, int height) {
        super(radius, offset, height);
    }

    /**
     * Default FoliagePlacers get a new BlockState from the BlockStateProvider for every block.
     * If we want to randomise the block, this means we end up with every block being random, even within the same bush.
     * This makes BushFoliagePlacer generate the same foliage block for every block in the bush.
     */
    @Redirect(method = "generate",
    at = @At(value = "INVOKE", target = "net/minecraft/world/gen/foliage/BushFoliagePlacer.generateSquare (Lnet/minecraft/world/TestableWorld;Ljava/util/function/BiConsumer;Ljava/util/Random;Lnet/minecraft/world/gen/feature/TreeFeatureConfig;Lnet/minecraft/util/math/BlockPos;IIZ)V"))
    private void randomiseFoliageTypePerBush(BushFoliagePlacer instance, TestableWorld testableWorld, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig treeFeatureConfig, BlockPos blockPos, int r, int y, boolean giantTrunk) {
        BlockState foliageBlock = treeFeatureConfig.foliageProvider.getBlockState(random, blockPos);

        BlockPos.Mutable mutable = new BlockPos.Mutable();
        for (int j = -r; j <= r + (giantTrunk ? 1 : 0); ++j) {
            for (int k = -r; k <= r + (giantTrunk ? 1 : 0); ++k) {
                if (!isPositionInvalid(random, j, y, k, r, giantTrunk)) {
                    mutable.set(blockPos, j, y, k);
                    if (TreeFeature.canReplace(testableWorld, mutable)) {
                        replacer.accept(mutable, foliageBlock);
                    }
                }
            }
        }
    }
}