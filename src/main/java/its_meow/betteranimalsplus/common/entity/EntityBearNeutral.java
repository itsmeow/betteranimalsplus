package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.base.Predicates;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.HurtByTargetGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityBearNeutral extends EntityBear implements IVariantTypes {

    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityBearNeutral.class, DataSerializers.VARINT);

    public EntityBearNeutral(World worldIn) {
        super(ModEntities.BLACK_BEAR.entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new EntityBearNeutral.AIMeleeAttack());
        this.goalSelector.addGoal(2, new EntityAIEatBerries(this, 1.0D, 12, 2));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, EntityBear.class));
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<ChickenEntity>(this, ChickenEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<RabbitEntity>(this, RabbitEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<EntityPheasant>(this, EntityPheasant.class, 90,
                true, true, Predicates.alwaysTrue()));
    }
    
    @Override
    public boolean isChildI() {
        return this.isChild();
    }

    @Override
    public Random getRNGI() {
        return this.getRNG();
    }

    @Override
    public EntityDataManager getDataManagerI() {
        return this.getDataManager();
    }

    @Override
    public int getVariantMax() {
        return 2;
    }

    @Override
    public DataParameter<Integer> getDataKey() {
        return TYPE_NUMBER;
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        int[] validTypes = {1, 2};
        return this.initData(super.onInitialSpawn(world, difficulty, reason, livingdata, compound), this.getBiasedRandomType(validTypes));
    }

    private int getBiasedRandomType(int[] validTypes) { // Double bias against kermode spawn
        int r = validTypes[this.getRNG().nextInt(validTypes.length)];
        if(validTypes.length > 1) { // No point if only a single possibility
            if(r == 2) {
                r = validTypes[this.getRNG().nextInt(validTypes.length)];
            }
            if(r == 2) {
                r = validTypes[this.getRNG().nextInt(validTypes.length)];
            }
        }
        return r;
    }
    
    @Override
    protected void registerData() {
        super.registerData();
        this.registerTypeKey();
    }

    @Override
    public boolean writeUnlessRemoved(CompoundNBT compound) {
        this.writeType(compound);
        return super.writeUnlessRemoved(compound);
    }

    @Override
    public void read(CompoundNBT compound) {
        super.read(compound);
        this.readType(compound);
    }

    @Override
    public void doDropHead() {
        if (!world.isRemote && !this.isChild()) {
            if (this.rand.nextInt(12) == 0) {
                ItemStack stack = new ItemStack(HeadTypes.BEARHEAD.getItem(this.getTypeNumber() + 1));
                this.entityDropItem(stack, 0.5F);
            }
        }
    }
    
    @Override
    protected ResourceLocation getLootTable() {
        switch(this.getTypeNumber()) {
        case 1: return ModLootTables.BEAR_BLACK;
        case 2: return ModLootTables.BEAR_KERMODE;
        default: return ModLootTables.BEAR_BLACK;
        }
    }
    
    @Override
    public boolean canDespawn(double range) {
        return ModEntities.BLACK_BEAR.despawn && !this.hasCustomName();
    }

}
