package its_meow.betteranimalsplus.common.block;

import javax.annotation.Nullable;

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
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockTurkey extends Block {

    public static final PropertyInteger BITES = PropertyInteger.create("bites", 0, 3);
    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    protected static final AxisAlignedBB AABB = new AxisAlignedBB(0.0625D, 0.0D, 0.0625D, 0.9375D, 0.9375D, 0.9375D);
    private BlockTurkey secondPart;
    
    public BlockTurkey(String name) {
        super(Material.SPONGE);
        this.setRegistryName(Ref.MOD_ID, name);
        this.setUnlocalizedName(Ref.MOD_ID + "." + name);
        this.setDefaultState(this.blockState.getBaseState().withProperty(BITES, 0).withProperty(FACING, EnumFacing.NORTH));
    }

    public BlockTurkey(String name, BlockTurkey secondPart) {
        this(name);
        this.secondPart = secondPart;
    }

    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return AABB;
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
            return eat(worldIn, pos, state, playerIn, secondPart);
        } else {
            ItemStack itemstack = playerIn.getHeldItem(hand);
            return eat(worldIn, pos, state, playerIn, secondPart) || itemstack.isEmpty();
        }
    }

    private static boolean eat(World worldIn, BlockPos pos, IBlockState state, EntityPlayer player, @Nullable BlockTurkey secondPart) {
        if(!player.canEat(false)) {
            return false;
        } else {
            player.getFoodStats().addStats(2, 0.1F);
            int i = state.getValue(BITES);

            if(secondPart != null && i < 3) {
                worldIn.setBlockState(pos, state.withProperty(BITES, i + 1), 3);
            } else if(secondPart != null && i == 3) {
                worldIn.setBlockState(pos, secondPart.getDefaultState().withProperty(FACING, state.getValue(FACING)));
            } else if(secondPart == null && i < 3) {
                worldIn.setBlockState(pos, state.withProperty(BITES, i + 1), 3);
            } else {
                worldIn.setBlockToAir(pos);
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
            worldIn.setBlockToAir(pos);
        }
    }

    private static boolean canBlockStay(World worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.down()).getMaterial().isSolid();
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(BITES, meta & 3).withProperty(FACING, EnumFacing.getFront((meta >> 2 & 3) + 2));
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

}
