package its_meow.betteranimalsplus.common.entity.ai;

import java.util.function.Function;

import com.google.common.base.Predicate;
import com.google.common.base.Predicates;

import net.minecraft.block.Block;
import net.minecraft.block.BlockTallGrass;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityAIEatGrassCustom extends EntityAIBase {
    protected static final Predicate<IBlockState> IS_TALL_GRASS = BlockStateMatcher.forBlock(Blocks.TALLGRASS).where(BlockTallGrass.TYPE, Predicates.equalTo(BlockTallGrass.EnumType.GRASS));
    protected final EntityLiving eater;
    protected final World world;
    protected int eatingGrassTimer;
    protected final int childChance;
    protected final int adultChance;
    protected final Function<EntityLiving, BlockPos> getPosition;

    public EntityAIEatGrassCustom(EntityLiving eater, int childChance, int adultChance) {
        this(eater, childChance, adultChance, e -> new BlockPos(e.posX, e.posY, e.posZ));
    }
    
    public EntityAIEatGrassCustom(EntityLiving eater, int childChance, int adultChance, Function<EntityLiving, BlockPos> getPosition) {
        this.eater = eater;
        this.world = eater.world;
        this.childChance = childChance;
        this.adultChance = adultChance;
        this.getPosition = getPosition;
        this.setMutexBits(7);
    }

    public boolean shouldExecute() {
        if(this.eater.getRNG().nextInt(this.eater.isChild() ? childChance : adultChance) != 0) {
            return false;
        } else {
            BlockPos blockpos = getPosition.apply(eater);
            return IS_TALL_GRASS.apply(this.world.getBlockState(blockpos)) || this.world.getBlockState(blockpos.down()).getBlock() == Blocks.GRASS;
        }
    }

    public void startExecuting() {
        this.eatingGrassTimer = 40;
        this.world.setEntityState(this.eater, (byte) 10);
        this.eater.getNavigator().clearPath();
    }

    public void resetTask() {
        this.eatingGrassTimer = 0;
    }

    public boolean shouldContinueExecuting() {
        return this.eatingGrassTimer > 0;
    }

    public int getEatingGrassTimer() {
        return this.eatingGrassTimer;
    }

    public void updateTask() {
        this.eatingGrassTimer = Math.max(0, this.eatingGrassTimer - 1);
        if(this.eatingGrassTimer == 4) {
            BlockPos blockpos = this.getPosition.apply(eater);
            if(IS_TALL_GRASS.apply(this.world.getBlockState(blockpos))) {
                if(net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.eater)) {
                    this.world.destroyBlock(blockpos, false);
                }
                this.eater.eatGrassBonus();
            } else {
                BlockPos blockpos1 = blockpos.down();
                if(this.world.getBlockState(blockpos1).getBlock() == Blocks.GRASS) {
                    if(net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.eater)) {
                        this.world.playEvent(2001, blockpos1, Block.getIdFromBlock(Blocks.GRASS));
                        this.world.setBlockState(blockpos1, Blocks.DIRT.getDefaultState(), 2);
                    }
                    this.eater.eatGrassBonus();
                }
            }
        }
    }
}