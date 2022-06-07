package dev.arthomnix.spaghettitrees.sapling;

import dev.arthomnix.spaghettitrees.tree.feature.BetterTreesConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.feature.ConfiguredFeature;

public class BetterBirchSaplingGenerator extends SaplingGenerator {
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return bees ? BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH_MORE_BEES : BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH;
    }
}