package net.bor1bro.firstmod.block;

import net.bor1bro.firstmod.FirstMod;
import net.bor1bro.firstmod.block.custom.Bor1broniumStashBlock;
import net.bor1bro.firstmod.block.custom.CutBor1broniumBlock;
import net.bor1bro.firstmod.block.custom.FlayeredBor1broniumBlock;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.ExperienceDroppingBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;

public class ModBlocks {

    public static final Block BOR1BRONIUM_BLOCK = registerBlock("bor1bronium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).sounds(BlockSoundGroup.SLIME))); //or .create(any settings you want)
    public static final Block CUT_BOR1BRONIUM_BLOCK = registerBlock("cut_bor1bronium_block",
            new CutBor1broniumBlock(FabricBlockSettings.copyOf(Blocks.GRASS_BLOCK).sounds(BlockSoundGroup.SLIME).slipperiness(0.5f))); //or .create(any settings you want)
    public static final Block FLAYERED_BOR1BRONIUM_BLOCK1 = registerBlock("flayered_bor1bronium_block1",
            new FlayeredBor1broniumBlock(FabricBlockSettings.copyOf(ModBlocks.CUT_BOR1BRONIUM_BLOCK)));
    public static final Block FLAYERED_BOR1BRONIUM_BLOCK2 = registerBlock("flayered_bor1bronium_block2",
            new FlayeredBor1broniumBlock(FabricBlockSettings.copyOf(ModBlocks.CUT_BOR1BRONIUM_BLOCK)));
    public static final Block FLAYERED_BOR1BRONIUM_BLOCK3 = registerBlock("flayered_bor1bronium_block3",
            new FlayeredBor1broniumBlock(FabricBlockSettings.copyOf(ModBlocks.CUT_BOR1BRONIUM_BLOCK).slipperiness(0.7f)));
    public static final Block RAW_BOR1BRONIUM_BLOCK = registerBlock("raw_bor1bronium_block",
            new Block(FabricBlockSettings.copyOf(Blocks.COBBLESTONE))); //or .create(any settings you want)
    public static final Block BOR1BRONIUM_ORE = registerBlock("bor1bronium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.STONE).strength(4.0f), UniformIntProvider.create(2, 5)));
    public static final Block DEEPSLATE_BOR1BRONIUM_ORE = registerBlock("deepslate_bor1bronium_ore",
            new ExperienceDroppingBlock(FabricBlockSettings.copyOf(Blocks.DEEPSLATE).strength(5.0f), UniformIntProvider.create(5, 10)));
    public static final Block BOR1BRONIUM_STASH = registerBlock("bor1bronium_stash",
            new Bor1broniumStashBlock(FabricBlockSettings.copyOf(Blocks.BEDROCK).sounds(BlockSoundGroup.WOOD)));

    public static Block registerBlock(String name, Block block)
    {
        registerBlockItem(name,block);
        return Registry.register(Registries.BLOCK, new Identifier(FirstMod.MOD_ID, name), block);
    }

    public static Item registerBlockItem(String name, Block block)
    {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks()
    {
        FirstMod.LOGGER.info("Registering ModBlocks for " + FirstMod.MOD_ID);
    }
}
