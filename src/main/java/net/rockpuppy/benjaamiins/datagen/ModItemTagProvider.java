package net.rockpuppy.benjaamiins.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.rockpuppy.benjaamiins.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.PICKAXES).add(ModItems.BEAN_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SWORDS).add(ModItems.BEAN_SWORD);
        getOrCreateTagBuilder(ItemTags.AXES).add(ModItems.BEAN_AXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS).add(ModItems.BEAN_SHOVEL);
        getOrCreateTagBuilder(ItemTags.HOES).add(ModItems.BEAN_HOE);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ModItems.BEAN_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ModItems.BEAN_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ModItems.BEAN_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ModItems.BEAN_BOOTS);
        getOrCreateTagBuilder(ItemTags.HEAD_ARMOR).add(ModItems.BENJAMINIUM_HELMET);
        getOrCreateTagBuilder(ItemTags.CHEST_ARMOR).add(ModItems.BENJAMINIUM_CHESTPLATE);
        getOrCreateTagBuilder(ItemTags.LEG_ARMOR).add(ModItems.BENJAMINIUM_LEGGINGS);
        getOrCreateTagBuilder(ItemTags.FOOT_ARMOR).add(ModItems.BENJAMINIUM_BOOTS);
    }
}
