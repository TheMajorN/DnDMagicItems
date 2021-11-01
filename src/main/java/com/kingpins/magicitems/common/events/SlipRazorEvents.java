package com.kingpins.magicitems.common.events;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.common.entities.SlipRazorEntity;
import com.kingpins.magicitems.core.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EntityTeleportEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = MagicItems.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class SlipRazorEvents extends EntityTeleportEvent {

    private final ServerPlayerEntity player;
    private final SlipRazorEntity slipRazor;
    private float attackDamage;

    public SlipRazorEvents(Entity entity, double targetX, double targetY, double targetZ, SlipRazorEntity slipRazor, float attackDamage) {
        super(entity, targetX, targetY, targetZ);
        this.slipRazor = slipRazor;
        this.player = (ServerPlayerEntity) entity;
        this.attackDamage = attackDamage;
    }

    public SlipRazorEntity getSlipRazorEntity()
    {
        return slipRazor;
    }

    public ServerPlayerEntity getPlayer()
    {
        return player;
    }

    public float getAttackDamage()
    {
        return attackDamage;
    }

    public void setAttackDamage(float attackDamage)
    {
        this.attackDamage = attackDamage;
    }

    public static SlipRazorEvents onSlipRazorLand(ServerPlayerEntity entity, double targetX, double targetY, double targetZ, SlipRazorEntity slipRazor, float attackDamage)
    {
        SlipRazorEvents event = new SlipRazorEvents(entity, targetX, targetY, targetZ, slipRazor, attackDamage);
        event.setAttackDamage(6.0F); //TODO Forge: Remove this line in 1.17
        MinecraftForge.EVENT_BUS.post(event);
        return event;
    }


}
