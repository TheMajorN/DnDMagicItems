package com.kingpins.magicitems.core.init;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.common.entities.SlipRazorEntity;
import com.kingpins.magicitems.common.entities.VoxSeekerEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            MagicItems.MOD_ID);

    //=====THROWABLE ITEMS=====
    public static final RegistryObject<EntityType<SlipRazorEntity>> SLIP_RAZOR_ENTITY = ENTITIES.register("slip_razor",
            () -> EntityType.Builder.<SlipRazorEntity>of(SlipRazorEntity::new, EntityClassification.MISC)
                    .sized(0.25F, 0.25F).build("slip_razor"));

    //=====LIVING CREATURES=====
    public static final RegistryObject<EntityType<VoxSeekerEntity>> VOX_SEEKER_ENTITY = ENTITIES.register("vox_seeker",
            () -> EntityType.Builder.of(VoxSeekerEntity::new,
                    EntityClassification.CREATURE).sized(1.0F, 1.0F)
                    .build(new ResourceLocation(MagicItems.MOD_ID, "vox_seeker").toString()));

}
