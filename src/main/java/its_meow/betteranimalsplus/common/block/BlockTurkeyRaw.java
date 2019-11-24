package its_meow.betteranimalsplus.common.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTurkeyRaw extends BlockTurkey {
    
    public BlockTurkeyRaw(String name) {
        super(name);
    }

    public BlockTurkeyRaw(String name, BlockTurkey secondPart) {
        super(name, secondPart);
    }
    
    protected boolean eat(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if(!player.canEat(false)) {
            return false;
        } else {
            int i = state.getValue(BITES);

            if(secondPart != null && i < 3) {
                worldIn.setBlockState(pos, state.withProperty(BITES, i + 1), 3);
                if(i < 2) {
                    player.getFoodStats().addStats(1, 0.1F);
                } else {
                    player.getFoodStats().addStats(2, 0.1F);
                }
            } else if(secondPart != null && i == 3) {
                worldIn.setBlockState(pos, secondPart.getDefaultState().withProperty(FACING, state.getValue(FACING)));
                player.getFoodStats().addStats(2, 0.1F);
            } else if(secondPart == null && i < 3) {
                worldIn.setBlockState(pos, state.withProperty(BITES, i + 1), 3);
                player.getFoodStats().addStats(2, 0.1F);
            } else {
                worldIn.setBlockToAir(pos);
                player.getFoodStats().addStats(2, 0.1F);
            }
            player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("poison"), 400, 1, false, false));
            return true;
        }
    }

}
