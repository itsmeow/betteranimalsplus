package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityEelBase;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public class EntityFreshwaterEel extends EntityEelBase {

    public EntityFreshwaterEel(EntityType<? extends EntityFreshwaterEel> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    public EntityTypeContainer<EntityFreshwaterEel> getContainer() {
        return ModEntities.EEL_FRESHWATER;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.EEL_FRESHWATER;
    }
}
