package its_meow.betteranimalsplus.common.entity;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public abstract class EntityTameableFlying extends TameableEntity {

    public EntityTameableFlying(EntityType<? extends TameableEntity> type, World worldIn) {
        super(type, worldIn);
    }

    @Override
    public void travel(Vec3d vec) {
        if (this.isInWater()) {
            this.moveRelative(0.02F, vec);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().mul(0.800000011920929D, 0.800000011920929D, 0.800000011920929D));
        } else if (this.isInLava()) {
            this.moveRelative(0.02F, vec);
            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().mul(0.5D, 0.5D, 0.5D));
        } else {
            float f = 0.91F;

            if (this.onGround) {
                BlockPos underPos = new BlockPos(MathHelper.floor(this.posX),
                        MathHelper.floor(this.getBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
                BlockState underState = this.world.getBlockState(underPos);
                f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
            }

            float f1 = 0.16277136F / (f * f * f);
            this.moveRelative(this.onGround ? 0.1F * f1 : 0.02F, vec);
            f = 0.91F;

            if (this.onGround) {
                BlockPos underPos = new BlockPos(MathHelper.floor(this.posX),
                        MathHelper.floor(this.getBoundingBox().minY) - 1, MathHelper.floor(this.posZ));
                BlockState underState = this.world.getBlockState(underPos);
                f = underState.getBlock().getSlipperiness(underState, this.world, underPos, this) * 0.91F;
            }

            this.move(MoverType.SELF, this.getMotion());
            this.setMotion(this.getMotion().mul(f, f, f));
        }

        this.prevLimbSwingAmount = this.limbSwingAmount;
        double d1 = this.posX - this.prevPosX;
        double d0 = this.posZ - this.prevPosZ;
        float f2 = MathHelper.sqrt(d1 * d1 + d0 * d0) * 4.0F;

        if (f2 > 1.0F) {
            f2 = 1.0F;
        }

        this.limbSwingAmount += (f2 - this.limbSwingAmount) * 0.4F;
        this.limbSwing += this.limbSwingAmount;
    }

    @Override
    public boolean isOnLadder() {
        return false;
    }

}
