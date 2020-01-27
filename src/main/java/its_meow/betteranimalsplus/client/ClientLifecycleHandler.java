package its_meow.betteranimalsplus.client;

import org.apache.logging.log4j.Level;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.model.ModelHirschgeistHelmet;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBadger;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBlackBear;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBoar;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBobbitWorm;
import its_meow.betteranimalsplus.client.renderer.entity.RenderBrownBear;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCoyote;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCrab;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCustomWolf;
import its_meow.betteranimalsplus.client.renderer.entity.RenderDeer;
import its_meow.betteranimalsplus.client.renderer.entity.RenderGoat;
import its_meow.betteranimalsplus.client.renderer.entity.RenderGoose;
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
import its_meow.betteranimalsplus.client.renderer.entity.RenderTurkey;
import its_meow.betteranimalsplus.client.renderer.entity.RenderZotzpyre;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockHandOfFate;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockTrillium;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderGenericHead;
import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import its_meow.betteranimalsplus.common.entity.projectile.EntityPheasantEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTurkeyEgg;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
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
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.TRILLIUM_TYPE, dispatcher -> new RenderBlockTrillium());
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.HAND_OF_FATE_TYPE, dispatcher -> new RenderBlockHandOfFate());
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.HEAD_TYPE, dispatcher -> new RenderGenericHead());
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BROWN_BEAR.entityType, RenderBrownBear::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BLACK_BEAR.entityType, RenderBlackBear::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.DEER.entityType, RenderDeer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.LAMMERGEIER.entityType, RenderLammergeier::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.FERAL_WOLF.entityType, RenderCustomWolf::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.COYOTE.entityType, RenderCoyote::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaHair.HAIR_TYPE, RenderTarantulaHair::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TARANTULA.entityType, RenderTarantula::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HIRSCHGEIST.entityType, RenderHirschgeist::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.GOAT.entityType, RenderGoat::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.JELLYFISH.entityType, RenderJellyfish::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PHEASANT.entityType, RenderPheasant::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.REINDEER.entityType, RenderReindeer::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BOAR.entityType, RenderBoar::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SQUIRREL.entityType, RenderSquirrel::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SONGBIRD.entityType, RenderSongbird::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BADGER.entityType, RenderBadger::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBadgerDirt.DIRT_TYPE, RenderNothing<EntityBadgerDirt>::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.LAMPREY.entityType, RenderLamprey::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.NAUTILUS.entityType, RenderNautilus::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.CRAB.entityType, RenderCrab::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HORSESHOE_CRAB.entityType, RenderHorseshoeCrab::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SHARK.entityType, RenderShark::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MOOSE.entityType, RenderMoose::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPheasantEgg.PHEASANT_EGG_TYPE, mgr -> new SpriteRenderer<>(mgr, Minecraft.getInstance().getItemRenderer()));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TURKEY.entityType, RenderTurkey::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTurkeyEgg.TURKEY_EGG_TYPE, mgr -> new SpriteRenderer<>(mgr, Minecraft.getInstance().getItemRenderer()));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.ZOTZPYRE.entityType, RenderZotzpyre::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BOBBIT_WORM.entityType, RenderBobbitWorm::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.GOOSE.entityType, RenderGoose::new);
        BetterAnimalsPlusMod.logger.log(Level.INFO, "Rendering squirrel physics...");
    }

}
