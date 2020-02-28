package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityCrabLikeBase;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.entity.ai.goal.RandomWalkingGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ResourceLocation;
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
    protected ResourceLocation getLootTable() {
        return null;
    }

    @Override
    public EntityTypeContainer<EntityHorseshoeCrab> getContainer() {
        return ModEntities.HORSESHOE_CRAB;
    }

}
