package dev.itsmeow.betteranimalsplus.common.entity.ai;

import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.util.math.MathHelper;

public class HybridMoveController extends MovementController {
    private final MobEntity parent;

    public HybridMoveController(MobEntity e) {
        super(e);
        this.parent = e;
    }

    @Override
    public void tick() {
        if(!this.parent.isInWater()) {
            this.speed = 0.25F;
            super.tick();
        } else {
            this.speed = 1F;
            this.parent.setMotion(this.parent.getMotion().add(0.0D, 0.005D, 0.0D));
            if (this.action == MovementController.Action.MOVE_TO && !this.parent.getNavigator().noPath()) {
                double d0 = this.posX - this.parent.getPosX();
                double d1 = this.posY - this.parent.getPosY();
                double d2 = this.posZ - this.parent.getPosZ();
                float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
                this.parent.rotationYaw = this.limitAngle(this.parent.rotationYaw, f, 90.0F);
                this.parent.renderYawOffset = this.parent.rotationYaw;
                float f1 = (float)(this.speed * this.parent.getAttribute(Attributes.MOVEMENT_SPEED).getValue());
                this.parent.setAIMoveSpeed(MathHelper.lerp(0.125F, this.parent.getAIMoveSpeed(), f1));
                this.parent.setMotion(this.parent.getMotion().add(0.0D, (double)this.parent.getAIMoveSpeed() * d1 * 0.1D, 0.0D));
            } else {
                this.mob.setAIMoveSpeed(0F);
            }
        }
    }
}