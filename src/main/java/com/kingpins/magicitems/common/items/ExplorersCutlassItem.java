package com.kingpins.magicitems.common.items;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ShearsItem;
import net.minecraft.tags.BlockTags;

public class ExplorersCutlassItem extends ShearsItem {
    public ExplorersCutlassItem(Properties properties) {
        super(properties);
    }

    @Override
    public float getDestroySpeed(ItemStack itemStack, BlockState state) {
        if (!state.is(Blocks.CACTUS)
            && !state.is(BlockTags.LEAVES)
            && !state.is(BlockTags.FLOWERS)
            && !state.is(BlockTags.CRIMSON_STEMS)
            && !state.is(BlockTags.WARPED_STEMS)
            && !state.is(BlockTags.BAMBOO_PLANTABLE_ON)) {
            return state.is(BlockTags.WOOL) ? 5.0F : super.getDestroySpeed(itemStack, state);
        } else {
            return 15.0F;
        }
    }

    @Override
    public boolean isCorrectToolForDrops(BlockState state) {
        return state.is(Blocks.CACTUS)
                || state.is(BlockTags.LEAVES)
                || state.is(BlockTags.FLOWERS)
                || state.is(BlockTags.CRIMSON_STEMS)
                || state.is(BlockTags.WARPED_STEMS)
                || state.is(BlockTags.BAMBOO_PLANTABLE_ON);
    }
}
