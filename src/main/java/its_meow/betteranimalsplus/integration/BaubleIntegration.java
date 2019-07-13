package its_meow.betteranimalsplus.integration;

import its_meow.betteranimalsplus.common.item.ItemWolfCapeBaubles;
import its_meow.betteranimalsplus.init.ModItems;

public class BaubleIntegration {

    public static void preInit() {
        ItemWolfCapeBaubles classic = new ItemWolfCapeBaubles(1);
        ItemWolfCapeBaubles timber = new ItemWolfCapeBaubles(2);
        ItemWolfCapeBaubles black = new ItemWolfCapeBaubles(3);
        ModItems.WOLF_CAPE_CLASSIC = classic;
        ModItems.WOLF_CAPE_TIMBER = timber;
        ModItems.WOLF_CAPE_BLACK = black;
    }

}
