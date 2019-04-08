package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.projectile.EntityBadgerDirt;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumDifficulty;
import net.minecraft.world.World;

public class EntityBadger extends EntityAnimalWithTypes implements IMob {

    protected static final DataParameter<Integer> DIG_OFFSET = EntityDataManager.<Integer>createKey(EntityBadger.class, DataSerializers.VARINT);

    public EntityBadger(World worldIn) {
        super(worldIn);
        this.setSize(0.8F, 0.8F);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        if (!this.isChild() && this.getEntityWorld().getDifficulty() != EnumDifficulty.PEACEFUL) {
            this.tasks.addTask(1, new EntityAIBadgerDigDirtThrow(this));
            this.tasks.addTask(2, new EntityAIAttackMelee(this, 0.5D, true));
        }
        this.tasks.addTask(3, new EntityAIWander(this, 0.4D));
        this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));
        if (!this.isChild() && this.getEntityWorld().getDifficulty() != EnumDifficulty.PEACEFUL) {
            this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true, new Class[0]));
            this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityAnimal>(this, EntityAnimal.class, 90, true, true, (@Nullable Entity in) -> in instanceof EntityChicken || in instanceof EntityPheasant || (in instanceof EntityAnimal && ((EntityAnimal) in).isChild() && !(in instanceof EntityBadger))));
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(12.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
    }

    protected void entityInit() {
        super.entityInit();
        this.dataManager.register(DIG_OFFSET, 0);
    }

    public int getDigOffset() {
        return this.dataManager.get(DIG_OFFSET).intValue();
    }

    public void setDigOffset(int dig) {
        this.dataManager.set(DIG_OFFSET, Integer.valueOf(dig));
    }

    @Override
    public int getVariantMax() {
        return 3;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityBadger(this.world);
    }

    public static class EntityAIBadgerDigDirtThrow extends EntityAIBase {

        private final EntityBadger badger;
        public int tick = 0;
        private int stateId = -1;

        public EntityAIBadgerDigDirtThrow(EntityBadger badger) {
            this.badger = badger;
            this.setMutexBits(3);
        }

        @Override
        public boolean shouldExecute() {
            World world = badger.world;
            BlockPos below = badger.getPosition().down();
            if(world.isBlockLoaded(below)) {
                IBlockState state = world.getBlockState(below);
                return badger.getRevengeTarget() != null && badger.getAttackTarget() == badger.getRevengeTarget() && (state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.GRAVEL || state.getBlock() == Blocks.MYCELIUM);
            } else {
                return false;
            }
        }

        @Override
        public boolean shouldContinueExecuting() {
            boolean onDiggable = false;
            World world = badger.world;
            BlockPos below = badger.getPosition().down();
            if(world.isBlockLoaded(below)) {
                IBlockState state = world.getBlockState(below);
                if(state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.GRAVEL || state.getBlock() == Blocks.MYCELIUM) {
                    if(state.getBlock() == Blocks.GRASS) {
                        state = Blocks.DIRT.getDefaultState();
                    }
                    stateId = Block.getStateId(state);
                    onDiggable = true;
                }
            }
            return badger.getRevengeTarget() != null && badger.getAttackTarget() == badger.getRevengeTarget() && tick <= 240 && onDiggable;
        }

        @Override
        public void startExecuting() {
            World world = badger.world;
            BlockPos below = badger.getPosition().down();
            if(world.isBlockLoaded(below)) {
                IBlockState state = world.getBlockState(below);
                if(state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.SAND || state.getBlock() == Blocks.GRAVEL || state.getBlock() == Blocks.MYCELIUM) {
                    if(state.getBlock() == Blocks.GRASS) {
                        state = Blocks.DIRT.getDefaultState();
                    }
                    stateId = Block.getStateId(state);
                    tick = 1;
                    badger.setDigOffset(tick);          
                }
            }
        }

        @Override
        public void updateTask() {
            tick++;
            badger.setDigOffset(tick);
            EntityLivingBase t = badger.getAttackTarget();             
            if(tick % 20 == 0) { // Throw dirt every second (20 ticks)
                EntityBadgerDirt proj = new EntityBadgerDirt(badger.world, badger, stateId);
                proj.setLocationAndAngles(badger.posX, badger.posY + 1, badger.posZ, 0, 0);
                double d0 = t.posY + t.getEyeHeight() - 1.100000023841858D;
                double d1 = t.posX - badger.posX;
                double d2 = d0 - proj.posY;
                double d3 = t.posZ - badger.posZ;
                float f = MathHelper.sqrt(d1 * d1 + d3 * d3) * 0.2F;
                proj.shoot(d1, d2 + f, d3, 0.6F, 4.8F);
                badger.playSound(SoundEvents.BLOCK_GRASS_BREAK, 1.0F, 1.0F / (badger.getRNG().nextFloat() * 0.4F + 0.8F));
                badger.world.spawnEntity(proj);
            }
            if(tick % 5 == 0) {
                badger.playSound(SoundEvents.BLOCK_GRASS_BREAK, 1.0F, 1.0F / (badger.getRNG().nextFloat() * 0.4F + 0.8F));
            }
        }

        @Override
        public void resetTask() {
            tick = 0;
            badger.setDigOffset(tick);
        }

    }

}