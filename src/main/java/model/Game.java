package model;

import enums.GameStates;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player enemyPlayer;
    private ArrayList<AnchorPane> player1Hand = new ArrayList<>();
    private ArrayList<AnchorPane> player2Hand = new ArrayList<>();

    private GameStates gameState;

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
    public ArrayList<AnchorPane> getCurrentPlayerHand(){
        if(currentPlayer.equals(player1)){
            return player1Hand;
        }
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

    public GameStates getGameState() {
        return gameState;
    }

    public void setGameState(GameStates gameState) {
        this.gameState = gameState;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setEnemyPlayer(Player enemyPlayer) {
        this.enemyPlayer = enemyPlayer;
    }
}
