package its_meow.betteranimalsplus.common.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.EntityAIEatGrass;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public abstract class EntityAnimalEatsGrassWithTypes extends EntityAnimalWithTypes {

	public final int taskPriority;
	private EntityAIEatGrass eatTask = null;
	public int eatTimer;

	public EntityAnimalEatsGrassWithTypes(EntityType<? extends Entity> entityType, World worldIn, int taskPriority) {
		super(entityType, worldIn);
		this.taskPriority = taskPriority;
	}

	public int getEatTime() {
		return eatTimer;
	}

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
	protected void initEntityAI() {
		super.initEntityAI();
		this.tasks.addTask(taskPriority, this.eatTask = new EntityAIEatGrass(this));
	}

}
