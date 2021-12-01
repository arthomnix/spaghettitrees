package dev.arthomnix.spaghettitrees.mixin;

import dev.arthomnix.spaghettitrees.tree.BetterTreesPlacedFeatures;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import net.minecraft.world.gen.feature.PlacedFeature;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {
    // make our trees generate instead of vanilla trees
    @Redirect(method="addForestTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterForestTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_FOREST_TREES);
    }

    @Redirect(method="addBirchTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterBirchForestTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_BIRCH_FOREST_TREES);
    }

    @Redirect(method="addTallBirchTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterTallBirchForestTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_TALL_BIRCH_FOREST_TREES);
    }

    @Redirect(method="addPlainsFeatures",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;",
                    ordinal = 0
            ))
    private static GenerationSettings.Builder addBetterPlainsTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_PLAINS_TREES);
    }

    @Redirect(method="addBambooJungleTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;",
                    ordinal = 1
            ))
    private static GenerationSettings.Builder BetterBambooJungleTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_BAMBOO_JUNGLE_VEGETATION);
    }

    @Redirect(method="addWaterBiomeOakTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterWaterTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_WATER_BIOME_TREES);
    }

    @Redirect(method="addJungleTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterJungleTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_JUNGLE_TREES);
    }

    @Redirect(method="addSparseJungleTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterJungleEdgeTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_SPARSE_JUNGLE_TREES);
    }

    @Redirect(method="addSavannaTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterSavannahTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_SAVANNAH_TREES);
    }

    @Redirect(method="addExtraSavannaTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterWindsweptSavannahTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_WINDSWEPT_SAVANNAH_TREES);
    }

    @Redirect(method="addSwampFeatures",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;",
                    ordinal = 0
            ))
    private static GenerationSettings.Builder addBetterSwampTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_SWAMP_TREES);
    }

    @Redirect(method="addBadlandsPlateauTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterBadlandsTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_BADLANDS_TREES);
    }

    @Redirect(method="addWindsweptHillsTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterWindsweptHillsTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_WINDSWEPT_HILLS_TREES);
    }

    @Redirect(method="addWindsweptForestTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/PlacedFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterWindsweptForestTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, PlacedFeature feature) {
        return instance.feature(featureStep, BetterTreesPlacedFeatures.BETTER_WINDSWEPT_FOREST_TREES);
    }
}
