package dev.arthomnix.spaghettitrees.sapling;

import dev.arthomnix.spaghettitrees.tree.BetterTreesConfiguredFeatures;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.feature.ConfiguredFeature;

import java.util.Random;

public class BetterBirchSaplingGenerator extends SaplingGenerator {
    @Override
    protected RegistryEntry<? extends ConfiguredFeature<?, ?>> getTreeFeature(Random random, boolean bees) {
        return bees ? BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH_MORE_BEES : BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH;
    }
}
