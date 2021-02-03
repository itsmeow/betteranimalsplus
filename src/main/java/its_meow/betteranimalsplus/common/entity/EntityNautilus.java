package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobBucketable;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.World;

public class EntityNautilus extends EntityWaterMobBucketable {

    public EntityNautilus(World world) {
        super(ModEntities.NAUTILUS.entityType, world);
    }
    
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 0.15D));
    }

    @Override
    protected PathNavigator createNavigator(World worldIn) {
        return new SwimmerPathNavigator(this, worldIn);
    }

    @Override
    public void travel(Vector3d vec) {
        this.move(MoverType.SELF, this.getMotion());
    }

    @Override
    public void tick() {
        super.tick();
        if(!this.inWater) {
            this.setMotion(this.getMotion().getX() * 0.2F, this.getMotion().getY(), this.getMotion().getZ() * 0.2F);
            if (!this.hasNoGravity()) {
                this.setMotion(this.getMotion().getX(), this.getMotion().getY() - 0.08D, this.getMotion().getZ());
            }
            this.setMotion(this.getMotion().getX(), this.getMotion().getY() * 0.9800000190734863D, this.getMotion().getZ());
        } else if(!world.isRemote) {
            if(!this.navigator.noPath()) {
                Vector3i target = this.navigator.getPath().func_242948_g();
                this.setMotion((target.getX() - this.getPosX()) * 0.05F, (target.getY() - this.getPosY()) * 0.05F, (target.getZ() - this.getPosZ()) * 0.05F);
            } else if(this.getMoveHelper().isUpdating()) {
                this.setMotion((this.getMoveHelper().getX() - this.getPosX()) * 0.05F, (this.getMoveHelper().getY() - this.getPosY()) * 0.05F, (this.getMoveHelper().getZ() - this.getPosZ()) * 0.05F);
            } else {
                this.setMotion(this.getMotion().getX() * 0.85F, this.getMotion().getY() * 0.85F, this.getMotion().getZ() * 0.85F);
            }
        }
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_SQUID_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_SQUID_DEATH;
    }
    
    @Override
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.NAUTILUS;
    }

    @Override
    public EntityWaterMobBucketable getImplementation() {
        return this;
    }

    @Override
    public EntityTypeContainer<?> getContainer() {
        return ModEntities.NAUTILUS;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.NAUTILUS;
    }

}
