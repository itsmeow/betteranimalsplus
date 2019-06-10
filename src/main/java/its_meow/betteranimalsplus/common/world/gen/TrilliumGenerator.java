package its_meow.betteranimalsplus.common.world.gen;

import java.util.Random;

import its_meow.betteranimalsplus.init.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalBlock;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

public class TrilliumGenerator extends Feature<NoFeatureConfig> {

    public TrilliumGenerator() {
        super(NoFeatureConfig::deserialize);
    }

    @Override
    public boolean place(IWorld world, ChunkGenerator<? extends GenerationSettings> genSettings, Random rand,
                         BlockPos pos, NoFeatureConfig cfg) {
        for (BlockState iblockstate = world.getBlockState(pos); (iblockstate.isAir(world, pos)
                || iblockstate.isIn(BlockTags.LEAVES)) && pos.getY() > 0; iblockstate = world.getBlockState(pos)) {
            pos = pos.down();
        }

        BlockState iblockstate1 = ModBlocks.TRILLIUM.getDefaultState();

        for (int i = 0; i < 4; ++i) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4),
                    rand.nextInt(8) - rand.nextInt(8));
            if (world.isAirBlock(blockpos) && iblockstate1.isValidPosition(world, blockpos)) {
                world.setBlockState(blockpos, iblockstate1.with(HorizontalBlock.HORIZONTAL_FACING,
                        Direction.byHorizontalIndex(rand.nextInt(4))), 2);
            }
        }

        return true;
    }

}
