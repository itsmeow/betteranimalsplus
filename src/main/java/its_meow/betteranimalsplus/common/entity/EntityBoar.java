package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityTypeContainer;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.CropsBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.FollowParentGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.MoveToBlockGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomWalkingGoal;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;


public class EntityBoar extends EntityAnimalWithSelectiveTypes implements IMob {

    public EntityBoar(World worldIn) {
        super(ModEntities.BOAR.entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        if (!this.isChild() && this.getEntityWorld().getDifficulty() != Difficulty.PEACEFUL) {
            this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.2D, false));
        }
        this.goalSelector.addGoal(3, new BreedGoal(this, 1.0D));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1.1D));
        this.goalSelector.addGoal(7, new BoarAIEatCrops(this));
        this.goalSelector.addGoal(7, new EntityAIEatBerries(this, 1.0D, 12, 2) {
            @Override
            protected void eatBerry() {
                super.eatBerry();
                EntityBoar.this.setInLove(null);
            }
        });
        this.goalSelector.addGoal(8, new WaterAvoidingRandomWalkingGoal(this, 1.0D));
        this.goalSelector.addGoal(9, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        if (!this.isChild() && this.getEntityWorld().getDifficulty() != Difficulty.PEACEFUL) {
            this.targetSelector.addGoal(1,
            new NearestAttackableTargetGoal<AnimalEntity>(this, AnimalEntity.class, 90, true, true,
            (@Nullable LivingEntity in) -> in instanceof ChickenEntity || in instanceof EntityPheasant
            || in instanceof AnimalEntity && ((AnimalEntity) in).isChild()
            && !(in instanceof EntityBoar || in instanceof PigEntity)));
            this.targetSelector.addGoal(2,
            new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 50, true, true,
            (@Nullable LivingEntity in) -> in instanceof AnimalEntity
            && !(in instanceof EntityBoar || in instanceof PigEntity)
            || in instanceof PlayerEntity));
        }
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.38D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3.5D);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_PIG_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENTITY_PIG_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_PIG_DEATH;
    }

    protected void playStepSound(BlockPos pos, Block blockIn) {
        this.playSound(SoundEvents.ENTITY_PIG_STEP, 0.15F, 1.0F);
    }

    /**
     * Called when the mob's health reaches 0.
     */
    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if (!world.isRemote && !this.isChild()) {
            if (this.rand.nextInt(12) == 0) {
                ItemStack stack = new ItemStack(HeadTypes.BOARHEAD.getItem(this.getTypeNumber()));
                this.entityDropItem(stack, 0.5F);
            }
        }
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return EntityType.PIG.getLootTable();
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        Vec3d pos = this.getPositionVector();
        Vec3d targetPos = entityIn.getPositionVector();
        ((LivingEntity) entityIn).knockBack(entityIn, 0.8F, pos.x - targetPos.x, pos.z - targetPos.z);

        // Vanilla attack code for mobs

        float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
        int i = 0;

        if (entityIn instanceof LivingEntity) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(),
            ((LivingEntity) entityIn).getCreatureAttribute());
            i += EnchantmentHelper.getKnockbackModifier(this);
        }

        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);

        if (flag) {
            if (i > 0 && entityIn instanceof LivingEntity) {
                ((LivingEntity) entityIn).knockBack(this, i * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F),
                -MathHelper.cos(this.rotationYaw * 0.017453292F));
                this.setMotion(this.getMotion().getX() * 0.6D, this.getMotion().getY(), this.getMotion().getZ() * 0.6D);
            }

            int j = EnchantmentHelper.getFireAspectModifier(this);

            if (j > 0) {
                entityIn.setFire(j * 4);
            }

            if (entityIn instanceof PlayerEntity) {
                PlayerEntity entityplayer = (PlayerEntity) entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack()
                : ItemStack.EMPTY;

                if (!itemstack.isEmpty() && !itemstack1.isEmpty()
                && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this)
                && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

                    if (this.rand.nextFloat() < f1) {
                        entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
                        this.world.setEntityState(entityplayer, (byte) 30);
                    }
                }
            }

            this.applyEnchantments(this, entityIn);
        }

        return flag;
    }

    /**
     * Called when a lightning bolt hits the entity.
     */
    @Override
    public void onStruckByLightning(LightningBoltEntity lightningBolt) {
        if (!this.world.isRemote && !this.dead) {
            ZombiePigmanEntity entitypigzombie = new ZombiePigmanEntity(EntityType.ZOMBIE_PIGMAN, this.world);
            entitypigzombie.setItemStackToSlot(EquipmentSlotType.MAINHAND, new ItemStack(Items.GOLDEN_SWORD));
            entitypigzombie.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            entitypigzombie.setNoAI(this.isAIDisabled());

            if (this.hasCustomName()) {
                entitypigzombie.setCustomName(this.getCustomName());
                entitypigzombie.setCustomNameVisible(true);
            }

            this.world.addEntity(entitypigzombie);
            this.remove();
        }
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        if (ageable instanceof EntityBoar) {
            EntityBoar boar = new EntityBoar(this.world);
            boar.setType(this.getTypeNumber());
            return boar;
        } else if (ageable instanceof PigEntity) {
            PigEntity pig = new PigEntity(EntityType.PIG, this.world);
            EntityBoar boar = new EntityBoar(this.world);
            boar.setType(this.getTypeNumber());
            return this.rand.nextBoolean() ? pig : boar;
        } else {
            return null;
        }
    }

    @Override
    public boolean canMateWith(AnimalEntity otherAnimal) {
        if (otherAnimal != this) {
            if (otherAnimal instanceof EntityBoar || otherAnimal instanceof PigEntity) {
                if (otherAnimal.isInLove() && this.isInLove()) {
                    return true;
                }
            }
        }

        return false;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.CARROT || stack.getItem() == Items.GOLDEN_CARROT;
    }

    @Override
    public int getVariantMax() {
        return 4;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return null;
    }

    @Override
    protected int[] getTypesFor(Set<BiomeDictionary.Type> types) {
        if(types.contains(Type.FOREST) && !types.contains(Type.CONIFEROUS)) {
            return new int[] {1, 2, 3};
        } else if(types.contains(Type.CONIFEROUS) && !types.contains(Type.SNOWY)) {
            return new int[] {1, 2, 3};
        } else if(types.contains(Type.CONIFEROUS) && types.contains(Type.SNOWY)) {
            return new int[] {1, 4};
        } else if(types.contains(Type.SNOWY) && !types.contains(Type.CONIFEROUS)) { 
            return new int[] {4};
        } else if(types.contains(Type.SAVANNA) || types.contains(Type.PLAINS)) {
            return new int[] {1, 2, 3};
        } else {
            return new int[] {1, 2, 3, 4};
        }
    }

    @Override
    protected EntityTypeContainer<? extends EntityAnimalWithTypes> getContainer() {
        return ModEntities.BOAR;
    }

    public static class BoarAIEatCrops extends MoveToBlockGoal {
        private final EntityBoar boar;
        private boolean wantsToRaid;
        private boolean canRaid;

        public BoarAIEatCrops(EntityBoar boarIn) {
            super(boarIn, 0.699999988079071D, 16);
            this.boar = boarIn;
        }

        @Override
        public boolean shouldExecute() {
            if(this.runDelay <= 0) {
                if(!net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.boar.world, this.boar)) {
                    return false;
                }

                this.canRaid = false;
                this.wantsToRaid = !this.boar.isInLove();
            }

            return super.shouldExecute();
        }

        @Override
        public boolean shouldContinueExecuting() {
            return this.canRaid && super.shouldContinueExecuting();
        }

        @Override
        public void tick() {
            super.tick();
            this.boar.getLookController().setLookPosition((double) this.destinationBlock.getX() + 0.5D, (double) (this.destinationBlock.getY() + 1), (double) this.destinationBlock.getZ() + 0.5D, 10.0F, (float) this.boar.getVerticalFaceSpeed());

            if(this.getIsAboveDestination()) {
                World world = this.boar.world;
                BlockPos blockpos = this.destinationBlock.up();
                BlockState iblockstate = world.getBlockState(blockpos);
                Block block = iblockstate.getBlock();

                if(this.canRaid && block instanceof CropsBlock && ((CropsBlock) block).isMaxAge(iblockstate)) {
                    world.setBlockState(blockpos, Blocks.AIR.getDefaultState(), 2);
                    world.destroyBlock(blockpos, true);
                    boar.setInLove(null);
                }

                this.canRaid = false;
                this.runDelay = 10;
            }
        }

        @Override
        protected boolean shouldMoveTo(IWorldReader worldIn, BlockPos pos) {
            Block block = worldIn.getBlockState(pos).getBlock();

            if(block == Blocks.FARMLAND && this.wantsToRaid && !this.canRaid) {
                pos = pos.up();
                BlockState iblockstate = worldIn.getBlockState(pos);
                block = iblockstate.getBlock();

                if(block instanceof CropsBlock && ((CropsBlock) block).isMaxAge(iblockstate)) {
                    this.canRaid = true;
                    return true;
                }
            }

            return false;
        }
    }

}
