package its_meow.betteranimalsplus.util;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;

import org.apache.commons.lang3.tuple.Pair;

import its_meow.betteranimalsplus.client.model.ModelBoarHead;
import its_meow.betteranimalsplus.client.model.ModelDeerHead;
import its_meow.betteranimalsplus.client.model.ModelFoxHead;
import its_meow.betteranimalsplus.client.model.ModelReindeerHead;
import its_meow.betteranimalsplus.client.model.ModelWolfHead;
import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.common.item.ItemBlockHeadType;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.init.TextureRegistry;
import net.minecraft.client.renderer.entity.model.ModelBase;

public enum HeadTypes {

	WOLFHEAD("wolfhead", true, 4, ()->()-> ModelWolfHead.class, type -> new TileEntityHead(type, 0F,
			TextureRegistry.wolf_black, TextureRegistry.wolf_snowy, TextureRegistry.wolf_timber, TextureRegistry.coyote_hostile)),

	FOXHEAD("foxhead", true, 4, ()->()-> ModelFoxHead.class, type -> new TileEntityHead(type, -0.1F,
			TextureRegistry.fox_1, TextureRegistry.fox_2, TextureRegistry.fox_3, TextureRegistry.fox_4)),

	BOARHEAD("boarhead", false, 4, ()->()-> ModelBoarHead.class, type -> new TileEntityHead(type, 0F,
			TextureRegistry.boar_1, TextureRegistry.boar_2, TextureRegistry.boar_3, TextureRegistry.boar_4)),

	DEERHEAD("deerhead", false, 2, ()->()-> ModelDeerHead.class, type -> new TileEntityHead(type, 0F, (typeNum -> {
		Calendar calendar = Calendar.getInstance();
		if(calendar.get(2) + 1 == 12 && calendar.get(5) >= 24 && calendar.get(5) <= 26) {
			return typeNum == 1 ? TextureRegistry.deer_1_christmas : TextureRegistry.deer_2_christmas;
		} else {
			return typeNum == 1 ? TextureRegistry.deer_1 : TextureRegistry.deer_2;
		}

	}))),

	REINDEERHEAD("reindeerhead", false, 4, ()->()-> ModelReindeerHead.class, type -> new TileEntityHead(type, 0F, (typeNum -> {
		if(typeNum <= 4) {
			return null;
		} else {
			switch(typeNum) {
			case 5:
				return TextureRegistry.reindeer_1_christmas;
			case 6:
				return TextureRegistry.reindeer_2_christmas;
			case 7:
				return TextureRegistry.reindeer_3_christmas;
			case 8:
				return TextureRegistry.reindeer_4_christmas;
			default:
				return TextureRegistry.reindeer_1;
			}
		}
	}), TextureRegistry.reindeer_1, TextureRegistry.reindeer_2, TextureRegistry.reindeer_3, TextureRegistry.reindeer_4));

	public final String name;
	public final boolean allowFloor;
	public final int textureCount;
	public final Function<HeadTypes, TileEntityHead> teFactory;
	private ArrayList<Pair<BlockGenericSkull, ItemBlockHeadType>> heads = new ArrayList<Pair<BlockGenericSkull, ItemBlockHeadType>>();
	private Set<ItemBlockHeadType> items = new HashSet<ItemBlockHeadType>();
	private Set<BlockGenericSkull> blocks = new HashSet<BlockGenericSkull>();
	private final Supplier<Supplier<Class<? extends ModelBase>>> modelSupplier;
	
	HeadTypes(String name, boolean allowFloor, int texCount, Supplier<Supplier<Class<? extends ModelBase>>> modelSupplier,
			Function<HeadTypes, TileEntityHead> teFactory) {
		this.name = name;
		this.allowFloor = allowFloor;
		this.teFactory = teFactory;
		this.textureCount = texCount;
		this.modelSupplier = modelSupplier;
		for(int i = 1; i <= texCount; i++) {
			BlockGenericSkull block = new BlockGenericSkull(this, i);
			ItemBlockHeadType item = new ItemBlockHeadType(block, this, i);
			heads.add(Pair.of(block, item));
			blocks.add(block);
			items.add(item);
		}
	}

	public BlockGenericSkull getBlock(int i) {
		return heads.get(i).getLeft();
	}
	
	public ItemBlockHeadType getItem(int i) {
		return heads.get(i).getRight();
	}
	
	public Set<ItemBlockHeadType> getItemSet() {
		return items;
	}
	
	public Set<BlockGenericSkull> getBlockSet() {
		return blocks;
	}

	public Supplier<Supplier<Class<? extends ModelBase>>> getModelSupplier() {
		return modelSupplier;
	}
	
}
