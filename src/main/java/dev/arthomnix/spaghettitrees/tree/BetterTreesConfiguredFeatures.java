package dev.arthomnix.spaghettitrees.tree;

import com.google.common.collect.ImmutableList;
import dev.arthomnix.spaghettitrees.mixin.SimpleBlockStateProviderInvoker;
import dev.arthomnix.spaghettitrees.mixin.TrunkPlacerTypeInvoker;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;


public class BetterTreesConfiguredFeatures {
    public static final TrunkPlacerType<BetterTrunkPlacer> BETTER_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("better_trunk_placer", BetterTrunkPlacer.CODEC);

    private static final BeehiveTreeDecorator BEES_RARE = new BeehiveTreeDecorator(0.002f);
    private static final BeehiveTreeDecorator BEES_REGULAR = new BeehiveTreeDecorator(0.02f);
    private static final BeehiveTreeDecorator BEES_COMMON = new BeehiveTreeDecorator(0.05f);
    // all our features
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK = Feature.TREE.configure(oakBuilder().build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_SWAMP_OAK = Feature.TREE.configure(oakBuilder().decorators(ImmutableList.of(LeavesVineTreeDecorator.INSTANCE)).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK_RARE_BEES = Feature.TREE.configure(oakBuilder().decorators(ImmutableList.of(BEES_RARE)).build());
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK_REGULAR_BEES = Feature.TREE.configure(oakBuilder().decorators(ImmutableList.of(BEES_REGULAR)).build());
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK_MORE_BEES = Feature.TREE.configure(oakBuilder().decorators(ImmutableList.of(BEES_COMMON)).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH = Feature.TREE.configure(birchBuilder().build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH_RARE_BEES = Feature.TREE.configure(birchBuilder().decorators(ImmutableList.of(BEES_RARE)).build());
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH_REGULAR_BEES = Feature.TREE.configure(birchBuilder().decorators(ImmutableList.of(BEES_REGULAR)).build());
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH_MORE_BEES = Feature.TREE.configure(birchBuilder().decorators(ImmutableList.of(BEES_COMMON)).build());

    public static final ConfiguredFeature<RandomFeatureConfig, ?> BETTER_FOREST_TREES = Feature.RANDOM_SELECTOR.configure(
                    new RandomFeatureConfig(
                            List.of(
                                    new RandomFeatureEntry(BetterTreesPlacedFeatures.TREE_BETTER_BIRCH_RARE_BEES, 0.2f)),
                            BetterTreesPlacedFeatures.TREE_BETTER_OAK_RARE_BEES)
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
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterOak = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterSwampOak = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_swamp_oak"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterOakRareBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak_rare_bees"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterOakRegularBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak_regular_bees"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterOakMoreBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak_more_bees"));

        RegistryKey<ConfiguredFeature<?, ?>> treeBetterBirch = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterBirchRareBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_rare_bees"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterBirchRegularBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_regular_bees"));
        RegistryKey<ConfiguredFeature<?, ?>> treeBetterBirchMoreBees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_more_bees"));

        RegistryKey<ConfiguredFeature<?, ?>> betterForestTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_forest_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterDarkForestVegetationBrown = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_dark_forest_vegetation_brown"));
        RegistryKey<ConfiguredFeature<?, ?>> betterBambooJungleVegetation = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_bamboo_jungle_vegetation"));
        RegistryKey<ConfiguredFeature<?, ?>> betterJungleTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_jungle_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterSparseJungleTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_sparse_jungle_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterSavannahTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_savannah_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterMountainTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_mountain_trees"));

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterOak.getValue(), TREE_BETTER_OAK);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterSwampOak.getValue(), TREE_BETTER_SWAMP_OAK);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterOakRareBees.getValue(), TREE_BETTER_OAK_RARE_BEES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterOakRegularBees.getValue(), TREE_BETTER_OAK_REGULAR_BEES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterOakMoreBees.getValue(), TREE_BETTER_OAK_MORE_BEES);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterBirch.getValue(), TREE_BETTER_BIRCH);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterBirchRareBees.getValue(), TREE_BETTER_BIRCH_RARE_BEES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterBirchRegularBees.getValue(), TREE_BETTER_BIRCH_REGULAR_BEES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, treeBetterBirchMoreBees.getValue(), TREE_BETTER_BIRCH_MORE_BEES);

        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterForestTrees.getValue(), BETTER_FOREST_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterDarkForestVegetationBrown.getValue(), BETTER_DARK_FOREST_VEGETATION_BROWN);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterBambooJungleVegetation.getValue(), BETTER_BAMBOO_JUNGLE_VEGETATION);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterJungleTrees.getValue(), BETTER_JUNGLE_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterSparseJungleTrees.getValue(), BETTER_SPARSE_JUNGLE_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterSavannahTrees.getValue(), BETTER_SAVANNAH_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterMountainTrees.getValue(), BETTER_MOUNTAIN_TREES);
    }

    private static TreeFeatureConfig.Builder oakBuilder() {
        return new TreeFeatureConfig.Builder(
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.OAK_LOG.getDefaultState()),
                new BetterTrunkPlacer(6, 6, 0, 0.85D, 1.25D, 0, 5, 0D, 1D, 0.3D, 0.95D),
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.OAK_LEAVES.getDefaultState()),
                new LargeOakFoliagePlacer(BiasedToBottomIntProvider.create(1, 2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(5, 0, 10)
        );
    }

    private static TreeFeatureConfig.Builder birchBuilder() {
        return new TreeFeatureConfig.Builder(
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.BIRCH_LOG.getDefaultState()),
                new BetterTrunkPlacer(5, 3, 0, 0.75D, 2D, 2, 5, 0D, 1D, 0.45D, 1D),
                SimpleBlockStateProviderInvoker.invokeCtor(Blocks.BIRCH_LEAVES.getDefaultState()),
                new LargeOakFoliagePlacer(BiasedToBottomIntProvider.create(1, 2), ConstantIntProvider.create(0), 2),
                new TwoLayersFeatureSize(5, 0, 10)
        );
    }
}
