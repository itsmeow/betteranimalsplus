package its_meow.betteranimalsplus.common.block;

import java.util.function.Supplier;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.init.BlockRegistry;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
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

	public BlockGenericSkull(Class<? extends TileEntity> teClass, String name, boolean allowFloor, int textureCount, Supplier<? extends TileEntity> teSupplier) {
		super();
		this.setRegistryName(name);
		this.teClass = teClass;
		this.allowFloor = allowFloor;
		this.texCount = textureCount;
		this.teSupplier = teSupplier;
	}


	@Override
	public void getDrops(IBlockState state, NonNullList<ItemStack> drops, World world, BlockPos pos, int fortune) {
		if (!((Boolean)state.getValue(NODROP)).booleanValue()) {
			Item item = this.getItemBlock();
			if (item != null && item != Items.AIR) {
				ItemStack stack = new ItemStack(item);
				TileEntity te = world.getTileEntity(pos);
				if(te != null && te instanceof TileEntityHead) {
					TileEntityHead teH = (TileEntityHead) te;
					stack.setTagCompound(new NBTTagCompound());
					stack.getTagCompound().setInteger("TYPENUM", teH.typeValue());
				}

				drops.add(stack);
			}
		}
	}

	@Override
	public TileEntity createNewTileEntity(IBlockReader reader)
	{
		try {
			return this.teClass.newInstance();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ItemBlock getItemBlock() {
		return BlockRegistry.getSkullItemForBlock(this);
	}

}
