package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.world.World;

public class EntityBearNeutralKermode extends EntityBearNeutral {

    public EntityBearNeutralKermode(World worldIn) {
        super(ModEntities.getEntityType("kermodebear"), worldIn);
    }

}
