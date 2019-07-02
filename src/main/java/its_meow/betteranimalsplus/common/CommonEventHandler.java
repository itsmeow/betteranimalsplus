package its_meow.betteranimalsplus.common;

import java.util.List;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.EntityBoar;
import its_meow.betteranimalsplus.common.entity.EntityCrab;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.block.Blocks;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.JukeboxTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID)
public class CommonEventHandler {

    @SubscribeEvent
    public static void onDeathOfEntity(LivingDeathEvent e) {
        if (e.getSource().getImmediateSource() instanceof EntityBoar) {
            EntityBoar boar = (EntityBoar) e.getSource().getImmediateSource();
            boar.setInLove(null);
            BlockPos p = boar.getPosition();
            boar.world.addParticle(ParticleTypes.HEART, p.getX(), p.getY(), p.getZ(), 0.0F, 0.05F, 0.0F);
        }
    }
    
    @SubscribeEvent
    public static void onBlockActivate(PlayerInteractEvent.RightClickBlock event) {
        if(event.getWorld().getBlockState(event.getPos()).getBlock() == Blocks.JUKEBOX) {
            TileEntity te = event.getWorld().getTileEntity(event.getPos());
            if(te instanceof JukeboxTileEntity) {
                JukeboxTileEntity box = (JukeboxTileEntity) te;
                boolean held = event.getEntityPlayer().getHeldItem(event.getHand()).getItem() == ModItems.RECORD_CRAB_RAVE;
                if(box.getRecord().getItem() == ModItems.RECORD_CRAB_RAVE) {
                    List<EntityCrab> crabs = event.getWorld().getEntitiesWithinAABB(EntityCrab.class, event.getEntityPlayer().getBoundingBox().grow(50));
                    for(EntityCrab crab : crabs) {
                        crab.unCrabRave();
                    }
                } else if(held) {
                    List<EntityCrab> crabs = event.getWorld().getEntitiesWithinAABB(EntityCrab.class, event.getEntityPlayer().getBoundingBox().grow(50));
                    for(EntityCrab crab : crabs) {
                        crab.crabRave();
                    }
                }
            }
        }
    }

}