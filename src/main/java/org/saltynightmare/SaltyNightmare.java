package org.saltynightmare;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.text.Text;
import net.minecraft.util.ColorCode;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.saltynightmare.potions.PotionsMaker;
import org.saltynightmare.blocks.*;

public class SaltyNightmare implements ModInitializer {
	public static final String NAMESPACE = "salty-nightmare";
	public static final Logger LOGGER = LoggerFactory.getLogger("salty-nightmare");

	/**
	 * Blocks
	 */
	public static final Block SALT_BLOCK = new SaltBlock(new ColorCode(13356278), AbstractBlock.Settings.create().instrument(Instrument.SNARE).sounds(BlockSoundGroup.SAND).mapColor(MapColor.WHITE_GRAY).strength(0.5F));
	/**
	 * Items
	 */
	public static final Item SALT_POWDER = new Item(new Item.Settings());

	/**
	 * Item Group
	 */
	private static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
			.icon(() -> new ItemStack(SALT_POWDER))
			.displayName(Text.translatable("itemGroup.salty-nightmare.group"))
			.entries((context, entries) -> {
				entries.add(SALT_BLOCK);
				entries.add(SALT_POWDER);
			})
			.build();

	@Override
	public void onInitialize() {
		PotionsMaker.registerPotions();

		/**
		 * Block & Block Items
		 */
		Registry.register(Registries.BLOCK, new Identifier(NAMESPACE, "salt_block"), SALT_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "salt_block"), new BlockItem(SALT_BLOCK, new Item.Settings()));

		/**
		 * Items
		 */
		Registry.register(Registries.ITEM, new Identifier(NAMESPACE, "salt_powder"), SALT_POWDER);

		/**
		 * Item Group
		 */
		Registry.register(Registries.ITEM_GROUP, new Identifier(NAMESPACE, "salty_nightmare_group"), ITEM_GROUP);

		LOGGER.info("Hello Fabric world!");
	}
}