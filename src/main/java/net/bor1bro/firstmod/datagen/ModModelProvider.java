package net.bor1bro.firstmod.datagen;

import net.bor1bro.firstmod.block.ModBlocks;
import net.bor1bro.firstmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.RAW_BOR1BRONIUM_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BOR1BRONIUM_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_BOR1BRONIUM_ORE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BOR1BRONIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BOR1BRONIUM, Models.GENERATED);
        itemModelGenerator.register(ModItems.RAW_BOR1BRONIUM_SNACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.COOKED_BOR1BRONIUM_SNACK, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOR1BRONIUM_MEAT, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOR1BRONIUM_FLAPS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOR1BRONIUM_MEMBER, Models.GENERATED);
        itemModelGenerator.register(ModItems.BOR1BRONIUM_SKIN, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_KNIFE, Models.GENERATED);
        itemModelGenerator.register(ModItems.NETHERITE_FLAYER, Models.GENERATED);
        itemModelGenerator.register(ModItems.POOPY, Models.GENERATED);
    }
}
