package dev.itsmeow.betteranimalsplus.common.entity.ai;

import dev.itsmeow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

public class LammerMoveHelper extends MoveControl {

    private final EntityLammergeier parentEntity;

    public LammerMoveHelper(EntityLammergeier lam) {
        super(lam);
        this.parentEntity = lam;
    }

    @Override
    public void tick() {
        if (this.operation == Operation.MOVE_TO) {
            double diffX = this.wantedX - this.parentEntity.getX();
            double diffY = this.wantedY - this.parentEntity.getY();
            double diffZ = this.wantedZ - this.parentEntity.getZ();
            Vec3 vector3d = new Vec3(diffX, diffY, diffZ);
            double d0 = vector3d.length();
            vector3d = vector3d.normalize();
            if (this.isPathClear(vector3d, Mth.ceil(d0))) {
                this.parentEntity.setDeltaMovement(this.parentEntity.getDeltaMovement().add(vector3d.scale(0.1D)));
            } else {
                this.operation = Operation.WAIT;
            }
            float yawAngle = (float)(Mth.atan2(diffZ, diffX) * (double)(180F / (float)Math.PI)) - 90.0F;
            this.parentEntity.setYRot(this.rotlerp(this.parentEntity.getYRot(), yawAngle, 35.0F));
            double xZDist = Math.sqrt(diffX * diffX + diffZ * diffZ);
            float pitchAngle = (float)(-(Mth.atan2(diffY, xZDist) * (double)(180F / (float)Math.PI)));
            this.parentEntity.setXRot(this.rotlerp(this.parentEntity.getXRot(), pitchAngle, 35.0F));
        }
    }

    private boolean isPathClear(Vec3 movement, int distance) {
        AABB axisalignedbb = this.parentEntity.getBoundingBox();
        for(int i = 1; i < distance; ++i) {
            axisalignedbb = axisalignedbb.move(movement);
            if (!this.parentEntity.level.noCollision(this.parentEntity, axisalignedbb)) {
                return false;
            }
        }
        return true;
    }

}