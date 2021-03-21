package its_meow.betteranimalsplus.common.entity.util.abstracts;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIEatGrassCustom;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class EntityAnimalEatsGrassWithTypes extends EntityAnimalWithTypes {

	public final int taskPriority;
	private EntityAIEatGrassCustom eatTask = null;
	public int eatTimer;

	public EntityAnimalEatsGrassWithTypes(EntityType<? extends AnimalEntity> entityType, World worldIn, int taskPriority) {
		super(entityType, worldIn);
		this.taskPriority = taskPriority;
	}

	public int getEatTime() {
		return eatTimer;
	}

	@Override
    @OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 10) {
			this.eatTimer = 40;
		} else {
			super.handleStatusUpdate(id);
		}
	}
	
    @Override
    public void livingTick() {
        super.livingTick();
        if (this.world.isRemote) {
            this.eatTimer = Math.max(0, this.eatTimer - 1);
        }
    }
    
    @Override
    public void eatGrassBonus() {
        super.eatGrassBonus();
        this.addGrowth(60);
    }
    
    @Override
    public void updateAITasks() {
        if(this.eatTask != null) {
            this.eatTimer = this.eatTask.getEatingGrassTimer();
        }
        super.updateAITasks();
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
