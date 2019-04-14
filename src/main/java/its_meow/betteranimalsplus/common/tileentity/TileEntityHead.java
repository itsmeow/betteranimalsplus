package its_meow.betteranimalsplus.common.tileentity;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Random;

import net.minecraft.client.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityHead extends TileEntitySkull {

    private Class<? extends ModelBase> modelT = null;
    private ModelBase model = null;
    protected int typeNum = 0;
    private boolean useFunc = false;
    private Method textureFunction;
    private float offset;

    public HashMap<Integer, ResourceLocation> textures;

    public TileEntityHead(Class<? extends ModelBase> modelType, float yOffset, ResourceLocation... textureList) {
        this.modelT = modelType;
        this.textures = new HashMap<Integer, ResourceLocation>();
        int i = 1;
        for (ResourceLocation texture : textureList) {
            this.textures.put(i, texture);
            i++;
        }
        if (!this.getTileData().hasKey("TYPENUM")) {
            this.setType(new Random().nextInt(this.textures.size()) + 1);
            this.markDirty();
        }
        this.offset = yOffset;
    }

    public ModelBase getModel() {
        if (this.model == null) {
            try {
                this.model = this.modelT.newInstance();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return this.model;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(this.getPos().add(-1, -1, -1), this.getPos().add(2, 2, 2));
    }

    public ResourceLocation getTexture() {
        if (this.useFunc) {
            try {
                return (ResourceLocation) this.textureFunction.invoke(this.typeNum);
            } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                e.printStackTrace();
            }
        } else {
            return this.textures.get(this.typeNum);
        }
        return null;
    }

    @Override
    public void setType(int i) {
        this.typeNum = i;
        this.markDirty();
    }

    public int typeValue() {
    	if(typeNum <= 0) {
    		this.typeNum = 1;
    	}
        return this.typeNum;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey("TYPENUM")) {
            this.typeNum = compound.getInteger("TYPENUM");
        } else {
            this.setType(new Random().nextInt(this.textures.size()) + 1);
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger("TYPENUM", this.typeNum);
        return compound;
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        NBTTagCompound tag = new NBTTagCompound();
        this.writeToNBT(tag);
        return new SPacketUpdateTileEntity(this.pos, 1, tag);
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
        this.world.scheduleUpdate(this.pos, this.blockType, 100);
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

    public float getOffset() {
        return this.offset;
    }

}
