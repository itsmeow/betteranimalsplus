package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.util.EntityTypeContainer;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class EntityBasicWaterCreature extends WaterMobEntity {

    public EntityBasicWaterCreature(EntityType<? extends WaterMobEntity> type, World world) {
        super(type, world);
    }
    
    @Override
    protected PathNavigator createNavigator(World worldIn) {
        return new SwimmerPathNavigator(this, worldIn);
    }

    @Override
    public void travel(Vec3d vec) {
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
                Vec3d target = this.navigator.getPath().getCurrentPos();
                this.setMotion((target.x - this.posX) * 0.05F, (target.y - this.posY) * 0.05F, (target.z - this.posZ) * 0.05F);
            } else if(this.getMoveHelper().isUpdating()) {
                this.setMotion((this.getMoveHelper().getX() - this.posX) * 0.05F, (this.getMoveHelper().getY() - this.posY) * 0.05F, (this.getMoveHelper().getZ() - this.posZ) * 0.05F);
            } else {
                this.setMotion(this.getMotion().getX() * 0.85F, this.getMotion().getY() * 0.85F, this.getMotion().getZ() * 0.85F);
            }
        }
    }

    protected abstract EntityTypeContainer<? extends EntityBasicWaterCreature> getContainer();

    @Override
    public boolean canDespawn(double range) {
        return getContainer().despawn;
    }

}
