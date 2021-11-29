package dev.arthomnix.spaghettitrees.tree;

import com.google.common.collect.ImmutableList;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.decorator.*;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;

public class BetterTreesPlacedFeatures {
    // Tried to split generating a new PlacedFeature from a ConfiguredFeature out into a function.
    // Crashed on startup, so I'm just going to leave it like this for now.
    public static final PlacedFeature DEAD_OAK_LOG = new PlacedFeature(() -> BetterTreesConfiguredFeatures.DEAD_OAK_LOG, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature DEAD_BIRCH_LOG = new PlacedFeature(() -> BetterTreesConfiguredFeatures.DEAD_BIRCH_LOG, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature OAK_STUMP = new PlacedFeature(() -> BetterTreesConfiguredFeatures.OAK_STUMP, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature BIRCH_STUMP = new PlacedFeature(() -> BetterTreesConfiguredFeatures.BIRCH_STUMP, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature UNDERGROWTH_BUSH = new PlacedFeature(() -> BetterTreesConfiguredFeatures.UNDERGROWTH_BUSH, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_BETTER_OAK = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_BETTER_OAK, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_DEAD_OAK = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_DEAD_OAK, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_BETTER_OAK_RARE_BEES = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_BETTER_OAK_RARE_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_BETTER_OAK_REGULAR_BEES = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_BETTER_OAK_REGULAR_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_BETTER_OAK_MORE_BEES = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_BETTER_OAK_MORE_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_BETTER_SWAMP_OAK = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_BETTER_SWAMP_OAK, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_BETTER_BIRCH = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_DEAD_BIRCH = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_DEAD_BIRCH, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_BETTER_BIRCH_RARE_BEES = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH_RARE_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_BETTER_BIRCH_REGULAR_BEES = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH_REGULAR_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature TREE_BETTER_BIRCH_MORE_BEES = new PlacedFeature(() -> BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH_MORE_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    ));

    public static final PlacedFeature BETTER_FOREST_TREES = BetterTreesConfiguredFeatures.BETTER_FOREST_TREES.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(8, 0.1f, 1)
            )
    );

    public static final PlacedFeature BETTER_FLOWER_FOREST_TREES = BetterTreesConfiguredFeatures.BETTER_FOREST_TREES.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(3, 0.1f, 1)
            )
    );

    public static final PlacedFeature BETTER_BIRCH_FOREST_TREES = BetterTreesConfiguredFeatures.BETTER_BIRCH_FOREST_TREES.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(8, 0.1f, 1)
            )
    );

    public static final PlacedFeature BETTER_PLAINS_TREES = BetterTreesConfiguredFeatures.TREE_BETTER_OAK_REGULAR_BEES.withPlacement(
            PlacedFeatures.createCountExtraModifier(0, 0.05f, 1),
            SquarePlacementModifier.of(),
            SurfaceWaterDepthFilterPlacementModifier.of(0),
            PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
            BiomePlacementModifier.of()
    );

    public static final PlacedFeature BETTER_WATER_BIOME_TREES = BetterTreesConfiguredFeatures.TREE_BETTER_OAK.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)
            )
    );

    public static final PlacedFeature BETTER_DARK_FOREST_VEGETATION = BetterTreesConfiguredFeatures.BETTER_DARK_FOREST_VEGETATION_BROWN.withPlacement(
            CountPlacementModifier.of(16),
            SquarePlacementModifier.of(),
            SurfaceWaterDepthFilterPlacementModifier.of(0),
            PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)
            ),
            BiomePlacementModifier.of()
    );

    public static final PlacedFeature BETTER_BAMBOO_JUNGLE_VEGETATION = BetterTreesConfiguredFeatures.BETTER_BAMBOO_JUNGLE_VEGETATION.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(30, 0.1f, 1)
            )
    );

    public static final PlacedFeature BETTER_JUNGLE_TREES = BetterTreesConfiguredFeatures.BETTER_JUNGLE_TREES.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(50, 0.1f, 1)
            )
    );

    public static final PlacedFeature BETTER_SPARSE_JUNGLE_TREES = BetterTreesConfiguredFeatures.BETTER_SPARSE_JUNGLE_TREES.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(2, 0.1f, 1)
            )
    );

    public static final PlacedFeature BETTER_SAVANNAH_TREES = BetterTreesConfiguredFeatures.BETTER_SAVANNAH_TREES.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 1)
            )
    );

    public static final PlacedFeature BETTER_WINDSWEPT_SAVANNAH_TREES = BetterTreesConfiguredFeatures.BETTER_SAVANNAH_TREES.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(2, 0.1f, 1)
            )
    );

    public static final PlacedFeature BETTER_WINDSWEPT_HILLS_TREES = BetterTreesConfiguredFeatures.BETTER_MOUNTAIN_TREES.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.1f,1)
            )
    );

    public static final PlacedFeature BETTER_WINDSWEPT_FOREST_TREES = BetterTreesConfiguredFeatures.BETTER_MOUNTAIN_TREES.withPlacement(
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(2, 0.1f, 1)
            )
    );

    public static final PlacedFeature BETTER_SWAMP_TREES = BetterTreesConfiguredFeatures.TREE_BETTER_SWAMP_OAK.withPlacement(
            PlacedFeatures.createCountExtraModifier(2, 0.1f, 1),
            SquarePlacementModifier.of(),
            SurfaceWaterDepthFilterPlacementModifier.of(2),
            PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
            BiomePlacementModifier.of(),
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)
            )
    );

    public static final PlacedFeature BETTER_BADLANDS_TREES = BetterTreesConfiguredFeatures.TREE_BETTER_OAK.withPlacement(
            VegetationPlacedFeatures.modifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(5, 0.1f, 1),
                    Blocks.OAK_SAPLING
            )
    );

    public static void registerAll() {
        RegistryKey<PlacedFeature> deadOakLog = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "dead_oak_log"));
        RegistryKey<PlacedFeature> deadBirchLog = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "dead_birch_log"));
        RegistryKey<PlacedFeature> oakStump = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "oak_stump"));
        RegistryKey<PlacedFeature> birchStump = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "birch_stump"));
        RegistryKey<PlacedFeature> undergrowthBush = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "undergrowth_bush"));

        RegistryKey<PlacedFeature> treeBetterOak = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak"));
        RegistryKey<PlacedFeature> treeDeadOak = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "dead_oak"));
        RegistryKey<PlacedFeature> treeBetterOakRareBees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak_rare_bees"));
        RegistryKey<PlacedFeature> treeBetterOakRegularBees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak_regular_bees"));
        RegistryKey<PlacedFeature> treeBetterOakMoreBees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_oak_more_bees"));
        RegistryKey<PlacedFeature> treeBetterSwampOak = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_swamp_oak"));

        RegistryKey<PlacedFeature> treeBetterBirch = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch"));
        RegistryKey<PlacedFeature> treeDeadBirch = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "dead_birch"));
        RegistryKey<PlacedFeature> treeBetterBirchRareBees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_rare_bees"));
        RegistryKey<PlacedFeature> treeBetterBirchRegularBees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_regular_bees"));
        RegistryKey<PlacedFeature> treeBetterBirchMoreBees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_more_bees"));

        RegistryKey<PlacedFeature> betterForestTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_forest_trees"));
        RegistryKey<PlacedFeature> betterFlowerForestTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_flower_forest_trees"));
        RegistryKey<PlacedFeature> betterBirchForestTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_birch_forest_trees"));
        RegistryKey<PlacedFeature> betterPlainsTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_plains_trees"));
        RegistryKey<PlacedFeature> betterWaterBiomeTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_water_biome_trees"));
        RegistryKey<PlacedFeature> betterDarkForestVegetation = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_dark_forest_vegetation"));
        RegistryKey<PlacedFeature> betterBambooJungleVegetation = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_bamboo_jungle_vegetation"));
        RegistryKey<PlacedFeature> betterJungleTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_jungle_trees"));
        RegistryKey<PlacedFeature> betterSparseJungleTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_sparse_jungle_trees"));
        RegistryKey<PlacedFeature> betterSavannahTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_savannah_trees"));
        RegistryKey<PlacedFeature> betterWindsweptSavannahTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_windswept_savannah_trees"));
        RegistryKey<PlacedFeature> betterWindsweptHillsTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_windswept_hills_trees"));
        RegistryKey<PlacedFeature> betterWindsweptForestTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_windswept_forest_trees"));
        RegistryKey<PlacedFeature> betterSwampTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_swamp_trees"));
        RegistryKey<PlacedFeature> betterBadlandsTrees = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier("spaghettitrees", "better_badlands_trees"));

        Registry.register(BuiltinRegistries.PLACED_FEATURE, deadOakLog.getValue(), DEAD_OAK_LOG);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, deadBirchLog.getValue(), DEAD_BIRCH_LOG);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, oakStump.getValue(), OAK_STUMP);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, birchStump.getValue(), BIRCH_STUMP);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, undergrowthBush.getValue(), UNDERGROWTH_BUSH);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeBetterOak.getValue(), TREE_BETTER_OAK);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeDeadOak.getValue(), TREE_DEAD_OAK);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeBetterOakRareBees.getValue(), TREE_BETTER_OAK_RARE_BEES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeBetterOakRegularBees.getValue(), TREE_BETTER_OAK_REGULAR_BEES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeBetterOakMoreBees.getValue(), TREE_BETTER_OAK_MORE_BEES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeBetterSwampOak.getValue(), TREE_BETTER_SWAMP_OAK);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeBetterBirch.getValue(), TREE_BETTER_BIRCH);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeDeadBirch.getValue(), TREE_DEAD_BIRCH);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeBetterBirchRareBees.getValue(), TREE_BETTER_BIRCH_RARE_BEES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeBetterBirchRegularBees.getValue(), TREE_BETTER_BIRCH_REGULAR_BEES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, treeBetterBirchMoreBees.getValue(), TREE_BETTER_BIRCH_MORE_BEES);

        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterForestTrees.getValue(), BETTER_FOREST_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterFlowerForestTrees.getValue(), BETTER_FLOWER_FOREST_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterBirchForestTrees.getValue(), BETTER_BIRCH_FOREST_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterPlainsTrees.getValue(), BETTER_PLAINS_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterWaterBiomeTrees.getValue(), BETTER_WATER_BIOME_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterDarkForestVegetation.getValue(), BETTER_DARK_FOREST_VEGETATION);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterBambooJungleVegetation.getValue(), BETTER_BAMBOO_JUNGLE_VEGETATION);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterJungleTrees.getValue(), BETTER_JUNGLE_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterSparseJungleTrees.getValue(), BETTER_SPARSE_JUNGLE_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterSavannahTrees.getValue(), BETTER_SAVANNAH_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterWindsweptSavannahTrees.getValue(), BETTER_WINDSWEPT_SAVANNAH_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterWindsweptHillsTrees.getValue(), BETTER_WINDSWEPT_HILLS_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterWindsweptForestTrees.getValue(), BETTER_WINDSWEPT_FOREST_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterSwampTrees.getValue(), BETTER_SWAMP_TREES);
        Registry.register(BuiltinRegistries.PLACED_FEATURE, betterBadlandsTrees.getValue(), BETTER_BADLANDS_TREES);
    }
}
