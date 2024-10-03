package net.rockpuppy.benjaamiins;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.screen.ScreenHandlerType;
import net.rockpuppy.benjaamiins.block.client.BeanPedestalBlockEntityRenderer;
import net.rockpuppy.benjaamiins.block.client.BeanstoneMonolithBlockEntityRenderer;
import net.rockpuppy.benjaamiins.block.entity.ModBlockEntities;
import net.rockpuppy.benjaamiins.entity.*;
import net.rockpuppy.benjaamiins.entity.client.*;
import net.rockpuppy.benjaamiins.screens.BeanScreen;
import net.rockpuppy.benjaamiins.screens.BeanstoneMonolithScreenHandler;

@Environment(EnvType.CLIENT)
public class BenjaamiinsClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {

		EntityRendererRegistry.register(ModEntities.BEAN_MASTER, BeanMasterRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BEAN_MASTER, BeanMasterModel::getTexturedModelData);

		EntityRendererRegistry.register(ModEntities.BEAN_GOD, BeanGodRenderer::new);
		EntityModelLayerRegistry.registerModelLayer(ModModelLayers.BEAN_GOD, BeanGodModel::getTexturedModelData);

		BlockEntityRendererFactories.register(ModBlockEntities.BEAN_PEDESTAL, BeanPedestalBlockEntityRenderer::new);
		BlockEntityRendererFactories.register(ModBlockEntities.BEANSTONE_MONOLITH, BeanstoneMonolithBlockEntityRenderer::new);

		HandledScreens.register(Benjaamiins.BEANSTONE_MONOLITH_SCREEN_HANDLER, BeanScreen::new);
	}
}