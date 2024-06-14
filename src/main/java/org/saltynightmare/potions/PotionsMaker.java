package org.saltynightmare.potions;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.recipe.BrewingRecipeRegistry;
import org.saltynightmare.SaltyNightmare;

import net.minecraft.item.Item;
import net.minecraft.potion.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class PotionsMaker {
    public static final Potion SALTY_POTION = registerPotion("salty_potion", new StatusEffectInstance[]{ new StatusEffectInstance(StatusEffects.HUNGER, 100, 0) });

    public static void registerPotions() {
        registerRecipe(Potions.WATER, SaltyNightmare.SALT_POWDER, SALTY_POTION);
    }

    protected static void registerRecipe(Potion input, Item item, Potion output) {
        BrewingRecipeRegistry.registerPotionRecipe(input, item, output);
    }

    protected static Potion registerPotion(String name, StatusEffectInstance[] effect) {
        return Registry.register(Registries.POTION, new Identifier(SaltyNightmare.NAMESPACE, name), new Potion(effect));
    }
}
