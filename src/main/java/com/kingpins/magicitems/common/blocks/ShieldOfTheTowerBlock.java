package com.kingpins.magicitems.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;

public class ShieldOfTheTowerBlock extends Block {
    public ShieldOfTheTowerBlock() {
        super(AbstractBlock.Properties.of(
                        Material.WOOD, MaterialColor.COLOR_BROWN)
                        .sound(SoundType.WOOD));
    }
}
