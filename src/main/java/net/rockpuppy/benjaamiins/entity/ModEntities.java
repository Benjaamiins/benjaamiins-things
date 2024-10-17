package net.rockpuppy.benjaamiins.entity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.entity.custom.BeanLordEntity;
import net.rockpuppy.benjaamiins.entity.custom.BeanMasterEntity;

public class ModEntities {
    public static final EntityType<BeanMasterEntity> BEAN_MASTER = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Benjaamiins.MOD_ID, "bean_master"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BeanMasterEntity::new)
                    .dimensions(EntityDimensions.fixed(0.6f, 1.5f)).build());

    public static final EntityType<BeanLordEntity> BEAN_LORD = Registry.register(Registries.ENTITY_TYPE,
            new Identifier(Benjaamiins.MOD_ID, "bean_lord"),
            FabricEntityTypeBuilder.create(SpawnGroup.CREATURE, BeanLordEntity::new)
                    .dimensions(EntityDimensions.fixed(1.5f, 3.5f)).build());

    public static void registerModEntities() {
    }

}
