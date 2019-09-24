package its_meow.betteranimalsplus.client;

import org.apache.logging.log4j.Level;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.model.ModelHirschgeistHelmet;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBadger;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBlackBear;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBoar;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBrownBear;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCoyote;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCrab;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCustomWolf;
import its_meow.betteranimalsplus.client.renderer.entity.RenderDeer;
import its_meow.betteranimalsplus.client.renderer.entity.RenderGoat;
import its_meow.betteranimalsplus.client.renderer.entity.RenderHirschgeist;
import its_meow.betteranimalsplus.client.renderer.entity.RenderHorseshoeCrab;
import its_meow.betteranimalsplus.client.renderer.entity.RenderJellyfish;
import its_meow.betteranimalsplus.client.renderer.entity.RenderLammergeier;
import its_meow.betteranimalsplus.client.renderer.entity.RenderLamprey;
import its_meow.betteranimalsplus.client.renderer.entity.RenderMoose;
import its_meow.betteranimalsplus.client.renderer.entity.RenderNautilus;
import its_meow.betteranimalsplus.client.renderer.entity.RenderNothing;
import its_meow.betteranimalsplus.client.renderer.entity.RenderPheasant;
import its_meow.betteranimalsplus.client.renderer.entity.RenderReindeer;
import its_meow.betteranimalsplus.client.renderer.entity.RenderShark;
import its_meow.betteranimalsplus.client.renderer.entity.RenderSongbird;
import its_meow.betteranimalsplus.client.renderer.entity.RenderSquirrel;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantula;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantulaHair;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockHandOfFate;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockTrillium;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderGenericHead;
import its_meow.betteranimalsplus.common.entity.EntityBadger;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.common.entity.EntityHorseshoeCrab;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityLamprey;
import its_meow.betteranimalsplus.common.entity.EntityMoose;
import its_meow.betteranimalsplus.common.entity.EntityNautilus;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.common.entity.EntityShark;
import its_meow.betteranimalsplus.common.entity.EntitySongbird;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientLifecycleHandler {

    public static final ModelHirschgeistHelmet<LivingEntity> armorModel = new ModelHirschgeistHelmet<LivingEntity>();

    @SuppressWarnings("unchecked")
    public static <A extends BipedModel<?>> A getArmorModel() {
        return (A) armorModel;
    }

    public void clientSetup(final FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrillium.class, new RenderBlockTrillium());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHandOfFate.class, new RenderBlockHandOfFate());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHead.class, new RenderGenericHead());
        RenderingRegistry.registerEntityRenderingHandler(EntityBear.class, RenderBrownBear::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBearNeutral.class, RenderBlackBear::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, RenderDeer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLammergeier.class, RenderLammergeier::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityFeralWolf.class, RenderCustomWolf::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCoyote.class, RenderCoyote::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaHair.class, RenderTarantulaHair::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTarantula.class, RenderTarantula::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHirschgeist.class, RenderHirschgeist::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGoat.class, RenderGoat::new);    
        RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, RenderJellyfish::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPheasant.class, RenderPheasant::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityReindeer.class, RenderReindeer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, RenderBoar::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySquirrel.class, RenderSquirrel::new);
        RenderingRegistry.registerEntityRenderingHandler(EntitySongbird.class, RenderSongbird::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBadger.class, RenderBadger::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBadgerDirt.class, RenderNothing<EntityBadgerDirt>::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLamprey.class, RenderLamprey::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityNautilus.class, RenderNautilus::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCrab.class, RenderCrab::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityHorseshoeCrab.class, RenderHorseshoeCrab::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityShark.class, RenderShark::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMoose.class, RenderMoose::new);
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Rendering squirrel physics...");
    }

}
