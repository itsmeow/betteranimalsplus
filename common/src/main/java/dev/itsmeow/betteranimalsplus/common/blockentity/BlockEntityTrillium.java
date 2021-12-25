package dev.itsmeow.betteranimalsplus.common.blockentity;


import dev.itsmeow.betteranimalsplus.init.ModBlockEntities;
import dev.itsmeow.betteranimalsplus.init.ModBlocks;
import dev.itsmeow.betteranimalsplus.init.ModResources;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class BlockEntityTrillium extends BlockEntity {

    private final String keyType = "trilliumType";
    private final String keyModel = "trilliumModel";
    private int typeNum;
    private int modelNum;

    public BlockEntityTrillium(BlockPos pos, BlockState state) {
        super(ModBlockEntities.TRILLIUM_TYPE.get(), pos, state);
        this.setType(new Random().nextInt(5));
        this.setModelNum(new Random().nextInt(3));
    }

    public ResourceLocation getTexture() {
        return this.typeNum == 0 ? ModResources.trillium_yellow : ModResources.trillium_purple;
    }

    public void setType(int i) {
        this.typeNum = i;
        this.setChanged();
    }

    public int typeValue() {
        return this.typeNum;
    }

    @Override
    public void load(CompoundTag compound) {
        super.load(compound);
        if (compound.contains(this.keyType)) {
            this.typeNum = compound.getInt(this.keyType);
        } else {
            this.setType(new Random().nextInt(5)); // 1/5 chance
        }
        if (compound.contains(this.keyModel)) {
            this.modelNum = compound.getInt(this.keyModel);
        } else {
            this.setModelNum(new Random().nextInt(3));
        }
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        super.saveAdditional(compoundTag);
        compoundTag.putInt(this.keyType, this.typeNum);
        compoundTag.putInt(this.keyModel, this.modelNum);
    }

    @Environment(EnvType.CLIENT)
    public float getRotation() {
        BlockState state = this.level.getBlockState(this.worldPosition);
        if (state.getBlock() == ModBlocks.TRILLIUM.get()) {
            Direction facing = state.getValue(HorizontalDirectionalBlock.FACING).getOpposite();
            if (facing == Direction.NORTH) {
                return 0F;
            }
            if (facing == Direction.EAST) {
                return 90F;
            }
            if (facing == Direction.SOUTH) {
                return 180F;
            }
            if (facing == Direction.WEST) {
                return 270F;
            }
        }
        return 0F;
    }

    public int getModelNum() {
        return this.modelNum;
    }

    public void setModelNum(int i) {
        this.modelNum = i;
        this.setChanged();
    }

    @Override
    public void setChanged() {
        super.setChanged();
        this.sync();
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag nbt = super.getUpdateTag();
        saveAdditional(nbt);
        return nbt;
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public void sync() {
        if (level != null && !level.isClientSide()) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), Block.UPDATE_CLIENTS);
        }
    }
}
