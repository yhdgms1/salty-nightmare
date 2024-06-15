package org.saltynightmare.effects;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.entity.player.PlayerEntity;

public class ThirstEffect extends StatusEffect {
    public ThirstEffect() {
        super(StatusEffectCategory.HARMFUL, 13356278);
    }

    @Override
    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (entity instanceof PlayerEntity player) {
            player.damage(entity.getDamageSources().generic(), 0.5F);
        }

        return true;
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 99 == 0;
    }
}
