package dev.itsmeow.betteranimalsplus.common.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

public class BlockTurkeyRaw extends BlockTurkey {

    public BlockTurkeyRaw() {
        super();
    }

    @Override
    protected InteractionResult eat(Level worldIn, BlockPos pos, BlockState state, Player player) {
        if (!player.canEat(false)) {
            return InteractionResult.FAIL;
        } else {
            int i = state.getValue(BITES);

            if (i < 7) {
                worldIn.setBlock(pos, state.setValue(BITES, i + 1), 3);
                if (i < 2) {
                    player.getFoodData().eat(1, 0.1F);
                } else {
                    player.getFoodData().eat(2, 0.1F);
                }
            } else {
                worldIn.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
                player.getFoodData().eat(2, 0.1F);
            }
            player.addEffect(new MobEffectInstance(MobEffects.POISON, 400, 1, false, false));
            return InteractionResult.CONSUME;
        }
    }

}