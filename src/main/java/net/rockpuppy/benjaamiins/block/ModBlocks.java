package net.rockpuppy.benjaamiins.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.block.custom.BeanPedestalBlock;
import net.rockpuppy.benjaamiins.block.custom.BeanstoneMonolithBlock;

public class ModBlocks {
    public static final Block BEAN_ORE = register(
            new Block(AbstractBlock.Settings.create().strength(6.0f, 5.0F).requiresTool().sounds(BlockSoundGroup.STONE)), "bean_ore", true);
    public static final Block DEEPSLATE_BEAN_ORE = register(
            new Block(AbstractBlock.Settings.create().strength(7.5f, 5.0F).requiresTool().sounds(BlockSoundGroup.DEEPSLATE)), "deepslate_bean_ore", true);
    public static final Block BEAN_BLOCK = register(
            new Block(AbstractBlock.Settings.create().strength(3f, 5.0F).requiresTool().sounds(BlockSoundGroup.HONEY)), "bean_block", true);
    public static final Block BEAN_BRICKS = register(
            new Block(AbstractBlock.Settings.create().strength(3f, 5.0F).requiresTool().sounds(BlockSoundGroup.HONEY)), "bean_bricks", true);
    public static final Block CRACKED_BEAN_BRICKS = register(
            new Block(AbstractBlock.Settings.create().strength(3f, 5.0F).requiresTool().sounds(BlockSoundGroup.HONEY)), "cracked_bean_bricks", true);

    public static final Block BENJAMINIUM_ORE = register(
            new Block(AbstractBlock.Settings.create().strength(6.0f, 5.0F).requiresTool().sounds(BlockSoundGroup.STONE)), "benjaminium_ore", true);
    public static final Block DEEPSLATE_BENJAMINIUM_ORE = register(
            new Block(AbstractBlock.Settings.create().strength(7.5f, 5.0F).requiresTool().sounds(BlockSoundGroup.STONE)), "deepslate_benjaminium_ore", true);
    public static final Block NETHER_BENJAMINIUM_ORE = register(
            new Block(AbstractBlock.Settings.create().strength(6.0f, 5.0F).requiresTool().sounds(BlockSoundGroup.STONE)), "nether_benjaminium_ore", true);
    public static final Block END_STONE_BENJAMINIUM_ORE = register(
            new Block(AbstractBlock.Settings.create().strength(6.0f, 5.0F).requiresTool().sounds(BlockSoundGroup.STONE)), "end_stone_benjaminium_ore", true);
    public static final Block BENJAMINIUM_SHARD_BLOCK = register(
            new Block(AbstractBlock.Settings.create().strength(6.0f, 5.0F).requiresTool().sounds(BlockSoundGroup.STONE)), "benjaminium_shard_block", true);
    public static final Block UNCUT_BENJAMINIUM_SHARD_BLOCK = register(
            new Block(AbstractBlock.Settings.create().strength(6.0f, 5.0F).requiresTool().sounds(BlockSoundGroup.STONE)), "uncut_benjaminium_shard_block", true);

    public static final Block BEAN_STAIRS = register(
            new StairsBlock(ModBlocks.BEAN_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(ModBlocks.BEAN_BLOCK)), "bean_stairs", true);
    public static final Block BEAN_SLAB = register(
            new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.BEAN_BLOCK)), "bean_slab", true);
    public static final Block BEAN_BRICK_STAIRS = register(
            new StairsBlock(ModBlocks.BEAN_BRICKS.getDefaultState(), AbstractBlock.Settings.copy(ModBlocks.BEAN_BLOCK)), "bean_brick_stairs", true);
    public static final Block BEAN_BRICK_SLAB = register(
            new SlabBlock(AbstractBlock.Settings.copy(ModBlocks.BEAN_BLOCK)), "bean_brick_slab", true);
    public static final Block BEAN_PILLAR = register(
            new PillarBlock(AbstractBlock.Settings.copy(ModBlocks.BEAN_BLOCK)), "bean_pillar", true);
    public static final Block CRACKED_BEAN_PILLAR = register(
            new PillarBlock(AbstractBlock.Settings.copy(ModBlocks.BEAN_BLOCK)), "cracked_bean_pillar", true);

    public static final Block BEAN_PEDESTAL = register(
            new BeanPedestalBlock(AbstractBlock.Settings.copy(ModBlocks.BEAN_BLOCK).nonOpaque()), "bean_pedestal", true);
    public static final Block BEANSTONE_MONOLITH = register(
            new BeanstoneMonolithBlock(AbstractBlock.Settings.copy(ModBlocks.BEAN_BLOCK).nonOpaque()), "beanstone_monolith", true);


    public static Block register(Block block, String name, boolean shouldRegisterItem) {
        Identifier id = Identifier.of(Benjaamiins.MOD_ID, name);

        if (shouldRegisterItem){
            BlockItem blockItem = new BlockItem(block, new Item.Settings());
            Registry.register(Registries.ITEM, id, blockItem);
        }

        return Registry.register(Registries.BLOCK, id, block);
    }
    public static void initialize() {
    }
}
