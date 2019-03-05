package its_meow.betteranimalsplus.init;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

import com.google.common.base.Preconditions;

import its_meow.betteranimalsplus.BetterAnimalsPlusMod;
import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.block.BlockHandOfFate;
import its_meow.betteranimalsplus.common.block.BlockTrillium;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import its_meow.betteranimalsplus.util.HeadTypes;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Item.Properties;
import net.minecraft.item.ItemBlock;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;

public class BlockRegistry {

	public static final BlockTrillium trillium = new BlockTrillium();
	public static final BlockHandOfFate handoffate = new BlockHandOfFate();

	public static Map<HeadTypes, TileEntityType<?>> skulltetypes = new HashMap<>();

	@Mod.EventBusSubscriber(modid = Ref.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
	public static class RegistrationHandler {

		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			final IForgeRegistry<Block> registry = event.getRegistry();

			registry.registerAll(trillium, handoffate);

			for(HeadTypes type : HeadTypes.values()) {
				registry.registerAll(type.getBlockSet().toArray(new Block[0]));
			}
		}

		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final ItemBlock[] items = {
					new ItemBlock(BlockRegistry.trillium, new Properties().group(BetterAnimalsPlusMod.group)),
					 BlockHandOfFate.getItemBlock()
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for(final ItemBlock item : items) {
				Block block = item.getBlock();
				ResourceLocation loc = item.getRegistryName();
				if(item.getRegistryName() == null) {
					loc = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
					item.setRegistryName(loc);
				}
				registry.register(item);
			}

			for(HeadTypes type : HeadTypes.values()) {
				registry.registerAll(type.getItemSet().toArray(new Item[0]));
			}
		}

		public static final TileEntityType<?> TRILLIUM_TYPE = TileEntityType.Builder.create(TileEntityTrillium::new)
				.build(null).setRegistryName(Ref.MOD_ID, "trilliumtilentity");
		public static final TileEntityType<?> HAND_OF_FATE_TYPE = TileEntityType.Builder.create(TileEntityHandOfFate::new)
				.build(null).setRegistryName(Ref.MOD_ID, "handoffatetilentity");

		@SubscribeEvent
		public static void registerTileEntities(final RegistryEvent.Register<TileEntityType<?>> event) {
			final IForgeRegistry<TileEntityType<?>> reg = event.getRegistry();
			reg.register(TRILLIUM_TYPE);
			reg.register(HAND_OF_FATE_TYPE);
			
			for(HeadTypes type : HeadTypes.values()) {
				reg(reg, type.name, () -> type.teFactory.apply(type), type);
			}
		}

		private static void reg(IForgeRegistry<TileEntityType<?>> reg, String name, Supplier<? extends TileEntity> factory,
				HeadTypes type) {
			TileEntityType<?> tetype = TileEntityType.Builder.create(factory).build(null).setRegistryName(Ref.MOD_ID, name + "tileentity");
			reg.register(tetype);
			BlockRegistry.skulltetypes.put(type, tetype);
		}

	}

	public static TileEntityType<?> getSkullTileEntityType(HeadTypes type) {
		return BlockRegistry.skulltetypes.get(type);
	}

}
