package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.itsmeow.betteranimalsplus.common.entity.EntityTurkey;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.minecraft.core.Position;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class EntityTurkeyEgg extends EntityModEgg {

    public EntityTurkeyEgg(EntityType<? extends EntityTurkeyEgg> type, Level world) {
        super(type, world);
    }

    public EntityTurkeyEgg(EntityType<? extends EntityTurkeyEgg> type, Level world, LivingEntity thrower) {
        super(type, world, thrower);
    }

    public EntityTurkeyEgg(EntityType<? extends EntityTurkeyEgg> type, Level world, double x, double y, double z) {
        super(type, world, x, y, z);
    }

    public EntityTurkeyEgg(EntityType<? extends EntityTurkeyEgg> type, Level worldIn, Position pos) {
        super(type, worldIn, pos.x(), pos.y(), pos.z());
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
