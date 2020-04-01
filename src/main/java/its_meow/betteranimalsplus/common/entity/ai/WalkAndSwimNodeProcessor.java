package its_meow.betteranimalsplus.common.entity.ai;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLiving;
import net.minecraft.init.Blocks;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.pathfinding.PathPoint;
import net.minecraft.pathfinding.WalkNodeProcessor;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;

public class WalkAndSwimNodeProcessor extends WalkNodeProcessor {
    private float field_203247_k;

    @Override
    public void init(IBlockAccess sourceIn, EntityLiving mob) {
        super.init(sourceIn, mob);
        mob.setPathPriority(PathNodeType.WATER, 0.0F);
        this.field_203247_k = mob.getPathPriority(PathNodeType.WALKABLE);
        mob.setPathPriority(PathNodeType.WALKABLE, 6.0F);
    }

    @Override
    public void postProcess() {
        this.entity.setPathPriority(PathNodeType.WALKABLE, this.field_203247_k);
        super.postProcess();
    }

    @Override
    public PathPoint getStart() {
        return this.openPoint(MathHelper.floor(this.entity.getEntityBoundingBox().minX), MathHelper.floor(this.entity.getEntityBoundingBox().minY + 0.5D), MathHelper.floor(this.entity.getEntityBoundingBox().minZ));
    }

    @Override
    public PathPoint getPathPointToCoords(double x, double y, double z) {
        return this.openPoint(MathHelper.floor(x), MathHelper.floor(y + 0.5D), MathHelper.floor(z));
    }

    @Override
    public int findPathOptions(PathPoint[] pathOptions, PathPoint currentPoint, PathPoint targetPoint, float maxDistance) {
        int i = 0;
        BlockPos blockpos = new BlockPos(currentPoint.x, currentPoint.y, currentPoint.z);
        double d0 = this.func_203246_a(blockpos);
        PathPoint pathpoint = this.getSafePoint(currentPoint.x, currentPoint.y, currentPoint.z + 1, 1, d0);
        PathPoint pathpoint1 = this.getSafePoint(currentPoint.x - 1, currentPoint.y, currentPoint.z, 1, d0);
        PathPoint pathpoint2 = this.getSafePoint(currentPoint.x + 1, currentPoint.y, currentPoint.z, 1, d0);
        PathPoint pathpoint3 = this.getSafePoint(currentPoint.x, currentPoint.y, currentPoint.z - 1, 1, d0);
        PathPoint pathpoint4 = this.getSafePoint(currentPoint.x, currentPoint.y + 1, currentPoint.z, 0, d0);
        PathPoint pathpoint5 = this.getSafePoint(currentPoint.x, currentPoint.y - 1, currentPoint.z, 1, d0);
        if(pathpoint != null && !pathpoint.visited) {
            pathOptions[i++] = pathpoint;
        }

        if(pathpoint1 != null && !pathpoint1.visited) {
            pathOptions[i++] = pathpoint1;
        }

        if(pathpoint2 != null && !pathpoint2.visited) {
            pathOptions[i++] = pathpoint2;
        }

        if(pathpoint3 != null && !pathpoint3.visited) {
            pathOptions[i++] = pathpoint3;
        }

        if(pathpoint4 != null && !pathpoint4.visited) {
            pathOptions[i++] = pathpoint4;
        }

        if(pathpoint5 != null && !pathpoint5.visited) {
            pathOptions[i++] = pathpoint5;
        }

        boolean flag = pathpoint3 == null || pathpoint3.nodeType == PathNodeType.OPEN || pathpoint3.costMalus != 0.0F;
        boolean flag1 = pathpoint == null || pathpoint.nodeType == PathNodeType.OPEN || pathpoint.costMalus != 0.0F;
        boolean flag2 = pathpoint2 == null || pathpoint2.nodeType == PathNodeType.OPEN || pathpoint2.costMalus != 0.0F;
        boolean flag3 = pathpoint1 == null || pathpoint1.nodeType == PathNodeType.OPEN || pathpoint1.costMalus != 0.0F;
        if(flag && flag3) {
            PathPoint pathpoint6 = this.getSafePoint(currentPoint.x - 1, currentPoint.y, currentPoint.z - 1, 1, d0);
            if(pathpoint6 != null && !pathpoint6.visited) {
                pathOptions[i++] = pathpoint6;
            }
        }

        if(flag && flag2) {
            PathPoint pathpoint7 = this.getSafePoint(currentPoint.x + 1, currentPoint.y, currentPoint.z - 1, 1, d0);
            if(pathpoint7 != null && !pathpoint7.visited) {
                pathOptions[i++] = pathpoint7;
            }
        }

        if(flag1 && flag3) {
            PathPoint pathpoint8 = this.getSafePoint(currentPoint.x - 1, currentPoint.y, currentPoint.z + 1, 1, d0);
            if(pathpoint8 != null && !pathpoint8.visited) {
                pathOptions[i++] = pathpoint8;
            }
        }

        if(flag1 && flag2) {
            PathPoint pathpoint9 = this.getSafePoint(currentPoint.x + 1, currentPoint.y, currentPoint.z + 1, 1, d0);
            if(pathpoint9 != null && !pathpoint9.visited) {
                pathOptions[i++] = pathpoint9;
            }
        }

        return i;
    }

    private double func_203246_a(BlockPos pos) {
        if(!this.entity.isInWater()) {
            BlockPos blockpos = pos.down();
            AxisAlignedBB bb = this.blockaccess.getBlockState(blockpos).getCollisionBoundingBox(this.blockaccess, blockpos);
            return (double) blockpos.getY() + (bb == null || bb.getAverageEdgeLength() <= 0 ? 0.0D : bb.maxY);
        } else {
            return (double) pos.getY() + 0.5D;
        }
    }

    private PathPoint getSafePoint(int x, int y, int z, int p_203245_4_, double p_203245_5_) {
        PathPoint pathpoint = null;
        BlockPos blockpos = new BlockPos(x, y, z);
        double d0 = this.func_203246_a(blockpos);
        if(d0 - p_203245_5_ > 1.125D) {
            return null;
        } else {
            PathNodeType pathnodetype = this.getPathNodeType(this.blockaccess, x, y, z, this.entity, this.entitySizeX, this.entitySizeY, this.entitySizeZ, false, false);
            float f = this.entity.getPathPriority(pathnodetype);
            double d1 = (double) this.entity.width / 2.0D;
            if(f >= 0.0F) {
                pathpoint = this.openPoint(x, y, z);
                pathpoint.nodeType = pathnodetype;
                pathpoint.costMalus = Math.max(pathpoint.costMalus, f);
            }

            if(pathnodetype != PathNodeType.WATER && pathnodetype != PathNodeType.WALKABLE) {
                if(pathpoint == null && p_203245_4_ > 0 && pathnodetype != PathNodeType.FENCE && pathnodetype != PathNodeType.TRAPDOOR) {
                    pathpoint = this.getSafePoint(x, y + 1, z, p_203245_4_ - 1, p_203245_5_);
                }

                if(pathnodetype == PathNodeType.OPEN) {
                    AxisAlignedBB axisalignedbb = new AxisAlignedBB((double) x - d1 + 0.5D, (double) y + 0.001D, (double) z - d1 + 0.5D, (double) x + d1 + 0.5D, (double) ((float) y + this.entity.height), (double) z + d1 + 0.5D);
                    if(!(this.entity.getEntityBoundingBox().getAverageEdgeLength() <= 0 && axisalignedbb.getAverageEdgeLength() <= 0)) {
                        return null;
                    }

                    PathNodeType pathnodetype1 = this.getPathNodeType(this.blockaccess, x, y - 1, z, this.entity, this.entitySizeX, this.entitySizeY, this.entitySizeZ, false, false);
                    if(pathnodetype1 == PathNodeType.BLOCKED) {
                        pathpoint = this.openPoint(x, y, z);
                        pathpoint.nodeType = PathNodeType.WALKABLE;
                        pathpoint.costMalus = Math.max(pathpoint.costMalus, f);
                        return pathpoint;
                    }

                    if(pathnodetype1 == PathNodeType.WATER) {
                        pathpoint = this.openPoint(x, y, z);
                        pathpoint.nodeType = PathNodeType.WATER;
                        pathpoint.costMalus = Math.max(pathpoint.costMalus, f);
                        return pathpoint;
                    }

                    int i = 0;

                    while(y > 0 && pathnodetype == PathNodeType.OPEN) {
                        --y;
                        if(i++ >= this.entity.getMaxFallHeight()) {
                            return null;
                        }

                        pathnodetype = this.getPathNodeType(this.blockaccess, x, y, z, this.entity, this.entitySizeX, this.entitySizeY, this.entitySizeZ, false, false);
                        f = this.entity.getPathPriority(pathnodetype);
                        if(pathnodetype != PathNodeType.OPEN && f >= 0.0F) {
                            pathpoint = this.openPoint(x, y, z);
                            pathpoint.nodeType = pathnodetype;
                            pathpoint.costMalus = Math.max(pathpoint.costMalus, f);
                            break;
                        }

                        if(f < 0.0F) {
                            return null;
                        }
                    }
                }

                return pathpoint;
            } else {
                if(y < this.entity.world.getSeaLevel() - 10 && pathpoint != null) {
                    ++pathpoint.costMalus;
                }

                return pathpoint;
            }
        }
    }

    @Override
    public PathNodeType getPathNodeType(IBlockAccess blockaccessIn, int x, int y, int z) {
        PathNodeType pathnodetype = this.getPathNodeTypeRaw(blockaccessIn, x, y, z);
        if(pathnodetype == PathNodeType.WATER) {
            return PathNodeType.WATER;
        } else {
            if(pathnodetype == PathNodeType.OPEN && y >= 1) {
                Block block = blockaccessIn.getBlockState(new BlockPos(x, y - 1, z)).getBlock();
                PathNodeType pathnodetype1 = this.getPathNodeTypeRaw(blockaccessIn, x, y - 1, z);
                if(pathnodetype1 != PathNodeType.WALKABLE && pathnodetype1 != PathNodeType.OPEN && pathnodetype1 != PathNodeType.LAVA) {
                    pathnodetype = PathNodeType.WALKABLE;
                } else {
                    pathnodetype = PathNodeType.OPEN;
                }

                if(pathnodetype1 == PathNodeType.DAMAGE_FIRE || block == Blocks.MAGMA || block == Blocks.FIRE) {
                    pathnodetype = PathNodeType.DAMAGE_FIRE;
                }

                if(pathnodetype1 == PathNodeType.DAMAGE_CACTUS) {
                    pathnodetype = PathNodeType.DAMAGE_CACTUS;
                }

                if(pathnodetype1 == PathNodeType.DAMAGE_OTHER) {
                    pathnodetype = PathNodeType.DAMAGE_OTHER;
                }
            }

            pathnodetype = this.checkNeighborBlocks(blockaccessIn, x, y, z, pathnodetype);
            return pathnodetype;
        }
    }

}
