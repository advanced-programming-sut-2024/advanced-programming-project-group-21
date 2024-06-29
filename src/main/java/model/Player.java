package model;

import enums.Card.CommandersEnum;
import enums.Card.FactionsEnum;
import model.Commanders.Commander;
import model.Factions.Faction;
import model.User.User;

import java.util.ArrayList;

public class Player extends User {
    private ArrayList<Card> hand = new ArrayList<>();
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> discardPile = new ArrayList<>();
    private User user;
    private int availableCards = 0;
    private CommandersEnum commander;
    private int lives;
    private FactionsEnum currentFaction;
    private int roundsWon = 0;
    private int roundsLost = 0;
    private int roundsDrawn = 0;


    public Player(User user) {
        super(user.getUsername(), user.getNickname(), user.getPassword(), user.getEmail());
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public ArrayList<Card> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(ArrayList<Card> discardPile) {
        this.discardPile = discardPile;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAvailableCards() {
        return availableCards;
    }

    public void setAvailableCards(int availableCards) {
        this.availableCards = availableCards;
    }

    public CommandersEnum getCommander() {
        return commander;
    }

    public void setCommander(CommandersEnum commander) {
        this.commander = commander;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public FactionsEnum getCurrentFaction() {
        return currentFaction;
    }

    public void setCurrentFaction(FactionsEnum currentFaction) {
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

    public static void addToDeck(String cardName, int count) {

    }

    public static void deleteFromDeck(int cardNumber, int count) {

    }
}
