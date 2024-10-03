package net.rockpuppy.benjaamiins.block.client;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.LightmapTextureManager;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRenderer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.render.model.json.ModelTransformationMode;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.LightType;
import net.minecraft.world.World;
import net.rockpuppy.benjaamiins.block.entity.BeanPedestalBlockEntity;
import org.joml.Quaternionf;


public class BeanPedestalBlockEntityRenderer implements BlockEntityRenderer<BeanPedestalBlockEntity> {

    public BeanPedestalBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(BeanPedestalBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
        ItemRenderer itemRenderer = MinecraftClient.getInstance().getItemRenderer();

        ItemStack itemStack = entity.getRenderStack();
        matrices.push();

        long worldTime = entity.getWorld().getTime();
        float rotation = (worldTime + tickDelta) % 360 * 2;
        double bobbingOffset = Math.sin((worldTime + tickDelta) * 0.1) * 0.1;

        matrices.translate(0.5f, 1.4f + bobbingOffset, 0.5f);
        matrices.multiply(new Quaternionf().rotateY((float) Math.toRadians(rotation)));
        matrices.scale(1.5f, 1.5f, 1.5f);

        itemRenderer.renderItem(itemStack, ModelTransformationMode.GROUND, light, overlay, matrices, vertexConsumers, entity.getWorld(), getLightLevel(entity.getWorld(), entity.getPos()));
        matrices.pop();
    }

    private int getLightLevel(World world, BlockPos pos) {
        int bLight = world.getLightLevel(LightType.BLOCK, pos);
        int sLight = world.getLightLevel(LightType.SKY, pos);
        return LightmapTextureManager.pack(bLight, sLight);
    }
}
