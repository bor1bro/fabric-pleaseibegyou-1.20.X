package net.bor1bro.firstmod.util;

import net.bor1bro.firstmod.FirstMod;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class ModTags {
    public static class Blocks
    {
        public static final TagKey<Block> FLAYERABLE_BLOCKS = createTag("flayerable_blocks");

        public static TagKey<Block> createTag(String name)
        {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(FirstMod.MOD_ID, name));
        }
    }

    public static class Items
    {


        public static TagKey<Item> createTag(String name)
        {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(FirstMod.MOD_ID, name));
        }
    }
}
