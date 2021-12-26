package com.kingpins.magicitems.common.events;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.core.init.ItemInit;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.Hand;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MagicItems.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class GoldenHindEvents {

    public static void holdGoldenHind(PlayerEvent player) {
        if (player.getEntityLiving().getItemInHand(Hand.MAIN_HAND).getItem() == ItemInit.GOLDEN_HIND.get()) {
            player.getEntityLiving().addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 99999));
            player.getEntityLiving().addEffect(new EffectInstance(Effects.WEAKNESS, 99999));
        } else {
            player.getEntityLiving().addEffect(new EffectInstance(Effects.MOVEMENT_SPEED, 1));
            player.getEntityLiving().addEffect(new EffectInstance(Effects.WEAKNESS, 1));
        }
    }

}
