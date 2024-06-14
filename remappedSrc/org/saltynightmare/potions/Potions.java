package org.saltynightmare.potions;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import org.saltynightmare.SaltyNightmare;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.recipe.BrewingRecipeRegistry;
import net.minecraft.util.Identifier;

public class Potions {
    public static Potion SALTY_POTION;

    public static void registerPotions() {
        SALTY_POTION = registerPotion("salty_potion", new StatusEffectInstance(StatusEffects.HUNGER, 100, 0));
    }

    public static void registerRecipe(Potion input, Item item, Potion output) {
        

    }

    public static Potion registerPotion(String name, StatusEffectInstance effect) {
        return Registry.register(Registries.POTION, new Identifier(SaltyNightmare.NAMESPACE, name), new Potion(effect));
    }
}
