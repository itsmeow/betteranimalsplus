package its_meow.betteranimalsplus.common.tileentity;

import java.util.HashMap;
import java.util.Random;
import java.util.function.Function;

import its_meow.betteranimalsplus.init.ModTileEntities;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.client.renderer.entity.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TileEntityHead extends TileEntity {

    private Class<? extends ModelBase> modelT = null;
    protected int typeNum = 0;
    private float offset;
    private float rotation = 0;
    private boolean shouldDrop = true;
    private Function<Integer, ResourceLocation> textureFunc;
    public HeadTypes type;

    public HashMap<Integer, ResourceLocation> textures;
    
    public TileEntityHead() {
    	super(ModTileEntities.HEAD_TYPE);
    }
    
    public TileEntityHead(HeadTypes type, float yOffset, ResourceLocation... textureList) {
        this(type, yOffset, null, textureList);
    }

    public TileEntityHead(HeadTypes type, float yOffset, Function<Integer, ResourceLocation> textureFunc,
            ResourceLocation... textureList) {
        super(ModTileEntities.HEAD_TYPE);
        this.type = type;
        this.modelT = type.getModelSupplier().get().get();
        this.textures = new HashMap<>();
        int i = 1;
        for (ResourceLocation texture : textureList) {
            this.textures.put(i, texture);
            i++;
        }
        if (!this.getTileData().contains("TYPENUM")) {
            this.setType(new Random().nextInt(type.textureCount) + 1);
            this.markDirty();
        }
        this.offset = yOffset;
        this.textureFunc = textureFunc;
    }

    public ModelBase getModel() {
        try {
            return this.modelT.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        return new AxisAlignedBB(this.getPos().add(-1, -1, -1), this.getPos().add(2, 2, 2));
    }

    public ResourceLocation getTexture() {
        if (textureFunc == null) {
            return this.textures.get(this.typeNum);
        } else {
            ResourceLocation rl = textureFunc.apply(this.typeNum);
            if (rl == null || rl.toString().equals("")) {
                rl = this.textures.get(this.typeNum);
            }
            return rl;
        }
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
        if (compound.contains("TYPENUM")) {
            this.typeNum = compound.getInt("TYPENUM");
        } else {
            this.setType(new Random().nextInt(this.textures.size()) + 1);
        }

        if (compound.contains("rotation")) {
            this.rotation = compound.getFloat("rotation");
        }
        if (compound.contains("GENERIC_TYPE")) {
			this.type = HeadTypes.valueOf(compound.getString("GENERIC_TYPE"));

			// Create with proper constructor for type
			TileEntityHead te2 = type.teFactory.apply(type);
			// Copy from TE
			this.modelT = te2.modelT;
			this.textures = te2.textures;
			this.offset = te2.offset;
			this.textureFunc = te2.textureFunc;
        }
    }

    @Override
    public NBTTagCompound write(NBTTagCompound compound) {
        super.write(compound);
        compound.putInt("TYPENUM", this.typeNum);
        compound.putFloat("rotation", rotation);
        compound.putString("GENERIC_TYPE", type.name());
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
        this.markDirty();
    }

    public float getSkullRotation() {
        return this.rotation;
    }

    public static void disableDrop(IBlockReader world, BlockPos pos) {
        TileEntity te = world.getTileEntity(pos);
        if ((te instanceof TileEntityHead)) {
            ((TileEntityHead) te).shouldDrop = false;
        }
    }

    public boolean shouldDrop() {
        return shouldDrop;
    }

}
