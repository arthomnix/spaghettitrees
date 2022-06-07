package dev.arthomnix.spaghettitrees.mixin.biome;

import dev.arthomnix.spaghettitrees.tree.feature.BetterTreesPlacedFeatures;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.biome.OverworldBiomeCreator;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(OverworldBiomeCreator.class)
public class DefaultBiomeCreatorMixin {
    // more making our trees generate instead of vanilla trees
    @Redirect(method = "createDarkForest", at = @At(value = "INVOKE", target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/util/registry/RegistryEntry;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"))
    private static GenerationSettings.Builder returnBetterDarkForestVegetation(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, RegistryEntry<PlacedFeature> feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_DARK_FOREST_VEGETATION);
    }

    @Redirect(method = "createNormalForest", at = @At(value = "INVOKE", target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/util/registry/RegistryEntry;)Lnet/minecraft/world/biome/GenerationSettings$Builder;", ordinal = 1))
    private static GenerationSettings.Builder returnBetterFlowerForestTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, RegistryEntry<PlacedFeature> feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_FLOWER_FOREST_TREES);
    }
}