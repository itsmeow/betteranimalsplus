package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.interfaces.IBucketable;
import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;

public abstract class EntityWaterMobBucketable extends WaterAnimal implements IBucketable, IContainerEntity<EntityWaterMobBucketable> {

    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(EntityWaterMobBucketable.class, EntityDataSerializers.BOOLEAN);

    public EntityWaterMobBucketable(EntityType<? extends EntityWaterMobBucketable> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(FROM_BUCKET, false);
    }

    @Override
    public boolean isFromContainer() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromContainer(boolean fromBucket) {
        this.entityData.set(FROM_BUCKET, fromBucket);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("FromBucket", this.isFromContainer());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.setFromContainer(compound.getBoolean("FromBucket"));
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
        if(this.hasCustomName()) {
            bucket.setHoverName(this.getCustomName());
        }
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);
        if(itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) {
            this.playSound(SoundEvents.BUCKET_FILL_FISH, 1.0F, 1.0F);
            itemstack.shrink(1);
            ItemStack itemstack1 = this.getContainerItem();
            this.setContainerData(itemstack1);
            if(!this.level.isClientSide) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayer) player, itemstack1);
            }
            if(itemstack.isEmpty()) {
                player.setItemInHand(hand, itemstack1);
            } else if(!player.getInventory().add(itemstack1)) {
                player.drop(itemstack1, false);
            }
            this.discard();
            return InteractionResult.SUCCESS;
        } else {
            return super.mobInteract(player, hand);
        }
    }

}
