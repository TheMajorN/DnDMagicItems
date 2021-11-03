package com.kingpins.magicitems.common.tileentities;

import com.kingpins.magicitems.core.init.TileEntityTypeInit;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.vector.Vector3i;

public class ChimeOBDTileEntity extends TileEntity implements ITickableTileEntity {

    public ChimeOBDTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ChimeOBDTileEntity() {
        this(TileEntityTypeInit.CHIME_OBD_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {

    }
}
