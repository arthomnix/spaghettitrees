package dev.arthomnix.spaghettitrees.tree;

import com.google.common.collect.ImmutableList;
import dev.arthomnix.spaghettitrees.mixin.TrunkPlacerTypeInvoker;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.BiasedToBottomIntProvider;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.Heightmap;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.LargeOakFoliagePlacer;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.treedecorator.BeehiveTreeDecorator;
import net.minecraft.world.gen.treedecorator.LeavesVineTreeDecorator;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

public class BetterTrees {
    public static final ConfiguredDecorator<HeightmapDecoratorConfig> HEIGHTMAP_OCEAN_FLOOR = Decorator.HEIGHTMAP.configure(new HeightmapDecoratorConfig(Heightmap.Type.OCEAN_FLOOR));
    public static final ConfiguredDecorator<?> HEIGHTMAP_OCEAN_FLOOR_NO_WATER = HEIGHTMAP_OCEAN_FLOOR.decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(new WaterDepthThresholdDecoratorConfig(0)));
    public static final ConfiguredDecorator<?> SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER = HEIGHTMAP_OCEAN_FLOOR_NO_WATER.spreadHorizontally();


    public static final TrunkPlacerType<BetterTrunkPlacer> BETTER_TRUNK_PLACER = TrunkPlacerTypeInvoker.callRegister("better_trunk_placer", BetterTrunkPlacer.CODEC);

    // all our features
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.OAK_LOG.getDefaultState()),
                    new BetterTrunkPlacer(6, 6, 0, 0.85D, 1.25D, 0, 5, 0D, 1D, 0.3D, 0.95D),
                    new SimpleBlockStateProvider(Blocks.OAK_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(Blocks.OAK_SAPLING.getDefaultState()),
                    new LargeOakFoliagePlacer(BiasedToBottomIntProvider.create(1, 2), ConstantIntProvider.create(0), 2),
                    new TwoLayersFeatureSize(5, 0, 10)
            ).build());

    static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_SWAMP_OAK = Feature.TREE.configure(TREE_BETTER_OAK.getConfig().setTreeDecorators(ImmutableList.of(LeavesVineTreeDecorator.INSTANCE)));

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK_RARE_BEES = Feature.TREE.configure(TREE_BETTER_OAK.getConfig().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002f))));
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK_REGULAR_BEES = Feature.TREE.configure(TREE_BETTER_OAK.getConfig().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.02f))));
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_OAK_MORE_BEES = Feature.TREE.configure(TREE_BETTER_OAK.getConfig().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.05f))));

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH = Feature.TREE
            .configure(new TreeFeatureConfig.Builder(
                    new SimpleBlockStateProvider(Blocks.BIRCH_LOG.getDefaultState()),
                    new BetterTrunkPlacer(5, 3, 0, 0.75D, 2D, 2, 5, 0D, 1D, 0.45D, 1D),
                    new SimpleBlockStateProvider(Blocks.BIRCH_LEAVES.getDefaultState()),
                    new SimpleBlockStateProvider(Blocks.BIRCH_SAPLING.getDefaultState()),
                    new LargeOakFoliagePlacer(BiasedToBottomIntProvider.create(1, 2), ConstantIntProvider.create(0), 2),
                    new TwoLayersFeatureSize(5, 0, 10)
            ).build());

    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH_RARE_BEES = Feature.TREE.configure(TREE_BETTER_BIRCH.getConfig().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.002f))));
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH_REGULAR_BEES = Feature.TREE.configure(TREE_BETTER_BIRCH.getConfig().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.02f))));
    public static final ConfiguredFeature<TreeFeatureConfig, ?> TREE_BETTER_BIRCH_MORE_BEES = Feature.TREE.configure(TREE_BETTER_BIRCH.getConfig().setTreeDecorators(ImmutableList.of(new BeehiveTreeDecorator(0.05f))));

    public static final ConfiguredFeature<?, ?> BETTER_FOREST_TREES = Feature.RANDOM_SELECTOR.configure(
                    new RandomFeatureConfig(
                            ImmutableList.of(
                                    TREE_BETTER_BIRCH_RARE_BEES.withChance(0.2f)),
                            TREE_BETTER_OAK_RARE_BEES)
            ).decorate(SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(4, 0.1f, 1)));

    public static final ConfiguredFeature<?, ?> BETTER_FLOWER_FOREST_TREES = Feature.RANDOM_SELECTOR.configure(
                    new RandomFeatureConfig(
                            ImmutableList.of(
                                    TREE_BETTER_BIRCH_REGULAR_BEES.withChance(0.2f)),
                            TREE_BETTER_OAK_REGULAR_BEES)
            ).decorate(SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(new CountExtraDecoratorConfig(2, 0.1f, 2)));

    public static final ConfiguredFeature<?, ?> BETTER_PLAINS_TREES = TREE_BETTER_OAK_MORE_BEES.decorate(SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.05f, 1)
    ));

    public static final ConfiguredFeature<?, ?> BETTER_BIRCH_TREES = TREE_BETTER_BIRCH_RARE_BEES.decorate(SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(4, 0.1f, 1)
    ));

    public static final ConfiguredFeature<?, ?> BETTER_DARK_FOREST_VEGETATION_BROWN = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            ConfiguredFeatures.HUGE_BROWN_MUSHROOM.withChance(0.025f),
                            ConfiguredFeatures.HUGE_RED_MUSHROOM.withChance(0.05f),
                            ConfiguredFeatures.DARK_OAK.withChance(2f/3f),
                            TREE_BETTER_BIRCH.withChance(0.2f)),
                    TREE_BETTER_OAK
            )
    ).decorate(HEIGHTMAP_OCEAN_FLOOR_NO_WATER.decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT)));

    public static final ConfiguredFeature<?, ?> BETTER_DARK_FOREST_VEGETATION_RED = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            ConfiguredFeatures.HUGE_RED_MUSHROOM.withChance(0.025f),
                            ConfiguredFeatures.HUGE_BROWN_MUSHROOM.withChance(0.05f),
                            ConfiguredFeatures.DARK_OAK.withChance(2f/3f),
                            TREE_BETTER_BIRCH.withChance(0.2f)),
                    TREE_BETTER_OAK
            )
    ).decorate(HEIGHTMAP_OCEAN_FLOOR_NO_WATER.decorate(Decorator.DARK_OAK_TREE.configure(DecoratorConfig.DEFAULT)));

    public static final ConfiguredFeature<?, ?> BETTER_BAMBOO_JUNGLE_VEGETATION = Feature.RANDOM_SELECTOR.configure(
                    new RandomFeatureConfig(
                            ImmutableList.of(
                                    TREE_BETTER_OAK.withChance(0.05f),
                                    ConfiguredFeatures.JUNGLE_BUSH.withChance(0.15f),
                                    ConfiguredFeatures.MEGA_JUNGLE_TREE.withChance(0.7f)
                            ),
                            Feature.RANDOM_PATCH.configure(
                                    ConfiguredFeatures.Configs.LUSH_GRASS_CONFIG
                            )
                    )
            ).decorate(SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(
                    new CountExtraDecoratorConfig(30, 0.1f, 1)
            ));

    public static final ConfiguredFeature<?, ?> BETTER_JUNGLE_TREES = Feature.RANDOM_SELECTOR.configure(
                    new RandomFeatureConfig(
                            ImmutableList.of(
                                    TREE_BETTER_OAK.withChance(0.1f),
                                    ConfiguredFeatures.JUNGLE_BUSH.withChance(0.5f),
                                    ConfiguredFeatures.MEGA_JUNGLE_TREE.withChance(1f/3f)
                            ),
                            ConfiguredFeatures.JUNGLE_TREE
                    )
            ).decorate(SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(
                    new CountExtraDecoratorConfig(50, 0.1f, 1)
            ));

    public static final ConfiguredFeature<?, ?> BETTER_JUNGLE_EDGE_TREES = Feature.RANDOM_SELECTOR.configure(
                    new RandomFeatureConfig(
                            ImmutableList.of(
                                    TREE_BETTER_OAK.withChance(0.1f),
                                    ConfiguredFeatures.JUNGLE_BUSH.withChance(0.5f)
                            ),
                            ConfiguredFeatures.JUNGLE_TREE
                    )
            ).decorate(SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER)
            .decorate(Decorator.COUNT_EXTRA.configure(
                    new CountExtraDecoratorConfig(2, 0.1f, 1)
            ));

    public static final ConfiguredFeature<?, ?> BETTER_WATER_TREES = TREE_BETTER_OAK.decorate(SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.1f, 1)
    ));

    public static final ConfiguredFeature<?, ?> BETTER_SAVANNAH_TREES_BASE = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            ConfiguredFeatures.ACACIA.withChance(0.8f)
                    ),
                    TREE_BETTER_OAK
            )
    ).decorate(SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER);

    public static final ConfiguredFeature<?, ?> BETTER_SAVANNAH_TREES = BETTER_SAVANNAH_TREES_BASE.decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(1, 0.1f, 1)
    ));

    public static final ConfiguredFeature<?, ?> BETTER_SHATTERED_SAVANNAH_TREES = BETTER_SAVANNAH_TREES_BASE.decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(2, 0.1f, 1)
    ));

    public static final ConfiguredFeature<?, ?> BETTER_SWAMP_TREES = TREE_BETTER_SWAMP_OAK.decorate(HEIGHTMAP_OCEAN_FLOOR)
            .decorate(Decorator.WATER_DEPTH_THRESHOLD.configure(
                    new WaterDepthThresholdDecoratorConfig(1)
            )).spreadHorizontally()
            .decorate(Decorator.COUNT_EXTRA.configure(
                    new CountExtraDecoratorConfig(2, 0.1f, 1)
            ));

    public static final ConfiguredFeature<?, ?> BETTER_BADLANDS_TREES = TREE_BETTER_OAK.decorate(HEIGHTMAP_OCEAN_FLOOR_NO_WATER).decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(5, 0.1f, 1)
    ));

    public static final ConfiguredFeature<?, ?> BETTER_MOUNTAIN_TREES_BASE = Feature.RANDOM_SELECTOR.configure(
            new RandomFeatureConfig(
                    ImmutableList.of(
                            ConfiguredFeatures.SPRUCE.withChance(2f/3f)
                    ),
                    TREE_BETTER_OAK
            )
    ).decorate(SQUARE_HEIGHTMAP_OCEAN_FLOOR_NO_WATER);

    public static final ConfiguredFeature<?, ?> BETTER_MOUNTAIN_EDGE_TREES = BETTER_MOUNTAIN_TREES_BASE.decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(3, 0.1f, 1)
    ));

    public static final ConfiguredFeature<?, ?> BETTER_MOUNTAIN_TREES = BETTER_MOUNTAIN_TREES_BASE.decorate(Decorator.COUNT_EXTRA.configure(
            new CountExtraDecoratorConfig(0, 0.1f, 1)
    ));

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
        RegistryKey<ConfiguredFeature<?, ?>> betterFlowerForestTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_flower_forest_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterBirchTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_forest_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterPlainsTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_plains_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterDarkForestVegetationBrown = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_dark_forest_vegetation_brown"));
        RegistryKey<ConfiguredFeature<?, ?>> betterDarkForestVegetationRed = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_dark_forest_vegetation_red"));
        RegistryKey<ConfiguredFeature<?, ?>> betterBambooJungleVegetation = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_bamboo_jungle_vegetation"));
        RegistryKey<ConfiguredFeature<?, ?>> betterWaterTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_water_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterJungleTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_jungle_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterJungleEdgeTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_jungle_edge_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterSavannahTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_savannah_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterShatteredSavannahTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_shattered_savannah_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterSwampTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_swamp_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterBadlandsTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_badlands_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterMountainTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_mountain_trees"));
        RegistryKey<ConfiguredFeature<?, ?>> betterMountainEdgeTrees = RegistryKey.of(Registry.CONFIGURED_FEATURE_KEY, new Identifier("spaghettitrees", "better_mountain_edge_trees"));

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
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterFlowerForestTrees.getValue(), BETTER_FLOWER_FOREST_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterBirchTrees.getValue(), BETTER_BIRCH_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterPlainsTrees.getValue(), BETTER_PLAINS_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterDarkForestVegetationBrown.getValue(), BETTER_DARK_FOREST_VEGETATION_BROWN);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterDarkForestVegetationRed.getValue(), BETTER_DARK_FOREST_VEGETATION_RED);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterBambooJungleVegetation.getValue(), BETTER_BAMBOO_JUNGLE_VEGETATION);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterWaterTrees.getValue(), BETTER_WATER_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterJungleTrees.getValue(), BETTER_JUNGLE_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterJungleEdgeTrees.getValue(), BETTER_JUNGLE_EDGE_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterSavannahTrees.getValue(), BETTER_SAVANNAH_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterShatteredSavannahTrees.getValue(), BETTER_SHATTERED_SAVANNAH_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterSwampTrees.getValue(), BETTER_SWAMP_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterBadlandsTrees.getValue(), BETTER_BADLANDS_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterMountainTrees.getValue(), BETTER_MOUNTAIN_TREES);
        Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, betterMountainEdgeTrees.getValue(), BETTER_MOUNTAIN_EDGE_TREES);
    }
}
