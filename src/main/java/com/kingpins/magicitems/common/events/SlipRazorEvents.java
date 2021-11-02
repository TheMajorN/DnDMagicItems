package com.kingpins.magicitems.common.events;

import com.kingpins.magicitems.common.entities.SlipRazorEntity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EntityTeleportEvent;

public class SlipRazorEvents extends EntityTeleportEvent {

    private final ServerPlayerEntity player;
    private final SlipRazorEntity slipRazor;
    private float attackDamage;

    public SlipRazorEvents(ServerPlayerEntity entity, double targetX, double targetY, double targetZ, SlipRazorEntity slipRazor, float attackDamage) {
        super(entity, targetX, targetY, targetZ);
        this.slipRazor = slipRazor;
        this.player = entity;
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

    public static EntityTeleportEvent onSlipRazorLand(ServerPlayerEntity entity, double targetX, double targetY, double targetZ, SlipRazorEntity slipRazor, float attackDamage) {
        SlipRazorEvents event = new SlipRazorEvents(entity, targetX, targetY, targetZ, slipRazor, attackDamage);
        //event.setAttackDamage(onOldEnderTeleport(entity, attackDamage, event)); //TODO Forge: Remove this line in 1.17
        MinecraftForge.EVENT_BUS.post(event);
        return event;
    }
}
