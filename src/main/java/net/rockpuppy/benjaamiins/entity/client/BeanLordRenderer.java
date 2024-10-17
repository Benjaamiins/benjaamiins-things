package net.rockpuppy.benjaamiins.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.entity.custom.BeanLordEntity;

public class BeanLordRenderer extends MobEntityRenderer<BeanLordEntity, BeanLordModel<BeanLordEntity>> {

    public BeanLordRenderer(EntityRendererFactory.Context context) {
        super(context, new BeanLordModel<>(context.getPart(ModModelLayers.BEAN_LORD)), 0.6f);
    }

    @Override
    public Identifier getTexture(BeanLordEntity entity) {
        return Identifier.of(Benjaamiins.MOD_ID, "textures/entity/bean_lord.png");
    }

    @Override
    public void render(BeanLordEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}