package model;

public class Game {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Player enemyPlayer;

    public Game(Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.currentPlayer = player1;
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



    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }
}
