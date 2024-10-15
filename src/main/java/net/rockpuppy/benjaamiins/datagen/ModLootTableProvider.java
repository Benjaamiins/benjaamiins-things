package net.rockpuppy.benjaamiins.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.rockpuppy.benjaamiins.block.ModBlocks;
import net.rockpuppy.benjaamiins.entity.ModEntities;
import net.rockpuppy.benjaamiins.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.BEAN_BLOCK);
        addDrop(ModBlocks.BEAN_STAIRS);
        addDrop(ModBlocks.BEAN_SLAB);
        addDrop(ModBlocks.BEAN_BRICKS);
        addDrop(ModBlocks.CRACKED_BEAN_BRICKS);
        addDrop(ModBlocks.BEAN_BRICK_STAIRS);
        addDrop(ModBlocks.BEAN_BRICK_SLAB);
        addDrop(ModBlocks.BEAN_PILLAR);
        addDrop(ModBlocks.CRACKED_BEAN_PILLAR);
        addDrop(ModBlocks.ZEPHORINE_SHARD_BLOCK);
        addDrop(ModBlocks.UNCUT_ZEPHORINE_SHARD_BLOCK);

        addDrop(ModBlocks.BEAN_ORE, oreLikeDrops(ModBlocks.BEAN_ORE, ModItems.BEAN));
        addDrop(ModBlocks.DEEPSLATE_BEAN_ORE, oreLikeDrops(ModBlocks.DEEPSLATE_BEAN_ORE, ModItems.BEAN));
        addDrop(ModBlocks.ZEPHORINE_ORE, oreLikeDrops(ModBlocks.ZEPHORINE_ORE, ModItems.UNCUT_ZEPHORINE_SHARD));
        addDrop(ModBlocks.DEEPSLATE_ZEPHORINE_ORE, oreLikeDrops(ModBlocks.DEEPSLATE_ZEPHORINE_ORE, ModItems.UNCUT_ZEPHORINE_SHARD));
        addDrop(ModBlocks.NETHER_ZEPHORINE_ORE, oreLikeDrops(ModBlocks.NETHER_ZEPHORINE_ORE, ModItems.UNCUT_ZEPHORINE_SHARD));
        addDrop(ModBlocks.END_STONE_ZEPHORINE_ORE, oreLikeDrops(ModBlocks.END_STONE_ZEPHORINE_ORE, ModItems.UNCUT_ZEPHORINE_SHARD));

    }

    public LootTable.Builder oreLikeDrops(Block withSilkTouch, Item withoutSilkTouch) {
        RegistryWrapper.Impl<Enchantment> impl = this.registryLookup.getWrapperOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(withSilkTouch, (LootPoolEntry.Builder)this.applyExplosionDecay(withSilkTouch, ItemEntry.builder(withoutSilkTouch)));
    }
}
