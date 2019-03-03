package its_meow.betteranimalsplus.common.tileentity;

import java.util.Random;

import its_meow.betteranimalsplus.init.BlockRegistry;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TileEntityTrillium extends TileEntity {

	private int typeNum;
	private final String keyType = "trilliumType";

	private int modelNum;
	private final String keyModel = "trilliumModel";


	public TileEntityTrillium() {
		super(BlockRegistry.RegistrationHandler.TRILLIUM_TYPE);
		if(!this.getTileData().hasKey(this.keyType)) {
			this.setType(new Random().nextInt(5));
		}
		if(!this.getTileData().hasKey(this.keyModel)) {
			this.modelNum = new Random().nextInt(3);
			this.markDirty();
		}
	}


	public ResourceLocation getTexture() {
		return this.typeNum == 0 ? TextureRegistry.trillium2 : TextureRegistry.trillium; // 1/5 chance of yellow trillium
	}


	public void setType(int i) {
		this.typeNum = i;
		this.markDirty();
	}

	public int typeValue() {
		return this.typeNum;
	}


	@Override
	public void read(NBTTagCompound compound) {
		super.read(compound);
		if(compound.hasKey(this.keyType)) {
			this.typeNum = compound.getInt(this.keyType);
		} else {
			this.setType(new Random().nextInt(5)); // 1/5 chance
		}
		if(compound.hasKey(this.keyModel)) {
			this.modelNum = compound.getInt(this.keyModel);
		} else {
			this.setModelNum(new Random().nextInt(3));
		}
	}


	@Override
	public NBTTagCompound write(NBTTagCompound compound) {
		super.write(compound);
		compound.setInt(this.keyType, this.typeNum);
		compound.setInt(this.keyModel, this.modelNum);
		return compound;
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.write(tag);
		return new SPacketUpdateTileEntity(this.pos, 1, tag);
	}


	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		this.read(packet.getNbtCompound());
		this.world.getPendingBlockTicks().scheduleTick(this.pos, this.getBlockState().getBlock(), 100);
	}


	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = new NBTTagCompound();
		this.write(tag);
		return tag;
	}
	
	public void setModelNum(int i) {
		this.modelNum = i;
		this.markDirty();
	}

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.read(tag);
	}

	@OnlyIn(Dist.CLIENT)
	public float getRotation() {
		IBlockState state = this.world.getBlockState(this.pos);
		if(state.getBlock() == BlockRegistry.trillium) {
			EnumFacing facing = state.get(BlockHorizontal.HORIZONTAL_FACING).getOpposite();
			if(facing == EnumFacing.NORTH) {
				return 0F;
			}
			if(facing == EnumFacing.EAST) {
				return 90F;
			}
			if(facing == EnumFacing.SOUTH) {
				return 180F;
			}
			if(facing == EnumFacing.WEST) {
				return 270F;
			}
		}
		return 0F;
	}

	public int getModelNum() {
		return this.modelNum;
	}


}
