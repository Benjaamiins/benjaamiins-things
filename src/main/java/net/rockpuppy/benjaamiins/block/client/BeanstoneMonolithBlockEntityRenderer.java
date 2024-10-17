package net.rockpuppy.benjaamiins.block.client;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BeaconBlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.Benjaamiins;
import net.rockpuppy.benjaamiins.block.entity.BeanstoneMonolithBlockEntity;

@Environment(EnvType.CLIENT)
public class BeanstoneMonolithBlockEntityRenderer implements BlockEntityRenderer<BeanstoneMonolithBlockEntity>  {
    private static final Identifier BEAM_TEXTURE = Identifier.of(Benjaamiins.MOD_ID, "textures/entity/bean_beam.png");

    public BeanstoneMonolithBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(BeanstoneMonolithBlockEntity entity, float f, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, int j) {
        long worldTime = entity.getWorld().getTime();
        BeaconBlockEntityRenderer.renderBeam(matrixStack, vertexConsumerProvider, BEAM_TEXTURE, f, 1, worldTime, 0, 512, new float[] {1.0f, 0.45f, 0.0f, 1.0f}, 0.15F, 0.175F);
    }

    @Override
    public int getRenderDistance() {
        return 128;
    }
}
