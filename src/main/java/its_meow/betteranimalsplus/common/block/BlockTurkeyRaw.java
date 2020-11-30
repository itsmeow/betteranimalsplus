package its_meow.betteranimalsplus.common.block;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTurkeyRaw extends BlockTurkey {

    public BlockTurkeyRaw() {
        super();
    }
    
    @Override
    protected ActionResultType eat(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        if(!player.canEat(false)) {
            return ActionResultType.FAIL;
        } else {
            int i = state.get(BITES);

            if(i < 7) {
                worldIn.setBlockState(pos, state.with(BITES, i + 1), 3);
                if(i < 2) {
                    player.getFoodStats().addStats(1, 0.1F);
                } else {
                    player.getFoodStats().addStats(2, 0.1F);
                }
            } else {
                worldIn.setBlockState(pos, Blocks.AIR.getDefaultState());
                player.getFoodStats().addStats(2, 0.1F);
            }
            player.addPotionEffect(new EffectInstance(Effects.POISON, 400, 1, false, false));
            return ActionResultType.CONSUME;
        }
    }

}