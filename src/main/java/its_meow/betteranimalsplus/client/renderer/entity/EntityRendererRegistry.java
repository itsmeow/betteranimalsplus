package its_meow.betteranimalsplus.client.renderer.entity;

import its_meow.betteranimalsplus.Ref;
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
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Ref.MOD_ID, value = Side.CLIENT)
public class EntityRendererRegistry {
   
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
    public static void registerEntityRenderers(ModelRegistryEvent event)
    {
		RenderingRegistry.registerEntityRenderingHandler(EntityBear.class, m -> new RenderBrownBear(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityBearNeutral.class, m -> new RenderBlackBear(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityBearNeutralKermode.class, m -> new RenderKermodeBear(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, m -> new RenderDeer(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityLammergeier.class, m -> new RenderLammergeier(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityFeralWolf.class, m -> new RenderCustomWolf(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityCoyote.class, m -> new RenderCoyote(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityFox.class, m -> new RenderFox(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaHair.class, m -> new RenderTarantulaHair(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityTarantula.class, m -> new RenderTarantula(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityHirschgeist.class, m -> new RenderHirschgeist(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityGoat.class, m -> new RenderGoat(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, m -> new RenderJellyfish(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityPheasant.class, m -> new RenderPheasant(m));
		RenderingRegistry.registerEntityRenderingHandler(EntityReindeer.class, m -> new RenderReindeer(m));
    }

}