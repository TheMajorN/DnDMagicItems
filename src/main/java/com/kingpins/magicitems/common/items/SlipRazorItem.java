package com.kingpins.magicitems.common.items;

import com.kingpins.magicitems.common.entities.SlipRazorEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class SlipRazorItem extends Item {
    public SlipRazorItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getItemInHand(Hand.MAIN_HAND);

        if(!worldIn.isClientSide) {
            SlipRazorEntity slipRazor = new SlipRazorEntity(playerIn, worldIn);
            slipRazor.setItem(stack);
            slipRazor.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 2.0F, 1.0F);
            worldIn.addFreshEntity(slipRazor);
        }
        return ActionResult.sidedSuccess(stack, true);
    }
}
