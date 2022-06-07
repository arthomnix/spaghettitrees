package dev.arthomnix.spaghettitrees.mixin;

import dev.arthomnix.spaghettitrees.mixin.invoker.SaplingBlockInvoker;
import dev.arthomnix.spaghettitrees.sapling.BetterBirchSaplingGenerator;
import dev.arthomnix.spaghettitrees.sapling.BetterOakSaplingGenerator;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Blocks;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.sapling.SaplingGenerator;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(Blocks.class)
public class BlocksMixin {
    @Redirect(method = "<clinit>", at = @At(target = "net/minecraft/block/SaplingBlock", value = "NEW", ordinal = 0))
    private static SaplingBlock returnBetterOakSaplingBlock(SaplingGenerator generator, AbstractBlock.Settings settings) {
        return SaplingBlockInvoker.invokeCtor(new BetterOakSaplingGenerator(), settings);
    }

    @Redirect(method = "<clinit>", at = @At(target = "net/minecraft/block/SaplingBlock", value = "NEW", ordinal = 2))
    private static SaplingBlock returnBetterBirchSaplingBlock(SaplingGenerator generator, AbstractBlock.Settings settings) {
        return SaplingBlockInvoker.invokeCtor(new BetterBirchSaplingGenerator(), settings);
    }
}