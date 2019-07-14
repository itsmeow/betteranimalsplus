package its_meow.betteranimalsplus.common.entity;

import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityHorseshoeCrab extends EntityCrabLikeBase {

    public EntityHorseshoeCrab(World world) {
        super(world);
        this.setSize(1F, 0.65F);
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(1, new EntityAIAvoidEntity<EntityPlayer>(this, EntityPlayer.class, 20F, 0.4F, 0.55F));
        this.tasks.addTask(2, new EntityAIWander(this, 0.3D));
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

}
