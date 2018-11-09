package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.common.tileentity.TileEntityWolfHead;
import its_meow.betteranimalsplus.init.ItemRegistry;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockWolfHead extends BlockAnimalSkull implements ITileEntityProvider {

	public BlockWolfHead() {
		super();
		this.setRegistryName("wolfhead");
		this.setUnlocalizedName("wolfhead");
	}


	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityWolfHead();
	}

	@Override
	public ItemBlock getItemBlock() {
		return ItemRegistry.itemWolfHead;
	}

}
