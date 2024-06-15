package org.saltynightmare.registry;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import org.saltynightmare.SaltyNightmare;

public class ItemGroupRegister {
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(ItemsRegister.SALT_POWDER))
            .displayName(Text.translatable("itemGroup.salty-nightmare.group"))
            .entries((context, entries) -> {
                /*
                    Blocks
                 */
                entries.add(BlockRegister.SALT_BLOCK);
                /*
                    Items
                 */
                entries.add(ItemsRegister.SALT_POWDER);
                /*
                    Potions
                 */
                entries.add(PotionContentsComponent.createStack(Items.POTION, PotionRegister.SALTY_POTION));
                entries.add(PotionContentsComponent.createStack(Items.LINGERING_POTION, PotionRegister.SALTY_POTION));
                entries.add(PotionContentsComponent.createStack(Items.SPLASH_POTION, PotionRegister.SALTY_POTION));
            })
            .build();

    public static void registerItemGroups() {
        Registry.register(Registries.ITEM_GROUP, SaltyNightmare.id( "salty_nightmare_group"), ITEM_GROUP);
    }
}
