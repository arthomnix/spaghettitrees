package dev.arthomnix.spaghettitrees.mixin.invoker;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(SaplingBlock.class)
public interface SaplingBlockInvoker {
    @Invoker("<init>")
    static SaplingBlock invokeCtor(SaplingGenerator generator, AbstractBlock.Settings settings) { throw new IllegalStateException(); }
}