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
        offerSmelting(exporter, List.of(ModBlocks.BEAN_BRICKS), RecipeCategory.MISC, ModBlocks.CRACKED_BEAN_BRICKS, 1.0F, 200, "bean");
        offerBlasting(exporter, List.of(ModBlocks.BEAN_BRICKS), RecipeCategory.MISC, ModBlocks.CRACKED_BEAN_BRICKS, 1.0F, 200, "bean");
        offerSmelting(exporter, List.of(ModBlocks.BEAN_PILLAR), RecipeCategory.MISC, ModBlocks.CRACKED_BEAN_PILLAR, 1.0F, 200, "bean");
        offerBlasting(exporter, List.of(ModBlocks.BEAN_PILLAR), RecipeCategory.MISC, ModBlocks.CRACKED_BEAN_PILLAR, 1.0F, 200, "bean");

        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BEAN, RecipeCategory.DECORATIONS, ModBlocks.BEAN_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.BENJAMINIUM_SHARD, RecipeCategory.DECORATIONS, ModBlocks.BENJAMINIUM_SHARD_BLOCK);
        offerReversibleCompactingRecipes(exporter, RecipeCategory.BUILDING_BLOCKS, ModItems.UNCUT_BENJAMINIUM_SHARD, RecipeCategory.DECORATIONS, ModBlocks.UNCUT_BENJAMINIUM_SHARD_BLOCK);

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

        offerHelmetRecipe(exporter, ModItems.BEAN_HELMET, ModItems.BEAN);
        offerChestplateRecipe(exporter, ModItems.BEAN_CHESTPLATE, ModItems.BEAN);
        offerLeggingsRecipe(exporter, ModItems.BEAN_LEGGINGS, ModItems.BEAN);
        offerBootsRecipe(exporter, ModItems.BEAN_BOOTS, ModItems.BEAN);
        offerHelmetRecipe(exporter, ModItems.BENJAMINIUM_HELMET, ModItems.BENJAMINIUM_SHARD);
        offerChestplateRecipe(exporter, ModItems.BENJAMINIUM_CHESTPLATE, ModItems.BENJAMINIUM_SHARD);
        offerLeggingsRecipe(exporter, ModItems.BENJAMINIUM_LEGGINGS, ModItems.BENJAMINIUM_SHARD);
        offerBootsRecipe(exporter, ModItems.BENJAMINIUM_BOOTS, ModItems.BENJAMINIUM_SHARD);

        offerPickaxeRecipe(exporter, ModItems.BEAN_PICKAXE, ModItems.BEAN);
        offerSwordRecipe(exporter, ModItems.BEAN_SWORD, ModItems.BEAN);
        offerAxeRecipe(exporter, ModItems.BEAN_AXE, ModItems.BEAN);
        offerShovelRecipe(exporter, ModItems.BEAN_SHOVEL, ModItems.BEAN);
        offerHoeRecipe(exporter, ModItems.BEAN_HOE, ModItems.BEAN);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BEAN_BRICKS, 4)
                .input('#', ModBlocks.BEAN_BLOCK)
                .pattern("##")
                .pattern("##")
                .criterion(hasItem(ModBlocks.BEAN_BLOCK), conditionsFromItem(ModBlocks.BEAN_BLOCK))
                .offerTo(exporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, ModBlocks.BEAN_PILLAR, 2)
                .input('#', ModBlocks.BEAN_BRICKS)
                .pattern("#")
                .pattern("#")
                .criterion(hasItem(ModBlocks.BEAN_BRICKS), conditionsFromItem(ModBlocks.BEAN_BRICKS))
                .offerTo(exporter);
    }

    public static void offerPickaxeRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .input('#', input)
                .input('*', Items.STICK)
                .pattern("###")
                .pattern(" * ")
                .pattern(" * ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerSwordRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .input('#', input)
                .input('*', Items.STICK)
                .pattern(" # ")
                .pattern(" # ")
                .pattern(" * ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerAxeRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .input('#', input)
                .input('*', Items.STICK)
                .pattern(" ##")
                .pattern(" *#")
                .pattern(" * ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerShovelRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .input('#', input)
                .input('*', Items.STICK)
                .pattern(" # ")
                .pattern(" * ")
                .pattern(" * ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerHoeRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .input('#', input)
                .input('*', Items.STICK)
                .pattern(" ##")
                .pattern(" * ")
                .pattern(" * ")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerHelmetRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .input('#', input)
                .pattern("###")
                .pattern("# #")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerChestplateRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .input('#', input)
                .pattern("# #")
                .pattern("###")
                .pattern("###")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerLeggingsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .input('#', input)
                .pattern("###")
                .pattern("# #")
                .pattern("# #")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
    public static void offerBootsRecipe(RecipeExporter exporter, ItemConvertible output, ItemConvertible input) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, output)
                .input('#', input)
                .pattern("   ")
                .pattern("# #")
                .pattern("# #")
                .criterion(hasItem(input), conditionsFromItem(input))
                .offerTo(exporter);
    }
}
