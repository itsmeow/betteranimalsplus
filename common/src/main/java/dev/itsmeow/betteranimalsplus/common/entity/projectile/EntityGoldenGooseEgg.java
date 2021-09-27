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

public class EntityGoldenGooseEgg extends EntityModEgg {
    public static EntityType<EntityGoldenGooseEgg> GOLDEN_GOOSE_EGG_TYPE = ModEntities.H.createEntityType(EntityGoldenGooseEgg::new, "golden_goose_egg", MobCategory.MISC, 64, 1, true, 0.25F, 0.25F);

    public EntityGoldenGooseEgg(Level world) {
        super(GOLDEN_GOOSE_EGG_TYPE, world);
    }

    public EntityGoldenGooseEgg(EntityType<? extends EntityGoldenGooseEgg> type, Level world) {
        super(type, world);
    }

    public EntityGoldenGooseEgg(Level world, LivingEntity thrower) {
        super(GOLDEN_GOOSE_EGG_TYPE, world, thrower);
    }

    public EntityGoldenGooseEgg(Level world, double x, double y, double z) {
        super(GOLDEN_GOOSE_EGG_TYPE, world, x, y, z);
    }

    public EntityGoldenGooseEgg(Level worldIn, Position pos) {
        super(GOLDEN_GOOSE_EGG_TYPE, worldIn, pos.x(), pos.y(), pos.z());
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.GOLDEN_GOOSE_EGG.get();
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
