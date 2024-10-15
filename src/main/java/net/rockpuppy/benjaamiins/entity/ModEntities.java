package net.rockpuppy.benjaamiins.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.entity.custom.BeanLordEntity;
import net.rockpuppy.benjaamiins.entity.custom.BeanMasterEntity;

public class ModEntities {
    public static final EntityType<BeanMasterEntity> BEAN_MASTER = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Benjaamiins.MOD_ID, "bean_master"),
            EntityType.Builder.create(BeanMasterEntity::new, SpawnGroup.CREATURE).dimensions(0.6f, 1.5f).build("bean_master")
    );

    public static final EntityType<BeanLordEntity> BEAN_LORD = Registry.register(
            Registries.ENTITY_TYPE,
            Identifier.of(Benjaamiins.MOD_ID, "bean_lord"),
            EntityType.Builder.create(BeanLordEntity::new, SpawnGroup.CREATURE).dimensions(1.5f, 3.5f).build("bean_lord")
    );

    public static void registerModEntities() {
    }

}
