package com.kingpins.magicitems.common.tileentities;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.core.init.TileEntityTypeInit;
import jdk.internal.vm.compiler.libgraal.LibGraal;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;

import java.util.List;
import java.util.Objects;

public class ChimeOBDTileEntity extends TileEntity implements ITickableTileEntity {

    public ChimeOBDTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ChimeOBDTileEntity() {
        this(TileEntityTypeInit.CHIME_OBD_TILE_ENTITY_TYPE.get());
    }


    @Override
    public void tick() {
        BlockPos pos = getBlockPos().below(3);
        //LivingEntity creeper = ???;
        AxisAlignedBB blockAABB = new AxisAlignedBB(pos);
        AxisAlignedBB creeperPos = EntityType.CREEPER.getAABB
                (5.0, 5.0, 5.0);
        assert level != null;
        /* List<MobEntity> entities = Objects.requireNonNull(Objects.requireNonNull(level
                .getBlockEntity(pos)).getLevel()).getNearbyEntities(
                MobEntity.class, EntityPredicate.DEFAULT, creeper, creeperPos);



        if (entities.equals(blockAABB)) {
            MagicItems.LOGGER.info("Creeper Alerted the bell!");

        }

         */
    }




}
