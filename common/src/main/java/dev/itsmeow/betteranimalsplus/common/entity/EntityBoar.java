package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.IDropHead;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithSelectiveTypes;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.util.ModPlatformEvents;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Pig;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.monster.ZombifiedPiglin;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;

import java.util.Set;

public class EntityBoar extends EntityAnimalWithSelectiveTypes implements Enemy, IDropHead<EntityAnimalWithTypes> {

    private static final String[] SNOWY_CONIFEROUS_TYPES = new String[] { "dark_brown", "gray" };
    private static final String[] ALL_BOAR_TYPES = new String[] { "dark_brown", "light_brown", "gray" };

    public EntityBoar(EntityType<? extends EntityBoar> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.setPathfindingMalus(BlockPathTypes.DANGER_OTHER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.DAMAGE_OTHER, 0.0F);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2D, false) {
            @Override
            public boolean canUse() {
                return !EntityBoar.this.isBaby() && super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                return !EntityBoar.this.isBaby() && super.canContinueToUse();
            }
        });
        this.goalSelector.addGoal(2, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(3, new FollowParentGoal(this, 1.1D));
        if(this.getContainer().getCustomConfiguration().getBoolean("nerf_options/eat_crops")) {
            this.goalSelector.addGoal(4, new BoarAIEatCrops(this));
            this.goalSelector.addGoal(5, new EntityAIEatBerries(this, 1.0D, 12, 2) {
                @Override
                protected void eatBerry() {
                    super.eatBerry();
                    if (EntityBoar.this.getContainer().getCustomConfiguration().getBoolean("nerf_options/breed_from_crops"))
                        EntityBoar.this.setInLove(null);
                }
            });
        }
        this.goalSelector.addGoal(6, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this) {
            @Override
            public boolean canUse() {
                return !EntityBoar.this.isBaby() && !EntityBoar.this.isPeaceful() && super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                return !EntityBoar.this.isBaby() && !EntityBoar.this.isPeaceful() && super.canContinueToUse();
            }
        }.setAlertOthers(EntityBoar.class));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<Animal>(this, Animal.class, 90, true, true, (LivingEntity in) -> in instanceof Chicken || in instanceof EntityPheasant || in instanceof Animal && in.isBaby() && !(in instanceof EntityBoar || in instanceof Pig || in instanceof Hoglin)) {
            @Override
            public boolean canUse() {
                return EntityBoar.this.shouldAttack() && EntityBoar.this.attackChance() && super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                return EntityBoar.this.shouldAttack() && super.canContinueToUse();
            }
        });
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 50, true, true, (LivingEntity in) -> in instanceof Animal && !(in instanceof EntityBoar || in instanceof Pig || in instanceof Hoglin) || in instanceof Player) {
            @Override
            public boolean canUse() {
                return EntityBoar.this.shouldAttack() && EntityBoar.this.attackChance() && super.canUse();
            }

            @Override
            public boolean canContinueToUse() {
                return EntityBoar.this.shouldAttack() && super.canContinueToUse();
            }
        });
    }

    public boolean shouldAttack() {
        return !this.isBaby() && !this.isPeaceful();
    }

    public boolean attackChance() {
        return ((double) this.getContainer().getCustomConfiguration().getInt("nerf_options/target_chance") / 100D) > Math.random();
    }

    public boolean isPeaceful() {
        return level.getDifficulty() == Difficulty.PEACEFUL;
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.PIG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.PIG_DEATH;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        this.playSound(SoundEvents.PIG_STEP, 0.15F, 1.0F);
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        this.doHeadDrop();
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return EntityType.PIG.getDefaultLootTable();
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        Vec3 pos = this.position();
        Vec3 targetPos = entityIn.position();
        ((LivingEntity) entityIn).knockback(0.8F, pos.x - targetPos.x, pos.z - targetPos.z);
       return super.doHurtTarget(entityIn);
    }

    @Override
    public void thunderHit(ServerLevel p_241841_1_, LightningBolt p_241841_2_) {
        if (!this.level.isClientSide && !this.dead) {
            ZombifiedPiglin entitypigzombie = EntityType.ZOMBIFIED_PIGLIN.create(this.level);
            entitypigzombie.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
            entitypigzombie.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), this.getXRot());
            entitypigzombie.setNoAi(this.isNoAi());

            if(this.hasCustomName()) {
                entitypigzombie.setCustomName(this.getCustomName());
                entitypigzombie.setCustomNameVisible(true);
            }

            this.level.addFreshEntity(entitypigzombie);
            this.discard();
        }
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob ageable) {
        if(this.getVariant().isPresent()) {
            if (ageable instanceof EntityBoar) {
                EntityBoar boar = getContainer().getEntityType().create(world);
                boar.setType(this.getVariant().get());
                return boar;
            } else if (ageable instanceof Pig) {
                Pig pig = new Pig(EntityType.PIG, this.level);
                EntityBoar boar = getContainer().getEntityType().create(world);
                boar.setType(this.getVariant().get());
                return this.random.nextBoolean() ? pig : boar;
            }
        }
        return null;
    }

    @Override
    public boolean canMate(Animal otherAnimal) {
        if(otherAnimal != this) {
            if(otherAnimal instanceof EntityBoar || otherAnimal instanceof Pig) {
                return otherAnimal.isInLove() && this.isInLove();
            }
        }

        return false;
    }

    @Override
    public boolean isInvulnerableTo(DamageSource source) {
        return super.isInvulnerableTo(source) || source == DamageSource.SWEET_BERRY_BUSH;
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == Items.CARROT || stack.getItem() == Items.GOLDEN_CARROT;
    }

    @Override
    public String[] getTypesFor(ResourceKey<Biome> biomeKey, Biome biome, Set<BiomeTypes.Type> types, MobSpawnType reason) {
       if(types.contains(BiomeTypes.CONIFEROUS) && types.contains(BiomeTypes.SNOWY)) {
            return SNOWY_CONIFEROUS_TYPES;
        } else if(types.contains(BiomeTypes.SNOWY) && !types.contains(BiomeTypes.CONIFEROUS) && !types.contains(BiomeTypes.FOREST)) {
            return new String[] { "gray" };
        } else {
            return ALL_BOAR_TYPES;
        }
    }

    @Override
    public EntityTypeContainer<EntityBoar> getContainer() {
        return ModEntities.BOAR;
    }

    public static class BoarAIEatCrops extends MoveToBlockGoal {
        private final EntityBoar boar;

        public BoarAIEatCrops(EntityBoar boarIn) {
            super(boarIn, 0.7, 16);
            this.boar = boarIn;
        }

        @Override
        public boolean canUse() {
            if(this.nextStartTick <= 0) {
                if(!ModPlatformEvents.mobGrief(this.boar.level, this.boar)) {
                    return false;
                }
            }

            return !this.boar.isInLove() && super.canUse();
        }

        @Override
        public boolean canContinueToUse() {
            return !this.boar.isInLove() && super.canContinueToUse();
        }

        @Override
        public void tick() {
            if(!this.blockPos.closerThan(this.mob.blockPosition(), this.acceptedDistance())) {
                this.boar.getMoveControl().setWantedPosition((double) this.blockPos.getX() + 0.5D, this.blockPos.getY(), (double) this.blockPos.getZ() + 0.5D, this.speedModifier);
            } else {
                Level world = this.boar.level;
                BlockPos pos = this.blockPos;
                BlockState state = world.getBlockState(pos);
                Block block = state.getBlock();

                if(!this.boar.isInLove() && block instanceof CropBlock && ((CropBlock) block).isMaxAge(state)) {
                    world.setBlock(pos, Blocks.AIR.defaultBlockState(), 2);
                    world.destroyBlock(pos, true);
                    if(boar.getContainer().getCustomConfiguration().getBoolean("nerf_options/breed_from_crops"))
                        boar.setInLove(null);
                }
            }
            this.boar.getLookControl().setLookAt((double) this.blockPos.getX() + 0.5D, this.blockPos.getY() + 0.5D, (double) this.blockPos.getZ() + 0.5D, 10.0F, (float) this.boar.getMaxHeadXRot());
        }

        @Override
        protected boolean isValidTarget(LevelReader worldIn, BlockPos pos) {
            BlockState state = worldIn.getBlockState(pos);
            Block block = state.getBlock();
            if(!this.boar.isInLove() && block instanceof CropBlock && ((CropBlock) block).isMaxAge(state)) {
                return worldIn.getBlockState(pos.below()).getBlock() == Blocks.FARMLAND;
            }
            return false;
        }
    }

    @Override
    protected EntityAnimalWithTypes getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

}
