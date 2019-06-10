package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.*;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.block.Blocks;
import net.minecraft.item.Items;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntitySongbird extends EntityAnimalWithTypes implements IFlyingAnimal {

    protected static final Set<Item> SEEDS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);

    public EntitySongbird(World worldIn) {
        super(ModEntities.getEntityType(EntitySongbird.class), worldIn);
        this.setSize(0.5F, 0.5F);
        this.moveHelper = new FlyingMovementController(this);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new SwimGoal(this));
        this.tasks.addTask(1, new PanicGoal(this, 1.25D));
        Predicate<Entity> avoidPredicate = input -> {
            boolean result1 = (input instanceof PlayerEntity);
            boolean result2 = !SEEDS.contains(((PlayerEntity) input).getHeldItem(Hand.MAIN_HAND).getItem())
                    && !SEEDS.contains(((PlayerEntity) input).getHeldItem(Hand.OFF_HAND).getItem());
            return result1 && result2;
        };
        this.tasks.addTask(2, new AvoidEntityGoal<PlayerEntity>(this, PlayerEntity.class, avoidPredicate, 10F, 0.8D,
                1D, Predicates.alwaysTrue()));
        this.tasks.addTask(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.tasks.addTask(4, new BreedGoal(this, 0.4F));
        this.tasks.addTask(5, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED);
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(6.0D);
        this.getAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.4D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.2D);
    }

    @Override
    public boolean canSpawn(IWorld world, boolean b) {
        int i = MathHelper.floor(this.posX);
        int j = MathHelper.floor(this.getBoundingBox().minY);
        int k = MathHelper.floor(this.posZ);
        BlockPos blockpos = new BlockPos(i, j, k);
        if(!world.isBlockLoaded(new BlockPos(blockpos))) {
            Block block = this.world.getBlockState(blockpos.down()).getBlock();
            return block instanceof LeavesBlock || block == Blocks.GRASS || block instanceof LogBlock
                    || block == Blocks.AIR && this.world.getLight(blockpos) > 8 && super.canSpawn(world, b);
        } else {
            return super.canSpawn(world, b);
        }
    }

    @Override
    protected PathNavigator createNavigator(World worldIn) {
        FlyingPathNavigator pathnavigateflying = new FlyingPathNavigator(this, worldIn);
        pathnavigateflying.setCanOpenDoors(false);
        pathnavigateflying.setCanSwim(true);
        pathnavigateflying.setCanEnterDoors(true);
        return pathnavigateflying;
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return SEEDS.contains(stack.getItem());
    }

    @Override
    public void fall(float distance, float damageMultiplier) {
    }

    @Override
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_PARROT_STEP, 0.15F, 1.0F);
    }

    @Override
    protected float playFlySound(float p_191954_1_) {
        this.playSound(SoundEvents.ENTITY_PARROT_FLY, 0.15F, 1.0F);
        return p_191954_1_;
    }

    @Override
    protected boolean makeFlySound() {
        return true;
    }

    @Override
    public SoundCategory getSoundCategory() {
        return SoundCategory.NEUTRAL;
    }

    @Override
    public boolean canBePushed() {
        return true;
    }

    public boolean isFlying() {
        return !this.onGround;
    }

    @Override
    public boolean canMateWith(AnimalEntity otherAnimal) {
        if (super.canMateWith(otherAnimal)) {
            if (!(otherAnimal instanceof EntitySongbird)) {
                return false;
            }
            return ((EntitySongbird) otherAnimal).getTypeNumber() == this.getTypeNumber();
        }
        return false;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.songbird;
    }

    @Override
    public int getVariantMax() {
        return 9;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntitySongbird(this.world);
    }

}
