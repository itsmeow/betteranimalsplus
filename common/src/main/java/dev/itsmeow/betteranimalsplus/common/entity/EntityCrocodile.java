package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityCrocidilian;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityCrocodile extends EntityCrocidilian {

    public EntityCrocodile(EntityType<? extends EntityCrocidilian> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public EntityTypeContainer<? extends EntityWaterMobPathing> getContainer() {
        return ModEntities.CROCODILE;
    }

}
