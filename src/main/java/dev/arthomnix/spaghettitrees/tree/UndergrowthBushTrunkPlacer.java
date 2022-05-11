package dev.arthomnix.spaghettitrees.tree;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeature;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class UndergrowthBushTrunkPlacer extends StraightTrunkPlacer {
    public static final Codec<UndergrowthBushTrunkPlacer> CODEC = RecordCodecBuilder.create(
            instance -> fillTrunkPlacerFields(instance).apply(instance, UndergrowthBushTrunkPlacer::new)
    );

    public UndergrowthBushTrunkPlacer(int i, int j, int k) {
        super(i, j, k);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return BetterTreesConfiguredFeatures.UNDERGROWTH_BUSH_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        BlockState trunkBlock = config.trunkProvider.getBlockState(random, startPos);

        setToDirt(world, replacer, random, startPos.down(), config);
        for (int i = 0; i < height; ++i) {
            if (TreeFeature.canReplace(world, startPos.up(i))) {
                replacer.accept(startPos.up(i), trunkBlock);
            }
        }

        return ImmutableList.of(new FoliagePlacer.TreeNode(startPos.up(height), 0, false));
    }
}