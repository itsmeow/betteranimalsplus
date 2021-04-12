package its_meow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import its_meow.betteranimalsplus.common.entity.ai.WaterMoveHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class EntityWaterMobPathing extends WaterMobEntity implements IContainerEntity<EntityWaterMobPathing> {

    public EntityWaterMobPathing(EntityType<? extends WaterMobEntity> type, World world) {
        super(type, world);
        this.moveController = new WaterMoveHelper(this);
    }

    @Override
    protected PathNavigator createNavigator(World worldIn) {
        return new SwimmerPathNavigator(this, worldIn);
    }

    @Override
    public void travel(Vec3d p_213352_1_) {
        if(this.isServerWorld() && this.isInWater()) {
            this.moveRelative(0.01F * (float) this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue(), p_213352_1_);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().scale(0.9D));
            if(this.getAttackTarget() == null) {
                this.setMotion(this.getMotion().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_213352_1_);
        }
    }

    @Override
    public boolean canDespawn(double range) {
        return despawn(range);
    }

    @Override
    public EntityWaterMobPathing getImplementation() {
        return this;
    }

}
