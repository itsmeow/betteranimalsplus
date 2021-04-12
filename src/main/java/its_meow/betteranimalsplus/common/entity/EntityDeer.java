package its_meow.betteranimalsplus.common.entity;

import dev.itsmeow.imdlib.entity.EntityTypeContainer;
import dev.itsmeow.imdlib.entity.util.variant.EntityVariant;
import dev.itsmeow.imdlib.entity.util.variant.IVariant;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.entity.util.EntityUtil;
import its_meow.betteranimalsplus.common.entity.util.IDropHead;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalEatsGrassWithTypes;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypes;
import its_meow.betteranimalsplus.init.ModEntities;
import its_meow.betteranimalsplus.init.ModLootTables;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Calendar;

public class EntityDeer extends EntityAnimalEatsGrassWithTypes implements IDropHead<EntityAnimalWithTypes> {

    public EntityDeer(EntityType<? extends EntityDeer> entityType, World worldIn) {
        super(entityType, worldIn, 6);
    }

    @Override
    public int getEatTime() {
        return eatTimer;
    }

    @OnlyIn(Dist.CLIENT)
    @Override
    public void handleStatusUpdate(byte id) {
        if(id == 10) {
            this.eatTimer = 40;
        } else {
            super.handleStatusUpdate(id);
        }
    }

    @Override
    public void baseTick() {
        super.baseTick();
        if(this.world.isRemote) {
            this.eatTimer = Math.max(0, this.eatTimer - 1);
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        Item i = stack.getItem();
        return i == Items.WHEAT || i == Items.CARROT || i == Items.GOLDEN_CARROT ||  i == Items.APPLE || i == Items.GOLDEN_APPLE;
    }

    @Override
    public int getMaxSpawnedInChunk() {
        return 4;
    }

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {
        this.playSound(SoundEvents.ENTITY_SHEEP_STEP, 0.15F, 1.0F);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new SwimGoal(this));
        this.goalSelector.addGoal(1, new BreedGoal(this, 0.45D));
        this.goalSelector.addGoal(2, new PanicGoal(this, 0.65D));
        IItemProvider[] temptItems = new IItemProvider[] {Items.APPLE, Items.GOLDEN_APPLE, Items.CARROT, Items.CARROT_ON_A_STICK, Items.GOLDEN_CARROT, Items.WHEAT};
        this.goalSelector.addGoal(3, new TemptGoal(this, 0.45D, false, Ingredient.fromItems(temptItems)));
        this.goalSelector.addGoal(4, new AvoidEntityGoal<>(this, PlayerEntity.class, 20, 0.55D, 0.7D));
        this.goalSelector.addGoal(5, new FollowParentGoal(this, 1D));
        // Eat Grass at Priority 6
        this.goalSelector.addGoal(6, new RandomWalkingGoal(this, 0.45D));
        this.goalSelector.addGoal(7, new LookRandomlyGoal(this));
    }

    @Override
    public void eatGrassBonus() {
        super.eatGrassBonus();
        this.addGrowth(60);
    }

    @Override
    protected void registerAttributes() {
        super.registerAttributes();
        this.getAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(15.0D);
        this.getAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.45D);
    }

    @Override
    public void onDeath(DamageSource cause) {
        super.onDeath(cause);
        this.doHeadDrop();
    }

    @Override
    protected ResourceLocation getLootTable() {
        return ModLootTables.deer;
    }

    @Override
    protected EntityDeer getBaseChild() {
        return getContainer().getEntityType().create(world);
    }

    @Override
    public ILivingEntityData onInitialSpawn(IWorld world, DifficultyInstance difficulty, SpawnReason reason, ILivingEntityData livingdata, CompoundNBT compound) {
        return EntityUtil.childChance(this, reason, super.onInitialSpawn(world, difficulty, reason, livingdata, compound), 0.25F);
    }

    @Override
    public EntityTypeContainer<EntityDeer> getContainer() {
        return ModEntities.DEER;
    }

    @Override
    public IVariant getRandomType() {
        int[] validTypes = new int[] { 1, 2, 3, 4 };
        int r = validTypes[this.getRNG().nextInt(validTypes.length)];
        if(r > 2) {
            r = validTypes[this.getRNG().nextInt(validTypes.length)];
        }
        if(r > 2) {
            r = validTypes[this.getRNG().nextInt(validTypes.length)];
        }
        return this.getContainer().getVariantForName(String.valueOf(r));
    }

    public static class EntityDeerVariant extends EntityVariant {

        private static boolean isChristmas = false;

        static {
            Calendar calendar = Calendar.getInstance();

            if(calendar.get(Calendar.MONTH) + 1 == 12 && calendar.get(Calendar.DATE) >= 24 && calendar.get(Calendar.DATE) <= 26) {
                isChristmas = true;
            }
        }

        private final ResourceLocation christmasTexture;

        public EntityDeerVariant(String nameTexture) {
            super(Ref.MOD_ID, nameTexture, "deer_" + nameTexture);
            this.christmasTexture = new ResourceLocation(Ref.MOD_ID, "textures/entity/deer_" + nameTexture + "_christmas.png");
        }

        @Override
        public ResourceLocation getTexture(Entity entity) {
            return isChristmas ? christmasTexture : texture;
        }

    }

}
