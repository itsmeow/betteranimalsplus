package its_meow.betteranimalsplus.integration;

import its_meow.betteranimalsplus.common.item.ItemWolfCapeBaubles;
import its_meow.betteranimalsplus.init.ModItems;

public class BaubleIntegration {

    public static void preInit() {
        ModItems.WOLF_CAPE_CLASSIC = new ItemWolfCapeBaubles(1);
        ModItems.WOLF_CAPE_TIMBER = new ItemWolfCapeBaubles(2);
        ModItems.WOLF_CAPE_BLACK = new ItemWolfCapeBaubles(3);
    }

}
