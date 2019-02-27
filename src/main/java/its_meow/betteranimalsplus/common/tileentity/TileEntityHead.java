package its_meow.betteranimalsplus.common.tileentity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

import its_meow.betteranimalsplus.init.BlockRegistry;
import net.minecraft.block.BlockSkull;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TileEntityHead extends TileEntity {

	private Class<? extends ModelBase> modelT = null;
	private ModelBase model = null;
	protected int typeNum = 0;
	private boolean useFunc = false;
	private Method textureFunction;
	private float offset;
	private float rotation;

	public HashMap<Integer, ResourceLocation> textures;

	public TileEntityHead(Class<? extends ModelBase> modelType, Class<? extends TileEntityHead> type, float yOffset,
			ResourceLocation... textureList) {
		super(BlockRegistry.getTileEntityType(type));
		this.modelT = modelType;
		this.textures = new HashMap<>();
		int i = 1;
		for(ResourceLocation texture : textureList) {
			this.textures.put(i, texture);
			i++;
		}
		if(!this.getTileData().hasKey("TYPENUM")) {
			this.setType(new Random().nextInt(this.textures.size()) + 1);
			this.markDirty();
		}
		this.offset = yOffset;
	}

	public ModelBase getModel() {
		if(this.model == null) {
			try {
				this.model = this.modelT.newInstance();
			} catch(InstantiationException e) {
				e.printStackTrace();
			} catch(IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return this.model;
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public AxisAlignedBB getRenderBoundingBox() {
		return new AxisAlignedBB(this.getPos().add(-1, -1, -1), this.getPos().add(2, 2, 2));
	}

	public ResourceLocation getTexture() {
		if(this.useFunc) {
			try {
				return (ResourceLocation) this.textureFunction.invoke(this.typeNum);
			} catch(IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
				e.printStackTrace();
			}
		} else {
			return this.textures.get(this.typeNum);
		}
		return null;
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
		if(compound.hasKey("TYPENUM")) {
			this.typeNum = compound.getInt("TYPENUM");
		} else {
			this.setType(new Random().nextInt(this.textures.size()) + 1);
		}
	}

	@Override
	public NBTTagCompound write(NBTTagCompound compound) {
		super.write(compound);
		compound.setInt("TYPENUM", this.typeNum);
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

	@Override
	public void handleUpdateTag(NBTTagCompound tag) {
		this.read(tag);
	}

	public float getOffset() {
		return this.offset;
	}

	public void setRotation(float rotation) {
		this.rotation = rotation;
	}

	public float getSkullRotation() {
		return this.rotation;
	}

	public float getRotationX() {
		return this.getBlockState().get(BlockSkull.ROTATION);
	}

	public EnumFacing getBlockFacing() {
		return EnumFacing.NORTH;
		// return this.getBlockState().get(BlockSkull.ROTATION);
	}

}
