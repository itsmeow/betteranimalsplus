package its_meow.betteranimalsplus.common.entity;

import java.util.Random;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityShark extends EntitySharkBase implements IVariantTypes {

    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityShark.class, DataSerializers.VARINT);
    private float lastAttack = 0;
    private float lastGrab = 0;
    private float lastTickHealth = 0;

    public EntityShark(World world) {
        super(ModEntities.getEntityType("shark"), world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MoveTowardsTargetGoal(this, 0.8D, 40F));
        this.goalSelector.addGoal(1, new LookAtGoal(this, LivingEntity.class, 15F));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.55D));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 100, false, false, e -> !(e instanceof EntitySharkBase)));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.75D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if(!this.world.isRemote && this.getAttackTarget() != null && this.getAttackTarget().isAlive() && this.isAlive()) {
            boolean isBoat = this.getAttackTarget() instanceof PlayerEntity && this.getAttackTarget().getRidingEntity() != null && this.getAttackTarget().getRidingEntity() instanceof BoatEntity;
            float grabDelay = isBoat ? 20F : 60F;
            if(this.getPassengers().contains(this.getAttackTarget())) {
                float time = 80F;
                time *= 5F * (Math.random() + 1F);
                if(this.lastAttack + time < this.ticksExisted) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
            } else if(lastGrab + grabDelay < this.ticksExisted && this.getDistanceSq(this.getAttackTarget()) < 5) {
                if(isBoat) {
                    BoatEntity boat = (BoatEntity) this.getAttackTarget().getRidingEntity();
                    boat.attackEntityFrom(DamageSource.causeMobDamage(this), 3F);
                } else if(!this.getAttackTarget().isInvulnerable()){
                    this.getAttackTarget().startRiding(this, false);
                }
                lastGrab = this.ticksExisted;
            } else {
                this.getMoveHelper().setMoveTo(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 0.1D);
            }
            if(lastTickHealth - 4F > this.getHealth()) {
                this.getAttackTarget().dismountEntity(this.getRidingEntity());
            }
        }
        this.lastTickHealth = this.getHealth();
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
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        return this.initData(super.onInitialSpawn(world, difficulty, reason, livingdata, compound));
    }

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
    public DataParameter<Integer> getDataKey() {
        return TYPE_NUMBER;
    }

    @Override
    public int getVariantMax() {
        return 4;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.SHARK;
    }

}