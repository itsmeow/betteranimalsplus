package its_meow.betteranimalsplus.common.tileentity;

import java.util.Random;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.client.model.ModelTrillium;
import its_meow.betteranimalsplus.client.model.ModelTrilliumMulti;
import its_meow.betteranimalsplus.client.model.ModelTrilliumMulti2;
import its_meow.betteranimalsplus.init.BlockRegistry;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TileEntityTrillium extends TileEntity {

	public static final TileEntityType<?> TRILLIUM_TYPE = TileEntityType.Builder.create(TileEntityTrillium::new).build(null).setRegistryName(Ref.MOD_ID, "trilliumtilentity");
	private int typeNum;
	private final String keyType = "trilliumType";

	private ModelBase model;

	private int modelNum;
	private final String keyModel = "trilliumModel";


	public TileEntityTrillium() {
		super(TRILLIUM_TYPE);
		if(!this.getTileData().hasKey(this.keyType)) {
			this.setType(new Random().nextInt(5));
		}
		if(!this.getTileData().hasKey(this.keyModel)) {
			this.modelNum = new Random().nextInt(3);
			this.markDirty();
			this.setModelWithNum();
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
			this.setModelWithNum();
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
		read(packet.getNbtCompound());
		world.getPendingBlockTicks().scheduleTick(this.pos, this.getBlockState().getBlock(), 100);
	}





	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = new NBTTagCompound();
		this.write(tag);
		return tag;
	}

	public ModelBase getModel() {	
		return this.model;
	}

	public void setModelNum(int i) {
		this.modelNum = i;
		this.setModelWithNum();
		this.markDirty();
	}

	private void setModel(ModelBase m) {
		this.model = m;
	}

	public void setModelWithNum() {
		if(this.modelNum == 0) {
			this.setModel(new ModelTrilliumMulti());
		} else if(this.modelNum == 1) {
			this.setModel(new ModelTrillium());
		} else {
			this.setModel(new ModelTrilliumMulti2());
		}
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


}
