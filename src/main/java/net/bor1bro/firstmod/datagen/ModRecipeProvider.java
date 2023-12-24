package net.bor1bro.firstmod.datagen;

import net.bor1bro.firstmod.block.ModBlocks;
import net.bor1bro.firstmod.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeJsonProvider;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.ShapedRecipe;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends FabricRecipeProvider {
    public static final List<ItemConvertible> KNIFEABLES = List.of(ModItems.BOR1BRONIUM);
    public ModRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generate(Consumer<RecipeJsonProvider> exporter) {
        offerFoodCookingRecipe(exporter, "campfire", RecipeSerializer.CAMPFIRE_COOKING,
                1000, ModItems.RAW_BOR1BRONIUM_SNACK, ModItems.COOKED_BOR1BRONIUM_SNACK, 0);

        ShapelessRecipeJsonBuilder.create(RecipeCategory.FOOD, ModItems.RAW_BOR1BRONIUM_SNACK)
                .input(ModItems.BOR1BRONIUM)
                .input(ModItems.NETHERITE_KNIFE)
                .criterion(FabricRecipeProvider.hasItem(ModItems.BOR1BRONIUM), FabricRecipeProvider.conditionsFromItem(ModItems.BOR1BRONIUM))
                .criterion(FabricRecipeProvider.hasItem(ModItems.NETHERITE_KNIFE), FabricRecipeProvider.conditionsFromItem(ModItems.NETHERITE_KNIFE))
                .offerTo(exporter);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BOR1BRONIUM_BLOCK, ModItems.BOR1BRONIUM);
        offerShapelessRecipe(exporter,ModItems.BOR1BRONIUM,ModBlocks.BOR1BRONIUM_BLOCK, "", 4);
        offerStonecuttingRecipe(exporter, RecipeCategory.MISC, ModItems.BOR1BRONIUM, ModItems.RAW_BOR1BRONIUM);

        offerCompactingRecipe(exporter, RecipeCategory.MISC, ModItems.BOR1BRONIUM_SKIN, ModItems.BOR1BRONIUM_FLAPS);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.NETHERITE_KNIFE, 1)
                .pattern("   ")
                .pattern(" N ")
                .pattern("S  ")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', Items.STICK)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModItems.NETHERITE_FLAYER, 1)
                .pattern("  N")
                .pattern(" S ")
                .pattern("L  ")
                .input('N', Items.NETHERITE_INGOT)
                .input('S', Items.STICK)
                .input('L', Items.LEATHER)
                .criterion(hasItem(Items.NETHERITE_INGOT), conditionsFromItem(Items.NETHERITE_INGOT))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .criterion(hasItem(Items.LEATHER), conditionsFromItem(Items.LEATHER))
                .offerTo(exporter);
    }
}
