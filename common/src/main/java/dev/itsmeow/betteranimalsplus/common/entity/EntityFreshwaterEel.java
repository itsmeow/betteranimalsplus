package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityEelBase;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityFreshwaterEel extends EntityEelBase {

    public EntityFreshwaterEel(EntityType<? extends EntityFreshwaterEel> entityType, Level worldIn) {
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
