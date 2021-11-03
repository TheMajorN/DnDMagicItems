package com.kingpins.magicitems.common.entities;

import com.kingpins.magicitems.common.events.SlipRazorEvents;
import com.kingpins.magicitems.core.init.EntityTypeInit;
import com.kingpins.magicitems.core.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;

import javax.annotation.Nonnull;

public class SlipRazorEntity extends ProjectileItemEntity {

    public SlipRazorEntity(EntityType<SlipRazorEntity> type, World world) {
        super(type, world);
    }

    public SlipRazorEntity(LivingEntity entity, World world) {
        super(EntityTypeInit.SLIP_RAZOR_ENTITY.get(), entity, world);
    }

    public SlipRazorEntity(double x, double y, double z, World world) {
        super(EntityTypeInit.SLIP_RAZOR_ENTITY.get(), x, y, z, world);
    }

    @Nonnull
    @Override
    protected Item getDefaultItem() {
        return ItemInit.SLIP_RAZOR.get();
    }


    @Override
    public IPacket<?> getAddEntityPacket() {
        return NetworkHooks.getEntitySpawningPacket(this);
    }

    @Override
    protected void onHitEntity(EntityRayTraceResult entityRayTraceResult) {
        super.onHitEntity(entityRayTraceResult);
        Entity entity = this.getOwner();
        Entity mobEntity = entityRayTraceResult.getEntity();

        for (int i = 0; i < 32; ++i) {
            this.level.addParticle(ParticleTypes.FLASH, this.getX(), this.getY() + this.random.nextDouble() * 2.0D, this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
        }

        if (!this.level.isClientSide && !this.removed) {
            if (entity instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entity;
                if (serverplayerentity.connection.getConnection().isConnected() && serverplayerentity.level == this.level && !serverplayerentity.isSleeping()) {
                    SlipRazorEvents event = (SlipRazorEvents) SlipRazorEvents.onSlipRazorLand(serverplayerentity, this.getX(), this.getY(), this.getZ(), this, 6.0F);
                    if (!event.isCanceled()) { // Don't indent to lower patch size
                        if (entity.isPassenger()) {
                            entity.stopRiding();
                        }

                        entity.teleportTo(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        entity.fallDistance = 0.0F;
                        mobEntity.hurt(DamageSource.thrown(this, this.getOwner()), 6.0F);
                        //entity.hurt(DamageSource.FALL, event.getAttackDamage());
                    } //Forge: End
                }
            } else if (entity != null) {
                entity.teleportTo(this.getX(), this.getY(), this.getZ());
                entity.fallDistance = 0.0F;
            }

            this.remove();
        }
    }

    @Override
    protected void onHit(RayTraceResult rayTraceResult) {
        super.onHit(rayTraceResult);
        Entity entity = this.getOwner();

        for (int i = 0; i < 32; ++i) {
            this.level.addParticle(ParticleTypes.FLASH, this.getX(), this.getY() + this.random.nextDouble() * 2.0D, this.getZ(), this.random.nextGaussian(), 0.0D, this.random.nextGaussian());
        }

        if (!this.level.isClientSide && !this.removed) {
            if (entity instanceof ServerPlayerEntity) {
                ServerPlayerEntity serverplayerentity = (ServerPlayerEntity) entity;
                if (serverplayerentity.connection.getConnection().isConnected() && serverplayerentity.level == this.level && !serverplayerentity.isSleeping()) {
                    SlipRazorEvents event = (SlipRazorEvents) SlipRazorEvents.onSlipRazorLand(serverplayerentity, this.getX(), this.getY(), this.getZ(), this, 5.0F);
                    if (!event.isCanceled()) { // Don't indent to lower patch size
                        if (entity.isPassenger()) {
                            entity.stopRiding();
                        }

                        entity.teleportTo(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        entity.fallDistance = 0.0F;
                    } //Forge: End
                }
            } else if (entity != null) {
                entity.teleportTo(this.getX(), this.getY(), this.getZ());
                entity.fallDistance = 0.0F;
            }

            this.remove();
        }
    }
}
