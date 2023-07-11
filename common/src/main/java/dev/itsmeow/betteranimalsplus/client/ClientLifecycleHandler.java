package dev.itsmeow.betteranimalsplus.client;

import com.google.common.collect.ImmutableMap;
import com.mojang.math.Axis;
import dev.architectury.platform.Platform;
import dev.architectury.registry.client.rendering.BlockEntityRendererRegistry;
import dev.itsmeow.betteranimalsplus.BetterAnimalsPlusMod;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.client.dumb.DeveloperRenderThing;
import dev.itsmeow.betteranimalsplus.client.model.armor.ModelBearCape;
import dev.itsmeow.betteranimalsplus.client.model.armor.ModelWolfCape;
import dev.itsmeow.betteranimalsplus.client.model.block.ModelTrillium;
import dev.itsmeow.betteranimalsplus.client.model.block.ModelTrilliumMulti;
import dev.itsmeow.betteranimalsplus.client.model.block.ModelTrilliumMulti2;
import dev.itsmeow.betteranimalsplus.client.model.block.head.*;
import dev.itsmeow.betteranimalsplus.client.model.entity.*;
import dev.itsmeow.betteranimalsplus.client.model.entity.shark.*;
import dev.itsmeow.betteranimalsplus.client.model.entity.whale.*;
import dev.itsmeow.betteranimalsplus.client.renderer.blockentity.RenderBlockTrillium;
import dev.itsmeow.betteranimalsplus.client.renderer.entity.RenderTarantulaHair;
import dev.itsmeow.betteranimalsplus.client.renderer.entity.layers.GooseItemLayerRenderer;
import dev.itsmeow.betteranimalsplus.client.renderer.entity.layers.LayerEyes;
import dev.itsmeow.betteranimalsplus.client.renderer.entity.layers.LayerEyesCondition;
import dev.itsmeow.betteranimalsplus.common.entity.EntityDeer;
import dev.itsmeow.betteranimalsplus.init.ModBlockEntities;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModResources;
import dev.itsmeow.imdlib.blockentity.HeadBlockEntity;
import dev.itsmeow.imdlib.client.IMDLibClient;
import dev.itsmeow.imdlib.client.render.RenderFactory;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.Pose;

import java.util.function.BiConsumer;

public class ClientLifecycleHandler {

    public static final RenderFactory R = IMDLibClient.getRenderRegistry(Ref.MOD_ID);

    public static void clientInit() {
        DeveloperRenderThing.init();
        BlockEntityRendererRegistry.register(ModBlockEntities.TRILLIUM_TYPE.get(), RenderBlockTrillium::new);
        HeadBlockEntity.registerTypeRender();
        if(Platform.isFabric()) {
            ClientLifecycleHandler.registerEntityRenders();
        }
        BetterAnimalsPlusMod.LOGGER.info("Rendering squirrel physics...");
    }

    public static void registerEntityRenders() {
        R.addRender(ModEntities.BROWN_BEAR::getEntityType, 1F, r -> r.tCondition(AgeableMob::isBaby, "brownbear_baby", "brownbear").mSingle(ModelBrownBear::new, "brown_bear").childScale(0.5F));
        R.addRender(ModEntities.BLACK_BEAR::getEntityType, 1F, r -> r.tVariant().mSingle(ModelBlackBear::new, "black_bear").childScale(0.5F));
        R.addRender(ModEntities.DEER::getEntityType, 1F, r -> r.tBabyVariant("deer_baby").mSingle(ModelDeer::new, "deer").childScale(0.6F).layer(t -> new LayerEyesCondition<>(t, ModResources.deer_christmas_glow, e -> EntityDeer.EntityDeerVariant.isChristmas)));
        R.addRender(ModEntities.LAMMERGEIER::getEntityType, 0.3F, r -> r.tVariant().mSingle(ModelLammergeier::new, "lammergeier"));
        R.addRender(ModEntities.FERAL_WOLF::getEntityType, 0.5F, r -> r.tVariant().mSingle(ModelFeralWolf::new, "feral_wolf").handleRotation((e, p) -> e.getTailRotation()).childScale(0.5F).layer(t -> new LayerEyesCondition<>(t, ModResources.wolf_eyes, e -> !e.isTame())));
        R.addRender(ModEntities.COYOTE::getEntityType, 0.5F, r -> r.tMapped(e -> e.isTame() || (e.isDaytime() && !e.isHostileDaytime()) ? "coyote" : "coyote_hostile").mSingle(ModelCoyote::new, "coyote").handleRotation((e, p) -> e.getTailRotation()).childScale(0.5F).layer(t -> new LayerEyesCondition<>(t, ModResources.coyote_eyes, e -> !e.isTame() && !(e.isDaytime() && !e.isHostileDaytime()))));
        RenderFactory.addRender(ModEntities.PROJECTILE_TARANTULA_HAIR::get, RenderTarantulaHair::new);
        R.addRender(ModEntities.TARANTULA::getEntityType, 1F, r -> r.tVariant().mSingle(ModelTarantula::new, "tarantula").preRender((e, s, p) -> {
            if(e.isClimbing()) {
                s.mulPose(Axis.XP.rotationDegrees(-90F));
                s.translate(0.0F, 0.75F, -0.5F);
            }
        }).layer(t -> new LayerEyes<>(t, ModResources.tarantula_eyes)));
        R.addRender(ModEntities.JELLYFISH::getEntityType, 0.5F, r -> r.tVariant().mSingle(ModelJellyfish::new, "jellyfish").preRender((e, s, p) -> {
            float a = e.getDimensions(Pose.STANDING).width;
            s.scale(a, a, a);
            s.translate(0F, 1F, 0F);
        }));
        R.addRender(ModEntities.PHEASANT::getEntityType, 0.5F, r -> r.tBabyVariant("pheasant_baby").mSingle(ModelPheasant::new, "pheasant").childScale(0.5F).handleRotation((e, p) -> {
            float f = e.oFlap + (e.wingRotation - e.oFlap) * p;
            float f1 = e.oFlapSpeed + (e.destPos - e.oFlapSpeed) * p;
            return (Mth.sin(f) + 1.0F) * f1;
        }));
        R.addRender(ModEntities.REINDEER::getEntityType, 1F, r -> r.tVariant().mSingle(ModelReindeer::new, "reindeer").ageScale(1.3F, 0.7F).layer(t -> new LayerEyesCondition<>(t, ModResources.reindeer_christmas_glow, e -> e.getVariantNameOrEmpty().endsWith("_christmas"))));
        R.addRender(ModEntities.BOAR::getEntityType, 0.6F, r -> r.tBabyVariant("boar_baby").mSingle(ModelBoar::new, "boar").childScale(0.6F));
        R.addRender(ModEntities.SQUIRREL::getEntityType, 0.3F, r -> r.tVariant().mSingle(ModelSquirrel::new, "squirrel").ageScale(0.5F, 0.35F));
        R.addRender(ModEntities.SONGBIRD::getEntityType, 0.3F, r -> r.tVariant().mCondition(e -> e.getVariantNameOrEmpty().isEmpty() || !e.getVariantNameOrEmpty().startsWith("small"), ModelSongbird::new, "songbird", ModelSongbirdSmall::new, "songbird_small").ageScale(0.5F, 0.3F));
        R.addRender(ModEntities.BADGER::getEntityType, 0.4F, r -> r.tVariant().mSingle(ModelBadger::new, "badger").ageScale(0.7F, 0.35F));
        R.addRender(ModEntities.LAMPREY::getEntityType, 0.4F, r -> r.tVariant().mSingle(ModelLamprey::new, "lamprey").preRender((e, s, p) -> {
            s.scale(0.5F, 0.5F, 0.5F);
            if(e.getVehicle() != null) {
                s.mulPose(Axis.YP.rotationDegrees(180F));
                s.translate(0, 0, 0.5F);
            }
        }));
        R.addRender(ModEntities.NAUTILUS::getEntityType, 0.4F, r -> r.tSingle("nautilus").mSingle(ModelNautilus::new, "nautilus"));
        R.addRender(ModEntities.CRAB::getEntityType, 0.4F, r -> r.tVariant().mSingle(ModelCrab::new, "crab").childScale(0.45F));
        R.addRender(ModEntities.HORSESHOE_CRAB::getEntityType, 0.4F, r -> r.tVariant().mSingle(ModelHorseshoeCrab::new, "horseshoe_crab").childScale(0.45F));
        R.addRender(ModEntities.SHARK::getEntityType, 2F, r -> r.tVariant().mMapped(e -> {
                    String v = e.getVariantNameOrEmpty();
                    if(v.equals("whitetip")) {
                        return "white_tip_shark";
                    }
                    return v.isEmpty() ? "bull_shark" : v + "_shark";
                }, ModelBullShark::new, "bull_shark")
                .mEntry(ModelBlueShark::new, "blue_shark")
                .mEntry(ModelTigerShark::new, "tiger_shark")
                .mEntry(ModelWhiteTipShark::new, "white_tip_shark")
                .mEntry(ModelGreenlandShark::new, "greenland_shark")
                .mEntry(ModelHammerheadShark::new, "hammerhead_shark")
                .mEntry(ModelGoblinShark::new, "goblin_shark")
                .mEntry(ModelMakoShark::new, "mako_shark")
                .mEntry(ModelGreatWhiteShark::new, "great_white_shark")
                .mEntry(ModelBaskingShark::new, "basking_shark")
                .mEntry(ModelWhaleShark::new, "whale_shark")
                .preRender((e, s, p) -> {
                    switch(e.getVariantNameOrEmpty()) {
                        case "blue":
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
                        case "great_white":
                            s.scale(1.2F, 1.2F, 1.2F);
                            break;
                        case "basking":
                        case "mako":
                        case "whale":
                        default:
                    }
                }));
        R.addRender(ModEntities.MOOSE::getEntityType, 0.8F, r -> r.tVariant().mSingle(ModelMoose::new, "moose").simpleScale(e -> 1.5F));
        RenderFactory.addRender(ModEntities.PROJECTILE_PHEASANT_EGG::get, RenderFactory.sprite());
        R.addRender(ModEntities.TURKEY::getEntityType, 0.5F, r -> r.tBabyVariant("turkey_baby").mSingle(ModelTurkey::new, "turkey").ageScale(0.8F, 0.5F).handleRotation((e, p) -> {
            float f = e.oFlap + (e.wingRotation - e.oFlap) * p;
            float f1 = e.oFlapSpeed + (e.destPos - e.oFlapSpeed) * p;
            return (Mth.sin(f) + 1.0F) * f1;
        }));
        RenderFactory.addRender(ModEntities.PROJECTILE_TURKEY_EGG::get, RenderFactory.sprite());
        R.addRender(ModEntities.BOBBIT_WORM::getEntityType, 0.4F, r -> r.tVariant().mSingle(ModelBobbitWorm::new, "bobbit_worm"));
        R.addRender(ModEntities.GOOSE::getEntityType, 0.5F, r -> r.tBabyVariant("goose_baby").mSingle(ModelGoose::new, "goose").ageScale(0.8F, 0.5F).layer(GooseItemLayerRenderer::new));
        RenderFactory.addRender(ModEntities.PROJECTILE_GOOSE_EGG::get, RenderFactory.sprite());
        RenderFactory.addRender(ModEntities.PROJECTILE_GOLDEN_GOOSE_EGG::get, RenderFactory.sprite());
        R.addRender(ModEntities.EEL_FRESHWATER::getEntityType, 0.4F, r -> r.tVariant().mSingle(ModelFreshwaterEel::new, "freshwater_eel"));
        R.addRender(ModEntities.EEL_SALTWATER::getEntityType, 0.4F, r -> r.tVariant().mSingle(ModelSaltwaterEel::new, "saltwater_eel"));
        R.addRender(ModEntities.WHALE::getEntityType, 3F, r -> r.tVariant()
                .mMapped(e -> {
                    String v = e.getVariantNameOrEmpty();
                    if(v.equals("sperm_albino")) {
                        return "sperm_whale";
                    }
                    return v.isEmpty() ? "beluga_whale" : v + "_whale";
                }, ModelWhaleBeluga::new, "beluga_whale")
                .mEntry(ModelWhaleCuviers::new, "cuviers_whale")
                .mEntry(ModelWhaleFalseKiller::new, "false_killer_whale")
                .mEntry(ModelWhaleNarwhal::new, "narwhal_whale")
                .mEntry(ModelWhaleNorthernBottlenose::new, "bottlenose_whale")
                .mEntry(ModelWhalePilot::new, "pilot_whale")
                .mEntry(ModelWhaleSperm::new, "sperm_whale")
                .mEntry(ModelWhaleBlue::new, "blue_whale")
                .mEntry(ModelWhaleRight::new, "right_whale")
                );
        R.addRender(ModEntities.WALRUS::getEntityType, 1.5F, r -> r.tSingle("walrus").mSingle(ModelWalrus::new, "walrus"));
        R.addRender(ModEntities.BUTTERFLY::getEntityType, 0.1F, r -> r.tVariant().mSingle(ModelButterfly::new, "butterfly").simpleScale(e -> e.getDimensions(Pose.STANDING).width));
        R.addRender(ModEntities.DRAGONFLY::getEntityType, 0.1F, r -> r.tVariant().mSingle(ModelDragonfly::new, "dragonfly").simpleScale(e -> (e.getDimensions(Pose.STANDING).width / 2F)));
        R.addRender(ModEntities.BARRACUDA::getEntityType, 1F, r -> r.tSingle("barracuda").mSingle(ModelBarracuda::new, "barracuda").simpleScale(e -> 0.6F));
        R.addRender(ModEntities.FLYING_FISH::getEntityType, 1F, r -> r.tVariant().mSingle(ModelFlyingFish::new, "flying_fish").simpleScale(e -> 0.4F));
        R.addRender(ModEntities.SQUID_COLOSSAL::getEntityType, 5F, r -> r.tSingle("squid_colossal").mSingle(ModelColossalSquid::new, "colossal_squid").simpleScale(e -> 1.9F).handleRotation((e, p) -> Mth.lerp(p, e.lastTentacleAngle, e.tentacleAngle)).applyRotations((e, s, a, y, p) -> {
            float f = Mth.lerp(p, e.prevSquidPitch, e.squidPitch);
            float f1 = Mth.lerp(p, e.prevSquidYaw, e.squidYaw);
            s.translate(0.0F, 0.5F, 0.0F);
            s.mulPose(Axis.YP.rotationDegrees(180.0F - y));
            s.mulPose(Axis.XP.rotationDegrees(f));
            s.mulPose(Axis.YP.rotationDegrees(f1));
            s.translate(0.0F, -1.2F, 0.0F);
        }));
        R.addRender(ModEntities.SQUID_GIANT::getEntityType, 3F, r -> r.tSingle("squid_giant").mSingle(ModelGiantSquid::new, "giant_squid").simpleScale(e -> 2.2F).handleRotation((e, p) -> Mth.lerp(p, e.lastTentacleAngle, e.tentacleAngle)).applyRotations((e, s, a, y, p) -> {
            float f = Mth.lerp(p, e.prevSquidPitch, e.squidPitch);
            float f1 = Mth.lerp(p, e.prevSquidYaw, e.squidYaw);
            s.translate(0.0F, 0.5F, 0.0F);
            s.mulPose(Axis.YP.rotationDegrees(180.0F - y));
            s.mulPose(Axis.XP.rotationDegrees(f));
            s.mulPose(Axis.YP.rotationDegrees(f1));
            s.translate(0.0F, -1.2F, 0.0F);
        }));
        R.addRender(ModEntities.PIRANHA::getEntityType, 0.4F, r -> r.tSingle("piranha").mSingle(ModelPiranha::new, "piranha").simpleScale(e -> 0.3F));
        R.addRender(ModEntities.OCTOPUS::getEntityType, 1F, r -> r.tVariant().mSingle(ModelOctopus::new, "octopus").handleRotation((e, p) -> Mth.lerp(p, e.lastTentacleAngle, e.tentacleAngle)).applyRotations((e, s, a, y, p) -> {
            // s.translate(0.0F, 0.5F, 0.0F);
            s.mulPose(Axis.YP.rotationDegrees(180.0F - y));
            if(e.isInWaterOrBubble() && (!e.isAboveBlock() || e.getDeltaMovement().length() > 0.01)) {
                float f = Mth.lerp(p, e.prevSquidPitch, e.squidPitch);
                float f1 = Mth.lerp(p, e.prevSquidYaw, e.squidYaw);
                s.mulPose(Axis.XP.rotationDegrees(f));
                s.mulPose(Axis.YP.rotationDegrees(f1));
            }
            // s.translate(0.0F, -1.2F, 0.0F);
        }));
        R.addRender(ModEntities.GAZELLE::getEntityType, 0.8F, r -> r.tVariant().childScale(0.6F).mMapped(e -> {
                    String v = e.getVariantNameOrEmpty();
                    if(v.equals("blackbuck_light") || v.equals("blackbuck_dark")) {
                        return "blackbuck_gazelle";
                    }
                    return v.isEmpty() ? "blackbuck_gazelle" : v + "_gazelle";
                }, ModelGazelle::new, "blackbuck_gazelle")
                .mEntry(ModelGazelle::new, "chinkara_gazelle")
                .mEntry(ModelGazelle::new, "erlanger_gazelle")
                .mEntry(ModelGazelle::new, "springbok_gazelle"));
        R.addRender(ModEntities.CROCODILE::getEntityType, 0.8F, r -> r.tVariant().mSingle(ModelCrocodile::new, "crocodile").childScale(0.6F));
        R.addRender(ModEntities.ALLIGATOR::getEntityType, 0.8F, r -> r.tVariant().mSingle(ModelAlligator::new, "alligator").childScale(0.6F));
        RenderFactory.addRender(ModEntities.PROJECTILE_BADGER_DIRT::get, RenderFactory.nothing());

        R.addRender(ModEntities.QUETZAL::getEntityType, 0.4F, r -> r.tSingle("quetzal").mSingle(ModelQuetzal::new, "quetzal"));

        R.addRender(ModEntities.HOATZIN::getEntityType, 0.4F, r -> r.tSingle("hoatzin").mSingle(ModelHoatzin::new, "hoatzin"));

        R.addRender(ModEntities.CRAYFISH::getEntityType, 0.4F, r -> r.tSingle("crayfish").mSingle(ModelCrayfish::new, "crayfish"));
    }

    public static void layerDefinitions(ImmutableMap.Builder<ModelLayerLocation, LayerDefinition> b) {
        BiConsumer<String, LayerDefinition> r = (k, l) -> b.put(new ModelLayerLocation(new ResourceLocation(Ref.MOD_ID, k), "main"), l);
        r.accept("badger", ModelBadger.createBodyLayer());
        r.accept("barracuda", ModelBarracuda.createBodyLayer());
        r.accept("black_bear", ModelBlackBear.createBodyLayer());
        r.accept("boar", ModelBoar.createBodyLayer());
        r.accept("bobbit_worm", ModelBobbitWorm.createBodyLayer());
        r.accept("brown_bear", ModelBrownBear.createBodyLayer());
        r.accept("butterfly", ModelButterfly.createBodyLayer());
        r.accept("colossal_squid", ModelColossalSquid.createBodyLayer());
        r.accept("coyote", ModelCoyote.createBodyLayer());
        r.accept("crab", ModelCrab.createBodyLayer());
        r.accept("deer", ModelDeer.createBodyLayer());
        r.accept("dragonfly", ModelDragonfly.createBodyLayer());
        r.accept("feral_wolf", ModelFeralWolf.createBodyLayer());
        r.accept("flying_fish", ModelFlyingFish.createBodyLayer());
        r.accept("freshwater_eel", ModelFreshwaterEel.createBodyLayer());
        r.accept("giant_squid", ModelGiantSquid.createBodyLayer());
        r.accept("goose", ModelGoose.createBodyLayer());
        r.accept("horseshoe_crab", ModelHorseshoeCrab.createBodyLayer());
        r.accept("jellyfish", ModelJellyfish.createBodyLayer());
        r.accept("lammergeier", ModelLammergeier.createBodyLayer());
        r.accept("lamprey", ModelLamprey.createBodyLayer());
        r.accept("moose", ModelMoose.createBodyLayer());
        r.accept("nautilus", ModelNautilus.createBodyLayer());
        r.accept("octopus", ModelOctopus.createBodyLayer());
        r.accept("pheasant", ModelPheasant.createBodyLayer());
        r.accept("piranha", ModelPiranha.createBodyLayer());
        r.accept("reindeer", ModelReindeer.createBodyLayer());
        r.accept("saltwater_eel", ModelSaltwaterEel.createBodyLayer());
        r.accept("songbird", ModelSongbird.createBodyLayer());
        r.accept("songbird_small", ModelSongbirdSmall.createBodyLayer());
        r.accept("squirrel", ModelSquirrel.createBodyLayer());
        r.accept("tarantula", ModelTarantula.createBodyLayer());
        r.accept("turkey", ModelTurkey.createBodyLayer());
        r.accept("walrus", ModelWalrus.createBodyLayer());
        r.accept("crocodile", ModelCrocodile.createBodyLayer());
        r.accept("alligator", ModelAlligator.createBodyLayer());
        r.accept("quetzal", ModelQuetzal.createBodyLayer());
        r.accept("hoatzin", ModelHoatzin.createBodyLayer());
        r.accept("crayfish", ModelCrayfish.createBodyLayer());

        r.accept("basking_shark", ModelBaskingShark.createBodyLayer());
        r.accept("blue_shark", ModelBlueShark.createBodyLayer());
        r.accept("bull_shark", ModelBullShark.createBodyLayer());
        r.accept("goblin_shark", ModelGoblinShark.createBodyLayer());
        r.accept("great_white_shark", ModelGreatWhiteShark.createBodyLayer());
        r.accept("greenland_shark", ModelGreenlandShark.createBodyLayer());
        r.accept("hammerhead_shark", ModelHammerheadShark.createBodyLayer());
        r.accept("mako_shark", ModelMakoShark.createBodyLayer());
        r.accept("tiger_shark", ModelTigerShark.createBodyLayer());
        r.accept("whale_shark", ModelWhaleShark.createBodyLayer());
        r.accept("white_tip_shark", ModelWhiteTipShark.createBodyLayer());

        r.accept("beluga_whale", ModelWhaleBeluga.createBodyLayer());
        r.accept("cuviers_whale", ModelWhaleCuviers.createBodyLayer());
        r.accept("false_killer_whale", ModelWhaleFalseKiller.createBodyLayer());
        r.accept("narwhal_whale", ModelWhaleNarwhal.createBodyLayer());
        r.accept("bottlenose_whale", ModelWhaleNorthernBottlenose.createBodyLayer());
        r.accept("pilot_whale", ModelWhalePilot.createBodyLayer());
        r.accept("sperm_whale", ModelWhaleSperm.createBodyLayer());
        r.accept("blue_whale", ModelWhaleBlue.createBodyLayer());
        r.accept("right_whale", ModelWhaleRight.createBodyLayer());

        r.accept("blackbuck_gazelle", ModelGazelle.createBlackbuck());
        r.accept("chinkara_gazelle", ModelGazelle.createChinkara());
        r.accept("erlanger_gazelle", ModelGazelle.createErlanger());
        r.accept("springbok_gazelle", ModelGazelle.createSpringbok());

        r.accept("bear_cape", ModelBearCape.createBodyLayer());
        r.accept("wolf_cape", ModelWolfCape.createBodyLayer());

        r.accept("black_bear_head", ModelBlackBearHead.createBodyLayer());
        r.accept("boar_head", ModelBoarHead.createBodyLayer());
        r.accept("brown_bear_head", ModelBrownBearHead.createBodyLayer());
        r.accept("coyote_head", ModelCoyoteHead.createBodyLayer());
        r.accept("deer_head", ModelDeerHead.createBodyLayer());
        r.accept("feral_wolf_head", ModelFeralWolfHead.createBodyLayer());
        r.accept("moose_head", ModelMooseHead.createBodyLayer());
        r.accept("reindeer_head", ModelReindeerHead.createBodyLayer());
        r.accept("blackbuck_gazelle_head", ModelGazelleHead.createBlackbuckLayer());
        r.accept("chinkara_gazelle_head", ModelGazelleHead.createChinkaraLayer());
        r.accept("erlanger_gazelle_head", ModelGazelleHead.createErlangerLayer());
        r.accept("springbok_gazelle_head", ModelGazelleHead.createSpringbokLayer());

        r.accept("trillium_single", ModelTrillium.createBodyLayer());
        r.accept("trillium_double", ModelTrilliumMulti.createBodyLayer());
        r.accept("trillium_triple", ModelTrilliumMulti2.createBodyLayer());
    }
}
