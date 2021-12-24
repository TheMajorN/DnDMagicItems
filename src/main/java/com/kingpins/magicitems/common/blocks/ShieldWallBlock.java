package com.kingpins.magicitems.common.blocks;

import com.kingpins.magicitems.core.init.TileEntityTypeInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class ShieldWallBlock extends Block {

    public ShieldWallBlock() {
        super(AbstractBlock.Properties.of(
                        Material.WOOD, MaterialColor.COLOR_LIGHT_BLUE)
                .sound(SoundType.WOOD));

    }

    @Override
    public boolean hasTileEntity(BlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileEntityTypeInit.SHIELD_OTT_TILE_ENTITY_TYPE.get().create();
    }
}
