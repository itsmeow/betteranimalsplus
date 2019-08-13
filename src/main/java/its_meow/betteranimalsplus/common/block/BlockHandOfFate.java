package its_meow.betteranimalsplus.common.block;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHandOfFate extends Block {

    public static final PropertyDirection FACING = BlockHorizontal.FACING;
    protected static final AxisAlignedBB AABB;
    
    static {
        double d = 0.0625D * 3;
        AABB = new AxisAlignedBB(d, 0.0D, d, 1D - d, 1.2D, 1D - d);
    }

    public BlockHandOfFate() {
        super(Material.IRON);
        this.translucent = true;
        this.fullBlock = false;
        this.setUnlocalizedName("betteranimalsplus.handoffate");
        this.setRegistryName("handoffate");
        this.setCreativeTab(BetterAnimalsPlusMod.tab);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setHardness(3.0F);
        this.setHarvestLevel("pickaxe", 0);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        return AABB;
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        TileEntity te = world.getTileEntity(pos);
        if (te instanceof TileEntityHandOfFate) {
            TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
            if (tehof.isOnFire()) {
                return 15;
            }
        }
        return super.getLightValue(state, world, pos);
    }

    @Override
    public int getLightOpacity(IBlockState state, IBlockAccess world, BlockPos pos) {
        return 2;
    }

    @Override
    public boolean hasCustomBreakingProgress(IBlockState state) {
        return true;
    }

    /**
     * Called by ItemBlocks just before a block is actually set in the world, to
     * allow for adjustments to the
     * IBlockstate
     */
    @Override
    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        return this.getDefaultState().withProperty(FACING, placer.getHorizontalFacing());
    }

    /**
     * Convert the given metadata into a BlockState for this Block
     */
    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing enumfacing = EnumFacing.getFront(meta);

        if (enumfacing.getAxis() == EnumFacing.Axis.Y) {
            enumfacing = EnumFacing.NORTH;
        }

        return this.getDefaultState().withProperty(FACING, enumfacing);
    }

    /**
     * Convert the BlockState into the correct metadata value
     */
    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(FACING).getIndex();
    }

    /**
     * Returns the blockstate with the given rotation from the passed blockstate. If
     * inapplicable, returns the passed
     * blockstate.
     */
    @Override
    public IBlockState withRotation(IBlockState state, Rotation rot) {
        return state.withProperty(FACING, rot.rotate(state.getValue(FACING)));
    }

    /**
     * Returns the blockstate with the given mirror of the passed blockstate. If
     * inapplicable, returns the passed
     * blockstate.
     */
    @Override
    public IBlockState withMirror(IBlockState state, Mirror mirrorIn) {
        return state.withRotation(mirrorIn.toRotation(state.getValue(FACING)));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[] { FACING });
    }

    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        ItemStack held = playerIn.getHeldItem(hand);
        if (held.getItem() == Items.FLINT_AND_STEEL) {
            if (!playerIn.isCreative()) {
                held.damageItem(1, playerIn);
            }
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityHandOfFate) {
                TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
                tehof.setOnFire(true);
                return true;
            }
        } else if (held.getItem() == Item.getItemFromBlock(Blocks.SAND) || held.getItem() == Items.WATER_BUCKET) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityHandOfFate) {
                TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
                tehof.setOnFire(false);
                return true;
            }
        } else if (held.getItem() == Items.NETHER_WART) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityHandOfFate) {
                TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
                if (!tehof.hasNetherWart() && tehof.isOnFire()) {
                    if (!playerIn.isCreative()) {
                        held.shrink(1);
                    }
                    tehof.setHasNetherWart(playerIn, true);
                    return true;
                }
            }
        } else if (held.getItem() == ModItems.antler) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityHandOfFate) {
                TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
                if (!tehof.hasAntler() && tehof.isOnFire()) {
                    if (!playerIn.isCreative()) {
                        held.shrink(1);
                    }
                    tehof.setHasAntler(playerIn, true);
                    return true;
                }
            }
        } else if (held.getItem() == ModItems.venisonRaw || held.getItem() == ModItems.venisonCooked) {
            TileEntity te = worldIn.getTileEntity(pos);
            if (te instanceof TileEntityHandOfFate) {
                TileEntityHandOfFate tehof = (TileEntityHandOfFate) te;
                if (!tehof.hasVenison() && tehof.isOnFire()) {
                    if (!playerIn.isCreative()) {
                        held.shrink(1);
                    }
                    tehof.setHasVenison(playerIn, true);
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Override
    public boolean isTopSolid(IBlockState state) {
        return false;
    }

    @Override
    public boolean isSideSolid(IBlockState base_state, IBlockAccess world, BlockPos pos, EnumFacing side) {
        return false;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state) {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public boolean hasTileEntity() {
        return true;
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }
    
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Override
    public TileEntity createTileEntity(World worldIn, IBlockState state) {
        return new TileEntityHandOfFate(worldIn);
    }

}
