package org.saltynightmare.registry;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.saltynightmare.SaltyNightmare;

public class PotionRegister {
    public static final Potion SALTY_POTION = registerPotion("salty_potion", new StatusEffectInstance[]{ new StatusEffectInstance(EffectsRegister.THIRST, 100, 0) });

    public static void registerPotions() {
        registerRecipe(Potions.WATER, ItemsRegister.SALT_POWDER, SALTY_POTION);
    }

    protected static void registerRecipe(Potion input, Item item, Potion output) {
        BrewingRecipeRegistry.registerPotionRecipe(input, item, output);
    }

    protected static Potion registerPotion(String name, StatusEffectInstance[] effect) {
        return Registry.register(Registries.POTION, new Identifier(SaltyNightmare.MOD_ID, name), new Potion(effect));
    }
}
