package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutralKermode;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.common.entity.EntityFox;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = Ref.MOD_ID, value = Dist.CLIENT)
public class EntityRendererRegistry {
   
	@OnlyIn(Dist.CLIENT)
	@SubscribeEvent
    public static void registerEntityRenderers(ModelRegistryEvent event)
    {
		RenderingRegistry.registerEntityRenderingHandler(EntityBear.class, RenderBrownBear::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityBearNeutral.class, RenderBlackBear::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityBearNeutralKermode.class, RenderKermodeBear::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, RenderDeer::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityLammergeier.class, RenderLammergeier::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFeralWolf.class, RenderCustomWolf::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityCoyote.class, RenderCoyote::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityFox.class, RenderFox::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaHair.class, RenderTarantulaHair::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantula.class, RenderTarantula::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityHirschgeist.class, RenderHirschgeist::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityGoat.class, RenderGoat::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, RenderJellyfish::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityPheasant.class, RenderPheasant::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityReindeer.class, RenderReindeer::new);
		RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, RenderBoar::new);
		RenderingRegistry.registerEntityRenderingHandler(EntitySquirrel.class, RenderSquirrel::new);
    }

}