package com.github.remainingtoast.block;

import com.github.remainingtoast.BreadMod;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BreadBlock extends Block {
    public BreadBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack stack = player.getMainHandStack();
        if(stack.getItem().equals(BreadMod.TOAST)){
            world.setBlockState(pos, Blocks.FIRE.getDefaultState());
        }
        return super.onUse(state, world, pos, player, hand, hit);
    }


}
