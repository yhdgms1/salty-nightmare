package org.saltynightmare.registry;

import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import org.saltynightmare.SaltyNightmare;

public class PotionRegister {
    public static final RegistryEntry<Potion> SALTY_POTION;

    public static void registerPotions() {
        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.WATER, ItemsRegister.SALT_POWDER, SALTY_POTION);
        });
    }

    protected static RegistryEntry<Potion> registerPotion(String name, StatusEffectInstance[] effect) {
        return Registry.registerReference(Registries.POTION, SaltyNightmare.id(name), new Potion(effect));
    }

    static {
        SALTY_POTION = registerPotion("salty_potion", new StatusEffectInstance[]{ new StatusEffectInstance(EffectsRegister.THIRST, 100, 0) });
    }
}
