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
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EntityRendererRegistry {
   
	@SideOnly(Side.CLIENT)
    public static void registerEntityRenderers()
    {
		RenderingRegistry.registerEntityRenderingHandler(EntityBear.class, RenderBrownBear.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityBearNeutral.class, RenderBlackBear.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityBearNeutralKermode.class, RenderKermodeBear.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, RenderDeer.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityLammergeier.class, RenderLammergeier.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityFeralWolf.class, RenderCustomWolf.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityCoyote.class, RenderCoyote.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityFox.class, RenderFox.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaHair.class, RenderTarantulaHair.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantula.class, RenderTarantula.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityHirschgeist.class, RenderHirschgeist.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityGoat.class, RenderGoat.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, RenderJellyfish.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityPheasant.class, RenderPheasant.FACTORY);
		RenderingRegistry.registerEntityRenderingHandler(EntityReindeer.class, RenderReindeer.FACTORY);
    }

}