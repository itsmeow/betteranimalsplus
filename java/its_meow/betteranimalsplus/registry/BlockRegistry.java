package its_meow.betteranimalsplus.registry;

import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.block.BlockHirschgeistSkull;
import its_meow.betteranimalsplus.block.BlockTrillium;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(its_meow.betteranimalsplus.Ref.MOD_ID)
public class BlockRegistry {
	
	public static final BlockTrillium trillium = new BlockTrillium();
	public static final BlockHirschgeistSkull hirschgeistskull = new BlockHirschgeistSkull();
	
	@Mod.EventBusSubscriber
	public static class RegistrationHandler {
		public static final Set<ItemBlock> ITEM_BLOCKS = new HashSet<>();

		/**
		 * Register this mod's {@link Block}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerBlocks(final RegistryEvent.Register<Block> event) {
			final IForgeRegistry<Block> registry = event.getRegistry();

			final Block[] blocks = {
					trillium,
					//hirschgeistskull,
			};

			registry.registerAll(blocks);

			
		}


		/**
		 * Register this mod's {@link ItemBlock}s.
		 *
		 * @param event The event
		 */
		@SubscribeEvent
		public static void registerItemBlocks(final RegistryEvent.Register<Item> event) {
			final ItemBlock[] items = {
					new ItemBlock(trillium),
					//new ItemBlock(hirschgeistskull),
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
		}
		
		@SubscribeEvent
		public static void registerItemBlockModels(final ModelRegistryEvent event) {
			OBJLoader.INSTANCE.addDomain(Ref.MOD_ID);
			initModelOBJ(trillium, 0);
			//initModel(hirschgeistskull, 0);
		}
		
		
	    public static void initModel(Block block, int meta) {
	        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "inventory"));
	    }
	    
	    public static void initModelOBJ(Block block, int meta) {
	        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName() + ".obj", "inventory"));
	    }
	}
}
