package its_meow.betteranimalsplus.common.entity;


import javax.annotation.Nullable;

import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalEatsGrassWithTypes;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.BlockState;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.PanicGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.ai.goal.TemptGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class EntityDeer extends EntityAnimalEatsGrassWithTypes {

    public EntityDeer(World worldIn) {
        super(ModEntities.DEER.entityType, worldIn, 5);
    }

    public int getEatTime() {
        return eatTimer;
    }
    
    @OnlyIn(Dist.CLIENT)
    @Override
    public void handleStatusUpdate(byte id)
    {
        if (id == 10)
        {
            this.eatTimer = 40;
        }
        else
        {
            super.handleStatusUpdate(id);
        }
    }
    
    @Override
    public void baseTick() {
        super.baseTick();
        if (this.world.isRemote) {
            this.eatTimer = Math.max(0, this.eatTimer - 1);
        }
    }

    @Override
    public boolean processInteract(PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        boolean isEmpty = stack.isEmpty();
        if (!isEmpty) {
            if (stack.getItem() == Items.WHEAT || stack.getItem() == Items.CARROT) {
                this.setInLove(player);
            }
        }

        return super.processInteract(player, hand);
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 4;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 0.45D));
        this.goalSelector.addGoal(2, new PanicGoal(this, 0.65D));
        IItemProvider[] temptItems = new IItemProvider[5];
        temptItems[0] = Items.APPLE;
        temptItems[1] = Items.GOLDEN_APPLE;
        temptItems[2] = Items.CARROT;
        temptItems[3] = Items.CARROT_ON_A_STICK;
        temptItems[4] = Items.GOLDEN_CARROT;
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.45D, false, Ingredient.fromItems(temptItems)));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<PlayerEntity>(this, PlayerEntity.class, 20, 0.55D, 0.7D));
        // Eat Grass at Priority 5
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 0.45D));
        this.goalSelector.addGoal(6, new LookRandomlyGoal(this));
    }

    @Override
    public void eatGrassBonus() {
        super.eatGrassBonus();
        this.addGrowth(60);
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45D);
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        HeadTypes.DEERHEAD.drop(this, 12);
    }

    @Override
    @Nullable
    protected ResourceLocation getLootTable() {
        return ModLootTables.deer;
    }

    @Override
    protected EntityDeer getBaseChild() {
        return new EntityDeer(this.world);
    }

    @Override
    public EntityTypeContainer<EntityDeer> getContainer() {
        return ModEntities.DEER;
    }

}
