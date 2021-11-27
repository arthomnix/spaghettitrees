package dev.arthomnix.spaghettitrees.mixin;

import dev.arthomnix.spaghettitrees.tree.BetterTrees;
import net.minecraft.world.biome.DefaultBiomeCreator;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DefaultBiomeCreator.class)
public class DefaultBiomeCreatorMixin {
    // more making our trees generate instead of vanilla trees
    @Redirect(method = "createDarkForest", at = @At(value = "INVOKE", target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"))
    private static GenerationSettings.Builder returnBetterDarkForestVegetation(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature, float depth, float scale, boolean hills) {
        return instance.feature(featureStep, hills ? BetterTrees.BETTER_DARK_FOREST_VEGETATION_RED : BetterTrees.BETTER_DARK_FOREST_VEGETATION_BROWN);
    }

    @Redirect(method = "createForest", at = @At(value = "INVOKE", target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;", ordinal = 1))
    private static GenerationSettings.Builder returnBetterFlowerForestTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature, float depth, float scale, boolean hills) {
        return instance.feature(featureStep, BetterTrees.BETTER_FLOWER_FOREST_TREES);
    }
}
