package net.rockpuppy.benjaamiins.item;

import net.fabricmc.fabric.api.registry.FuelRegistry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.entity.ModEntities;
import net.rockpuppy.benjaamiins.item.custom.EliteBeanArmorItem;

public class ModItems {

    public static final FoodComponent bean = new FoodComponent.Builder().alwaysEdible().hunger(5).saturationModifier(1).build();

    public static final Item BEAN = register("bean", new Item(new Item.Settings().food(bean)));

    public static final Item BEAN_PICKAXE = register("bean_pickaxe", new PickaxeItem(ModToolMaterial.BEAN, 2, 2.6f, new Item.Settings()));
    public static final Item BEAN_SWORD = register("bean_sword", new SwordItem(ModToolMaterial.BEAN, 11, 1.5f, new Item.Settings()));
    public static final Item BEAN_AXE = register("bean_axe", new AxeItem(ModToolMaterial.BEAN, 13, 2.6f, new Item.Settings()));
    public static final Item BEAN_SHOVEL = register("bean_shovel", new ShovelItem(ModToolMaterial.BEAN, 2, 3f, new Item.Settings()));
    public static final Item BEAN_HOE = register("bean_hoe", new HoeItem(ModToolMaterial.BEAN, 3, 1f, new Item.Settings()));

    public static final Item BEAN_HELMET = register("bean_helmet",
            new ArmorItem(ModArmorMaterial.BEAN, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item BEAN_CHESTPLATE = register("bean_chestplate",
            new ArmorItem(ModArmorMaterial.BEAN, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item BEAN_LEGGINGS = register("bean_leggings",
            new ArmorItem(ModArmorMaterial.BEAN, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item BEAN_BOOTS = register("bean_boots",
            new ArmorItem(ModArmorMaterial.BEAN, ArmorItem.Type.BOOTS, new Item.Settings()));

    public static final Item ELITE_BEAN_HELMET = register("elite_bean_helmet",
            new EliteBeanArmorItem(ModArmorMaterial.ELITE_BEAN, ArmorItem.Type.HELMET, new Item.Settings()));
    public static final Item ELITE_BEAN_CHESTPLATE = register("elite_bean_chestplate",
            new EliteBeanArmorItem(ModArmorMaterial.ELITE_BEAN, ArmorItem.Type.CHESTPLATE, new Item.Settings()));
    public static final Item ELITE_BEAN_LEGGINGS = register("elite_bean_leggings",
            new EliteBeanArmorItem(ModArmorMaterial.ELITE_BEAN, ArmorItem.Type.LEGGINGS, new Item.Settings()));
    public static final Item ELITE_BEAN_BOOTS = register("elite_bean_boots",
            new EliteBeanArmorItem(ModArmorMaterial.ELITE_BEAN, ArmorItem.Type.BOOTS, new Item.Settings()));

    public static final Item BEAN_MASTER_SPAWN_EGG = register("bean_master_spawn_egg", new SpawnEggItem(ModEntities.BEAN_MASTER, 0xff9c00, 0xff7400, new Item.Settings()));
    public static final Item BEAN_GOD_SPAWN_EGG = register("bean_god_spawn_egg", new SpawnEggItem(ModEntities.BEAN_GOD, 0xff7400, 0xff9c00, new Item.Settings()));
    public static final Item BENJAMINIUM_SHARD = register("benjaminium_shard", new Item(new Item.Settings()));
    public static final Item UNCUT_BENJAMINIUM_SHARD = register("uncut_benjaminium_shard", new Item(new Item.Settings()));
    public static final Item VALIDUS_BEANORUM = register("validus_beanorum", new Item(new Item.Settings()));

    public static Item register(String id, Item item) {
        Identifier itemID = Identifier.of(Benjaamiins.MOD_ID, id);
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);
        return registeredItem;
    }

    public static void initialize() {
        FuelRegistry.INSTANCE.add(ModItems.BEAN, 20);
    }

}