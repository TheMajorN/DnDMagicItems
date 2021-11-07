package com.kingpins.magicitems.core.init;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.common.blocks.ChimeOfBeastDiscoveryBlock;
import com.kingpins.magicitems.common.blocks.ShieldWallBlock;
import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class BlockInit {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS,
            MagicItems.MOD_ID);

    //=====BLOCK ITEMS=====
    //public static final RegistryObject<Block> MACE_OF_THE_MULE = BLOCKS.register("mace_of_the_mule", MaceOfTheMuleBlock::new);

    public static final RegistryObject<Block> CHIME_OF_BEAST_DISCOVERY = BLOCKS.register("chime_of_beast_discovery",
            ChimeOfBeastDiscoveryBlock::new);

    //=====SHIELD OF THE TOWER BLOCK
    public static final RegistryObject<Block> SHIELD_OF_THE_TOWER_BLOCK = BLOCKS.register("shield_wall",
            ShieldWallBlock::new);

}
