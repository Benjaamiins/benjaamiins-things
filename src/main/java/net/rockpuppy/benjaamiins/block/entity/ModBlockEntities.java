package net.rockpuppy.benjaamiins.block.entity;

import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.block.ModBlocks;


public class ModBlockEntities {
    public static <T extends BlockEntityType<?>> T register(String path, T blockEntityType) {
        return Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of("benjaamiins", path), blockEntityType);
    }

    public static final BlockEntityType<BeanPedestalBlockEntity> BEAN_PEDESTAL = register(
            "bean_pedestal",
            BlockEntityType.Builder.create(BeanPedestalBlockEntity::new, ModBlocks.BEAN_PEDESTAL).build()
    );

    public static final BlockEntityType<BeanstoneMonolithBlockEntity> BEANSTONE_MONOLITH = register(
            "beanstone_monolith",
            BlockEntityType.Builder.create(BeanstoneMonolithBlockEntity::new, ModBlocks.BEANSTONE_MONOLITH).build()
    );

    public static void onInitialize() {
    }
}
