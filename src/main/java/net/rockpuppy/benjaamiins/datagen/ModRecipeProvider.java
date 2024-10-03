package net.rockpuppy.benjaamiins.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.rockpuppy.benjaamiins.block.ModBlocks;
import net.rockpuppy.benjaamiins.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    private static final List<ItemConvertible> BEAN_SMELTABLES = List.of(
            ModBlocks.BEAN_ORE, ModBlocks.DEEPSLATE_BEAN_ORE);
    public static final List<ItemConvertible> BENJAMINIUM_SMELTABLES = List.of(
            ModBlocks.BENJAMINIUM_ORE, ModBlocks.DEEPSLATE_BEAN_ORE, ModBlocks.NETHER_BENJAMINIUM_ORE, ModBlocks.END_STONE_BENJAMINIUM_ORE, ModItems.UNCUT_BENJAMINIUM_SHARD);

    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {
        offerSmelting(exporter, BEAN_SMELTABLES, RecipeCategory.MISC, ModItems.BEAN, 1.0F, 200, "bean");
        offerBlasting(exporter, BEAN_SMELTABLES, RecipeCategory.MISC, ModItems.BEAN, 1.0F, 200, "bean");
        offerSmelting(exporter, BENJAMINIUM_SMELTABLES, RecipeCategory.MISC, ModItems.BENJAMINIUM_SHARD, 1.0F, 200, "bean");
        offerBlasting(exporter, BENJAMINIUM_SMELTABLES, RecipeCategory.MISC, ModItems.BENJAMINIUM_SHARD, 1.0F, 200, "bean");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BEAN, RecipeCategory.DECORATIONS, ModBlocks.BEAN_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BENJAMINIUM_SHARD, RecipeCategory.DECORATIONS, ModBlocks.BENJAMINIUM_SHARD_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.UNCUT_BENJAMINIUM_SHARD, RecipeCategory.DECORATIONS, ModBlocks.UNCUT_BENJAMINIUM_SHARD_BLOCK);

        offer2x2CompactingRecipe(exporter, RecipeCategory.BUILDING_BLOCKS, ModBlocks.BEAN_BRICKS, ModBlocks.BEAN_BLOCK);

        createStairsRecipe(ModBlocks.BEAN_STAIRS, Ingredient.ofItems(ModBlocks.BEAN_BLOCK))
                .criterion(hasItem(ModBlocks.BEAN_BLOCK), conditionsFromItem(ModBlocks.BEAN_BLOCK))
                .offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS , ModBlocks.BEAN_SLAB, Ingredient.ofItems(ModBlocks.BEAN_BLOCK))
                .criterion(hasItem(ModBlocks.BEAN_BLOCK), conditionsFromItem(ModBlocks.BEAN_BLOCK))
                .offerTo(exporter);
        createStairsRecipe(ModBlocks.BEAN_BRICK_STAIRS, Ingredient.ofItems(ModBlocks.BEAN_BRICKS))
                .criterion(hasItem(ModBlocks.BEAN_BRICKS), conditionsFromItem(ModBlocks.BEAN_BRICKS))
                .offerTo(exporter);
        createSlabRecipe(RecipeCategory.BUILDING_BLOCKS , ModBlocks.BEAN_BRICK_SLAB, Ingredient.ofItems(ModBlocks.BEAN_BRICKS))
                .criterion(hasItem(ModBlocks.BEAN_BRICKS), conditionsFromItem(ModBlocks.BEAN_BRICKS))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEAN_PICKAXE, 1)
                .pattern("BBB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.BEAN)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BEAN), conditionsFromItem(ModItems.BEAN))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEAN_SWORD, 1)
                .pattern(" B ")
                .pattern(" B ")
                .pattern(" S ")
                .input('B', ModItems.BEAN)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BEAN), conditionsFromItem(ModItems.BEAN))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEAN_AXE, 1)
                .pattern(" BB")
                .pattern(" SB")
                .pattern(" S ")
                .input('B', ModItems.BEAN)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BEAN), conditionsFromItem(ModItems.BEAN))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEAN_SHOVEL, 1)
                .pattern(" B ")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.BEAN)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BEAN), conditionsFromItem(ModItems.BEAN))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModItems.BEAN_HOE, 1)
                .pattern(" BB")
                .pattern(" S ")
                .pattern(" S ")
                .input('B', ModItems.BEAN)
                .input('S', Items.STICK)
                .criterion(hasItem(ModItems.BEAN), conditionsFromItem(ModItems.BEAN))
                .criterion(hasItem(Items.STICK), conditionsFromItem(Items.STICK))
                .offerTo(exporter);
    }
}
