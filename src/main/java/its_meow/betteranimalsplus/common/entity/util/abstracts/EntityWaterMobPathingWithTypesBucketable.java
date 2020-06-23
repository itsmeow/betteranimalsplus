package its_meow.betteranimalsplus.common.entity.util.abstracts;

import its_meow.betteranimalsplus.common.entity.util.IBucketable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public abstract class EntityWaterMobPathingWithTypesBucketable extends EntityWaterMobPathingWithTypes implements IBucketable {

    public EntityWaterMobPathingWithTypesBucketable(EntityType<? extends EntityWaterMobPathingWithTypesBucketable> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.registerFromBucketKey();
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.writeFromBucketToEntity(compound);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.readFromBucketToEntity(compound);
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return !this.isFromBucket() && despawn(distanceToClosestPlayer);
    }

    @Override
    public boolean preventDespawn() {
        return this.isFromBucket();
    }

    @Override
    public void setBucketData(ItemStack bucket) {
        IBucketable.super.setBucketData(bucket);
        CompoundNBT tag = bucket.getTag();
        if(bucket.getTag() == null) {
            tag = new CompoundNBT();
        }
        tag.putString("BucketVariantTag", this.getVariantNameOrEmpty());
        bucket.setTag(tag);
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
        if(this.processBucketInteract(player, hand)) {
            return true;
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void readFromBucketTag(CompoundNBT tag) {
        if(tag.contains("BucketVariantTag")) {
            this.setType(tag.getString("BucketVariantTag"));
        }
    }

}
