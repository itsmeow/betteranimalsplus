package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.ai.EfficientMoveTowardsTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntitySharkBase;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.util.OceanBiomeHelper;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes;
import dev.itsmeow.imdlib.entity.util.BiomeTypes;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.Boat;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class EntityShark extends EntitySharkBase {

    private float lastAttack = 0;
    private float lastGrab = 0;
    private float lastTickHealth = 0;
    public float lastBodyRotation = 0;

    public EntityShark(EntityType<? extends EntityShark> entityType, Level worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new EfficientMoveTowardsTargetGoal(this, 1D, true));
        this.goalSelector.addGoal(1, new LookAtPlayerGoal(this, LivingEntity.class, 15F));
        this.goalSelector.addGoal(1, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1D, 1));
        this.targetSelector.addGoal(1, new HungerNearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, false, e -> !(e instanceof EntitySharkBase || e instanceof EntityBobbitWorm || e instanceof Player)));
        this.targetSelector.addGoal(2, new PeacefulNearestAttackableTargetGoal<>(this, Player.class, 5, false, false, e -> shouldAttackForHealth(e.getHealth())));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(super.hurt(source, amount)) {
            if(source.getDirectEntity() instanceof Player && !this.isPeaceful()) {
                Player player = (Player) source.getDirectEntity();
                if(!player.isCreative() && !player.isInvisible()) {
                    this.setTarget(player);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public IVariantTypes<EntityWaterMobPathing> setType(IVariant variant) {
        super.setType(variant);
        updateAttributes(this.getVariantNameOrEmpty());
        return this;
    }

    @Override
    public IVariantTypes<EntityWaterMobPathing> setType(String variantKey) {
        super.setType(variantKey);
        updateAttributes(this.getVariantNameOrEmpty());
        return this;
    }

    private void updateAttributes(String name) {
        if("hammerhead".equals(name)) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(45D);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(9D);
        } else if("mako".equals(name)) {
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(3D);
        } else if("great_white".equals(name)) {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(60D);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(12D);
        } else {
            this.getAttribute(Attributes.MAX_HEALTH).setBaseValue(30D);
            this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue(6D);
            this.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(1.5D);
        }
        this.setHealth(this.getMaxHealth());
    }

    public boolean shouldAttackForHealth(float health) {
        switch(this.getVariantNameOrEmpty()) {
            case "blue":
            case "greenland":
            case "hammerhead":
            case "goblin":
                return health <= 8F;
            case "bull":
            case "mako":
            case "great_white":
                return health <= 13F;
            case "tiger":
                return health <= 10F;
            case "whitetip":
                return health <= 16F;
            default:
                return false;
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if(this.getTarget() != null && !this.getTarget().isAlive()) {
            this.setTarget(null);
        }
        if(!this.level.isClientSide && this.getTarget() != null && this.getTarget().isAlive() && this.isAlive() && !this.isPeaceful()) {
            boolean isBoat = this.getTarget() instanceof Player && this.getTarget().getVehicle() != null && this.getTarget().getVehicle() instanceof Boat;
            float grabDelay = isBoat ? 20F : 60F;
            if(this.getPassengers().contains(this.getTarget())) {
                float time = 30F * ((float) Math.random() + 1F);
                if(this.lastAttack + time < this.tickCount) {
                    this.doHurtTarget(this.getTarget());
                }
            } else if(lastGrab + grabDelay < this.tickCount && this.distanceToSqr(this.getTarget()) < 5) {
                if(isBoat) {
                    Boat boat = (Boat) this.getTarget().getVehicle();
                    boat.hurt(DamageSource.mobAttack(this), 3F);
                } else if(!this.getTarget().isInvulnerable() && this.getTarget().getBbWidth() < 2.5 && this.getTarget().getBbHeight() < 2.5) {
                    if (this.getTarget() instanceof Mob) {
                        Mob el = (Mob) this.getTarget();
                        el.setTarget(null);
                        el.setLastHurtByMob(null);
                        el.getNavigation().stop(); 
                        el.setNoAi(true);
                    }
                    this.getTarget().startRiding(this, false);
                } else if(!this.getTarget().isInvulnerable()) {
                    this.doHurtTarget(this.getTarget());
                }
                lastGrab = this.tickCount;
            }
            if(lastTickHealth - 4F > this.getHealth()) {
                this.getTarget().stopRiding();
                if (this.getTarget() instanceof Mob) {
                    Mob el = (Mob) this.getTarget();
                    el.setNoAi(false);
                }
            }
        }
        this.lastTickHealth = this.getHealth();
    }

    @Override
    public boolean doHurtTarget(Entity entityIn) {
        if(super.doHurtTarget(entityIn)) {
            this.lastAttack = this.tickCount;
            return true;
        }
        return false;
    }

    @Override
    public EntityTypeContainer<EntityShark> getContainer() {
        return ModEntities.SHARK;
    }

    @Override
    public String[] getTypesFor(ResourceKey<Biome> biomeKey, Biome biome, Set<BiomeTypes.Type> types, MobSpawnType reason) {
        // types always contains OCEAN
        List<String> list = new ArrayList<>();
        OceanBiomeHelper.Wrapper b = new OceanBiomeHelper.Wrapper(biomeKey);
        if(b.isColdOrFrozen()) {
            list.add("greenland");
        } else {
            list.add("bull");
            list.add("blue");
            list.add("whitetip");
            list.add("tiger");
        }
        if(!b.isFrozen()) {
            list.add("great_white");
        }
        if(b.isDeep()) {
            list.add("goblin");
            if(!b.isFrozen()) {
                list.add("mako");
            }
        }
        if(b.isWarm()) {
            list.add("mako");
            list.add("hammerhead");
        }
        return list.toArray(new String[0]);
    }

    @Override
    public IVariant getRandomVariantForBiome(LevelAccessor world, MobSpawnType reason) {
        Holder<Biome> biome = world.getBiome(this.getImplementation().blockPosition());
        Optional<ResourceKey<Biome>> biomeKey = biome.unwrapKey();
        biomeKey.orElseThrow(() -> new RuntimeException("Biome provided to selective type generation has no ID found."));
        String[] validTypes = this.getTypesFor(biomeKey.get(), biome.value(), BiomeTypes.getTypes(biomeKey.get()), reason);
        String varStr = validTypes[this.getImplementation().getRandom().nextInt(validTypes.length)];
        for(int i = 0; i < 2; i++) {
            if("great_white".equals(varStr) || "goblin".equals(varStr)) {
                varStr = validTypes[this.getImplementation().getRandom().nextInt(validTypes.length)];
            }
        }
        if(world instanceof Level && ((Level) world).isDay()) {
            if(validTypes.length > 1 && "goblin".equals(varStr)) {
                for(int i = 0; i < validTypes.length && "goblin".equals(varStr); i++) {
                    varStr = validTypes[i];
                }
            }
        }
        Optional<IVariant> variant = this.getContainer().getVariantForName(varStr);
        if(variant.isEmpty() || !varStr.equals(variant.get().getName())) {
            throw new RuntimeException("Received invalid variant \"" + varStr + "\" from selective type on entity " + this.getContainer().getEntityName());
        }
        return variant.get();
    }
}
