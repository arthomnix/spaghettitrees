package dev.arthomnix.spaghettitrees.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.function.BiConsumer;

@Mixin(LargeOakFoliagePlacer.class)
public class LargeOakFoliagePlacerMixin {
    @Redirect(method = "generate",
    at = @At(value = "INVOKE", target = "net/minecraft/world/gen/foliage/LargeOakFoliagePlacer.generateSquare (Lnet/minecraft/world/TestableWorld;Ljava/util/function/BiConsumer;Lnet/minecraft/util/math/random/" +
            "Random;Lnet/minecraft/world/gen/feature/TreeFeatureConfig;Lnet/minecraft/util/math/BlockPos;IIZ)V"))
    private void generateFoliageWithAddedRadius(LargeOakFoliagePlacer instance, TestableWorld world, BiConsumer<BlockPos, BlockState> biConsumer, Random random, TreeFeatureConfig config, BlockPos blockPos, int r, int y, boolean b, TestableWorld methodWorld, BiConsumer<BlockPos, BlockState> replacer, Random methodRandom, TreeFeatureConfig methodConfig, int trunkHeight, FoliagePlacer.TreeNode treeNode, int foliageHeight, int radius, int offset) {
        ((FoliagePlacerInvoker) instance).callGenerateSquare(world, biConsumer, random, config, blockPos, r + treeNode.getFoliageRadius(), y, treeNode.isGiantTrunk());
    }
}