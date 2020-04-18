package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.common.entity.EntityTurkey;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityTurkeyEgg extends EntityModEgg {
    public static EntityType<EntityTurkeyEgg> TURKEY_EGG_TYPE = ModEntities.<EntityTurkeyEgg>createEntityType(EntityTurkeyEgg.class, EntityTurkeyEgg::new, "turkey_egg", EntityClassification.MISC, 64, 1, true, 0.25F, 0.25F);
    
    public EntityTurkeyEgg(World world) {
        super(TURKEY_EGG_TYPE, world);
    }
    
    public EntityTurkeyEgg(EntityType<? extends EntityTurkeyEgg> type, World world) {
        super(type, world);
    }

    public EntityTurkeyEgg(World world, LivingEntity thrower) {
        super(TURKEY_EGG_TYPE, world, thrower);
    }

    public EntityTurkeyEgg(World world, double x, double y, double z) {
        super(TURKEY_EGG_TYPE, world, x, y, z);
    }

    public EntityTurkeyEgg(World worldIn, IPosition pos) {
        super(TURKEY_EGG_TYPE, worldIn, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.TURKEY_EGG;
    }

    @Override
    protected Entity createEntity() {
        EntityTurkey turkey = ModEntities.TURKEY.entityType.create(this.world);
        turkey.setGrowingAge(-24000);
        turkey.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
        turkey.setType(turkey.getRandomType());
        return turkey;
    }

}
