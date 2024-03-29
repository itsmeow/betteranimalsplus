package dev.itsmeow.betteranimalsplus.common.entity.util.abstracts;

import dev.itsmeow.betteranimalsplus.common.entity.ai.EntityAIEatGrassCustom;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.level.Level;

public abstract class EntityAnimalEatsGrassWithTypes extends EntityAnimalWithTypes {

	public final int taskPriority;
	private EntityAIEatGrassCustom eatTask = null;
	public int eatTimer;

	public EntityAnimalEatsGrassWithTypes(EntityType<? extends Animal> entityType, Level worldIn, int taskPriority) {
		super(entityType, worldIn);
		this.taskPriority = taskPriority;
	}

	public int getEatTime() {
		return eatTimer;
	}

	@Override
    @Environment(EnvType.CLIENT)
	public void handleEntityEvent(byte id) {
		if (id == 10) {
			this.eatTimer = 40;
		} else {
			super.handleEntityEvent(id);
		}
	}
	
    @Override
    public void aiStep() {
        super.aiStep();
        if (this.level.isClientSide) {
            this.eatTimer = Math.max(0, this.eatTimer - 1);
        }
    }
    
    @Override
    public void ate() {
        super.ate();
        this.ageUp(60);
    }
    
    @Override
    public void customServerAiStep() {
        if(this.eatTask != null) {
            this.eatTimer = this.eatTask.getEatingGrassTimer();
        }
        super.customServerAiStep();
    }

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(taskPriority, this.eatTask = this.provideEatTask());
	}
	
	protected EntityAIEatGrassCustom provideEatTask() {
	    return new EntityAIEatGrassCustom(this, 200, 1000);
	}

}
