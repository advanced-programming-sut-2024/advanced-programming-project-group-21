package enums.Card;

import controller.ApplicationController;
import javafx.scene.layout.AnchorPane;
import model.Card;
import model.Game;
import enums.GameStates;
import model.Player;

import java.util.Random;

import model.GameBoard;
import view.Game.GameMenuViewController;

import java.util.ArrayList;


public enum FactionsEnum {
    // name, image, shield, description
    SKELLIGE("Skellige", "file:src/main/resources/Images/Factions/faction_skellige.jpg", "file:src/main/resources/Images/Icons/deck_shield_skellige.png", "Two random cards from your graveyard will be placed randomly on the battlefield at the beginning of the third round.") {
        @Override
        public void doAbility() {
            Game game = ApplicationController.game;
            Player player = ApplicationController.game.getCurrentPlayer();
            if (game.getGameState() == GameStates.ROUND_3_STARTED) {
                ArrayList<AnchorPane> graveyard = player.getDiscardPile();
                Random random = new Random();
                int randomIndex1 = random.nextInt(graveyard.size());
                int randomIndex2 = random.nextInt(graveyard.size());
                AnchorPane card1Pane = graveyard.get(randomIndex1);
                AnchorPane card2Pane = graveyard.get(randomIndex2);
                Card card1 = (Card) card1Pane.getUserData();
                Card card2 = (Card) card2Pane.getUserData();
                if (card1Pane.getTypeSelector().equals(CardType.CLOSED_COMBAT_UNIT)) {
                    player.getClosedCombatUnits().add(card1Pane);
                } else if (card1Pane.getTypeSelector().equals(CardType.RANGED_UNIT)) {
                    player.getRangedCombatUnits().add(card1Pane);
                } else if (card1Pane.getTypeSelector().equals(CardType.SIEGE_UNIT)) {
                    player.getSiegeCombatUnits().add(card1Pane);
                } else if (card1Pane.getTypeSelector().equals(CardType.AGILE_UNIT)) {
                    player.getClosedCombatUnits().add(card1Pane);
                }
                if (card2Pane.getTypeSelector().equals(CardType.CLOSED_COMBAT_UNIT)) {
                    player.getClosedCombatUnits().add(card2Pane);
                } else if (card2Pane.getTypeSelector().equals(CardType.RANGED_UNIT)) {
                    player.getRangedCombatUnits().add(card2Pane);
                } else if (card2Pane.getTypeSelector().equals(CardType.SIEGE_UNIT)) {
                    player.getSiegeCombatUnits().add(card2Pane);
                } else if (card2Pane.getTypeSelector().equals(CardType.AGILE_UNIT)) {
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
            Game game = ApplicationController.game;
            Player player = ApplicationController.game.getCurrentPlayer();
            if (game.getGameState() == GameStates.ROUND_3_STARTED || game.getGameState() == GameStates.ROUND_2_STARTED || game.getGameState() == GameStates.ROUND_3_ENDED) {
                Card card = player.getDeck().get(0);
                player.addToHand((new GameMenuViewController()).createCard(card));
                player.getDeck().remove(0);
            }
        }
    },
    MONSTERS("Monsters", "file:src/main/resources/Images/Factions/faction_monsters.jpg", "file:src/main/resources/Images/Icons/deck_shield_monsters.png", "After each round, monsters will randomly hold a card from the battlefield to the next round.") {
        @Override
        public void doAbility() {
            Game game = ApplicationController.game;
            Player player = ApplicationController.game.getCurrentPlayer();
            if (game.getGameState() == GameStates.ROUND_3_STARTED || game.getGameState() == GameStates.ROUND_2_STARTED) {
                ArrayList<AnchorPane> firstRow = player.getClosedCombatUnits();
                ArrayList<AnchorPane> secondRow = player.getRangedCombatUnits();
                ArrayList<AnchorPane> thirdRow = player.getSiegeCombatUnits();
                ArrayList<ArrayList> rows = new ArrayList<>();
                rows.add(firstRow);
                rows.add(secondRow);
                rows.add(thirdRow);
                ArrayList<AnchorPane> randomRow = rows.get(new Random().nextInt(rows.size()));
                Card randomCard = (Card) randomRow.get(new Random().nextInt(randomRow.size())).getUserData();
                for (int i = 0; i < 3; i++) {
                    if (!rows.get(i).equals(randomRow)) {
                        for (Object cardPane : rows.get(i)) {
                            rows.get(i).remove(cardPane);
                            player.getDiscardPile().add((AnchorPane) cardPane);
                        }
                    }
                }
                for (AnchorPane cardPane : randomRow) {
                    Card card = (Card) cardPane.getUserData();
                    if (!card.getName().equals(randomCard.getName())) {
                        randomRow.remove(card);
                        player.getDiscardPile().add(cardPane);
                    }
                }

            }
        }
    },

    NILFGAARD("Nilfgaard", "file:src/main/resources/Images/Factions/faction_nilfgaard.jpg", "file:src/main/resources/Images/Icons/deck_shield_nilfgaard.png", "If a round ends in a draw, nilfgaard will win the round.") {
        @Override
        public void doAbility() {
            Game game = ApplicationController.game;
            Player player = ApplicationController.game.getCurrentPlayer();
            Player enemy = ApplicationController.game.getEnemyPlayer();
            if (game.getGameState().equals(GameStates.ROUND_3_STARTED) || game.getGameState().equals(GameStates.ROUND_2_STARTED) || game.getGameState().equals(GameStates.ROUND_3_ENDED)) {
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
            Game game = ApplicationController.game;
            Player player = ApplicationController.game.getCurrentPlayer();
            Player enemy = ApplicationController.game.getEnemyPlayer();
            if (game.getGameState().equals(GameStates.ROUND_3_STARTED) || game.getGameState().equals(GameStates.ROUND_2_STARTED) || game.getGameState().equals(GameStates.ROUND_1_STARTED)) {
                ApplicationController.game.setCurrentPlayer(player);
                ApplicationController.game.setEnemyPlayer(enemy);
            }
        }
    },

    NEUTRAL("Neutral", "file:src/main/resources/Images/Factions/faction_monsters.jpg", "file:src/main/resources/Images/Icons/deck_shield_monsters.png", "Neutral cards can be used by any faction.") {
        @Override
        public void doAbility() {
            Game game = ApplicationController.game;
            if (game.getGameState() == GameStates.ROUND_3_STARTED) {
                // doesn't have an ability
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



