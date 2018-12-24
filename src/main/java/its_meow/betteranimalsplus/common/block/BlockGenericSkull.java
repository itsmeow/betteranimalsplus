package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.common.item.ItemBlockSkull;
import its_meow.betteranimalsplus.init.BlockRegistry;
import its_meow.betteranimalsplus.init.ItemRegistry;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGenericSkull extends BlockAnimalSkull implements ITileEntityProvider {
	
	public final boolean allowFloor;
	public final Class<? extends TileEntity> teClass;
	
	public BlockGenericSkull(Class<? extends TileEntity> teClass, String name, boolean allowFloor) {
		super();
		this.setRegistryName(name);
		this.setUnlocalizedName("betteranimalsplus." + name);
		this.teClass = teClass;
		this.allowFloor = allowFloor;
	}


	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		try {
			return teClass.newInstance();
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
