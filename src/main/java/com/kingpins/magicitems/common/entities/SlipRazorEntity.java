package com.kingpins.magicitems.common.entities;

import com.kingpins.magicitems.core.init.EntityTypeInit;
import com.kingpins.magicitems.core.init.ItemInit;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.network.IPacket;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
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
    protected void onHit(RayTraceResult p_70227_1_) {
        /*if (p_70227_1_.getType() == RayTraceResult.Type.ENTITY) {
            Entity entity = ((EntityRayTraceResult)p_70227_1_).getEntity();

            entity.hurt(DamageSource.thrown(this, this.getOwner()), 6.0F);
        }

         */
            this.remove();
    }
}
