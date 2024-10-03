package net.rockpuppy.benjaamiins.item.client;

import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.item.custom.EliteBeanArmorItem;
import software.bernie.geckolib.model.DefaultedItemGeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public final class EliteBeanArmorRenderer extends GeoArmorRenderer<EliteBeanArmorItem> {
    public EliteBeanArmorRenderer() {
        super(new DefaultedItemGeoModel<>(Identifier.of(Benjaamiins.MOD_ID, "armor/elite_bean_armor")));
    }
}
