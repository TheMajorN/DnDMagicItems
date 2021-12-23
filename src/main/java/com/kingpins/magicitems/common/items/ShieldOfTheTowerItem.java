package com.kingpins.magicitems.common.items;

import com.kingpins.magicitems.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.item.ShieldItem;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ShieldOfTheTowerItem extends Item {

    public ShieldOfTheTowerItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResultType useOn(ItemUseContext useContext) {
        PlayerEntity player = useContext.getPlayer();
        World level = player.level;
        BlockPos pos = useContext.getClickedPos();
        BlockState state = level.getBlockState(pos);

        if (!state.isAir()) {
            level.setBlockAndUpdate(pos,
                    BlockInit.SHIELD_OF_THE_TOWER_BLOCK.get().defaultBlockState());
            for (int i = 0 ; i < 6 ; i++) {
                level.setBlockAndUpdate(pos.east(i),
                        BlockInit.SHIELD_OF_THE_TOWER_BLOCK.get().defaultBlockState());
            }
            for (int i = 0 ; i < 6 ; i++) {
                level.setBlockAndUpdate(pos.west(i),
                        BlockInit.SHIELD_OF_THE_TOWER_BLOCK.get().defaultBlockState());
            }
            for (int i = 0 ; i < 6 ; i++) {
                level.setBlockAndUpdate(pos.above(i),
                        BlockInit.SHIELD_OF_THE_TOWER_BLOCK.get().defaultBlockState());
            }
        }
        return ActionResultType.SUCCESS;
    }
}
