package dev.arthomnix.spaghettitrees.sapling;

import dev.arthomnix.spaghettitrees.tree.BetterTrees;
import net.minecraft.block.sapling.SaplingGenerator;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import org.jetbrains.annotations.Nullable;

import java.util.Random;

public class BetterOakSaplingGenerator extends SaplingGenerator {
    @Nullable
    @Override
    protected ConfiguredFeature<TreeFeatureConfig, ?> getTreeFeature(Random random, boolean bees) {
        return bees ? BetterTrees.TREE_BETTER_OAK_MORE_BEES : BetterTrees.TREE_BETTER_OAK;
    }
}
