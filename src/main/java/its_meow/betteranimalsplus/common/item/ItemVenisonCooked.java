package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemVenisonCooked extends ItemFood {

	 /** Number of ticks to run while 'EnumAction'ing until result. */
    public final int itemUseDuration;
    /** The amount this food item heals the player. */
    private final int healAmount;
    /** Whether wolves like this food (true for raw and cooked porkchop). */
    private final boolean isWolfsFavoriteMeat;
	
	public ItemVenisonCooked(int amount, boolean isWolfFood) {
		super(amount, isWolfFood);
		this.setRegistryName("venisoncooked");
		this.setUnlocalizedName("betteranimalsplus.venisoncooked");
        this.itemUseDuration = 32;
        this.healAmount = 3;
        this.isWolfsFavoriteMeat = false;
        this.setCreativeTab(BetterAnimalsPlusMod.tab);
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
	public boolean isWolfsFavoriteMeat() {
		return this.isWolfsFavoriteMeat;
	}

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.EAT;
    }

	@SideOnly(Side.CLIENT)
	public void initModel(){
		ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(getRegistryName(), "inventory"));
	}

}
