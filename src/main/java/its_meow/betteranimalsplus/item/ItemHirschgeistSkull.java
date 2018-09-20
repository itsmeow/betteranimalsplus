package its_meow.betteranimalsplus.item;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.block.TileEntityHirschgeistSkull;
import its_meow.betteranimalsplus.entity.model.ModelHirschgeistSkull;
import its_meow.betteranimalsplus.entity.model.ModelHirschgeistSkullArmorPiece;
import its_meow.betteranimalsplus.proxy.ClientProxy;
import its_meow.betteranimalsplus.registry.BlockRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockSkull;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemSkull;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemHirschgeistSkull extends ItemBlockParentHirschgeistSkull {

	//Is non static!
	private Block block;

	public ItemHirschgeistSkull(Block block) {
		super(block);
		setMaxDamage(0);
		this.setUnlocalizedName("hirschgeistskull");
		//this.setRegistryName("hirschgeistskullitem");
		this.block = block;
		ItemArmor armor;
	}
	
	@Override
	public EnumActionResult onItemUse(EntityPlayer player, World world, BlockPos pos, EnumHand hand,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem(hand);
		if (side == EnumFacing.DOWN) {
			return EnumActionResult.FAIL;
		} else {
			BlockPos clickedPos = pos.offset(side);
			IBlockState clickedState = world.getBlockState(clickedPos);
			if(!clickedState.getBlock().isReplaceable(world, clickedPos)) {
				return EnumActionResult.FAIL;
			}
			if (!world.isRemote) {
				world.setBlockState(clickedPos, block.getDefaultState().withProperty(BlockSkull.FACING, side), 3);

				TileEntity tile = world.getTileEntity(clickedPos);
				populateTile(stack, side, player, tile);
			}
			return EnumActionResult.SUCCESS;
		}
	}



	protected void populateTile(ItemStack stack, EnumFacing side, EntityPlayer player, TileEntity tile) {
		if (tile instanceof TileEntityHirschgeistSkull) {
			TileEntityHirschgeistSkull tileSkull = (TileEntityHirschgeistSkull) tile;
			int rotation = 0;
			if (side == EnumFacing.UP)
				rotation = MathHelper.floor(player.rotationYaw * 16.0F / 360.0F + 0.5D) & 15;
			tileSkull.setSkullRotation(rotation);
		}
	}

	@Override
	public boolean isValidArmor(ItemStack stack, EntityEquipmentSlot armorType, Entity entity) {
		return armorType == EntityEquipmentSlot.HEAD;
	}

	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, EntityEquipmentSlot slot, String type)
	{
		return Ref.MOD_ID + ":textures/entites/hirschgeist.png";
	}

	@Override 	
	@SideOnly(Side.CLIENT)
	public ModelBiped getArmorModel(EntityLivingBase entityLiving, ItemStack itemStack, EntityEquipmentSlot armorSlot,
			ModelBiped defaultModel) {
		return ClientProxy.helmetModel;
	}



}
