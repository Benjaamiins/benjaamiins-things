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
        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.BEAN_HELMET, ModItems.BEAN_CHESTPLATE, ModItems.BEAN_LEGGINGS, ModItems.BEAN_BOOTS);
    }
}
