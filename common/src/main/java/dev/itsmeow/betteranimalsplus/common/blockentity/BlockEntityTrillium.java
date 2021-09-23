package dev.itsmeow.betteranimalsplus.common.blockentity;


import dev.itsmeow.betteranimalsplus.init.ModBlockEntities;
import dev.itsmeow.betteranimalsplus.init.ModBlocks;
import dev.itsmeow.betteranimalsplus.init.ModResources;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class BlockEntityTrillium extends BlockEntity {

    private final String keyType = "trilliumType";
    private final String keyModel = "trilliumModel";
    private int typeNum;
    private int modelNum;

    public BlockEntityTrillium() {
        super(ModBlockEntities.TRILLIUM_TYPE.get());
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
    public void load(BlockState state, CompoundTag compound) {
        super.load(state, compound);
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
    public CompoundTag save(CompoundTag compound) {
        super.save(compound);
        compound.putInt(this.keyType, this.typeNum);
        compound.putInt(this.keyModel, this.modelNum);
        return compound;
    }

    @Override
    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        CompoundTag tag = new CompoundTag();
        this.save(tag);
        return new ClientboundBlockEntityDataPacket(this.worldPosition, 1, tag);
    }

    @Override
    public CompoundTag getUpdateTag() {
        CompoundTag tag = new CompoundTag();
        this.save(tag);
        return tag;
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

}
