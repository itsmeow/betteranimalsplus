package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import dev.itsmeow.betteranimalsplus.common.entity.ai.WaterMoveHelper;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.pathfinding.SwimmerPathNavigator;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public abstract class EntityWaterMobPathing extends WaterMobEntity implements IContainerEntity<EntityWaterMobPathing> {

    public EntityWaterMobPathing(EntityType<? extends WaterMobEntity> type, World world) {
        super(type, world);
        this.moveControl = new WaterMoveHelper(this);
    }

    @Override
    protected PathNavigator createNavigation(World worldIn) {
        return new SwimmerPathNavigator(this, worldIn);
    }

    @Override
    public void travel(Vector3d p_213352_1_) {
        if(this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.01F * (float) this.getAttribute(Attributes.MOVEMENT_SPEED).getValue(), p_213352_1_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.9D));
            if(this.getTarget() == null) {
                this.setDeltaMovement(this.getDeltaMovement().add(0.0D, -0.005D, 0.0D));
            }
        } else {
            super.travel(p_213352_1_);
        }
    }

    @Override
    public boolean removeWhenFarAway(double range) {
        return despawn(range);
    }

    @Override
    public EntityWaterMobPathing getImplementation() {
        return this;
    }

}
