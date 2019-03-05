package its_meow.betteranimalsplus.client;

import org.apache.logging.log4j.Level;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBlackBear;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBoar;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBrownBear;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCoyote;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCustomWolf;
import its_meow.betteranimalsplus.client.renderer.entity.RenderDeer;
import its_meow.betteranimalsplus.client.renderer.entity.RenderFox;
import its_meow.betteranimalsplus.client.renderer.entity.RenderGoat;
import its_meow.betteranimalsplus.client.renderer.entity.RenderHirschgeist;
import its_meow.betteranimalsplus.client.renderer.entity.RenderJellyfish;
import its_meow.betteranimalsplus.client.renderer.entity.RenderKermodeBear;
import its_meow.betteranimalsplus.client.renderer.entity.RenderLammergeier;
import its_meow.betteranimalsplus.client.renderer.entity.RenderPheasant;
import its_meow.betteranimalsplus.client.renderer.entity.RenderReindeer;
import its_meow.betteranimalsplus.client.renderer.entity.RenderSquirrel;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantula;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantulaHair;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockHandOfFate;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockTrillium;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderGenericHead;
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
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientLifecycleHandler {

	public void clientSetup(final FMLClientSetupEvent event) {
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrillium.class, new RenderBlockTrillium());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHandOfFate.class, new RenderBlockHandOfFate());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHead.class, new RenderGenericHead());
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
		BetterAnimalsPlusMod.logger.log(Level.INFO, "Rendering squirrel physics...");
	}

}
