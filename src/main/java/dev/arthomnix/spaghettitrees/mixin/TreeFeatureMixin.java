package dev.arthomnix.spaghettitrees.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import java.util.Random;
import java.util.function.BiConsumer;

@Mixin(TreeFeature.class)
public class TreeFeatureMixin {
    @Redirect(method = "method_27372(Lnet/minecraft/world/gen/feature/TreeFeatureConfig;Lnet/minecraft/world/StructureWorldAccess;Ljava/util/function/BiConsumer;Ljava/util/Random;IIILnet/minecraft/world/gen/foliage/FoliagePlacer$TreeNode;)V",
    at = @At(value="INVOKE", target = "net/minecraft/world/gen/foliage/FoliagePlacer.generate (Lnet/minecraft/world/TestableWorld;Ljava/util/function/BiConsumer;Ljava/util/Random;Lnet/minecraft/world/gen/feature/TreeFeatureConfig;ILnet/minecraft/world/gen/foliage/FoliagePlacer$TreeNode;II)V"))
    // generate a random height and radius for every foliage node rather than every tree
    private static void generateWithRandomizedFoliageRadius(FoliagePlacer instance, TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, TreeFeatureConfig config, int trunkHeight, FoliagePlacer.TreeNode treeNode, int foliageHeight, int radius) {
        int height = config.trunkPlacer.getHeight(random);
        int randomHeight = instance.getRandomHeight(random, height, config);
        int baseHeight = height - randomHeight;
        int randomRadius = instance.getRandomRadius(random, baseHeight);
        instance.generate(world, replacer, random, config, trunkHeight, treeNode, randomHeight, randomRadius);
    }
}
