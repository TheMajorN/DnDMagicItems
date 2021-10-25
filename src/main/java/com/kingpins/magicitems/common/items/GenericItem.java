package com.kingpins.magicitems.common.items;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class GenericItem extends Item {

    public GenericItem() {
        super(new Item.Properties().tab(ItemGroup.TAB_COMBAT));
    }
}
