package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.init.MobRegistry;
import net.minecraft.world.World;

public class EntityBearNeutralKermode extends EntityBearNeutral {

	public EntityBearNeutralKermode(World worldIn) {
		super(MobRegistry.getType(EntityBearNeutralKermode.class), worldIn);
	}

}
