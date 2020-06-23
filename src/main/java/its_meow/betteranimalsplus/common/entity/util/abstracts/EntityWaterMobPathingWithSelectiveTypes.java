package its_meow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.util.ISelectiveVariantTypes;
import net.minecraft.entity.EntityType;
import net.minecraft.world.World;

public abstract class EntityWaterMobPathingWithSelectiveTypes extends EntityWaterMobPathingWithTypes implements ISelectiveVariantTypes<EntityWaterMobPathing> {

    public EntityWaterMobPathingWithSelectiveTypes(EntityType<? extends EntityWaterMobPathingWithSelectiveTypes> type, World world) {
        super(type, world);
    }

}
