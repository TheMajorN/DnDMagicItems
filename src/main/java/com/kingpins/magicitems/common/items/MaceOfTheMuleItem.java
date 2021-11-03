package com.kingpins.magicitems.common.items;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class MaceOfTheMuleItem extends Item {
    public MaceOfTheMuleItem(Properties p_i48487_1_) {
        super(p_i48487_1_);
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        entity.hurt(DamageSource.playerAttack(player), 3.0F);
        return super.onLeftClickEntity(stack, player, entity);
    }
}
