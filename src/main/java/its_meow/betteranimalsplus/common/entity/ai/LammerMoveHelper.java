package its_meow.betteranimalsplus.common.entity.ai;

import java.util.Random;

import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;

public class LammerMoveHelper extends MovementController {

    private final EntityLammergeier parentEntity;

    public LammerMoveHelper(EntityLammergeier lam) {
        super(lam);
        this.parentEntity = lam;
    }

    @Override
    public boolean isUpdating() {
        return this.action == MovementController.Action.MOVE_TO;
    }

    @Override
    public void tick() {
        if (this.action == Action.JUMPING) {
            this.action = Action.MOVE_TO;
        }
        if (this.action == MovementController.Action.MOVE_TO && !this.parentEntity.isSitting()) {
            double d0 = this.posX - this.parentEntity.posX;
            double d1 = this.posY - this.parentEntity.posY;
            double d2 = this.posZ - this.parentEntity.posZ;
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d3 <= 1.0D || d3 >= 3600.0D || this.posY > 500.0D) {
                this.action = MovementController.Action.WAIT;
            }
            d3 = MathHelper.sqrt(d3);
            if (this.isNotColliding(this.posX, this.posY, this.posZ, d3)) {
                double motionXAdd = d0 / d3 * 0.1D;
                double motionYAdd = d1 / d3 * 0.1D + (this.parentEntity.getAttackTarget() == null ? 0.0D
                        : this.parentEntity.getAttackTarget().isRidingOrBeingRiddenBy(this.parentEntity) ? 0.1D : 0D);
                double motionZAdd = d2 / d3 * 0.1D;
                this.parentEntity.setMotion(this.parentEntity.getMotion().getX() + motionXAdd, this.parentEntity.getMotion().getY() + motionYAdd, this.parentEntity.getMotion().getZ() + motionZAdd);
            } else {
                this.parentEntity.setMotion(this.parentEntity.getMotion().add(new Vec3d(0, 0.05, 0)));
                if (this.parentEntity.getEntityWorld().getBlockState(this.parentEntity.getPosition().up()).isSolid()) {
                    double motionXAdd = d0 / d3 * 0.1D;
                    double motionYAdd = d1 / d3 * 0.1D + (this.parentEntity.getAttackTarget() == null ? 0.0D
                            : this.parentEntity.getAttackTarget().isRidingOrBeingRiddenBy(this.parentEntity) ? 0.1D : 0D);
                    double motionZAdd = d2 / d3 * 0.1D;
                    this.parentEntity.setMotion(this.parentEntity.getMotion().getX() + motionXAdd, this.parentEntity.getMotion().getY() + motionYAdd, this.parentEntity.getMotion().getZ() + motionZAdd);
                }
                if (this.parentEntity.posX == this.parentEntity.lastTickPosX
                        && this.parentEntity.posY == this.parentEntity.lastTickPosY
                        && this.parentEntity.posZ == this.parentEntity.lastTickPosZ) {
                    Random rand = this.parentEntity.getRNG();

                    this.setMoveTo(this.parentEntity.posX + rand.nextInt(2) - 1,
                            this.parentEntity.posY + rand.nextInt(2) - 1, this.parentEntity.posZ + rand.nextInt(2) - 1,
                            0.5D);
                }
                this.action = MovementController.Action.WAIT;
            }
        }
    }

    /**
     * Checks if entity bounding box is not colliding with terrain
     */
    private boolean isNotColliding(double x, double y, double z, double isNotColliding) {
        double d0 = (x - this.parentEntity.posX) / isNotColliding;
        double d1 = (y - this.parentEntity.posY) / isNotColliding;
        double d2 = (z - this.parentEntity.posZ) / isNotColliding;
        AxisAlignedBB axisalignedbb = this.parentEntity.getBoundingBox();

        for (int i = 1; i < isNotColliding; ++i) {
            axisalignedbb = axisalignedbb.offset(d0, d1, d2);

            if (this.parentEntity.world.getEntitiesWithinAABBExcludingEntity(this.parentEntity, axisalignedbb).size() != 0) {
                return false;
            }
        }

        return true;
    }
}