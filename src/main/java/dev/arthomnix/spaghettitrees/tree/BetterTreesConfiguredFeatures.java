package dev.arthomnix.spaghettitrees.tree;

import com.google.common.collect.ImmutableList;
import dev.arthomnix.spaghettitrees.mixin.SimpleBlockStateProviderInvoker;
import dev.arthomnix.spaghettitrees.mixin.TrunkPlacerTypeInvoker;
import dev.arthomnix.spaghettitrees.util.RegistryUtil;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.BlobFoliagePlacer;
import net.minecraft.world.gen.foliage.BushFoliagePlacer;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.treedecorator.TrunkVineTreeDecorator;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;

public class BetterTreesConfiguredFeatures {
    static { System.out.println("Hi from BetterTreesConfiguredFeatures clinit"); }
    public static final TrunkPlacerType<BetterTrunkPlacer> BETTER_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("better_trunk_placer", BetterTrunkPlacer.CODEC);
    public static final TrunkPlacerType<DeadLogTrunkPlacer> DEAD_LOG_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("dead_log_trunk_placer", DeadLogTrunkPlacer.CODEC);

    private static final BeehiveTreeDecorator BEES_RARE = new BeehiveTreeDecorator(0.002f);
    private static final BeehiveTreeDecorator BEES_REGULAR = new BeehiveTreeDecorator(0.02f);
    private static final BeehiveTreeDecorator BEES_COMMON = new BeehiveTreeDecorator(0.05f);
    // all our features
    public static final RegistryEntry<ConfiguredFeature<?, ?>> DEAD_OAK_LOG = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "dead_oak_log"), Feature.TREE, deadLogBuilder(Blocks.OAK_WOOD).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());
    public static final RegistryEntry<ConfiguredFeature<?, ?>> DEAD_BIRCH_LOG = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "dead_birch_log"), Feature.TREE, deadLogBuilder(Blocks.BIRCH_WOOD).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());

    public static final RegistryEntry<ConfiguredFeature<?, ?>> OAK_STUMP = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "oak_stump"), Feature.TREE, stumpBuilder(Blocks.OAK_WOOD).build());
    public static final RegistryEntry<ConfiguredFeature<?, ?>> BIRCH_STUMP = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "birch_stump"), Feature.TREE, stumpBuilder(Blocks.BIRCH_WOOD).build());

    public static final RegistryEntry<ConfiguredFeature<?, ?>> UNDERGROWTH_BUSH = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "undergrowth_bush"), Feature.TREE, bushBuilder().build());

    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_BETTER_OAK = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_better_oak"), Feature.TREE, oakBuilder(false).build());

    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_DEAD_OAK = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_dead_oak"), Feature.TREE, oakBuilder(true).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());

    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_BETTER_SWAMP_OAK = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_better_swamp_oak"), Feature.TREE, oakBuilder(false).decorators(ImmutableList.of(LeavesVineTreeDecorator.INSTANCE)).build());

    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_BETTER_OAK_RARE_BEES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_better_oak_rare_bees"), Feature.TREE, oakBuilder(false).decorators(ImmutableList.of(BEES_RARE)).build());
    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_BETTER_OAK_REGULAR_BEES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_better_oak_regular_bees"), Feature.TREE, oakBuilder(false).decorators(ImmutableList.of(BEES_REGULAR)).build());
    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_BETTER_OAK_MORE_BEES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_better_oak_more_bees"), Feature.TREE, oakBuilder(false).decorators(ImmutableList.of(BEES_COMMON)).build());

    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_BETTER_BIRCH = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_better_birch"), Feature.TREE, birchBuilder(false, false).build());

    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_DEAD_BIRCH = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_dead_birch"), Feature.TREE, birchBuilder(false, true).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());
    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_TALL_DEAD_BIRCH = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_tall_dead_birch"), Feature.TREE, birchBuilder(true, true).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());

    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_BETTER_BIRCH_RARE_BEES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_better_birch_rare_bees"), Feature.TREE, birchBuilder(false, false).decorators(ImmutableList.of(BEES_RARE)).build());
    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_TALL_BETTER_BIRCH_RARE_BEES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_tall_better_birch_rare_bees"), Feature.TREE, birchBuilder(true, false).decorators(ImmutableList.of(BEES_RARE)).build());
    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_BETTER_BIRCH_REGULAR_BEES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_better_birch_regular_bees"), Feature.TREE, birchBuilder(false, false).decorators(ImmutableList.of(BEES_REGULAR)).build());
    public static final RegistryEntry<ConfiguredFeature<?, ?>> TREE_BETTER_BIRCH_MORE_BEES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "tree_better_birch_more_bees"), Feature.TREE, birchBuilder(false, false).decorators(ImmutableList.of(BEES_COMMON)).build());

    public static RegistryEntry<ConfiguredFeature<?, ?>> BETTER_FOREST_TREES;
    public static RegistryEntry<ConfiguredFeature<?, ?>> BETTER_BIRCH_FOREST_TREES;
    public static RegistryEntry<ConfiguredFeature<?, ?>> BETTER_TALL_BIRCH_FOREST_TREES;
    public static RegistryEntry<ConfiguredFeature<?, ?>> BETTER_DARK_FOREST_VEGETATION_BROWN;
    public static RegistryEntry<ConfiguredFeature<?, ?>> BETTER_BAMBOO_JUNGLE_VEGETATION;
    public static RegistryEntry<ConfiguredFeature<?, ?>> BETTER_JUNGLE_TREES;
    public static RegistryEntry<ConfiguredFeature<?, ?>> BETTER_SPARSE_JUNGLE_TREES;
    public static RegistryEntry<ConfiguredFeature<?, ?>> BETTER_SAVANNAH_TREES;
    public static RegistryEntry<ConfiguredFeature<?, ?>> BETTER_MOUNTAIN_TREES;

    protected static void registerBiomeTreeFeatures() {
        BETTER_FOREST_TREES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "better_forest_trees"), Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(
                        List.of(
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_BETTER_BIRCH_RARE_BEES, 0.1f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.DEAD_OAK_LOG, 0.25f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.DEAD_BIRCH_LOG, 0.1f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_DEAD_OAK, 0.024f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_DEAD_BIRCH, 0.006f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.UNDERGROWTH_BUSH, 0.2f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.OAK_STUMP, 0.032f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.BIRCH_STUMP, 0.008f)
                        ),
                        BetterTreesPlacedFeatures.TREE_BETTER_OAK_RARE_BEES
                )
        );

        BETTER_BIRCH_FOREST_TREES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "better_birch_forest_trees"), Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(
                        List.of(
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.DEAD_BIRCH_LOG, 0.22f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_DEAD_BIRCH, 0.03f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.UNDERGROWTH_BUSH, 0.1f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.BIRCH_STUMP, 0.04f)
                        ),
                        BetterTreesPlacedFeatures.TREE_BETTER_BIRCH_RARE_BEES
                )
        );

        BETTER_TALL_BIRCH_FOREST_TREES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "better_tall_birch_forest_trees"), Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(
                        List.of(
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.DEAD_BIRCH_LOG, 0.22f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_TALL_DEAD_BIRCH, 0.03f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.UNDERGROWTH_BUSH, 0.1f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.BIRCH_STUMP, 0.04f)
                        ),
                        BetterTreesPlacedFeatures.TREE_TALL_BETTER_BIRCH_RARE_BEES
                )
        );

        BETTER_DARK_FOREST_VEGETATION_BROWN = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "better_dark_forest_vegetation"), Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(
                        List.of(
                                new RandomFeatureEntry(PlacedFeatures.createEntry(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM), 0.025f),
                                new RandomFeatureEntry(PlacedFeatures.createEntry(TreeConfiguredFeatures.HUGE_RED_MUSHROOM), 0.05f),
                                new RandomFeatureEntry(TreePlacedFeatures.DARK_OAK_CHECKED, 2f / 3f),
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_BETTER_BIRCH, 0.2f)),
                        BetterTreesPlacedFeatures.TREE_BETTER_OAK
                )
        );

        BETTER_BAMBOO_JUNGLE_VEGETATION = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "better_bamboo_jungle_vegetation"), Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(
                        List.of(
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_BETTER_OAK, 0.05f),
                                new RandomFeatureEntry(TreePlacedFeatures.JUNGLE_BUSH, 0.15f),
                                new RandomFeatureEntry(TreePlacedFeatures.MEGA_JUNGLE_TREE_CHECKED, 0.7f)
                        ),
                        PlacedFeatures.createEntry(VegetationConfiguredFeatures.PATCH_GRASS_JUNGLE)
                )
        );

        BETTER_JUNGLE_TREES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "better_jungle_trees"), Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(
                        List.of(
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_BETTER_OAK, 0.1f),
                                new RandomFeatureEntry(TreePlacedFeatures.JUNGLE_BUSH, 0.5f),
                                new RandomFeatureEntry(TreePlacedFeatures.MEGA_JUNGLE_TREE_CHECKED, 1f / 3f)
                        ),
                        TreePlacedFeatures.JUNGLE_TREE
                )
        );

        BETTER_SPARSE_JUNGLE_TREES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "better_sparse_jungle_trees"), Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(
                        List.of(
                                new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_BETTER_OAK, 0.1f),
                                new RandomFeatureEntry(TreePlacedFeatures.JUNGLE_BUSH, 0.5f)
                        ),
                        TreePlacedFeatures.JUNGLE_TREE
                )
        );

        BETTER_SAVANNAH_TREES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "better_savannah_trees"), Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(
                        List.of(
                                new RandomFeatureEntry(TreePlacedFeatures.ACACIA_CHECKED, 0.8f)
                        ),
                        BetterTreesPlacedFeatures.TREE_BETTER_OAK
                )
        );

        BETTER_MOUNTAIN_TREES = RegistryUtil.registerConfiguredFeature(new Identifier("spaghettitrees", "better_mountain_trees"), Feature.RANDOM_SELECTOR,
                new RandomFeatureConfig(
                        List.of(
                                new RandomFeatureEntry(TreePlacedFeatures.SPRUCE_CHECKED, 2f / 3f)
                        ),
                        BetterTreesPlacedFeatures.TREE_BETTER_OAK
                )
        );
    }

    private static TreeFeatureConfig.Builder oakBuilder(boolean dead) {
        return new TreeFeatureConfig.Builder(
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.OAK_WOOD.getDefaultState()),
                new BetterTrunkPlacer(6, 6, 0, 0.85D, 1.25D, 0, 5, 0D, 1D, 0.3D, 0.95D),
                SimpleBlockStateProviderInvoker.invokeCtor((dead ? Blocks.AIR : Blocks.OAK_LEAVES).getDefaultState()),
                new LargeOakFoliagePlacer(BiasedToBottomIntProvider.create(1, 2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(5, 0, 10)
        );
    }

    private static TreeFeatureConfig.Builder birchBuilder(boolean tall, boolean dead) {
        return new TreeFeatureConfig.Builder(
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.BIRCH_WOOD.getDefaultState()),
                new BetterTrunkPlacer(tall ? 10 : 5, tall ? 10 : 3, 0, 0.75D, 2D, 2, 5, 0D, 1D, 0.45D, 1D),
                SimpleBlockStateProviderInvoker.invokeCtor((dead ? Blocks.AIR : Blocks.BIRCH_LEAVES).getDefaultState()),
                new LargeOakFoliagePlacer(BiasedToBottomIntProvider.create(1, 2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(5, 0, 10)
        );
    }

    private static TreeFeatureConfig.Builder deadLogBuilder(Block block) {
        return new TreeFeatureConfig.Builder(
                SimpleBlockStateProviderInvoker.invokeCtor(block.getDefaultState()),
                new DeadLogTrunkPlacer(4, 6, 0),
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.AIR.getDefaultState()),
                new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(1, 10, 10)
        );
    }

    private static TreeFeatureConfig.Builder stumpBuilder(Block block) {
        return new TreeFeatureConfig.Builder(
                SimpleBlockStateProviderInvoker.invokeCtor(block.getDefaultState()),
                new BetterTrunkPlacer(1, 2, 0),
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.AIR.getDefaultState()),
                new BlobFoliagePlacer(ConstantIntProvider.create(0), ConstantIntProvider.create(0), 0),
                new TwoLayersFeatureSize(1, 2, 1)
        );
    }

    private static TreeFeatureConfig.Builder bushBuilder() {
        return new TreeFeatureConfig.Builder(
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.OAK_WOOD.getDefaultState()),
                new StraightTrunkPlacer(1, 1, 0),
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.OAK_LEAVES.getDefaultState()),
                new BushFoliagePlacer(BiasedToBottomIntProvider.create(1, 2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 2, 2)
        );
    }
    static { System.out.println("Hi from BetterTreesConfiguredFeatures clinit end"); }
}
