package com.kingpins.magicitems.common.items;

import com.kingpins.magicitems.core.init.ItemInit;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class ShieldOfTheTowerItem extends ShieldItem {
    public ShieldOfTheTowerItem(Properties p_i48470_1_) {
        super(p_i48470_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        if (playerIn.getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.SHIELD_OF_THE_TOWER.get() && !playerIn.isCrouching()) {
            return super.use(worldIn, playerIn, handIn);
        } else {
            return super.use(worldIn, playerIn, handIn); // Changing this later, just here now to avoid an error.
        }
    }
}
