package its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.ai;

import its_meow.betteranimalsplus.common.entity.miniboss.hirschgeist.EntityHirschgeist;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.potion.Effects;
import net.minecraft.init.Particles;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class HirschgeistAIFlameAttack extends Goal {

    private int flameTicks;
    private AreaEffectCloudEntity areaEffectCloud;
    private EntityHirschgeist attacker;
    private World world;

    public HirschgeistAIFlameAttack(EntityHirschgeist creature) {
        this.attacker = creature;
        this.world = creature.world;
        this.setMutexBits(4);
    }

    @Override
    public boolean shouldExecute() {
        if (this.attacker.getAttackTarget() == null) {
            return false;
        } else if (this.attacker.isDaytime()) {
            return false;
        } else if (!this.attacker.getAttackTarget().isAlive()) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean shouldContinueExecuting() {
        if (this.flameTicks > 200) {
            return false;
        } else if (this.attacker.getAttackTarget() == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void tick() {
        ++this.flameTicks;
        LivingEntity target = this.attacker.getAttackTarget();
        if (this.flameTicks == 10 && target != null && target.getDistanceSq(this.attacker) <= 100) {

            double x = target.posX;
            double y = target.posY;
            double z = target.posZ;

            this.areaEffectCloud = new AreaEffectCloudEntity(target.world, x, y, z);
            this.areaEffectCloud.setOwner(this.attacker);
            this.areaEffectCloud.setRadius(3.0F);
            this.areaEffectCloud.setDuration(2000);
            this.areaEffectCloud.setParticleData(Particles.FLAME);
            this.areaEffectCloud.addEffect(new EffectInstance(Effects.INSTANT_DAMAGE));
            /*
             * IBlockState blockstate = this.world.getBlockState(tPos);
             * if(blockstate.getBlock() == Blocks.AIR) { IBlockState fire =
             * Blocks.FIRE.getDefaultState(); world.setBlockState(tPos, fire); }
             */
            this.attacker.world.spawnEntity(this.areaEffectCloud);
        }

        if (this.world.isRemote) {
            this.doClientRenderEffects();
        }
    }

    public void doClientRenderEffects() {
        if (this.flameTicks % 2 == 0 && this.flameTicks < 10 && this.attacker.getAttackTarget() != null) {
            LivingEntity target = this.attacker.getAttackTarget();
            Vec3d vec3d = this.attacker.getHeadLookVec(1.0F).normalize();
            vec3d.rotateYaw(-((float) Math.PI / 4F));
            double d0 = target.posX;
            double d1 = target.posY;
            double d2 = target.posZ;

            for (int i = 0; i < 8; ++i) {
                double d3 = d0 + this.attacker.getRNG().nextGaussian() / 2.0D;
                double d4 = d1 + this.attacker.getRNG().nextGaussian() / 2.0D;
                double d5 = d2 + this.attacker.getRNG().nextGaussian() / 2.0D;

                for (int j = 0; j < 6; ++j) {
                    this.attacker.world.addParticle(Particles.FLAME, d3, d4, d5, -vec3d.x * 0.07999999821186066D * j,
                            -vec3d.y * 0.6000000238418579D, -vec3d.z * 0.07999999821186066D * j);
                }

                vec3d.rotateYaw(0.19634955F);
            }
        }
    }

    /**
     * Called when this phase is set to active
     */
    @Override
    public void startExecuting() {
        this.flameTicks = 0;
    }

    public void removeAreaEffect() {
        if (this.areaEffectCloud != null) {
            this.areaEffectCloud.remove();

            this.areaEffectCloud = null;
        }
    }

}
