package com.kingpins.magicitems.common.events;

import com.kingpins.magicitems.MagicItems;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MagicItems.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SlipRazorEvents {

    @SubscribeEvent
    public static void slipTeleport() {

    }

}
