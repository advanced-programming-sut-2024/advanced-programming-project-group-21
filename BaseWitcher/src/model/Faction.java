package model;

import java.util.ArrayList;

public class Faction {
    private static ArrayList<Commander> commanders = new ArrayList<>();
    private static ArrayList<Card> cards = new ArrayList<>();
    private static Commander currentCommander;
    private String name;

    public static ArrayList<Commander> getCommanders() {
        return commanders;
    }

    public static void setCommanders(ArrayList<Commander> commanders) {
        Faction.commanders = commanders;
    }

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void setCards(ArrayList<Card> cards) {
        Faction.cards = cards;
    }

    public static Commander getCurrentCommander() {
        return currentCommander;
    }

    public static void setCurrentCommander(Commander currentCommander) {
        Faction.currentCommander = currentCommander;
    }

    public void doAbility() {

    }

}
