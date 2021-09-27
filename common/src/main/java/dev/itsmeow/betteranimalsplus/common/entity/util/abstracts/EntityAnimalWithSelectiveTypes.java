package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.interfaces.ISelectiveVariantTypes;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public abstract class EntityAnimalWithSelectiveTypes extends EntityAnimalWithTypes implements ISelectiveVariantTypes<EntityAnimalWithTypes> {

    public EntityAnimalWithSelectiveTypes(EntityType<? extends EntityAnimalWithSelectiveTypes> type, Level world) {
        super(type, world);
    }

}
