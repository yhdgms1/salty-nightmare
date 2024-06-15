package org.saltynightmare;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.saltynightmare.registry.*;

public class SaltyNightmare implements ModInitializer {
	public static final String MOD_ID = "salty-nightmare";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		BlockRegister.registerBlocks();
		BlockItemsRegister.registerBlockItems();
		ItemsRegister.registerItems();
		PotionRegister.registerPotions();
		EffectsRegistry.registerEffects();
		ItemGroupRegister.registerItemGroups();
	}
}