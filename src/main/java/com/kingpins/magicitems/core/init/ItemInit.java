package com.kingpins.magicitems.core.init;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.core.enums.ModItemTier;
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
    public static final RegistryObject<SwordItem> MACE_OF_THE_MULE = ITEMS.register("mace_of_the_mule",
            () -> new SwordItem(ModItemTier.MACE_OF_THE_MULE, 3, -2.0F, new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
}
