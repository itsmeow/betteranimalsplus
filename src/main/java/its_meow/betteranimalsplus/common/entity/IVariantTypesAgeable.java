package its_meow.betteranimalsplus.common.entity;

import javax.annotation.Nullable;

import net.minecraft.entity.AgeableEntity.AgeableData;
import net.minecraft.entity.ILivingEntityData;

public interface IVariantTypesAgeable extends IVariantTypes {
    
    public static class AgeableTypeData extends AgeableData implements ILivingEntityData {
        public int typeData;

        public AgeableTypeData(int type) {
            this.typeData = type;
        }
    }
    
    @Nullable
    default ILivingEntityData initData(ILivingEntityData livingdata) {

        if (!this.isChildI()) {
            int i = this.getRandomType();

            if (livingdata instanceof AgeableTypeData) {
                i = ((AgeableTypeData) livingdata).typeData;
            } else {
                livingdata = new AgeableTypeData(i);
            }

            this.setType(i);

        }

        return livingdata;
    }
    
    @Nullable
    default ILivingEntityData initData(ILivingEntityData livingdata, int type) {

        if (!this.isChildI()) {
            int i = type;
            livingdata = new AgeableTypeData(i);
            this.setType(i);

        }

        return livingdata;
    }
    
}
