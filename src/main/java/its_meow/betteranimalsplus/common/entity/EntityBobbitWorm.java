package its_meow.betteranimalsplus.common.entity;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.RandomPositionGenerator;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateSwimmer;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class EntityBobbitWorm extends EntityAnimalWithTypes {

    protected static final DataParameter<Integer> ATTACK_STATE = EntityDataManager.<Integer>createKey(EntityBobbitWorm.class, DataSerializers.VARINT);
    private float lastAttack = 0;
    private float lastGrab = 0;
    private Vec3d targetPosition;

    public EntityBobbitWorm(World world) {
        super(world);
        this.setSize(1F, 1F);
        this.setPathPriority(PathNodeType.WATER, 10F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAIWatchClosest(this, EntityLivingBase.class, 10.0F));
        Set<Class<? extends EntityLivingBase>> blackList = new HashSet<Class<? extends EntityLivingBase>>();
        blackList.add(EntitySkeleton.class);
        blackList.add(EntityEnderman.class);
        blackList.add(EntityHirschgeist.class);
        blackList.add(EntityJellyfish.class);
        this.targetTasks.addTask(0, new EntityAINearestAttackableTarget<EntityLivingBase>(this, EntityLivingBase.class, 0, true, true, e -> e.width < 3 && !(e instanceof IMob) && !(e instanceof EntityBobbitWorm) && !blackList.contains(e.getClass())));
    }

    @Override
    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(ATTACK_STATE, 0);
    }

    public int getAttackState() {
        return this.dataManager.get(ATTACK_STATE);
    }

    public int setAttackState(int state) {
        this.dataManager.set(ATTACK_STATE, state);
        return state;
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(10D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        return entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue());
    }

    @Nullable
    protected Vec3d getNewTargetPosition() {
        Vec3d pos = RandomPositionGenerator.findRandomTarget(this, 20, 5);
        if(pos != null) {
            if(isGoodBurrowingPosition(new BlockPos(pos))) {
                return pos;
            }
        }
        if(world.getBlockState(this.getPosition().down()).getBlock() == Blocks.WATER) {
            return new Vec3d(this.getPosition().down());
        }
        return null;
    }

    public boolean isGoodBurrowingPosition(BlockPos pos) {
        Block below = world.getBlockState(pos.down()).getBlock();
        return (below == Blocks.CLAY || below == Blocks.SAND || below == Blocks.GRAVEL || below == Blocks.DIRT) && this.world.getBlockState(pos).getBlock() == Blocks.WATER;
    }

    @Override
    protected PathNavigate createNavigator(World worldIn) {
        return new PathNavigateSwimmer(this, worldIn);
    }

    public void travel(float strafe, float vertical, float forward) {
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
    }

    @Override
    public void updatePassenger(Entity passenger) {
        if(this.isPassenger(passenger)) {
            passenger.setPosition(this.posX, this.posY - (this.height / 2), this.posZ);
        }
    }

    @Override
    public boolean canRiderInteract() {
        return true;
    }

    @Override
    public boolean shouldRiderSit() {
        return false;
    }

    @Override
    public boolean shouldDismountInWater(Entity entity) {
        return false;
    }

    @Override
    public void onUpdate() {
        super.onUpdate();
        if(!this.inWater) {
            this.motionX *= 0.2F;
            this.motionZ *= 0.2F;
            if(!this.hasNoGravity()) {
                this.motionY -= 0.08D;
            }
            this.motionY *= 0.9800000190734863D;
        } else if(!world.isRemote) {
            if(this.targetPosition != null) {
                this.motionX = (this.targetPosition.x - this.posX) * 0.05F;
                this.motionY = (this.targetPosition.y - this.posY) * 0.05F;
                this.motionZ = (this.targetPosition.z - this.posZ) * 0.05F;
            }
            if(targetPosition != null && Math.sqrt(this.getPosition().distanceSq(this.targetPosition.x, this.targetPosition.y, this.targetPosition.z)) < 1) {
                this.motionX *= 0.2F;
                this.motionZ *= 0.2F;
            }
        }
        if(world.isRemote) { // shut up client stop MOVING you stupid idiot
            this.motionX *= 0.2F;
            this.motionZ *= 0.2F;
            this.motionY *= 0.2F;
        }
        boolean goodPos = this.isGoodBurrowingPosition(this.getPosition());
        if(this.targetPosition == null && !goodPos) {
            Vec3d pos = this.getNewTargetPosition();
            if(pos != null) {
                this.targetPosition = pos;
            }
        }
        if(targetPosition != null && Math.sqrt(this.getPosition().distanceSq(this.targetPosition.x, this.targetPosition.y, this.targetPosition.z)) < 1 && !goodPos) {
            this.targetPosition = null;
        }
        if(this.getAttackState() > 0) {
            this.setAttackState(this.getAttackState() - 1);
        }
        if(!this.world.isRemote && this.getAttackTarget() != null && !this.getAttackTarget().isDead && !this.isDead) {
            if(this.getPassengers().contains(this.getAttackTarget())) {
                float time = 30F;
                if(this.lastAttack + (time - 20) < this.ticksExisted) {
                    this.setAttackState(20);
                }
                if(this.lastAttack + time < this.ticksExisted) {
                    this.attackEntityAsMob(this.getAttackTarget());
                    this.lastAttack = this.ticksExisted;
                }
            } else if(lastGrab + 60F < this.ticksExisted && this.getDistanceSq(this.getAttackTarget()) < 5) {
                if(!this.getAttackTarget().getIsInvulnerable() && this.getAttackTarget().width < 2.5 && this.getAttackTarget().height < 2.5) {
                    this.getAttackTarget().startRiding(this, false);
                } else if(!this.getAttackTarget().getIsInvulnerable()) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
                lastGrab = this.ticksExisted;
            }
        }
    }

    @Override
    public boolean canBePushed() {
        return false;
    }

    @Override
    protected void collideWithNearbyEntities() {}

    public boolean canBreatheUnderwater() {
        return true;
    }

    public boolean getCanSpawnHere() {
        return this.posY > 45.0D && this.posY < (double) this.world.getSeaLevel();
    }

    public boolean isNotColliding() {
        return this.world.checkNoEntityCollision(this.getEntityBoundingBox(), this);
    }

    public int getTalkInterval() {
        return 120;
    }

    protected int getExperiencePoints(EntityPlayer player) {
        return 1 + this.world.rand.nextInt(3);
    }

    public void onEntityUpdate() {
        int i = this.getAir();
        super.onEntityUpdate();
        if(this.isEntityAlive() && !this.isInWater()) {
            --i;
            this.setAir(i);
            if(this.getAir() == -20) {
                this.setAir(0);
                this.attackEntityFrom(DamageSource.DROWN, 2.0F);
            }
        } else {
            this.setAir(300);
        }
    }

    public boolean isPushedByWater() {
        return false;
    }

    @Override
    public int getVariantMax() {
        return 2;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return null;
    }

    @Override
    protected String getContainerName() {
        return "bobbit_worm";
    }

}
