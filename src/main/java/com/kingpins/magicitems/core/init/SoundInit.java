package com.kingpins.magicitems.core.init;

import com.kingpins.magicitems.MagicItems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SoundInit {

    public static final DeferredRegister<SoundEvent> SOUNDS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS,
            MagicItems.MOD_ID);

    //=====MACE OF THE MULE=====
    public static final RegistryObject<SoundEvent> MACE_OF_THE_MULE_SOUND = SOUNDS.register
            ("mace_of_the_mule_sound", () -> new SoundEvent(new ResourceLocation(MagicItems.MOD_ID, "mace_of_the_mule_sound")));

    //=====SLIP RAZOR=====
    public static final RegistryObject<SoundEvent> TELEPORT_SOUND = SOUNDS.register
            ("teleport_sound", () -> new SoundEvent(new ResourceLocation(MagicItems.MOD_ID, "teleport_sound")));

    //=====CHIME OF BEAST DISCOVERY=====
    public static final RegistryObject<SoundEvent> CHIME_OBD_SOUND = SOUNDS.register
            ("chime_obd_sound", () -> new SoundEvent(new ResourceLocation(MagicItems.MOD_ID, "chime_obd_sound")));
}
