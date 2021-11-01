package com.kingpins.magicitems.client.render.tileentity;

import com.kingpins.magicitems.core.init.TileEntityTypeInit;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ChimeOBDTileEntity extends TileEntity implements ITickableTileEntity {

    public ChimeOBDTileEntity(TileEntityType<?> p_i48289_1_) {
        super(p_i48289_1_);
    }

    public ChimeOBDTileEntity() {
        this(TileEntityTypeInit.CHIME_OBD_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        //this.worldPosition.distSqr();
    }
}
