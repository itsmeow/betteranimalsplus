package its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist;

import dev.itsmeow.imdlib.entity.util.IContainerEntity;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.ai.HirschgeistAIAttackMelee;
import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.ai.HirschgeistAIFlameAttack;
import its_meow.betteranimalsplus.common.entity.util.EntityTypeContainerBAP;
import its_meow.betteranimalsplus.common.entity.util.IDropHead;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.BlockState;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.loading.FMLEnvironment;

public class EntityHirschgeist extends MobEntity implements IMob, IDropHead, IContainerEntity<EntityHirschgeist> {

    public EntityHirschgeist(World worldIn) {
        super(ModEntities.HIRSCHGEIST.entityType, worldIn);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new SwimGoal(this));
        this.goalSelector.addGoal(2, new HirschgeistAIAttackMelee(this, 0.7D));
        this.goalSelector.addGoal(2, new HirschgeistAIFlameAttack(this));
        this.goalSelector.addGoal(3, new LookAtGoal(this, PlayerEntity.class, 15F));
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<PlayerEntity>(this, PlayerEntity.class, false));
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(150.0D);
        this.getAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(50.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.65D);
        this.getAttributes().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
    }

    public boolean isDaytime() {
        long time = this.world.getDayTime() % 24000L; // Time can go over value of 24000, so divide and take the remainder
        return !(time >= 13000L && time <= 23000L);
    }

    @Override
    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENTITY_SKELETON_HORSE_AMBIENT;
    }

    @Override
    protected float getSoundPitch() {
        return 0.3F; // Lower pitch of skeleton horse sound
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.5F, 0.6F);
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.hirschgeist;
    }

    @Override
    public boolean attackable() {
        return !this.isDaytime();
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(this.isDaytime() && FMLEnvironment.dist == Dist.CLIENT && this.world.isRemote) {
            if(source.getTrueSource() instanceof PlayerEntity) {
                PlayerEntity player = (PlayerEntity) source.getTrueSource();
                player.sendMessage(new StringTextComponent("The " + I18n.format("entity.betteranimalsplus.hirschgeist") + " is immortal in the daytime. Try fighting it later."));
            }
        }
        return this.isDaytime() ? false : super.attackEntityFrom(source, amount);
    }

    @Override
    public void setAttackTarget(LivingEntity entityIn) {
        super.setAttackTarget(this.isDaytime() ? null : entityIn);
    }

    public Vec3d getHeadLookVec(float p_184665_1_) {
        Vec3d vec3d;
        if(this.getAttackTarget() != null) {
            float f = Math.max(MathHelper.sqrt(this.getDistanceSq(this.getAttackTarget())) / 4.0F, 1.0F);
            float f1 = 6.0F / f;
            float f2 = this.rotationPitch;
            this.rotationPitch = -f1 * 1.5F * 5.0F;
            vec3d = this.getLook(p_184665_1_);
            this.rotationPitch = f2;

            return vec3d;
        }
        return null;
    }

    @Override
    public EntityHirschgeist getImplementation() {
        return this;
    }

    @Override
    public EntityTypeContainerBAP<?> getContainer() {
        return ModEntities.HIRSCHGEIST;
    }

}
