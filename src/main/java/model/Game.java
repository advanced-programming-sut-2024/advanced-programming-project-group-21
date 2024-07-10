package model;

import enums.GameStates;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player enemyPlayer;
    private int round = 1;

    private GameStates gameState = GameStates.PRE_GAME;

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

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void start() {
    }
}
