package dev.itsmeow.betteranimalsplus.client;

import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.math.Vector3f;
import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.client.dumb.DeveloperRenderThing;
import dev.itsmeow.betteranimalsplus.client.model.entity.*;
import dev.itsmeow.betteranimalsplus.client.model.entity.shark.*;
import dev.itsmeow.betteranimalsplus.client.renderer.blockentity.RenderBlockTrillium;
import dev.itsmeow.betteranimalsplus.client.renderer.entity.RenderTarantulaHair;
import dev.itsmeow.betteranimalsplus.client.renderer.entity.layers.GooseItemLayerRenderer;
import dev.itsmeow.betteranimalsplus.client.renderer.entity.layers.LayerEyes;
import dev.itsmeow.betteranimalsplus.client.renderer.entity.layers.LayerEyesCondition;
import dev.itsmeow.betteranimalsplus.init.ModBlockEntities;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModResources;
import dev.itsmeow.imdlib.blockentity.HeadBlockEntity;
import dev.itsmeow.imdlib.client.IMDLibClient;
import dev.itsmeow.imdlib.client.render.RenderFactory;
import me.shedaniel.architectury.registry.BlockEntityRenderers;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AgableMob;
import net.minecraft.world.entity.Pose;

public class ClientLifecycleHandler {

    public static final RenderFactory R = IMDLibClient.getRenderRegistry(Ref.MOD_ID);

    public static void clientInit() {
        DeveloperRenderThing.init();
        BlockEntityRenderers.registerRenderer(ModBlockEntities.TRILLIUM_TYPE.get(), RenderBlockTrillium::new);
        HeadBlockEntity.registerTypeRender();
        R.addRender(ModEntities.BROWN_BEAR.getEntityType(), 1F, r -> r.tCondition(AgableMob::isBaby, "brownbear_baby", "brownbear").mSingle(new ModelBrownBear<>()).childScale(0.5F));
        R.addRender(ModEntities.BLACK_BEAR.getEntityType(), 1F, r -> r.tVariant().mSingle(new ModelBlackBear<>()).childScale(0.5F));
        R.addRender(ModEntities.DEER.getEntityType(), 1F, r -> r.tBabyVariant("deer_baby").mSingle(new ModelDeer<>()).childScale(0.6F));
        R.addRender(ModEntities.LAMMERGEIER.getEntityType(), 0.3F, r -> r.tVariant().mSingle(new ModelLammergeier<>()));
        R.addRender(ModEntities.FERAL_WOLF.getEntityType(), 0.5F, r -> r.tVariant().mSingle(new ModelFeralWolf<>()).handleRotation((e, p) -> e.getTailRotation()).childScale(0.5F).layer(t -> new LayerEyesCondition<>(t, ModResources.wolf_eyes, e -> !e.isTame())));
        R.addRender(ModEntities.COYOTE.getEntityType(), 0.5F, r -> r.tMapped(e -> e.isTame() || (e.isDaytime() && !e.isHostileDaytime()) ? "coyote" : "coyote_hostile").mSingle(new ModelCoyote<>()).handleRotation((e, p) -> e.getTailRotation()).childScale(0.5F).layer(t -> new LayerEyesCondition<>(t, ModResources.coyote_eyes, e -> !e.isTame() && !(e.isDaytime() && !e.isHostileDaytime()))));
        RenderFactory.addRender(ModEntities.PROJECTILE_TARANTULA_HAIR.get(), RenderTarantulaHair::new);
        R.addRender(ModEntities.TARANTULA.getEntityType(), 1F, r -> r.tVariant().mSingle(new ModelTarantula<>()).preRender((e, s, p) -> {
            if(e.isClimbing()) {
                s.mulPose(Vector3f.XP.rotationDegrees(-90F));
                s.translate(0.0F, 0.75F, -0.5F);
            }
        }).layer(t -> new LayerEyes<>(t, ModResources.tarantula_eyes)));
        R.addRender(ModEntities.GOAT.getEntityType(), 0.5F, r -> r.tVariant().mSingle(new ModelGoat<>()).childScale(0.5F));
        R.addRender(ModEntities.JELLYFISH.getEntityType(), 0.5F, r -> r.tVariant().mSingle(new ModelJellyfish<>()).preRender((e, s, p) -> {
            float a = e.getDimensions(Pose.STANDING).width;
            s.scale(a, a, a);
            s.translate(0F, 1F, 0F);
        }));
        R.addRender(ModEntities.PHEASANT.getEntityType(), 0.5F, r -> r.tBabyVariant("pheasant_baby").mSingle(new ModelPheasant<>()).childScale(0.5F).handleRotation((e, p) -> {
            float f = e.oFlap + (e.wingRotation - e.oFlap) * p;
            float f1 = e.oFlapSpeed + (e.destPos - e.oFlapSpeed) * p;
            return (Mth.sin(f) + 1.0F) * f1;
        }));
        R.addRender(ModEntities.REINDEER.getEntityType(), 1F, r -> r.tVariant().mSingle(new ModelReindeer<>()).ageScale(1.3F, 0.7F));
        R.addRender(ModEntities.BOAR.getEntityType(), 0.6F, r -> r.tBabyVariant("boar_baby").mSingle(new ModelBoar<>()).childScale(0.6F));
        R.addRender(ModEntities.SQUIRREL.getEntityType(), 0.3F, r -> r.tVariant().mSingle(new ModelSquirrel<>()).ageScale(0.5F, 0.35F));
        R.addRender(ModEntities.SONGBIRD.getEntityType(), 0.3F, r -> r.tVariant().mCondition(e -> e.getVariantNameOrEmpty().isEmpty() || !e.getVariantNameOrEmpty().startsWith("small"), new ModelSongbird<>(), new ModelSongbirdSmall<>()).ageScale(0.5F, 0.3F));
        R.addRender(ModEntities.BADGER.getEntityType(), 0.4F, r -> r.tVariant().mSingle(new ModelBadger<>()).renderLayer((e, a, b, c, t) -> RenderType.entityTranslucent(t)).ageScale(0.7F, 0.35F));
        R.addRender(ModEntities.LAMPREY.getEntityType(), 0.4F, r -> r.tVariant().mSingle(new ModelLamprey<>()).preRender((e, s, p) -> {
            s.scale(0.5F, 0.5F, 0.5F);
            if(e.getVehicle() != null) {
                s.mulPose(Vector3f.YP.rotationDegrees(180F));
                s.translate(0, 0, 0.5F);
            }
        }));
        R.addRender(ModEntities.NAUTILUS.getEntityType(), 0.4F, r -> r.tSingle("nautilus").mSingle(new ModelNautilus<>()));
        R.addRender(ModEntities.CRAB.getEntityType(), 0.4F, r -> r.tVariant().mSingle(new ModelCrab<>()).childScale(0.45F));
        R.addRender(ModEntities.HORSESHOE_CRAB.getEntityType(), 0.4F, r -> r.tVariant().mSingle(new ModelHorseshoeCrab<>()).childScale(0.45F));
        R.addRender(ModEntities.SHARK.getEntityType(), 2F, r -> r.tVariant().mMapped(e -> {
            switch(e.getVariantNameOrEmpty()) {
            case "blue":
                return ModelBlueShark.class;
            case "bull":
                return ModelBullShark.class;
            case "tiger":
                return ModelTigerShark.class;
            case "whitetip":
                return ModelWhiteTipShark.class;
            case "greenland":
                return ModelGreenlandShark.class;
            case "hammerhead":
                return ModelHammerheadShark.class;
            case "goblin":
                return ModelGoblinShark.class;
            case "mako":
                return ModelMakoShark.class;
            case "great_white":
                return ModelGreatWhiteShark.class;
            default:
                return ModelBullShark.class;
            }
        }, new ModelBullShark()).preRender((e, s, p) -> {
            switch(e.getVariantNameOrEmpty()) {
            case "blue":
                s.scale(0.8F, 0.8F, 0.8F);
                break;
            case "bull":
                s.scale(0.8F, 0.8F, 0.8F);
                break;
            case "tiger":
                s.scale(1.1F, 1.1F, 1.1F);
                break;
            case "whitetip":
                s.scale(0.9F, 0.9F, 0.9F);
                break;
            case "greenland":
                s.scale(1.7F, 1.7F, 1.7F);
                s.translate(0F, 0.3F, 0F);
                break;
            case "hammerhead":
                s.scale(1.3F, 1.3F, 1.3F);
                break;
            case "goblin":
                s.scale(0.7F, 0.7F, 0.7F);
                break;
            case "mako":
                break;
            case "great_white":
                s.scale(1.2F, 1.2F, 1.2F);
                break;
            default:
                break;
            }
        }));
        R.addRender(ModEntities.MOOSE.getEntityType(), 0.8F, r -> r.tVariant().mSingle(new ModelMoose<>()).simpleScale(e -> 1.5F));
        RenderFactory.addRender(ModEntities.PROJECTILE_PHEASANT_EGG.get(), RenderFactory.sprite());
        R.addRender(ModEntities.TURKEY.getEntityType(), 0.5F, r -> r.tBabyVariant("turkey_baby").mSingle(new ModelTurkey<>()).ageScale(0.8F, 0.5F).handleRotation((e, p) -> {
            float f = e.oFlap + (e.wingRotation - e.oFlap) * p;
            float f1 = e.oFlapSpeed + (e.destPos - e.oFlapSpeed) * p;
            return (Mth.sin(f) + 1.0F) * f1;
        }));
        RenderFactory.addRender(ModEntities.PROJECTILE_TURKEY_EGG.get(), RenderFactory.sprite());
        R.addRender(ModEntities.BOBBIT_WORM.getEntityType(), 0.4F, r -> r.tVariant().mSingle(new ModelBobbitWorm<>()));
        R.addRender(ModEntities.GOOSE.getEntityType(), 0.5F, r -> r.tBabyVariant("goose_baby").mSingle(new ModelGoose<>()).ageScale(0.8F, 0.5F).layer(GooseItemLayerRenderer::new));
        RenderFactory.addRender(ModEntities.PROJECTILE_GOOSE_EGG.get(), RenderFactory.sprite());
        RenderFactory.addRender(ModEntities.PROJECTILE_GOLDEN_GOOSE_EGG.get(), RenderFactory.sprite());
        R.addRender(ModEntities.EEL_FRESHWATER.getEntityType(), 0.4F, r -> r.tVariant().mSingle(new ModelFreshwaterEel<>()));
        R.addRender(ModEntities.EEL_SALTWATER.getEntityType(), 0.4F, r -> r.tVariant().mSingle(new ModelSaltwaterEel<>()));
        R.addRender(ModEntities.WHALE.getEntityType(), 3F, r -> r.tVariant().mCondition(e -> !"cuviers".equals(e.getVariantNameOrEmpty()) && !"bottlenose".equals(e.getVariantNameOrEmpty()), new ModelSmallWhale<>(), new ModelBeakedWhale<>()).preRender((e, s, p) -> {
            switch(e.getVariantNameOrEmpty()) {
            case "cuviers":
                s.scale(1.7F, 1.7F, 1.7F);
                break;
            case "bottlenose":
                s.scale(2.5F, 2.5F, 2.5F);
                break;
            case "false_killer":
                s.scale(1.8F, 1.8F, 1.8F);
                break;
            case "beluga":
                s.scale(1.5F, 1.5F, 1.5F);
                break;
            case "pilot":
                s.scale(2.0F, 2.0F, 2.0F);
                break;
            case "narwhal":
                s.scale(1.6F, 1.6F, 1.6F);
                break;
            default:
                break;
            }
        }));
        R.addRender(ModEntities.WALRUS.getEntityType(), 1.5F, r -> r.tSingle("walrus").mSingle(new ModelWalrus<>()));
        R.addRender(ModEntities.BUTTERFLY.getEntityType(), 0.1F, r -> r.tVariant().mSingle(new ModelButterfly<>()).simpleScale(e -> e.getDimensions(Pose.STANDING).width));
        R.addRender(ModEntities.DRAGONFLY.getEntityType(), 0.1F, r -> r.tVariant().mSingle(new ModelDragonfly<>()).simpleScale(e -> (e.getDimensions(Pose.STANDING).width / 2F)));
        R.addRender(ModEntities.BARRACUDA.getEntityType(), 1F, r -> r.tSingle("barracuda").mSingle(new ModelBarracuda<>()).simpleScale(e -> 0.6F));
        R.addRender(ModEntities.FLYING_FISH.getEntityType(), 1F, r -> r.tVariant().mSingle(new ModelFlyingFish<>()).simpleScale(e -> 0.4F));
        R.addRender(ModEntities.SQUID_COLOSSAL.getEntityType(), 5F, r -> r.tSingle("squid_colossal").mSingle(new ModelColossalSquid<>()).simpleScale(e -> 1.9F).handleRotation((e, p) -> Mth.lerp(p, e.lastTentacleAngle, e.tentacleAngle)).applyRotations((e, s, a, y, p) -> {
            float f = Mth.lerp(p, e.prevSquidPitch, e.squidPitch);
            float f1 = Mth.lerp(p, e.prevSquidYaw, e.squidYaw);
            s.translate(0.0F, 0.5F, 0.0F);
            s.mulPose(Vector3f.YP.rotationDegrees(180.0F - y));
            s.mulPose(Vector3f.XP.rotationDegrees(f));
            s.mulPose(Vector3f.YP.rotationDegrees(f1));
            s.translate(0.0F, -1.2F, 0.0F);
        }));
        R.addRender(ModEntities.SQUID_GIANT.getEntityType(), 3F, r -> r.tSingle("squid_giant").mSingle(new ModelGiantSquid<>()).simpleScale(e -> 2.2F).handleRotation((e, p) -> Mth.lerp(p, e.lastTentacleAngle, e.tentacleAngle)).applyRotations((e, s, a, y, p) -> {
            float f = Mth.lerp(p, e.prevSquidPitch, e.squidPitch);
            float f1 = Mth.lerp(p, e.prevSquidYaw, e.squidYaw);
            s.translate(0.0F, 0.5F, 0.0F);
            s.mulPose(Vector3f.YP.rotationDegrees(180.0F - y));
            s.mulPose(Vector3f.XP.rotationDegrees(f));
            s.mulPose(Vector3f.YP.rotationDegrees(f1));
            s.translate(0.0F, -1.2F, 0.0F);
        }));
        R.addRender(ModEntities.PIRANHA.getEntityType(), 0.4F, r -> r.tSingle("piranha").mSingle(new ModelPiranha<>()).simpleScale(e -> 0.3F));
        R.addRender(ModEntities.OCTOPUS.getEntityType(), 1F, r -> r.tVariant().mSingle(new ModelOctopus<>()).handleRotation((e, p) -> Mth.lerp(p, e.lastTentacleAngle, e.tentacleAngle)).applyRotations((e, s, a, y, p) -> {
            // s.translate(0.0F, 0.5F, 0.0F);
            s.mulPose(Vector3f.YP.rotationDegrees(180.0F - y));
            if(e.isInWaterOrBubble() && (!e.isAboveBlock() || e.getDeltaMovement().length() > 0.01)) {
                float f = Mth.lerp(p, e.prevSquidPitch, e.squidPitch);
                float f1 = Mth.lerp(p, e.prevSquidYaw, e.squidYaw);
                s.mulPose(Vector3f.XP.rotationDegrees(f));
                s.mulPose(Vector3f.YP.rotationDegrees(f1));
            }
            // s.translate(0.0F, -1.2F, 0.0F);
        }));
        RenderFactory.addRender(ModEntities.PROJECTILE_BADGER_DIRT.get(), RenderFactory.nothing());
        BetterAnimalsPlusMod.LOGGER.info("Rendering squirrel physics...");
    }

    public static class RenderTypes extends RenderType {

        public RenderTypes() {
            super(null, null, 0, 0, false, false, null, null);
        }

        public static RenderType getEyesEntityCutoutNoCullDepthMaskOff(ResourceLocation locationIn) {
            RenderStateShard.TextureStateShard renderstate$texturestate = new RenderStateShard.TextureStateShard(locationIn, false, false);
            return create("eyes_entity_cutout_no_cull_depth_mask_off", DefaultVertexFormat.NEW_ENTITY, 7, 256, false, true, RenderType.CompositeState.builder().setTextureState(renderstate$texturestate).setCullState(NO_CULL).setTransparencyState(ADDITIVE_TRANSPARENCY).setWriteMaskState(COLOR_WRITE).setFogState(BLACK_FOG).setDiffuseLightingState(DIFFUSE_LIGHTING).setAlphaState(DEFAULT_ALPHA).setLightmapState(NO_LIGHTMAP).setOverlayState(OVERLAY).createCompositeState(false));
        }

    }
}
