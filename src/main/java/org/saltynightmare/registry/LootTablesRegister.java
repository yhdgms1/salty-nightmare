package org.saltynightmare.registry;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;

public class LootTablesRegister {
    // ChatGPT-generated
    // However, info here: https://minecraft.fandom.com/wiki/Loot_table
    private static final String[] VILLAGE_CHEST_LOOT_TABLES = {
         "chests/village/village_weaponsmith",
         "chests/village/village_toolsmith",
         "chests/village/village_armorer",
         "chests/village/village_cartographer",
         "chests/village/village_mason",
         "chests/village/village_shepherd",
         "chests/village/village_fletcher",
         "chests/village/village_tannery",
         "chests/village/village_temple",
         "chests/village/village_desert_house",
         "chests/village/village_plains_house",
         "chests/village/village_taiga_house",
         "chests/village/village_snowy_house",
         "chests/village/village_savanna_house",
    };

    public static void registerVillageLootTables() {
        
        LootTableEvents.MODIFY.register((key, builder, source) -> {
            var path = key.getValue().getPath();

            for (String chest : VILLAGE_CHEST_LOOT_TABLES) {
                if (chest.equals(path)) {
                    LootPool pool = LootPool.builder()
                        .rolls(ConstantLootNumberProvider.create(2))
                        .conditionally(RandomChanceLootCondition.builder(0.2f))
                        .with(ItemEntry.builder(ItemsRegister.SALT_POWDER))
                        .build();

                    builder.pool(pool);
                }
            }
        });
    }
}
