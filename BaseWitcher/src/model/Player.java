package model;

import java.util.ArrayList;

public class Player extends User {
    private static ArrayList<Card> hand = new ArrayList<>();
    private static ArrayList<Card> deck = new ArrayList<>();
    private static ArrayList<Card> discardPile = new ArrayList<>();
    private static ArrayList<Spell> spellCards = new ArrayList<>();
    private static User user;
    private int availableCards = 0;
    private Commander commander;
    private int lives;
    private Faction currentFaction;
    private int roundsWon = 0;
    private int roundsLost = 0;
    private int roundsDrawn = 0;


    public Player(String username, String nickname, String password, String email) {
        super(username, nickname, password, email);
    }

    public static ArrayList<Card> getHand() {
        return hand;
    }

    public static void setHand(ArrayList<Card> hand) {
        Player.hand = hand;
    }

    public static ArrayList<Card> getDeck() {
        return deck;
    }

    public static void setDeck(ArrayList<Card> deck) {
        Player.deck = deck;
    }

    public static ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    public static void setDiscardPile(ArrayList<Card> discardPile) {
        Player.discardPile = discardPile;
    }

    public static ArrayList<Spell> getSpellCards() {
        return spellCards;
    }

    public static void setSpellCards(ArrayList<Spell> spellCards) {
        Player.spellCards = spellCards;
    }

    public static User getUser() {
        return user;
    }

    public static void setUser(User user) {
        Player.user = user;
    }

    public int getAvailableCards() {
        return availableCards;
    }

    public void setAvailableCards(int availableCards) {
        this.availableCards = availableCards;
    }

    public Commander getCommander() {
        return commander;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public Faction getCurrentFaction() {
        return currentFaction;
    }

    public void setCurrentFaction(Faction currentFaction) {
        this.currentFaction = currentFaction;
    }

    public int getRoundsDrawn() {
        return roundsDrawn;
    }

    public void setRoundsDrawn(int roundsDrawn) {
        this.roundsDrawn = roundsDrawn;
    }

    public int getRoundsLost() {
        return roundsLost;
    }

    public void setRoundsLost(int roundsLost) {
        this.roundsLost = roundsLost;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }
}
