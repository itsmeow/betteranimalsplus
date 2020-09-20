package its_meow.betteranimalsplus.common.entity.util.abstracts;

import its_meow.betteranimalsplus.common.entity.util.IBucketable;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public abstract class EntityWaterMobWithTypesBucketable extends EntityWaterMobWithTypes implements IBucketable {

    public EntityWaterMobWithTypesBucketable(EntityType<? extends EntityWaterMobWithTypesBucketable> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.registerFromContainerKey();
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.writeFromContainerToEntity(compound);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.readFromContainerToEntity(compound);
    }

    @Override
    public boolean canDespawn(double distanceToClosestPlayer) {
        return !this.isFromContainer() && despawn(distanceToClosestPlayer);
    }

    @Override
    public boolean preventDespawn() {
        return this.isFromContainer();
    }

    @Override
    public void setContainerData(ItemStack bucket) {
        IBucketable.super.setContainerData(bucket);
        CompoundNBT tag = bucket.getTag();
        if(bucket.getTag() == null) {
            tag = new CompoundNBT();
        }
        tag.putString("BucketVariantTag", this.getVariantNameOrEmpty());
        bucket.setTag(tag);
    }

    @Override
    protected boolean processInteract(PlayerEntity player, Hand hand) {
        if(this.processContainerInteract(player, hand)) {
            return true;
        }
        return super.processInteract(player, hand);
    }

    @Override
    public void readFromContainerTag(CompoundNBT tag) {
        if(tag.contains("BucketVariantTag")) {
            this.setType(tag.getString("BucketVariantTag"));
        }
    }

}
