package com.kingpins.magicitems.common.blocks;

import com.kingpins.magicitems.core.init.BlockInit;
import com.kingpins.magicitems.core.init.TileEntityTypeInit;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import javax.annotation.Nullable;

public class ShieldWallBlock extends Block {

    public ShieldWallBlock() {
        super(AbstractBlock.Properties.of(
                        Material.WOOD, MaterialColor.COLOR_LIGHT_BLUE)
                .sound(SoundType.WOOD));

    }
}
