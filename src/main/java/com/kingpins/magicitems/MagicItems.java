package com.kingpins.magicitems;

import com.kingpins.magicitems.common.entities.VoxSeekerEntity;
import com.kingpins.magicitems.core.init.*;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Supplier;


@Mod(MagicItems.MOD_ID)
public class MagicItems {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "dndmi";

    public MagicItems() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        ItemInit.ITEMS.register(bus);
        BlockInit.BLOCKS.register(bus);
        SoundInit.SOUNDS.register(bus);
        EntityTypeInit.ENTITIES.register(bus);
        TileEntityTypeInit.TILE_ENTITIES.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void registerEntityModels(Supplier<Minecraft> minecraft) {
        ItemRenderer renderer = minecraft.get().getItemRenderer();

        RenderingRegistry.registerEntityRenderingHandler(EntityTypeInit.SLIP_RAZOR_ENTITY.get(),
                (rendererManager) -> new SpriteRenderer<>(rendererManager, renderer));
    }

    private void doClientStuff(final FMLClientSetupEvent event) {
        registerEntityModels(event.getMinecraftSupplier());
    }

    private void setup(final FMLCommonSetupEvent event) {
        DeferredWorkQueue.runLater(() -> {
            GlobalEntityTypeAttributes.put(EntityTypeInit.VOX_SEEKER_ENTITY.get(), VoxSeekerEntity.setCustomAttributes().build());
        });
    }
}
