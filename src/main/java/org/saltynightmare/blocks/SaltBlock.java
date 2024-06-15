package org.saltynightmare.blocks;

import net.minecraft.block.ColoredFallingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ColorCode;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SaltBlock extends ColoredFallingBlock {
    public SaltBlock(ColorCode colorCode, Settings settings) {
        super(colorCode, settings);
    }

    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if (entity instanceof PlayerEntity player) {
            if (player.getHealth() < player.getMaxHealth() / 2) {
                player.damage(world.getDamageSources().generic(), 0.5F);
            }
        }
    }
}
