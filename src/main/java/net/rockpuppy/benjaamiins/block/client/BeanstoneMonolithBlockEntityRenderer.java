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
import net.rockpuppy.benjaamiins.block.entity.BeanstoneMonolithBlockEntity;
import org.joml.Quaternionf;


public class BeanstoneMonolithBlockEntityRenderer implements BlockEntityRenderer<BeanstoneMonolithBlockEntity> {

    public BeanstoneMonolithBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
    }

    @Override
    public void render(BeanstoneMonolithBlockEntity entity, float tickDelta, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay) {
    }
}
