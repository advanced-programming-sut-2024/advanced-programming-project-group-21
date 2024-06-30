package controller;

import model.Card;
import model.Player;

import java.util.ArrayList;

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

        // TODO: implement this method
//        player1.getCurrentFaction().doAbility();
//        player2.getCurrentFaction().doAbility();
    }

    public void createStartingHand() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();
        ArrayList<Card> deck = currentPlayer.getDeck();
        ArrayList<Card> hand = new ArrayList<>();

        for (int i = 9; i >= 0; i--) {
            hand.add(deck.get(i));
            deck.remove(i);
        }


        currentPlayer.setHand(hand);

        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();
        deck = enemyPlayer.getDeck();
        hand = new ArrayList<>();

        for (int i = 9; i >= 0; i--) {
            hand.add(deck.get(i));
            deck.remove(i);
        }

        enemyPlayer.setHand(hand);
    }
}
