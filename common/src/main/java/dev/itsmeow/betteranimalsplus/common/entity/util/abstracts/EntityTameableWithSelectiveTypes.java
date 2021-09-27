package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.interfaces.ISelectiveVariantTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public abstract class EntityTameableWithSelectiveTypes extends EntityTameableWithTypes implements ISelectiveVariantTypes<EntityTameableBetterAnimalsPlus> {

    public EntityTameableWithSelectiveTypes(EntityType<? extends EntityTameableWithSelectiveTypes> type, Level world) {
        super(type, world);
    }

}
