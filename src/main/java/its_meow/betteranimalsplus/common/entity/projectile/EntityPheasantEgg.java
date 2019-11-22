package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.common.entity.EntityPheasant;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityPheasantEgg extends EntityModEgg {

    public EntityPheasantEgg(World worldIn) {
        super(worldIn);
    }

    public EntityPheasantEgg(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityPheasantEgg(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public Item getEggItem() {
        return ModItems.PHEASANT_EGG;
    }

    public Entity createEntity() {
        EntityPheasant entity = new EntityPheasant(this.world);
        entity.setGrowingAge(-24000);
        entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        entity.setType(entity.getRandomType());
        return entity;
    }

}
