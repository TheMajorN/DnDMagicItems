package com.kingpins.magicitems.core.init;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.client.render.tileentity.ChimeOBDTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypeInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITIES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES,
            MagicItems.MOD_ID);

    public static final RegistryObject<TileEntityType<ChimeOBDTileEntity>> CHIME_OBD_TILE_ENTITY_TYPE = TILE_ENTITIES.register("chime_of_beast_discovery",
            () -> TileEntityType.Builder.of(ChimeOBDTileEntity::new, BlockInit.CHIME_OF_BEAST_DISCOVERY.get()).build(null));

}
