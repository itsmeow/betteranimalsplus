package its_meow.betteranimalsplus.common.entity;

import com.google.common.base.Predicates;

import dev.itsmeow.imdlib.entity.util.EntityTypeContainer;
import its_meow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityBAPSquid;
import its_meow.betteranimalsplus.init.ModEntities;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class EntityGiantSquid extends EntityBAPSquid {

    public EntityGiantSquid(World world) {
        super(ModEntities.SQUID_GIANT.entityType, world);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(2, new PeacefulNearestAttackableTargetGoal<>(this, PlayerEntity.class, 100, true, true, Predicates.alwaysTrue()));
    }

    @Override
    public EntityTypeContainer<?> getContainer() {
        return ModEntities.SQUID_GIANT;
    }

}
