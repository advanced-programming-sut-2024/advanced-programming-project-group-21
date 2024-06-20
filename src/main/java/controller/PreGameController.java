package controller;

import enums.Card.CardEnum;
import enums.Card.Factions;
import model.Card;
import model.PreGame;

import java.util.ArrayList;

public class PreGameController {
    public void showCurrentMenu(){

    }

    public void exitMenu(){

    }

    public void enterMenu(String name){

    }

    public void showFactions(){

    }

    public void selectFaction(String factionName){

    }

    public void showCards(){

    }

    public void showDeck(){

    }

    public void showInfoCurrentUser(){

    }

    public void saveDeckWithName(String name){

    }

    public void saveDeckWithAddress(String address){

    }

    public void loadDeckWithName(String name){

    }

    public void loadDeckWithAddress(String address){

    }

    public void showLeaders(){

    }

    public void selectLeader(int leaderNumber){

    }

    public void addToDeck(String cardName, int count){

    }

    public void deleteFromDeck(String cardName, int count){

    }

    public void changeTurn(){

    }

    public void startGame(){

    }

    public ArrayList<Card> loadPregameCards(Factions faction){
        deletePreGameCards(); // Clear the preGameCards list
        ArrayList<Card> cards = new ArrayList<>();

        for(CardEnum cardEnum : CardEnum.values()){
            if(cardEnum.getFaction().equals(faction) || cardEnum.getFaction().equals(Factions.NEUTRAL)){
                for(int i = 0; i < cardEnum.getPreGameCount(); i++){
                    Card card = new Card(cardEnum);
                    cards.add(card);
                    ApplicationController.preGame.addCardToPreGameCards(card);
                }
            }
        }

        return cards;
    }

    public void initialize(){
        PreGame preGame = new PreGame();
        ApplicationController.preGame = preGame;
    }

    private void deletePreGameCards(){
        ApplicationController.preGame.setPreGameCards(new ArrayList<>());
        ApplicationController.preGame.setPreGameHBoxList(new ArrayList<>());
    }
}
