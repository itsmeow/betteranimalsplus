package its_meow.betteranimalsplus.common.entity;

import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.world.World;

public class EntityBadger extends EntityAnimalWithTypes {
    
    public EntityBadger(World worldIn) {
        super(ModEntities.getEntityType(EntityBadger.class), worldIn);
        this.setSize(0.8F, 0.8F);
    }

    @Override
    public int getVariantMax() {
        return 3;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityBadger(this.world);
    }
    


}