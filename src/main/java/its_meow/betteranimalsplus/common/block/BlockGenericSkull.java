package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.block.BlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

public class BlockGenericSkull extends BlockAnimalSkull {

    public final HeadType type;

    public BlockGenericSkull(HeadType type, String id) {
        super();
        this.setRegistryName(Ref.MOD_ID, type.getName() + "_" + id);
        this.type = type;
    }

    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return type.createTE();
    }
}
