package its_meow.betteranimalsplus.common.tileentity;

import java.util.Random;

import its_meow.betteranimalsplus.client.model.ModelWolfHead;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityWolfHead extends TileEntitySkull {
	
	private int typeNum = 0;
	private final String keyType = "wolfHeadType";
	
	private Class<? extends ModelBase> modelT = null;
	private ModelBase model = null;
	
	public ResourceLocation texture;
	
	public TileEntityWolfHead() {
		modelT = ModelWolfHead.class.asSubclass(ModelBase.class);
		if(!this.getTileData().hasKey(keyType)) {
			this.setType(new Random().nextInt(4) + 1);
		}
		this.texture = getWolfTexture(typeValue());
	}
	
	
	public ModelBase getModel() {
		if(model == null) {
			try {
				model = modelT.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return model;
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos().add(-1, -1, -1), getPos().add(2, 2, 2));
	}
	
	private ResourceLocation getWolfTexture(int typeNumber) {
		ResourceLocation result = null;
		switch(typeNumber) {
		case 1:
			result = TextureRegistry.wolf_black;
			break;
		case 2:
			result = TextureRegistry.wolf_snowy;
			break;
		case 3:
			result = TextureRegistry.wolf_timber;
			break;
		case 4:
			result = TextureRegistry.coyote_hostile;
			break;
		default:
			result = TextureRegistry.wolf_timber;
			break;
		}
		return result;
	}
	
	public void setType(int i) {
		this.typeNum = i;
		this.markDirty();
	}
	
	public int typeValue() {
		return typeNum;
	}
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		if(compound.hasKey(keyType)) {
			this.typeNum = compound.getInteger(keyType);
		} else {
			this.setType(new Random().nextInt(4) + 1);
		}
	}

	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setInteger(keyType, this.typeNum);
		return compound;
	}

	@Override
	public SPacketUpdateTileEntity getUpdatePacket() {
		NBTTagCompound tag = new NBTTagCompound();
		this.writeToNBT(tag);
		return new SPacketUpdateTileEntity(pos, 1, tag);
	}

	@Override
	public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
		readFromNBT(packet.getNbtCompound());
		world.scheduleUpdate(this.pos, this.blockType, 100);
	}
	
	@Override
	public NBTTagCompound getUpdateTag() {
		NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return tag;
	}
	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.readFromNBT(tag);
	}

}
