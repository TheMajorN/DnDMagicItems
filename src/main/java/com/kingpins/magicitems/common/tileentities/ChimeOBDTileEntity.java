package com.kingpins.magicitems.common.tileentities;

import com.google.common.base.Predicates;
import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.core.init.SoundInit;
import com.kingpins.magicitems.core.init.TileEntityTypeInit;
import net.minecraft.entity.*;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;

import java.util.List;
import java.util.Objects;

public class ChimeOBDTileEntity extends TileEntity implements ITickableTileEntity {
    public int tick;

    public ChimeOBDTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ChimeOBDTileEntity() {
        this(TileEntityTypeInit.CHIME_OBD_TILE_ENTITY_TYPE.get());
    }




    @Override
    public void tick() {
        tick++;
        PlayerEntity player = Objects.requireNonNull(getLevel()).getNearestPlayer(EntityPredicate.DEFAULT, 1.0, 1.0, 1.0);

        BlockPos pos = getBlockPos().below(3);
        AxisAlignedBB blockAABB = new AxisAlignedBB(pos).inflate(5, 5, 5);

        assert level != null;
        List<CreeperEntity> entities = level.getEntities
                (EntityType.CREEPER, blockAABB, Predicates.alwaysTrue());


        if (tick == 100) {
            if (entities.size() > 0) {
                level.playSound(player, pos, SoundInit.CHIME_OBD_SOUND.get(), SoundCategory.BLOCKS, 5.0F, 5.0F);
                MagicItems.LOGGER.info("Creeper Alerted the bell!");
            }
            tick = 0;
        }
    }
}
