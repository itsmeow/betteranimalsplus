package its_meow.betteranimalsplus.block;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityHandOfFate extends TileEntity {
	
	private boolean onFire = false;
	
	
	public TileEntityHandOfFate() {
	}
	
	
	public void setOnFire(boolean b) {
		this.onFire = b;
		this.markDirty();
	}
	
	public boolean isOnFire() {
		return onFire;
	}
	
	
	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);
		this.onFire = compound.getBoolean("OnFire");
	}



	@Override
	public NBTTagCompound writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);
		compound.setBoolean("OnFire", this.onFire);
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
	@SideOnly(Side.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(getPos().add(-2, -4, -2), getPos().add(2, 4, 2));
	}
	
}
