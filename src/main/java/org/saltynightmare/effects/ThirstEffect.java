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
    public void applyUpdateEffect(LivingEntity entity, int amplifier) {
        super.applyUpdateEffect(entity, amplifier);

        if (entity instanceof PlayerEntity player) {
            player.damage(entity.getDamageSources().generic(), 0.5F);
        }
    }

    @Override
    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        return duration % 99 == 0;
    }
}
