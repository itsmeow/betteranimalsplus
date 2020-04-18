package its_meow.betteranimalsplus.client;

import java.util.function.Predicate;

import com.google.common.base.Predicates;
import com.mojang.blaze3d.matrix.MatrixStack;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.model.ModelBadger;
import its_meow.betteranimalsplus.client.model.ModelBear;
import its_meow.betteranimalsplus.client.model.ModelBoar;
import its_meow.betteranimalsplus.client.model.ModelBobbitWorm;
import its_meow.betteranimalsplus.client.model.ModelCrab;
import its_meow.betteranimalsplus.client.model.ModelDeer;
import its_meow.betteranimalsplus.client.model.ModelFreshwaterEel;
import its_meow.betteranimalsplus.client.model.ModelGoat;
import its_meow.betteranimalsplus.client.model.ModelHorseshoeCrab;
import its_meow.betteranimalsplus.client.model.ModelLammergeier;
import its_meow.betteranimalsplus.client.model.ModelMoose;
import its_meow.betteranimalsplus.client.model.ModelNautilus;
import its_meow.betteranimalsplus.client.model.ModelReindeer;
import its_meow.betteranimalsplus.client.model.ModelSaltwaterEel;
import its_meow.betteranimalsplus.client.model.ModelSquirrel;
import its_meow.betteranimalsplus.client.model.ModelTarantula;
import its_meow.betteranimalsplus.client.model.ModelWalrus;
import its_meow.betteranimalsplus.client.model.ModelZotzpyre;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCoyote;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCustomWolf;
import its_meow.betteranimalsplus.client.renderer.entity.RenderGoose;
import its_meow.betteranimalsplus.client.renderer.entity.RenderHirschgeist;
import its_meow.betteranimalsplus.client.renderer.entity.RenderJellyfish;
import its_meow.betteranimalsplus.client.renderer.entity.RenderLamprey;
import its_meow.betteranimalsplus.client.renderer.entity.RenderPheasant;
import its_meow.betteranimalsplus.client.renderer.entity.RenderShark;
import its_meow.betteranimalsplus.client.renderer.entity.RenderSongbird;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantulaHair;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTurkey;
import its_meow.betteranimalsplus.client.renderer.entity.RenderWhale;
import its_meow.betteranimalsplus.client.renderer.entity.generic.RenderNothing;
import its_meow.betteranimalsplus.client.renderer.entity.generic.SimpleRenderer;
import its_meow.betteranimalsplus.client.renderer.entity.generic.SimpleScaledRenderer;
import its_meow.betteranimalsplus.client.renderer.entity.generic.SimpleScaledSingleRenderer;
import its_meow.betteranimalsplus.client.renderer.entity.generic.SimpleSingleRenderer;
import its_meow.betteranimalsplus.client.renderer.entity.layers.LayerEyesCondition;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockHandOfFate;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockTrillium;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderGenericHead;
import its_meow.betteranimalsplus.common.entity.EntityBadger;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBearNeutral;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityBobbitWorm;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
import its_meow.betteranimalsplus.common.entity.EntityFreshwaterEel;
import its_meow.betteranimalsplus.common.entity.EntityGoat;
import its_meow.betteranimalsplus.common.entity.EntityHorseshoeCrab;
import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import its_meow.betteranimalsplus.common.entity.EntityMoose;
import its_meow.betteranimalsplus.common.entity.EntityNautilus;
import its_meow.betteranimalsplus.common.entity.EntityReindeer;
import its_meow.betteranimalsplus.common.entity.EntitySaltwaterEel;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.common.entity.EntityTarantula;
import its_meow.betteranimalsplus.common.entity.EntityWalrus;
import its_meow.betteranimalsplus.common.entity.EntityZotzpyre;
import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import its_meow.betteranimalsplus.common.entity.projectile.EntityGoldenGooseEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityGooseEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityPheasantEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTurkeyEgg;
import its_meow.betteranimalsplus.common.entity.util.IVariantTypes;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModTextures;
import its_meow.betteranimalsplus.init.ModTileEntities;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.Vector3f;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.MobEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@SuppressWarnings("unused")
public class ClientLifecycleHandler {

    public void clientSetup(final FMLClientSetupEvent event) {
        RenderTypeLookup.setRenderLayer(ModEntities.HIRSCHGEIST.getHeadType().getBlock(), RenderType.translucent());
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.TRILLIUM_TYPE, RenderBlockTrillium::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.HAND_OF_FATE_TYPE, RenderBlockHandOfFate::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.HEAD_TYPE, RenderGenericHead::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BROWN_BEAR.entityType, simpleScaledSingle(new ModelBear<EntityBear>(), 1F, ModTextures.bear_brown, 1.3D, 1.3D));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BLACK_BEAR.entityType, simple(new ModelBear<EntityBearNeutral>(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.DEER.entityType, simpleScaled(new ModelDeer<EntityDeer>(), 1F, 1.0D, 0.6D));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.LAMMERGEIER.entityType, simple(new ModelLammergeier<EntityLammergeier>(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.FERAL_WOLF.entityType, RenderCustomWolf::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.COYOTE.entityType, RenderCoyote::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaHair.HAIR_TYPE, RenderTarantulaHair::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TARANTULA.entityType, mgr -> (new SimpleSingleRenderer<EntityTarantula, ModelTarantula<EntityTarantula>>(mgr, new ModelTarantula<EntityTarantula>(), 1F, ModTextures.tarantula) {
            @Override
            protected void preRenderCallback(EntityTarantula entity, MatrixStack stack, float partialTickTime) {
                if(entity.isBesideClimbableBlock()) {
                    stack.rotate(Vector3f.XP.rotationDegrees(-90F));
                    stack.translate(0.0F, 0.75F, -0.5F);
                }
            }
        }.layer(base -> new LayerEyesCondition<>(base, ModTextures.tarantula_eyes, Predicates.alwaysTrue()))));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HIRSCHGEIST.entityType, RenderHirschgeist::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.GOAT.entityType, simpleScaled(new ModelGoat<EntityGoat>(), 0.5F, 1D, 0.5D));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.JELLYFISH.entityType, RenderJellyfish::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.PHEASANT.entityType, RenderPheasant::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.REINDEER.entityType, simpleScaled(new ModelReindeer<EntityReindeer>(), 1F, 1.3D, 0.7D));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BOAR.entityType, simpleScaled(new ModelBoar<EntityBoar>(), 0.6F, 1D, 0.6D));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SQUIRREL.entityType, simpleScaled(new ModelSquirrel<EntitySquirrel>(), 0.3F, 0.5D, 0.35D));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SONGBIRD.entityType, RenderSongbird::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BADGER.entityType, simpleScaled(new ModelBadger<EntityBadger>(), 0.4F, 0.7D, 0.35D));
        RenderingRegistry.registerEntityRenderingHandler(EntityBadgerDirt.DIRT_TYPE, nothing());
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.LAMPREY.entityType, RenderLamprey::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.NAUTILUS.entityType, simpleSingle(new ModelNautilus<EntityNautilus>(), 0.4F, ModTextures.nautilus));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.CRAB.entityType, simpleScaled(new ModelCrab<EntityCrab>(), 0.4F, 1D, 0.45D));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.HORSESHOE_CRAB.entityType, simpleScaled(new ModelHorseshoeCrab<EntityHorseshoeCrab>(), 0.4F, 1D, 0.45D));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.SHARK.entityType, RenderShark::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.MOOSE.entityType, simpleScaled(new ModelMoose<EntityMoose>(), 0.8F, 1.5D, 1.5D));
        RenderingRegistry.registerEntityRenderingHandler(EntityPheasantEgg.PHEASANT_EGG_TYPE, sprite());
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.TURKEY.entityType, RenderTurkey::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTurkeyEgg.TURKEY_EGG_TYPE, sprite());
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.ZOTZPYRE.entityType, simpleEyes(new ModelZotzpyre<EntityZotzpyre>(), 0.4F, ModTextures.zotzpyre_eyes, Predicates.alwaysTrue()));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.BOBBIT_WORM.entityType, simple(new ModelBobbitWorm<EntityBobbitWorm>(), 0.4F));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.GOOSE.entityType, RenderGoose::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGooseEgg.GOOSE_EGG_TYPE, sprite());
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldenGooseEgg.GOLDEN_GOOSE_EGG_TYPE, sprite());
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.EEL_FRESHWATER.entityType, simple(new ModelFreshwaterEel<EntityFreshwaterEel>(), 0.4F));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.EEL_SALTWATER.entityType, simple(new ModelSaltwaterEel<EntitySaltwaterEel>(), 0.4F));
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WHALE.entityType, RenderWhale::new);
        RenderingRegistry.registerEntityRenderingHandler(ModEntities.WALRUS.entityType, simpleSingle(new ModelWalrus<EntityWalrus>(), 1.5F, ModTextures.walrus));
        BetterAnimalsPlusMod.logger.info("Rendering squirrel physics...");
    }

    private static <T extends Entity> IRenderFactory<T> nothing() {
        return RenderNothing::new;
    }

    private static <T extends Entity & IRendersAsItem> IRenderFactory<T> sprite() {
        return mgr -> new SpriteRenderer<T>(mgr, Minecraft.getInstance().getItemRenderer());
    }

    private static <T extends MobEntity & IVariantTypes<?>, A extends EntityModel<T>> IRenderFactory<T> simple(A model, float shadowSize) {
        return mgr -> new SimpleRenderer<T, A>(mgr, model, shadowSize);
    }

    private static <T extends MobEntity & IVariantTypes<?>, A extends EntityModel<T>> IRenderFactory<T> simpleScaled(A model, float shadowSize, double adultScale, double childScale) {
        return mgr -> new SimpleScaledRenderer<T, A>(mgr, model, shadowSize, adultScale, childScale);
    }

    private static <T extends MobEntity, A extends EntityModel<T>> IRenderFactory<T> simpleSingle(A model, float shadowSize, ResourceLocation texture) {
        return mgr -> new SimpleSingleRenderer<T, A>(mgr, model, shadowSize, texture);
    }

    private static <T extends MobEntity, A extends EntityModel<T>> IRenderFactory<T> simpleScaledSingle(A model, float shadowSize, ResourceLocation texture, double adultScale, double childScale) {
        return mgr -> new SimpleScaledSingleRenderer<T, A>(mgr, model, shadowSize, texture, adultScale, childScale);
    }

    private static <T extends MobEntity & IVariantTypes<?>, A extends EntityModel<T>> IRenderFactory<T> simpleEyes(A model, float shadowSize, ResourceLocation eyes, Predicate<T> showEyes) {
        return mgr -> (new SimpleRenderer<T, A>(mgr, model, shadowSize).layer(base -> new LayerEyesCondition<T, A>(base, eyes, showEyes)));
    }

    private static <T extends MobEntity & IVariantTypes<?>, A extends EntityModel<T>> IRenderFactory<T> simpleScaledEyes(A model, float shadowSize, double adultScale, double childScale, ResourceLocation eyes, Predicate<T> showEyes) {
        return mgr -> (new SimpleScaledRenderer<T, A>(mgr, model, shadowSize, adultScale, childScale).layer(base -> new LayerEyesCondition<T, A>(base, eyes, showEyes)));
    }

    private static <T extends MobEntity, A extends EntityModel<T>> IRenderFactory<T> simpleSingleEyes(A model, float shadowSize, ResourceLocation texture, ResourceLocation eyes, Predicate<T> showEyes) {
        return mgr -> (new SimpleSingleRenderer<T, A>(mgr, model, shadowSize, texture).layer(base -> new LayerEyesCondition<T, A>(base, eyes, showEyes)));
    }

    private static <T extends MobEntity, A extends EntityModel<T>> IRenderFactory<T> simpleScaledSingleEyes(A model, float shadowSize, ResourceLocation texture, double adultScale, double childScale, ResourceLocation eyes, Predicate<T> showEyes) {
        return mgr -> (new SimpleScaledSingleRenderer<T, A>(mgr, model, shadowSize, texture, adultScale, childScale).layer(base -> new LayerEyesCondition<T, A>(base, eyes, showEyes)));
    }

}
