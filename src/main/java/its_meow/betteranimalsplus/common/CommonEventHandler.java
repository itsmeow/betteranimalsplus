package its_meow.betteranimalsplus.common;

import dev.itsmeow.imdlib.entity.util.IBucketable;
import dev.itsmeow.imdlib.entity.util.IVariant;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.*;
import its_meow.betteranimalsplus.common.entity.EntityFeralWolf.WolfVariant;
import its_meow.betteranimalsplus.common.entity.util.IHaveHunger;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntitySharkBase;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.init.ModTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.IRandomRange;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.JukeboxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.function.Predicate;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class CommonEventHandler {

    public static final Set<Predicate<Entity>> NO_ATTACKED_DROPS = new HashSet<>();
    static {
        NO_ATTACKED_DROPS.add(e -> e instanceof EntityLamprey);
        NO_ATTACKED_DROPS.add(e -> e instanceof EntitySharkBase);
        NO_ATTACKED_DROPS.add(e -> e instanceof EntityBarracuda);
        NO_ATTACKED_DROPS.add(e -> e instanceof EntityPiranha);
        NO_ATTACKED_DROPS.add(e -> e instanceof EntityOctopus && ((EntityOctopus) e).friend == null);
    }

    @SubscribeEvent
    public static void onDeathOfEntity(LivingDeathEvent e) {
        if(e.getSource().getImmediateSource() instanceof EntityBoar) {
            EntityBoar boar = (EntityBoar) e.getSource().getImmediateSource();
            boar.setInLove(null);
            BlockPos p = boar.getPosition();
            boar.world.addParticle(ParticleTypes.HEART, p.getX(), p.getY(), p.getZ(), 0.0F, 0.05F, 0.0F);
        } else if(e.getSource().getImmediateSource() instanceof ServerPlayerEntity) {
            ServerPlayerEntity player = (ServerPlayerEntity) e.getSource().getImmediateSource();
            if(e.getEntity() instanceof EntityBear || e.getEntity() instanceof PolarBearEntity) {
                if(player.getHeldItemMainhand().isEmpty()) {
                    ModTriggers.PUNCH_BEAR_DEATH.trigger(player);
                }
            } else if(e.getEntity() instanceof EntitySquirrel && !player.getAdvancements().getProgress(player.server.getAdvancementManager().getAdvancement(new ResourceLocation("betteranimalsplus:squirrel_kill_100"))).isDone()) {
                CompoundNBT pTag = player.getPersistentData();
                if(!pTag.contains("betteranimalsplus", Constants.NBT.TAG_COMPOUND)) {
                    pTag.put("betteranimalsplus", new CompoundNBT());
                }
                CompoundNBT bTag = pTag.getCompound("betteranimalsplus");
                if(bTag.contains("squirrel_kills", Constants.NBT.TAG_INT)) {
                    int newVal = bTag.getInt("squirrel_kills") + 1;
                    bTag.putInt("squirrel_kills", newVal);
                    if(ModTriggers.SQUIRREL_KILL_TRIGGERS.containsKey(newVal)) {
                        ModTriggers.SQUIRREL_KILL_TRIGGERS.get(newVal).trigger(player);
                    }
                    if(newVal >= 100) {
                        bTag.remove("squirrel_kills");
                    }
                } else {
                    bTag.putInt("squirrel_kills", 1);
                    if(ModTriggers.SQUIRREL_KILL_TRIGGERS.containsKey(1)) {
                        ModTriggers.SQUIRREL_KILL_TRIGGERS.get(1).trigger(player);
                    }
                }
            }
        } else if(e.getSource().getTrueSource() instanceof EntityOctopus) {
            EntityOctopus octo = (EntityOctopus) e.getSource().getTrueSource();
            if(octo.friend != null) {
                PlayerEntity p = octo.world.getPlayerByUuid(octo.friend);
                if(p instanceof ServerPlayerEntity && p.getAttackingEntity() == e.getEntityLiving()) {
                    ModTriggers.OCTOPUS_SAVE_PLAYER.trigger((ServerPlayerEntity) octo.world.getPlayerByUuid(octo.friend));
                }
            }
        }
        if(e.getSource().getImmediateSource() instanceof IHaveHunger) {
            ((IHaveHunger<?>) e.getSource().getImmediateSource()).resetHunger();
        }
    }
    
    @SubscribeEvent
    public static void onBlockActivate(PlayerInteractEvent.RightClickBlock event) {
        if(event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.JUKEBOX && event.getPlayer() instanceof ServerPlayerEntity) {
            TileEntity te = event.getWorld().getTileEntity(event.getPos());
            if(te instanceof JukeboxTileEntity) {
                JukeboxTileEntity box = (JukeboxTileEntity) te;
                Item held = event.getPlayer().getHeldItem(event.getHand()).getItem();
                Item boxItem = box.getRecord().getItem();
                boolean added = box.getRecord().isEmpty();
                onDiskUse(added, (ServerPlayerEntity) event.getPlayer(), added ? held : boxItem);
            }
        }
    }

    @SubscribeEvent
    public static void onItemUsed(PlayerInteractEvent.RightClickItem event) {
        ResourceLocation reg = event.getItemStack().getItem().getRegistryName();
        if(reg != null && reg.getPath().equals("portable_jukebox") && event.getPlayer() instanceof ServerPlayerEntity) {
            if(event.getItemStack().getChildTag("Disc") != null) {
                Item item = ItemStack.read(event.getItemStack().getChildTag("Disc")).getItem();
                onDiskUse(event.getPlayer().isCrouching(), (ServerPlayerEntity) event.getPlayer(), item);
            }
        }
    }

    private static void onDiskUse(boolean added, ServerPlayerEntity player, Item item) {
        if(item == ModItems.RECORD_CRAB_RAVE.get()) {
            if(added) {
                List<EntityCrab> crabs = player.getEntityWorld().getEntitiesWithinAABB(EntityCrab.class, player.getBoundingBox().grow(50));
                ModTriggers.USE_CRAB_DISK.trigger(player);
                for(EntityCrab crab : crabs) {
                    crab.crabRave();
                }

            } else {
                List<EntityCrab> crabs = player.getEntityWorld().getEntitiesWithinAABB(EntityCrab.class, player.getBoundingBox().grow(100));
                for(EntityCrab crab : crabs) {
                    crab.unCrabRave();
                }
            }
        } else if(item == ModItems.RECORD_WALRUS.get() && added) {
            ModTriggers.USE_WALRUS_DISK.trigger(player);
        }
    }
    
    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event) {
        IRandomRange simple_one = new IRandomRange() {
            @Override
            public int generateInt(Random rand) {
                return 1;
            }

            @Override
            public ResourceLocation getType() {
                return IRandomRange.CONSTANT;
            }
        };
        if(event.getName().equals(EntityType.WOLF.getLootTable())) {
            IVariant v = ModEntities.FERAL_WOLF.getVariantForName("snowy");
            if(v instanceof WolfVariant) {
                WolfVariant variant = (WolfVariant) v;
                event.getTable().addPool(LootPool.builder().rolls(simple_one).name("snowy_pelt").addEntry(TableLootEntry.builder(variant.getLootTable())).build());
            }
        } else if(event.getName().equals(EntityType.SQUID.getLootTable())) {
            event.getTable().addPool(LootPool.builder().rolls(simple_one).name("bap_calamari").addEntry(TableLootEntry.builder(ModLootTables.SQUID)).build());
        }
    }
    
    @SubscribeEvent
    public static void onPlayerDamage(AttackEntityEvent event) {
        if(event.getPlayer() instanceof ServerPlayerEntity && (event.getTarget() instanceof EntityBear || event.getTarget() instanceof PolarBearEntity)) {
            if(event.getPlayer().getHeldItemMainhand().isEmpty()) {
                ModTriggers.PUNCH_BEAR.trigger((ServerPlayerEntity) event.getPlayer());
            }
        }
    }
    
    @SubscribeEvent
    public static void onPlayerRespawn(PlayerEvent.Clone event) {
        if(event.getOriginal().getPersistentData().contains("betteranimalsplus", Constants.NBT.TAG_COMPOUND)) {
            event.getPlayer().getPersistentData().put("betteranimalsplus", event.getOriginal().getPersistentData().getCompound("betteranimalsplus"));
        }
    }
    
    @SubscribeEvent
    public static void onLivingDrop(LivingDropsEvent event) {
        if(event.getSource().getTrueSource() != null && !(event.getEntity() instanceof PlayerEntity) && NO_ATTACKED_DROPS.stream().anyMatch(predicate -> predicate.test(event.getSource().getTrueSource())) && (!(event.getSource().getTrueSource() instanceof IBucketable) || !((IBucketable) event.getSource().getTrueSource()).isFromContainer())) {
            event.getDrops().clear();
        }
    }

}