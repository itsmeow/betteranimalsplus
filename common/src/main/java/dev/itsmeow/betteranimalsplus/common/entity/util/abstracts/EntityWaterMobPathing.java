package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.imdlib.entity.interfaces.IContainerEntity;
import dev.itsmeow.betteranimalsplus.common.entity.ai.WaterMoveHelper;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

public abstract class EntityWaterMobPathing extends WaterAnimal implements IContainerEntity<EntityWaterMobPathing> {

    public EntityWaterMobPathing(EntityType<? extends WaterAnimal> type, Level world) {
        super(type, world);
        this.moveControl = new WaterMoveHelper(this);
    }

    @Override
    protected PathNavigation createNavigation(Level worldIn) {
        return new WaterBoundPathNavigation(this, worldIn);
    }

    @Override
    public void travel(Vec3 p_213352_1_) {
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
