package net.rockpuppy.benjaamiins.entity.client;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.entity.custom.BeanMasterEntity;

public class BeanMasterRenderer extends MobEntityRenderer<BeanMasterEntity, BeanMasterModel<BeanMasterEntity>> {

    public BeanMasterRenderer(EntityRendererFactory.Context context) {
        super(context, new BeanMasterModel<>(context.getPart(ModModelLayers.BEAN_MASTER)), 0.6f);
    }

    @Override
    public Identifier getTexture(BeanMasterEntity entity) {
        return Identifier.of(Benjaamiins.MOD_ID, "textures/entity/bean_master.png");
    }

    @Override
    public void render(BeanMasterEntity livingEntity, float f, float g, MatrixStack matrixStack,
                       VertexConsumerProvider vertexConsumerProvider, int i) {
        if (livingEntity.isBaby()) {
            matrixStack.scale(0.8f, 0.8f, 0.8f);
        } else {
            matrixStack.scale(1f, 1f, 1f);
        }

        super.render(livingEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }
}
