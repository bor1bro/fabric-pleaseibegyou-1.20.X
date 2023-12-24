package net.bor1bro.firstmod.datagen;

import net.bor1bro.firstmod.block.ModBlocks;
import net.bor1bro.firstmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.data.server.loottable.BlockLootTableGenerator;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.item.Item;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BOR1BRONIUM_BLOCK);
        addDrop(ModBlocks.CUT_BOR1BRONIUM_BLOCK);
        addDrop(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK1);
        addDrop(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK2);
        addDrop(ModBlocks.FLAYERED_BOR1BRONIUM_BLOCK3);

        addDrop(ModBlocks.RAW_BOR1BRONIUM_BLOCK, oreDrops(ModBlocks.RAW_BOR1BRONIUM_BLOCK, ModItems.RAW_BOR1BRONIUM));
        addDrop(ModBlocks.BOR1BRONIUM_ORE, bor1broniumOreDrops(ModBlocks.BOR1BRONIUM_ORE, ModItems.BOR1BRONIUM));
        addDrop(ModBlocks.DEEPSLATE_BOR1BRONIUM_ORE, deepslateBor1broniumOreDrops(ModBlocks.DEEPSLATE_BOR1BRONIUM_ORE, ModItems.BOR1BRONIUM));
    }

    public LootTable.Builder bor1broniumOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator
                .dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this
                        .applyExplosionDecay(drop, ((LeafEntry.Builder) ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider
                                        .create(0.0f, 1.0f))))));
    }
    public LootTable.Builder deepslateBor1broniumOreDrops(Block drop, Item item) {
        return BlockLootTableGenerator
                .dropsWithSilkTouch(drop, (LootPoolEntry.Builder)this
                        .applyExplosionDecay(drop, ((LeafEntry.Builder) ItemEntry.builder(item)
                                .apply(SetCountLootFunction.builder(UniformLootNumberProvider
                                        .create(1.0f, 2.0f))))));
    }
}
