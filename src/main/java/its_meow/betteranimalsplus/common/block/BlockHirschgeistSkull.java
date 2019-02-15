package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHirschgeistSkull;
import its_meow.betteranimalsplus.init.ItemRegistry;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockHirschgeistSkull extends BlockAnimalSkull {

	public BlockHirschgeistSkull() {
		super();
		this.setRegistryName("hirschgeistskull");
	}


	@Override
	public TileEntity createNewTileEntity(IBlockReader world)
	{
		return new TileEntityHirschgeistSkull();
	}
	
	@Override
	public ItemBlock getItemBlock() {
		return ItemRegistry.itemHirschgeistSkull;
	}

}
