package enums.Card;

import controller.ApplicationController;
import enums.GameStates;
import javafx.scene.layout.AnchorPane;
import model.App;
import model.Card;
import model.Game;
import model.Player;
import view.Game.GameMenuViewController;

import java.util.ArrayList;
import java.util.HashMap;

public enum CardAbility {
    COMMANDERS_HORN("Commander's Horn", "Double the strength of all unit cards in the row","file:src/main/resources/Images/Icons/card_ability_horn.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            Player player = ApplicationController.game.getCurrentPlayer();
            if (cardObject.getCardPosition().equals(CardPositions.CLOSED_COMBAT) ||
                    cardObject.getCardPosition().equals(CardPositions.CLOSED_COMBAT_SPECIAL)) {
                for (AnchorPane unit : player.getClosedCombatUnits()) {
                    Card unitCard = (Card) unit.getUserData();
                    unitCard.setPowerCoefficient(unitCard.getPowerCoefficient());
                }
            } else if (cardObject.getCardPosition().equals(CardPositions.RANGED_COMBAT) ||
                    cardObject.getCardPosition().equals(CardPositions.RANGED_COMBAT_SPECIAL)) {
                for (AnchorPane unit : player.getRangedCombatUnits()) {
                    Card unitCard = (Card) unit.getUserData();
                    unitCard.setPowerCoefficient(unitCard.getPowerCoefficient() * 2);
                }
            } else if (cardObject.getCardPosition().equals(CardPositions.SIEGE_COMBAT) ||
                    cardObject.getCardPosition().equals(CardPositions.SIEGE_COMBAT_SPECIAL)) {
                for (AnchorPane unit : player.getSiegeCombatUnits()) {
                    Card unitCard = (Card) unit.getUserData();
                    unitCard.setPowerCoefficient(unitCard.getPowerCoefficient() * 2);
                }
            }
        }
    },
    DECOY("Decoy", "Return a card to your hand","file:src/main/resources/Images/Icons/card_ability_decoy.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card targetCard = (Card) target.getUserData();
            Player player = ApplicationController.game.getCurrentPlayer();
            if (targetCard.getCardPosition().equals(CardPositions.CLOSED_COMBAT)) {
                player.addToClosedCombatUnits(card);
            } else if (targetCard.getCardPosition().equals(CardPositions.RANGED_COMBAT)) {
                player.addToRangedCombatUnits(card);
            } else if (targetCard.getCardPosition().equals(CardPositions.SIEGE_COMBAT)) {
                player.addToSiegeCombatUnits(card);
            }
            ApplicationController.game.getCurrentPlayer().getHand().add(target);
        }
    },
    MEDIC("Medic", "Choose one card from your discard pile and play it instantly","file:src/main/resources/Images/Icons/card_ability_medic.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Player player = ApplicationController.game.getCurrentPlayer();
            AnchorPane randomCardPane = getRandomCardFromDiscardPile();
            Card randomCard = (Card) randomCardPane.getUserData();

            if(randomCard==null){
                return;
            }
            if (randomCard.getCardPosition().equals(CardPositions.CLOSED_COMBAT)) {
                player.addToClosedCombatUnits(randomCardPane);
            } else if (randomCard.getCardPosition().equals(CardPositions.RANGED_COMBAT)) {
                player.addToRangedCombatUnits(randomCardPane);
            } else if (randomCard.getCardPosition().equals(CardPositions.SIEGE_COMBAT)) {
                player.addToSiegeCombatUnits(randomCardPane);
            }
        }

        private AnchorPane getRandomCardFromDiscardPile() {
            Player player = ApplicationController.game.getCurrentPlayer();
            ArrayList<AnchorPane> discardPile = player.getDiscardPile();
            if (discardPile.size() == 0) {
                return null;
            }
            int randomIndex = (int) (Math.random() * discardPile.size());
            return discardPile.get(randomIndex);
        }
    },
    MORALE_BOOST("Morale Boost", "Adds one to the power of all units in the row (excluding itself)","file:src/main/resources/Images/Icons/card_ability_morale.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            Player player = ApplicationController.game.getCurrentPlayer();
            if (cardObject.getCardPosition().equals(CardPositions.CLOSED_COMBAT))
                for (AnchorPane unit : player.getClosedCombatUnits()) {
                    if (unit != card) {
                        Card unitCard = (Card) unit.getUserData();
                        unitCard.setPowerModifier(unitCard.getPowerModifier() + 1);
                    }
                }
            else if (cardObject.getCardPosition().equals(CardPositions.RANGED_COMBAT))
                for (AnchorPane unit : player.getRangedCombatUnits()) {
                    if (unit != card) {
                        Card unitCard = (Card) unit.getUserData();
                        unitCard.setPowerModifier(unitCard.getPowerModifier() + 1);
                    }
                }
            else if (cardObject.getCardPosition().equals(CardPositions.SIEGE_COMBAT))
                for (AnchorPane unit : player.getSiegeCombatUnits()) {
                    if (unit != card) {
                        Card unitCard = (Card) unit.getUserData();
                        unitCard.setPowerModifier(unitCard.getPowerModifier() + 1);
                    }
                }

        }
    },

    MUSTER("Muster", "Play all cards with the same name from your deck and hand instantly", "file:src/main/resources/Images/Icons/card_ability_muster.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            Player player = ApplicationController.game.getCurrentPlayer();
            if (cardObject.getCardPosition().equals(CardPositions.CLOSED_COMBAT)) {
                for (AnchorPane unit : ApplicationController.game.getCurrentPlayer().getHand()) {
                    Card unitCard = (Card) unit.getUserData();
                    if (unitCard.getName().equals(cardObject.getName())) {
                        player.addToClosedCombatUnits(unit);
                    }
                }
                for (Card unit : player.getDeck()) {
                    if (unit.getName().equals(cardObject.getName())) {
                        player.addToClosedCombatUnits((new GameMenuViewController()).createCard(unit));
                        player.getDeck().remove(unit);
                    }
                }
            }
            if (cardObject.getCardPosition().equals(CardPositions.RANGED_COMBAT)) {
                for (AnchorPane unit : ApplicationController.game.getCurrentPlayer().getHand()) {
                    Card unitCard = (Card) unit.getUserData();
                    if (unitCard.getName().equals(cardObject.getName())) {
                        player.addToRangedCombatUnits(unit);
                    }
                }
                for (Card unit : player.getDeck()) {
                    if (unit.getName().equals(cardObject.getName())) {
                        player.addToRangedCombatUnits((new GameMenuViewController()).createCard(unit));
                        player.getDeck().remove(unit);
                    }
                }
            }
            if (cardObject.getCardPosition().equals(CardPositions.SIEGE_COMBAT)) {
                for (AnchorPane unit : ApplicationController.game.getCurrentPlayer().getHand()) {
                    Card unitCard = (Card) unit.getUserData();
                    if (unitCard.getName().equals(cardObject.getName())) {
                        player.addToSiegeCombatUnits(unit);
                    }
                }
                for (Card unit : player.getDeck()) {
                    if (unit.getName().equals(cardObject.getName())) {
                        player.addToSiegeCombatUnits((new GameMenuViewController()).createCard(unit));
                        player.getDeck().remove(unit);
                    }
                }
            }
        }
    },

    SPY("Spy", "Place on your opponent's battlefield and get two cards from your deck","file:src/main/resources/Images/Icons/card_ability_spy.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Player player = ApplicationController.game.getCurrentPlayer();
            for (int i = 1; i >= 0; i--) {
                player.addToHand((new GameMenuViewController()).createCard(player.getDeck().get(i)));
                player.getDeck().remove(i);
            }
        }
    },

    TIGHT_BOND("Tight Bond", "Place next to a card with the same name to increase the strength of both cards","file:src/main/resources/Images/Icons/card_ability_bond.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            Player player = ApplicationController.game.getCurrentPlayer();
            HashMap<String, Integer> cards = new HashMap<>();
            if (cardObject.getCardPosition().equals(CardPositions.CLOSED_COMBAT)) {
                for (AnchorPane unit : player.getClosedCombatUnits()) {
                    putInHashMap(cards, (Card) unit.getUserData());
                }
            } else if (cardObject.getCardPosition().equals(CardPositions.RANGED_COMBAT)) {
                for (AnchorPane unit : player.getRangedCombatUnits()) {
                    putInHashMap(cards, (Card) unit.getUserData());
                }
            } else if (cardObject.getCardPosition().equals(CardPositions.SIEGE_COMBAT)) {
                for (AnchorPane unit : player.getSiegeCombatUnits()) {
                    putInHashMap(cards, (Card) unit.getUserData());
                }
            }
            setEfficiency(cards, cardObject, player);
        }

        private void putInHashMap(HashMap<String, Integer> cards, Card unitCard) {
            if (unitCard.getAbility().equals(CardAbility.TIGHT_BOND)) {
                if (cards.containsKey(unitCard.getName())) {
                    cards.put(unitCard.getName(), cards.get(unitCard.getName()) + 1);
                } else {
                    cards.put(unitCard.getName(), 0);
                }
            }
        }

        private void setEfficiency(HashMap<String, Integer> cards, Card cardObject, Player player) {
            for (String key : cards.keySet()) {
                if (cardObject.getCardPosition().equals(CardPositions.CLOSED_COMBAT)) {
                    for (AnchorPane unit : player.getClosedCombatUnits()) {
                        Card unitCard = (Card) unit.getUserData();
                        if (unitCard.getName().equals(key)) {
                            unitCard.setPowerCoefficient(unitCard.getPowerCoefficient() + cards.get(key));
                        }
                    }
                } else if (cardObject.getCardPosition().equals(CardPositions.RANGED_COMBAT)) {
                    for (AnchorPane unit : player.getRangedCombatUnits()) {
                        Card unitCard = (Card) unit.getUserData();
                        if (unitCard.getName().equals(key)) {
                            unitCard.setPowerCoefficient(unitCard.getPowerCoefficient() + cards.get(key));
                        }
                    }
                } else if (cardObject.getCardPosition().equals(CardPositions.SIEGE_COMBAT)) {
                    for (AnchorPane unit : player.getSiegeCombatUnits()) {
                        Card unitCard = (Card) unit.getUserData();
                        if (unitCard.getName().equals(key)) {
                            unitCard.setPowerCoefficient(unitCard.getPowerCoefficient() + cards.get(key));
                        }
                    }
                }

            }
        }
    },

    SCORCH("Scorch", "Destroy the strongest cards on the battlefield","file:src/main/resources/Images/Icons/card_ability_scorch.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            if (cardObject.getName().equals("Scorch")) {
                // deletes the most powerful card(s)
                ArrayList<AnchorPane> mostPowerfulCards = getMostPowerfulCards(getAllCards());
                for (AnchorPane mostPowerfulCard : mostPowerfulCards) {
                    Card mostPowerfulCardObject = (Card) mostPowerfulCard.getUserData();
                    if (mostPowerfulCardObject.getCardPosition().equals(CardPositions.CLOSED_COMBAT)) {
                        ApplicationController.game.getCurrentPlayer().getClosedCombatUnits().remove(mostPowerfulCard);
                    } else if (mostPowerfulCardObject.getCardPosition().equals(CardPositions.RANGED_COMBAT)) {
                        ApplicationController.game.getCurrentPlayer().getRangedCombatUnits().remove(mostPowerfulCard);
                    } else if (mostPowerfulCardObject.getCardPosition().equals(CardPositions.SIEGE_COMBAT)) {
                        ApplicationController.game.getCurrentPlayer().getSiegeCombatUnits().remove(mostPowerfulCard);
                    }
                }
            } else {
                ArrayList<AnchorPane> closedWithoutHero = new ArrayList<>();
                for (AnchorPane unit : ApplicationController.game.getEnemyPlayer().getClosedCombatUnits())
                    if (!((Card) unit.getUserData()).isHero())
                        closedWithoutHero.add(unit);
                if (getPower(closedWithoutHero) >= 10)
                    for (AnchorPane mostPowerfulCard : getMostPowerfulCards(closedWithoutHero))
                        ApplicationController.game.getEnemyPlayer().getClosedCombatUnits().remove(mostPowerfulCard);

                ArrayList<AnchorPane> rangedWithoutHero = new ArrayList<>();
                for (AnchorPane unit : ApplicationController.game.getEnemyPlayer().getRangedCombatUnits())
                    if (!((Card) unit.getUserData()).isHero())
                        rangedWithoutHero.add(unit);
                if (getPower(rangedWithoutHero) >= 10)
                    for (AnchorPane mostPowerfulCard : getMostPowerfulCards(rangedWithoutHero))
                        ApplicationController.game.getEnemyPlayer().getRangedCombatUnits().remove(mostPowerfulCard);

                ArrayList<AnchorPane> siegeWithoutHero = new ArrayList<>();
                for (AnchorPane unit : ApplicationController.game.getEnemyPlayer().getSiegeCombatUnits())
                    if (!((Card) unit.getUserData()).isHero())
                        siegeWithoutHero.add(unit);
                if (getPower(siegeWithoutHero) >= 10)
                    for (AnchorPane mostPowerfulCard : getMostPowerfulCards(siegeWithoutHero))
                        ApplicationController.game.getEnemyPlayer().getSiegeCombatUnits().remove(mostPowerfulCard);
            }
        }


        private ArrayList<AnchorPane> getMostPowerfulCards(ArrayList<AnchorPane> cards) {
            ArrayList<AnchorPane> mostPowerfulCards = new ArrayList<>();
            int maxPower = 0;
            for (AnchorPane card : cards) {
                Card cardObject = (Card) card.getUserData();
                if (cardObject.getPower() > maxPower) {
                    maxPower = cardObject.getPower();
                    mostPowerfulCards.clear();
                    mostPowerfulCards.add(card);
                } else if (cardObject.getPower() == maxPower) {
                    mostPowerfulCards.add(card);
                }
            }
            return mostPowerfulCards;
        }

        private ArrayList<AnchorPane> getAllCards() {
            ArrayList<AnchorPane> allCards = new ArrayList<>();
            Player player = ApplicationController.game.getCurrentPlayer();
            allCards.addAll(player.getClosedCombatUnits());
            allCards.addAll(player.getRangedCombatUnits());
            allCards.addAll(player.getSiegeCombatUnits());
            Player enemyPlayer = ApplicationController.game.getEnemyPlayer();
            allCards.addAll(enemyPlayer.getClosedCombatUnits());
            allCards.addAll(enemyPlayer.getRangedCombatUnits());
            allCards.addAll(enemyPlayer.getSiegeCombatUnits());
            return allCards;
        }

        private int getPower(ArrayList<AnchorPane> cards) {
            int result = 0;
            for (AnchorPane card : cards) {
                Card cardObject = (Card) card.getUserData();
                result += cardObject.getPower();
            }
            return result;
        }
    },

    BERSEKER("Berserker", "Turns to a bear when mardroeme is played on it.","file:src/main/resources/Images/Icons/card_ability_berserker.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            AnchorPane bear = createBear(cardObject);
            if(cardObject.getCardPosition().equals(CardPositions.CLOSED_COMBAT)){
                for(AnchorPane unit : ApplicationController.game.getCurrentPlayer().getClosedCombatUnits()){
                    if(((Card) unit.getUserData()).getAbility().equals(CardAbility.MARDOEME)){
                        ApplicationController.game.getCurrentPlayer().getClosedCombatUnits().remove(card);
                        ApplicationController.game.getCurrentPlayer().addToClosedCombatUnits(bear);
                        return;
                    }
                }
            }
            else if(cardObject.getCardPosition().equals(CardPositions.RANGED_COMBAT)){
                for(AnchorPane unit : ApplicationController.game.getCurrentPlayer().getRangedCombatUnits()){
                    if(((Card) unit.getUserData()).getAbility().equals(CardAbility.MARDOEME)){
                        ApplicationController.game.getCurrentPlayer().getRangedCombatUnits().remove(card);
                        ApplicationController.game.getCurrentPlayer().addToRangedCombatUnits(bear);
                        return;
                    }
                }
            }
            else if(cardObject.getCardPosition().equals(CardPositions.SIEGE_COMBAT)){
                for(AnchorPane unit : ApplicationController.game.getCurrentPlayer().getSiegeCombatUnits()){
                    if(((Card) unit.getUserData()).getAbility().equals(CardAbility.MARDOEME)){
                        ApplicationController.game.getCurrentPlayer().getSiegeCombatUnits().remove(card);
                        ApplicationController.game.getCurrentPlayer().addToSiegeCombatUnits(bear);
                        return;
                    }
                }
            }
            checkInSpecials(card, bear);
        }

        private void checkInSpecials(AnchorPane card, AnchorPane bear) {
            Player player = ApplicationController.game.getCurrentPlayer();
            if(player.getClosedCombatSpecial() != null){
                if(((Card) player.getClosedCombatSpecial().getUserData()).getAbility().equals(CardAbility.MARDOEME)){
                    player.getSiegeCombatUnits().remove(card);
                    player.addToClosedCombatUnits(bear);
                }
            }
            else if(player.getRangedCombatSpecial() != null){
                if(((Card) player.getRangedCombatSpecial().getUserData()).getAbility().equals(CardAbility.MARDOEME)){
                    player.getSiegeCombatUnits().remove(card);
                    player.addToRangedCombatUnits(bear);
                }
            }
            else if(player.getSiegeCombatSpecial() != null){
                if(((Card) player.getSiegeCombatSpecial().getUserData()).getAbility().equals(CardAbility.MARDOEME)){
                    player.getSiegeCombatUnits().remove(card);
                    player.addToSiegeCombatUnits(bear);
                }
            }
        }

        private AnchorPane createBear(Card cardObject) {
            Card bear = null;
            if(cardObject.getCardEnum().equals(CardEnum.BERSEERKER)){
                bear = new Card(CardEnum.VIDKAARL);
            }
            else if(cardObject.getCardEnum().equals(CardEnum.YOUNG_BERSERKER)){
                bear = new Card(CardEnum.YOUNG_VIDKAARL);
            }
            return ((new GameMenuViewController()).createCard(bear));
        }
    },

    MARDOEME("Mardroeme", "Turns a berserker to a bear.","file:src/main/resources/Images/Icons/card_ability_mardroeme.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            AnchorPane bear = createBear(cardObject);
            if(cardObject.getCardPosition().equals(CardPositions.CLOSED_COMBAT)){
                for(AnchorPane unit : ApplicationController.game.getCurrentPlayer().getClosedCombatUnits()){
                    if(((Card) unit.getUserData()).getAbility().equals(CardAbility.BERSEKER)){
                        ApplicationController.game.getCurrentPlayer().getClosedCombatUnits().remove(unit);
                        ApplicationController.game.getCurrentPlayer().addToClosedCombatUnits(bear);
                        return;
                    }
                }
            }
            else if(cardObject.getCardPosition().equals(CardPositions.RANGED_COMBAT)){
                for(AnchorPane unit : ApplicationController.game.getCurrentPlayer().getRangedCombatUnits()){
                    if(((Card) unit.getUserData()).getAbility().equals(CardAbility.BERSEKER)){
                        ApplicationController.game.getCurrentPlayer().getRangedCombatUnits().remove(unit);
                        ApplicationController.game.getCurrentPlayer().addToRangedCombatUnits(bear);
                        return;
                    }
                }
            }
            else if(cardObject.getCardPosition().equals(CardPositions.SIEGE_COMBAT)){
                for(AnchorPane unit : ApplicationController.game.getCurrentPlayer().getSiegeCombatUnits()){
                    if(((Card) unit.getUserData()).getAbility().equals(CardAbility.BERSEKER)){
                        ApplicationController.game.getCurrentPlayer().getSiegeCombatUnits().remove(unit);
                        ApplicationController.game.getCurrentPlayer().addToSiegeCombatUnits(bear);
                        return;
                    }
                }
            }
            checkInSpecials(card, bear);
        }

        private void checkInSpecials(AnchorPane card, AnchorPane bear) {
            Player player = ApplicationController.game.getCurrentPlayer();
            if(((Card)card.getUserData()).getCardPosition().equals(CardPositions.CLOSED_COMBAT_SPECIAL)) {
                for (AnchorPane unit : player.getClosedCombatUnits()) {
                    if (((Card) unit.getUserData()).getAbility().equals(CardAbility.BERSEKER)) {
                        player.getClosedCombatUnits().remove(unit);
                        player.addToClosedCombatUnits(bear);
                    }
                }
            }
            else if(((Card)card.getUserData()).getCardPosition().equals(CardPositions.RANGED_COMBAT_SPECIAL)) {
                for (AnchorPane unit : player.getRangedCombatUnits()) {
                    if (((Card) unit.getUserData()).getAbility().equals(CardAbility.BERSEKER)) {
                        player.getRangedCombatUnits().remove(unit);
                        player.addToRangedCombatUnits(bear);
                    }
                }
            }
            else if(((Card)card.getUserData()).getCardPosition().equals(CardPositions.SIEGE_COMBAT_SPECIAL)) {
                for (AnchorPane unit : player.getSiegeCombatUnits()) {
                    if (((Card) unit.getUserData()).getAbility().equals(CardAbility.BERSEKER)) {
                        player.getSiegeCombatUnits().remove(unit);
                        player.addToSiegeCombatUnits(bear);
                    }
                }
            }
        }

        private AnchorPane createBear(Card cardObject) {
            Card bear = null;
            if(cardObject.getCardEnum().equals(CardEnum.BERSEERKER)){
                bear = new Card(CardEnum.VIDKAARL);
            }
            else if(cardObject.getCardEnum().equals(CardEnum.YOUNG_BERSERKER)){
                bear = new Card(CardEnum.YOUNG_VIDKAARL);
            }
            return ((new GameMenuViewController()).createCard(bear));
        }
    },

    TRANSFORMERMS("Transformers", "Transforms into a random card with power 8.","file:src/main/resources/Images/Icons/card_ability_transformer.png") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            Card cardObject = (Card) card.getUserData();
            if (cardObject.getCardPosition().equals(CardPositions.DISCARD_PILE)
                    && (ApplicationController.game.getGameState().equals(GameStates.ROUND_2_STARTED) ||
                    ApplicationController.game.getGameState().equals(GameStates.ROUND_3_STARTED))) {
                transform(card, ApplicationController.game.getCurrentPlayer());
            }
        }

        public void transform(AnchorPane card, Player player) {
            AnchorPane target = getRandomCard();
            Card targetCard = (Card) target.getUserData();
            player.removeFromDiscardPile(card);
            if(targetCard.getType().equals(CardType.CLOSED_COMBAT_UNIT) || targetCard.getType().equals(CardType.AGILE_UNIT)){
                player.addToClosedCombatUnits(target);
            }
            else if(targetCard.getType().equals(CardType.RANGED_UNIT)){
                player.addToRangedCombatUnits(target);
            }
            else if(targetCard.getType().equals(CardType.SIEGE_UNIT)){
                player.addToSiegeCombatUnits(target);
            }

        }

        private AnchorPane getRandomCard() {
            for (CardEnum cardEnum : CardEnum.values()) {
                if (cardEnum.getPower() == 8) {
                    Card card = new Card(cardEnum);
                    return (new GameMenuViewController()).createCard(card);
                }
            }
            return null;
        }
    },
    NONE("None", "No ability","") {
        @Override
        public void doAbility(AnchorPane card, AnchorPane target) {
            // Does nothing by default
        }
    };;

    private String name;
    private String description;
    private String onCardImage;

    CardAbility(String name, String description, String onCardImage) {
        this.name = name;
        this.description = description;
        this.onCardImage = onCardImage;

    }

    public abstract void doAbility(AnchorPane card, AnchorPane target);

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getOnCardImage() {
        return onCardImage;
    }
}

