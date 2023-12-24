package net.bor1bro.firstmod.item;

import net.bor1bro.firstmod.FirstMod;
import net.bor1bro.firstmod.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup BOR1BRONIUM_GROUP = Registry.register(Registries.ITEM_GROUP,
            new Identifier(FirstMod.MOD_ID, "bor1bronium"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.bor1bronium"))
                    .icon(() -> new ItemStack(ModItems.BOR1BRONIUM)).entries((displayContext, entries) -> {
                        entries.add(ModItems.RAW_BOR1BRONIUM);
                        entries.add(ModItems.BOR1BRONIUM);
                        entries.add(ModItems.BOR1BRONIUM_MEMBER);
                        entries.add(ModItems.BOR1BRONIUM_FLAPS);
                        entries.add(ModItems.BOR1BRONIUM_SKIN);
                        entries.add(ModItems.RAW_BOR1BRONIUM_SNACK);
                        entries.add(ModItems.COOKED_BOR1BRONIUM_SNACK);
                        entries.add(ModItems.BOR1BRONIUM_MEAT);
                        entries.add(ModBlocks.RAW_BOR1BRONIUM_BLOCK);
                        entries.add(ModBlocks.BOR1BRONIUM_BLOCK);
                        entries.add(ModBlocks.CUT_BOR1BRONIUM_BLOCK);
                        entries.add(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK1);
                        entries.add(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK2);
                        entries.add(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK3);
                        entries.add(ModBlocks.BOR1BRONIUM_ORE);
                        entries.add(ModBlocks.DEEPSLATE_BOR1BRONIUM_ORE);
                        entries.add(ModBlocks.BOR1BRONIUM_STASH);
                        entries.add(ModItems.NETHERITE_KNIFE);
                        entries.add(ModItems.NETHERITE_FLAYER);
                        entries.add(ModItems.POOPY);
                    }).build());
    public static void registerItemGroups()
    {
        FirstMod.LOGGER.info("Registering Item Groups for " + FirstMod.MOD_ID);
    }
}
