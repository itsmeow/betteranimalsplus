package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.common.item.ItemBlockSkull;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGenericSkull extends BlockAnimalSkull implements ITileEntityProvider {
	
	private Class<? extends TileEntity> teClass;
	
	public BlockGenericSkull(Class<? extends TileEntity> teClass, String name) {
		super();
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.teClass = teClass;
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
		return new ItemBlockSkull(this);
	}

}
