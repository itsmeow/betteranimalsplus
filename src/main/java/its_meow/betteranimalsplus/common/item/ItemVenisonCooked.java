package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.model.ModelLoader;

public class ItemVenisonCooked extends ItemFood {

	 /** Number of ticks to run while 'EnumAction'ing until result. */
    public final int itemUseDuration;
    /** The amount this food item heals the player. */
    private final int healAmount;
    /** Whether wolves like this food (true for raw and cooked porkchop). */
    private final boolean isMeat;
	
	public ItemVenisonCooked(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		this.setRegistryName("venisoncooked");
		this.setUnlocalizedName("betteranimalsplus.venisoncooked");
        this.itemUseDuration = 32;
        this.healAmount = 3;
        this.isMeat = false;
        this.setCreativeTab(BetterAnimalsPlusMod.group);
	}
	
    /**
     * How long it takes to use or consume an item
     */
    public int getMaxItemUseDuration(ItemStack stack)
    {
        return this.itemUseDuration;
    }
    
    @Override
	public int getHealAmount(ItemStack stack) {
		return this.healAmount;
	}

	@Override
	public boolean isMeat() {
		return this.isMeat;
	}

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.EAT;
    }

	@OnlyIn(Dist.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
