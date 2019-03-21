package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHirschgeistSkull;
import its_meow.betteranimalsplus.init.ItemRegistry;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockHirschgeistSkull extends BlockAnimalSkull implements ITileEntityProvider {

    public BlockHirschgeistSkull() {
        super();
        this.setRegistryName("hirschgeistskull");
        this.setUnlocalizedName("betteranimalsplus.hirschgeistskull");
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
        return new TileEntityHirschgeistSkull();
    }

    @Override
    public ItemBlock getItemBlock() {
        return ItemRegistry.itemHirschgeistSkull;
    }

}
