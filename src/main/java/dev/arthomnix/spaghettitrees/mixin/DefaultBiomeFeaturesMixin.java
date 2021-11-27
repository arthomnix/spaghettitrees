package dev.arthomnix.spaghettitrees.mixin;

import dev.arthomnix.spaghettitrees.tree.BetterTrees;
import net.minecraft.world.biome.GenerationSettings;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.DefaultBiomeFeatures;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(DefaultBiomeFeatures.class)
public class DefaultBiomeFeaturesMixin {
    // make our trees generate instead of vanilla trees
    @Redirect(method="addForestTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterForestTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_FOREST_TREES);
    }

    @Redirect(method="addBirchTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterBirchForestTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_BIRCH_TREES);
    }

    @Redirect(method="addTallBirchTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterTallBirchForestTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_BIRCH_TREES);
    }

    @Redirect(method="addPlainsFeatures",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;",
                    ordinal = 0
            ))
    private static GenerationSettings.Builder addBetterPlainsTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_PLAINS_TREES);
    }

    @Redirect(method="addBambooJungleTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;",
                    ordinal = 1
            ))
    private static GenerationSettings.Builder BetterBambooJungleTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_BAMBOO_JUNGLE_VEGETATION);
    }

    @Redirect(method="addWaterBiomeOakTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterWaterTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_WATER_TREES);
    }

    @Redirect(method="addJungleTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterJungleTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_JUNGLE_TREES);
    }

    @Redirect(method="addJungleEdgeTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterJungleEdgeTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_JUNGLE_EDGE_TREES);
    }

    @Redirect(method="addSavannaTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterSavannahTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_SAVANNAH_TREES);
    }

    @Redirect(method="addExtraSavannaTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterShatteredSavannahTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_SHATTERED_SAVANNAH_TREES);
    }

    @Redirect(method="addSwampFeatures",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;",
                    ordinal = 0
            ))
    private static GenerationSettings.Builder addBetterSwampTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_SWAMP_TREES);
    }

    @Redirect(method="addBadlandsPlateauTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterBadlandsTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_BADLANDS_TREES);
    }

    @Redirect(method="addMountainTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterMountainTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_MOUNTAIN_TREES);
    }

    @Redirect(method="addExtraMountainTrees",
            at = @At(value="INVOKE",
                    target = "net/minecraft/world/biome/GenerationSettings$Builder.feature (Lnet/minecraft/world/gen/GenerationStep$Feature;Lnet/minecraft/world/gen/feature/ConfiguredFeature;)Lnet/minecraft/world/biome/GenerationSettings$Builder;"
            ))
    private static GenerationSettings.Builder addBetterMountainEdgeTrees(GenerationSettings.Builder instance, GenerationStep.Feature featureStep, ConfiguredFeature<?, ?> feature) {
        return instance.feature(featureStep, BetterTrees.BETTER_MOUNTAIN_EDGE_TREES);
    }
}
