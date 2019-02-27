package its_meow.betteranimalsplus.common.block;

import java.util.function.Supplier;

import its_meow.betteranimalsplus.init.BlockRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

public class BlockGenericSkull extends BlockAnimalSkull {

	public final boolean allowFloor;
	public final Class<? extends TileEntity> teClass;
	public final int texCount;
	public Supplier<? extends TileEntity> teSupplier;

	public BlockGenericSkull(Class<? extends TileEntity> teClass, String name, boolean allowFloor, int textureCount,
			Supplier<? extends TileEntity> teSupplier) {
		super();
		this.setRegistryName(name);
		this.teClass = teClass;
		this.allowFloor = allowFloor;
		this.texCount = textureCount;
		this.teSupplier = teSupplier;
	}


	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		super.getDrops(state, drops, world, pos, fortune);
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader reader) {
		try {
			return this.teClass.newInstance();
		} catch(InstantiationException e) {
			e.printStackTrace();
		} catch(IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ItemBlock getItemBlock() {
		return BlockRegistry.getSkullItemForBlock(this, 1);
	}

	@Override
	public ItemBlock getItemBlock(int texID) {
		return BlockRegistry.getSkullItemForBlock(this, texID);
	}

}
