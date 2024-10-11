package net.rockpuppy.benjaamiins;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.transfer.v1.item.ItemStorage;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.resource.featuretoggle.FeatureSet;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.rockpuppy.benjaamiins.block.ModBlocks;
import net.rockpuppy.benjaamiins.block.entity.BeanPedestalBlockEntity;
import net.rockpuppy.benjaamiins.block.entity.ModBlockEntities;
import net.rockpuppy.benjaamiins.entity.ModEntities;
import net.rockpuppy.benjaamiins.entity.custom.BeanGodEntity;
import net.rockpuppy.benjaamiins.entity.custom.BeanMasterEntity;
import net.rockpuppy.benjaamiins.item.ModArmorMaterial;
import net.rockpuppy.benjaamiins.item.ModItemGroups;
import net.rockpuppy.benjaamiins.item.ModItems;
import net.rockpuppy.benjaamiins.screens.BeanstoneMonolithScreenHandler;
import net.rockpuppy.benjaamiins.world.gen.ModWorldGeneration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.bernie.geckolib.GeckoLib;

public class Benjaamiins implements ModInitializer {
	public static final String MOD_ID = "benjaamiins";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	public static final ScreenHandlerType<BeanstoneMonolithScreenHandler> BEANSTONE_MONOLITH_SCREEN_HANDLER = Registry.register(Registries.SCREEN_HANDLER, Identifier.of("benjaamiins", "beanstone_monolith"), new ScreenHandlerType<>(BeanstoneMonolithScreenHandler::new, FeatureSet.empty()));


	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		ModItems.initialize();
		ModBlocks.initialize();
		ModEntities.registerModEntities();

		ModArmorMaterial.initialize();

		ModWorldGeneration.generationModWorldGen();

		ModBlockEntities.onInitialize();
		ItemStorage.SIDED.registerForBlockEntity(BeanPedestalBlockEntity::getInventoryProvider, ModBlockEntities.BEAN_PEDESTAL);

		FabricDefaultAttributeRegistry.register(ModEntities.BEAN_MASTER, BeanMasterEntity.createBeanMasterAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.BEAN_GOD, BeanGodEntity.createBeanGodAttributes());
	}

	/*
	Crafting Recipes:

	Elite Bean Armour

	Bean Pedestal
	Bean Monolith

	Textures:

	Retexture Bean

	Block/Mob Drops:
	*/
}