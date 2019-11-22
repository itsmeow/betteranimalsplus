package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.common.entity.EntityTurkey;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityTurkeyEgg extends EntityModEgg {

    public EntityTurkeyEgg(World worldIn) {
        super(worldIn);
    }

    public EntityTurkeyEgg(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityTurkeyEgg(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public Item getEggItem() {
        return ModItems.TURKEY_EGG;
    }

    public Entity createEntity() {
        EntityTurkey entity = new EntityTurkey(this.world);
        entity.setGrowingAge(-24000);
        entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        entity.setType(entity.getRandomType());
        return entity;
    }

}
