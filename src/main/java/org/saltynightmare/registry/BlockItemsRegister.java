package org.saltynightmare.registry;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import org.saltynightmare.SaltyNightmare;

public class BlockItemsRegister {
    public static void registerBlockItems() {
        Registry.register(Registries.ITEM, SaltyNightmare.id("salt_block"), new BlockItem(BlockRegister.SALT_BLOCK, new Item.Settings()));
    }
}
