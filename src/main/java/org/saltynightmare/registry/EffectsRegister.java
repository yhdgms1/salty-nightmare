package org.saltynightmare.registry;

import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.saltynightmare.SaltyNightmare;
import org.saltynightmare.effects.ThirstEffect;

public class EffectsRegister extends StatusEffects {
    public static StatusEffect THIRST = new ThirstEffect();

    public static void registerEffects () {
        registerStatusEffect("thirst", THIRST);
    }

    private static StatusEffect registerStatusEffect(String name, StatusEffect effect) {
        return Registry.register(Registries.STATUS_EFFECT, new Identifier(SaltyNightmare.MOD_ID, name), effect);
    }
}
