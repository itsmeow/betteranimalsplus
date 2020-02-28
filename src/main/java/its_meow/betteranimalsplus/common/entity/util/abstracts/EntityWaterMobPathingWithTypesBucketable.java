package its_meow.betteranimalsplus.common.entity.util.abstracts;

import its_meow.betteranimalsplus.common.entity.util.IBucketable;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public abstract class EntityWaterMobPathingWithTypesBucketable extends EntityWaterMobPathingWithTypes implements IBucketable {

    private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.createKey(EntityWaterMobPathingWithTypesBucketable.class, DataSerializers.BOOLEAN);

    public EntityWaterMobPathingWithTypesBucketable(EntityType<? extends EntityWaterMobPathingWithTypesBucketable> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(FROM_BUCKET, false);
    }

    @Override
    public boolean isFromBucket() {
        return this.dataManager.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean fromBucket) {
        this.dataManager.set(FROM_BUCKET, fromBucket);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("FromBucket", this.isFromBucket());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setFromBucket(compound.getBoolean("FromBucket"));
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return !this.isFromBucket() && super.canDespawn(distanceToClosestPlayer);
    }

    @Override
    public boolean preventDespawn() {
        return this.isFromBucket();
    }

    @Override
    public void setBucketData(ItemStack bucket) {
        if(this.hasCustomName()) {
            bucket.setDisplayName(this.getCustomName());
        }
        CompoundNBT tag = bucket.getTag();
        tag.putString("BucketVariantTag", this.getVariantName());
    }

    protected abstract SoundEvent getFlopSound();

    @Override
    protected SoundEvent getSwimSound() {
        return SoundEvents.ENTITY_FISH_SWIM;
    }

    @Override
    public void livingTick() {
        if(!this.isInWater() && this.onGround && this.collidedVertically) {
            this.setMotion(this.getMotion().add((double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.05F), (double) 0.4F, (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.05F)));
            this.onGround = false;
            this.isAirBorne = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getSoundPitch());
        }

        super.livingTick();
    }

    @Override
    protected boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if(itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) {
            this.playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0F, 1.0F);
            itemstack.shrink(1);
            ItemStack itemstack1 = this.getBucket();
            this.setBucketData(itemstack1);
            if(!this.world.isRemote) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) player, itemstack1);
            }
            if(itemstack.isEmpty()) {
                player.setHeldItem(hand, itemstack1);
            } else if(!player.inventory.addItemStackToInventory(itemstack1)) {
                player.dropItem(itemstack1, false);
            }
            this.remove();
            return true;
        } else {
            return super.processInteract(player, hand);
        }
    }

}
