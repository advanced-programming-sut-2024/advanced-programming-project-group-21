package enums.Card;

import controller.ApplicationController;
import javafx.scene.layout.AnchorPane;
import model.Card;
import model.Game;
import enums.GameStates;
import model.Player;
import java.util.Random;
import model.GameBoard;
import java.util.ArrayList;


public enum FactionsEnum {
    // name, image, shield, description
    SKELLIGE("Skellige", "file:src/main/resources/Images/Factions/faction_skellige.jpg", "file:src/main/resources/Images/Icons/deck_shield_skellige.png", "Two random cards from your graveyard will be placed randomly on the battlefield at the beginning of the third round.") {
        @Override
        public void doAbility() {
            if (Game.gameState == GameStates.ROUND_3_STARTED) {
                Player player = ApplicationController.game.getCurrentPlayer();
                ArrayList<Card> graveyard = player.getDiscardPile();
                Random random = new Random();
                int randomIndex1 = random.nextInt(graveyard.size());
                int randomIndex2 = random.nextInt(graveyard.size());
                Card card1 = graveyard.get(randomIndex1);
                Card card2 = graveyard.get(randomIndex2);
                AnchorPane card1Pane = new AnchorPane();
                AnchorPane card2Pane = new AnchorPane();
                card1Pane.setUserData(card1);
                card2Pane.setUserData(card2);
                if (card1.getType().equals(CardType.CLOSED_COMBAT_UNIT)) {
                    player.getClosedCombatUnits().add(card1Pane);
                } else if (card1.getType().equals(CardType.RANGED_UNIT)) {
                    player.getRangedCombatUnits().add(card1Pane);
                } else if (card1.getType().equals(CardType.SIEGE_UNIT)) {
                    player.getSiegeCombatUnits().add(card1Pane);
                } else if (card1.getType().equals(CardType.AGILE_UNIT)) {
                    player.getClosedCombatUnits().add(card1Pane);
                }
                if (card2.getType().equals(CardType.CLOSED_COMBAT_UNIT)) {
                    player.getClosedCombatUnits().add(card2Pane);
                } else if (card2.getType().equals(CardType.RANGED_UNIT)) {
                    player.getRangedCombatUnits().add(card2Pane);
                } else if (card2.getType().equals(CardType.SIEGE_UNIT)) {
                    player.getSiegeCombatUnits().add(card2Pane);
                } else if (card2.getType().equals(CardType.AGILE_UNIT)) {
                    player.getClosedCombatUnits().add(card2Pane);
                }
                graveyard.remove(randomIndex1);
                graveyard.remove(randomIndex2);
            }
        }
    },
    NORTHERN_REALMS("Northern Realms", "file:src/main/resources/Images/Factions/faction_realms.jpg", "file:src/main/resources/Images/Icons/deck_shield_realms.png", "If the player wins the round, a card will be placed in the player's hand at the beginning of the next round.") {
        @Override
        public void doAbility() {
            if (Game.gameState == GameStates.ROUND_3_STARTED || Game.gameState == GameStates.ROUND_2_STARTED || Game.gameState == GameStates.ROUND_3_ENDED) {
                Player player = ApplicationController.game.getCurrentPlayer();
                Card card = player.getDeck().get(0);
                player.addToHand(card);
                player.getDeck().remove(0);
            }
        }
    },
    MONSTERS("Monsters", "file:src/main/resources/Images/Factions/faction_monsters.jpg", "file:src/main/resources/Images/Icons/deck_shield_monsters.png", "After each round, monsters will randomly hold a card from the battlefield to the next round.") {
        @Override
        public void doAbility() {
            if (Game.gameState == GameStates.ROUND_3_STARTED || Game.gameState == GameStates.ROUND_2_STARTED){
            // do ability
            }
        }
    },

    NILFGAARD("Nilfgaard", "file:src/main/resources/Images/Factions/faction_nilfgaard.jpg", "file:src/main/resources/Images/Icons/deck_shield_nilfgaard.png", "If a round ends in a draw, nilfgaard will win the round.") {
        @Override
        public void doAbility() {
            Player player = ApplicationController.game.getCurrentPlayer();
            Player enemy = ApplicationController.game.getEnemyPlayer();
            if (Game.gameState.equals(GameStates.ROUND_3_STARTED) || Game.gameState.equals(GameStates.ROUND_2_STARTED) || Game.gameState.equals(GameStates.ROUND_3_ENDED)) {
                if (player.getCurrentFaction().equals(NILFGAARD) && !enemy.getCurrentFaction().equals(NILFGAARD)) {
                    player.setRoundsWon(player.getRoundsWon() + 1);
                    enemy.setRoundsLost(enemy.getRoundsLost() + 1);
                    enemy.setLives(enemy.getLives() - 1);
                }
            }
        }
    },

    SCOIATAEL("Scoiatael", "file:src/main/resources/Images/Factions/faction_scoiatael.jpg", "file:src/main/resources/Images/Icons/deck_shield_scoiatael.png", "Player will always play the first card in the first round. If both players have this faction, first player will be chosen randomly.") {
        @Override
        public void doAbility() {
            Player player = ApplicationController.game.getCurrentPlayer();
            Player enemy = ApplicationController.game.getEnemyPlayer();
            if (Game.gameState.equals(GameStates.ROUND_3_STARTED) || Game.gameState.equals(GameStates.ROUND_2_STARTED) || Game.gameState.equals(GameStates.ROUND_1_STARTED)) {
                ApplicationController.game.setCurrentPlayer(player);
                ApplicationController.game.setEnemyPlayer(enemy);
            }
        }
    },

    NEUTRAL("Neutral", "file:src/main/resources/Images/Factions/faction_monsters.jpg", "file:src/main/resources/Images/Icons/deck_shield_monsters.png", "Neutral cards can be used by any faction.") {
        @Override
        public void doAbility() {
            if (Game.gameState == GameStates.ROUND_3_STARTED) {
                // do ability
            }
        }
    };


    public abstract void doAbility();

    private String name;
    private String image;
    private String shield;
    private String description;

    FactionsEnum(String name, String image, String shield, String description) {
        this.name = name;
        this.image = image;
        this.shield = shield;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getShield() {
        return shield;
    }
}



