package net.rockpuppy.benjaamiins.item.client;

import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.item.custom.EliteBeanArmorItem;
import software.bernie.geckolib.model.GeoModel;

public class EliteBeanArmorModel extends GeoModel<EliteBeanArmorItem> {
    @Override
    public Identifier getModelResource(EliteBeanArmorItem animatable) {
        return Identifier.of(Benjaamiins.MOD_ID, "geo/elite_bean_armor.geo.json");
    }

    @Override
    public Identifier getTextureResource(EliteBeanArmorItem animatable) {
        return Identifier.of(Benjaamiins.MOD_ID, "textures/armor/elite_bean_armor.png");
    }

    @Override
    public Identifier getAnimationResource(EliteBeanArmorItem animatable) {
        return Identifier.of(Benjaamiins.MOD_ID, "animations/elite_bean_armor.animation.json");
    }
}
