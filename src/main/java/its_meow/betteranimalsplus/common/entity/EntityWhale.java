package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.ai.BreatheAirGoal;
import its_meow.betteranimalsplus.common.entity.ai.EntityAIWanderWaterEntity;
import its_meow.betteranimalsplus.common.entity.ai.FindWaterGoal;
import its_meow.betteranimalsplus.config.BetterAnimalsPlusConfig;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Biomes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;

public class EntityWhale extends EntityWaterCreatureAirBreathingWithTypes {

    public int attacksLeft = 0;

    public EntityWhale(World world) {
        super(world);
        this.setSize(5F, 3F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new BreatheAirGoal(this));
        this.tasks.addTask(0, new FindWaterGoal(this));
        this.tasks.addTask(2, new WhaleMeleeAttackGoal(this));
        this.tasks.addTask(3, new EntityAIWanderWaterEntity(this, 1.0D, 2));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        this.tasks.addTask(5, new EntityAILookIdle(this));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false, new Class[0]));
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(2D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8D);
    }

    @Override
    public void setAir(int air) {
        if(air == 300 && this.world != null && this.isAddedToWorld() && this.world.loadedEntityList.contains(this) && !this.isInsideOfMaterial(Material.WATER)) {
            super.setAir(2400);
        } else {
            super.setAir(air);
        }
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.WHALE;
    }

    public boolean attackEntityAsMob(Entity entityIn) {
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) (this.getTypeNumber() == 3 ? this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue() : 1F));
        if(flag) {
            if(this.getTypeNumber() != 3) {
                if(attacksLeft > 0) {
                    attacksLeft--;
                }
                if(entityIn instanceof EntityPlayer) {
                    EntityPlayer player = (EntityPlayer) entityIn;
                    int ticks = 0;
                    if(this.world.getDifficulty() == EnumDifficulty.EASY) {
                        ticks = 50;
                    } else if(this.world.getDifficulty() == EnumDifficulty.NORMAL) {
                        ticks = 100;
                    } else if(this.world.getDifficulty() == EnumDifficulty.HARD) {
                        ticks = 140;
                    }
                    player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("slowness"), ticks, 1, false, false));
                    player.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("nausea"), ticks + 40, 1, false, false));
                }
            }
            Vec3d pos = this.getPositionVector();
            Vec3d targetPos = entityIn.getPositionVector();
            ((EntityLivingBase) entityIn).knockBack(this, this.getTypeNumber() == 3 ? 0.8F : 2F, pos.x - targetPos.x, pos.z - targetPos.z);
        }
        return flag;
    }

    @Override
    public int getVariantMax() {
        return 6;
    }

    @Override
    protected String getContainerName() {
        return "whale";
    }

    @Override
    @Nullable
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, @Nullable IEntityLivingData livingdata) {
        Biome biome = world.getBiome(this.getPosition());
        int validTypes[] = this.getTypesFor(biome, BiomeDictionary.getTypes(biome));
        return BetterAnimalsPlusConfig.biomeBasedVariants ? this.initData(super.onInitialSpawn(difficulty, livingdata), validTypes[this.getRNG().nextInt(validTypes.length)]) : this.initData(super.onInitialSpawn(difficulty, livingdata));
    }
    
    

    protected int[] getTypesFor(Biome biome, Set<BiomeDictionary.Type> types) {
        if(biome == Biomes.FROZEN_OCEAN) {
            return new int[] { 3, 2 };
        } else {
            return new int[] { 6, 4, 1, 5 };
        }
    }

    public static class WhaleMeleeAttackGoal extends EntityAIAttackMelee {

        private EntityWhale whale;

        public WhaleMeleeAttackGoal(EntityWhale whale) {
            super(whale, 1.2F, true);
            this.whale = whale;
        }

        @Override
        public void startExecuting() {
            if(whale.getTypeNumber() != 3) {
                whale.attacksLeft = 1;
            }
            super.startExecuting();
        }

        @Override
        public boolean shouldContinueExecuting() {
            return (whale.getTypeNumber() == 3 || whale.attacksLeft > 0) && super.shouldContinueExecuting();
        }

        @Override
        protected void checkAndPerformAttack(EntityLivingBase p_190102_1_, double p_190102_2_) {
            if(whale.attacksLeft > 0 || whale.getTypeNumber() == 3) {
                super.checkAndPerformAttack(p_190102_1_, p_190102_2_);
            } else {
                this.resetTask();
            }
        }

        @Override
        public void resetTask() {
            super.resetTask();
            if(whale.attacksLeft <= 0 && whale.getTypeNumber() != 3) {
                this.attacker.setAttackTarget(null);
                this.attacker.setRevengeTarget(null);
            }
        }

        @Override
        protected double getAttackReachSqr(EntityLivingBase attackTarget) {
            return (double) (this.attacker.width * this.attacker.width + attackTarget.width);
        }

    }

}
