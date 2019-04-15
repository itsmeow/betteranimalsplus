package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGenericSkull extends BlockAnimalSkull {

	public final HeadTypes type;
	public final int typeNum;

	public BlockGenericSkull(HeadTypes type, int typeNum) {
		this.typeNum = typeNum;
		this.setRegistryName(type.name + "_" + typeNum);
		this.setUnlocalizedName(Ref.MOD_ID + "." + type.name);
		this.setCreativeTab(BetterAnimalsPlusMod.tab);
		this.type = type;
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) {
		return new ItemStack(type.getItem(typeNum));
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state,
			int fortune) {
		drops.add(new ItemStack(type.getItem(typeNum)));
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return typeNum > 0 ? type.teFactory.apply(type) : null;
	}

}