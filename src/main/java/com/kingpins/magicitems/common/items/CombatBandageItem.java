package com.kingpins.magicitems.common.items;

import net.minecraft.item.Food;
import net.minecraft.item.Item;

import javax.annotation.Nullable;


public class CombatBandageItem extends Item {
    public CombatBandageItem(Properties properties) {
        super(properties);
    }

    @Nullable
    @Override
    public Food getFoodProperties() {
        return super.getFoodProperties();
    }
}
