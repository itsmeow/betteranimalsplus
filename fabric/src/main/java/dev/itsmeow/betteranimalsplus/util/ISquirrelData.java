package dev.itsmeow.betteranimalsplus.util;

import java.util.function.Function;

public interface ISquirrelData {

    void setSquirrelKills(int kills);

    void setSquirrelKills(Function<Integer, Integer> mutator);

    int getSquirrelKills();

}
