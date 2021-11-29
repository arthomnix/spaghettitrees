package dev.arthomnix.spaghettitrees.tree;

import com.google.common.collect.ImmutableList;
import dev.arthomnix.spaghettitrees.mixin.SimpleBlockStateProviderInvoker;
import dev.arthomnix.spaghettitrees.mixin.TrunkPlacerTypeInvoker;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
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
    public static final TrunkPlacerType<BetterTrunkPlacer> BETTER_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("better_trunk_placer", BetterTrunkPlacer.CODEC);
    public static final TrunkPlacerType<DeadLogTrunkPlacer> DEAD_LOG_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("dead_log_trunk_placer", DeadLogTrunkPlacer.CODEC);

    private static final BeehiveTreeDecorator BEES_RARE = new BeehiveTreeDecorator(0.002f);
    private static final BeehiveTreeDecorator BEES_REGULAR = new BeehiveTreeDecorator(0.02f);
    private static final BeehiveTreeDecorator BEES_COMMON = new BeehiveTreeDecorator(0.05f);
    // all our features
    public static final ConfiguredFeature<TreeFeatureConfig, ?> DEAD_OAK_LOG = Feature.TREE.configure(deadLogBuilder(Blocks.OAK_LOG).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());
    public static final ConfiguredFeature<TreeFeatureConfig, ?> DEAD_BIRCH_LOG = Feature.TREE.configure(deadLogBuilder(Blocks.BIRCH_LOG).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> OAK_STUMP = Feature.TREE.configure(stumpBuilder(Blocks.OAK_LOG).build());
    public static final ConfiguredFeature<TreeFeatureConfig, ?> BIRCH_STUMP = Feature.TREE.configure(stumpBuilder(Blocks.BIRCH_LOG).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> UNDERGROWTH_BUSH = Feature.TREE.configure(bushBuilder().build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK = Feature.TREE.configure(oakBuilder(false).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_DEAD_OAK = Feature.TREE.configure(oakBuilder(true).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_SWAMP_OAK = Feature.TREE.configure(oakBuilder(false).decorators(ImmutableList.of(LeavesVineTreeDecorator.INSTANCE)).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK_RARE_BEES = Feature.TREE.configure(oakBuilder(false).decorators(ImmutableList.of(BEES_RARE)).build());
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK_REGULAR_BEES = Feature.TREE.configure(oakBuilder(false).decorators(ImmutableList.of(BEES_REGULAR)).build());
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK_MORE_BEES = Feature.TREE.configure(oakBuilder(false).decorators(ImmutableList.of(BEES_COMMON)).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH = Feature.TREE.configure(birchBuilder(false).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_DEAD_BIRCH = Feature.TREE.configure(birchBuilder(true).decorators(ImmutableList.of(TrunkVineTreeDecorator.INSTANCE)).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH_RARE_BEES = Feature.TREE.configure(birchBuilder(false).decorators(ImmutableList.of(BEES_RARE)).build());
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH_REGULAR_BEES = Feature.TREE.configure(birchBuilder(false).decorators(ImmutableList.of(BEES_REGULAR)).build());
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH_MORE_BEES = Feature.TREE.configure(birchBuilder(false).decorators(ImmutableList.of(BEES_COMMON)).build());

    public static final ConfiguredFeature<RandomFeatureConfig, ?> BETTER_FOREST_TREES = Feature.RANDOM_SELECTOR.configure(
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

    public static final ConfiguredFeature<RandomFeatureConfig, ?> BETTER_BIRCH_FOREST_TREES = Feature.RANDOM_SELECTOR.configure(
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
    public static final ConfiguredFeature<RandomFeatureConfig, ?> BETTER_DARK_FOREST_VEGETATION_BROWN = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    List.of(
                            new RandomFeatureEntry(TreeConfiguredFeatures.HUGE_BROWN_MUSHROOM.withPlacement(), 0.025f),
                            new RandomFeatureEntry(TreeConfiguredFeatures.HUGE_RED_MUSHROOM.withPlacement(), 0.05f),
                            new RandomFeatureEntry(TreePlacedFeatures.DARK_OAK_CHECKED, 2f/3f),
                            new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_BETTER_BIRCH, 0.2f)),
                    BetterTreesPlacedFeatures.TREE_BETTER_OAK
            )
    );

    public static final ConfiguredFeature<RandomFeatureConfig, ?> BETTER_BAMBOO_JUNGLE_VEGETATION = Feature.RANDOM_SELECTOR.configure(
                    new RandomFeatureConfig(
                            List.of(
                                    new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_BETTER_OAK, 0.05f),
                                    new RandomFeatureEntry(TreePlacedFeatures.JUNGLE_BUSH, 0.15f),
                                    new RandomFeatureEntry(TreePlacedFeatures.MEGA_JUNGLE_TREE_CHECKED, 0.7f)
                            ),
                            VegetationConfiguredFeatures.PATCH_GRASS_JUNGLE.withPlacement()
                    )
            );

    public static final ConfiguredFeature<RandomFeatureConfig, ?> BETTER_JUNGLE_TREES = Feature.RANDOM_SELECTOR.configure(
                    new RandomFeatureConfig(
                            List.of(
                                    new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_BETTER_OAK, 0.1f),
                                    new RandomFeatureEntry(TreePlacedFeatures.JUNGLE_BUSH, 0.5f),
                                    new RandomFeatureEntry(TreePlacedFeatures.MEGA_JUNGLE_TREE_CHECKED, 1f/3f)
                            ),
                            TreePlacedFeatures.JUNGLE_TREE
                    )
    );

    public static final ConfiguredFeature<RandomFeatureConfig, ?> BETTER_SPARSE_JUNGLE_TREES = Feature.RANDOM_SELECTOR.configure(
                    new RandomFeatureConfig(
                            List.of(
                                    new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_BETTER_OAK, 0.1f),
                                    new RandomFeatureEntry(TreePlacedFeatures.JUNGLE_BUSH, 0.5f)
                            ),
                            TreePlacedFeatures.JUNGLE_TREE
                    )
            );

    public static final ConfiguredFeature<RandomFeatureConfig, ?> BETTER_SAVANNAH_TREES = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    List.of(
                            new RandomFeatureEntry(TreePlacedFeatures.ACACIA_CHECKED, 0.8f)
                    ),
                    BetterTreesPlacedFeatures.TREE_BETTER_OAK
            )
    );

    public static final ConfiguredFeature<RandomFeatureConfig, ?> BETTER_MOUNTAIN_TREES = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    List.of(
                            new RandomFeatureEntry(TreePlacedFeatures.SPRUCE_CHECKED, 2f/3f)
                    ),
                    BetterTreesPlacedFeatures.TREE_BETTER_OAK
            )
    );

    // Register all trees
    public static void registerAll() {
        RegistryKey<ConfiguredFeature<?, ?>> deadOakLog = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "dead_oak_log"));
        RegistryKey<ConfiguredFeature<?, ?>> deadBirchLog = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "dead_birch_log"));
        RegistryKey<ConfiguredFeature<?, ?>> oakStump = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "oak_stump"));
        RegistryKey<ConfiguredFeature<?, ?>> birchStump = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "birch_stump"));
        RegistryKey<ConfiguredFeature<?, ?>> undergrowthBush = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "undergrowth_bush"));

        RegistryKey<ConfiguredFeature<?, ?>> treeBetterOak = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak"));
        RegistryKey<ConfiguredFeature<?, ?>> treeDeadOak = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "dead_oak"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterSwampOak = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_swamp_oak"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterOakRareBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak_rare_bees"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterOakRegularBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak_regular_bees"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterOakMoreBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak_more_bees"));

        RegistryKey<ConfiguredFeature<?, ?>> treeBetterBirch = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch"));
        RegistryKey<ConfiguredFeature<?, ?>> treeDeadBirch = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "dead_birch"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterBirchRareBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_rare_bees"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterBirchRegularBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_regular_bees"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterBirchMoreBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_more_bees"));

        RegistryKey<ConfiguredFeature<?, ?>> betterForestTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_forest_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterBirchForestTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_forest_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterDarkForestVegetationBrown = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_dark_forest_vegetation_brown"));
        RegistryKey<ConfiguredFeature<?, ?>> betterBambooJungleVegetation = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_bamboo_jungle_vegetation"));
        RegistryKey<ConfiguredFeature<?, ?>> betterJungleTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_jungle_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterSparseJungleTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_sparse_jungle_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterSavannahTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_savannah_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterMountainTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_mountain_trees"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, deadOakLog.getValue(), DEAD_OAK_LOG);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, deadBirchLog.getValue(), DEAD_BIRCH_LOG);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, undergrowthBush.getValue(), UNDERGROWTH_BUSH);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, oakStump.getValue(), OAK_STUMP);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, birchStump.getValue(), BIRCH_STUMP);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterOak.getValue(), TREE_BETTER_OAK);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeDeadOak.getValue(), TREE_DEAD_OAK);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterSwampOak.getValue(), TREE_BETTER_SWAMP_OAK);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterOakRareBees.getValue(), TREE_BETTER_OAK_RARE_BEES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterOakRegularBees.getValue(), TREE_BETTER_OAK_REGULAR_BEES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterOakMoreBees.getValue(), TREE_BETTER_OAK_MORE_BEES);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterBirch.getValue(), TREE_BETTER_BIRCH);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeDeadBirch.getValue(), TREE_DEAD_BIRCH);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterBirchRareBees.getValue(), TREE_BETTER_BIRCH_RARE_BEES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterBirchRegularBees.getValue(), TREE_BETTER_BIRCH_REGULAR_BEES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterBirchMoreBees.getValue(), TREE_BETTER_BIRCH_MORE_BEES);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterForestTrees.getValue(), BETTER_FOREST_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterBirchForestTrees.getValue(), BETTER_BIRCH_FOREST_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterDarkForestVegetationBrown.getValue(), BETTER_DARK_FOREST_VEGETATION_BROWN);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterBambooJungleVegetation.getValue(), BETTER_BAMBOO_JUNGLE_VEGETATION);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterJungleTrees.getValue(), BETTER_JUNGLE_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterSparseJungleTrees.getValue(), BETTER_SPARSE_JUNGLE_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterSavannahTrees.getValue(), BETTER_SAVANNAH_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterMountainTrees.getValue(), BETTER_MOUNTAIN_TREES);
    }

    private static TreeFeatureConfig.Builder oakBuilder(boolean dead) {
        return new TreeFeatureConfig.Builder(
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.OAK_LOG.getDefaultState()),
                new BetterTrunkPlacer(6, 6, 0, 0.85D, 1.25D, 0, 5, 0D, 1D, 0.3D, 0.95D),
                SimpleBlockStateProviderInvoker.invokeCtor((dead ? Blocks.AIR : Blocks.OAK_LEAVES).getDefaultState()),
                new LargeOakFoliagePlacer(BiasedToBottomIntProvider.create(1, 2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(5, 0, 10)
        );
    }

    private static TreeFeatureConfig.Builder birchBuilder(boolean dead) {
        return new TreeFeatureConfig.Builder(
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.BIRCH_LOG.getDefaultState()),
                new BetterTrunkPlacer(5, 3, 0, 0.75D, 2D, 2, 5, 0D, 1D, 0.45D, 1D),
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
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.OAK_LOG.getDefaultState()),
                new StraightTrunkPlacer(1, 1, 0),
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.OAK_LEAVES.getDefaultState()),
                new BushFoliagePlacer(BiasedToBottomIntProvider.create(1, 2), ConstantIntProvider.create(1), 2),
                new TwoLayersFeatureSize(1, 2, 2)
        );
    }
}
