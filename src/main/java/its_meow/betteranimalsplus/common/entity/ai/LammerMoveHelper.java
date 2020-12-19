package its_meow.betteranimalsplus.common.entity.ai;

import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;

public class LammerMoveHelper extends MovementController {

    private final EntityLammergeier parentEntity;

    public LammerMoveHelper(EntityLammergeier lam) {
        super(lam);
        this.parentEntity = lam;
    }

    @Override
    public void tick() {
        if (this.action == MovementController.Action.MOVE_TO) {
            double diffX = this.posX - this.parentEntity.getPosX();
            double diffY = this.posY - this.parentEntity.getPosY();
            double diffZ = this.posZ - this.parentEntity.getPosZ();
            Vector3d vector3d = new Vector3d(diffX, diffY, diffZ);
            double d0 = vector3d.length();
            vector3d = vector3d.normalize();
            if (this.isPathClear(vector3d, MathHelper.ceil(d0))) {
                this.parentEntity.setMotion(this.parentEntity.getMotion().add(vector3d.scale(0.1D)));
            } else {
                this.action = MovementController.Action.WAIT;
            }
            float yawAngle = (float)(MathHelper.atan2(diffZ, diffX) * (double)(180F / (float)Math.PI)) - 90.0F;
            this.parentEntity.rotationYaw = this.limitAngle(this.parentEntity.rotationYaw, yawAngle, 35.0F);
            double xZDist = (double)MathHelper.sqrt(diffX * diffX + diffZ * diffZ);
            float pitchAngle = (float)(-(MathHelper.atan2(diffY, xZDist) * (double)(180F / (float)Math.PI)));
            this.parentEntity.rotationPitch = this.limitAngle(this.parentEntity.rotationPitch, pitchAngle, 35.0F);
        }
    }

    private boolean isPathClear(Vector3d movement, int distance) {
        AxisAlignedBB axisalignedbb = this.parentEntity.getBoundingBox();
        for(int i = 1; i < distance; ++i) {
            axisalignedbb = axisalignedbb.offset(movement);
            if (!this.parentEntity.world.hasNoCollisions(this.parentEntity, axisalignedbb)) {
                return false;
            }
        }
        return true;
    }

}