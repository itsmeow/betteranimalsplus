package its_meow.betteranimalsplus.client;

import java.util.function.Predicate;

import com.google.common.base.Predicates;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.client.model.ModelBadger;
import its_meow.betteranimalsplus.client.model.ModelBear;
import its_meow.betteranimalsplus.client.model.ModelBoar;
import its_meow.betteranimalsplus.client.model.ModelBobbitWorm;
import its_meow.betteranimalsplus.client.model.ModelCrab;
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
import its_meow.betteranimalsplus.client.model.ModelZotzpyre;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCoyote;
import its_meow.betteranimalsplus.client.renderer.entity.RenderCustomWolf;
import its_meow.betteranimalsplus.client.renderer.entity.RenderDeer;
import its_meow.betteranimalsplus.client.renderer.entity.RenderGoose;
import its_meow.betteranimalsplus.client.renderer.entity.RenderHirschgeist;
import its_meow.betteranimalsplus.client.renderer.entity.RenderJellyfish;
import its_meow.betteranimalsplus.client.renderer.entity.RenderLamprey;
import its_meow.betteranimalsplus.client.renderer.entity.RenderPheasant;
import its_meow.betteranimalsplus.client.renderer.entity.RenderShark;
import its_meow.betteranimalsplus.client.renderer.entity.RenderSongbird;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTarantulaHair;
import its_meow.betteranimalsplus.client.renderer.entity.RenderTurkey;
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
import its_meow.betteranimalsplus.common.entity.EntityCoyote;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.common.entity.EntityDeer;
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
import its_meow.betteranimalsplus.common.entity.EntityZotzpyre;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import its_meow.betteranimalsplus.common.entity.projectile.EntityGoldenGooseEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityGooseEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityPheasantEgg;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTarantulaHair;
import its_meow.betteranimalsplus.common.entity.projectile.EntityTurkeyEgg;
import its_meow.betteranimalsplus.common.entity.util.IVariantTypes;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.client.Minecraft;
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
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrillium.class, new RenderBlockTrillium());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHandOfFate.class, new RenderBlockHandOfFate());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHead.class, new RenderGenericHead());
        RenderingRegistry.registerEntityRenderingHandler(EntityBear.class, simpleScaledSingle(new ModelBear<EntityBear>(), 1F, ModTextures.bear_brown, 1.3D, 1.3D));
        RenderingRegistry.registerEntityRenderingHandler(EntityBearNeutral.class, simple(new ModelBear<EntityBearNeutral>(), 1F));
        RenderingRegistry.registerEntityRenderingHandler(EntityDeer.class, RenderDeer::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLammergeier.class, simple(new ModelLammergeier<EntityLammergeier>(), 0.3F));
        RenderingRegistry.registerEntityRenderingHandler(EntityFeralWolf.class, RenderCustomWolf::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityCoyote.class, RenderCoyote::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTarantulaHair.class, RenderTarantulaHair::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTarantula.class, simpleSingleEyes(new ModelTarantula<EntityTarantula>(), 1F, ModTextures.tarantula, ModTextures.tarantula_eyes, Predicates.alwaysTrue()));
        RenderingRegistry.registerEntityRenderingHandler(EntityHirschgeist.class, RenderHirschgeist::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGoat.class, simpleScaled(new ModelGoat<EntityGoat>(), 0.5F, 1D, 0.5D));
        RenderingRegistry.registerEntityRenderingHandler(EntityJellyfish.class, RenderJellyfish::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityPheasant.class, RenderPheasant::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityReindeer.class, simpleScaled(new ModelReindeer<EntityReindeer>(), 1F, 1.3D, 0.7D));
        RenderingRegistry.registerEntityRenderingHandler(EntityBoar.class, simpleScaled(new ModelBoar<EntityBoar>(), 0.6F, 1D, 0.6D));
        RenderingRegistry.registerEntityRenderingHandler(EntitySquirrel.class, simpleScaled(new ModelSquirrel<EntitySquirrel>(), 0.3F, 0.5D, 0.35D));
        RenderingRegistry.registerEntityRenderingHandler(EntitySongbird.class, RenderSongbird::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityBadger.class, simpleScaled(new ModelBadger<EntityBadger>(), 0.4F, 0.7D, 0.35D));
        RenderingRegistry.registerEntityRenderingHandler(EntityBadgerDirt.class, RenderNothing::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityLamprey.class, RenderLamprey::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityNautilus.class, simpleSingle(new ModelNautilus<EntityNautilus>(), 0.4F, ModTextures.nautilus));
        RenderingRegistry.registerEntityRenderingHandler(EntityCrab.class, simpleScaled(new ModelCrab<EntityCrab>(), 0.4F, 1D, 0.45D));
        RenderingRegistry.registerEntityRenderingHandler(EntityHorseshoeCrab.class, simpleScaled(new ModelHorseshoeCrab<EntityHorseshoeCrab>(), 0.4F, 1D, 0.45D));
        RenderingRegistry.registerEntityRenderingHandler(EntityShark.class, RenderShark::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMoose.class, simpleScaled(new ModelMoose<EntityMoose>(), 0.8F, 1.5D, 1.5D));
        RenderingRegistry.registerEntityRenderingHandler(EntityPheasantEgg.class, sprite());
        RenderingRegistry.registerEntityRenderingHandler(EntityTurkey.class, RenderTurkey::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityTurkeyEgg.class, sprite());
        RenderingRegistry.registerEntityRenderingHandler(EntityZotzpyre.class, simpleEyes(new ModelZotzpyre<EntityZotzpyre>(), 0.4F, ModTextures.zotzpyre_eyes, Predicates.alwaysTrue()));
        RenderingRegistry.registerEntityRenderingHandler(EntityBobbitWorm.class, simple(new ModelBobbitWorm<EntityBobbitWorm>(), 0.4F));
        RenderingRegistry.registerEntityRenderingHandler(EntityGoose.class, RenderGoose::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityGooseEgg.class, sprite());
        RenderingRegistry.registerEntityRenderingHandler(EntityGoldenGooseEgg.class, sprite());
        RenderingRegistry.registerEntityRenderingHandler(EntityFreshwaterEel.class, simple(new ModelFreshwaterEel<EntityFreshwaterEel>(), 0.4F));
        RenderingRegistry.registerEntityRenderingHandler(EntitySaltwaterEel.class, simple(new ModelSaltwaterEel<EntitySaltwaterEel>(), 0.4F));
        BetterAnimalsPlusMod.logger.info("Rendering squirrel physics...");
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
