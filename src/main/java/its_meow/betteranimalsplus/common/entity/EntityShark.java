package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.util.EntityTypeContainer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.MoveTowardsTargetGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityShark extends EntitySharkBase {

    protected static final DataParameter<Integer> TYPE_NUMBER = EntityDataManager.<Integer>createKey(EntityShark.class, DataSerializers.VARINT);
    private float lastAttack = 0;
    private float lastGrab = 0;
    private float lastTickHealth = 0;
    public float lastBodyRotation = 0;

    public EntityShark(World world) {
        super(ModEntities.SHARK.entityType, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MoveTowardsTargetGoal(this, 0.8D, 40F));
        this.goalSelector.addGoal(1, new LookAtGoal(this, LivingEntity.class, 15F));
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 0.65D, 1));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<LivingEntity>(this, LivingEntity.class, 100, false, false, e -> {
            if(e instanceof EntitySharkBase || e instanceof EntityBobbitWorm) return false;
            if(e instanceof PlayerEntity) return shouldAttackForHealth(e.getHealth());
            return true;
        }));
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(super.attackEntityFrom(source, amount)) {
            if(source.getTrueSource() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) source.getTrueSource();
                if(!player.isCreative() && !player.isInvisible()) {
                    this.setAttackTarget(player);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.75D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
    }
    
    public boolean shouldAttackForHealth(float health) {
        int type = this.getTypeNumber();
        switch(type) {
        case 1: return health <= 8F;// blue
        case 2: return health <= 13F;// bull
        case 3: return health <= 10; // tiger
        case 4: return health <= 16F;// whitetip
        default: return false;
        }
    }

    @Override
    public void livingTick() {
        super.livingTick();
        if(this.getAttackTarget() != null && !this.getAttackTarget().isAlive()) {
            this.setAttackTarget(null);
        }
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
                } else if(!this.getAttackTarget().isInvulnerable() && this.getAttackTarget().getWidth() < 2.5 && this.getAttackTarget().getHeight() < 2.5) {
                    if (this.getAttackTarget() instanceof MobEntity) {
                        MobEntity el = (MobEntity) this.getAttackTarget();
                        el.setAttackTarget(null);
                        el.setRevengeTarget(null);
                        el.getNavigator().clearPath(); 
                        el.setNoAI(true);
                    }
                    this.getAttackTarget().startRiding(this, false);
                } else if(!this.getAttackTarget().isInvulnerable()) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
                lastGrab = this.ticksExisted;
            }
            if(lastTickHealth - 4F > this.getHealth()) {
                this.getAttackTarget().dismountEntity(this);
                if (this.getAttackTarget() instanceof MobEntity) {
                    MobEntity el = (MobEntity) this.getAttackTarget();
                    el.setNoAI(false);
                }
            }
        }
        this.lastTickHealth = this.getHealth();
    }

    @Override
    public int getVariantMax() {
        return 4;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.SHARK;
    }

    @Override
    protected EntityTypeContainer<? extends EntityWaterMobPathingWithTypes> getContainer() {
        return ModEntities.SHARK;
    }

}
