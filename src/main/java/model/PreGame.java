package model;

import enums.Card.FactionsEnum;
import javafx.scene.layout.HBox;

import java.util.ArrayList;

public class PreGame {
    private ArrayList<Card> preGameCards = new ArrayList<>();
    private ArrayList<Card> deckCards = new ArrayList<>();
    private ArrayList<HBox> preGameHBoxList = new ArrayList<>();

    private ArrayList<HBox> deckHBoxList = new ArrayList<>();
    private FactionsEnum faction = FactionsEnum.SKELLIGE;


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
}
