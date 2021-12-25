package com.kingpins.magicitems.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class ShieldWallBlock extends Block {



    public ShieldWallBlock() {
        super(AbstractBlock.Properties.of(
                        Material.WOOD, MaterialColor.COLOR_LIGHT_BLUE)
                .sound(SoundType.WOOD));

    }
}