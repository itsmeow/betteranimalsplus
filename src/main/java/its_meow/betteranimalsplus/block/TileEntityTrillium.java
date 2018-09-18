package its_meow.betteranimalsplus.block;

import java.util.Random;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.registry.TextureRegistry;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;

public class TileEntityTrillium extends TileEntity {

	//private boolean typeBool = false;

	private ResourceLocation texture = TextureRegistry.trillium;

	public TileEntityTrillium() {
		/*if(this.getTileData().hasKey("TypeBool")) {
			typeBool = this.getTileData().getBoolean("TypeBool");
		} else {
			typeBool = (new Random()).nextBoolean();
			this.markDirty();
		}*/
	}
	/*
	public void setType(boolean b) {
		typeBool = b;
		this.markDirty();
	}*/

	public ResourceLocation getTexture() {
		return texture;
		//return typeBool ? TextureRegistry.trillium : TextureRegistry.trillium2;
	}
	/*
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.setType(compound.getBoolean("TypeBool"));
	}



	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		compound.setBoolean("TypeBool", this.typeBool);
		return super.writeToNBT(compound);
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
	}*/





}
