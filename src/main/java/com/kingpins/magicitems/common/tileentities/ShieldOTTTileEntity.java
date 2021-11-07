package com.kingpins.magicitems.common.tileentities;

import com.kingpins.magicitems.core.init.TileEntityTypeInit;
import com.kingpins.magicitems.core.util.NBTHelper;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.FluidState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.BlockPos;

import javax.annotation.Nullable;
import javax.swing.text.html.parser.Entity;

public class ShieldOTTTileEntity extends TileEntity implements ITickableTileEntity {

    public int x, y, z, tick;
    boolean initialized = false;

    public ShieldOTTTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public ShieldOTTTileEntity() {
        this(TileEntityTypeInit.SHIELD_OTT_TILE_ENTITY_TYPE.get());
    }

    @Override
    public void tick() {
        if (!initialized) {
            init();
        }
        tick++;
        if (tick == 10) {
            tick = 0;
            if (y > 2) {
                execute();
            }
        }
    }

    private void init() {
        initialized = true;
        x = this.worldPosition.getX() - 1;
        y = this.worldPosition.getY() - 1;
        z = this.worldPosition.getZ() - 1;
        tick = 0;
    }

    private void execute() {
        int index = 0;
        Block[] blocksAdded = new Block[15];
        for (int x = 0 ; x < 1 ; x++) {
            for (int z = 0 ; z < 15; z++) {
                BlockPos posToAdd = new BlockPos(this.x + x, this.y, this.z + z);
                blocksAdded[index] = this.level.getBlockState(posToAdd).getBlock();
                addBlock(posToAdd, true, null);
                index++;
            }
        }
        this.y--;
    }

    private boolean addBlock(BlockPos pos, boolean dropBlock, @Nullable Entity entity) {
        BlockState state = level.getBlockState(pos);
        if (!state.isAir(level, pos)) {
            return false;
        } else {
            FluidState fluidState = level.getFluidState(pos);
            level.levelEvent(2001, pos, Block.getId(state));
            return level.setBlock(pos, fluidState.createLegacyBlock(), 3);
        }
    }

    @Override
    public CompoundNBT save(CompoundNBT compound) {
        compound.put("initvalues", NBTHelper.toNBT(this));
        return super.save(compound);
    }

    @Override
    public void load(BlockState state, CompoundNBT compound) {
        super.load(state, compound);
        CompoundNBT initvalues = compound.getCompound("initvalues");
        if (initvalues != null) {
            this.x = initvalues.getInt("x");
            this.y = initvalues.getInt("y");
            this.z = initvalues.getInt("z");
            this.tick = 0;
            initialized = true;
            return;
        }
        init();
    }
}
