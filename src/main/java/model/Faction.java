package model;

import java.util.ArrayList;

public class Faction {
    private static ArrayList<Card> cards = new ArrayList<>();
    private String name;

    public static ArrayList<Card> getCards() {
        return cards;
    }

    public static void setCards(ArrayList<Card> cards) {
        Faction.cards = cards;
    }


    public void doAbility() {

    }

}
