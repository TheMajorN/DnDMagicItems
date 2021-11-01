package com.kingpins.magicitems.core.init;

import com.kingpins.magicitems.MagicItems;
import com.kingpins.magicitems.common.entities.SlipRazorEntity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class EntityTypeInit {

    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES,
            MagicItems.MOD_ID);

    public static final RegistryObject<EntityType<SlipRazorEntity>> SLIP_RAZOR_ENTITY = ENTITIES.register("slip_razor",
            () -> EntityType.Builder.<SlipRazorEntity>of(SlipRazorEntity::new, EntityClassification.MISC)
                    .sized(0.25F, 0.25F).build("slip_razor"));

}
