package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.util.EntityTypeContainer;
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
    public int getVariantMax() {
        return 3;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityHorseshoeCrab(world);
    }
    
    @Override
    protected ResourceLocation getLootTable() {
        return null;
    }

    @Override
    protected EntityTypeContainer<? extends EntityAnimalWithTypes> getContainer() {
        return ModEntities.HORSESHOE_CRAB;
    }

}
