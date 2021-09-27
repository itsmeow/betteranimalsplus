package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

public abstract class EntityTameableFlying extends EntityTameableBetterAnimalsPlus {

    public EntityTameableFlying(EntityType<? extends EntityTameableFlying> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    public void travel(Vec3 p_213352_1_) {
        if(this.isInWater()) {
            this.moveRelative(0.02F, p_213352_1_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.8F));
        } else if(this.isInLava()) {
            this.moveRelative(0.02F, p_213352_1_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
        } else {
            BlockPos ground = new BlockPos(this.getX(), this.getBoundingBox().minY - 1.0D, this.getZ());
            float f = 0.91F;
            if(this.onGround) {
                f = this.level.getBlockState(ground).getSlipperiness(level, ground, this) * 0.91F;
            }

            float f1 = 0.16277137F / (f * f * f);
            f = 0.91F;
            if(this.onGround) {
                f = this.level.getBlockState(ground).getSlipperiness(level, ground, this) * 0.91F;
            }

            this.moveRelative(this.onGround ? 0.1F * f1 : 0.02F, p_213352_1_);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(f));
        }

        this.animationSpeedOld = this.animationSpeed;
        double d1 = this.getX() - this.xo;
        double d0 = this.getZ() - this.zo;
        float f2 = Mth.sqrt(d1 * d1 + d0 * d0) * 4.0F;
        if(f2 > 1.0F) {
            f2 = 1.0F;
        }

        this.animationSpeed += (f2 - this.animationSpeed) * 0.4F;
        this.animationPosition += this.animationSpeed;
    }

    @Override
    public boolean onClimbable() {
        return false;
    }

}
