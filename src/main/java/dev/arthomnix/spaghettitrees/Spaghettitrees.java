package dev.arthomnix.spaghettitrees;


import dev.arthomnix.spaghettitrees.tree.BetterTrees;
import net.fabricmc.api.ModInitializer;


// whenever you see the word "better" in this mod put it in huge quote marks

public class Spaghettitrees implements ModInitializer {
    @Override
    public void onInitialize() {
        BetterTrees.registerAll();
    }
}
