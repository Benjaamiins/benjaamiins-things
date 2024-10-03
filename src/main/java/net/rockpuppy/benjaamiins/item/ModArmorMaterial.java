package net.rockpuppy.benjaamiins.item;

import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.recipe.Ingredient;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

public class ModArmorMaterial {
    public static final RegistryEntry<ArmorMaterial> BEAN = registerMaterial("bean", Map.of(
            ArmorItem.Type.HELMET, 5,
            ArmorItem.Type.CHESTPLATE, 10,
            ArmorItem.Type.LEGGINGS, 8,
            ArmorItem.Type.BOOTS, 5
    ),
    20,
            SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND,
            () -> Ingredient.ofItems(ModItems.BEAN),
            4.0f,
            0.2f,
            false);
    public static final RegistryEntry<ArmorMaterial> BENJAMINIUM = registerMaterial("benjaminium", Map.of(
                    ArmorItem.Type.HELMET, 3,
                    ArmorItem.Type.CHESTPLATE, 8,
                    ArmorItem.Type.LEGGINGS, 6,
                    ArmorItem.Type.BOOTS, 3
            ),
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.ofItems(ModItems.BENJAMINIUM_SHARD),
            3.0f,
            0.1f,
            false);
    public static final RegistryEntry<ArmorMaterial> ELITE_BEAN = registerMaterial("elite_bean", Map.of(
                    ArmorItem.Type.HELMET, 5,
                    ArmorItem.Type.CHESTPLATE, 10,
                    ArmorItem.Type.LEGGINGS, 8,
                    ArmorItem.Type.BOOTS, 5
            ),
            20,
            SoundEvents.ITEM_ARMOR_EQUIP_NETHERITE,
            () -> Ingredient.ofItems(ModItems.BENJAMINIUM_SHARD),
            4.0f,
            0.2f,
            false);



    public static RegistryEntry<ArmorMaterial> registerMaterial(String id, Map<ArmorItem.Type, Integer> defensePoints, int enchantability, RegistryEntry<SoundEvent> equipSound, Supplier<Ingredient> repairIngredientSupplier, float toughness, float knockbackResistance, boolean dyeable) {
        List<ArmorMaterial.Layer> layers = List.of(
                new ArmorMaterial.Layer(Identifier.of(Benjaamiins.MOD_ID, id), "", dyeable)
        );

        ArmorMaterial material = new ArmorMaterial(defensePoints, enchantability, equipSound, repairIngredientSupplier, layers, toughness, knockbackResistance);

        material = Registry.register(Registries.ARMOR_MATERIAL, Identifier.of(Benjaamiins.MOD_ID, id), material);

        return RegistryEntry.of(material);
    }

    public static void initialize() {};
}
