package its_meow.betteranimalsplus.client;


import dev.itsmeow.imdlib.client.IMDLibClient;
import dev.itsmeow.imdlib.client.render.RenderFactory;
import dev.itsmeow.imdlib.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.client.model.*;
import its_meow.betteranimalsplus.client.model.shark.*;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantulaHair;
import its_meow.betteranimalsplus.client.renderer.entity.layers.GooseItemLayerRenderer;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyes;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyesCondition;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockTrillium;
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.projectile.*;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModResources;
import its_meow.betteranimalsplus.init.ModTileEntities;
import net.minecraft.client.renderer.RenderState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.Pose;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

public class ClientLifecycleHandler {

    public static final RenderFactory R = IMDLibClient.getRenderRegistry(Ref.MOD_ID);

    public void clientSetup(final FMLClientSetupEvent event) {
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.TRILLIUM_TYPE.get(), RenderBlockTrillium::new);
        TileEntityHead.registerTypeRender();
        R.addRender(ModEntities.BROWN_BEAR.entityType, 1F, r -> r.tSingle("bear_brown").mSingle(new ModelBear<>()).ageScale(1.3F, 0.65F));
        R.addRender(ModEntities.BLACK_BEAR.entityType, 1F, r -> r.tVariant().mSingle(new ModelBear<>()).childScale(0.5F));
        R.addRender(ModEntities.DEER.entityType, 1F, r -> r.tBabyVariant("deer_baby").mSingle(new ModelDeer<>()).childScale(0.6F));
        R.addRender(ModEntities.LAMMERGEIER.entityType, 0.3F, r -> r.tVariant().mSingle(new ModelLammergeier<>()));
        R.addRender(ModEntities.FERAL_WOLF.entityType, 0.5F, r -> r.tVariant().mSingle(new ModelFeralWolf<>()).handleRotation((e, p) -> e.getTailRotation()).childScale(0.5F).layer(t -> new LayerEyesCondition<>(t, ModResources.wolf_eyes, e -> !e.isTamed())));
        R.addRender(ModEntities.COYOTE.entityType, 0.5F, r -> r.tMapped(e -> e.isTamed() || (e.isDaytime() && !EntityCoyote.HOSTILE_DAYTIME) ? "coyote_neutral" : "coyote_hostile").mSingle(new ModelCoyote<>()).handleRotation((e, p) -> e.getTailRotation()).childScale(0.5F).layer(t -> new LayerEyesCondition<>(t, ModResources.coyote_eyes, e -> !e.isTamed() && !(e.isDaytime() && !EntityCoyote.HOSTILE_DAYTIME))));
        RenderFactory.addRender(EntityTarantulaHair.HAIR_TYPE, RenderTarantulaHair::new);
        R.addRender(ModEntities.TARANTULA.entityType, 1F, r -> r.tSingle("tarantula").mSingle(new ModelTarantula<>()).preRender((e, s, p) -> {
            if(e.isBesideClimbableBlock()) {
                s.rotate(Vector3f.XP.rotationDegrees(-90F));
                s.translate(0.0F, 0.75F, -0.5F);
            }
        }).layer(t -> new LayerEyes<>(t, ModResources.tarantula_eyes)));
        R.addRender(ModEntities.GOAT.entityType, 0.5F, r -> r.tVariant().mSingle(new ModelGoat<>()).childScale(0.5F));
        R.addRender(ModEntities.JELLYFISH.entityType, 0.5F, r -> r.tVariant().mSingle(new ModelJellyfish<>()).preRender((e, s, p) -> {
            float a = e.getSize(Pose.STANDING).width;
            s.scale(a, a, a);
            s.translate(0F, 1F, 0F);
        }));
        R.addRender(ModEntities.PHEASANT.entityType, 0.5F, r -> r.tBabyVariant("pheasant_baby").mSingle(new ModelPheasant<>()).childScale(0.5F).handleRotation((e, p) -> {
            float f = e.oFlap + (e.wingRotation - e.oFlap) * p;
            float f1 = e.oFlapSpeed + (e.destPos - e.oFlapSpeed) * p;
            return (MathHelper.sin(f) + 1.0F) * f1;
        }));
        R.addRender(ModEntities.REINDEER.entityType, 1F, r -> r.tVariant().mSingle(new ModelReindeer<>()).ageScale(1.3F, 0.7F));
        R.addRender(ModEntities.BOAR.entityType, 0.6F, r -> r.tBabyVariant("boar_baby").mSingle(new ModelBoar<>()).childScale(0.6F));
        R.addRender(ModEntities.SQUIRREL.entityType, 0.3F, r -> r.tVariant().mSingle(new ModelSquirrel<>()).ageScale(0.5F, 0.35F));
        R.addRender(ModEntities.SONGBIRD.entityType, 0.3F, r -> r.tVariant().mCondition(e -> e.getVariantNameOrEmpty().isEmpty() || !e.getVariantNameOrEmpty().startsWith("small"), new ModelSongbird<>(), new ModelSongbirdSmall<>()).ageScale(0.5F, 0.3F));
        R.addRender(ModEntities.BADGER.entityType, 0.4F, r -> r.tVariant().mSingle(new ModelBadger<>()).ageScale(0.7F, 0.35F));
        R.addRender(ModEntities.LAMPREY.entityType, 0.4F, r -> r.tVariant().mSingle(new ModelLamprey<>()).preRender((e, s, p) -> {
            s.scale(0.5F, 0.5F, 0.5F);
            if(e.getRidingEntity() != null) {
                s.rotate(Vector3f.YP.rotationDegrees(180F));
                s.translate(0, 0, 0.5F);
            }
        }));
        R.addRender(ModEntities.NAUTILUS.entityType, 0.4F, r -> r.tSingle("nautilus").mSingle(new ModelNautilus<>()));
        R.addRender(ModEntities.CRAB.entityType, 0.4F, r -> r.tVariant().mSingle(new ModelCrab<>()).childScale(0.45F));
        R.addRender(ModEntities.HORSESHOE_CRAB.entityType, 0.4F, r -> r.tVariant().mSingle(new ModelHorseshoeCrab<>()).childScale(0.45F));
        R.addRender(ModEntities.SHARK.entityType, 2F, r -> r.tVariant().mMapped(e -> {
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
        R.addRender(ModEntities.MOOSE.entityType, 0.8F, r -> r.tVariant().mSingle(new ModelMoose<>()).simpleScale(e -> 1.5F));
        RenderFactory.addRender(EntityPheasantEgg.PHEASANT_EGG_TYPE, RenderFactory.sprite());
        R.addRender(ModEntities.TURKEY.entityType, 0.5F, r -> r.tBabyVariant("turkey_baby").mSingle(new ModelTurkey<>()).ageScale(0.8F, 0.5F).handleRotation((e, p) -> {
            float f = e.oFlap + (e.wingRotation - e.oFlap) * p;
            float f1 = e.oFlapSpeed + (e.destPos - e.oFlapSpeed) * p;
            return (MathHelper.sin(f) + 1.0F) * f1;
        }));
        RenderFactory.addRender(EntityTurkeyEgg.TURKEY_EGG_TYPE, RenderFactory.sprite());
        R.addRender(ModEntities.BOBBIT_WORM.entityType, 0.4F, r -> r.tVariant().mSingle(new ModelBobbitWorm<>()));
        R.addRender(ModEntities.GOOSE.entityType, 0.5F, r -> r.tBabyVariant("goose_baby").mSingle(new ModelGoose<>()).ageScale(0.8F, 0.5F).layer(GooseItemLayerRenderer::new));
        RenderFactory.addRender(EntityGooseEgg.GOOSE_EGG_TYPE, RenderFactory.sprite());
        RenderFactory.addRender(EntityGoldenGooseEgg.GOLDEN_GOOSE_EGG_TYPE, RenderFactory.sprite());
        R.addRender(ModEntities.EEL_FRESHWATER.entityType, 0.4F, r -> r.tVariant().mSingle(new ModelFreshwaterEel<>()));
        R.addRender(ModEntities.EEL_SALTWATER.entityType, 0.4F, r -> r.tVariant().mSingle(new ModelSaltwaterEel<>()));
        R.addRender(ModEntities.WHALE.entityType, 3F, r -> r.tVariant().mCondition(e -> !"cuviers".equals(e.getVariantNameOrEmpty()) && !"bottlenose".equals(e.getVariantNameOrEmpty()), new ModelSmallWhale<>(), new ModelBeakedWhale<>()).preRender((e, s, p) -> {
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
        R.addRender(ModEntities.WALRUS.entityType, 1.5F, r -> r.tSingle("walrus").mSingle(new ModelWalrus<>()));
        R.addRender(ModEntities.BUTTERFLY.entityType, 0.1F, r -> r.tVariant().mSingle(new ModelButterfly<>()).simpleScale(e -> e.getSize(Pose.STANDING).width));
        R.addRender(ModEntities.DRAGONFLY.entityType, 0.1F, r -> r.tVariant().mSingle(new ModelDragonfly<>()).simpleScale(e -> (e.getSize(Pose.STANDING).width / 2F)));
        R.addRender(ModEntities.BARRACUDA.entityType, 1F, r -> r.tSingle("barracuda").mSingle(new ModelBarracuda<>()).simpleScale(e -> 0.6F));
        R.addRender(ModEntities.FLYING_FISH.entityType, 1F, r -> r.tVariant().mSingle(new ModelFlyingFish<>()).simpleScale(e -> 0.4F));
        R.addRender(ModEntities.SQUID_COLOSSAL.entityType, 5F, r -> r.tSingle("squid_colossal").mSingle(new ModelColossalSquid<>()).simpleScale(e -> 1.9F).handleRotation((e, p) -> MathHelper.lerp(p, e.lastTentacleAngle, e.tentacleAngle)).applyRotations((e, s, a, y, p) -> {
            float f = MathHelper.lerp(p, e.prevSquidPitch, e.squidPitch);
            float f1 = MathHelper.lerp(p, e.prevSquidYaw, e.squidYaw);
            s.translate(0.0F, 0.5F, 0.0F);
            s.rotate(Vector3f.YP.rotationDegrees(180.0F - y));
            s.rotate(Vector3f.XP.rotationDegrees(f));
            s.rotate(Vector3f.YP.rotationDegrees(f1));
            s.translate(0.0F, -1.2F, 0.0F);
        }));
        R.addRender(ModEntities.SQUID_GIANT.entityType, 3F, r -> r.tSingle("squid_giant").mSingle(new ModelGiantSquid<>()).simpleScale(e -> 2.2F).handleRotation((e, p) -> MathHelper.lerp(p, e.lastTentacleAngle, e.tentacleAngle)).applyRotations((e, s, a, y, p) -> {
            float f = MathHelper.lerp(p, e.prevSquidPitch, e.squidPitch);
            float f1 = MathHelper.lerp(p, e.prevSquidYaw, e.squidYaw);
            s.translate(0.0F, 0.5F, 0.0F);
            s.rotate(Vector3f.YP.rotationDegrees(180.0F - y));
            s.rotate(Vector3f.XP.rotationDegrees(f));
            s.rotate(Vector3f.YP.rotationDegrees(f1));
            s.translate(0.0F, -1.2F, 0.0F);
        }));
        R.addRender(ModEntities.PIRANHA.entityType, 0.4F, r -> r.tSingle("piranha").mSingle(new ModelPiranha<>()).simpleScale(e -> 0.3F));
        R.addRender(ModEntities.OCTOPUS.entityType, 1F, r -> r.tVariant().mSingle(new ModelOctopus<>()).handleRotation((e, p) -> MathHelper.lerp(p, e.lastTentacleAngle, e.tentacleAngle)).applyRotations((e, s, a, y, p) -> {
            // s.translate(0.0F, 0.5F, 0.0F);
            s.rotate(Vector3f.YP.rotationDegrees(180.0F - y));
            if(e.isInWaterOrBubbleColumn() && (!e.isAboveBlock() || e.getMotion().length() > 0.01)) {
                float f = MathHelper.lerp(p, e.prevSquidPitch, e.squidPitch);
                float f1 = MathHelper.lerp(p, e.prevSquidYaw, e.squidYaw);
                s.rotate(Vector3f.XP.rotationDegrees(f));
                s.rotate(Vector3f.YP.rotationDegrees(f1));
            }
            // s.translate(0.0F, -1.2F, 0.0F);
        }));
        RenderFactory.addRender(EntityBadgerDirt.DIRT_TYPE, RenderFactory.nothing());
        BetterAnimalsPlusMod.logger.info("Rendering squirrel physics...");
    }

    public static class RenderTypes extends RenderType {

        public RenderTypes() {
            super(null, null, 0, 0, false, false, null, null);
        }

        public static RenderType getEyesEntityCutoutNoCullDepthMaskOff(ResourceLocation locationIn) {
            RenderState.TextureState renderstate$texturestate = new RenderState.TextureState(locationIn, false, false);
            return makeType("eyes_entity_cutout_no_cull_depth_mask_off", DefaultVertexFormats.ENTITY, 7, 256, false, true, RenderType.State.getBuilder().texture(renderstate$texturestate).cull(CULL_DISABLED).transparency(ADDITIVE_TRANSPARENCY).writeMask(COLOR_WRITE).fog(BLACK_FOG).diffuseLighting(DIFFUSE_LIGHTING_ENABLED).alpha(DEFAULT_ALPHA).lightmap(LIGHTMAP_DISABLED).overlay(OVERLAY_ENABLED).build(false));
        }

    }
}
