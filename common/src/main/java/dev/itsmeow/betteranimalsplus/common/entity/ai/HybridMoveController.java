package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;

public class HybridMoveController extends MoveControl {
    private final Mob parent;

    public HybridMoveController(Mob e) {
        super(e);
        this.parent = e;
    }

    @Override
    public void tick() {
        if(!this.parent.isInWater()) {
            this.speedModifier = 0.25F;
            super.tick();
        } else {
            this.speedModifier = 1F;
            this.parent.setDeltaMovement(this.parent.getDeltaMovement().add(0.0D, 0.005D, 0.0D));
            if (this.operation == Operation.MOVE_TO && !this.parent.getNavigation().isDone()) {
                double d0 = this.wantedX - this.parent.getX();
                double d1 = this.wantedY - this.parent.getY();
                double d2 = this.wantedZ - this.parent.getZ();
                float f = (float) (Mth.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.parent.setYRot(this.rotlerp(this.parent.getYRot(), f, 90.0F));
                this.parent.yBodyRot = this.parent.getYRot();
                float f1 = (float)(this.speedModifier * this.parent.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                this.parent.setSpeed(Mth.lerp(0.125F, this.parent.getSpeed(), f1));
                this.parent.setDeltaMovement(this.parent.getDeltaMovement().add(0.0D, (double)this.parent.getSpeed() * d1 * 0.1D, 0.0D));
            } else {
                this.mob.setSpeed(0F);
            }
        }
    }
}