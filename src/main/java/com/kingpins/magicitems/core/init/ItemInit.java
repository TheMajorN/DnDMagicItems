package com.kingpins.magicitems.core.init;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.common.items.SlipRazorItem;
import com.kingpins.magicitems.core.enums.ModItemTier;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SwordItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS,
            MagicItems.MOD_ID);

    // =====WEAPONS=====
    public static final RegistryObject<BlockItem> MACE_OF_THE_MULE = ITEMS.register("mace_of_the_mule",
            () -> new BlockItem(BlockInit.MACE_OF_THE_MULE.get(), new Item.Properties().tab(ItemGroup.TAB_TOOLS)));

    public static final RegistryObject<Item> SLIP_RAZOR = ITEMS.register("slip_razor",
            () -> new SlipRazorItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));
}
