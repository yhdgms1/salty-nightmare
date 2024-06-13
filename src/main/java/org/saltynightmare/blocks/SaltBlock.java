package org.saltynightmare.blocks;

import com.mojang.serialization.MapCodec;
import net.minecraft.block.Block;
import net.minecraft.block.FallingBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class SaltBlock extends FallingBlock {
    public SaltBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected MapCodec<? extends FallingBlock> getCodec() {
        return null;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
        // когда наступаешь и мало хп то больно и хп ещё будет сниматься
        return super.onUse(state, world, pos, player, hit);

//        if (!world.isClient) {
//            player.sendMessage(Text.literal("Hello, world!"), false);
//        }
//
//        return ActionResult.SUCCESS;
    }
}
