package net.rockpuppy.benjaamiins.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.entity.custom.BeanGodEntity;

public class BeanGodRenderer extends MobEntityRenderer<BeanGodEntity, BeanGodModel<BeanGodEntity>> {

    public BeanGodRenderer(EntityRendererFactory.Context context) {
        super(context, new BeanGodModel<>(context.getPart(ModModelLayers.BEAN_GOD)), 0.6f);
    }

    @Override
    public Identifier getTexture(BeanGodEntity entity) {
        return Identifier.of(Benjaamiins.MOD_ID, "textures/entity/bean_god.png");
    }

    @Override
    public void render(BeanGodEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}