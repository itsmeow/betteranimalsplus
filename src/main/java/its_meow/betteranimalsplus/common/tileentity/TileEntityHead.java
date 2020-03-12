package its_meow.betteranimalsplus.common.tileentity;

import its_meow.betteranimalsplus.common.block.BlockAnimalSkull;
import its_meow.betteranimalsplus.common.entity.util.IVariant;
import its_meow.betteranimalsplus.init.ModTileEntities;
import its_meow.betteranimalsplus.util.HeadType;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class TileEntityHead extends TileEntity {
    
    private HeadType cachedType = null;
    private IVariant cachedVariant = null;

    public TileEntityHead() {
        super(ModTileEntities.HEAD_TYPE);
    }

    public TileEntityHead(HeadType type) {
        super(ModTileEntities.HEAD_TYPE);
    }

    @OnlyIn(Dist.CLIENT)
    public EntityModel<? extends Entity> getNewModel() {
        return this.getHeadType().getModelSupplier().get().get();
    }

    private Block getBlock() {
        return this.getBlockState().getBlock();
    }

    public HeadType getHeadType() {
        if(cachedType == null) {
            cachedType = HeadType.valueOf(this.getBlock());
        }
        return cachedType;
    }

    public ResourceLocation getTexture() {
        return this.getHeadVariant().getTexture();
    }

    public IVariant getHeadVariant() {
        if(cachedVariant == null) {
            cachedVariant = this.getHeadType().getVariant(this.getBlock());
        }
        return cachedVariant;
    }

    public float getOffset() {
        return this.getHeadType().getYOffset();
    }

    public Direction getDirection() {
        return this.getBlockState().get(BlockAnimalSkull.FACING_EXCEPT_DOWN);
    }

    public Direction getTopDirection() {
        return this.getBlockState().get(BlockAnimalSkull.TOP_FACING);
    }

    public float getTopRotation() {
        return this.getTopDirection().getHorizontalAngle();
    }

}
