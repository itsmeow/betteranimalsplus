package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityBAPSquid;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class EntityColossalSquid extends EntityBAPSquid {

    public EntityColossalSquid(EntityType<? extends EntityColossalSquid> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.targetSelector.addGoal(2, new PeacefulNearestAttackableTargetGoal<>(this, Player.class, 150, true, true, e -> true));
    }

    @Override
    public EntityTypeContainer<? extends EntityColossalSquid> getContainer() {
        return ModEntities.SQUID_COLOSSAL;
    }

}
