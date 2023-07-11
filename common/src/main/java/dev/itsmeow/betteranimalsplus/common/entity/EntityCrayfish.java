package dev.itsmeow.betteranimalsplus.common.entity;

import dev.itsmeow.betteranimalsplus.common.entity.util.EntityUtil;
import dev.itsmeow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import dev.itsmeow.betteranimalsplus.init.ModEntities;
import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.pathfinder.BlockPathTypes;

public class EntityCrayfish extends EntityAnimalWithTypes {

    public EntityCrayfish(EntityType<? extends EntityCrayfish> entityType, Level worldIn) {
        super(entityType, worldIn);
        this.setPathfindingMalus(BlockPathTypes.WATER, 10F);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new PanicGoal(this, 1.0D));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 20F, 0.44F, 0.55F));
        this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1.0D));
    }

    @Override
    protected EntityCrayfish getBaseChild() {
        return getContainer().getEntityType().create(level);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, MobSpawnType reason, SpawnGroupData livingdata, CompoundTag compound) {
        return EntityUtil.childChance(this, reason, super.finalizeSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    protected float getWaterSlowDown() {
        return 0F;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }

    @Override
    public boolean isPushedByFluid() {
        return false;
    }

    @Override
    public EntityTypeContainer<EntityCrayfish> getContainer() {
        return ModEntities.CRAYFISH;
    }

    public static boolean canCrayfishSpawn(EntityType<EntityCrayfish> type, LevelAccessor world, MobSpawnType reason, BlockPos pos, RandomSource rand) {
        Block downBlock = world.getBlockState(pos.below()).getBlock();
        return (( nearWater(world, pos)) || downBlock == Blocks.WATER) && world.getRawBrightness(pos, 0) > 8 && world.isEmptyBlock(pos);
    }

    protected static boolean nearWater(LevelAccessor world, BlockPos pos) {
        int i = 12;
        int j = 2;
        BlockPos.MutableBlockPos newpos = new BlockPos.MutableBlockPos();
        for(int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
            for(int l = 0; l < i; ++l) {
                for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                    for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                        newpos.set(pos).move(i1, k - 1, j1);
                        if(newpos.getX() >> 4 == pos.getX() >> 4 && newpos.getZ() >> 4 == pos.getZ() >> 4 && world.getBlockState(newpos).getBlock() == Blocks.WATER) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
