package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityCrabLikeBase;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;

public class EntityHorseshoeCrab extends EntityCrabLikeBase {

    private int bloodLeft = 5;

    public EntityHorseshoeCrab(EntityType<? extends EntityHorseshoeCrab> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, PlayerEntity.class, 20F, 0.44F, 0.55F));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.3D));
    }

    @Override
    public ActionResultType mobInteract(PlayerEntity player, Hand hand) {
        if(player.getItemInHand(hand).getItem() == Items.GLASS_BOTTLE & bloodLeft > 0) {
            this.hurt(DamageSource.playerAttack(player), 1.3F);
            this.bloodLeft--;
            if(this.bloodLeft == 0 && this.getHealth() >= 0F) {
                this.hurt(DamageSource.playerAttack(player), this.getHealth() * 10F);
            }
            player.getItemInHand(hand).shrink(1);
            player.addItem(new ItemStack(ModItems.HORSESHOE_CRAB_BLOOD.get()));
            return ActionResultType.SUCCESS;
        }
        return super.mobInteract(player, hand);
    }

    @Override
    protected EntityHorseshoeCrab getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public ILivingEntityData finalizeSpawn(IServerWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public void readAdditionalSaveData(CompoundNBT compound) {
        super.readAdditionalSaveData(compound);
        this.bloodLeft = compound.getInt("BloodLeft");
    }

    @Override
    public void addAdditionalSaveData(CompoundNBT compound) {
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
