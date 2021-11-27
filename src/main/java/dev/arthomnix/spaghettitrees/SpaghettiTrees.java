package dev.arthomnix.spaghettitrees;


import dev.arthomnix.spaghettitrees.tree.BetterTreesConfiguredFeatures;
import dev.arthomnix.spaghettitrees.tree.BetterTreesPlacedFeatures;
import net.fabricmc.api.ModInitializer;


// whenever you see the word "better" in this mod put it in huge quote marks

public class SpaghettiTrees implements ModInitializer {
    @Override
    public void onInitialize() {
        BetterTreesConfiguredFeatures.registerAll();
        BetterTreesPlacedFeatures.registerAll();
    }
}
