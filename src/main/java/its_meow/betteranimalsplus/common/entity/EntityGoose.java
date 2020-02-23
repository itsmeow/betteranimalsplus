package its_meow.betteranimalsplus.common.entity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

import its_meow.betteranimalsplus.common.entity.ai.WaterfowlNavigator;
import its_meow.betteranimalsplus.init.ModItems;
import its_meow.betteranimalsplus.init.ModSoundEvents;
import net.minecraft.block.Block;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IEntityLivingData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.EntityAIFollowParent;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMate;
import net.minecraft.entity.ai.EntityAIPanic;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAITarget;
import net.minecraft.entity.ai.EntityAITempt;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.pathfinding.PathNavigate;
import net.minecraft.pathfinding.PathNodeType;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.oredict.OreDictionary;

public class EntityGoose extends EntityAnimalWithTypes {

    public int attacksLeft = 0;
    public int lastAttackTime = 0;
    protected final Set<UUID> dislikedPlayers = new HashSet<UUID>();
    private int eatTicks;
    private static final Predicate<EntityItem> ITEM_SELECTOR = (item) -> {
        return !item.cannotPickup() && !item.isDead;
    };
    public int timeUntilNextEgg;
    public static String[] pickupBlockList;

    public EntityGoose(World world) {
        super(world);
        this.setSize(1F, 1F);
        this.setCanPickUpLoot(true);
        this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        this.setPathPriority(PathNodeType.WATER, 0.0F);
    }

    @Override
    protected PathNavigate createNavigator(World worldIn) {
        return new WaterfowlNavigator(this, worldIn);
    }

    @Override
    protected float getWaterSlowDown() {
        return 0.95F;
    }

    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAIPanic(this, 1.4D) {
            @Override
            public boolean shouldExecute() {
                return this.creature.getAttackTarget() == null && super.shouldExecute();
            }
        });
        this.tasks.addTask(3, new EntityAIMate(this, 1.0D));
        this.tasks.addTask(4, new EntityAITempt(this, 1.0D, false, Sets.newHashSet(Items.PUMPKIN_SEEDS, Items.WHEAT_SEEDS, Items.BEETROOT_SEEDS, Items.MELON_SEEDS, Items.BREAD)));
        this.tasks.addTask(5, new EntityAIFollowParent(this, 1.1D));
        this.tasks.addTask(6, new EntityAIWander(this, 1.0D));
        this.tasks.addTask(7, new EntityGoose.FindItemsGoal());
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 6.0F));

        this.tasks.addTask(1, new EntityAIAttackMelee(this, 1.1D, false) {
            @Override
            public void startExecuting() {
                attacksLeft = this.attacker.getRNG().nextInt(4) + 1;
                super.startExecuting();
            }

            @Override
            public boolean shouldExecute() {
                return super.shouldExecute() && this.attacker.ticksExisted - lastAttackTime > 150 && EntityGoose.this.getTypeNumber() != 1;
            }

            @Override
            public boolean shouldContinueExecuting() {
                return attacksLeft > 0 && super.shouldContinueExecuting();
            }

            @Override
            protected void checkAndPerformAttack(EntityLivingBase p_190102_1_, double p_190102_2_) {
                if(attacksLeft > 0) {
                    super.checkAndPerformAttack(p_190102_1_, p_190102_2_);
                } else {
                    this.resetTask();
                }
            }

            @Override
            public void resetTask() {
                super.resetTask();
                if(attacksLeft <= 0) {
                    this.attacker.setAttackTarget(null);
                }
            }
        });
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true, new Class[0]) {
            @Override
            public boolean shouldExecute() {
                return super.shouldExecute() && EntityGoose.this.getTypeNumber() != 1;
            }
        });
        this.targetTasks.addTask(1, new DislikeTargetGoal(this) {
            @Override
            public boolean shouldExecute() {
                return super.shouldExecute() && EntityGoose.this.getTypeNumber() != 1;
            }
        });
    }

    @Override
    public void onLivingUpdate() {
        super.onLivingUpdate();
        if(!this.world.isRemote && !this.isDead && this.isServerWorld()) {
            ItemStack itemstack = this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
            if(itemstack.getItem() instanceof ItemFood && this.getAttackTarget() == null) {
                ++this.eatTicks;
                if(this.eatTicks > 200) {
                    if(itemstack.getItem() == Items.BREAD) {
                        this.addPotionEffect(new PotionEffect(Potion.getPotionFromResourceLocation("poison"), 900, 1, false, true));
                    }
                    ItemStack itemstack1 = itemstack.onItemUseFinish(this.world, this);

                    if(!itemstack1.isEmpty()) {
                        this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, itemstack1);
                    }
                    this.eatTicks = 0;
                } else if(this.eatTicks > 160 && this.rand.nextFloat() < 0.1F) {
                    this.playSound(SoundEvents.ENTITY_GENERIC_EAT, 1.0F, 1.0F);
                    this.world.setEntityState(this, (byte) 45); // calls handleStatusUpdate((byte) 45);
                }
            }
        }
        if(!this.world.isRemote && !this.isChild() && --this.timeUntilNextEgg <= 0) {
            this.playSound(SoundEvents.ENTITY_CHICKEN_EGG, 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
            this.entityDropItem(new ItemStack(this.getRNG().nextInt(128) == 0 ? ModItems.GOLDEN_GOOSE_EGG : ModItems.GOOSE_EGG), 0.5F);
            this.timeUntilNextEgg = this.rand.nextInt(6000) + 6000;
        }
    }

    @SideOnly(Side.CLIENT)
    public void handleStatusUpdate(byte id) {
        if(id == 45) {
            ItemStack stack = this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
            if(!stack.isEmpty()) {
                for(int i = 0; i < 8; ++i) {
                    Vec3d vec3d = (new Vec3d(((double) this.rand.nextFloat() - 0.5D) * 0.1D, Math.random() * 0.1D + 0.1D, 0.0D)).rotatePitch(-this.rotationPitch * ((float) Math.PI / 180F)).rotateYaw(-this.rotationYaw * ((float) Math.PI / 180F));
                    if(stack.getHasSubtypes()) {
                        this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX + this.getLookVec().x / 2.0D, this.posY, this.posZ + this.getLookVec().z / 2.0D, vec3d.x, vec3d.y + 0.05D, vec3d.z, Item.getIdFromItem(stack.getItem()), stack.getMetadata());
                    } else {
                        this.world.spawnParticle(EnumParticleTypes.ITEM_CRACK, this.posX + this.getLookVec().x / 2.0D, this.posY, this.posZ + this.getLookVec().z / 2.0D, vec3d.x, vec3d.y + 0.05D, vec3d.z, Item.getIdFromItem(stack.getItem()));
                    }
                }
            }
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.3D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
    }

    @Override
    public void setAttackTarget(EntityLivingBase entity) {
        super.setAttackTarget(entity);
        if(entity instanceof EntityPlayer) {
            UUID uuid = ((EntityPlayer) entity).getGameProfile().getId();
            if(!dislikedPlayers.contains(uuid)) {
                dislikedPlayers.add(uuid);
            }
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity entityIn) {
        if(attacksLeft > 0) {
            attacksLeft--;
        }
        this.lastAttackTime = this.ticksExisted;
        float f = (float) this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).getAttributeValue();
        int i = 0;
        if(entityIn instanceof EntityLivingBase) {
            f += EnchantmentHelper.getModifierForCreature(this.getHeldItemMainhand(), ((EntityLivingBase) entityIn).getCreatureAttribute());
            i += EnchantmentHelper.getKnockbackModifier(this);
        }
        boolean flag = entityIn.attackEntityFrom(DamageSource.causeMobDamage(this), f);
        if(flag) {
            if(i > 0 && entityIn instanceof EntityLivingBase) {
                ((EntityLivingBase) entityIn).knockBack(this, i * 0.5F, MathHelper.sin(this.rotationYaw * 0.017453292F), (-MathHelper.cos(this.rotationYaw * 0.017453292F)));
                this.motionX *= 0.6D;
                this.motionZ *= 0.6D;
            }
            int j = EnchantmentHelper.getFireAspectModifier(this);
            if(j > 0) {
                entityIn.setFire(j * 4);
            }
            if(entityIn instanceof EntityPlayer) {
                EntityPlayer entityplayer = (EntityPlayer) entityIn;
                ItemStack itemstack = this.getHeldItemMainhand();
                ItemStack itemstack1 = entityplayer.isHandActive() ? entityplayer.getActiveItemStack() : ItemStack.EMPTY;

                if(!itemstack.isEmpty() && !itemstack1.isEmpty() && itemstack.getItem().canDisableShield(itemstack, itemstack1, entityplayer, this) && itemstack1.getItem().isShield(itemstack1, entityplayer)) {
                    float f1 = 0.25F + EnchantmentHelper.getEfficiencyModifier(this) * 0.05F;

                    if(this.rand.nextFloat() < f1) {
                        entityplayer.getCooldownTracker().setCooldown(itemstack1.getItem(), 100);
                        this.world.setEntityState(entityplayer, (byte) 30);
                    }
                }
            }
            this.applyEnchantments(this, entityIn);
        }
        return flag;
        
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if(source.getTrueSource() != null && source.getTrueSource() != null && source.getTrueSource() == this.getAttackTarget()) {
            this.lastAttackTime = 0; // allow instant retaliation
        }
        return super.attackEntityFrom(source, amount);
    }

    @Override
    protected boolean canEquipItem(ItemStack newStack) {
        ItemStack oldStack = this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
        return !isPickupBlacklisted(newStack.getItem()) && (oldStack.isEmpty() || this.eatTicks == 0 && newStack.getItem() instanceof ItemFood && !(oldStack.getItem() instanceof ItemFood));
    }

    public boolean isPickupBlacklisted(Item item) {
        String id = item.getRegistryName().toString();
        for(String itemsId : pickupBlockList) {
            if(itemsId.startsWith("ore:")) {
                if(OreDictionary.getOres(itemsId.substring(4)).stream().anyMatch(itemStack -> itemStack.getItem() == item)) {
                    return true;
                }
            } else if(id.equals(itemsId)) {
                return true;
            }
        }
        return false;
    }

    private void dropItemGoose(ItemStack stack) {
        if(!stack.isEmpty() && !this.world.isRemote) {
            EntityItem itementity = new EntityItem(this.world, this.posX + this.getLookVec().x, this.posY + 1.0D, this.posZ + this.getLookVec().z, stack);
            itementity.setPickupDelay(40);
            this.world.spawnEntity(itementity);
        }
    }

    private void spawnItem(ItemStack stack) {
        EntityItem entity = new EntityItem(this.world, this.posX, this.posY, this.posZ, stack);
        this.world.spawnEntity(entity);
    }

    @Override
    public SoundEvent getAmbientSound() {
        return ModSoundEvents.GOOSE_AMBIENT;
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return ModSoundEvents.GOOSE_HURT;
    }

    @Override
    protected SoundEvent getDeathSound() {
        return ModSoundEvents.GOOSE_DEATH;
    }

    @Override
    protected void updateEquipmentIfNeeded(EntityItem itemEntity) {
        ItemStack stack = itemEntity.getItem();
        if(this.canEquipItem(stack)) {
            int i = stack.getCount();
            if(i > 1) {
                this.spawnItem(stack.splitStack(i - 1));
            }
            this.dropItemGoose(this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND));
            this.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, stack.splitStack(1));
            this.inventoryHandsDropChances[EntityEquipmentSlot.MAINHAND.getIndex()] = 2.0F;
            this.onItemPickup(itemEntity, stack.getCount());
            itemEntity.setDead();
            this.eatTicks = 0;
        }
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        NBTTagCompound c = super.writeToNBT(compound);
        NBTTagList list = new NBTTagList();
        for(UUID uuid : dislikedPlayers) {
            list.appendTag(new NBTTagString(uuid.toString()));
        }
        c.setTag("disliked_players", list);
        return c;
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        super.readFromNBT(compound);
        compound.getTagList("disliked_players", Constants.NBT.TAG_STRING).forEach(nbt -> dislikedPlayers.add(UUID.fromString(((NBTTagString) nbt).getString())));
    }

    @Override
    public IEntityLivingData onInitialSpawn(DifficultyInstance difficulty, IEntityLivingData livingdata) {
        return this.initData(super.onInitialSpawn(difficulty, livingdata), this.getRNG().nextInt(2) + 2); // handle variant 1 in eggs directly
    }

    @Override
    public boolean getCanSpawnHere() {
        BlockPos pos = new BlockPos(this.posX, Math.floor(this.posY), this.posZ);
        Block downBlock = world.getBlockState(pos.down()).getBlock();
        return ((downBlock == Blocks.GRASS && nearWater(world, pos)) || downBlock == Blocks.WATER) && world.getLight(pos) > 8 && world.isAirBlock(pos);
    }

    protected static boolean nearWater(World world, BlockPos pos) {
        int i = 12;
        int j = 2;
        BlockPos.MutableBlockPos newpos = new BlockPos.MutableBlockPos();
        for(int k = 0; k <= j; k = k > 0 ? -k : 1 - k) {
            for(int l = 0; l < i; ++l) {
                for(int i1 = 0; i1 <= l; i1 = i1 > 0 ? -i1 : 1 - i1) {
                    for(int j1 = i1 < l && i1 > -l ? l : 0; j1 <= l; j1 = j1 > 0 ? -j1 : 1 - j1) {
                        newpos.setPos(pos).add(i1, k - 1, j1);
                        if(newpos.getX() >> 4 == pos.getX() >> 4 && newpos.getZ() >> 4 == pos.getZ() >> 4 && world.getBlockState(newpos).getBlock() == Blocks.WATER) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override
    public int getVariantMax() {
        return 3;
    }

    @Override
    protected IVariantTypes getBaseChild() {
        return new EntityGoose(world);
    }

    public class FindItemsGoal extends EntityAIBase {
        public FindItemsGoal() {
            this.setMutexBits(1);
        }

        @Override
        public boolean shouldExecute() {
            if(!EntityGoose.this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty()) {
                return false;
            } else if(EntityGoose.this.getAttackTarget() == null && EntityGoose.this.getRevengeTarget() == null) {
                if(EntityGoose.this.getRNG().nextInt(10) != 0) {
                    return false;
                } else {
                    List<EntityItem> list = EntityGoose.this.world.getEntitiesWithinAABB(EntityItem.class, EntityGoose.this.getEntityBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityGoose.ITEM_SELECTOR);
                    return !list.isEmpty() && EntityGoose.this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND).isEmpty();
                }
            } else {
                return false;
            }
        }

        @Override
        public void updateTask() {
            List<EntityItem> list = EntityGoose.this.world.getEntitiesWithinAABB(EntityItem.class, EntityGoose.this.getEntityBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityGoose.ITEM_SELECTOR);
            ItemStack itemstack = EntityGoose.this.getItemStackFromSlot(EntityEquipmentSlot.MAINHAND);
            if(itemstack.isEmpty() && !list.isEmpty()) {
                EntityGoose.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double) 1.2F);
            }

        }

        @Override
        public void startExecuting() {
            List<EntityItem> list = EntityGoose.this.world.getEntitiesWithinAABB(EntityItem.class, EntityGoose.this.getEntityBoundingBox().grow(8.0D, 8.0D, 8.0D), EntityGoose.ITEM_SELECTOR);
            if(!list.isEmpty()) {
                EntityGoose.this.getNavigator().tryMoveToEntityLiving(list.get(0), (double) 1.2F);
            }

        }
    }

    public class DislikeTargetGoal extends EntityAITarget {

        protected EntityGoose goose;
        protected EntityPlayer targetEntity;

        public DislikeTargetGoal(EntityGoose goose) {
            super(goose, false);
            this.goose = goose;
        }

        @Override
        public boolean shouldExecute() {
            if(goose.dislikedPlayers.size() > 0 && goose.getAttackTarget() == null && this.goose.ticksExisted - goose.lastAttackTime > 150) {
                this.targetEntity = this.taskOwner.world.getNearestAttackablePlayer(this.taskOwner.posX, this.taskOwner.posY + (double) this.taskOwner.getEyeHeight(), this.taskOwner.posZ, this.getTargetDistance(), this.getTargetDistance(), player -> 1.0D, entity -> isSuitableTarget(entity, false));
                return this.targetEntity != null;
            }
            return false;
        }

        @Override
        public void startExecuting() {
            this.taskOwner.setAttackTarget(this.targetEntity);
            super.startExecuting();
        }

        @Override
        protected boolean isSuitableTarget(EntityLivingBase target, boolean includeInvincibles) {
            return target instanceof EntityPlayer && dislikedPlayers.contains(((EntityPlayer) target).getGameProfile().getId());
        }

    }

    @Override
    protected String getContainerName() {
        return "goose";
    }

}
