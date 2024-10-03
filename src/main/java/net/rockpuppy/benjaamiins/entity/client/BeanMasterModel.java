package net.rockpuppy.benjaamiins.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.rockpuppy.benjaamiins.animation.ModAnimations;
import net.rockpuppy.benjaamiins.entity.custom.BeanMasterEntity;

public class BeanMasterModel<T extends BeanMasterEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bean_master;
	private final ModelPart Head;

	public BeanMasterModel(ModelPart root) {
		this.bean_master = root.getChild("bean_master");
		this.Head = bean_master.getChild("body").getChild("Head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bean_master = modelPartData.addChild("bean_master", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, 24.0F, 1.3545F));

		ModelPartData body = bean_master.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-2.0F, -14.0F, -3.0F, 9.0F, 10.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData Right_leg = body.addChild("Right_leg", ModelPartBuilder.create().uv(23, 23).cuboid(-1.0F, 3.0F, -3.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -4.0F, -1.0F));

		ModelPartData Lower_leg_r1 = Right_leg.addChild("Lower_leg_r1", ModelPartBuilder.create().uv(32, 29).cuboid(-1.0F, -8.0F, -2.0F, 1.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(1.0F, 7.0F, 2.0F, 0.2183F, -0.0029F, 0.0039F));

		ModelPartData Left_leg = body.addChild("Left_leg", ModelPartBuilder.create().uv(23, 10).cuboid(-2.0F, 3.0F, -3.0F, 3.0F, 1.0F, 5.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -4.0F, -1.0F));

		ModelPartData Lower_leg_r2 = Left_leg.addChild("Lower_leg_r2", ModelPartBuilder.create().uv(28, 16).cuboid(-1.0F, -8.0F, -2.0F, 1.0F, 4.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 7.0F, 2.0F, 0.2183F, -0.0029F, 0.0039F));

		ModelPartData Right_arm = body.addChild("Right_arm", ModelPartBuilder.create(), ModelTransform.pivot(7.5F, -13.0F, -0.5F));

		ModelPartData Upper_arm_r1 = Right_arm.addChild("Upper_arm_r1", ModelPartBuilder.create().uv(8, 28).cuboid(-0.5F, -1.0F, -1.5F, 1.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		ModelPartData Lower_arm_r1 = Right_arm.addChild("Lower_arm_r1", ModelPartBuilder.create().uv(24, 29).cuboid(-0.51F, -1.0F, -1.5F, 1.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, 1.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData Left_arm = body.addChild("Left_arm", ModelPartBuilder.create(), ModelTransform.pivot(-2.5F, -13.0F, -0.5F));

		ModelPartData Upper_arm_r2 = Left_arm.addChild("Upper_arm_r2", ModelPartBuilder.create().uv(0, 28).cuboid(-0.5F, -1.0F, -1.5F, 1.0F, 7.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		ModelPartData Lower_arm_r2 = Left_arm.addChild("Lower_arm_r2", ModelPartBuilder.create().uv(16, 28).cuboid(-0.49F, -1.0F, -1.5F, 1.0F, 6.0F, 3.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 6.0F, 1.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData Head = body.addChild("Head", ModelPartBuilder.create().uv(23, 16).cuboid(-3.5F, -7.0F, -2.8955F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 15).cuboid(-4.5F, -8.0F, -2.6455F, 9.0F, 8.0F, 5.0F, new Dilation(0.0F))
				.uv(5, 28).cuboid(1.5F, -7.0F, -2.8955F, 2.0F, 2.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(2.5F, -14.0F, -0.3545F));
		return TexturedModelData.of(modelData, 64, 64);
	}

	@Override
	public void setAngles(BeanMasterEntity entity , float limbSwing, float limbSwingAmount, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		this.animateMovement(ModAnimations.BEAN_MASTER_WALK, limbSwing, limbSwingAmount, 20.0f, 20.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.BEAN_MASTER_IDLE, animationProgress, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.Head.yaw = headYaw * 0.017453292F;
		this.Head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertices, int light, int overlay, int color) {
		bean_master.render(matrices, vertices, light, overlay, color);
	}

	@Override
	public ModelPart getPart() {
		return this.bean_master;
	}
}