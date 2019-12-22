package its_meow.betteranimalsplus.common.entity.ai;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.math.MathHelper;

public class WaterMoveHelper extends MovementController {
    private final WaterMobEntity entity;

    public WaterMoveHelper(WaterMobEntity entity) {
        super(entity);
        this.entity = entity;
    }

    public void tick() {
        if(this.entity.areEyesInFluid(FluidTags.WATER)) {
            this.entity.setMotion(this.entity.getMotion().add(0.0D, 0.005D, 0.0D));
        }

        if(this.action == MovementController.Action.MOVE_TO && !this.entity.getNavigator().noPath()) {
            double d0 = this.posX - this.entity.posX;
            double d1 = this.posY - this.entity.posY;
            double d2 = this.posZ - this.entity.posZ;
            double d3 = (double) MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
            d1 = d1 / d3;
            float f = (float) (MathHelper.atan2(d2, d0) * (double) (180F / (float) Math.PI)) - 90.0F;
            this.entity.rotationYaw = this.limitAngle(this.entity.rotationYaw, f, 90.0F);
            this.entity.renderYawOffset = this.entity.rotationYaw;
            float f1 = (float) (this.speed * this.entity.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getValue());
            this.entity.setAIMoveSpeed(MathHelper.lerp(0.125F, this.entity.getAIMoveSpeed(), f1));
            this.entity.setMotion(this.entity.getMotion().add(0.0D, (double) this.entity.getAIMoveSpeed() * d1 * 0.1D, 0.0D));
        } else {
            this.entity.setAIMoveSpeed(0.0F);
        }
    }
}
