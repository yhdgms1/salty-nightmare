package org.saltynightmare.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import org.saltynightmare.SaltyNightmare;
import org.saltynightmare.effects.ThirstEffect;

public class EffectsRegister extends StatusEffects {
    public static RegistryEntry<StatusEffect> THIRST;

    private static RegistryEntry<StatusEffect> register(String id, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, SaltyNightmare.id(id), statusEffect);
    }

    static {
        THIRST = register("thirst", new ThirstEffect());
    }
}
