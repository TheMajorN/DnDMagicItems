package com.kingpins.magicitems.common.items;

import com.kingpins.magicitems.common.entities.SlipRazorEntity;
import com.kingpins.magicitems.core.init.SoundInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class SlipRazorItem extends Item {
    public SlipRazorItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn) {
        ItemStack stack = playerIn.getItemInHand(Hand.MAIN_HAND);

        playerIn.getCooldowns().addCooldown(this, 20);
        if(!worldIn.isClientSide) {
            SlipRazorEntity slipRazor = new SlipRazorEntity(playerIn, worldIn);
            slipRazor.setItem(stack);
            slipRazor.shootFromRotation(playerIn, playerIn.xRot, playerIn.yRot, 0.0F, 2.0F, 1.0F);
            worldIn.addFreshEntity(slipRazor);
        }

        playerIn.awardStat(Stats.ITEM_USED.get(this));

        return ActionResult.sidedSuccess(stack, true);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        entity.hurt(DamageSource.playerAttack(player), 1.5F);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
