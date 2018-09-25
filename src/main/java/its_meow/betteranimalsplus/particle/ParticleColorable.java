package its_meow.betteranimalsplus.particle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ParticleColorable extends Particle {
	
	public ParticleColorable(World worldIn, double xCoordIn, double yCoordIn, double zCoordIn, double xSpeedIn, double ySpeedIn, double zSpeedIn, ResourceLocation locIn, float sizeIn, int rColorIn, int gColorIn, int bColorIn)
	{
		super(worldIn, xCoordIn, yCoordIn, zCoordIn, xSpeedIn, ySpeedIn, zSpeedIn);

        this.motionX = 0.0F;
        this.motionY = 0.0F;
        this.motionZ = 0.0F;
        this.posX += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.posY += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.posZ += (double)((this.rand.nextFloat() - this.rand.nextFloat()) * 0.05F);
        this.particleScale = sizeIn;
        this.particleRed = ((float) rColorIn) / 255F;
        this.particleGreen = ((float) rColorIn) / 255F;
        this.particleBlue = ((float) rColorIn) / 255F;
        this.particleMaxAge = 16;
        
        this.setParticleTexture(Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(locIn.toString()));
	}
	
	@Override
    public void renderParticle(BufferBuilder buffer, Entity entityIn, float partialTicks, float rotationX, float rotationZ, float rotationYZ, float rotationXY, float rotationXZ)
    {
        float f = ((float)this.particleAge + partialTicks) / (float)this.particleMaxAge;
        super.renderParticle(buffer, entityIn, partialTicks, rotationX, rotationZ, rotationYZ, rotationXY, rotationXZ);
    }
	
	@Override
	public int getFXLayer()
	{
		return 1;
	}
	
}
