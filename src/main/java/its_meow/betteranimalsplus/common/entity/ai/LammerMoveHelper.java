package its_meow.betteranimalsplus.common.entity.ai;

import java.util.Random;

import its_meow.betteranimalsplus.common.entity.EntityLammergeier;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;

public class LammerMoveHelper extends EntityMoveHelper {

    private final EntityLammergeier parentEntity;

    public LammerMoveHelper(EntityLammergeier lam) {
        super(lam);
        this.parentEntity = lam;
    }

    @Override
    public boolean isUpdating() {
        return this.action == EntityMoveHelper.Action.MOVE_TO;
    }

    @Override
    public void tick() {
        if (this.action == Action.JUMPING) {
            this.action = Action.MOVE_TO;
        }
        if (this.action == EntityMoveHelper.Action.MOVE_TO && !this.parentEntity.isSitting()) {
            double d0 = this.posX - this.parentEntity.posX;
            double d1 = this.posY - this.parentEntity.posY;
            double d2 = this.posZ - this.parentEntity.posZ;
            double d3 = d0 * d0 + d1 * d1 + d2 * d2;
            if (d3 <= 1.0D || d3 >= 3600.0D || this.posY > 500.0D) {
                this.action = EntityMoveHelper.Action.WAIT;
            }
            d3 = MathHelper.sqrt(d3);
            if (this.isNotColliding(this.posX, this.posY, this.posZ, d3)) {
                this.parentEntity.motionX += d0 / d3 * 0.1D;
                this.parentEntity.motionY += d1 / d3 * 0.1D + (this.parentEntity.getAttackTarget() == null ? 0.0D
                        : this.parentEntity.getAttackTarget().isRidingOrBeingRiddenBy(this.parentEntity) ? 0.1D : 0D);
                this.parentEntity.motionZ += d2 / d3 * 0.1D;
            } else {
                this.parentEntity.motionY += 0.05;
                if (this.parentEntity.getEntityWorld().getBlockState(this.parentEntity.getPosition().up()).isSolid()) {
                    this.parentEntity.motionX += d0 / d3 * 0.1D;
                    this.parentEntity.motionY -= 0.05 + (this.parentEntity.getAttackTarget() == null ? 0.0D
                            : this.parentEntity.getAttackTarget().isRidingOrBeingRiddenBy(this.parentEntity) ? 0.1D
                                    : 0D);
                    this.parentEntity.motionZ += d2 / d3 * 0.1D;
                }
                if (this.parentEntity.posX == this.parentEntity.lastTickPosX
                        && this.parentEntity.posY == this.parentEntity.lastTickPosY
                        && this.parentEntity.posZ == this.parentEntity.lastTickPosZ) {
                    Random rand = this.parentEntity.getRNG();

                    this.setMoveTo(this.parentEntity.posX + rand.nextInt(2) - 1,
                            this.parentEntity.posY + rand.nextInt(2) - 1, this.parentEntity.posZ + rand.nextInt(2) - 1,
                            0.5D);
                }
                this.action = EntityMoveHelper.Action.WAIT;
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

            if (this.parentEntity.world.getCollisionBoxes(this.parentEntity, axisalignedbb, 0, 0, 0).count() != 0) {
                return false;
            }
        }

        return true;
    }
}