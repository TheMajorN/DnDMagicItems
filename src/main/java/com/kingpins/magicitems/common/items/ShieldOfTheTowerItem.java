package com.kingpins.magicitems.common.items;

import com.kingpins.magicitems.core.init.BlockInit;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUseContext;
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
            level.setBlock(pos,
                    BlockInit.SHIELD_WALL_BLOCK.get().defaultBlockState(), 1);
            for (int i = 0 ; i < 6 ; i++) {
                level.setBlock(pos.east(i),
                        BlockInit.SHIELD_WALL_BLOCK.get().defaultBlockState(), 1);
            }
            for (int i = 0 ; i < 6 ; i++) {
                level.setBlock(pos.west(i),
                        BlockInit.SHIELD_WALL_BLOCK.get().defaultBlockState(), 1);
            }
            for (int i = 0 ; i < 6 ; i++) {
                level.setBlock(pos.above(i),
                        BlockInit.SHIELD_WALL_BLOCK.get().defaultBlockState(), 1);
            }
        }
        return ActionResultType.SUCCESS;
    }
}
