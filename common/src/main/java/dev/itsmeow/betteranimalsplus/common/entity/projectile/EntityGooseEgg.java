package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.itsmeow.betteranimalsplus.common.entity.EntityGoose;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityGooseEgg extends EntityModEgg {
    public static EntityType<EntityGooseEgg> GOOSE_EGG_TYPE = ModEntities.H.createEntityType(EntityGooseEgg::new, "goose_egg", EntityClassification.MISC, 64, 1, true, 0.25F, 0.25F);

    public EntityGooseEgg(World world) {
        super(GOOSE_EGG_TYPE, world);
    }

    public EntityGooseEgg(EntityType<? extends EntityGooseEgg> type, World world) {
        super(type, world);
    }

    public EntityGooseEgg(World world, LivingEntity thrower) {
        super(GOOSE_EGG_TYPE, world, thrower);
    }

    public EntityGooseEgg(World world, double x, double y, double z) {
        super(GOOSE_EGG_TYPE, world, x, y, z);
    }

    public EntityGooseEgg(World worldIn, IPosition pos) {
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
