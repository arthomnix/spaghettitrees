package dev.arthomnix.spaghettitrees.mixin.invoker;

import net.minecraft.block.BlockState;
import net.minecraft.world.gen.stateprovider.SimpleBlockStateProvider;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SimpleBlockStateProvider.class)
public interface SimpleBlockStateProviderInvoker {
    @Invoker("<init>")
    static SimpleBlockStateProvider invokeCtor(BlockState state) { throw new IllegalStateException(); }
}