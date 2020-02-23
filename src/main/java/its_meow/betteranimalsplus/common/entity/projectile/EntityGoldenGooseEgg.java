package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.common.entity.EntityGoose;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityGoldenGooseEgg extends EntityModEgg {
    
    public EntityGoldenGooseEgg(World worldIn) {
        super(worldIn);
    }

    public EntityGoldenGooseEgg(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public EntityGoldenGooseEgg(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }

    public Item getEggItem() {
        return ModItems.GOLDEN_GOOSE_EGG;
    }

    public Entity createEntity() {
        EntityGoose entity = new EntityGoose(this.world);
        entity.setGrowingAge(-24000);
        entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, 0.0F);
        entity.setType(1); // white goose
        return entity;
    }

}
