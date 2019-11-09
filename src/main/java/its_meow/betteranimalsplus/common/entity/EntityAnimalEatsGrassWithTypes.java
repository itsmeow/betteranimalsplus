package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIEatGrassCustom;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public abstract class EntityAnimalEatsGrassWithTypes extends EntityAnimalWithTypes {

	public final int taskPriority;
	private EntityAIEatGrassCustom eatTask = null;
	public int eatTimer;

	public EntityAnimalEatsGrassWithTypes(World worldIn, int taskPriority) {
		super(worldIn);
		this.taskPriority = taskPriority;
	}

	public int getEatTime() {
		return eatTimer;
	}

	@SideOnly(Side.CLIENT)
	public void handleStatusUpdate(byte id) {
		if (id == 10) {
			this.eatTimer = 40;
		} else {
			super.handleStatusUpdate(id);
		}
	}
	
    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
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
		this.tasks.addTask(taskPriority, eatTask = this.provideEatTask());
	}
	
	protected EntityAIEatGrassCustom provideEatTask() {
	    return new EntityAIEatGrassCustom(this, 50, 500);
	}

}
