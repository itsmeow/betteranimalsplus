package its_meow.betteranimalsplus.client;

import com.mojang.blaze3d.platform.GlStateManager;

import dev.itsmeow.imdlib.client.IMDLibClient;
import dev.itsmeow.imdlib.client.render.RenderFactory;
import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.client.model.ModelBadger;
import its_meow.betteranimalsplus.client.model.ModelBeakedWhale;
import its_meow.betteranimalsplus.client.model.ModelBear;
import its_meow.betteranimalsplus.client.model.ModelBoar;
import its_meow.betteranimalsplus.client.model.ModelBobbitWorm;
import its_meow.betteranimalsplus.client.model.ModelButterfly;
import its_meow.betteranimalsplus.client.model.ModelCoyote;
import its_meow.betteranimalsplus.client.model.ModelCrab;
import its_meow.betteranimalsplus.client.model.ModelDeer;
import its_meow.betteranimalsplus.client.model.ModelDragonfly;
import its_meow.betteranimalsplus.client.model.ModelFeralWolf;
import its_meow.betteranimalsplus.client.model.ModelFreshwaterEel;
import its_meow.betteranimalsplus.client.model.ModelGoat;
import its_meow.betteranimalsplus.client.model.ModelGoose;
import its_meow.betteranimalsplus.client.model.ModelGreenlandShark;
import its_meow.betteranimalsplus.client.model.ModelHirschgeistMain;
import its_meow.betteranimalsplus.client.model.ModelHorseshoeCrab;
import its_meow.betteranimalsplus.client.model.ModelJellyfish;
import its_meow.betteranimalsplus.client.model.ModelLammergeier;
import its_meow.betteranimalsplus.client.model.ModelLamprey;
import its_meow.betteranimalsplus.client.model.ModelMoose;
import its_meow.betteranimalsplus.client.model.ModelNautilus;
import its_meow.betteranimalsplus.client.model.ModelPheasant;
import its_meow.betteranimalsplus.client.model.ModelReindeer;
import its_meow.betteranimalsplus.client.model.ModelSaltwaterEel;
import its_meow.betteranimalsplus.client.model.ModelShark;
import its_meow.betteranimalsplus.client.model.ModelSmallWhale;
import its_meow.betteranimalsplus.client.model.ModelSongbird;
import its_meow.betteranimalsplus.client.model.ModelSongbirdSmall;
import its_meow.betteranimalsplus.client.model.ModelSquirrel;
import its_meow.betteranimalsplus.client.model.ModelTarantula;
import its_meow.betteranimalsplus.client.model.ModelTurkey;
import its_meow.betteranimalsplus.client.model.ModelWalrus;
import its_meow.betteranimalsplus.client.model.ModelZotzpyre;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantulaHair;
import its_meow.betteranimalsplus.client.renderer.entity.layers.GooseItemLayerRenderer;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyes;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyesCondition;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockHandOfFate;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockTrillium;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderGenericHead;
import its_meow.betteranimalsplus.common.entity.EntityBadger;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityBobbitWorm;
import its_meow.betteranimalsplus.common.entity.EntityButterfly;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityDragonfly;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf;
import its_meow.betteranimalsplus.common.entity.EntityFreshwaterEel;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.common.entity.EntityGoose;
import its_meow.betteranimalsplus.common.entity.EntityHorseshoeCrab;
import its_meow.betteranimalsplus.common.entity.EntityJellyfish;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityLamprey;
import its_meow.betteranimalsplus.common.entity.EntityMoose;
import its_meow.betteranimalsplus.common.entity.EntityNautilus;
import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.common.entity.EntitySaltwaterEel;
import its_meow.betteranimalsplus.common.entity.EntityShark;
import its_meow.betteranimalsplus.common.entity.EntitySongbird;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.EntityTurkey;
import its_meow.betteranimalsplus.common.entity.EntityWalrus;
import its_meow.betteranimalsplus.common.entity.EntityWhale;
import its_meow.betteranimalsplus.common.entity.EntityZotzpyre;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import its_meow.betteranimalsplus.common.entity.projectile.EntityGoldenGooseEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityGooseEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityPheasantEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTurkeyEgg;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import its_meow.betteranimalsplus.init.ModResources;
import net.minecraft.entity.Pose;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientLifecycleHandler {

    public static final RenderFactory R = IMDLibClient.getRenderRegistry(Ref.MOD_ID);

    public void clientSetup(final FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrillium.class, new RenderBlockTrillium());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHandOfFate.class, new RenderBlockHandOfFate());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHead.class, new RenderGenericHead());

        R.addRender(EntityBear.class, 1F, r -> r.tSingle("bear_brown").mSingle(new ModelBear<>()).preRender((e, f) -> GlStateManager.scalef(1.3F, 1.3F, 1.3F)));
        R.addRender(EntityBearNeutral.class, 1F, r -> r.tVariant().mSingle(new ModelBear<>()));
        R.addRender(EntityDeer.class, 1F, r -> r.tBabyVariant("deer_baby").mSingle(new ModelDeer<>()).childScale(0.6F));
        R.addRender(EntityLammergeier.class, 0.3F, r -> r.tVariant().mSingle(new ModelLammergeier<>()));
        R.addRender(EntityFeralWolf.class, 0.5F, r -> r.tVariant().mSingle(new ModelFeralWolf<>()).handleRotation((e, p) -> e.getTailRotation()).preRender((e, p) -> {
            if(e.isWolfWet()) {
                float f = e.getBrightness() * e.getShadingWhileWet(p);
                GlStateManager.color3f(f, f, f);
            }
        }).layer(t -> new LayerEyesCondition<>(t, ModResources.wolf_eyes, e -> !e.isTamed())));
        R.addRender(EntityCoyote.class, 0.5F, r -> r.tMapped(e -> e.isTamed() || (e.isDaytime() && !EntityCoyote.HOSTILE_DAYTIME) ? "coyote_neutral" : "coyote_hostile").mSingle(new ModelCoyote<>()).handleRotation((e, p) -> e.getTailRotation()).preRender((e, p) -> {
            if(e.isWolfWet()) {
                float f = e.getBrightness() * e.getShadingWhileWet(p);
                GlStateManager.color3f(f, f, f);
            }
        }).layer(t -> new LayerEyesCondition<>(t, ModResources.coyote_eyes, e -> !e.isTamed() && !(e.isDaytime() && !EntityCoyote.HOSTILE_DAYTIME))));
        RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaHair.class, RenderTarantulaHair::new);
        R.addRender(EntityTarantula.class, 1F, r -> r.tSingle("tarantula").mSingle(new ModelTarantula<>()).preRender((e, p) -> {
            if(e.isBesideClimbableBlock()) {
                GlStateManager.rotatef(-90, 1, 0, 0);
                GlStateManager.translatef(0.0F, 0.75F, -0.5F);
            }
        }).layer(t -> new LayerEyes<>(t, ModResources.tarantula_eyes)));
        R.addRender(EntityHirschgeist.class, 1F, r -> r.tSingle("hirschgeist").mSingle(new ModelHirschgeistMain<>()).condScale(e -> !e.isDaytime(), 2F));
        R.addRender(EntityGoat.class, 0.5F, r -> r.tVariant().mSingle(new ModelGoat<>()).childScale(0.5F));
        R.addRender(EntityJellyfish.class, 0.5F, r -> r.tVariant().mSingle(new ModelJellyfish<>()).preRender((e, p) -> {
            float s = e.getSize(Pose.STANDING).width;
            GlStateManager.scalef(s, s, s);
            GlStateManager.translatef(0, 1F, 0);
        }));
        R.addRender(EntityPheasant.class, 0.5F, r -> r.tBabyVariant("pheasant_baby").mSingle(new ModelPheasant<>()).childScale(0.5F).handleRotation((e, p) -> {
            float f = e.oFlap + (e.wingRotation - e.oFlap) * p;
            float f1 = e.oFlapSpeed + (e.destPos - e.oFlapSpeed) * p;
            return (MathHelper.sin(f) + 1.0F) * f1;
        }));
        R.addRender(EntityReindeer.class, 1F, r -> r.tVariant().mSingle(new ModelReindeer<>()).ageScale(1.3F, 0.7F));
        R.addRender(EntityBoar.class, 0.6F, r -> r.tBabyVariant("boar_baby").mSingle(new ModelBoar<>()).childScale(0.6F));
        R.addRender(EntitySquirrel.class, 0.3F, r -> r.tVariant().mSingle(new ModelSquirrel<>()).ageScale(0.5F, 0.35F));
        R.addRender(EntitySongbird.class, 0.3F, r -> r.tVariant().mCondition(e -> e.getVariantNameOrEmpty().isEmpty() || !e.getVariantNameOrEmpty().startsWith("small"), new ModelSongbird<>(), new ModelSongbirdSmall<>()).ageScale(0.5F, 0.3F));
        R.addRender(EntityBadger.class, 0.4F, r -> r.tVariant().mSingle(new ModelBadger<>()).ageScale(0.7F, 0.35F));
        R.addRender(EntityLamprey.class, 0.4F, r -> r.tVariant().mSingle(new ModelLamprey<>()).preRender((e, p) -> {
            GlStateManager.scaled(0.5D, 0.5D, 0.5D);
            if(e.getRidingEntity() != null) {
                GlStateManager.rotatef(180, 0, 1, 0);
                GlStateManager.translatef(0, 0, 0.5F);
            }
        }));
        R.addRender(EntityNautilus.class, 0.4F, r -> r.tSingle("nautilus").mSingle(new ModelNautilus<>()));
        R.addRender(EntityCrab.class, 0.4F, r -> r.tVariant().mSingle(new ModelCrab<>()).childScale(0.45F));
        R.addRender(EntityHorseshoeCrab.class, 0.4F, r -> r.tVariant().mSingle(new ModelHorseshoeCrab<>()).childScale(0.45F));
        R.addRender(EntityShark.class, 2F, r -> r.tVariant().mCondition(e -> !"greenland".equals(e.getVariantNameOrEmpty()), new ModelShark<>(), new ModelGreenlandShark<>()).preRender((e, p) -> {
            switch(e.getVariantNameOrEmpty()) {
            case "blue":
                GlStateManager.scaled(0.8D, 0.7D, 0.8D);
                break;
            case "bull":
                GlStateManager.scaled(0.6D, 0.6D, 0.6D);
                break;
            case "tiger":
                GlStateManager.scaled(1.1D, 1.1D, 1.1D);
                break;
            case "whitetip":
                GlStateManager.scaled(0.8D, 0.8D, 0.8D);
                break;
            case "greenland":
                GlStateManager.scaled(1.7D, 1.7D, 1.7D);
                GlStateManager.translated(0D, 0.3D, 0D);
                break;
            default:
                break;
            }
        }));
        R.addRender(EntityMoose.class, 0.8F, r -> r.tVariant().mSingle(new ModelMoose<>()).simpleScale(e -> 1.5F));
        RenderFactory.addRender(EntityPheasantEgg.class, RenderFactory.sprite());
        R.addRender(EntityTurkey.class, 0.5F, r -> r.tBabyVariant("turkey_baby").mSingle(new ModelTurkey<>()).ageScale(0.8F, 0.5F).handleRotation((e, p) -> {
            float f = e.oFlap + (e.wingRotation - e.oFlap) * p;
            float f1 = e.oFlapSpeed + (e.destPos - e.oFlapSpeed) * p;
            return (MathHelper.sin(f) + 1.0F) * f1;
        }));
        RenderFactory.addRender(EntityTurkeyEgg.class, RenderFactory.sprite());
        R.addRender(EntityZotzpyre.class, 0.4F, r -> r.tVariant().mSingle(new ModelZotzpyre<>()).layer(t -> new LayerEyes<>(t, ModResources.zotzpyre_eyes)));
        R.addRender(EntityBobbitWorm.class, 0.4F, r -> r.tVariant().mSingle(new ModelBobbitWorm<>()));
        R.addRender(EntityGoose.class, 0.5F, r -> r.tBabyVariant("goose_baby").mSingle(new ModelGoose<>()).ageScale(0.8F, 0.5F).layer(t -> new GooseItemLayerRenderer<EntityGoose>(t)));
        RenderFactory.addRender(EntityGooseEgg.class, RenderFactory.sprite());
        RenderFactory.addRender(EntityGoldenGooseEgg.class, RenderFactory.sprite());
        R.addRender(EntityFreshwaterEel.class, 0.4F, r -> r.tVariant().mSingle(new ModelFreshwaterEel<>()));
        R.addRender(EntitySaltwaterEel.class, 0.4F, r -> r.tVariant().mSingle(new ModelSaltwaterEel<>()));
        R.addRender(EntityWhale.class, 3F, r -> r.tVariant().mCondition(e -> !"cuviers".equals(e.getVariantNameOrEmpty()) && !"bottlenose".equals(e.getVariantNameOrEmpty()), new ModelSmallWhale<>(), new ModelBeakedWhale<>()).preRender((e, p) -> {
            switch(e.getVariantNameOrEmpty()) {
            case "cuviers":
                GlStateManager.scaled(1.7D, 1.7D, 1.7D);
                break;
            case "bottlenose":
                GlStateManager.scaled(2.5D, 2.5D, 2.5D);
                break;
            case "false_killer":
                GlStateManager.scaled(1.8D, 1.8D, 1.8D);
                break;
            case "beluga":
                GlStateManager.scaled(1.5D, 1.5D, 1.5D);
                break;
            case "pilot":
                GlStateManager.scaled(2.0D, 2.0D, 2.0D);
                break;
            case "narwhal":
                GlStateManager.scaled(1.6D, 1.6D, 1.6D);
                break;
            default:
                break;
            }
        }));
        R.addRender(EntityWalrus.class, 1.5F, r -> r.tSingle("walrus").mSingle(new ModelWalrus<EntityWalrus>()));
        R.addRender(EntityButterfly.class, 0.1F, r -> r.tVariant().mSingle(new ModelButterfly<>()).simpleScale(e -> e.getSize(Pose.STANDING).width));
        R.addRender(EntityDragonfly.class, 0.1F, r -> r.tVariant().mSingle(new ModelDragonfly<>()).simpleScale(e -> (e.getSize(Pose.STANDING).width / 2F)));
        RenderFactory.addRender(EntityBadgerDirt.class, RenderFactory.nothing());
        BetterAnimalsPlusMod.logger.info("Rendering squirrel physics...");
    }

}
