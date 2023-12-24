package net.bor1bro.firstmod.datagen;

import net.bor1bro.firstmod.block.ModBlocks;
import net.bor1bro.firstmod.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        getOrCreateTagBuilder(ModTags.Blocks.FLAYERABLE_BLOCKS)
                .add(ModBlocks.CUT_BOR1BRONIUM_BLOCK)
                .add(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK1)
                .add(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK2);

        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.RAW_BOR1BRONIUM_BLOCK)
                .add(ModBlocks.BOR1BRONIUM_ORE)
                .add(ModBlocks.DEEPSLATE_BOR1BRONIUM_ORE);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.RAW_BOR1BRONIUM_BLOCK);

        getOrCreateTagBuilder(TagKey.of(RegistryKeys.BLOCK, new Identifier("fabric", "needs_tool_level_4")))
                .add(ModBlocks.BOR1BRONIUM_ORE)
                .add(ModBlocks.DEEPSLATE_BOR1BRONIUM_ORE);
    }
}
