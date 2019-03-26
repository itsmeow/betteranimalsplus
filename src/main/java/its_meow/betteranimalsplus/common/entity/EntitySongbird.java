package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLeaves;
import net.minecraft.block.BlockLog;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWanderAvoidWaterFlying;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityFlyHelper;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNavigateFlying;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntitySongbird extends EntityAnimalWithTypes implements IFlyingAnimal {

    private static final Set<Item> SEEDS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS,
            Items.BEETROOT_SEEDS);

    public EntitySongbird(World worldIn) {
        super(ModEntities.getEntityType(EntitySongbird.class), worldIn);
        this.setSize(0.5F, 0.5F);
        this.moveHelper = new EntityFlyHelper(this);
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIPanic(this, 1.25D));
        Predicate<Entity> avoidPredicate = input -> {
            boolean result1 = (input instanceof EntityPlayer);
            boolean result2 = !SEEDS.contains(((EntityPlayer) input).getHeldItem(EnumHand.MAIN_HAND).getItem())
                    && !SEEDS.contains(((EntityPlayer) input).getHeldItem(EnumHand.OFF_HAND).getItem());
            return result1 && result2;
        };
        this.tasks.addTask(2, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, avoidPredicate, 10F, 0.8D,
                1D, Predicates.alwaysTrue()));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(4, new EntityAIMate(this, 0.4F));
        this.tasks.addTask(5, new EntityAIWanderAvoidWaterFlying(this, 1.0D));
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
            return block instanceof BlockLeaves || block == Blocks.GRASS || block instanceof BlockLog
                    || block == Blocks.AIR && this.world.getLight(blockpos) > 8 && super.canSpawn(world, b);
        } else {
            return super.canSpawn(world, b);
        }
    }

    @Override
    protected PathNavigate createNavigator(World worldIn) {
        PathNavigateFlying pathnavigateflying = new PathNavigateFlying(this, worldIn);
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
    protected void updateFallState(double y, boolean onGroundIn, IBlockState state, BlockPos pos) {
    }

    @Override
    protected void playStepSound(BlockPos pos, IBlockState state) {
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
    public boolean canMateWith(EntityAnimal otherAnimal) {
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
