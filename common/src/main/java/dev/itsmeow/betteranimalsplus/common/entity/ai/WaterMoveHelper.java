package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;

public class WaterMoveHelper extends MoveControl {
    private final WaterAnimal entity;

    public WaterMoveHelper(WaterAnimal entity) {
        super(entity);
        this.entity = entity;
    }

    @Override
    public void tick() {
        if(this.entity.isEyeInFluid(FluidTags.WATER)) {
            this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
        }

        if(this.operation == Operation.MOVE_TO && !this.entity.getNavigation().isDone()) {
            double d0 = this.wantedX - this.entity.getX();
            double d1 = this.wantedY - this.entity.getY();
            double d2 = this.wantedZ - this.entity.getZ();
            double d3 = Mth.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
            d1 = d1 / d3;
            float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
            this.entity.yRot = this.rotlerp(this.entity.yRot, f, 90.0F);
            this.entity.yBodyRot = this.entity.yRot;
            float f1 = (float) (this.speedModifier * this.entity.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
            this.entity.setSpeed(Mth.lerp(0.125F, this.entity.getSpeed(), f1));
            this.entity.setDeltaMovement(this.entity.getDeltaMovement().add(0.0D, (double) this.entity.getSpeed() * d1 * 0.1D, 0.0D));
        } else {
            this.entity.setSpeed(0.0F);
        }
    }
}
