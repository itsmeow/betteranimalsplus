package its_meow.betteranimalsplus.common.world.gen;

import java.util.Random;

import its_meow.betteranimalsplus.common.block.BlockTrillium;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TrilliumGenerator extends Feature {

	private BlockTrillium trillium;
	private IBlockState state;

	public TrilliumGenerator(BlockTrillium trilliumIn) {
		setGeneratedBlock(trilliumIn);
	}

	public void setGeneratedBlock(BlockTrillium trilliumIn)
	{
		this.trillium = trilliumIn;
		this.state = trilliumIn.getDefaultState();
	}

	@Override
	public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator,
			IChunkProvider chunkProvider)
	{
		int x = (chunkX * 16) + 8 + (random.nextInt(16) - 8);
		int z = (chunkZ * 16) + 8 + (random.nextInt(16) - 8);
		int y = 64;
		BlockPos blockpos = new BlockPos(x, y, z);
		if(BiomeDictionary.hasType(world.getBiome(blockpos), BiomeDictionary.Type.SWAMP)) {
			for (int i = 0; i < 64; ++i)
			{
				blockpos = new BlockPos(x, i, z);

				if (world.isAirBlock(blockpos) && this.trillium.canBlockStay(world, blockpos, this.state))
				{
					EnumFacing face = EnumFacing.HORIZONTALS[random.nextInt(4)];
					world.setBlockState(blockpos, this.state.withProperty(BlockHorizontal.FACING, face));
				}
			}
		}
	}

	@Override
	public boolean func_212245_a(IWorld world, IChunkGenerator generator, Random rand,
			BlockPos pos, IFeatureConfig config) {
		// TODO Auto-generated method stub
		return false;
	}

}
