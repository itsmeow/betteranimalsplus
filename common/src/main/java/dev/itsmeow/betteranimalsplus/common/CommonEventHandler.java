package dev.itsmeow.betteranimalsplus.common;

import com.google.common.collect.Multimap;
import com.google.common.collect.MultimapBuilder;
import dev.architectury.event.CompoundEventResult;
import dev.architectury.event.EventResult;
import dev.architectury.event.events.common.EntityEvent;
import dev.architectury.event.events.common.InteractionEvent;
import dev.architectury.injectables.annotations.ExpectPlatform;
import dev.architectury.registry.registries.Registries;
import dev.architectury.utils.PlatformExpectedError;
import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.entity.*;
import dev.itsmeow.betteranimalsplus.common.entity.util.IHaveHunger;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntitySharkBase;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import dev.itsmeow.betteranimalsplus.init.ModTriggers;
import dev.itsmeow.betteranimalsplus.mixin.MobAccessor;
import dev.itsmeow.imdlib.entity.interfaces.IBucketable;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Registry;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.IronGolem;
import net.minecraft.world.entity.animal.PolarBear;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.RecordItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.JukeboxBlockEntity;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Predicate;

public class CommonEventHandler {

    public static final Set<Predicate<Entity>> NO_ATTACKED_DROPS = new HashSet<>();
    static {
        NO_ATTACKED_DROPS.add(e -> e instanceof EntityLamprey);
        NO_ATTACKED_DROPS.add(e -> e instanceof EntitySharkBase);
        NO_ATTACKED_DROPS.add(e -> e instanceof EntityBarracuda);
        NO_ATTACKED_DROPS.add(e -> e instanceof EntityPiranha);
        NO_ATTACKED_DROPS.add(e -> e instanceof EntityOctopus && ((EntityOctopus) e).friend == null);
    }
    public static final Multimap<ResourceLocation, ResourceLocation> LOOT_TABLE_INJECTIONS = MultimapBuilder.hashKeys().hashSetValues().build();
    static {
        IVariant v = ModEntities.FERAL_WOLF.getVariantForName("snowy");
        if (v instanceof EntityFeralWolf.WolfVariant) {
            EntityFeralWolf.WolfVariant variant = (EntityFeralWolf.WolfVariant) v;
            LOOT_TABLE_INJECTIONS.put(EntityType.WOLF.getDefaultLootTable(), variant.getLootTable());
        }
        LOOT_TABLE_INJECTIONS.put(EntityType.SQUID.getDefaultLootTable(), ModLootTables.SQUID);
    }

    public static void init() {
        EntityEvent.LIVING_DEATH.register(CommonEventHandler::entityDeath);
        EntityEvent.LIVING_HURT.register(CommonEventHandler::entityAttack);
        EntityEvent.ADD.register(CommonEventHandler::entityAdd);
        InteractionEvent.RIGHT_CLICK_BLOCK.register(CommonEventHandler::rightClickBlock);
        InteractionEvent.RIGHT_CLICK_ITEM.register(CommonEventHandler::rightClickItem);
        CommonEventHandler.registerPlatformEvents();
    }

    public static EventResult entityDeath(LivingEntity entity, DamageSource source) {
        if(source.getDirectEntity() instanceof EntityBoar && ModEntities.BOAR.getCustomConfiguration().getBoolean("nerf_options/breed_from_kill")) {
            EntityBoar boar = (EntityBoar) source.getDirectEntity();
            boar.setInLove(null);
            BlockPos p = boar.blockPosition();
            boar.level.addParticle(ParticleTypes.HEART, p.getX(), p.getY(), p.getZ(), 0.0F, 0.05F, 0.0F);
        } else if(source.getDirectEntity() instanceof ServerPlayer) {
            ServerPlayer player = (ServerPlayer) source.getDirectEntity();
            if(entity instanceof EntityBear || entity instanceof PolarBear) {
                if(player.getMainHandItem().isEmpty()) {
                    ModTriggers.PUNCH_BEAR_DEATH.trigger(player);
                }
            } else if(entity instanceof EntitySquirrel && !player.getAdvancements().getOrStartProgress(player.server.getAdvancements().getAdvancement(new ResourceLocation("betteranimalsplus:squirrel_kill_100"))).isDone()) {
                CommonEventHandler.setSquirrelKills(player, oldValue -> {
                    int newValue = oldValue + 1;
                    if(newValue > 100) {
                        newValue = 1;
                    }
                    if(ModTriggers.SQUIRREL_KILL_TRIGGERS.containsKey(newValue)) {
                        ModTriggers.SQUIRREL_KILL_TRIGGERS.get(newValue).trigger(player);
                    }
                    return newValue;
                });
            }
        } else if(source.getEntity() instanceof EntityOctopus) {
            EntityOctopus octo = (EntityOctopus) source.getEntity();
            if(octo.friend != null) {
                Player p = octo.level.getPlayerByUUID(octo.friend);
                if(p instanceof ServerPlayer && p.getKillCredit() == entity) {
                    ModTriggers.OCTOPUS_SAVE_PLAYER.trigger((ServerPlayer) octo.level.getPlayerByUUID(octo.friend));
                }
            }
        }
        if(source.getDirectEntity() instanceof IHaveHunger) {
            ((IHaveHunger<?>) source.getDirectEntity()).resetHunger();
        }
        return EventResult.pass();
    }

    public static EventResult rightClickBlock(Player player, InteractionHand hand, BlockPos pos, Direction direction) {
        if(player.level.getBlockState(pos).getBlock() == Blocks.JUKEBOX && player instanceof ServerPlayer) {
            BlockEntity te = player.level.getBlockEntity(pos);
            if(te instanceof JukeboxBlockEntity) {
                JukeboxBlockEntity box = (JukeboxBlockEntity) te;
                Item held = player.getItemInHand(hand).getItem();
                Item boxItem = box.getRecord().getItem();
                boolean added = box.getRecord().isEmpty();
                onDiskUse(added, (ServerPlayer) player, added ? held : boxItem);
            }
        }
        return EventResult.pass();
    }

    public static CompoundEventResult<ItemStack> rightClickItem(Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        ResourceLocation reg = Registries.get(Ref.MOD_ID).get(Registry.ITEM_REGISTRY).getId(stack.getItem());
        if(reg != null && reg.getPath().equals("portable_jukebox") && player instanceof ServerPlayer) {
            if(stack.getTagElement("Disc") != null) {
                Item item = ItemStack.of(stack.getTagElement("Disc")).getItem();
                onDiskUse(player.isCrouching(), (ServerPlayer) player, item);
            }
        }
        return CompoundEventResult.pass();
    }

    private static void onDiskUse(boolean added, ServerPlayer player, Item item) {
        if(item instanceof RecordItem) {
            if(added) {
                List<EntityCrab> crabs = player.getCommandSenderWorld().getEntitiesOfClass(EntityCrab.class, player.getBoundingBox().inflate(50));
                if(crabs.size() > 0) {
                    ModTriggers.CRAB_DANCE.trigger(player);
                }
                for(EntityCrab crab : crabs) {
                    crab.crabRave();
                }

            } else {
                List<EntityCrab> crabs = player.getCommandSenderWorld().getEntitiesOfClass(EntityCrab.class, player.getBoundingBox().inflate(100));
                for(EntityCrab crab : crabs) {
                    crab.unCrabRave();
                }
            }
        }
    }

    public static EventResult entityAttack(LivingEntity entity, DamageSource source, float damage) {
        if (source.getEntity() instanceof ServerPlayer && (entity instanceof EntityBear || entity instanceof PolarBear)) {
            if (((ServerPlayer) source.getEntity()).getMainHandItem().isEmpty()) {
                ModTriggers.PUNCH_BEAR.trigger((ServerPlayer) source.getEntity());
            }
        }
        return EventResult.pass();
    }

    public static void modifyDropsList(Collection<ItemEntity> drops, DamageSource source, LivingEntity entity) {
        if(source.getEntity() != null && !(entity instanceof Player) && NO_ATTACKED_DROPS.stream().anyMatch(predicate -> predicate.test(source.getEntity())) && (!(source.getEntity() instanceof IBucketable) || !((IBucketable) source.getEntity()).isFromContainer())) {
            drops.clear();
        }
    }

    public static EventResult entityAdd(Entity entity, Level level) {
        if(entity instanceof IronGolem) {
            ((MobAccessor) entity).getTargetSelector().addGoal(3, new NearestAttackableTargetGoal<>((IronGolem) entity, EntityFeralWolf.class, 5, false, false, e -> !((EntityFeralWolf) e).isTame() && (e instanceof EntityCoyote ? !((EntityCoyote) e).isDaytime() : true)));
        }
        return EventResult.pass();
    }

    @ExpectPlatform
    public static void registerPlatformEvents() {
        throw new PlatformExpectedError();
    }

    @ExpectPlatform
    public static void setSquirrelKills(Player player, int kills) {
        throw new PlatformExpectedError();
    }

    @ExpectPlatform
    public static void setSquirrelKills(Player player, Function<Integer, Integer> mutator) {
        throw new PlatformExpectedError();
    }

    @ExpectPlatform
    public static int getSquirrelKills(Player player) {
        throw new PlatformExpectedError();
    }
}