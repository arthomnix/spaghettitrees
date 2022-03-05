package dev.arthomnix.spaghettitrees.tree;

import com.google.common.collect.ImmutableList;
import dev.arthomnix.spaghettitrees.util.RegistryUtil;
import net.minecraft.block.Blocks;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.RegistryEntry;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.PlacedFeature;
import net.minecraft.world.gen.feature.PlacedFeatures;
import net.minecraft.world.gen.feature.VegetationPlacedFeatures;
import net.minecraft.world.gen.placementmodifier.*;

public class BetterTreesPlacedFeatures {
    public static final RegistryEntry<PlacedFeature> DEAD_OAK_LOG = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_dead_oak_log"), new PlacedFeature(BetterTreesConfiguredFeatures.DEAD_OAK_LOG, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> DEAD_BIRCH_LOG = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_dead_birch_log"), new PlacedFeature(BetterTreesConfiguredFeatures.DEAD_BIRCH_LOG, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> OAK_STUMP = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_oak_stump"), new PlacedFeature(BetterTreesConfiguredFeatures.OAK_STUMP, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> BIRCH_STUMP = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_birch_stump"), new PlacedFeature(BetterTreesConfiguredFeatures.BIRCH_STUMP, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> UNDERGROWTH_BUSH = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_undergrowth_bush"), new PlacedFeature(BetterTreesConfiguredFeatures.UNDERGROWTH_BUSH, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> TREE_BETTER_OAK = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_tree_better_oak"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_BETTER_OAK, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> TREE_DEAD_OAK = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_tree_dead_oak"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_DEAD_OAK, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> TREE_BETTER_OAK_RARE_BEES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_tree_better_oak_rare_bees"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_BETTER_OAK_RARE_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> TREE_BETTER_OAK_BEES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_tree_better_oak_bees"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_BETTER_OAK_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> TREE_BETTER_BIRCH = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_tree_better_birch"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> TREE_DEAD_BIRCH = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_tree_dead_birch"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_DEAD_BIRCH, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> TREE_TALL_DEAD_BIRCH = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_tree_tall_dead_birch"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_TALL_DEAD_BIRCH, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> TREE_BETTER_BIRCH_RARE_BEES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_tree_better_birch_rare_bees"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH_RARE_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> TREE_BETTER_BIRCH_BEES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_tree_better_birch_bees"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_BETTER_BIRCH_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    public static final RegistryEntry<PlacedFeature> TREE_TALL_BETTER_BIRCH_RARE_BEES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_tree_tall_better_birch_rare_bees"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_TALL_BETTER_BIRCH_RARE_BEES, ImmutableList.of(
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(
                            Blocks.BIRCH_SAPLING.getDefaultState(), BlockPos.ORIGIN
                    )
            )
    )));

    static {
        BetterTreesConfiguredFeatures.registerBiomeTreeFeatures();
    }

    public static final RegistryEntry<PlacedFeature> BETTER_FOREST_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_forest_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_FOREST_TREES,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(8, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_FLOWER_FOREST_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_flower_forest_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_FOREST_TREES,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(3, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_BIRCH_FOREST_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_birch_forest_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_BIRCH_FOREST_TREES,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(8, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_TALL_BIRCH_FOREST_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_tall_birch_forest_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_TALL_BIRCH_FOREST_TREES,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(8, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_PLAINS_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_plains_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_BETTER_OAK_RARE_BEES, ImmutableList.of(
            PlacedFeatures.createCountExtraModifier(0, 0.05f, 1),
            SquarePlacementModifier.of(),
            SurfaceWaterDepthFilterPlacementModifier.of(0),
            PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
            BiomePlacementModifier.of()
    )));

    public static final RegistryEntry<PlacedFeature> BETTER_WATER_BIOME_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_water_biome_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_BETTER_OAK,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_DARK_FOREST_VEGETATION = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_dark_forest_vegetation"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_DARK_FOREST_VEGETATION_BROWN, ImmutableList.of(
            CountPlacementModifier.of(16),
            SquarePlacementModifier.of(),
            SurfaceWaterDepthFilterPlacementModifier.of(0),
            PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)
            ),
            BiomePlacementModifier.of()
    )));

    public static final RegistryEntry<PlacedFeature> BETTER_BAMBOO_JUNGLE_VEGETATION = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_bamboo_jungle_vegetation"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_BAMBOO_JUNGLE_VEGETATION,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(30, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_JUNGLE_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_jungle_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_JUNGLE_TREES,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(50, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_SPARSE_JUNGLE_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_sparse_jungle_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_SPARSE_JUNGLE_TREES,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(2, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_SAVANNAH_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_savannah_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_SAVANNAH_TREES,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(1, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_WINDSWEPT_SAVANNAH_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_windswept_savannah_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_SAVANNAH_TREES,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(2, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_WINDSWEPT_HILLS_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_windswept_hills_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_MOUNTAIN_TREES,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(0, 0.1f,1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_WINDSWEPT_FOREST_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_windswept_forest_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_MOUNTAIN_TREES,
            VegetationPlacedFeatures.modifiers(
                    PlacedFeatures.createCountExtraModifier(2, 0.1f, 1)
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_SWAMP_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_swamp_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_BETTER_SWAMP_OAK, ImmutableList.of(
            PlacedFeatures.createCountExtraModifier(2, 0.1f, 1),
            SquarePlacementModifier.of(),
            SurfaceWaterDepthFilterPlacementModifier.of(2),
            PlacedFeatures.OCEAN_FLOOR_HEIGHTMAP,
            BiomePlacementModifier.of(),
            BlockFilterPlacementModifier.of(
                    BlockPredicate.wouldSurvive(Blocks.OAK_SAPLING.getDefaultState(), BlockPos.ORIGIN)
            )
    )));

    public static final RegistryEntry<PlacedFeature> BETTER_BADLANDS_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_badlands_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.TREE_BETTER_OAK,
            VegetationPlacedFeatures.modifiersWithWouldSurvive(
                    PlacedFeatures.createCountExtraModifier(5, 0.1f, 1),
                    Blocks.OAK_SAPLING
            )
    ));

    public static final RegistryEntry<PlacedFeature> BETTER_MEADOW_TREES = RegistryUtil.registerPlacedFeature(new Identifier("spaghettitrees", "placed_better_meadow_trees"), new PlacedFeature(BetterTreesConfiguredFeatures.BETTER_MEADOW_TREES,
            VegetationPlacedFeatures.modifiers(
                    RarityFilterPlacementModifier.of(100)
            )
    ));
}
