package enums.Card;

import javafx.scene.layout.AnchorPane;

public enum CardAbility {
    COMMANDERS_HORN("Commander's Horn", "Double the strength of all unit cards in the row") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Commander's Horn ability");
        }
    },
    DECOY("Decoy", "Return a card to your hand") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Decoy ability");
        }
    },
    MEDIC("Medic", "Choose one card from your discard pile and play it instantly") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Medic ability");
        }
    },
    MORALE_BOOST("Morale Boost", "Adds one to the power of all units in the row (excluding itself)") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Morale Boost ability");
        }
    },
    MUSTER("Muster", "Play all cards with the same name from your deck and hand instantly") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Muster ability");
        }
    },
    SPY("Spy", "Place on your opponent's battlefield and get two cards from your deck") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Spy ability");
        }
    },
    TIGHT_BOND("Tight Bond", "Place next to a card with the same name to increase the strength of both cards") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Tight Bond ability");
        }
    },
    SCORCH("Scorch", "Destroy the strongest cards on the battlefield") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Scorch ability");
        }
    },
    BERSEKER("Berserker", "Turns to a bear when mardroeme is played on it.") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Berserker ability");
        }
    },
    MARDOEME("Mardroeme", "Turns a berserker to a bear.") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Mardroeme ability");
        }
    },
    TRANSFORMERMS("Transformers", "Transforms into a random card from the deck.") {
        @Override
        public void doAbility(AnchorPane card) {
            System.out.println("Transformers ability");
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

    public abstract void doAbility(AnchorPane card);
}

