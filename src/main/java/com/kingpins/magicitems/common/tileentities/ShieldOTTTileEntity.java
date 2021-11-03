package com.kingpins.magicitems.common.tileentities;

import com.kingpins.magicitems.core.init.TileEntityTypeInit;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class ShieldOTTTileEntity extends TileEntity implements ITickableTileEntity {
    public ShieldOTTTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ShieldOTTTileEntity() {
        this(TileEntityTypeInit.SHIELD_OTT_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        this.level.setBlock(this.getBlockPos().above(), Blocks.ACACIA_PLANKS.defaultBlockState(), 1);
    }
}
