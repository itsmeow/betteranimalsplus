package its_meow.betteranimalsplus.proxy;

import its_meow.betteranimalsplus.client.model.ModelHirschgeistHelmet;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockHandOfFate;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderBlockTrillium;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderGenericHead;
import its_meow.betteranimalsplus.client.renderer.tileentity.RenderGenericHeadFloor;
import its_meow.betteranimalsplus.common.block.BlockGenericSkull;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHandOfFate;
import its_meow.betteranimalsplus.common.tileentity.TileEntityHead;
import its_meow.betteranimalsplus.common.tileentity.TileEntityTrillium;
import its_meow.betteranimalsplus.init.ModBlocks;
import net.minecraft.client.model.ModelBiped;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy implements ISidedProxy {

    public static final ModelHirschgeistHelmet armorModel = new ModelHirschgeistHelmet();

    @Override
    public void preInit(FMLPreInitializationEvent event) {

    }

    @Override
    public void init(FMLInitializationEvent event) {
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityTrillium.class, new RenderBlockTrillium());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHandOfFate.class, new RenderBlockHandOfFate());
        ClientRegistry.bindTileEntitySpecialRenderer(TileEntityHead.class, new RenderGenericHead());
        for (BlockGenericSkull block : ModBlocks.genericskulls.keySet()) {
            if (block.allowFloor) {
                ClientRegistry.bindTileEntitySpecialRenderer(block.teClass.asSubclass(TileEntityHead.class), new RenderGenericHeadFloor());
            }
        }
    }

    @Override
    public void postInit(FMLPostInitializationEvent e) {

    }

    public static ModelBiped getArmorModel() {
        return armorModel;
    }

}
