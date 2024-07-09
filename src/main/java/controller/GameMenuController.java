package controller;

import javafx.scene.layout.AnchorPane;
import model.Card;
import model.Player;
import model.Game;

import java.util.ArrayList;

import enums.Card.FactionsEnum;

public class GameMenuController {

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

