package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.interfaces.ISelectiveVariantTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public abstract class EntityWaterMobPathingWithSelectiveTypes extends EntityWaterMobPathingWithTypes implements ISelectiveVariantTypes<EntityWaterMobPathing> {

    public EntityWaterMobPathingWithSelectiveTypes(EntityType<? extends EntityWaterMobPathingWithSelectiveTypes> type, Level world) {
        super(type, world);
    }

}
