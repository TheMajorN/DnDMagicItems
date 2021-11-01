package com.kingpins.magicitems.common.events;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.core.init.ItemInit;
import com.kingpins.magicitems.core.init.SoundInit;
import net.minecraft.client.audio.Sound;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.entity.player.PlayerSleepInBedEvent;
import net.minecraftforge.event.entity.player.PlayerWakeUpEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MagicItems.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class MaceOfTheMuleEvents {

    public static int charge = 12;

    @SubscribeEvent
    public static void maceOfTheMuleChargeHit(AttackEntityEvent player) {
        LivingEntity playerIn = player.getEntityLiving();
        if (player.getEntityLiving().getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.MACE_OF_THE_MULE.get() && player.getEntityLiving().isCrouching()) {
            player.getEntityLiving().getItemInHand(Hand.MAIN_HAND).enchant(Enchantments.KNOCKBACK, 10);
            playerIn.playSound(SoundInit.MACE_OF_THE_MULE_SOUND.get(), 1.0f, 1.0f);
            charge--;
        }
        else if (player.getEntityLiving().getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.MACE_OF_THE_MULE.get() && !player.getEntityLiving().isCrouching()) {
            player.getEntityLiving().getItemInHand(Hand.MAIN_HAND).removeTagKey("Enchantments");
        }
    }

    @SubscribeEvent
    public static void sleepRecharge(PlayerWakeUpEvent player) {
        if (player.wakeImmediately()) {
            charge = 12;
        }
    }
}
