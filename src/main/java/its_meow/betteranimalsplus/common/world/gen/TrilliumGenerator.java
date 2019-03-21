package its_meow.betteranimalsplus.common.world.gen;

import java.util.Random;

import its_meow.betteranimalsplus.init.ModBlocks;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.IChunkGenSettings;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class TrilliumGenerator extends Feature<NoFeatureConfig> {

    @Override
    public boolean func_212245_a(IWorld world, IChunkGenerator<? extends IChunkGenSettings> genSettings, Random rand,
            BlockPos pos, NoFeatureConfig cfg) {
        for (IBlockState iblockstate = world.getBlockState(pos); (iblockstate.isAir(world, pos)
                || iblockstate.isIn(BlockTags.LEAVES)) && pos.getY() > 0; iblockstate = world.getBlockState(pos)) {
            pos = pos.down();
        }

        IBlockState iblockstate1 = ModBlocks.TRILLIUM.getDefaultState();

        for (int i = 0; i < 4; ++i) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4),
                    rand.nextInt(8) - rand.nextInt(8));
            if (world.isAirBlock(blockpos) && iblockstate1.isValidPosition(world, blockpos)) {
                world.setBlockState(blockpos, iblockstate1.with(BlockHorizontal.HORIZONTAL_FACING,
                        EnumFacing.byHorizontalIndex(rand.nextInt(4))), 2);
            }
        }

        return true;
    }

}
