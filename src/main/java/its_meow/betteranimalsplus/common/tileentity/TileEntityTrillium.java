package its_meow.betteranimalsplus.common.tileentity;

import java.util.Random;

import its_meow.betteranimalsplus.client.model.ModelTrillium;
import its_meow.betteranimalsplus.client.model.ModelTrilliumMulti;
import its_meow.betteranimalsplus.client.model.ModelTrilliumMulti2;
import its_meow.betteranimalsplus.init.ModBlocks;
import its_meow.betteranimalsplus.init.ModTextures;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.model.ModelBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityTrillium extends TileEntity {

    private int typeNum;
    private final String keyType = "trilliumType";

    private ModelBase model;

    private int modelNum;
    private final String keyModel = "trilliumModel";

    public TileEntityTrillium() {
        if (!this.getTileData().hasKey(this.keyType)) {
            this.setType(new Random().nextInt(5));
        }
        if (!this.getTileData().hasKey(this.keyModel)) {
            this.modelNum = new Random().nextInt(3);
            this.markDirty();
            this.setModelWithNum();
        }
    }

    public ResourceLocation getTexture() {
        return this.typeNum == 0 ? ModTextures.trillium_purple : ModTextures.trillium_yellow;
    }

    public void setType(int i) {
        this.typeNum = i;
        this.markDirty();
    }

    public int typeValue() {
        return this.typeNum;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        if (compound.hasKey(this.keyType)) {
            this.typeNum = compound.getInteger(this.keyType);
        } else {
            this.setType(new Random().nextInt(5)); // 1/5 chance
        }
        if (compound.hasKey(this.keyModel)) {
            this.modelNum = compound.getInteger(this.keyModel);
            this.setModelWithNum();
        } else {
            this.setModelNum(new Random().nextInt(3));
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        super.writeToNBT(compound);
        compound.setInteger(this.keyType, this.typeNum);
        compound.setInteger(this.keyModel, this.modelNum);
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
        if (this.modelNum == 0) {
            this.setModel(new ModelTrilliumMulti());
        } else if (this.modelNum == 1) {
            this.setModel(new ModelTrillium());
        } else {
            this.setModel(new ModelTrilliumMulti2());
        }
    }

    @Override
    public void handleUpdateTag(NBTTagCompound tag) {
        this.readFromNBT(tag);
    }

    @SideOnly(Side.CLIENT)
    public float getRotation() {
        IBlockState state = this.world.getBlockState(this.pos);
        if (state.getBlock() == ModBlocks.trillium) {
            EnumFacing facing = state.getValue(BlockHorizontal.FACING).getOpposite();
            if (facing == EnumFacing.NORTH) {
                return 0F;
            }
            if (facing == EnumFacing.EAST) {
                return 90F;
            }
            if (facing == EnumFacing.SOUTH) {
                return 180F;
            }
            if (facing == EnumFacing.WEST) {
                return 270F;
            }
        }
        return 0F;
    }

    public int getModelNum() {
        return this.modelNum;
    }

}
