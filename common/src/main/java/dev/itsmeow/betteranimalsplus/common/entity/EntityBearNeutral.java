package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.Ref;
import dev.itsmeow.betteranimalsplus.common.entity.ai.EntityAIEatBerries;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes;
import dev.itsmeow.imdlib.entity.util.variant.EntityVariant;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.entity.animal.Rabbit;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class EntityBearNeutral extends EntityBear implements IVariantTypes<EntityBear> {

    public EntityBearNeutral(EntityType<? extends EntityBearNeutral> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BearMeleeAttackGoal());
        this.goalSelector.addGoal(2, new BreedGoal(this, 1D));
        this.goalSelector.addGoal(2, new FollowParentGoal(this, 1.25D));
        this.goalSelector.addGoal(2, new EntityAIEatBerries(this, 1.0D, 12, 2));
        this.targetSelector.addGoal(1, new BearHurtByTargetGoal());
        this.targetSelector.addGoal(2, new AttackPlayerGoal());
        this.goalSelector.addGoal(5, new RandomStrollGoal(this, 0.5D));
        this.goalSelector.addGoal(6, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.targetSelector.addGoal(3, new HungerNearestAttackableTargetGoal<>(this, Chicken.class, true));
        this.targetSelector.addGoal(4, new HungerNearestAttackableTargetGoal<>(this, Rabbit.class, true));
        this.targetSelector.addGoal(5, new HungerNearestAttackableTargetGoal<>(this, EntityPheasant.class, 90, true, true, e -> true));
        this.targetSelector.addGoal(4, new HungerNearestAttackableTargetGoal<>(this, Fox.class, 90, true, true, e -> true));
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.getItem() == Items.SALMON || stack.getItem() == Items.COOKED_SALMON || stack.getItem() == Items.HONEYCOMB;
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        this.setInitialHunger();
        if(livingdata instanceof AgeableTypeData) {
            this.setAge(-24000);
            this.setType(((AgeableTypeData) livingdata).typeData);
        } else {
            livingdata = this.initAgeableData(world, reason, null);
        }
        return livingdata;
    }

    @Override
    public IVariant getRandomType() {
        return this.getContainer().getVariantForName(this.getRandom().nextFloat() <= 0.125F ? "kermode" : "black").orElse(IVariantTypes.super.getRandomType());
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.registerTypeKey();
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        this.writeType(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.readType(compound);
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
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
    public boolean removeWhenFarAway(double range) {
        return despawn(range);
    }

    @Override
    public AgeableMob getBreedOffspring(ServerLevel world, AgeableMob ageable) {
        EntityBearNeutral child = getContainer().getEntityType().create(world);
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

    public static class BlackBearVariant extends EntityVariant {

        private final ResourceLocation babyTexture;

        public BlackBearVariant(String nameTexture) {
            super(Ref.MOD_ID, nameTexture, "blackbear_" + nameTexture);
            this.babyTexture = new ResourceLocation(Ref.MOD_ID, "textures/entity/blackbear_" + nameTexture + "_baby.png");
        }

        @Override
        public ResourceLocation getTexture(Entity entity) {
            if(entity instanceof EntityBearNeutral && ((EntityBearNeutral) entity).isBaby()) {
                return babyTexture;
            }
            return super.getTexture(entity);
        }
    }
}
