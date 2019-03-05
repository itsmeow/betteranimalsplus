package its_meow.betteranimalsplus.common.item;

import its_meow.betteranimalsplus.util.EntityContainer;
import net.minecraft.entity.EntityType;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemSpawnEgg;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;

public class ItemBetterAnimalsPlusEgg extends ItemSpawnEgg {

	private final EntityType<?> type;

	public ItemBetterAnimalsPlusEgg(EntityType<?> type, int eggSolid, int eggSpot, EntityContainer container) {
		super(type, eggSolid, eggSpot, new Properties().group(ItemGroup.MISC));
		this.type = type;
	}

	@Override
	public String getTranslationKey(ItemStack stack) {
		if(type != null) {
			return "entity.betteranimalsplus." + this.type.getRegistryName().getPath();
		}
		return "item.betteranimalsplus.emptyegg";
	}

	//private static String eggName = "";
	//private static boolean before = false;

	@Override
	public ITextComponent getDisplayName(ItemStack stack) {
		return new TextComponentTranslation("misc.betteranimalsplus.eggorder", new TextComponentTranslation(this.getTranslationKey(stack)));
	}

	@Override
	public EntityType<?> getType(NBTTagCompound tag) {
		return this.type;
	}

	@Override
	public boolean hasType(NBTTagCompound tag, EntityType<?> type) {
		return type == this.type;
	}

	/*
	private static Pair<String, Boolean> getEggString() {
		if(eggName.equals("")) {
			String sharedBit = getCommonSubstring(I18n.format(Items.BAT_SPAWN_EGG.getTranslationKey()), I18n.format(Items.COD_SPAWN_EGG.getTranslationKey()));
			before = Items.BAT_SPAWN_EGG.getTranslationKey().toString().indexOf(sharedBit) == 0;
		}
		return Pair.of(eggName, before);
	}


	public static String getCommonSubstring(String s, String t) {
	    int[][] table = new int[s.length()][t.length()];
	    int longest = 0;
	    Set<String> result = new HashSet<String>();

	    for (int i = 0; i < s.length(); i++) {
	        for (int j = 0; j < t.length(); j++) {
	            if (s.charAt(i) != t.charAt(j)) {
	                continue;
	            }

	            table[i][j] = (i == 0 || j == 0) ? 1
	                                             : 1 + table[i - 1][j - 1];
	            if (table[i][j] > longest) {
	                longest = table[i][j];
	                result.clear();
	            }
	            if (table[i][j] == longest) {
	                result.add(s.substring(i - longest + 1, i + 1));
	            }
	        }
	    }
	    return result.toArray(new String[0])[0];
	}*/


}
