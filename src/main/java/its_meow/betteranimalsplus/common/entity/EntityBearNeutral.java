package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.IVariant;
import dev.itsmeow.imdlib.entity.util.IVariantTypes;
import its_meow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import its_meow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import javax.annotation.Nullable;

public class EntityBearNeutral extends EntityBear implements IVariantTypes<EntityBear> {

    public EntityBearNeutral(World worldIn) {
        super(ModEntities.BLACK_BEAR.entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BearMeleeAttackGoal());
        this.goalSelector.addGoal(2, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new EntityAIEatBerries(this, 1.0D, 12, 2));
        this.targetSelector.addGoal(1, new BearHurtByTargetGoal());
        this.targetSelector.addGoal(2, new AttackPlayerGoal());
        this.goalSelector.addGoal(5, new RandomWalkingGoal(this, 0.5D));
        this.goalSelector.addGoal(6, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, ChickenEntity.class, true));
        this.targetSelector.addGoal(4, new HungerNearestAttackableTargetGoal<>(this, RabbitEntity.class, true));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, EntityPheasant.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(4, new HungerNearestAttackableTargetGoal<>(this, FoxEntity.class, 90, true, true, e -> true));
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.SALMON || stack.getItem() == Items.COOKED_SALMON || stack.getItem() == Items.HONEYCOMB;
    }

    @Override
    @Nullable
    public ILivingEntityData onInitialSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, @Nullable ILivingEntityData livingdata, CompoundNBT compound) {
        this.setInitialHunger();
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
    public EntityTypeContainer<EntityBearNeutral> getContainer() {
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
    public AgeableEntity func_241840_a(ServerWorld world, AgeableEntity ageable) {
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
