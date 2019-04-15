package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockGenericSkull extends BlockAnimalSkull {

	public final HeadTypes type;

	public BlockGenericSkull(HeadTypes type) {
		super();
		this.setRegistryName(type.name);
		this.setUnlocalizedName(Ref.MOD_ID + "." + type.name);
		this.setCreativeTab(BetterAnimalsPlusMod.tab);
		this.type = type;
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return type.teFactory.apply(type);
	}

}