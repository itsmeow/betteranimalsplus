package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.itsmeow.betteranimalsplus.common.entity.EntityGoose;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.minecraft.core.Position;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class EntityGoldenGooseEgg extends EntityModEgg {

    public EntityGoldenGooseEgg(EntityType<? extends EntityGoldenGooseEgg> type, Level world) {
        super(type, world);
    }

    public EntityGoldenGooseEgg(EntityType<? extends EntityGoldenGooseEgg> type,Level world, LivingEntity thrower) {
        super(type, world, thrower);
    }

    public EntityGoldenGooseEgg(EntityType<? extends EntityGoldenGooseEgg> type,Level world, double x, double y, double z) {
        super(type, world, x, y, z);
    }

    public EntityGoldenGooseEgg(EntityType<? extends EntityGoldenGooseEgg> type,Level worldIn, Position pos) {
        super(type, worldIn, pos.x(), pos.y(), pos.z());
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.GOLDEN_GOOSE_EGG.get();
    }

    @Override
    protected Entity createEntity() {
        EntityGoose goose = ModEntities.GOOSE.getEntityType().create(this.level);
        goose.setAge(-24000);
        goose.moveTo(this.getX(), this.getY(), this.getZ(), this.getYRot(), 0.0F);
        goose.setType("1");
        return goose;
    }
}
