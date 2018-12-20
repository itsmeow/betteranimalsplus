package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.common.entity.EntityFox;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityRendererRegistry {
   
	@SideOnly(Side.CLIENT)
    public static void registerEntityRenderers()
    {
    	registerEntityRenderer(EntityBear.class, RenderBrownBear.FACTORY);
		registerEntityRenderer(EntityBearNeutral.class, RenderBlackBear.FACTORY);
		registerEntityRenderer(EntityBearNeutralKermode.class, RenderKermodeBear.FACTORY);
		registerEntityRenderer(EntityDeer.class, RenderDeer.FACTORY);
		registerEntityRenderer(EntityLammergeier.class, RenderLammergeier.FACTORY);
		registerEntityRenderer(EntityFeralWolf.class, RenderCustomWolf.FACTORY);
		registerEntityRenderer(EntityCoyote.class, RenderCoyote.FACTORY);
		registerEntityRenderer(EntityFox.class, RenderFox.FACTORY);
		registerEntityRenderer(EntityTarantulaHair.class, RenderTarantulaHair.FACTORY);
		registerEntityRenderer(EntityTarantula.class, RenderTarantula.FACTORY);
		registerEntityRenderer(EntityHirschgeist.class, RenderHirschgeist.FACTORY);
		registerEntityRenderer(EntityGoat.class, RenderGoat.FACTORY);
		registerEntityRenderer(EntityJellyfish.class, RenderJellyfish.FACTORY);
		registerEntityRenderer(EntityPheasant.class, RenderPheasant.FACTORY);
		registerEntityRenderer(EntityReindeer.class, RenderReindeer.FACTORY);
    }
    
	@SideOnly(Side.CLIENT)
	public static void registerEntityRenderer(Class EntityClass, IRenderFactory RenderFactory){
		RenderingRegistry.registerEntityRenderingHandler(EntityClass, RenderFactory);
	}

}