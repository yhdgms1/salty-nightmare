package org.saltynightmare.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;

public class SaltBlock extends FallingBlock {
    public static final MapCodec<SaltBlock> CODEC = createCodec(SaltBlock::new);
    public static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 15.0, 15.0);

    public SaltBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<SaltBlock> getCodec() {
        return CODEC;
    }

    @Override
    public void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity) {
        if (entity instanceof PlayerEntity) {
            PlayerEntity player = (PlayerEntity) entity;

            /**
             * Когда меньше половины HP касание блока соли будет наносить урон, т.к. соль на рану
             */
            if (player.getHealth() < player.getMaxHealth() / 2) {
                player.damage(world.getDamageSources().generic(), 0.5F);
            }
        }

        super.onEntityCollision(state, world, pos, entity);
    }

    protected VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }
}
