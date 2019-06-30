package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIWanderWaterEntity;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.init.SoundEvents;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityNautilus extends EntityWaterMob {

    public EntityNautilus(World world) {
        super(world);
        this.setSize(0.75F, 0.85F);
    }
    
    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(0, new EntityAIWanderWaterEntity(this, 0.15D));
    }
    
    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.25D);
    }

    @Override
    protected PathNavigate createNavigator(World worldIn) {
        return new PathNavigateSwimmer(this, worldIn);
    }

    public void travel(float strafe, float vertical, float forward) {
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.inWater) {
            this.motionX *= 0.2F;
            this.motionZ *= 0.2F;
            if (!this.hasNoGravity()) {
                this.motionY -= 0.08D;
            }

            this.motionY *= 0.9800000190734863D;
        } else if(!world.isRemote) {
            if(!this.navigator.noPath()) {
                Vec3d target = this.navigator.getPath().getCurrentPos();
                this.motionX = (target.x - this.posX) * 0.05F;
                this.motionY = (target.y - this.posY) * 0.05F;
                this.motionZ = (target.z - this.posZ) * 0.05F;
            } else if(this.getMoveHelper().isUpdating()) {
                this.motionX = (this.getMoveHelper().getX() - this.posX) * 0.05F;
                this.motionZ = (this.getMoveHelper().getZ() - this.posZ) * 0.05F;
                this.motionY = (this.getMoveHelper().getY() - this.posY) * 0.05F;
            } else {
                this.motionX *= 0.8F;
                this.motionZ *= 0.8F;
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
    
    protected boolean canTriggerWalking() {
        return false;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.NAUTILUS;
    }

}
