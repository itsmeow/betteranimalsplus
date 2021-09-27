package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingWithTypesBucketable;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class EntityFlyingFish extends EntityWaterMobPathingWithTypesBucketable {

    public EntityFlyingFish(EntityType<? extends EntityFlyingFish> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtPlayerGoal(this, WaterAnimal.class, 10.0F));
        this.goalSelector.addGoal(0, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new SurfaceOnAttackGoal(this));
        this.goalSelector.addGoal(2, new FlyingFishFlyGoal(this, 5));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 0.5D, 1));
    }

    @Override
    public void aiStep() {
        if(!this.isInWater() && this.onGround && this.verticalCollision) {
            this.setDeltaMovement(this.getDeltaMovement().add((this.random.nextFloat() * 2.0F - 1.0F) * 0.05F, 0.4F, (this.random.nextFloat() * 2.0F - 1.0F) * 0.05F));
            this.onGround = false;
            this.hasImpulse = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }
        super.aiStep();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.COD_FLOP;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.DROPS_COD;
    }

    @Override
    public EntityTypeContainer<? extends EntityFlyingFish> getContainer() {
        return ModEntities.FLYING_FISH;
    }

    @Override
    public EntityTypeContainerContainable<?, ?> getContainableContainer() {
        return ModEntities.FLYING_FISH;
    }

    public static class FlyingFishFlyGoal extends JumpGoal {
        private final EntityFlyingFish fish;
        private final int chance;
        private boolean inWater;
        private BlockPos start;
        private int ticks = 0;
        private int scale;

        public FlyingFishFlyGoal(EntityFlyingFish fish, int chance) {
            this.fish = fish;
            this.chance = chance;
        }

        @Override
        public boolean canUse() {
            boolean revenge = this.fish.getLastHurtByMob() != null && this.fish.getLastHurtByMob().distanceTo(this.fish) < 10;
            if(revenge || this.fish.getRandom().nextInt(this.chance) == 0) {
                Direction direction = this.fish.getMotionDirection();
                int dx = direction.getStepX();
                int dz = direction.getStepZ();
                if(revenge) {
                    LivingEntity attacker = this.fish.getLastHurtByMob();
                    Vec3 vec = attacker.position().subtract(fish.position()).normalize();
                    dx = (int) vec.x;
                    dz = (int) vec.z;
                }
                this.scale = this.fish.getRandom().nextInt(4) + (revenge ? 7 : 5);
                // loop through all blocks between this and target, make sure won't get trapped on land
                for(int tempScale = scale; tempScale >= 1; tempScale--) {
                    if(!this.canJumpTo(fish.blockPosition(), dx, dz, tempScale) || !this.isAirAbove(fish.blockPosition(), dx, dz, tempScale)) {
                        return false;
                    }
                }
                this.start = fish.blockPosition();
                return true;
            }
            return false;
        }

        private boolean canJumpTo(BlockPos pos, int dx, int dz, int scale) {
            BlockPos blockpos = pos.offset(dx * scale, 0, dz * scale);
            return this.fish.level.getFluidState(blockpos).is(FluidTags.WATER) && !this.fish.level.getBlockState(blockpos).getMaterial().blocksMotion();
        }

        private boolean isAirAbove(BlockPos pos, int dx, int dz, int scale) {
            return this.fish.level.isEmptyBlock(pos.offset(dx * scale, 1, dz * scale)) && this.fish.level.isEmptyBlock(pos.offset(dx * scale, 2, dz * scale));
        }

        @Override
        public boolean canContinueToUse() {
            return this.ticks < 200 && this.fish.getLastHurtByMob() != null ? this.fish.getLastHurtByMob().distanceTo(fish) > 10 : this.fish.position().distanceTo(new Vec3(start.getX() + 0.5, start.getY(), start.getZ() + 0.5)) < scale;
        }

        @Override
        public boolean isInterruptable() {
            return false;
        }

        @Override
        public void start() {
            this.ticks = 0;
        }

        @Override
        public void stop() {
            this.fish.xRot = 0.0F;
            this.ticks = 0;
        }

        @Override
        @SuppressWarnings("deprecation")
        public void tick() {
            boolean lastInWater = this.inWater;
            if(!lastInWater) {
                this.inWater = this.fish.level.getFluidState(this.fish.blockPosition()).is(FluidTags.WATER);
            }

            if(this.inWater && !lastInWater) {
                this.fish.playSound(SoundEvents.DOLPHIN_JUMP, 1.0F, 1.0F);
            }
            Vec3 vec3d = this.fish.getDeltaMovement();
            if(vec3d.y * vec3d.y < (double) 0.03F && this.fish.xRot != 0.0F) {
                this.fish.xRot = Mth.rotlerp(this.fish.xRot, 0.0F, 0.2F);
            } else {
                double d0 = Math.sqrt(Entity.getHorizontalDistanceSqr(vec3d));
                double d1 = Math.signum(-vec3d.y) * Math.acos(d0 / vec3d.length()) * (double) (180F / (float) Math.PI);
                this.fish.xRot = (float) d1;
            }
            Direction direction = this.fish.getMotionDirection();
            this.fish.setDeltaMovement(this.fish.getDeltaMovement().add((double) direction.getStepX() * 0.03D, 0.04D, (double) direction.getStepZ() * 0.03D));
            this.fish.getNavigation().stop();
            this.ticks++;
        }
    }

    public static class SurfaceOnAttackGoal extends Goal {
        private final EntityFlyingFish fish;
        private int targetY = 0;
        private boolean fail = false;

        public SurfaceOnAttackGoal(EntityFlyingFish fish) {
            this.fish = fish;
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean canUse() {
            int i = getTopWaterBlock();
            return fish.getLastHurtByMob() != null && i != -1 && fish.blockPosition().getY() < i;
        }

        @Override
        public boolean canContinueToUse() {
            return !fail && fish.blockPosition().getY() != targetY;
        }

        @Override
        public void start() {
            this.fail = false;
            this.targetY = this.getTopWaterBlock();
        }

        @Override
        public void tick() {
            if(!this.fish.getNavigation().moveTo(fish.blockPosition().getX(), targetY, fish.blockPosition().getZ(), 1D)) {
                this.fail = true;
            }
        }

        @Override
        public void stop() {
            this.fail = false;
        }

        private int getTopWaterBlock() {
            if(fish.isInWater()) {
                Level world = fish.level;
                BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(fish.blockPosition().getX(), fish.blockPosition().getY(), fish.blockPosition().getZ());
                for(int i = fish.blockPosition().getY(); i < fish.level.getHeight(); i++) {
                    pos.setY(i);
                    if(world.getFluidState(pos).is(FluidTags.WATER) && world.isEmptyBlock(pos.above())) {
                        return i;
                    }
                }
            }
            this.fail = true;
            return -1;
        }

}
}
