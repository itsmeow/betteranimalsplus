package its_meow.betteranimalsplus.common.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MobEntity;
import net.minecraft.pathfinding.GroundPathNavigator;
import net.minecraft.pathfinding.Path;
import net.minecraft.pathfinding.PathFinder;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.PathType;
import net.minecraft.pathfinding.WalkNodeProcessor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

public class WaterfowlNavigator extends GroundPathNavigator {

    public WaterfowlNavigator(MobEntity entitylivingIn, World worldIn) {
        super(entitylivingIn, worldIn);
        this.nodeProcessor.setCanOpenDoors(false);
        this.nodeProcessor.setCanSwim(true);
    }

    @Override
    protected PathFinder getPathFinder(int p_179679_1_) {
        this.nodeProcessor = new WalkNodeProcessor();
        this.nodeProcessor.setCanEnterDoors(true);
        return new PathFinder(this.nodeProcessor, p_179679_1_);
    }

    @Override
    protected boolean canNavigate() {
        return this.entity.onGround || this.isInLiquid() || this.entity.isPassenger();
    }

    @Override
    protected Vector3d getEntityPosition() {
        return new Vector3d(this.entity.getPosX(), this.getPathablePosY(), this.entity.getPosZ());
    }

    @Override
    public Path getPathToPos(BlockPos pos, int p_179680_2_) {
        if(this.world.isAirBlock(pos)) {
            BlockPos blockpos;
            for(blockpos = pos.down(); blockpos.getY() > 0 && this.world.isAirBlock(blockpos); blockpos = blockpos.down()) {
            }

            if(blockpos.getY() > 0) {
                return super.getPathToPos(blockpos.up(), p_179680_2_);
            }

            while(blockpos.getY() < this.world.getHeight() && this.world.isAirBlock(blockpos)) {
                blockpos = blockpos.up();
            }

            pos = blockpos;
        }

        if(!this.world.getBlockState(pos).getMaterial().isSolid()) {
            return super.getPathToPos(pos, p_179680_2_);
        } else {
            BlockPos blockpos1;
            for(blockpos1 = pos.up(); blockpos1.getY() < this.world.getHeight() && this.world.getBlockState(blockpos1).getMaterial().isSolid(); blockpos1 = blockpos1.up()) {
            }

            return super.getPathToPos(blockpos1, p_179680_2_);
        }
    }

    @Override
    public Path getPathToEntity(Entity entityIn, int p_75494_2_) {
        return this.getPathToPos(entityIn.getPosition(), p_75494_2_);
    }

    private int getPathablePosY() {
        if(this.entity.isInWater() && this.getCanSwim()) {
            int i = MathHelper.floor(this.entity.getBoundingBox().minY);
            Block block = this.world.getBlockState(new BlockPos(this.entity.getPosX(), i, this.entity.getPosZ())).getBlock();
            int j = 0;

            while(block == Blocks.WATER) {
                ++i;
                block = this.world.getBlockState(new BlockPos(this.entity.getPosX(), i, this.entity.getPosZ())).getBlock();
                ++j;
                if(j > 16) {
                    return MathHelper.floor(this.entity.getBoundingBox().minY);
                }
            }

            return i;
        } else {
            return MathHelper.floor(this.entity.getBoundingBox().minY + 0.5D);
        }
    }

    @Override
    protected boolean isDirectPathBetweenPoints(Vector3d posVec31, Vector3d posVec32, int sizeX, int sizeY, int sizeZ) {
        int i = MathHelper.floor(posVec31.x);
        int j = MathHelper.floor(posVec31.z);
        double d0 = posVec32.x - posVec31.x;
        double d1 = posVec32.z - posVec31.z;
        double d2 = d0 * d0 + d1 * d1;
        if(d2 < 1.0E-8D) {
            return false;
        } else {
            double d3 = 1.0D / Math.sqrt(d2);
            d0 = d0 * d3;
            d1 = d1 * d3;
            sizeX = sizeX + 2;
            sizeZ = sizeZ + 2;
            if(!this.isSafeToStandAt(i, MathHelper.floor(posVec31.y), j, sizeX, sizeY, sizeZ, posVec31, d0, d1)) {
                return false;
            } else {
                sizeX = sizeX - 2;
                sizeZ = sizeZ - 2;
                double d4 = 1.0D / Math.abs(d0);
                double d5 = 1.0D / Math.abs(d1);
                double d6 = (double) i - posVec31.x;
                double d7 = (double) j - posVec31.z;
                if(d0 >= 0.0D) {
                    ++d6;
                }

                if(d1 >= 0.0D) {
                    ++d7;
                }

                d6 = d6 / d0;
                d7 = d7 / d1;
                int k = d0 < 0.0D ? -1 : 1;
                int l = d1 < 0.0D ? -1 : 1;
                int i1 = MathHelper.floor(posVec32.x);
                int j1 = MathHelper.floor(posVec32.z);
                int k1 = i1 - i;
                int l1 = j1 - j;

                while(k1 * k > 0 || l1 * l > 0) {
                    if(d6 < d7) {
                        d6 += d4;
                        i += k;
                        k1 = i1 - i;
                    } else {
                        d7 += d5;
                        j += l;
                        l1 = j1 - j;
                    }

                    if(!this.isSafeToStandAt(i, MathHelper.floor(posVec31.y), j, sizeX, sizeY, sizeZ, posVec31, d0, d1)) {
                        return false;
                    }
                }

                return true;
            }
        }
    }

    private boolean isSafeToStandAt(int x, int y, int z, int sizeX, int sizeY, int sizeZ, Vector3d vec31, double p_179683_8_, double p_179683_10_) {
        int i = x - sizeX / 2;
        int j = z - sizeZ / 2;
        if(!this.isPositionClear(i, y, j, sizeX, sizeY, sizeZ, vec31, p_179683_8_, p_179683_10_)) {
            return false;
        } else {
            for(int k = i; k < i + sizeX; ++k) {
                for(int l = j; l < j + sizeZ; ++l) {
                    double d0 = (double) k + 0.5D - vec31.x;
                    double d1 = (double) l + 0.5D - vec31.z;
                    if(!(d0 * p_179683_8_ + d1 * p_179683_10_ < 0.0D)) {
                        PathNodeType pathnodetype = this.nodeProcessor.getPathNodeType(this.world, k, y - 1, l, this.entity, sizeX, sizeY, sizeZ, true, true);

                        if(pathnodetype == PathNodeType.LAVA) {
                            return false;
                        }

                        if(pathnodetype == PathNodeType.OPEN) {
                            return false;
                        }

                        pathnodetype = this.nodeProcessor.getPathNodeType(this.world, k, y, l, this.entity, sizeX, sizeY, sizeZ, true, true);
                        float f = this.entity.getPathPriority(pathnodetype);
                        if(f < 0.0F || f >= 8.0F) {
                            return false;
                        }

                        if(pathnodetype == PathNodeType.DAMAGE_FIRE || pathnodetype == PathNodeType.DANGER_FIRE || pathnodetype == PathNodeType.DAMAGE_OTHER) {
                            return false;
                        }
                    }
                }
            }

            return true;
        }
    }

    private boolean isPositionClear(int x, int y, int z, int sizeX, int sizeY, int sizeZ, Vector3d p_179692_7_, double p_179692_8_, double p_179692_10_) {
        for(BlockPos blockpos : BlockPos.getAllInBoxMutable(new BlockPos(x, y, z), new BlockPos(x + sizeX - 1, y + sizeY - 1, z + sizeZ - 1))) {
            double d0 = (double) blockpos.getX() + 0.5D - p_179692_7_.x;
            double d1 = (double) blockpos.getZ() + 0.5D - p_179692_7_.z;
            if(!(d0 * p_179692_8_ + d1 * p_179692_10_ < 0.0D) && !this.world.getBlockState(blockpos).allowsMovement(this.world, blockpos, PathType.LAND) && !this.world.getBlockState(blockpos).allowsMovement(this.world, blockpos, PathType.WATER)) {
                return false;
            }
        }

        return true;
    }

}
