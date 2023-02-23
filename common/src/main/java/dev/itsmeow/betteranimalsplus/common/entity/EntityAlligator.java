package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityCrocidilian;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class EntityAlligator extends EntityCrocidilian {

    public EntityAlligator(EntityType<? extends EntityAlligator> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public EntityTypeContainer<? extends EntityAnimalWithTypes> getContainer() {
        return ModEntities.ALLIGATOR;
    }

    @Override
    public IVariant getRandomType() {
        if(this.getRandom().nextFloat() <= 0.125F) {
            return getContainer().getVariantForName("albino").orElse(null);
        }
        return getContainer().getVariantForName("american").orElse(null);
    }
}
