package net.rockpuppy.benjaamiins.entity.client;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.SinglePartEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.MathHelper;
import net.rockpuppy.benjaamiins.animation.ModAnimations;
import net.rockpuppy.benjaamiins.entity.custom.BeanGodEntity;

public class BeanGodModel<T extends BeanGodEntity> extends SinglePartEntityModel<T> {
	private final ModelPart bean_god;
	private final ModelPart head;

	public BeanGodModel(ModelPart root) {
		this.bean_god = root.getChild("bean_god");
		this.head = bean_god.getChild("body").getChild("head");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bean_god = modelPartData.addChild("bean_god", ModelPartBuilder.create(), ModelTransform.pivot(-5.0F, 24.0F, 1.3545F));

		ModelPartData body = bean_god.addChild("body", ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -41.0F, -6.0F, 18.0F, 22.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 0.0F, 0.0F));

		ModelPartData right_leg = body.addChild("right_leg", ModelPartBuilder.create(), ModelTransform.pivot(10.0F, -19.0F, -2.0045F));

		ModelPartData muscle_r1 = right_leg.addChild("muscle_r1", ModelPartBuilder.create().uv(16, 72).cuboid(-2.0F, -9.0924F, -3.7257F, 4.0F, 9.0F, 8.0F, new Dilation(-0.1F))
				.uv(40, 78).cuboid(-3.0F, -9.0924F, -2.7257F, 6.0F, 10.0F, 6.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, 7.75F, 0.5455F, -0.1309F, 0.0F, 0.0F));

		ModelPartData right_lower_leg = right_leg.addChild("right_lower_leg", ModelPartBuilder.create().uv(33, 45).cuboid(-3.0F, 9.0F, -6.9955F, 6.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 1.0F));

		ModelPartData Leg_r1 = right_lower_leg.addChild("Leg_r1", ModelPartBuilder.create().uv(85, 37).cuboid(-3.11F, -7.1F, -2.9F, 6.0F, 10.0F, 6.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, 7.0F, 0.2955F, 0.0873F, 0.0F, 0.0F));

		ModelPartData Left_leg = body.addChild("Left_leg", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, -19.0F, -2.0045F));

		ModelPartData muscle_r2 = Left_leg.addChild("muscle_r2", ModelPartBuilder.create().uv(67, 26).cuboid(-2.0F, -9.0924F, -3.7257F, 4.0F, 9.0F, 8.0F, new Dilation(-0.1F))
				.uv(77, 54).cuboid(-3.0F, -9.0924F, -2.7257F, 6.0F, 10.0F, 6.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, 7.75F, 0.5455F, -0.1309F, 0.0F, 0.0F));

		ModelPartData left_lower_leg = Left_leg.addChild("left_lower_leg", ModelPartBuilder.create().uv(44, 32).cuboid(-3.0F, 9.0F, -6.9955F, 6.0F, 2.0F, 11.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, 8.0F, 1.0F));

		ModelPartData Leg_r2 = left_lower_leg.addChild("Leg_r2", ModelPartBuilder.create().uv(80, 0).cuboid(-2.89F, -7.1F, -2.9F, 6.0F, 10.0F, 6.0F, new Dilation(-0.1F)), ModelTransform.of(0.0F, 7.0F, 0.2955F, 0.0873F, 0.0F, 0.0F));

		ModelPartData right_arm = body.addChild("right_arm", ModelPartBuilder.create(), ModelTransform.of(17.0F, -38.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData arm_muscle_r1 = right_arm.addChild("arm_muscle_r1", ModelPartBuilder.create().uv(68, 70).cuboid(0.0F, 0.0F, -3.9999F, 4.0F, 10.0F, 8.0F, new Dilation(0.0F))
				.uv(56, 0).cuboid(-1.0F, -2.0F, -3.0F, 6.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -1.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		ModelPartData right_lower_arm = right_arm.addChild("right_lower_arm", ModelPartBuilder.create(), ModelTransform.of(0.0F, 11.0F, 2.0F, 0.2182F, 0.0F, 0.0F));

		ModelPartData lower_arm_r1 = right_lower_arm.addChild("lower_arm_r1", ModelPartBuilder.create().uv(86, 82).cuboid(-2.52F, -2.0F, -3.0F, 5.0F, 12.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.3054F, 0.0F, 0.0F));

		ModelPartData Left_arm = body.addChild("Left_arm", ModelPartBuilder.create(), ModelTransform.of(-7.0F, -38.0F, -1.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData arm_muscle_r2 = Left_arm.addChild("arm_muscle_r2", ModelPartBuilder.create().uv(52, 60).cuboid(0.0F, 0.0F, -3.9999F, 4.0F, 10.0F, 8.0F, new Dilation(0.0F))
				.uv(0, 55).cuboid(-1.0F, -2.0F, -3.0F, 6.0F, 14.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(-2.0F, -1.0F, 0.0F, 0.2182F, 0.0F, 0.0F));

		ModelPartData left_lower_arm = Left_arm.addChild("left_lower_arm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 11.0F, 2.0F));

		ModelPartData lower_arm_r2 = left_lower_arm.addChild("lower_arm_r2", ModelPartBuilder.create().uv(0, 83).cuboid(-2.48F, -2.0F, -3.0F, 5.0F, 12.0F, 6.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, -0.0873F, 0.0F, 0.0F));

		ModelPartData head = body.addChild("head", ModelPartBuilder.create().uv(46, 0).cuboid(-5.0F, -11.0F, -5.65F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(0, 32).cuboid(-6.0F, -13.0F, -5.2955F, 12.0F, 13.0F, 10.0F, new Dilation(0.0F))
				.uv(18, 55).cuboid(1.0F, -11.0F, -5.65F, 4.0F, 4.0F, 2.0F, new Dilation(0.0F))
				.uv(34, 39).cuboid(-5.0F, -5.25F, -5.5F, 10.0F, 2.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, -41.0F, -0.7045F));

		ModelPartData right_eyebrow = head.addChild("right_eyebrow", ModelPartBuilder.create(), ModelTransform.pivot(3.5F, -11.0F, -5.65F));

		ModelPartData eyebrow_r1 = right_eyebrow.addChild("eyebrow_r1", ModelPartBuilder.create().uv(56, 29).cuboid(-3.0F, -1.0F, -0.1F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2618F));

		ModelPartData left_eyebrow = head.addChild("left_eyebrow", ModelPartBuilder.create(), ModelTransform.pivot(-3.5F, -11.0F, -5.65F));

		ModelPartData eyebrow_r2 = left_eyebrow.addChild("eyebrow_r2", ModelPartBuilder.create().uv(56, 26).cuboid(-2.0F, -1.0F, -0.1F, 5.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2618F));

		ModelPartData mouth = head.addChild("mouth", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 41.0F, -0.4F));

		ModelPartData cube_r1 = mouth.addChild("cube_r1", ModelPartBuilder.create().uv(0, 0).cuboid(-2.5F, -1.0F, -0.3545F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(2.4F, -44.0F, -4.6455F, 0.0F, 0.0F, 0.1309F));

		ModelPartData cube_r2 = mouth.addChild("cube_r2", ModelPartBuilder.create().uv(0, 4).cuboid(-0.5F, -1.0F, -0.3545F, 3.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(-2.3F, -44.0F, -4.6455F, 0.0F, 0.0F, -0.1309F));

		ModelPartData Crown = head.addChild("Crown", ModelPartBuilder.create().uv(24, 58).cuboid(8.0F, -57.0F, -5.6455F, 2.0F, 2.0F, 12.0F, new Dilation(0.0F))
				.uv(55, 46).cuboid(-5.0F, -57.0F, -5.6455F, 2.0F, 2.0F, 12.0F, new Dilation(0.0F))
				.uv(101, 60).cuboid(-3.0F, -57.0F, 4.3545F, 11.0F, 2.0F, 2.0F, new Dilation(0.0F))
				.uv(98, 0).cuboid(-3.0F, -57.0F, -5.6455F, 11.0F, 2.0F, 2.0F, new Dilation(0.0F)), ModelTransform.pivot(-2.5F, 42.0F, -0.65F));

		ModelPartData horn = Crown.addChild("horn", ModelPartBuilder.create().uv(48, 114).cuboid(-1.0F, -7.2995F, 1.7937F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(36, 114).cuboid(-1.0F, -9.8995F, 1.7937F, 2.0F, 3.0F, 2.0F, new Dilation(-0.3F))
				.uv(114, 25).cuboid(-1.0F, -11.8995F, 1.7937F, 2.0F, 3.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.of(2.5F, -50.65F, -5.3F, 0.48F, 0.0F, 0.0F));

		ModelPartData horn2 = Crown.addChild("horn2", ModelPartBuilder.create().uv(16, 118).cuboid(-1.4799F, -8.0013F, 1.0363F, 2.0F, 3.0F, 2.0F, new Dilation(-0.1F))
				.uv(8, 118).cuboid(-1.4799F, -10.3013F, 1.0363F, 2.0F, 3.0F, 2.0F, new Dilation(-0.3F))
				.uv(50, 119).cuboid(-1.4799F, -12.3013F, 1.0363F, 2.0F, 3.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.of(6.0F, -50.0F, -4.8F, 0.3481F, -0.0226F, 0.0843F));

		ModelPartData horn3 = Crown.addChild("horn3", ModelPartBuilder.create().uv(118, 4).cuboid(-0.5201F, -8.0013F, 1.0363F, 2.0F, 3.0F, 2.0F, new Dilation(-0.1F))
				.uv(0, 118).cuboid(-0.5201F, -10.3013F, 1.0363F, 2.0F, 3.0F, 2.0F, new Dilation(-0.3F))
				.uv(32, 119).cuboid(-0.5201F, -12.3013F, 1.0363F, 2.0F, 3.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.of(-1.0F, -50.0F, -4.8F, 0.3481F, 0.0226F, -0.0843F));

		ModelPartData horn4 = Crown.addChild("horn4", ModelPartBuilder.create().uv(116, 85).cuboid(-0.5201F, -8.1848F, 0.4561F, 2.0F, 3.0F, 2.0F, new Dilation(-0.15F))
				.uv(116, 72).cuboid(-0.5201F, -10.1848F, 0.4561F, 2.0F, 3.0F, 2.0F, new Dilation(-0.35F))
				.uv(117, 110).cuboid(-0.5201F, -11.8848F, 0.4561F, 2.0F, 3.0F, 2.0F, new Dilation(-0.65F)), ModelTransform.of(-4.1F, -50.0F, -4.8F, 0.2608F, 0.0226F, -0.0843F));

		ModelPartData horn5 = Crown.addChild("horn5", ModelPartBuilder.create().uv(87, 113).cuboid(-1.4799F, -8.1848F, 0.4561F, 2.0F, 3.0F, 2.0F, new Dilation(-0.15F))
				.uv(8, 113).cuboid(-1.4799F, -10.1848F, 0.4561F, 2.0F, 3.0F, 2.0F, new Dilation(-0.35F))
				.uv(103, 117).cuboid(-1.4799F, -11.8848F, 0.4561F, 2.0F, 3.0F, 2.0F, new Dilation(-0.65F)), ModelTransform.of(9.1F, -50.0F, -4.8F, 0.2608F, -0.0226F, 0.0843F));

		ModelPartData horn6 = Crown.addChild("horn6", ModelPartBuilder.create().uv(56, 50).cuboid(-3.5036F, -8.0269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(56, 45).cuboid(-3.5036F, -9.8269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(68, 88).cuboid(-3.5036F, -11.3269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(9.9F, -50.0F, -2.8F, 0.0F, 0.0F, 0.3491F));

		ModelPartData horn8 = Crown.addChild("horn8", ModelPartBuilder.create().uv(11, 101).cuboid(-3.5036F, -8.0269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(48, 100).cuboid(-3.5036F, -9.8269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(116, 95).cuboid(-3.5036F, -11.3269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(9.9F, -50.0F, 0.0F, 0.0F, 0.0F, 0.3491F));

		ModelPartData horn9 = Crown.addChild("horn9", ModelPartBuilder.create().uv(84, 70).cuboid(-3.5036F, -8.0269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(58, 78).cuboid(-3.5036F, -9.8269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(116, 67).cuboid(-3.5036F, -11.3269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(9.9F, -50.0F, 2.8F, 0.0F, 0.0F, 0.3491F));

		ModelPartData horn10 = Crown.addChild("horn10", ModelPartBuilder.create().uv(95, 115).cuboid(-2.9212F, -7.9802F, -3.1056F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(114, 80).cuboid(-2.9212F, -9.7802F, -3.1056F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(62, 117).cuboid(-2.9212F, -11.2802F, -3.1056F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(9.3F, -49.7F, 5.9F, -0.2618F, 0.0F, 0.2618F));

		ModelPartData horn11 = Crown.addChild("horn11", ModelPartBuilder.create().uv(0, 113).cuboid(-1.1094F, -8.0269F, -3.7498F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(109, 112).cuboid(-1.1094F, -9.8269F, -3.7498F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(101, 112).cuboid(-1.1094F, -11.3269F, -3.7498F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(6.1F, -49.7F, 6.2F, -0.3491F, 0.0F, 0.0F));

		ModelPartData horn13 = Crown.addChild("horn13", ModelPartBuilder.create().uv(14, 75).cuboid(-1.0F, -8.0269F, -3.7498F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(74, 0).cuboid(-1.0F, -9.8269F, -3.7498F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(71, 52).cuboid(-1.0F, -11.3269F, -3.7498F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(2.5F, -49.7F, 6.2F, -0.3491F, 0.0F, 0.0F));

		ModelPartData horn15 = Crown.addChild("horn15", ModelPartBuilder.create().uv(109, 44).cuboid(-0.9906F, -8.0269F, -3.7498F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(109, 39).cuboid(-0.9906F, -9.8269F, -3.7498F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(108, 95).cuboid(-0.9906F, -11.3269F, -3.7498F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(-0.9F, -49.7F, 6.2F, -0.3491F, 0.0F, 0.0F));

		ModelPartData horn16 = Crown.addChild("horn16", ModelPartBuilder.create().uv(56, 114).cuboid(0.9212F, -7.9802F, -3.1056F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(114, 49).cuboid(0.9212F, -9.7802F, -3.1056F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(117, 44).cuboid(0.9212F, -11.2802F, -3.1056F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(-4.3F, -49.7F, 5.9F, -0.2618F, 0.0F, -0.2618F));

		ModelPartData horn7 = Crown.addChild("horn7", ModelPartBuilder.create().uv(68, 60).cuboid(1.5036F, -8.0269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(24, 64).cuboid(1.5036F, -9.8269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(115, 115).cuboid(1.5036F, -11.3269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(-4.9F, -50.0F, 2.8F, 0.0F, 0.0F, -0.3491F));

		ModelPartData horn12 = Crown.addChild("horn12", ModelPartBuilder.create().uv(30, 89).cuboid(1.5036F, -8.0269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(22, 89).cuboid(1.5036F, -9.8269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(116, 90).cuboid(1.5036F, -11.3269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(-4.9F, -50.0F, 0.0F, 0.0F, 0.0F, -0.3491F));

		ModelPartData horn14 = Crown.addChild("horn14", ModelPartBuilder.create().uv(0, 37).cuboid(1.5036F, -8.0269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.2F))
				.uv(0, 32).cuboid(1.5036F, -9.8269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.4F))
				.uv(28, 59).cuboid(1.5036F, -11.3269F, -0.6556F, 2.0F, 3.0F, 2.0F, new Dilation(-0.7F)), ModelTransform.of(-4.9F, -50.0F, -2.8F, 0.0F, 0.0F, -0.3491F));

		ModelPartData Muscles = body.addChild("Muscles", ModelPartBuilder.create().uv(40, 59).cuboid(0.5F, -40.0F, -4.0F, 7.0F, 6.0F, 1.0F, new Dilation(0.0F))
				.uv(0, 75).cuboid(-6.5F, -33.0F, -4.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F))
				.uv(104, 4).cuboid(0.5F, -33.0F, -4.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F))
				.uv(71, 45).cuboid(-6.5F, -26.0F, -4.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F))
				.uv(32, 72).cuboid(0.5F, -26.0F, -4.0F, 6.0F, 6.0F, 1.0F, new Dilation(0.0F))
				.uv(34, 32).cuboid(-7.5F, -40.0F, -4.0F, 7.0F, 6.0F, 1.0F, new Dilation(0.0F)), ModelTransform.pivot(5.0F, 0.0F, -2.7089F));

		ModelPartData left_shoulder_armor = body.addChild("left_shoulder_armor", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 0.0F, -1.3545F));

		ModelPartData cube_r3 = left_shoulder_armor.addChild("cube_r3", ModelPartBuilder.create().uv(0, 101).cuboid(-1.0684F, -0.9558F, -4.0F, 2.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-11.1F, -41.4F, 4.75F, 1.7017F, 1.3963F, 1.5708F));

		ModelPartData cube_r4 = left_shoulder_armor.addChild("cube_r4", ModelPartBuilder.create().uv(101, 100).cuboid(-1.0684F, -0.9558F, -3.0F, 2.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(-11.1F, -41.4F, -3.75F, -1.7017F, -1.3963F, 1.5708F));

		ModelPartData cube_r5 = left_shoulder_armor.addChild("cube_r5", ModelPartBuilder.create().uv(55, 85).cuboid(-1.0684F, -0.9558F, -4.0F, 2.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(-14.85F, -41.15F, 0.0F, 0.0F, 0.0F, 0.1745F));

		ModelPartData cube_r6 = left_shoulder_armor.addChild("cube_r6", ModelPartBuilder.create().uv(95, 53).cuboid(-3.017F, -1.7389F, -5.0F, 7.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -41.0F, 5.0F, -0.2182F, 0.0F, -0.1309F));

		ModelPartData cube_r7 = left_shoulder_armor.addChild("cube_r7", ModelPartBuilder.create().uv(100, 11).cuboid(-3.0171F, -1.7389F, 0.0F, 7.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(-12.0F, -41.0F, -4.0F, 0.2182F, 0.0F, -0.1309F));

		ModelPartData horn20 = left_shoulder_armor.addChild("horn20", ModelPartBuilder.create().uv(87, 107).cuboid(-0.9674F, -3.0883F, -0.8885F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(102, 82).cuboid(-0.9674F, -5.6883F, -0.8885F, 2.0F, 3.0F, 2.0F, new Dilation(-0.3F))
				.uv(101, 64).cuboid(-0.9674F, -7.6883F, -0.8885F, 2.0F, 3.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.of(-9.75F, -42.9F, 0.45F, 0.0F, 0.0F, -0.1309F));

		ModelPartData horn21 = left_shoulder_armor.addChild("horn21", ModelPartBuilder.create().uv(85, 118).cuboid(-0.9554F, -3.2428F, -0.7137F, 2.0F, 3.0F, 2.0F, new Dilation(-0.1F))
				.uv(24, 118).cuboid(-0.9554F, -5.5428F, -0.7137F, 2.0F, 3.0F, 2.0F, new Dilation(-0.3F))
				.uv(119, 54).cuboid(-0.9554F, -7.5428F, -0.7137F, 2.0F, 3.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.of(-12.0F, -41.75F, 0.25F, 0.0F, 0.0F, -0.2618F));

		ModelPartData horn22 = left_shoulder_armor.addChild("horn22", ModelPartBuilder.create().uv(93, 110).cuboid(-0.9245F, -3.1658F, -0.7439F, 2.0F, 3.0F, 2.0F, new Dilation(-0.15F))
				.uv(109, 64).cuboid(-0.9245F, -5.1658F, -0.7439F, 2.0F, 3.0F, 2.0F, new Dilation(-0.35F))
				.uv(117, 39).cuboid(-0.9245F, -6.8658F, -0.7439F, 2.0F, 3.0F, 2.0F, new Dilation(-0.65F)), ModelTransform.of(-14.1F, -41.0F, 0.2F, 0.0F, 0.0F, -0.3927F));

		ModelPartData right_shoulder_armor = body.addChild("right_shoulder_armor", ModelPartBuilder.create(), ModelTransform.pivot(5.0F, 0.0F, -1.3545F));

		ModelPartData cube_r8 = right_shoulder_armor.addChild("cube_r8", ModelPartBuilder.create().uv(51, 102).cuboid(-0.9316F, -0.9558F, -4.0F, 2.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(11.1F, -41.4F, 4.75F, 1.7017F, -1.3963F, -1.5708F));

		ModelPartData cube_r9 = right_shoulder_armor.addChild("cube_r9", ModelPartBuilder.create().uv(103, 27).cuboid(-0.9316F, -0.9558F, -3.0F, 2.0F, 5.0F, 7.0F, new Dilation(0.0F)), ModelTransform.of(11.1F, -41.4F, -3.75F, -1.7017F, 1.3963F, -1.5708F));

		ModelPartData cube_r10 = right_shoulder_armor.addChild("cube_r10", ModelPartBuilder.create().uv(87, 17).cuboid(-0.9316F, -0.9558F, -4.0F, 2.0F, 8.0F, 9.0F, new Dilation(0.0F)), ModelTransform.of(14.85F, -41.15F, 0.0F, 0.0F, 0.0F, -0.1745F));

		ModelPartData cube_r11 = right_shoulder_armor.addChild("cube_r11", ModelPartBuilder.create().uv(100, 18).cuboid(-3.983F, -1.7389F, -5.0F, 7.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, -41.0F, 5.0F, -0.2182F, 0.0F, 0.1309F));

		ModelPartData cube_r12 = right_shoulder_armor.addChild("cube_r12", ModelPartBuilder.create().uv(84, 100).cuboid(-3.9829F, -1.7389F, 0.0F, 7.0F, 2.0F, 5.0F, new Dilation(0.0F)), ModelTransform.of(12.0F, -41.0F, -4.0F, 0.2182F, 0.0F, 0.1309F));

		ModelPartData horn17 = right_shoulder_armor.addChild("horn17", ModelPartBuilder.create().uv(108, 90).cuboid(-1.0326F, -3.0883F, -0.8885F, 2.0F, 3.0F, 2.0F, new Dilation(0.0F))
				.uv(108, 85).cuboid(-1.0326F, -5.6883F, -0.8885F, 2.0F, 3.0F, 2.0F, new Dilation(-0.3F))
				.uv(36, 108).cuboid(-1.0326F, -7.6883F, -0.8885F, 2.0F, 3.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.of(9.75F, -42.9F, 0.45F, 0.0F, 0.0F, 0.1309F));

		ModelPartData horn18 = right_shoulder_armor.addChild("horn18", ModelPartBuilder.create().uv(119, 18).cuboid(-1.0446F, -3.2428F, -0.7137F, 2.0F, 3.0F, 2.0F, new Dilation(-0.1F))
				.uv(119, 9).cuboid(-1.0446F, -5.5428F, -0.7137F, 2.0F, 3.0F, 2.0F, new Dilation(-0.3F))
				.uv(70, 119).cuboid(-1.0446F, -7.5428F, -0.7137F, 2.0F, 3.0F, 2.0F, new Dilation(-0.6F)), ModelTransform.of(12.0F, -41.75F, 0.25F, 0.0F, 0.0F, 0.2618F));

		ModelPartData horn19 = right_shoulder_armor.addChild("horn19", ModelPartBuilder.create().uv(112, 100).cuboid(-1.0755F, -3.1658F, -0.7439F, 2.0F, 3.0F, 2.0F, new Dilation(-0.15F))
				.uv(42, 111).cuboid(-1.0755F, -5.1658F, -0.7439F, 2.0F, 3.0F, 2.0F, new Dilation(-0.35F))
				.uv(42, 117).cuboid(-1.0755F, -6.8658F, -0.7439F, 2.0F, 3.0F, 2.0F, new Dilation(-0.65F)), ModelTransform.of(14.1F, -41.0F, 0.2F, 0.0F, 0.0F, 0.3927F));

		ModelPartData skirt = body.addChild("skirt", ModelPartBuilder.create().uv(56, 23).cuboid(-10.0F, -2.0F, 0.0F, 19.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(22, 94).cuboid(-6.5F, 0.0F, 0.0F, 12.0F, 12.0F, 0.0F, new Dilation(0.0F))
				.uv(56, 20).cuboid(-10.0F, -2.0F, 11.0F, 19.0F, 2.0F, 1.0F, new Dilation(0.0F))
				.uv(36, 96).cuboid(8.0F, -2.0F, 1.0F, 1.0F, 2.0F, 10.0F, new Dilation(0.0F))
				.uv(67, 92).cuboid(-10.0F, -2.0F, 1.0F, 1.0F, 2.0F, 10.0F, new Dilation(0.0F)), ModelTransform.pivot(5.5F, -20.9F, -7.0F));

		ModelPartData cube_r13 = skirt.addChild("cube_r13", ModelPartBuilder.create().uv(18, 106).cuboid(-6.0F, -2.0F, -1.0F, 9.0F, 12.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(7.9F, 2.0F, 7.5F, 0.0F, -1.5708F, 0.0F));

		ModelPartData cube_r14 = skirt.addChild("cube_r14", ModelPartBuilder.create().uv(69, 107).cuboid(-6.0F, -2.0F, -1.0F, 9.0F, 12.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-8.9F, 2.0F, 4.5F, 0.0F, 1.5708F, 0.0F));

		ModelPartData cube_r15 = skirt.addChild("cube_r15", ModelPartBuilder.create().uv(92, 70).cuboid(-6.0F, -2.0F, -1.0F, 12.0F, 12.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(-0.5F, 2.0F, 11.0F, 0.0F, 3.1416F, 0.0F));
		return TexturedModelData.of(modelData, 128, 128);
	}

	@Override
	public void setAngles(BeanGodEntity entity , float limbSwing, float limbSwingAmount, float animationProgress, float headYaw, float headPitch) {
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.setHeadAngles(headYaw, headPitch);

		this.animateMovement(ModAnimations.BEAN_MASTER_WALK, limbSwing, limbSwingAmount, 2.0f, 2.5f);
		this.updateAnimation(entity.idleAnimationState, ModAnimations.BEAN_MASTER_IDLE, animationProgress, 1f);
	}

	private void setHeadAngles(float headYaw, float headPitch) {
		headYaw = MathHelper.clamp(headYaw, -30.0F, 30.0F);
		headPitch = MathHelper.clamp(headPitch, -25.0F, 45.0F);

		this.head.yaw = headYaw * 0.017453292F;
		this.head.pitch = headPitch * 0.017453292F;
	}

	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bean_god.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}

	@Override
	public ModelPart getPart() {
		return this.bean_god;
	}
}