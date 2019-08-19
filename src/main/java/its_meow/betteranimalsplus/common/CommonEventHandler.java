package its_meow.betteranimalsplus.common;

import java.util.List;
import java.util.Random;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.EntityBear;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.common.entity.EntityLamprey;
import its_meow.betteranimalsplus.common.entity.EntitySquirrel;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.init.ModTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.JukeboxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.loot.IRandomRange;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class CommonEventHandler {

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
                CompoundNBT pTag = player.getEntityData();
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
        }
    }
    
    @SubscribeEvent
    public static void onBlockActivate(PlayerInteractEvent.RightClickBlock event) {
        if(event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.JUKEBOX) {
            TileEntity te = event.getWorld().getTileEntity(event.getPos());
            if(te instanceof JukeboxTileEntity) {
                JukeboxTileEntity box = (JukeboxTileEntity) te;
                boolean held = event.getPlayer().getHeldItem(event.getHand()).getItem() == ModItems.RECORD_CRAB_RAVE;
                if(box.getRecord().getItem() == ModItems.RECORD_CRAB_RAVE) {
                    List<EntityCrab> crabs = event.getWorld().getEntitiesWithinAABB(EntityCrab.class, event.getPlayer().getBoundingBox().grow(50));
                    for(EntityCrab crab : crabs) {
                        crab.unCrabRave();
                    }
                } else if(held) {
                    List<EntityCrab> crabs = event.getWorld().getEntitiesWithinAABB(EntityCrab.class, event.getPlayer().getBoundingBox().grow(50));
                    if(event.getPlayer() instanceof ServerPlayerEntity) {
                        ModTriggers.USE_CRAB_DISK.trigger((ServerPlayerEntity) event.getPlayer());
                    }
                    for(EntityCrab crab : crabs) {
                        crab.crabRave();
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event) {
        if(event.getName().equals(EntityType.WOLF.getLootTable())) {
            
            event.getTable().addPool(LootPool.builder().rolls(new IRandomRange() {
                @Override
                public int generateInt(Random rand) {
                    return 1;
                }

                @Override
                public ResourceLocation func_215830_a() {
                    return IRandomRange.CONSTANT;
                }
            }).name("snowy_pelt").addEntry(TableLootEntry.builder(ModLootTables.WOLF_SNOWY)).build());
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
        if(event.getOriginal().getEntityData().contains("betteranimalsplus", Constants.NBT.TAG_COMPOUND)) {
            event.getPlayer().getEntityData().put("betteranimalsplus", event.getOriginal().getEntityData().getCompound("betteranimalsplus"));
        }
    }
    
    @SubscribeEvent
    public static void onLivingDrop(LivingDropsEvent event) {
        if(event.getSource().getTrueSource() instanceof EntityLamprey && !(event.getEntity() instanceof PlayerEntity)) {
            event.getDrops().clear();
        }
    }

}