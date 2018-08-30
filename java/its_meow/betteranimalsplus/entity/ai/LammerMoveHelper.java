package its_meow.betteranimalsplus.entity.ai;
import java.util.Random;

import its_meow.betteranimalsplus.entity.EntityLammergeier;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;

public class LammerMoveHelper extends EntityMoveHelper
	{
		private final EntityLammergeier parentEntity;
		private int courseChangeCooldown;

		public LammerMoveHelper(EntityLammergeier lam)
		{
			super(lam);
			this.parentEntity = lam;
		}
		
		public boolean isUpdating()
	    {
	        return this.action == EntityMoveHelper.Action.MOVE_TO;
	    }
		
		@Override
		public void onUpdateMoveHelper()
		{	
			//System.out.println("A: " + (this.action == EntityMoveHelper.Action.MOVE_TO));
			if (this.action == EntityMoveHelper.Action.MOVE_TO)
			{
				double d0 = this.posX - this.parentEntity.posX;
				double d1 = this.posY - this.parentEntity.posY;
				double d2 = this.posZ - this.parentEntity.posZ;
				double d3 = d0 * d0 + d1 * d1 + d2 * d2;

				//if (this.courseChangeCooldown-- <= 0)
				{
					//this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
					d3 = (double)MathHelper.sqrt(d3);
					//System.out.println("B: " + (this.isNotColliding(this.posX, this.posY + 1, this.posZ, d3)));
					if (this.isNotColliding(this.posX, this.posY, this.posZ, d3))
					{
						/*if(Math.abs(d0) >= 1 && Math.abs(d1) >= 1 && Math.abs(d2) >= 1) {
							this.action = EntityMoveHelper.Action.WAIT;
							return;
						}*/
						this.parentEntity.motionX += d0 / d3 * 0.1D;
						this.parentEntity.motionY += d1 / d3 * 0.1D;
						this.parentEntity.motionZ += d2 / d3 * 0.1D;
					}
					else
					{
						this.parentEntity.motionY += 0.05;
						if(this.parentEntity.getEntityWorld().getBlockState(this.parentEntity.getPosition().up()).isFullBlock()) {
							this.parentEntity.motionX += d0 / d3 * 0.1D;
							this.parentEntity.motionY -= 0.05;
							this.parentEntity.motionZ += d2 / d3 * 0.1D;
						}
						if(this.parentEntity.posX == this.parentEntity.lastTickPosX && this.parentEntity.posY == this.parentEntity.lastTickPosY && this.parentEntity.posZ == this.parentEntity.lastTickPosZ) {
							Random rand = this.parentEntity.getRNG();
							this.setMoveTo(this.parentEntity.posX + rand.nextInt(2) - 1, this.parentEntity.posY + rand.nextInt(3) - 1, this.parentEntity.posZ  + rand.nextInt(3) - 1, 0.5D);
						}
						this.action = EntityMoveHelper.Action.WAIT;
					}
				}
			}
		}

		/**
		 * Checks if entity bounding box is not colliding with terrain
		 */
		private boolean isNotColliding(double x, double y, double z, double p_179926_7_)
		{
			double d0 = (x - this.parentEntity.posX) / p_179926_7_;
			double d1 = (y - this.parentEntity.posY) / p_179926_7_;
			double d2 = (z - this.parentEntity.posZ) / p_179926_7_;
			AxisAlignedBB axisalignedbb = this.parentEntity.getEntityBoundingBox();

			for (int i = 1; (double)i < p_179926_7_; ++i)
			{
				axisalignedbb = axisalignedbb.offset(d0, d1, d2);

				if (!this.parentEntity.world.getCollisionBoxes(this.parentEntity, axisalignedbb).isEmpty())
				{
					return false;
				}
			}

			return true;
		}
	}