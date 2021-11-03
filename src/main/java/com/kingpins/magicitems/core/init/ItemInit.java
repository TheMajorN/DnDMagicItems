package com.kingpins.magicitems.core.init;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.common.items.MaceOfTheMuleItem;
import com.kingpins.magicitems.common.items.ShieldOfTheTowerItem;
import com.kingpins.magicitems.common.items.SlipRazorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            MagicItems.MOD_ID);

    // =====WEAPONS=====
    public static final RegistryObject<Item> MACE_OF_THE_MULE = ITEMS.register("mace_of_the_mule",
            () -> new MaceOfTheMuleItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    public static final RegistryObject<Item> SLIP_RAZOR = ITEMS.register("slip_razor",
            () -> new SlipRazorItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    // =====SHIELDS=====
    public static final RegistryObject<Item> SHIELD_OF_THE_TOWER = ITEMS.register("shield_of_the_tower",
            () -> new ShieldOfTheTowerItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));


}
