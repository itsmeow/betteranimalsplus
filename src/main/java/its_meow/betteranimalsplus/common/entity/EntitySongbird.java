package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.collect.Sets;

import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithSelectiveTypes;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.FlyingMovementController;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.WaterAvoidingRandomFlyingGoal;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.pathfinding.FlyingPathNavigator;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Hand;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

public class EntitySongbird extends EntityAnimalWithSelectiveTypes implements IFlyingAnimal {

    protected static final Set<Item> SEEDS = Sets.newHashSet(Items.WHEAT_SEEDS, Items.MELON_SEEDS, Items.PUMPKIN_SEEDS, Items.BEETROOT_SEEDS);

    public EntitySongbird(World worldIn) {
        super(ModEntities.SONGBIRD.entityType, worldIn);
        this.moveController = new FlyingMovementController(this, 180, true);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new PanicGoal(this, 1.25D));
        Predicate<LivingEntity> avoidPredicate = input -> {
            boolean result1 = (input instanceof PlayerEntity);
            boolean result2 = !SEEDS.contains(((PlayerEntity) input).getHeldItem(Hand.MAIN_HAND).getItem())
                    && !SEEDS.contains(((PlayerEntity) input).getHeldItem(Hand.OFF_HAND).getItem());
            return result1 && result2;
        };
        this.goalSelector.addGoal(2, new AvoidEntityGoal<PlayerEntity>(this, PlayerEntity.class, avoidPredicate, 10F, 0.8D,
                1D, Predicates.alwaysTrue()));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 8.0F));
        this.goalSelector.addGoal(4, new BreedGoal(this, 0.4F));
        this.goalSelector.addGoal(5, new WaterAvoidingRandomFlyingGoal(this, 1.0D));
    }

    @Override
    public boolean canSpawn(IWorld world, SpawnReason reason) {
        int i = MathHelper.floor(this.getPosX());
        int j = MathHelper.floor(this.getBoundingBox().minY);
        int k = MathHelper.floor(this.getPosZ());
        BlockPos blockpos = new BlockPos(i, j, k);
        if(world instanceof World && !((World) world).isBlockPresent(new BlockPos(blockpos))) {
            Block block = this.world.getBlockState(blockpos.down()).getBlock();
            return block instanceof LeavesBlock || block == Blocks.GRASS || block.isIn(BlockTags.LOGS)
                    || block == Blocks.AIR && this.world.getLight(blockpos) > 8 && super.canSpawn(world, reason);
        } else {
            return super.canSpawn(world, reason);
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
    public boolean onLivingFall(float distance, float damageMultiplier) {
        return false;
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
            return !this.getVariantNameOrEmpty().isEmpty() && !((EntitySongbird) otherAnimal).getVariantNameOrEmpty().isEmpty() && ((EntitySongbird) otherAnimal).getVariantNameOrEmpty().equals(this.getVariantNameOrEmpty());
        }
        return false;
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.songbird;
    }

    @Override
    protected EntitySongbird getBaseChild() {
        return new EntitySongbird(this.world);
    }

    @Override
    public String[] getTypesFor(RegistryKey<Biome> biomeKey, Biome biome, Set<BiomeDictionary.Type> types, SpawnReason reason) {
        if(types.contains(Type.FOREST) && !types.contains(Type.CONIFEROUS)) {
            return new String[] {"2", "small_2", "small_3", "small_4"};
        } else if(types.contains(Type.CONIFEROUS) && !types.contains(Type.SNOWY)) {
            return new String[] {"1", "small_5", "small_6"};
        } else if(types.contains(Type.CONIFEROUS) && types.contains(Type.SNOWY)) {
            return new String[] {"3", "4", "small_1"};
        } else {
            return new String[] {"1", "2", "3", "4", "small_1", "small_2", "small_3", "small_4", "small_5", "small_6"};
        }
    }

    @Override
    public EntityTypeContainerBAP<EntitySongbird> getContainer() {
        return ModEntities.SONGBIRD;
    }

}
