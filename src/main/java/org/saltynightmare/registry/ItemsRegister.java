package org.saltynightmare.registry;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.saltynightmare.SaltyNightmare;

public class ItemsRegister {
    public static final Item SALT_POWDER = new Item(new Item.Settings());

    public static void registerItems() {
        Registry.register(Registries.ITEM, new Identifier(SaltyNightmare.MOD_ID, "salt_powder"), SALT_POWDER);

    }
}
