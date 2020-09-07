package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.common.entity.util.EntityUtil;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityCrabLikeBase;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

public class EntityHorseshoeCrab extends EntityCrabLikeBase {

    public EntityHorseshoeCrab(World world) {
        super(ModEntities.HORSESHOE_CRAB.entityType, world);
    }
    
    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new AvoidEntityGoal<PlayerEntity>(this, PlayerEntity.class, 20F, 0.44F, 0.55F));
        this.goalSelector.addGoal(2, new RandomWalkingGoal(this, 0.3D));
    }

    @Override
    protected EntityHorseshoeCrab getBaseChild() {
        return new EntityHorseshoeCrab(world);
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        EntityUtil.childChance(this, reason, livingdata, 0.25F);
        return super.onInitialSpawn(world, difficulty, reason, livingdata, compound);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return null;
    }

    @Override
    public EntityTypeContainerBAP<EntityHorseshoeCrab> getContainer() {
        return ModEntities.HORSESHOE_CRAB;
    }

}
