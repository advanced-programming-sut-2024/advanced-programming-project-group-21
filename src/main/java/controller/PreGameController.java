package controller;

import enums.Card.CardEnum;
import enums.Card.FactionsEnum;
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

    public ArrayList<Card> loadPregameCards(FactionsEnum faction){
        deletePreGameCards(); // Clear the preGameCards list
        ArrayList<Card> cards = new ArrayList<>();
        for(CardEnum cardEnum : CardEnum.values()){
            if(cardEnum.getFaction().equals(faction) ||
                    cardEnum.getFaction().equals(FactionsEnum.NEUTRAL) ||
                    ApplicationController.preGame.getPreGameCards().stream().anyMatch(card -> card.getName().equals(cardEnum.getName()))){
                for(int i = 0; i < cardEnum.getPreGameCount(); i++){
                    Card card = new Card(cardEnum);
                    cards.add(card);
                    ApplicationController.preGame.addCardToPreGameCards(card);
                    System.out.println(cardEnum.getName() + " is " + card);
                }
            }
        }

        return cards;
    }

    private void deletePreGameCards(){
        ApplicationController.preGame.setPreGameCards(new ArrayList<>());
        ApplicationController.preGame.setPreGameHBoxList(new ArrayList<>());
    }

    public void moveCardToDeck(Card inputCard) {
        Card card = null;
        for(Card tempCard : ApplicationController.preGame.getPreGameCards()){
            if(tempCard.getName().equals(inputCard.getName())){
                card = tempCard;
                break;
            }
        }
        ApplicationController.preGame.addCardToDeckCards(card);
        ApplicationController.preGame.getPreGameCards().remove(card);
    }

    public void moveCardToPreGame(Card inputCard) {
        Card card = null;
        for(Card tempCard : ApplicationController.preGame.getDeckCards()){
            if(tempCard.getName().equals(inputCard.getName())){
                card = tempCard;
                break;
            }
        }
        ApplicationController.preGame.addCardToPreGameCards(card);
        ApplicationController.preGame.getDeckCards().remove(card);
    }
}
