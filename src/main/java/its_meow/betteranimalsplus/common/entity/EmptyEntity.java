package its_meow.betteranimalsplus.common.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.world.World;

public class EmptyEntity extends EntityLiving {

    public EmptyEntity(World worldIn) {
        super(worldIn);
    }
    
    public void onUpdate() {
        super.onUpdate();
        this.setDead();
    }

}
