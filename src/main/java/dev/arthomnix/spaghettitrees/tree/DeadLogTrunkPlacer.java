package dev.arthomnix.spaghettitrees.tree;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;

public class DeadLogTrunkPlacer extends BetterTrunkPlacer {
    public static final Codec<DeadLogTrunkPlacer> CODEC = RecordCodecBuilder.create(
            instance -> fillTrunkPlacerFields(instance).apply(instance, DeadLogTrunkPlacer::new)
    );

    public DeadLogTrunkPlacer(int baseHeight, int firstRandomHeight, int secondRandomHeight) {
        super(baseHeight, firstRandomHeight, secondRandomHeight, 0.25D, 2D, 2, 6, 0D, 1D, 0D, 1D);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return BetterTreesConfiguredFeatures.DEAD_LOG_TRUNK_PLACER;
    }

    public List<FoliagePlacer.TreeNode> generate(TestableWorld world, BiConsumer<BlockPos, BlockState> replacer, Random random, int height, BlockPos startPos, TreeFeatureConfig config) {
        int directionId = random.nextInt(5) + 2;
        Direction direction = Direction.byId(directionId);
        Branch deadLog = new Branch(world, replacer, random, startPos, startPos, config, direction, height, 0, 1, 0D, 0D, 0.1D, false);
        deadLog.generate();
        return ImmutableList.of();
    }
}