package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityCrabLikeBase;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;

public class EntityHorseshoeCrab extends EntityCrabLikeBase {

    private int bloodLeft = 5;

    public EntityHorseshoeCrab(EntityType<? extends EntityHorseshoeCrab> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 20F, 0.44F, 0.55F));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 0.3D));
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if(player.getItemInHand(hand).getItem() == Items.GLASS_BOTTLE & bloodLeft > 0) {
            this.hurt(DamageSource.playerAttack(player), 1.3F);
            this.bloodLeft--;
            if(this.bloodLeft == 0 && this.getHealth() >= 0F) {
                this.hurt(DamageSource.playerAttack(player), this.getHealth() * 10F);
            }
            player.getItemInHand(hand).shrink(1);
            player.addItem(new ItemStack(ModItems.HORSESHOE_CRAB_BLOOD.get()));
            return InteractionResult.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected EntityHorseshoeCrab getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
        this.bloodLeft = compound.getInt("BloodLeft");
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putInt("BloodLeft", this.bloodLeft);
    }

    @Override
    protected ResourceLocation getDefaultLootTable() {
        return null;
    }

    @Override
    public EntityTypeContainer<EntityHorseshoeCrab> getContainer() {
        return ModEntities.HORSESHOE_CRAB;
    }

}
