package net.bor1bro.firstmod.item;

import net.bor1bro.firstmod.FirstMod;
import net.bor1bro.firstmod.item.custom.Bor1broniumSnackItem;
import net.bor1bro.firstmod.item.custom.NetheriteFlayerItem;
import net.bor1bro.firstmod.item.custom.NetheriteKnifeItem;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;
import net.minecraft.item.ToolItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.bor1bro.firstmod.mixin.ItemAccessor;

public class ModItems {

    public static final Item BOR1BRONIUM = registerItem("bor1bronium", new Item(new FabricItemSettings()));
    public static final Item BOR1BRONIUM_MEMBER = registerItem("bor1bronium_member", new Item(new FabricItemSettings()));
    public static final Item BOR1BRONIUM_FLAPS = registerItem("bor1bronium_flaps", new Item(new FabricItemSettings()));
    public static final Item RAW_BOR1BRONIUM = registerItem("raw_bor1bronium", new Item(new FabricItemSettings()));
    public static final Item RAW_BOR1BRONIUM_SNACK = registerItem("raw_bor1bronium_snack",
            new Bor1broniumSnackItem(new FabricItemSettings().maxCount(16).recipeRemainder(ModItems.NETHERITE_KNIFE)));
    public static final Item COOKED_BOR1BRONIUM_SNACK = registerItem("cooked_bor1bronium_snack",
            new Bor1broniumSnackItem(new FabricItemSettings().food(ModFoodComponents.COOKED_BOR1BRONIUM_SNACK).maxCount(16)));
    public static final Item NETHERITE_KNIFE = registerRemainderItem("netherite_knife",
            new NetheriteKnifeItem(new FabricItemSettings().maxCount(1)));
    public static final Item NETHERITE_FLAYER = registerItem("netherite_flayer",
            new NetheriteFlayerItem(new FabricItemSettings().maxCount(1)));

    private static void addItemsToIngredientItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(BOR1BRONIUM);
        entries.add(RAW_BOR1BRONIUM);
        entries.add(BOR1BRONIUM_MEMBER);
        entries.add(BOR1BRONIUM_FLAPS);
    }
    private static void addItemsToFoodAndDrinkItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(COOKED_BOR1BRONIUM_SNACK);
    }
    private static void addItemsToToolItemGroup(FabricItemGroupEntries entries)
    {
        entries.add(NETHERITE_KNIFE);
        entries.add(NETHERITE_FLAYER);
    }

    private static Item registerItem(String name, Item item)
    {
        return Registry.register(Registries.ITEM, new Identifier(FirstMod.MOD_ID, name), item);
    }

    private static Item registerRemainderItem(String name, Item item) {
        Item remainderItem = registerItem(name, item);
        ((ItemAccessor) remainderItem).setRecipeRemainder(remainderItem);

        return remainderItem;
    }

    public static void registerModItems()
    {
        FirstMod.LOGGER.info("Registering Mod Items for " + FirstMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(ModItems::addItemsToIngredientItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(ModItems::addItemsToFoodAndDrinkItemGroup);
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(ModItems::addItemsToToolItemGroup);
    }
}
