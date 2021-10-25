package com.kingpins.magicitems.common.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class GenericBlock extends Block {

    public GenericBlock() {
        super(AbstractBlock.Properties.of(Material.HEAVY_METAL));
    }
}
