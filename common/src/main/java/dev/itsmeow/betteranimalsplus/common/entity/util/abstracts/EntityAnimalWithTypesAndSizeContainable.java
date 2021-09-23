package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.interfaces.IContainable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class EntityAnimalWithTypesAndSizeContainable extends EntityAnimalWithTypesAndSize implements IContainable {

    public EntityAnimalWithTypesAndSizeContainable(EntityType<? extends EntityAnimalWithTypesAndSizeContainable> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.registerFromContainerKey();
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
        super.addAdditionalSaveData(compound);
        this.writeFromContainerToEntity(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.readFromContainerToEntity(compound);
    }

    @Override
    public boolean removeWhenFarAway(double distanceToClosestPlayer) {
        return !this.isFromContainer() && despawn(distanceToClosestPlayer);
    }

    @Override
    public boolean requiresCustomPersistence() {
        return this.isFromContainer();
    }

    @Override
    public void setContainerData(ItemStack bucket) {
        IContainable.super.setContainerData(bucket);
        CompoundNBT tag = bucket.getTag();
        if(bucket.getTag() == null) {
            tag = new CompoundNBT();
        }
        tag.putString("BucketVariantTag", this.getVariantNameOrEmpty());
        bucket.setTag(tag);
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        if(this.processContainerInteract(player, hand)) {
            return ActionResultType.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    @Override
    public void readFromContainerTag(CompoundNBT tag) {
        if(tag.contains("BucketVariantTag")) {
            this.setType(tag.getString("BucketVariantTag"));
        }
    }

}
