package its_meow.betteranimalsplus.common.entity.projectile;

import its_meow.betteranimalsplus.common.entity.EntityGoose;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModItems;
import net.minecraft.dispenser.IPosition;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.world.World;

public class EntityGoldenGooseEgg extends EntityModEgg {
    public static EntityType<EntityGoldenGooseEgg> GOLDEN_GOOSE_EGG_TYPE = ModEntities.H.<EntityGoldenGooseEgg>createEntityType(EntityGoldenGooseEgg.class, EntityGoldenGooseEgg::new, "golden_goose_egg", EntityClassification.MISC, 64, 1, true, 0.25F, 0.25F);

    public EntityGoldenGooseEgg(World world) {
        super(GOLDEN_GOOSE_EGG_TYPE, world);
    }

    public EntityGoldenGooseEgg(EntityType<? extends EntityGoldenGooseEgg> type, World world) {
        super(type, world);
    }

    public EntityGoldenGooseEgg(World world, LivingEntity thrower) {
        super(GOLDEN_GOOSE_EGG_TYPE, world, thrower);
    }

    public EntityGoldenGooseEgg(World world, double x, double y, double z) {
        super(GOLDEN_GOOSE_EGG_TYPE, world, x, y, z);
    }

    public EntityGoldenGooseEgg(World worldIn, IPosition pos) {
        super(GOLDEN_GOOSE_EGG_TYPE, worldIn, pos.getX(), pos.getY(), pos.getZ());
    }

    @Override
    public Item getDefaultItem() {
        return ModItems.GOLDEN_GOOSE_EGG;
    }

    @Override
    protected Entity createEntity() {
        EntityGoose goose = ModEntities.GOOSE.entityType.create(this.world);
        goose.setGrowingAge(-24000);
        goose.setLocationAndAngles(this.getPosX(), this.getPosY(), this.getPosZ(), this.rotationYaw, 0.0F);
        goose.setType("1");
        return goose;
    }
}
