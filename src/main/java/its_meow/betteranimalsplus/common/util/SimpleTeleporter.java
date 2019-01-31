package its_meow.betteranimalsplus.common.util;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ITeleporter;

/** Set your own location when using. Otherwise you will be thrown at the same spot you were at. **/
public class SimpleTeleporter implements ITeleporter {

	@Override
	public void placeEntity(World world, Entity entity, float yaw) {
		
	}

}
