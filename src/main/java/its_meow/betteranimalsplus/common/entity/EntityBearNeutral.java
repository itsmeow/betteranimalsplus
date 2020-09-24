package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import com.google.common.base.Predicates;

import dev.itsmeow.imdlib.entity.util.IVariant;
import dev.itsmeow.imdlib.entity.util.IVariantTypes;
import its_meow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.BreedGoal;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityBearNeutral extends EntityBear implements IVariantTypes<EntityBear> {

    public EntityBearNeutral(World worldIn) {
        super(ModEntities.BLACK_BEAR.entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new EntityBear.MeleeAttackGoal());
        this.goalSelector.addGoal(2, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(2, new EntityAIEatBerries(this, 1.0D, 12, 2));
        this.targetSelector.addGoal(1, new EntityBear.HurtByTargetGoal());
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<ChickenEntity>(this, ChickenEntity.class, true));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<RabbitEntity>(this, RabbitEntity.class, true));
        this.targetSelector.addGoal(4, new NearestAttackableTargetGoal<EntityPheasant>(this, EntityPheasant.class, 90, true, true, Predicates.alwaysTrue()));
        this.targetSelector.addGoal(3, new NearestAttackableTargetGoal<FoxEntity>(this, FoxEntity.class, 90, true, true, Predicates.alwaysTrue()));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.SALMON || stack.getItem() == Items.COOKED_SALMON || stack.getItem() == Items.HONEYCOMB;
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        if(livingdata instanceof AgeableTypeData) {
            this.setGrowingAge(-24000);
            this.setType(((AgeableTypeData) livingdata).typeData);
        } else {
            livingdata = this.initAgeableData(world, reason, null);
        }
        return livingdata;
    }

    @Override
    public IVariant getRandomType() {
        return this.getContainer().getVariantForName(this.getRNG().nextFloat() <= 0.125F ? "kermode" : "black");
    }

    @Override
    protected void registerData() {
        super.registerData();
        this.registerTypeKey();
    }

    @Override
    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        this.writeType(compound);
    }

    @Override
    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.readType(compound);
    }

    @Override
    protected ResourceLocation getLootTable() {
        switch(this.getVariantNameOrEmpty()) {
        case "black":
            return ModLootTables.BEAR_BLACK;
        case "kermode":
            return ModLootTables.BEAR_KERMODE;
        default:
            return ModLootTables.BEAR_BLACK;
        }
    }

    @Override
    public EntityTypeContainerBAP<EntityBearNeutral> getContainer() {
        return ModEntities.BLACK_BEAR;
    }

    @Override
    public EntityBearNeutral getImplementation() {
        return this;
    }

    @Override
    public boolean canDespawn(double range) {
        return despawn(range);
    }

    @Override
    public AgeableEntity createChild(AgeableEntity ageable) {
        EntityBearNeutral child = new EntityBearNeutral(this.world);
        if(ageable instanceof EntityBearNeutral) {
            if("kermode".equals(((EntityBearNeutral) ageable).getVariantNameOrEmpty()) && "kermode".equals(this.getVariantNameOrEmpty())) {
                child.setType("kermode");
            } else {
                child.setType("black");
            }
        } else {
            child.setType(this.getVariant().orElseGet(this::getRandomType));
        }
        return child;
    }
}
