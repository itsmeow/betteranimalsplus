package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.init.ModBlocks;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockGenericSkull extends BlockAnimalSkull implements ITileEntityProvider {

    public final boolean allowFloor;
    public final Class<? extends TileEntity> teClass;
    public final int texCount;

    public BlockGenericSkull(Class<? extends TileEntity> teClass, String name, boolean allowFloor, int textureCount) {
        super();
        this.setRegistryName(name);
        this.setUnlocalizedName("betteranimalsplus." + name);
        this.teClass = teClass;
        this.allowFloor = allowFloor;
        this.texCount = textureCount;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        if (!state.getValue(NODROP).booleanValue()) {
            Item item = this.getItemBlock();
            if (item != null && item != Items.AIR) {
                ItemStack stack = new ItemStack(item);
                TileEntity te = world.getTileEntity(pos);
                if (te != null && te instanceof TileEntityHead) {
                    TileEntityHead teH = (TileEntityHead) te;
                    stack.setTagCompound(new NBTTagCompound());
                    stack.getTagCompound().setInteger("TYPENUM", teH.typeValue());
                }

                drops.add(stack);
            }
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta) {
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
        return ModBlocks.getSkullItemForBlock(this);
    }

}
