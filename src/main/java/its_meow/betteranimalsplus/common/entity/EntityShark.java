package its_meow.betteranimalsplus.common.entity;

import java.util.Set;

import its_meow.betteranimalsplus.common.entity.ai.EntityAIFindEntityNearestPredicate;
import its_meow.betteranimalsplus.common.entity.ai.EntityAIWanderWaterEntity;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.BiomeDictionary.Type;

public class EntityShark extends EntitySharkBase {

    
    private float lastAttack = 0;
    private float lastGrab = 0;
    private float lastTickHealth = 0;
    public float lastBodyRotation = 0;

    public EntityShark(World world) {
        super(world);
        this.setSize(2.5F, 1.2F);
    }

    @Override
    protected void initEntityAI() {
        super.initEntityAI();
        this.tasks.addTask(1, new EntityAIWatchClosest(this, EntityLiving.class, 15F));
        this.tasks.addTask(2, new EntityAIWanderWaterEntity(this, 0.65D));
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPredicate(this, EntityLiving.class, e -> !(e instanceof EntityBobbitWorm), true));
        this.targetTasks.addTask(1, new EntityAIFindEntityNearestPredicate(this, EntityPlayer.class, e -> this.shouldAttackForHealth(e.getHealth()), true));
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(super.attackEntityFrom(source, amount)) {
            if(source.getTrueSource() instanceof EntityPlayer) {
                EntityPlayer player = (EntityPlayer) source.getTrueSource();
                if(!player.capabilities.isCreativeMode && !player.isInvisible()) {
                    this.setAttackTarget(player);
                }
            }
            return true;
        }
        return false;
    }

    public boolean shouldAttackForHealth(float health) {
        int type = this.getTypeNumber();
        switch(type) {
        case 1: return health <= 8F; // blue
        case 2: return health <= 13F;// bull
        case 3: return health <= 10F;// tiger
        case 4: return health <= 16F;// whitetip
        case 5: return health <= 8F; // greenland
        default: return false;
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.75D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6D);
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(!this.world.isRemote && this.getAttackTarget() != null && !this.getAttackTarget().isDead && !this.isDead) {
            boolean isBoat = this.getAttackTarget() instanceof EntityPlayer && this.getAttackTarget().isRiding() && this.getAttackTarget().getRidingEntity() instanceof EntityBoat;
            float grabDelay = isBoat ? 20F : 60F;
            if(this.getPassengers().contains(this.getAttackTarget())) {
                float time = 30F;
                time *= (Math.random() + 1F);
                if(this.lastAttack + time < this.ticksExisted) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
            } else if(lastGrab + grabDelay < this.ticksExisted && this.getDistanceSq(this.getAttackTarget()) < 5) {
                if(isBoat) {
                    EntityBoat boat = (EntityBoat) this.getAttackTarget().getRidingEntity();
                    boat.attackEntityFrom(DamageSource.causeMobDamage(this), 3F);
                } else if(!this.getAttackTarget().getIsInvulnerable() && this.getAttackTarget().width < 2.5 && this.getAttackTarget().height < 2.5){
                    this.getAttackTarget().startRiding(this, false);
                } else if(!this.getAttackTarget().getIsInvulnerable()) {
                    this.attackEntityAsMob(this.getAttackTarget());
                }
                lastGrab = this.ticksExisted;
            } else {
                this.getMoveHelper().setMoveTo(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 0.1D);
            }
            if(lastTickHealth - 4F > this.getHealth()) {
                this.getAttackTarget().dismountRidingEntity();
            }
        }
        this.lastTickHealth = this.getHealth();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.SHARK;
    }

    @Override
    public int getVariantMax() {
        return 5;
    }

    @Override
    protected String getContainerName() {
        return "shark";
    }

    @Override
    protected int[] getTypesFor(Set<Type> biome) {
        return biome.contains(Type.COLD) ? new int[] {5} : new int[] {1,2,3,4}; // greenland ONLY in cold oceans
    }

}
