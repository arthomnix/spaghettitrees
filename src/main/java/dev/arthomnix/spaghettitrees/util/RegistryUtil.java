package dev.arthomnix.spaghettitrees.util;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.PlacedFeature;

public class RegistryUtil {
    public static RegistryEntry<PlacedFeature> registerPlacedFeature(Identifier id, PlacedFeature feature) {
        return BuiltinRegistries.add(BuiltinRegistries.PLACED_FEATURE, id, feature);
    }

    public static <FC extends FeatureConfig, F extends Feature<FC>> RegistryEntry<ConfiguredFeature<?, ?>> registerConfiguredFeature(Identifier id, F feature, FC config) {
        return BuiltinRegistries.add(BuiltinRegistries.CONFIGURED_FEATURE, id, new ConfiguredFeature<>(feature, config));
    }
}
