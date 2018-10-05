package its_meow.betteranimalsplus.common.particle;

import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ParticleSparksOrange extends ParticleColorable {

	public ParticleSparksOrange(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn) {
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, 0, 0, 0, TextureRegistry.sparks, 1, 255, 231, 181);
		
	}

}
