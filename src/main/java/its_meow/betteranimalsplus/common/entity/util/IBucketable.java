package its_meow.betteranimalsplus.common.entity.util;

import net.minecraft.item.ItemStack;

public interface IBucketable {

    public void setBucketData(ItemStack bucket);

    public ItemStack getBucket();
    
    public void setFromBucket(boolean fromBucket);
    
    public boolean isFromBucket();

}
