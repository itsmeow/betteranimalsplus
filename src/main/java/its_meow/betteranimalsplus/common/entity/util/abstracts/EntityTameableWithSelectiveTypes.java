package its_meow.betteranimalsplus.common.entity.util.abstracts;

import its_meow.betteranimalsplus.common.entity.util.ISelectiveVariantTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class EntityTameableWithSelectiveTypes extends EntityTameableWithTypes implements ISelectiveVariantTypes<EntityTameableBetterAnimalsPlus> {

    public EntityTameableWithSelectiveTypes(EntityType<? extends EntityTameableWithSelectiveTypes> type, World world) {
        super(type, world);
    }

}
