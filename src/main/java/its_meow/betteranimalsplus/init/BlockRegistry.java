package its_meow.betteranimalsplus.init;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import com.google.common.base.Preconditions;

import its_meow.betteranimalsplus.client.HeadItemMeshDefinition;
import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.common.block.BlockHandOfFate;
import its_meow.betteranimalsplus.common.block.BlockHirschgeistSkull;
import its_meow.betteranimalsplus.common.block.BlockTrillium;
import its_meow.betteranimalsplus.common.item.ItemBlockSkull;
import its_meow.betteranimalsplus.common.tileentity.*;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(its_meow.betteranimalsplus.Ref.MOD_ID)
public class BlockRegistry {

	public static final BlockTrillium trillium = new BlockTrillium();
	public static final BlockHirschgeistSkull hirschgeistskull = new BlockHirschgeistSkull();
	public static final BlockHandOfFate handoffate = new BlockHandOfFate();

	// Generic Skulls
	public static final BlockGenericSkull deerhead = new BlockGenericSkull(TileEntityDeerHead.class, "deerhead", false, 2);
	public static final BlockGenericSkull wolfhead = new BlockGenericSkull(TileEntityWolfHead.class, "wolfhead", true, 4);
	public static final BlockGenericSkull reindeerhead = new BlockGenericSkull(TileEntityReindeerHead.class, "reindeerhead", false, 4);
	public static final BlockGenericSkull foxhead = new BlockGenericSkull(TileEntityFoxHead.class, "foxhead", true, 4);
	public static final BlockGenericSkull boarhead = new BlockGenericSkull(TileEntityBoarHead.class, "boarhead", false, 4);

	public static HashMap<BlockGenericSkull, ItemBlockSkull> genericskulls = new HashMap<BlockGenericSkull, ItemBlockSkull>();

	public static void addGenericSkull(BlockGenericSkull block) {
		genericskulls.put(block, new ItemBlockSkull(block, block.allowFloor));
	}

	public static ItemBlockSkull getSkullItemForBlock(BlockGenericSkull block) {
		return genericskulls.get(block);
	}

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

			BlockRegistry.addGenericSkull(BlockRegistry.deerhead);
			BlockRegistry.addGenericSkull(BlockRegistry.wolfhead);
			BlockRegistry.addGenericSkull(BlockRegistry.reindeerhead);
			BlockRegistry.addGenericSkull(BlockRegistry.foxhead);
			BlockRegistry.addGenericSkull(BlockRegistry.boarhead);

			final Block[] blocks = {
					trillium,
					hirschgeistskull,
					handoffate,
			};

			registry.registerAll(blocks);

			genericskulls.keySet().forEach(b -> registry.register(b));

			GameRegistry.registerTileEntity(TileEntityTrillium.class, new ResourceLocation(trillium.getRegistryName() +  "tileentity"));
			GameRegistry.registerTileEntity(TileEntityHirschgeistSkull.class, new ResourceLocation(hirschgeistskull.getRegistryName() +  "tileentity"));
			GameRegistry.registerTileEntity(TileEntityHandOfFate.class,  new ResourceLocation(handoffate.getRegistryName() +  "tileentity"));

			for(BlockGenericSkull block : genericskulls.keySet()) {
				GameRegistry.registerTileEntity(block.teClass, new ResourceLocation(block.getRegistryName() + "tileentity"));
			}
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
					hirschgeistskull.getItemBlock(),
					BlockHandOfFate.getItemBlock(),
			};

			final IForgeRegistry<Item> registry = event.getRegistry();

			for (final ItemBlock item : items) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}

			for (final ItemBlock item : genericskulls.values()) {
				final Block block = item.getBlock();
				final ResourceLocation registryName = Preconditions.checkNotNull(block.getRegistryName(), "Block %s has null registry name", block);
				registry.register(item.setRegistryName(registryName));
				ITEM_BLOCKS.add(item);
			}
		}

		@SubscribeEvent
		public static void registerItemBlockModels(final ModelRegistryEvent event) {
			//OBJLoader.INSTANCE.addDomain(Ref.MOD_ID);
			initModel(trillium, 0);
			initModel(hirschgeistskull, 0);
			initModel(handoffate, 0);

			// generics
			for(BlockGenericSkull skull : genericskulls.keySet()) {
				HeadItemMeshDefinition meshDefinition = new HeadItemMeshDefinition(skull);
				ItemBlockSkull item = (ItemBlockSkull) skull.getItemBlock();
				ModelBakery.registerItemVariants(item, meshDefinition.defaultModelResourceLocation);
				for (int i = 0; i < skull.texCount; i++)
				{
					ItemStack stack = new ItemStack(item);
					stack.setTagCompound(new NBTTagCompound());
					stack.getTagCompound().setInteger("TYPENUM", i);
					ModelBakery.registerItemVariants(item, meshDefinition.getModelLocation(stack));
				}
				ModelLoader.setCustomMeshDefinition(item, meshDefinition);
			}
		}


		public static void initModelMeta(Block block, int meta) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "type=" + meta));
		}

		public static void initModel(Block block, int meta) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "inventory"));
		}

		public static void initModelOBJ(Block block, int meta) {
			ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName() + ".obj", "inventory"));
		}

	}
}
