package its_meow.betteranimalsplus.common.entity.util.abstracts;

import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntityWaterMobPathingWithTypesAirBreathing extends EntityWaterMobPathingWithTypes {

    private static final DataParameter<Integer> MOISTNESS = EntityDataManager.createKey(EntityWaterMobPathingWithTypesAirBreathing.class, DataSerializers.VARINT);

    public EntityWaterMobPathingWithTypesAirBreathing(EntityType<? extends EntityWaterMobPathingWithTypesAirBreathing> entityType, World worldIn) {
        super(entityType, worldIn);
    }

    public boolean canBreatheUnderwater() {
        return false;
    }

    protected void updateAir(int p_209207_1_) {
    }

    public int getMoistness() {
        return this.dataManager.get(MOISTNESS);
    }

    public void setMoistness(int p_211137_1_) {
        this.dataManager.set(MOISTNESS, p_211137_1_);
    }

    protected void registerData() {
        super.registerData();
        this.dataManager.register(MOISTNESS, 2400);
    }

    public void writeAdditional(CompoundNBT compound) {
        super.writeAdditional(compound);
        compound.putInt("Moistness", this.getMoistness());
    }

    public void readAdditional(CompoundNBT compound) {
        super.readAdditional(compound);
        this.setMoistness(compound.getInt("Moistness"));
    }

    public int getMaxAir() {
        return 4800;
    }

    protected int determineNextAir(int currentAir) {
        return this.getMaxAir();
    }

    public void tick() {
        super.tick();
        if(!this.isAIDisabled()) {
            if(this.isInWaterRainOrBubbleColumn()) {
                this.setMoistness(2400);
            } else {
                this.setMoistness(this.getMoistness() - 1);
                if(this.getMoistness() <= 0) {
                    this.attackEntityFrom(DamageSource.DRYOUT, 1.0F);
                }
            }

        }
    }

}
