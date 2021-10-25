package com.kingpins.magicitems.common.events;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.core.init.ItemInit;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MagicItems.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MaceOfTheMuleEvents {

    static int charge = 4;

    @SubscribeEvent
    public static void maceOfTheMuleChargeHit(AttackEntityEvent player) {
        if (player.getEntityLiving().getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.MACE_OF_THE_MULE.get() && player.getEntityLiving().isCrouching() && charge > 0) {
            player.getEntityLiving().getItemInHand(Hand.MAIN_HAND).enchant(Enchantments.KNOCKBACK, 10);
            charge--;
        }
        else if (player.getEntityLiving().getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.MACE_OF_THE_MULE.get() && !player.getEntityLiving().isCrouching()) {
            player.getEntityLiving().getItemInHand(Hand.MAIN_HAND).removeTagKey("Enchantments");
        }
    }

    public static void sleepRecharge(PlayerSleepInBedEvent player) {
        if (player.getEntityLiving().isSleeping()) {
            charge = 4;
        }
    }

}
