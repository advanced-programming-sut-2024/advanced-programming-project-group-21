package controller;

import javafx.scene.layout.AnchorPane;
import model.Card;
import model.Player;
import model.Game;

import java.util.ArrayList;

import enums.Card.FactionsEnum;

public class GameMenuController {

    public void showCurrentMenu() {

    }

    public void exitMenu() {

    }

    public void enterMenu(String name) {

    }

    public void vetoCard(int cardNumber) {

    }

    public void showInHandDeck(int cardNumber) {

    }

    public void showRemainingCards() {

    }

    public void showOutOfPlayCards() {

    }

    public void showCardsInRow(int rowNumber) {

    }

    public void showSpellInPlay() {

    }

    public void placeCard(int cardNumber, int rowNumber) {

    }

    public void showCommander() {

    }

    public void playCommander() {

    }

    public void showPlayersInfo() {

    }

    public void showPlayersLives() {

    }

    public void showNumOfCardsInHand() {

    }

    public void showTurnInfo() {

    }

    public void showTotalScore() {

    }

    public void showTotalScoreOfRow(int rowNumber) {

    }

    public void passRound() {

    }

    private void endGame() {

    }

    private void checkIfGameEnded() {

    }

    private void createGameHistory(Player player1, Player player2) {

    }

    private void addScoreToGameHistoryRound(Player player1, Player player2) {

    }

    private void completeGameHistory(Player player1, Player player2) {

    }

    public void shuffleDeckCards(Player player) {
        ArrayList<Card> cards = player.getDeck();
        for (int i = 0; i < cards.size(); i++) {
            int randomIndex = (int) (Math.random() * cards.size());
            Card temp = cards.get(i);
            cards.set(i, cards.get(randomIndex));
            cards.set(randomIndex, temp);
        }
        player.setDeck(cards);
    }

    public void setCurrentPlayer() {
        Player player1 = ApplicationController.game.getPlayer1();
        Player player2 = ApplicationController.game.getPlayer2();

        // set current player and enemy player randomly
        if (Math.random() < 0.5) {
            ApplicationController.game.setCurrentPlayer(player1);
            ApplicationController.game.setEnemyPlayer(player2);
        } else {
            ApplicationController.game.setCurrentPlayer(player2);
            ApplicationController.game.setEnemyPlayer(player1);
        }

            player1.getCurrentFaction().doAbility(player1);
       player2.getCurrentFaction().doAbility(player2);
    }
}

