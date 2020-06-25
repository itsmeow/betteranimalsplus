package its_meow.betteranimalsplus.common.entity.ai;

import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class LammerMoveHelper extends MovementController {

    private final EntityLammergeier parentEntity;

    public LammerMoveHelper(EntityLammergeier lam) {
        super(lam);
        this.parentEntity = lam;
    }

    public void tick() {
        if (this.action != MovementController.Action.MOVE_TO) {
            this.parentEntity.setMotion(0, 0, 0);
            return;
        }

        double diffX = this.posX - this.mob.posX;
        double diffY = this.posY - this.mob.posY;
        double diffZ = this.posZ - this.mob.posZ;
        Vec3d vec = new Vec3d(diffX, diffY, diffZ);
        if(vec.length() < 2.5000003E-7F) {
            this.action = Action.WAIT;
            this.parentEntity.setMotion(0, 0, 0);
            return;
        }
        this.parentEntity.setMotion(vec.scale(0.5D));
        float yawAngle = (float)(MathHelper.atan2(diffZ, diffX) * (double)(180F / (float)Math.PI)) - 90.0F;
        this.mob.rotationYaw = this.limitAngle(this.mob.rotationYaw, yawAngle, 35.0F);
        double xZDist = (double)MathHelper.sqrt(diffX * diffX + diffZ * diffZ);
        float pitchAngle = (float)(-(MathHelper.atan2(diffY, xZDist) * (double)(180F / (float)Math.PI)));
        this.mob.rotationPitch = this.limitAngle(this.mob.rotationPitch, pitchAngle, 35.0F);
    }

}