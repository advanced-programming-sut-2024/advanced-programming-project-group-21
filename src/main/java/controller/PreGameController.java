package controller;

import enums.Card.CardEnum;
import enums.Card.FactionsEnum;
import model.Card;
import model.Player;
import model.PreGame;
import model.User.User;

import java.util.ArrayList;

import static controller.ApplicationController.preGame;

public class PreGameController {
    public void loadPregameCards(FactionsEnum faction) {
        deletePreGameCards(faction); // Clear the preGameCards list
        ArrayList<Card> cards = new ArrayList<>();
        outer:
        for (CardEnum cardEnum : CardEnum.values()) {
            if (cardEnum.getFaction().equals(faction) || cardEnum.getFaction().equals(FactionsEnum.NEUTRAL)) {
                for (Card card : preGame.getDeckCards()) {
                    if (card.getCardEnum().equals(cardEnum)) {
                        continue outer;
                    }
                }
                for (Card card : preGame.getPreGameCards()) {
                    if (card.getCardEnum().equals(cardEnum)) {
                        continue outer;
                    }
                }
                for (int i = 0; i < cardEnum.getPreGameCount(); i++) {
                    Card card = new Card(cardEnum);
                    cards.add(card);
                    preGame.addCardToPreGameCards(card);
                    System.out.println(cardEnum.getName() + " is " + card);
                }
            }
        }
    }

    void deletePreGameCards(FactionsEnum factionsEnum) {
        ArrayList<Card> preGameCards = new ArrayList<>();
        ArrayList<Card> deckCards = new ArrayList<>();
        for (Card card : preGame.getPreGameCards()) {
            if (card.getFaction().equals(factionsEnum) || card.getFaction().equals(FactionsEnum.NEUTRAL)) {
                preGameCards.add(card);
            }
        }
        for (Card card : preGame.getDeckCards()) {
            if (card.getFaction().equals(factionsEnum) || card.getFaction().equals(FactionsEnum.NEUTRAL)) {
                deckCards.add(card);
            }
        }
        preGame.setPreGameCards(preGameCards);
        preGame.setDeckCards(deckCards);
    }

    public void moveCardToDeck(Card inputCard) {
        Card card = null;
        for (Card tempCard : preGame.getPreGameCards()) {
            if (tempCard.getName().equals(inputCard.getName())) {
                card = tempCard;
                break;
            }
        }
        preGame.addCardToDeckCards(card);
        preGame.getPreGameCards().remove(card);
    }

    public void moveCardToPreGame(Card inputCard) {
        Card card = null;
        for (Card tempCard : preGame.getDeckCards()) {
            if (tempCard.getName().equals(inputCard.getName())) {
                card = tempCard;
                break;
            }
        }
        preGame.addCardToPreGameCards(card);
        preGame.getDeckCards().remove(card);
    }

    public void saveToPlayer() {
        PreGame preGame = ApplicationController.preGame;
        Player player = preGame.getCurrentPlayer();
        player.setDeck(preGame.getDeckCards());
        player.setCommander(preGame.getCommander());
        player.setCurrentFaction(preGame.getFaction());
    }

    public void createPlayers() {
        Player player1 = new Player(ApplicationController.getLoggedInUser());
        preGame.setPlayer1(player1);
        preGame.setCurrentPlayer(player1);
    }

    public void createPlayer2(String username){
        User user = new User("", username, "dwkbhwdjbinwdqud7821guydb18d", "d3gyu21gu2dygu12gdud");
        Player player2 = new Player(user);
        preGame.setPlayer2(player2);
        preGame.setCurrentPlayer(preGame.getPlayer2());
    }
}
