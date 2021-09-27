package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.itsmeow.betteranimalsplus.common.entity.EntityTurkey;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.minecraft.core.Position;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class EntityTurkeyEgg extends EntityModEgg {
    public static EntityType<EntityTurkeyEgg> TURKEY_EGG_TYPE = ModEntities.H.createEntityType(EntityTurkeyEgg::new, "turkey_egg", MobCategory.MISC, 64, 1, true, 0.25F, 0.25F);
    
    public EntityTurkeyEgg(Level world) {
        super(TURKEY_EGG_TYPE, world);
    }
    
    public EntityTurkeyEgg(EntityType<? extends EntityTurkeyEgg> type, Level world) {
        super(type, world);
    }

    public EntityTurkeyEgg(Level world, LivingEntity thrower) {
        super(TURKEY_EGG_TYPE, world, thrower);
    }

    public EntityTurkeyEgg(Level world, double x, double y, double z) {
        super(TURKEY_EGG_TYPE, world, x, y, z);
    }

    public EntityTurkeyEgg(Level worldIn, Position pos) {
        super(TURKEY_EGG_TYPE, worldIn, pos.x(), pos.y(), pos.z());
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.TURKEY_EGG.get();
    }

    @Override
    protected Entity createEntity() {
        EntityTurkey turkey = ModEntities.TURKEY.getEntityType().create(this.level);
        turkey.setAge(-24000);
        turkey.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0.0F);
        turkey.setType(turkey.getRandomType());
        return turkey;
    }

}
