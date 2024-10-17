package net.rockpuppy.benjaamiins.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Model;
import net.minecraft.data.client.Models;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.block.ModBlocks;
import net.rockpuppy.benjaamiins.item.ModItems;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        BlockStateModelGenerator.BlockTexturePool beanPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BEAN_BLOCK);
        BlockStateModelGenerator.BlockTexturePool beanBrickPool = blockStateModelGenerator.registerCubeAllModelTexturePool(ModBlocks.BEAN_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.CRACKED_BEAN_BRICKS);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_BEAN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.BEAN_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZEPHORINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DEEPSLATE_ZEPHORINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.NETHER_ZEPHORINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.END_STONE_ZEPHORINE_ORE);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.ZEPHORINE_SHARD_BLOCK);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.UNCUT_ZEPHORINE_SHARD_BLOCK);

        blockStateModelGenerator.registerLog(ModBlocks.BEAN_PILLAR).log(ModBlocks.BEAN_PILLAR);
        blockStateModelGenerator.registerLog(ModBlocks.CRACKED_BEAN_PILLAR).log(ModBlocks.CRACKED_BEAN_PILLAR);

        beanPool.stairs(ModBlocks.BEAN_STAIRS);
        beanPool.slab(ModBlocks.BEAN_SLAB);
        beanBrickPool.stairs(ModBlocks.BEAN_BRICK_STAIRS);
        beanBrickPool.slab(ModBlocks.BEAN_BRICK_SLAB);

        blockStateModelGenerator.registerSimpleState(ModBlocks.BEAN_PEDESTAL);
        blockStateModelGenerator.registerSimpleState(ModBlocks.BEANSTONE_MONOLITH);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.BEAN, Models.GENERATED);
        itemModelGenerator.register(ModItems.VALIDUS_BEANORUM, Models.GENERATED);

        itemModelGenerator.register(ModItems.BEAN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BEAN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BEAN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BEAN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.BEAN_HOE, Models.HANDHELD);

        itemModelGenerator.register(ModItems.BEAN_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEAN_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEAN_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.BEAN_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.ZEPHORINE_SHARD, Models.GENERATED);
        itemModelGenerator.register(ModItems.UNCUT_ZEPHORINE_SHARD, Models.GENERATED);

        itemModelGenerator.register(ModItems.ELITE_BEAN_HELMET, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELITE_BEAN_CHESTPLATE, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELITE_BEAN_LEGGINGS, Models.GENERATED);
        itemModelGenerator.register(ModItems.ELITE_BEAN_BOOTS, Models.GENERATED);

        itemModelGenerator.register(ModItems.BEAN_MASTER_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.BEAN_LORD_SPAWN_EGG, new Model(Optional.of(new Identifier("item/template_spawn_egg")), Optional.empty()));
    }
}