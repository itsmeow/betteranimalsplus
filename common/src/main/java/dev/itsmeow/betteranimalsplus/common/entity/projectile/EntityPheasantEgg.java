package dev.itsmeow.betteranimalsplus.common.entity.projectile;

import dev.itsmeow.betteranimalsplus.common.entity.EntityPheasant;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModItems;
import net.minecraft.core.Position;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;

public class EntityPheasantEgg extends EntityModEgg {
    public static EntityType<EntityPheasantEgg> PHEASANT_EGG_TYPE = ModEntities.H.createEntityType(EntityPheasantEgg::new, "pheasant_egg", MobCategory.MISC, 64, 1, true, 0.25F, 0.25F);
    
    public EntityPheasantEgg(Level world) {
        super(PHEASANT_EGG_TYPE, world);
    }
    
    public EntityPheasantEgg(EntityType<? extends EntityPheasantEgg> type, Level world) {
        super(type, world);
    }

    public EntityPheasantEgg(Level world, LivingEntity thrower) {
        super(PHEASANT_EGG_TYPE, world, thrower);
    }

    public EntityPheasantEgg(Level world, double x, double y, double z) {
        super(PHEASANT_EGG_TYPE, world, x, y, z);
    }
    
    public EntityPheasantEgg(Level worldIn, Position pos) {
        super(PHEASANT_EGG_TYPE, worldIn, pos.x(), pos.y(), pos.z());
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
