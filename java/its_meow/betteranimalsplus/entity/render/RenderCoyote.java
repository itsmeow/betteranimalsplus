package its_meow.betteranimalsplus.entity.render;

import javax.annotation.Nonnull;

import org.lwjgl.opengl.GL11;

import its_meow.betteranimalsplus.entity.EntityBear;
import its_meow.betteranimalsplus.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.entity.EntityCoyote;
import its_meow.betteranimalsplus.entity.model.ModelCustomWolf;
import its_meow.betteranimalsplus.entity.render.RenderKermodeBear.Factory;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.model.ModelWolf;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerWolfCollar;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderCoyote extends RenderLiving<EntityCoyote> {

	public RenderCoyote(RenderManager manager)
	{
		super(manager, new ModelCustomWolf(), 0.5F);
		this.addLayer(new LayerCoyoteEyes(this));
	}


	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	protected float handleRotationFloat(EntityWolf livingBase, float partialTicks)
	{
		return livingBase.getTailRotation();
	}

	/**
	 * Renders the desired {@code T} type Entity.
	 */
	public void doRender(EntityCoyote entity, double x, double y, double z, float entityYaw, float partialTicks)
	{
		if (entity.isWolfWet())
		{
			float f = entity.getBrightness() * entity.getShadingWhileWet(partialTicks);
			GlStateManager.color(f, f, f);
		}

		super.doRender(entity, x, y, z, entityYaw, partialTicks);
	}

	/**
	 * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
	 */
	protected ResourceLocation getEntityTexture(EntityCoyote entity)
	{
		return this.getCoyoteTexture(entity);
	}
	
	private ResourceLocation getCoyoteTexture(EntityCoyote entity) {	
		if(entity.isTamed()) {
			return TextureRegistry.coyote_neutral;
		} else if(entity.isDaytime()) {
			return TextureRegistry.coyote_neutral;
		} else {
			return TextureRegistry.coyote_hostile;
		}
	}

	public static final Factory FACTORY = new Factory();

	public static class Factory implements IRenderFactory<EntityCoyote> {

		@Override
		public Render<? super EntityCoyote> createRenderFor(RenderManager manager) {
			return new RenderCoyote(manager);
		}

	}



}
