package model;

import enums.Card.CommandersEnum;
import enums.Card.FactionsEnum;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class PreGame {
    private ArrayList<Card> preGameCards = new ArrayList<>();
    private ArrayList<Card> deckCards = new ArrayList<>();
    private ArrayList<HBox> preGameHBoxList = new ArrayList<>();

    private ArrayList<HBox> deckHBoxList = new ArrayList<>();
    private FactionsEnum faction = FactionsEnum.SKELLIGE;
    private CommandersEnum commander = null;
    private boolean enoughUnits = false;
    private boolean validSpecials = true;
    private Player player1 = null;
    private Player player2 = null;
    private Player currentPlayer = player1;
    private boolean firstPlayer = true;


    public void addCardToPreGameCards(Card card){
        preGameCards.add(card);
    }

    public void addCardToDeckCards(Card card){
        deckCards.add(card);
    }

    public void setPreGameCards(ArrayList<Card> preGameCards) {
        this.preGameCards = preGameCards;
    }

    public void setPreGameHBoxList(ArrayList<HBox> preGameHBoxList) {
        this.preGameHBoxList = preGameHBoxList;
    }

    public ArrayList<Card> getPreGameCards() {
        return preGameCards;
    }

    public ArrayList<Card> getDeckCards() {
        return deckCards;
    }

    public ArrayList<HBox> getPreGameHBoxList() {
        return preGameHBoxList;
    }

    public ArrayList<HBox> getDeckHBoxList() {
        return deckHBoxList;
    }

    public void setDeckCards(ArrayList<Card> deckCards) {
        this.deckCards = deckCards;
    }

    public void setDeckHBoxList(ArrayList<HBox> deckHBoxList) {
        this.deckHBoxList = deckHBoxList;
    }

    public FactionsEnum getFaction() {
        return faction;
    }

    public void setFaction(FactionsEnum faction) {
        this.faction = faction;
    }

    public void getPreGameCardByName(){};

    public CommandersEnum getCommander() {
        return commander;
    }

    public void setCommander(CommandersEnum commander) {
        this.commander = commander;
    }

    public boolean isEnoughUnits() {
        return enoughUnits;
    }

    public void setEnoughUnits(boolean enoughUnits) {
        this.enoughUnits = enoughUnits;
    }

    public boolean isValidSpecials() {
        return validSpecials;
    }

    public void setValidSpecials(boolean validSpecials) {
        this.validSpecials = validSpecials;
    }

    public boolean canStartGame() {
        return enoughUnits && validSpecials;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public boolean isFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(boolean firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
