package net.rockpuppy.benjaamiins.entity.client;

import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;

public class ModModelLayers {
    public static final EntityModelLayer BEAN_MASTER =
            new EntityModelLayer(Identifier.of(Benjaamiins.MOD_ID, "bean_master"), "main");

    public static final EntityModelLayer BEAN_LORD =
            new EntityModelLayer(Identifier.of(Benjaamiins.MOD_ID, "bean_lord"), "main");
}
