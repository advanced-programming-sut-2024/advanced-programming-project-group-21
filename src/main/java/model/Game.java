package model;

import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player enemyPlayer;
    private ArrayList<AnchorPane> player1Hand;
    private ArrayList<AnchorPane> player2Hand;

    public Game(PreGame preGame) {
        this.player1 = preGame.getPlayer1();
        this.player2 = preGame.getPlayer2();
    }

    public void switchPlayer() {
        if (currentPlayer == player1) {
            currentPlayer = player2;
            enemyPlayer = player1;
        } else {
            currentPlayer = player1;
            enemyPlayer = player2;
        }
    }

    public void startGame() {
        // start the game
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public Player getEnemyPlayer() {
        return enemyPlayer;
    }

    public ArrayList<AnchorPane> getPlayer1Hand() {
        return player1Hand;
    }

    public void setPlayer1Hand(ArrayList<AnchorPane> player1Hand) {
        this.player1Hand = player1Hand;
    }

    public ArrayList<AnchorPane> getPlayer2Hand() {
        return player2Hand;
    }

    public void setPlayer2Hand(ArrayList<AnchorPane> player2Hand) {
        this.player2Hand = player2Hand;
    }

    public void addToPlayer1Hand(AnchorPane card) {
        player1Hand.add(card);
    }

    public void addToPlayer2Hand(AnchorPane card) {
        player2Hand.add(card);
    }

    public void removeFromPlayer1Hand(AnchorPane card) {
        player1Hand.remove(card);
    }

    public void removeFromPlayer2Hand(AnchorPane card) {
        player2Hand.remove(card);
    }
}
