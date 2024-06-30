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

    public void passRound(){

    }

    private void endGame(){

    }

    private void checkIfGameEnded(){

    }

    private void createGameHistory(Player player1, Player player2){

    }

    private void addScoreToGameHistoryRound(Player player1, Player player2){

    }

    private void completeGameHistory(Player player1, Player player2){

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
}
