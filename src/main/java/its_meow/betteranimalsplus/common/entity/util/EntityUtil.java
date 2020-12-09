package its_meow.betteranimalsplus.common.entity.util;

import dev.itsmeow.imdlib.entity.util.IVariantTypes;
import its_meow.betteranimalsplus.common.entity.util.abstracts.EntityAnimalWithTypesAndSize;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.AgeableEntity.AgeableData;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.SpawnReason;

public class EntityUtil {

    public static ILivingEntityData childChance(AgeableEntity e, SpawnReason reason, ILivingEntityData livingdata, float chance) {
        if(livingdata != null && livingdata instanceof AgeableData) {
            int i = ((AgeableData) livingdata).getIndexInGroup();
            if(livingdata instanceof EntityAnimalWithTypesAndSize.AgeableSizeTypeData) {
                EntityAnimalWithTypesAndSize.AgeableSizeTypeData d = (EntityAnimalWithTypesAndSize.AgeableSizeTypeData) livingdata;
                livingdata = new EntityAnimalWithTypesAndSize.AgeableSizeTypeData(d, d.typeData, d.size);
            } else if(livingdata instanceof IVariantTypes.AgeableTypeData) {
                IVariantTypes.AgeableTypeData d = (IVariantTypes.AgeableTypeData) livingdata;
                livingdata = new IVariantTypes.AgeableTypeData(d, d.typeData);
            } else {
                livingdata = new AgeableData(chance);
            }
            ((AgeableData) livingdata).indexInGroup = i;
        }
        return livingdata;
    }

}
