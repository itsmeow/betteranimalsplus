package its_meow.betteranimalsplus.client;

import its_meow.betteranimalsplus.Ref;
import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.common.item.ItemBlockSkull;
import its_meow.betteranimalsplus.init.BlockRegistry;
import its_meow.betteranimalsplus.init.ItemRegistry;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Ref.MOD_ID, value = Side.CLIENT)
public class EventHandlerClient {

    /*
     * @SubscribeEvent
     * public void textureStitchEventPre(TextureStitchEvent.Pre event)
     * {
     * event.getMap().registerSprite(TextureRegistry.sparks);
     * event.getMap().registerSprite(TextureRegistry.ember_left);
     * event.getMap().registerSprite(TextureRegistry.ember_mid);
     * event.getMap().registerSprite(TextureRegistry.ember_right);
     * }
     */

    @SubscribeEvent
    public static void registerItemBlockModels(final ModelRegistryEvent event) {
        // Blocks

        // OBJLoader.INSTANCE.addDomain(Ref.MOD_ID);

        initModel(BlockRegistry.trillium, 0);
        initModel(BlockRegistry.hirschgeistskull, 0);
        initModel(BlockRegistry.handoffate, 0);

        // generics
        for (BlockGenericSkull skull : BlockRegistry.genericskulls.keySet()) {
            HeadItemMeshDefinition meshDefinition = new HeadItemMeshDefinition(skull);
            ItemBlockSkull item = (ItemBlockSkull) skull.getItemBlock();
            ModelBakery.registerItemVariants(item, meshDefinition.defaultModelResourceLocation);
            for (int i = 1; i <= skull.texCount; i++) {
                ItemStack stack = new ItemStack(item);
                stack.setTagCompound(new NBTTagCompound());
                stack.getTagCompound().setInteger("TYPENUM", i);
                ModelBakery.registerItemVariants(item, meshDefinition.getModelLocation(stack));
            }
            ModelLoader.setCustomMeshDefinition(item, meshDefinition);
        }

        // Items

        initModel(ItemRegistry.venisonRaw, 0);
        initModel(ItemRegistry.venisonCooked, 0);
        initModel(ItemRegistry.itemHirschgeistSkullWearable, 0);
        initModel(ItemRegistry.antler, 0);
        initModel(ItemRegistry.goatMilk, 0);
        initModel(ItemRegistry.goatCheese, 0);
        initModel(ItemRegistry.pheasantRaw, 0);
        initModel(ItemRegistry.pheasantCooked, 0);
    }

    public static void initModel(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void initModel(Block block, int meta) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName(), "inventory"));
    }

    public static void initModelOBJ(Block block, int meta) {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(block.getRegistryName() + ".obj", "inventory"));
    }

}
