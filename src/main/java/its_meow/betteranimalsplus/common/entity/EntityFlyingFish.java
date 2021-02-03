package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.EntityTypeContainerContainable;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathingWithTypesBucketable;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.WaterMobEntity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.EnumSet;

public class EntityFlyingFish extends EntityWaterMobPathingWithTypesBucketable {

    public EntityFlyingFish(World world) {
        super(ModEntities.FLYING_FISH.entityType, world);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new LookAtGoal(this, WaterMobEntity.class, 10.0F));
        this.goalSelector.addGoal(0, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(1, new SurfaceOnAttackGoal(this));
        this.goalSelector.addGoal(2, new FlyingFishFlyGoal(this, 5));
        this.goalSelector.addGoal(3, new RandomSwimmingGoal(this, 0.5D, 1));
    }

    @Override
    public void livingTick() {
        if(!this.isInWater() && this.onGround && this.collidedVertically) {
            this.setMotion(this.getMotion().add((this.rand.nextFloat() * 2.0F - 1.0F) * 0.05F, 0.4F, (this.rand.nextFloat() * 2.0F - 1.0F) * 0.05F));
            this.onGround = false;
            this.isAirBorne = true;
            this.playSound(this.getFlopSound(), this.getSoundVolume(), this.getSoundPitch());
        }
        super.livingTick();
    }

    @Override
    protected SoundEvent getFlopSound() {
        return SoundEvents.ENTITY_COD_FLOP;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(4D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(1D);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.DROPS_COD;
    }

    @Override
    public EntityTypeContainer<?> getContainer() {
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
        public boolean shouldExecute() {
            boolean revenge = this.fish.getRevengeTarget() != null && this.fish.getRevengeTarget().getDistance(this.fish) < 10;
            if(revenge || this.fish.getRNG().nextInt(this.chance) == 0) {
                Direction direction = this.fish.getAdjustedHorizontalFacing();
                int dx = direction.getXOffset();
                int dz = direction.getZOffset();
                if(revenge) {
                    LivingEntity attacker = this.fish.getRevengeTarget();
                    Vec3d vec = attacker.getPositionVector().subtract(fish.getPositionVector()).normalize();
                    dx = (int) vec.x;
                    dz = (int) vec.z;
                }
                this.scale = this.fish.getRNG().nextInt(4) + (revenge ? 7 : 5);
                // loop through all blocks between this and target, make sure won't get trapped on land
                for(int tempScale = scale; tempScale >= 1; tempScale--) {
                    if(!this.canJumpTo(fish.getPosition(), dx, dz, tempScale) || !this.isAirAbove(fish.getPosition(), dx, dz, tempScale)) {
                        return false;
                    }
                }
                this.start = fish.getPosition();
                return true;
            }
            return false;
        }

        private boolean canJumpTo(BlockPos pos, int dx, int dz, int scale) {
            BlockPos blockpos = pos.add(dx * scale, 0, dz * scale);
            return this.fish.world.getFluidState(blockpos).isTagged(FluidTags.WATER) && !this.fish.world.getBlockState(blockpos).getMaterial().blocksMovement();
        }

        private boolean isAirAbove(BlockPos pos, int dx, int dz, int scale) {
            return this.fish.world.isAirBlock(pos.add(dx * scale, 1, dz * scale)) && this.fish.world.isAirBlock(pos.add(dx * scale, 2, dz * scale));
        }

        @Override
        public boolean shouldContinueExecuting() {
            return this.ticks < 200 && this.fish.getRevengeTarget() != null ? this.fish.getRevengeTarget().getDistance(fish) > 10 : this.fish.getPositionVector().distanceTo(new Vec3d(start.getX() + 0.5, start.getY(), start.getZ() + 0.5)) < scale;
        }

        @Override
        public boolean isPreemptible() {
            return false;
        }

        @Override
        public void startExecuting() {
            this.ticks = 0;
        }

        @Override
        public void resetTask() {
            this.fish.rotationPitch = 0.0F;
            this.ticks = 0;
        }

        @Override
        @SuppressWarnings("deprecation")
        public void tick() {
            boolean lastInWater = this.inWater;
            if(!lastInWater) {
                this.inWater = this.fish.world.getFluidState(new BlockPos(this.fish)).isTagged(FluidTags.WATER);
            }

            if(this.inWater && !lastInWater) {
                this.fish.playSound(SoundEvents.ENTITY_DOLPHIN_JUMP, 1.0F, 1.0F);
            }
            Vec3d vec3d = this.fish.getMotion();
            if(vec3d.y * vec3d.y < (double) 0.03F && this.fish.rotationPitch != 0.0F) {
                this.fish.rotationPitch = MathHelper.rotLerp(this.fish.rotationPitch, 0.0F, 0.2F);
            } else {
                double d0 = Math.sqrt(Entity.horizontalMag(vec3d));
                double d1 = Math.signum(-vec3d.y) * Math.acos(d0 / vec3d.length()) * (double) (180F / (float) Math.PI);
                this.fish.rotationPitch = (float) d1;
            }
            Direction direction = this.fish.getAdjustedHorizontalFacing();
            this.fish.setMotion(this.fish.getMotion().add((double) direction.getXOffset() * 0.03D, 0.04D, (double) direction.getZOffset() * 0.03D));
            this.fish.getNavigator().clearPath();
            this.ticks++;
        }
    }

    public static class SurfaceOnAttackGoal extends Goal {
        private final EntityFlyingFish fish;
        private int targetY = 0;
        private boolean fail = false;

        public SurfaceOnAttackGoal(EntityFlyingFish fish) {
            this.fish = fish;
            this.setMutexFlags(EnumSet.of(Flag.MOVE));
        }

        @Override
        public boolean shouldExecute() {
            int i = getTopWaterBlock();
            return fish.getRevengeTarget() != null && i != -1 && fish.getPosition().getY() < i;
        }

        @Override
        public boolean shouldContinueExecuting() {
            return !fail && fish.getPosition().getY() != targetY;
        }

        @Override
        public void startExecuting() {
            this.fail = false;
            this.targetY = this.getTopWaterBlock();
        }

        @Override
        public void tick() {
            if(!this.fish.getNavigator().tryMoveToXYZ(fish.getPosition().getX(), targetY, fish.getPosition().getZ(), 1D)) {
                this.fail = true;
            }
        }

        @Override
        public void resetTask() {
            this.fail = false;
        }

        private int getTopWaterBlock() {
            if(fish.isInWater()) {
                World world = fish.world;
                BlockPos.Mutable pos = new BlockPos.Mutable(fish.getPosition());
                for(int i = fish.getPosition().getY(); i < fish.world.getMaxHeight(); i++) {
                    pos.setY(i);
                    if(world.getFluidState(pos).isTagged(FluidTags.WATER) && world.isAirBlock(pos.up())) {
                        return i;
                    }
                }
            }
            this.fail = true;
            return -1;
        }

}
}
