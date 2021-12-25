package com.kingpins.magicitems.core.init;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.common.items.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
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

    public static final RegistryObject<Item> EXPLORERS_CUTLASS = ITEMS.register("explorers_cutlass",
            () -> new ExplorersCutlassItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    // =====SHIELDS=====
    public static final RegistryObject<Item> SHIELD_OF_THE_TOWER = ITEMS.register("shield_of_the_tower",
            () -> new ShieldOfTheTowerItem(new Item.Properties().tab(ItemGroup.TAB_COMBAT)));

    // =====CONSUMABLES=====
    public static final RegistryObject<Item> COMBAT_BANDAGE = ITEMS.register("combat_bandage",
            () -> new Item(new Item.Properties().tab(ItemGroup.TAB_FOOD).food(new Food.Builder()
            .effect(() -> new EffectInstance(Effects.HEAL, 100, 2), 1.0F)
            .fast().build())));

    // =====Block Items=====
    public static final RegistryObject<BlockItem> SHIELD_WALL_ITEM = ITEMS.register("shield_wall",
            () -> new BlockItem(BlockInit.SHIELD_WALL_BLOCK.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));

    public static final RegistryObject<BlockItem> CHIME_OBD_ITEM = ITEMS.register("chime_of_beast_discovery",
            () -> new BlockItem(BlockInit.CHIME_OF_BEAST_DISCOVERY.get(), new Item.Properties().tab(ItemGroup.TAB_TOOLS)));
}
