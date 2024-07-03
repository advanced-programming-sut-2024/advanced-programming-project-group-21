package enums.Card;

import controller.ApplicationController;
import javafx.scene.layout.AnchorPane;
import model.App;
import model.Card;
import model.Player;
import view.Game.GameMenuViewController;

public enum CardAbility {
    COMMANDERS_HORN("Commander's Horn", "Double the strength of all unit cards in the row") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            Player player = ApplicationController.game.getCurrentPlayer();
            if (cardObject.getType().equals(CardType.CLOSED_COMBAT_UNIT)) {
                player.getClosedPowerList()[0] *= 2;
            } else if (cardObject.getType().equals(CardType.RANGED_UNIT)) {
                player.getRangedPowerList()[0] *= 2;
            } else if (cardObject.getType().equals(CardType.SIEGE_UNIT)) {
                player.getSiegePowerList()[0] *= 2;
            }
        }
    },
    DECOY("Decoy", "Return a card to your hand") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            ApplicationController.game.getCurrentPlayerHand().add(target);
        }
    },
    MEDIC("Medic", "Choose one card from your discard pile and play it instantly") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) target.getUserData();
            Player player = ApplicationController.game.getCurrentPlayer();
            Card targetCard = (Card) target.getUserData();

            if (targetCard.getType().equals(CardType.CLOSED_COMBAT_UNIT)) {
                player.addToClosedCombatUnits(target);
            } else if (targetCard.getType().equals(CardType.RANGED_UNIT)) {
                player.addToRangedCombatUnits(target);
            } else if (targetCard.getType().equals(CardType.SIEGE_UNIT)) {
                player.addToSiegeCombatUnits(target);
            }
        }
    },
    MORALE_BOOST("Morale Boost", "Adds one to the power of all units in the row (excluding itself)") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            Player player = ApplicationController.game.getCurrentPlayer();
            if (cardObject.getType().equals(CardType.CLOSED_COMBAT_UNIT)) {
                player.getClosedPowerList()[0] += player.getClosedCombatUnits().size() - 1;
            } else if (cardObject.getType().equals(CardType.RANGED_UNIT)) {
                player.getRangedPowerList()[0] += player.getRangedCombatUnits().size() - 1;
            } else if (cardObject.getType().equals(CardType.SIEGE_UNIT)) {
                player.getSiegePowerList()[0] += player.getSiegeCombatUnits().size() - 1;
            }
        }
    },
    MUSTER("Muster", "Play all cards with the same name from your deck and hand instantly") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            Player player = ApplicationController.game.getCurrentPlayer();
            if (cardObject.getType().equals(CardType.CLOSED_COMBAT_UNIT)) {
                for (AnchorPane unit : ApplicationController.game.getCurrentPlayerHand()) {
                    Card unitCard = (Card) unit.getUserData();
                    if (unitCard.getName().equals(cardObject.getName())) {
                        player.addToClosedCombatUnits(unit);
                    }
                }
                for (Card unit : player.getDeck()) {
                    if (unit.getName().equals(cardObject.getName())) {
                        player.addToClosedCombatUnits((new GameMenuViewController()).createCard(unit)); // TODO: ADD HAND AND DECK PANES TO PLAYER INSTEAD OF GAME
                    }
                }
            }
            if (cardObject.getType().equals(CardType.RANGED_UNIT)) {
                for (AnchorPane unit : ApplicationController.game.getCurrentPlayerHand()) {
                    Card unitCard = (Card) unit.getUserData();
                    if (unitCard.getName().equals(cardObject.getName())) {
                        player.addToRangedCombatUnits(unit);
                    }
                }
                for (Card unit : player.getDeck()) {
                    if (unit.getName().equals(cardObject.getName())) {
                        player.addToRangedCombatUnits((new GameMenuViewController()).createCard(unit)); // TODO: ADD HAND AND DECK PANES TO PLAYER INSTEAD OF GAME
                    }
                }
            }
            if (cardObject.getType().equals(CardType.SIEGE_UNIT)) {
                for (AnchorPane unit : ApplicationController.game.getCurrentPlayerHand()) {
                    Card unitCard = (Card) unit.getUserData();
                    if (unitCard.getName().equals(cardObject.getName())) {
                        player.addToSiegeCombatUnits(unit);
                    }
                }
                for (Card unit : player.getDeck()) {
                    if (unit.getName().equals(cardObject.getName())) {
                        player.addToSiegeCombatUnits((new GameMenuViewController()).createCard(unit)); // TODO: ADD HAND AND DECK PANES TO PLAYER INSTEAD OF GAME
                    }
                }
            }
        }
    },
    SPY("Spy", "Place on your opponent's battlefield and get two cards from your deck") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Player player = ApplicationController.game.getEnemyPlayer(); // TODO: BOOKMARK
            for (int i = 1; i >= 0; i--) {
                player.getDeck().get(i);
                player.addToHand(player.getDeck().get(i));
                player.getDeck().remove(i);
            }
        }
    },
    TIGHT_BOND("Tight Bond", "Place next to a card with the same name to increase the strength of both cards") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            Player player = ApplicationController.game.getCurrentPlayer();
            if (cardObject.getType().equals(CardType.CLOSED_COMBAT_UNIT)) {
                player.getClosedPowerList()[0] *= 2;
            } else if (cardObject.getType().equals(CardType.RANGED_UNIT)) {
                player.getRangedPowerList()[0] *= 2;
            } else if (cardObject.getType().equals(CardType.SIEGE_UNIT)) {
                player.getSiegePowerList()[0] *= 2;
            }

        }
    },
    SCORCH("Scorch", "Destroy the strongest cards on the battlefield") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Player player = ApplicationController.game.getEnemyPlayer();
            int max = 0;
            for (AnchorPane unit : player.getClosedCombatUnits()) {
                Card unitCard = (Card) unit.getUserData();
                if (unitCard.getPower() > max) {
                    max = unitCard.getPower();
                }
            }
            for (AnchorPane unit : player.getRangedCombatUnits()) {
                Card unitCard = (Card) unit.getUserData();
                if (unitCard.getPower() > max) {
                    max = unitCard.getPower();
                }
            }
            for (AnchorPane unit : player.getSiegeCombatUnits()) {
                Card unitCard = (Card) unit.getUserData();
                if (unitCard.getPower() > max) {
                    max = unitCard.getPower();
                }
            }
            for (AnchorPane unit : player.getClosedCombatUnits()) {
                Card unitCard = (Card) unit.getUserData();
                if (unitCard.getPower() == max) {
                    player.removeFromClosedCombatUnits(unit);
                }
            }
            for (AnchorPane unit : player.getRangedCombatUnits()) {
                Card unitCard = (Card) unit.getUserData();
                if (unitCard.getPower() == max) {
                    player.removeFromRangedCombatUnits(unit);
                }
            }
            for (AnchorPane unit : player.getSiegeCombatUnits()) {
                Card unitCard = (Card) unit.getUserData();
                if (unitCard.getPower() == max) {
                    player.removeFromSiegeCombatUnits(unit);
                }
            }

        }
    },
    BERSEKER("Berserker", "Turns to a bear when mardroeme is played on it.") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            if (cardObject.getName().equals("Mardroeme")) {
//                cardObject.setName("Bear");
//                cardObject.setPower(10);
            }

        }
    },
    MARDOEME("Mardroeme", "Turns a berserker to a bear.") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) target.getUserData();
            if (cardObject.getName().equals("Berserker")) {
            }

        }
    },
    TRANSFORMERMS("Transformers", "Transforms into a random card from the deck.") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {

        }
    };

    private String name;
    private String description;
//    private String onCardImage; // TODO: Implement this
//    private String effectImage;

    CardAbility(String name, String description) {
        this.name = name;
        this.description = description;
//        this.onCardImage = onCardImage;
//        this.effectImage = effectImage;
    }

    public abstract void doAbility(AnchorPane card, AnchorPane target);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}

