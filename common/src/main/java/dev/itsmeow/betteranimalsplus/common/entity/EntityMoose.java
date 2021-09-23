package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import dev.itsmeow.betteranimalsplus.common.entity.ai.EntityAIEatGrassCustom;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.IDropHead;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalEatsGrassWithTypes;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;

public class EntityMoose extends EntityAnimalEatsGrassWithTypes implements IDropHead<EntityAnimalWithTypes> {

    public EntityMoose(EntityType<? extends EntityMoose> entityType, World worldIn) {
        super(entityType, worldIn, 5);
        this.maxUpStep = 1F;
    }
    
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new RandomWalkingGoal(this, 0.65D));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 0.65D, false));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return EntityMoose.this.level.getDifficulty() != Difficulty.PEACEFUL && super.canUse();
            }
        });
        this.targetSelector.addGoal(1, new PeacefulNearestAttackableTargetGoal<>(this, PlayerEntity.class, 75, true, true, e -> e.distanceTo(this) < 15));
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.9F;
    }
    
    @Override
    protected void pushEntities() {
        // prevent pushing
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void checkInsideBlocks() {
        AxisAlignedBB axisalignedbb = this.getBoundingBox();
        BlockPos blockpos = new BlockPos(axisalignedbb.minX + 0.001D, axisalignedbb.minY + 0.001D, axisalignedbb.minZ + 0.001D);
        BlockPos blockpos1 = new BlockPos(axisalignedbb.maxX - 0.001D, axisalignedbb.maxY - 0.001D, axisalignedbb.maxZ - 0.001D);
        BlockPos.Mutable blockpos$mutable = new BlockPos.Mutable();
        if(this.level.hasChunksAt(blockpos, blockpos1)) {
            for(int i = blockpos.getX(); i <= blockpos1.getX(); ++i) {
                for(int j = blockpos.getY(); j <= blockpos1.getY(); ++j) {
                    for(int k = blockpos.getZ(); k <= blockpos1.getZ(); ++k) {
                        blockpos$mutable.set(i, j, k);
                        BlockState blockstate = this.level.getBlockState(blockpos$mutable);

                        try {
                            blockstate.entityInside(this.level, blockpos$mutable, this);
                            this.onInsideBlock(blockstate);
                            if(blockstate.getBlock() == Blocks.LILY_PAD) {
                                Block.dropResources(blockstate, level, blockpos$mutable.immutable());
                                level.setBlockAndUpdate(blockpos$mutable.immutable(), Blocks.AIR.defaultBlockState());
                            }
                        } catch(Throwable throwable) {
                            CrashReport crashreport = CrashReport.forThrowable(throwable, "Colliding entity with block");
                            CrashReportCategory crashreportcategory = crashreport.addCategory("Block being collided with");
                            CrashReportCategory.populateBlockDetails(crashreportcategory, blockpos$mutable, blockstate);
                            throw new ReportedException(crashreport);
                        }
                    }
                }
            }
        }
    }

    @Override
    protected EntityAIEatGrassCustom provideEatTask() {
        return new EntityAIEatGrassCustom(this, 200, 1000, eater -> {
            Direction facing = eater.getDirection();
            return eater.blockPosition().relative(facing).relative(facing);
        });
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        Vector3d pos = this.position();
        Vector3d targetPos = entityIn.position();
        ((LivingEntity) entityIn).knockback(1F, pos.x - targetPos.x, pos.z - targetPos.z);
        float f = (float) this.getAttribute(Attributes.ATTACK_DAMAGE).getValue();
        return entityIn.hurt(DamageSource.mobAttack(this), f);
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        this.doHeadDrop();
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.MOOSE;
    }

    @Override
    protected EntityMoose getBaseChild() {
        return null;
    }
    
    @Override
    public EntityTypeContainer<EntityMoose> getContainer() {
        return ModEntities.MOOSE;
    }

    @Override
    public IVariant getRandomType() {
        int[] validTypes = new int[] {1, 2, 3, 4};
        int r = validTypes[this.getRandom().nextInt(validTypes.length)];
        if(r > 2) {
            r = validTypes[this.getRandom().nextInt(validTypes.length)];
        }
        if(r > 2) {
            r = validTypes[this.getRandom().nextInt(validTypes.length)];
        }
        return this.getContainer().getVariantForName(String.valueOf(r));
    }

}
