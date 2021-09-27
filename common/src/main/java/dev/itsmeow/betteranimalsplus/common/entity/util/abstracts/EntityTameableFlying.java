package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.animal.FlyingAnimal;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.Level;

public abstract class EntityTameableFlying extends EntityTameableBetterAnimalsPlus implements FlyingAnimal {

    public EntityTameableFlying(EntityType<? extends EntityTameableFlying> type, Level worldIn) {
        super(type, worldIn);
    }

    @Override
    public void travel(Vec3 vec3) {
        if (this.isInWater()) {
            this.moveRelative(0.02F, vec3);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.8F));
        } else if (this.isInLava()) {
            this.moveRelative(0.02F, vec3);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(0.5D));
        } else {
            BlockPos blockPos = this.getBlockPosBelowThatAffectsMyMovement();
            float fric = this.level.getBlockState(blockPos).getBlock().getFriction();
            float groundFric = this.onGround ? fric * 0.91F : 0.91F;
            Vec3 newVec = this.handleRelativeFrictionAndCalculateMovement(vec3, fric);
            double yMov = newVec.y;
            if (this.hasEffect(MobEffects.LEVITATION)) {
                yMov += (0.05D * (double) (this.getEffect(MobEffects.LEVITATION).getAmplifier() + 1) - newVec.y) * 0.2D;
                this.fallDistance = 0.0F;
            } else if (this.level.isClientSide && !this.level.hasChunkAt(blockPos)) {
                if (this.getY() > 0.0D) {
                    yMov = -0.1D;
                } else {
                    yMov = 0.0D;
                }
            } else if (!this.isNoGravity()) {
                yMov -= 0.08D;
            }

            this.setDeltaMovement(newVec.x * (double) groundFric, yMov * 0.98D, newVec.z * (double) groundFric);
        }
        this.calculateEntityAnimation(this, true);
    }

    @Override
    public boolean onClimbable() {
        return false;
    }

}
