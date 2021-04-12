package its_meow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.interfaces.IBucketable;
import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

public abstract class EntityWaterMobBucketable extends WaterMobEntity implements IBucketable, IContainerEntity<EntityWaterMobBucketable> {

    private static final DataParameter<Boolean> FROM_BUCKET = EntityDataManager.createKey(EntityWaterMobBucketable.class, DataSerializers.BOOLEAN);

    public EntityWaterMobBucketable(EntityType<? extends EntityWaterMobBucketable> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.dataManager.register(FROM_BUCKET, false);
    }

    @Override
    public boolean isFromContainer() {
        return this.dataManager.get(FROM_BUCKET);
    }

    @Override
    public void setFromContainer(boolean fromBucket) {
        this.dataManager.set(FROM_BUCKET, fromBucket);
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putBoolean("FromBucket", this.isFromContainer());
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setFromContainer(compound.getBoolean("FromBucket"));
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
        if(this.hasCustomName()) {
            bucket.setDisplayName(this.getCustomName());
        }
    }

    @Override
    protected ActionResultType getEntityInteractionResult(PlayerEntity player, Hand hand) {
        ItemStack itemstack = player.getHeldItem(hand);
        if(itemstack.getItem() == Items.WATER_BUCKET && this.isAlive()) {
            this.playSound(SoundEvents.ITEM_BUCKET_FILL_FISH, 1.0F, 1.0F);
            itemstack.shrink(1);
            ItemStack itemstack1 = this.getContainerItem();
            this.setContainerData(itemstack1);
            if(!this.world.isRemote) {
                CriteriaTriggers.FILLED_BUCKET.trigger((ServerPlayerEntity) player, itemstack1);
            }
            if(itemstack.isEmpty()) {
                player.setHeldItem(hand, itemstack1);
            } else if(!player.inventory.addItemStackToInventory(itemstack1)) {
                player.dropItem(itemstack1, false);
            }
            this.remove();
            return ActionResultType.SUCCESS;
        } else {
            return super.getEntityInteractionResult(player, hand);
        }
    }

}
