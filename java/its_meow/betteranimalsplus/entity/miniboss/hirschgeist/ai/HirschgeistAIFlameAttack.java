package its_meow.betteranimalsplus.entity.miniboss.hirschgeist.ai;

import its_meow.betteranimalsplus.entity.miniboss.hirschgeist.EntityHirschgeist;
import net.minecraft.block.BlockFire;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class HirschgeistAIFlameAttack extends EntityAIBase {
	
	 private int flameTicks;
	 private int flameCount;
	 private EntityAreaEffectCloud areaEffectCloud;
	 private EntityHirschgeist attacker;
	 private World world;
	
	 public HirschgeistAIFlameAttack(EntityHirschgeist creature)
	    {
	        this.attacker = creature;
	        this.world = creature.world;
	        this.setMutexBits(3);
	    }
	
	
	@Override
	public boolean shouldExecute() {
		if(attacker.getAttackTarget() == null) {
			return false;
		} else if(attacker.isDaytime()) {
			return false;
		} else if(attacker.getAttackTarget().isDead) {
			return false;
		} else {
			return true;
		}
	}
	
	@Override
	public boolean shouldContinueExecuting() {
		if(flameTicks > 200) {
			return false;
		} else {
			return true;
		}
	}
	
	
	@Override
	public void updateTask() {
		++this.flameTicks;

        if (this.flameTicks == 10)
        {
            float f = 5.0F;
            double d0 = this.attacker.posX + 0 * 5.0D / 2.0D;
            double d1 = this.attacker.posZ + 0* 5.0D / 2.0D;
            double d2 = this.attacker.posY + (double)(this.attacker.height / 2.0F);
            BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(MathHelper.floor(d0), MathHelper.floor(d2), MathHelper.floor(d1));

            while (this.attacker.world.isAirBlock(blockpos$mutableblockpos) && d2 >= 0) //Forge: Fix infinite loop if ground is missing.
            {
                --d2;
                blockpos$mutableblockpos.setPos(MathHelper.floor(d0), MathHelper.floor(d2), MathHelper.floor(d1));
            }

            d2 = (double)(MathHelper.floor(d2) + 1);
            this.areaEffectCloud = new EntityAreaEffectCloud(this.attacker.world, d0, d2, d1);
            this.areaEffectCloud.setOwner(this.attacker);
            this.areaEffectCloud.setRadius(5.0F);
            this.areaEffectCloud.setDuration(200);
            this.areaEffectCloud.setParticle(EnumParticleTypes.FLAME);
            IBlockState blockstate = this.world.getBlockState(new BlockPos(d0, d2, d1));
            if(blockstate.getBlock() == Blocks.AIR) {
            	IBlockState fire = Blocks.FIRE.getDefaultState();
            	world.setBlockState(new BlockPos(d0, d2, d1), fire);
            }
            this.attacker.world.spawnEntity(this.areaEffectCloud);
        }
        
        if(world.isRemote) {
        	this.doClientRenderEffects();
        }
	}
	
	
    public void doClientRenderEffects()
    {
        if (this.flameTicks % 2 == 0 && this.flameTicks < 10 && attacker.getAttackTarget() != null)
        {
            Vec3d vec3d = this.attacker.getHeadLookVec(1.0F).normalize();
            vec3d.rotateYaw(-((float)Math.PI / 4F));
            double d0 = this.attacker.posX;
            double d1 = this.attacker.posY + (double)(this.attacker.height / 2.0F);
            double d2 = this.attacker.posZ;

            for (int i = 0; i < 8; ++i)
            {
                double d3 = d0 + this.attacker.getRNG().nextGaussian() / 2.0D;
                double d4 = d1 + this.attacker.getRNG().nextGaussian() / 2.0D;
                double d5 = d2 + this.attacker.getRNG().nextGaussian() / 2.0D;

                for (int j = 0; j < 6; ++j)
                {
                    this.attacker.world.spawnParticle(EnumParticleTypes.FLAME, d3, d4, d5, -vec3d.x * 0.07999999821186066D * (double)j, -vec3d.y * 0.6000000238418579D, -vec3d.z * 0.07999999821186066D * (double)j);
                }

                vec3d.rotateYaw(0.19634955F);
            }
        }
    }
	
	
	/**
     * Called when this phase is set to active
     */
    public void startExecuting()
    {
        this.flameTicks = 0;
        ++this.flameCount;
    }

    public void removeAreaEffect()
    {
        if (this.areaEffectCloud != null)
        {
            this.areaEffectCloud.setDead();
            this.areaEffectCloud = null;
        }
    }

    public void resetTask()
    {
        this.flameCount = 0;
    }
	
	
	
	
	
}
