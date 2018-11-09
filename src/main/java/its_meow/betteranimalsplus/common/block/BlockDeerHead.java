package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.client.model.ModelDeerHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.init.ItemRegistry;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockDeerHead extends BlockAnimalSkull implements ITileEntityProvider {

	public BlockDeerHead() {
		super();
		this.setRegistryName("deerhead");
		this.setUnlocalizedName("deerhead");
	}


	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta)
	{
		return new TileEntityHead(ModelDeerHead.class.asSubclass(ModelBase.class), TextureRegistry.deer_2);
	}
	
	@Override
	public ItemBlock getItemBlock() {
		return ItemRegistry.itemDeerHead;
	}

}
