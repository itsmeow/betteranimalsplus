package its_meow.betteranimalsplus.common.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.world.World;

public class EntitySaltwaterEel extends EntityEelBase {

    /* Client Animation Fields */
    public float lastBodyRotation = 0;
    public float body01 = 0;
    public float body02 = 0;
    public float body03 = 0;
    public float body04 = 0;
    public float body05 = 0;
    public float body06 = 0;
    /* Server Logic Fields */
    protected boolean isTargetForFood = false;

    public EntitySaltwaterEel(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, false, new Class[0]));
    }

    @Override
    public void setAttackTarget(EntityLivingBase entity) {
        if(entity != null && (this.getAttackTarget() == null || this.getAttackTarget() != entity)) {
            isTargetForFood = isHoldingFood(entity);
        }
        super.setAttackTarget(entity);
    }
    
    protected boolean shouldCheckTarget() {
        return isTargetForFood;
    }

    @Override
    public int getVariantMax() {
        return 5;
    }

    @Override
    protected String getContainerName() {
        return "eel_saltwater";
    }

}
