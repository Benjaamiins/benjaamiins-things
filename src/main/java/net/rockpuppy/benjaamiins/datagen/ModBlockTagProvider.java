package net.rockpuppy.benjaamiins.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.rockpuppy.benjaamiins.block.ModBlocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.BEAN_BLOCK)
                .add(ModBlocks.BEAN_STAIRS)
                .add(ModBlocks.BEAN_SLAB)
                .add(ModBlocks.BEAN_BRICKS)
                .add(ModBlocks.CRACKED_BEAN_BRICKS)
                .add(ModBlocks.BEAN_BRICK_STAIRS)
                .add(ModBlocks.BEAN_BRICK_SLAB)
                .add(ModBlocks.BEAN_PILLAR)
                .add(ModBlocks.CRACKED_BEAN_PILLAR)
                .add(ModBlocks.DEEPSLATE_BEAN_ORE)
                .add(ModBlocks.BEAN_ORE)
                .add(ModBlocks.ZEPHORINE_SHARD_BLOCK)
                .add(ModBlocks.UNCUT_ZEPHORINE_SHARD_BLOCK)
                .add(ModBlocks.ZEPHORINE_ORE)
                .add(ModBlocks.DEEPSLATE_ZEPHORINE_ORE)
                .add(ModBlocks.NETHER_ZEPHORINE_ORE)
                .add(ModBlocks.END_STONE_ZEPHORINE_ORE)
                .add(ModBlocks.BEAN_PEDESTAL)
                .add(ModBlocks.BEANSTONE_MONOLITH);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.BEAN_ORE)
                .add(ModBlocks.DEEPSLATE_BEAN_ORE)
                .add(ModBlocks.ZEPHORINE_ORE)
                .add(ModBlocks.DEEPSLATE_BEAN_ORE)
                .add(ModBlocks.NETHER_ZEPHORINE_ORE)
                .add(ModBlocks.END_STONE_ZEPHORINE_ORE)
                .add(ModBlocks.BEANSTONE_MONOLITH);

        getOrCreateTagBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.BEAN_BLOCK)
                .add(ModBlocks.BEAN_STAIRS)
                .add(ModBlocks.BEAN_SLAB)
                .add(ModBlocks.BEAN_BRICKS)
                .add(ModBlocks.BEAN_BRICK_STAIRS)
                .add(ModBlocks.BEAN_BRICK_SLAB)
                .add(ModBlocks.BEAN_PILLAR)
                .add(ModBlocks.ZEPHORINE_SHARD_BLOCK)
                .add(ModBlocks.UNCUT_ZEPHORINE_SHARD_BLOCK)
                .add(ModBlocks.BEAN_PEDESTAL);
    }
}
