package model.Commanders;

import model.Factions.Faction;

public class Commander {
    private String name;
    private static boolean hasDoneAction = false;
    private static Faction faction;

    public Commander(String name) {
        this.name = name;
    }


    public void doAbility() {

    }
}
