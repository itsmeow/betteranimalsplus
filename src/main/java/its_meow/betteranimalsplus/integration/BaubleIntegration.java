package its_meow.betteranimalsplus.integration;

import its_meow.betteranimalsplus.common.item.ItemBearCapeBaubles;
import its_meow.betteranimalsplus.common.item.ItemWolfCapeBaubles;
import its_meow.betteranimalsplus.init.ModItems;

public class BaubleIntegration {

    public static void preInit() {
        ModItems.WOLF_CAPE_CLASSIC = new ItemWolfCapeBaubles("classic", ModItems.WOLF_PELT_SNOWY);
        ModItems.WOLF_CAPE_TIMBER = new ItemWolfCapeBaubles("timber", ModItems.WOLF_PELT_TIMBER);
        ModItems.WOLF_CAPE_BLACK = new ItemWolfCapeBaubles("black", ModItems.WOLF_PELT_BLACK);

        ModItems.WOLF_CAPE_ARCTIC = new ItemWolfCapeBaubles("arctic", ModItems.WOLF_PELT_ARCTIC);
        ModItems.WOLF_CAPE_BROWN = new ItemWolfCapeBaubles("brown", ModItems.WOLF_PELT_BROWN);
        ModItems.WOLF_CAPE_RED = new ItemWolfCapeBaubles("red", ModItems.WOLF_PELT_RED);
        
        ModItems.BEAR_CAPE_BROWN = new ItemBearCapeBaubles("brown", ModItems.BEAR_CAPE_BROWN);
        ModItems.BEAR_CAPE_BLACK = new ItemBearCapeBaubles("black", ModItems.BEAR_CAPE_BLACK);
        ModItems.BEAR_CAPE_KERMODE = new ItemBearCapeBaubles("kermode", ModItems.BEAR_CAPE_KERMODE);
    }

}
