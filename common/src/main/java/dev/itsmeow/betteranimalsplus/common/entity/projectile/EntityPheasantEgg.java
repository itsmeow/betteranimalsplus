package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.itsmeow.betteranimalsplus.common.entity.EntityPheasant;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.minecraft.core.Position;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class EntityPheasantEgg extends EntityModEgg {

    public EntityPheasantEgg(EntityType<? extends EntityPheasantEgg> type, Level world) {
        super(type, world);
    }

    public EntityPheasantEgg(EntityType<? extends EntityPheasantEgg> type, Level world, LivingEntity thrower) {
        super(type, world, thrower);
    }

    public EntityPheasantEgg(EntityType<? extends EntityPheasantEgg> type, Level world, double x, double y, double z) {
        super(type, world, x, y, z);
    }
    
    public EntityPheasantEgg(EntityType<? extends EntityPheasantEgg> type, Level worldIn, Position pos) {
        super(type, worldIn, pos.x(), pos.y(), pos.z());
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.PHEASANT_EGG.get();
    }

    @Override
    protected Entity createEntity() {
        EntityPheasant pheasant = ModEntities.PHEASANT.getEntityType().create(this.level);
        pheasant.setAge(-24000);
        pheasant.moveTo(this.getX(), this.getY(), this.getZ(), this.yRot, 0.0F);
        pheasant.setType(pheasant.getRandomType());
        return pheasant;
    }

}
