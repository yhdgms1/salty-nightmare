package org.saltynightmare.registry;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.util.Identifier;

public class LootTablesRegister {
    // ChatGPT
    private static final Identifier[] VILLAGE_CHEST_LOOT_TABLES = {
            new Identifier("minecraft", "chests/village/village_weaponsmith"),
            new Identifier("minecraft", "chests/village/village_toolsmith"),
            new Identifier("minecraft", "chests/village/village_armorer"),
            new Identifier("minecraft", "chests/village/village_cartographer"),
            new Identifier("minecraft", "chests/village/village_mason"),
            new Identifier("minecraft", "chests/village/village_shepherd"),
            new Identifier("minecraft", "chests/village/village_fletcher"),
            new Identifier("minecraft", "chests/village/village_tannery"),
            new Identifier("minecraft", "chests/village/village_temple"),
            new Identifier("minecraft", "chests/village/village_desert_house"),
            new Identifier("minecraft", "chests/village/village_plains_house"),
            new Identifier("minecraft", "chests/village/village_taiga_house"),
            new Identifier("minecraft", "chests/village/village_snowy_house"),
            new Identifier("minecraft", "chests/village/village_savanna_house"),
    };

    public static void registerVillageLootTables() {
        LootTableEvents.MODIFY.register((resourceManager, lootManager, id, supplier, setter) -> {
            for (Identifier villageChest : VILLAGE_CHEST_LOOT_TABLES) {
                if (villageChest.equals(id)) {
                    LootPool pool = LootPool.builder()
                            .rolls(ConstantLootNumberProvider.create(2))
                            .conditionally(RandomChanceLootCondition.builder(0.2f))
                            .with(ItemEntry.builder(ItemsRegister.SALT_POWDER))
                            .build();

                    supplier.pool(pool);
                }
            }
        });
    }
}
