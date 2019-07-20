package its_meow.betteranimalsplus.common;

import java.util.List;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.BlockJukebox.TileEntityJukebox;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.storage.loot.LootEntry;
import net.minecraft.world.storage.loot.LootEntryTable;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTableList;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraft.world.storage.loot.conditions.LootCondition;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class CommonEventHandler {

    @SubscribeEvent
    public static void onDeathOfEntity(LivingDeathEvent e) {
        if (e.getSource().getImmediateSource() instanceof EntityBoar) {
            EntityBoar boar = (EntityBoar) e.getSource().getImmediateSource();
            boar.setInLove(null);
            BlockPos p = boar.getPosition();
            boar.world.spawnParticle(EnumParticleTypes.HEART, p.getX(), p.getY(), p.getZ(), 0.0F, 0.05F, 0.0F);
        }
    }
    
    @SubscribeEvent
    public static void onBlockActivate(PlayerInteractEvent.RightClickBlock event) {
        if(event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.JUKEBOX) {
            TileEntity te = event.getWorld().getTileEntity(event.getPos());
            if(te instanceof TileEntityJukebox) {
                TileEntityJukebox box = (TileEntityJukebox) te;
                boolean held = event.getEntityPlayer().getHeldItem(event.getHand()).getItem() == ModItems.RECORD_CRAB_RAVE;
                if(box.getRecord().getItem() == ModItems.RECORD_CRAB_RAVE) {
                    List<EntityCrab> crabs = event.getWorld().getEntitiesWithinAABB(EntityCrab.class, event.getEntityPlayer().getEntityBoundingBox().grow(50));
                    for(EntityCrab crab : crabs) {
                        crab.unCrabRave();
                    }
                } else if(held) {
                    List<EntityCrab> crabs = event.getWorld().getEntitiesWithinAABB(EntityCrab.class, event.getEntityPlayer().getEntityBoundingBox().grow(50));
                    for(EntityCrab crab : crabs) {
                        crab.crabRave();
                    }
                }
            }
        }
    }
    
    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event) {
        if(event.getName().equals(LootTableList.ENTITIES_WOLF)) {
            event.getTable().addPool(new LootPool(new LootEntry[] {new LootEntryTable(ModLootTables.WOLF_SNOWY, 1, 0, new LootCondition[0], "betteranimalsplus_wolf_snowy_inject_entry")}, new LootCondition[0], new RandomValueRange(1), new RandomValueRange(0), "snowy_pelt"));
        }
    }

}