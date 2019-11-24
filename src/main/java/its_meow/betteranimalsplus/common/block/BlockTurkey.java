package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.Ref;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTurkey extends Block {

    public static final PropertyInteger BITES = PropertyInteger.create("bites", 0, 3);
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    protected static final AxisAlignedBB[] X_AABBS = new AxisAlignedBB[] {
        new AxisAlignedBB(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
        new AxisAlignedBB(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
        new AxisAlignedBB(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 3)),
        new AxisAlignedBB(0.0625D * 2, 0.0D, 0.0625D * 3, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 4)),
        new AxisAlignedBB(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 7D, 1D - (0.0625D * 4)),
        new AxisAlignedBB(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 5D, 1D - (0.0625D * 4)),
        new AxisAlignedBB(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 3D, 1D - (0.0625D * 4)),
        new AxisAlignedBB(0.0625D * 2, 0.0D, 0.0625D * 4, 1D - (0.0625D * 2), 0.0625D * 2D, 1D - (0.0625D * 4))
    };
    protected static final AxisAlignedBB[] Y_AABBS = new AxisAlignedBB[] {
        new AxisAlignedBB(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
        new AxisAlignedBB(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
        new AxisAlignedBB(0.0625D * 3, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
        new AxisAlignedBB(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 3), 0.0625D * 7D, 1D - (0.0625D * 2)),
        new AxisAlignedBB(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 7D, 1D - (0.0625D * 2)),
        new AxisAlignedBB(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 5D, 1D - (0.0625D * 2)),
        new AxisAlignedBB(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 3D, 1D - (0.0625D * 2)),
        new AxisAlignedBB(0.0625D * 4, 0.0D, 0.0625D * 2, 1D - (0.0625D * 4), 0.0625D * 2D, 1D - (0.0625D * 2))
    };
    protected BlockTurkey secondPart;
    
    public BlockTurkey(String name) {
        super(Material.SPONGE);
        this.setRegistryName(Ref.MOD_ID, name);
        this.setTranslationKey(Ref.MOD_ID + "." + name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BITES, 0).withProperty(FACING, EnumFacing.NORTH));
    }

    public BlockTurkey(String name, BlockTurkey secondPart) {
        this(name);
        this.secondPart = secondPart;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return state.getValue(FACING).getAxis() == Axis.X ? X_AABBS[state.getValue(BITES) + (secondPart == null ? 4 : 0)] : Y_AABBS[state.getValue(BITES) + (secondPart == null ? 4 : 0)];
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if(!worldIn.isRemote) {
            return eat(worldIn, pos, state, playerIn);
        } else {
            ItemStack itemstack = playerIn.getHeldItem(hand);
            return eat(worldIn, pos, state, playerIn) || itemstack.isEmpty();
        }
    }

    protected boolean eat(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player) {
        if(!player.canEat(false)) {
            return false;
        } else {
            int i = state.getValue(BITES);

            if(secondPart != null && i < 3) {
                worldIn.setBlockState(pos, state.withProperty(BITES, i + 1), 3);
                if(i < 2) {
                    player.getFoodStats().addStats(2, 0.3F);
                } else {
                    player.getFoodStats().addStats(4, 0.3F);
                }
            } else if(secondPart != null && i == 3) {
                worldIn.setBlockState(pos, secondPart.getDefaultState().withProperty(FACING, state.getValue(FACING)));
                player.getFoodStats().addStats(4, 0.3F);
            } else if(secondPart == null && i < 3) {
                worldIn.setBlockState(pos, state.withProperty(BITES, i + 1), 3);
                player.getFoodStats().addStats(4, 0.3F);
            } else {
                worldIn.setBlockToAir(pos);
                player.getFoodStats().addStats(4, 0.3F);
            }

            return true;
        }
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos) {
        return super.canPlaceBlockAt(worldIn, pos) ? canBlockStay(worldIn, pos) : false;
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if(!canBlockStay(worldIn, pos)) {
            this.dropBlockAsItem(worldIn, pos, state, 0);
            worldIn.setBlockToAir(pos);
        }
    }

    private static boolean canBlockStay(World worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).getMaterial().isSolid();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(BITES, meta & 3).withProperty(FACING, EnumFacing.byIndex((meta >> 2 & 3) + 2));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return (state.getValue(FACING).getIndex() - 2) << 2 | state.getValue(BITES);
    }
    
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
    }

    @SideOnly(Side.CLIENT)
    public BlockRenderLayer getBlockLayer() {
        return BlockRenderLayer.CUTOUT;
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { BITES, FACING });
    }

    @Override
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
        if(state.getValue(BITES) == 0 && secondPart != null) {
            super.getDrops(drops, world, pos, state, fortune);
        }
    }

}
