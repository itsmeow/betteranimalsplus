package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIEatGrassCustom;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityTypeContainer;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityMoose extends EntityAnimalEatsGrassWithTypes {

    public EntityMoose(World worldIn) {
        super(ModEntities.MOOSE.entityType, worldIn, 5);
    }
    
    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new RandomWalkingGoal(this, 0.55D));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 0.65D, false));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, 75, true, true, e -> e.getDistance(this) < 15));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(52.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.5D);
    }
    
    protected EntityAIEatGrassCustom provideEatTask() {
        return new EntityAIEatGrassCustom(this, 50, 50, eater -> {
            Direction facing = eater.getHorizontalFacing();
            return eater.getPosition().offset(facing).offset(facing);
        });
    }
    
    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        Vec3d pos = this.getPositionVector();
        Vec3d targetPos = entityIn.getPositionVector();
        ((LivingEntity) entityIn).knockBack(entityIn, 1F, pos.x - targetPos.x, pos.z - targetPos.z);
        float f = (float) this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getValue();
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        if (!world.isRemote && !this.isChild()) {
            if (this.rand.nextInt(12) == 0) {
                ItemStack stack = new ItemStack(HeadTypes.MOOSEHEAD.getItem(this.getTypeNumber()));
                this.entityDropItem(stack, 0.5F);
            }
        }
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
    protected EntityTypeContainer<? extends EntityAnimalWithTypes> getContainer() {
        return ModEntities.MOOSE;
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        int validTypes[] = {1, 2, 3, 4};
        return this.initData(super.onInitialSpawn(world, difficulty, reason, livingdata, compound), getBiasedRandomType(validTypes));
    }

    private int getBiasedRandomType(int[] validTypes) {
        int r = validTypes[this.getRNG().nextInt(validTypes.length)];
        if(r > 2) {
            r = validTypes[this.getRNG().nextInt(validTypes.length)];
        }
        if(r > 2) {
            r = validTypes[this.getRNG().nextInt(validTypes.length)];
        }
        return r;
    }

}
