package its_meow.betteranimalsplus.entity.render;

import javax.annotation.Nonnull;

import org.lwjgl.opengl.GL11;

import its_meow.betteranimalsplus.entity.EntityFox;
import its_meow.betteranimalsplus.entity.model.ModelFox;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFox extends RenderLiving<EntityFox> {

	public RenderFox(RenderManager manager)
	{
		super(manager, new ModelFox(), 0.5F);
	}


	/**
	 * Defines what float the third param in setRotationAngles of ModelBase is
	 */
	protected float handleRotationFloat(EntityFox livingBase, float partialTicks)
	{
		return livingBase.getTailRotation();
	}

	/**
	 * Renders the desired {@code T} type Entity.
	 */
	public void doRender(EntityFox entity, double x, double y, double z, float entityYaw, float partialTicks)
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
	protected ResourceLocation getEntityTexture(EntityFox entity)
	{
		return this.getFoxTexture(entity.getTypeNumber(), entity);
	}
	
	private ResourceLocation getFoxTexture(int typeNumber, EntityFox entity) {
		ResourceLocation result = null;
		
		switch(typeNumber) {
			case 1:
				result = TextureRegistry.fox_1;
				break;
			case 2:
				result = TextureRegistry.fox_2;
				break;
			case 3:
				result = TextureRegistry.fox_3;
				break;
			case 4:
				result = TextureRegistry.fox_4;
				break;
		}
		return result;
	}

	public static final Factory FACTORY = new Factory();

	public static class Factory implements IRenderFactory<EntityFox> {

		@Override
		public Render<? super EntityFox> createRenderFor(RenderManager manager) {
			return new RenderFox(manager);
		}

	}



}
