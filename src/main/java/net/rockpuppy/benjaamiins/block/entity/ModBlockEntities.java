package net.rockpuppy.benjaamiins.block.entity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.block.ModBlocks;


public class ModBlockEntities {
    public static final BlockEntityType<BeanPedestalBlockEntity> BEAN_PEDESTAL =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Benjaamiins.MOD_ID, "bean_pedestal"),
                    FabricBlockEntityTypeBuilder.create(BeanPedestalBlockEntity::new,
                            ModBlocks.BEAN_PEDESTAL).build());

    public static final BlockEntityType<BeanstoneMonolithBlockEntity> BEANSTONE_MONOLITH =
            Registry.register(Registries.BLOCK_ENTITY_TYPE, new Identifier(Benjaamiins.MOD_ID, "beanstone_monolith"),
                    FabricBlockEntityTypeBuilder.create(BeanstoneMonolithBlockEntity::new,
                            ModBlocks.BEANSTONE_MONOLITH).build());

    public static void onInitialize() {
    }
}
