package net.rockpuppy.benjaamiins.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.block.ModBlocks;

public class ModItemGroups {
    public static final ItemGroup BENJAAMIINS_GROUP = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Benjaamiins.MOD_ID, "benjaamiins_items"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.BEAN))
                    .displayName(Text.translatable("itemGroup.benjaamiins.benjaamiins_things"))
                    .entries((displayContext, entries) -> {
                    entries.add(ModItems.BEAN);
                    entries.add(ModItems.BEAN_PICKAXE);
                    entries.add(ModItems.BEAN_SWORD);
                    entries.add(ModItems.BEAN_AXE);
                    entries.add(ModItems.BEAN_SHOVEL);
                    entries.add(ModItems.BEAN_HOE);
                    entries.add(ModItems.BEAN_MASTER_SPAWN_EGG);
                    entries.add(ModItems.BEAN_LORD_SPAWN_EGG);

                    entries.add(ModItems.BEAN_HELMET);
                    entries.add(ModItems.BEAN_CHESTPLATE);
                    entries.add(ModItems.BEAN_LEGGINGS);
                    entries.add(ModItems.BEAN_BOOTS);

                    entries.add(ModBlocks.BEAN_ORE);
                    entries.add(ModBlocks.DEEPSLATE_BEAN_ORE);
                    entries.add(ModBlocks.BEAN_BLOCK);
                    entries.add(ModBlocks.BEAN_STAIRS);
                    entries.add(ModBlocks.BEAN_SLAB);
                    entries.add(ModBlocks.BEAN_BRICKS);
                    entries.add(ModBlocks.CRACKED_BEAN_BRICKS);
                    entries.add(ModBlocks.BEAN_BRICK_STAIRS);
                    entries.add(ModBlocks.BEAN_BRICK_SLAB);
                    entries.add(ModBlocks.BEAN_PILLAR);
                    entries.add(ModBlocks.CRACKED_BEAN_PILLAR);
                    entries.add(ModBlocks.BEAN_PEDESTAL);

                    entries.add(ModBlocks.BEANSTONE_MONOLITH);

                    entries.add(ModItems.ZEPHORINE_SHARD);
                    entries.add(ModItems.UNCUT_ZEPHORINE_SHARD);

                    entries.add(ModBlocks.ZEPHORINE_ORE);
                    entries.add(ModBlocks.DEEPSLATE_ZEPHORINE_ORE);
                    entries.add(ModBlocks.NETHER_ZEPHORINE_ORE);
                    entries.add(ModBlocks.END_STONE_ZEPHORINE_ORE);
                    entries.add(ModBlocks.ZEPHORINE_SHARD_BLOCK);
                    entries.add(ModBlocks.UNCUT_ZEPHORINE_SHARD_BLOCK);

                    entries.add(ModItems.ELITE_BEAN_HELMET);
                    entries.add(ModItems.ELITE_BEAN_CHESTPLATE);
                    entries.add(ModItems.ELITE_BEAN_LEGGINGS);
                    entries.add(ModItems.ELITE_BEAN_BOOTS);

                    entries.add(ModItems.VALIDUS_BEANORUM);
                    }).build());


    public static void registerItemGroups() {
    }
}
