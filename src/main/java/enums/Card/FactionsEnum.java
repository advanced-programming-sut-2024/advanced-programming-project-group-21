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
        public void doAbility(Player player) {
            if (ApplicationController.game.getGameState() == GameStates.ROUND_3_STARTED) {
                ArrayList<AnchorPane> graveyard = player.getDiscardPile();
                Random random = new Random();
                int counter = 2;
                while (counter > 0) {
                    int randomIndex = random.nextInt(graveyard.size());
                    AnchorPane cardPane = graveyard.get(randomIndex);
                    Card card = (Card) cardPane.getUserData();
                    if (card.getType().equals(CardType.SPELL) || card.getType().equals(CardType.WEATHER)) {
                        continue;
                    }
                    addCard(player, cardPane);
                    graveyard.remove(randomIndex);
                    counter--;
                }
            }
        }

        private void addCard(Player player, AnchorPane cardPane) {
            Card card = (Card) cardPane.getUserData();
            if (card.getType().equals(CardType.CLOSED_COMBAT_UNIT)) {
                player.getClosedCombatUnits().add(cardPane);
            } else if (card.getType().equals(CardType.RANGED_UNIT)) {
                player.getRangedCombatUnits().add(cardPane);
            } else if (card.getType().equals(CardType.SIEGE_UNIT)) {
                player.getSiegeCombatUnits().add(cardPane);
            } else if (card.getType().equals(CardType.AGILE_UNIT)) {
                player.getClosedCombatUnits().add(cardPane);
            }
        }
    },
    NORTHERN_REALMS("Northern Realms", "file:src/main/resources/Images/Factions/faction_realms.jpg", "file:src/main/resources/Images/Icons/deck_shield_realms.png", "If the player wins the round, a card will be placed in the player's hand at the beginning of the next round.") {
        @Override
        public void doAbility(Player player) {
            GameStates gameStates = ApplicationController.game.getGameState();
            if ((gameStates == GameStates.ROUND_3_STARTED && player.isWonRound2()) ||
                    (gameStates == GameStates.ROUND_2_STARTED && player.isWonRound1())) {
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
        public void doAbility(Player player) {
            Player enemy = getEnemyPlayer(player);
            GameStates gameStates = ApplicationController.game.getGameState();
            if (gameStates.equals(GameStates.DRAW)) {
                if (enemy.getCurrentFaction().equals(NILFGAARD)) {
                    if (Math.random() < 0.5)
                        new GameMenuViewController().winPlayer(player);
                    else
                        new GameMenuViewController().winPlayer(enemy);
                }
                else{
                    new GameMenuViewController().winPlayer(player);
                }
            }
        }

        private Player getEnemyPlayer(Player player) {
            if (player.equals(ApplicationController.game.getPlayer1())) {
                return ApplicationController.game.getPlayer2();
            } else {
                return ApplicationController.game.getPlayer1();
            }
        }
    },

    SCOIATAEL("Scoiatael", "file:src/main/resources/Images/Factions/faction_scoiatael.jpg", "file:src/main/resources/Images/Icons/deck_shield_scoiatael.png", "Player will always play the first card in the first round. If both players have this faction, first player will be chosen randomly.") {
        @Override
        public void doAbility(Player player) {
            Player enemy = getEnemyPlayer(player);
            GameStates gameStates = ApplicationController.game.getGameState();
            if (gameStates.equals(GameStates.PRE_GAME)){
                if(enemy.getCurrentFaction().equals(SCOIATAEL)){
                    if (Math.random() < 0.5)
                        ApplicationController.game.setCurrentPlayer(player);
                    else
                        ApplicationController.game.setCurrentPlayer(enemy);
                }
            }
        }

        private Player getEnemyPlayer(Player player) {
            if (player.equals(ApplicationController.game.getPlayer1())) {
                return ApplicationController.game.getPlayer2();
            } else {
                return ApplicationController.game.getPlayer1();
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


    public abstract void doAbility(Player player);

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



