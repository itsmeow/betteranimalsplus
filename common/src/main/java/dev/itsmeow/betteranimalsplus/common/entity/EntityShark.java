package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.interfaces.IVariantTypes;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import dev.itsmeow.betteranimalsplus.common.entity.ai.EfficientMoveTowardsTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.HungerNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.ai.PeacefulNearestAttackableTargetGoal;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntitySharkBase;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityWaterMobPathing;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.betteranimalsplus.init.ModLootTables;
import dev.itsmeow.betteranimalsplus.util.OceanBiomeHelper;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.RandomSwimmingGoal;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;

import javax.annotation.CheckForNull;
import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class EntityShark extends EntitySharkBase {

    private float lastAttack = 0;
    private float lastGrab = 0;
    private float lastTickHealth = 0;
    public float lastBodyRotation = 0;

    public EntityShark(EntityType<? extends EntityShark> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new EfficientMoveTowardsTargetGoal(this, 1D, true));
        this.goalSelector.addGoal(1, new LookAtGoal(this, LivingEntity.class, 15F));
        this.goalSelector.addGoal(1, new LookRandomlyGoal(this));
        this.goalSelector.addGoal(2, new RandomSwimmingGoal(this, 1D, 1));
        this.targetSelector.addGoal(1, new HungerNearestAttackableTargetGoal<>(this, LivingEntity.class, 5, false, false, e -> !(e instanceof EntitySharkBase || e instanceof EntityBobbitWorm || e instanceof PlayerEntity)));
        this.targetSelector.addGoal(2, new PeacefulNearestAttackableTargetGoal<>(this, PlayerEntity.class, 5, false, false, e -> shouldAttackForHealth(e.getHealth())));
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        if(super.hurt(source, amount)) {
            if(source.getDirectEntity() instanceof PlayerEntity && !this.isPeaceful()) {
                PlayerEntity player = (PlayerEntity) source.getDirectEntity();
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
        case "blue": return health <= 8F;
        case "bull": return health <= 13F;
        case "tiger": return health <= 10F;
        case "whitetip": return health <= 16F;
        case "greenland": return health <= 8F;
        case "hammerhead": return health <= 8F;
        case "goblin": return health <= 8F;
        case "mako": return health <= 13F;
        case "great_white": return health <= 13F;
        default: return false;
        }
    }

    @Override
    public void aiStep() {
        super.aiStep();
        if(this.getTarget() != null && !this.getTarget().isAlive()) {
            this.setTarget(null);
        }
        if(!this.level.isClientSide && this.getTarget() != null && this.getTarget().isAlive() && this.isAlive() && !this.isPeaceful()) {
            boolean isBoat = this.getTarget() instanceof PlayerEntity && this.getTarget().getVehicle() != null && this.getTarget().getVehicle() instanceof BoatEntity;
            float grabDelay = isBoat ? 20F : 60F;
            if(this.getPassengers().contains(this.getTarget())) {
                float time = 30F * ((float) Math.random() + 1F);
                if(this.lastAttack + time < this.tickCount) {
                    this.doHurtTarget(this.getTarget());
                }
            } else if(lastGrab + grabDelay < this.tickCount && this.distanceToSqr(this.getTarget()) < 5) {
                if(isBoat) {
                    BoatEntity boat = (BoatEntity) this.getTarget().getVehicle();
                    boat.hurt(DamageSource.mobAttack(this), 3F);
                } else if(!this.getTarget().isInvulnerable() && this.getTarget().getBbWidth() < 2.5 && this.getTarget().getBbHeight() < 2.5) {
                    if (this.getTarget() instanceof MobEntity) {
                        MobEntity el = (MobEntity) this.getTarget();
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
                if (this.getTarget() instanceof MobEntity) {
                    MobEntity el = (MobEntity) this.getTarget();
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
    protected ResourceLocation getDefaultLootTable() {
        return ModLootTables.SHARK;
    }

    @Override
    public EntityTypeContainer<EntityShark> getContainer() {
        return ModEntities.SHARK;
    }

    @Override
    public String[] getTypesFor(RegistryKey<Biome> biomeKey, Biome biome, Set<Type> types, SpawnReason reason) {
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

    @Nullable
    @CheckForNull
    @Override
    public IVariant getRandomVariantForBiome(IWorld world, SpawnReason reason) {
        Biome biome = world.getBiome(this.getImplementation().blockPosition());
        Optional<RegistryKey<Biome>> biomeKey = world.registryAccess().registryOrThrow(Registry.BIOME_REGISTRY).getResourceKey(biome);
        biomeKey.orElseThrow(() -> new RuntimeException("Biome provided to selective type generation has no ID found."));
        String[] validTypes = this.getTypesFor(biomeKey.get(), biome, BiomeDictionary.getTypes(biomeKey.get()), reason);
        String varStr = validTypes[this.getImplementation().getRandom().nextInt(validTypes.length)];
        for(int i = 0; i < 2; i++) {
            if("great_white".equals(varStr) || "goblin".equals(varStr)) {
                varStr = validTypes[this.getImplementation().getRandom().nextInt(validTypes.length)];
            }
        }
        if(world instanceof World && ((World) world).isDay()) {
            if(validTypes.length > 1 && "goblin".equals(varStr)) {
                for(int i = 0; i < validTypes.length && "goblin".equals(varStr); i++) {
                    varStr = validTypes[i];
                }
            }
        }
        IVariant variant = this.getContainer().getVariantForName(varStr);
        if(variant == null || !varStr.equals(variant.getName())) {
            throw new RuntimeException("Received invalid variant \"" + varStr + "\" from selective type on entity " + this.getContainer().getEntityName());
        }
        return variant;
    }
}
