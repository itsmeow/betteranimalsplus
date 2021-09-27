package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.itsmeow.betteranimalsplus.common.entity.EntityGoose;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.minecraft.core.Position;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class EntityGooseEgg extends EntityModEgg {
    public static EntityType<EntityGooseEgg> GOOSE_EGG_TYPE = ModEntities.H.createEntityType(EntityGooseEgg::new, "goose_egg", MobCategory.MISC, 64, 1, true, 0.25F, 0.25F);

    public EntityGooseEgg(Level world) {
        super(GOOSE_EGG_TYPE, world);
    }

    public EntityGooseEgg(EntityType<? extends EntityGooseEgg> type, Level world) {
        super(type, world);
    }

    public EntityGooseEgg(Level world, LivingEntity thrower) {
        super(GOOSE_EGG_TYPE, world, thrower);
    }

    public EntityGooseEgg(Level world, double x, double y, double z) {
        super(GOOSE_EGG_TYPE, world, x, y, z);
    }

    public EntityGooseEgg(Level worldIn, Position pos) {
        super(GOOSE_EGG_TYPE, worldIn, pos.x(), pos.y(), pos.z());
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.GOOSE_EGG.get();
    }

    @Override
    protected Entity createEntity() {
        EntityGoose goose = ModEntities.GOOSE.getEntityType().create(this.level);
        goose.setAge(-24000);
        goose.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0.0F);
        goose.setType("1");
        return goose;
    }

}
