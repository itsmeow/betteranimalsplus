package its_meow.betteranimalsplus.common.entity;

import net.minecraft.world.World;

public class EntityFreshwaterEel extends EntityEelBase {

    public EntityFreshwaterEel(World worldIn) {
        super(worldIn);
        this.setSize(1F, 1F);
    }

    @Override
    public int getVariantMax() {
        return 2;
    }

    @Override
    protected String getContainerName() {
        return "eel_freshwater";
    }
}
