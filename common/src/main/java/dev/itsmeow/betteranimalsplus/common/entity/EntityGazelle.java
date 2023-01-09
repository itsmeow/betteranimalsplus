package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.IDropHead;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalEatsGrassWithTypes;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;

public class EntityGazelle extends EntityAnimalEatsGrassWithTypes implements IDropHead<EntityAnimalWithTypes> {

    public EntityGazelle(EntityType<? extends EntityGazelle> entityType, Level level) {
        super(entityType, level, 6);
    }

    @Override
    public int getEatTime() {
        return eatTimer;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void handleEntityEvent(byte id) {
        if (id == 10) {
            this.eatTimer = 40;
        } else {
            super.handleEntityEvent(id);
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if (this.level.isClientSide) {
            this.eatTimer = Math.max(0, this.eatTimer - 1);
        }
    }

    @Override
    public boolean isFood(ItemStack stack) {
        Item i = stack.getItem();
        return i == Items.WHEAT || i == Items.CARROT || i == Items.GOLDEN_CARROT || i == Items.APPLE || i == Items.GOLDEN_APPLE;
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 4;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.SHEEP_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 0.45D));
        this.goalSelector.addGoal(2, new PanicGoal(this, 0.65D));
        ItemLike[] temptItems = new ItemLike[]{Items.APPLE, Items.GOLDEN_APPLE, Items.CARROT, Items.CARROT_ON_A_STICK, Items.GOLDEN_CARROT, Items.WHEAT};
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.45D, Ingredient.of(temptItems), false));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, Player.class, 20, 0.55D, 0.7D));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1D));
        // Eat Grass at Priority 6
        this.goalSelector.addGoal(6, new RandomStrollGoal(this, 0.45D));
        this.goalSelector.addGoal(7, new RandomLookAroundGoal(this));
    }

    @Override
    public void ate() {
        super.ate();
        this.ageUp(60);
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);
        this.doHeadDrop();
    }

    @Override
    protected EntityGazelle getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public EntityTypeContainer<EntityGazelle> getContainer() {
        return ModEntities.GAZELLE;
    }

}
