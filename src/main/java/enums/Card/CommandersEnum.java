package enums.Card;

import controller.ApplicationController;
import model.Card;
import model.Player;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

import static enums.Card.CardAbility.COMMANDERS_HORN;

public enum CommandersEnum {
    // name, id, faction, leader ability description, preGameImage, inGameImage

    // Skellige
    CRACHE_AN_CRAITE("Crache an Craite", 1, FactionsEnum.SKELLIGE, "Brings back cards to deck from the graveyard.", "file:src/main/resources/Images/CommandersDetailed/skellige_crach_an_craite.jpg", "file:src/main/resources/Images/CommandersNoText/skellige_crach_an_craite.jpg") {
        @Override
        public void doAbility(Player player) {
            ArrayList<AnchorPane> graveyard = player.getDiscardPile();
            if (graveyard.size() > 0) {
                for (int i = 0; i < graveyard.size(); i++) {
                    Card card = (Card) graveyard.get(i).getUserData();
                    player.getDeck().add(card);
                    player.getDiscardPile().remove(i);
                }

            }
        }
    },

    KING_BRAN("king bran", 2, FactionsEnum.SKELLIGE, "soldiers only lose half their power under the weather", "file:src/main/resources/Images/CommandersDetailed/skellige_king_bran.jpg", "file:src/main/resources/Images/CommandersNoText/skellige_king_bran (1).jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    //Northen realms
    THE_SIEGEMASTER("the siegemaster", 3, FactionsEnum.NORTHERN_REALMS, "selects and plays an impenetrable fog card from your deck", "file:src/main/resources/Images/CommandersDetailed/realms_foltes_siegemaster.jpg", "file:src/main/resources/Images/CommandersNoText/realms_foltes_siegemaster.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    THE_STEEL_FORGED("the steel forged", 4, FactionsEnum.NORTHERN_REALMS, "removes the effect of weather", "file:src/main/resources/Images/CommandersDetailed/realms_foltes_steelforged.jpg", "file:src/main/resources/Images/CommandersNoText/realms_foltes_steel_Forged.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }

    },

    KING_OF_TEMERIA("king of temeria", 5, FactionsEnum.NORTHERN_REALMS, "doubles the power of siege cards unless there is a commander's horn card in that row", "file:src/main/resources/Images/CommandersDetailed/realms_foltes_kingoftameria.jpg", "file:src/main/resources/Images/CommandersNoText/realms_foltes_kingOfTameria.jpg") {
        @Override
        public void doAbility(Player player) {
            for (AnchorPane card : player.getSiegeCombatUnits()) {
                Card cardObject = (Card) card.getUserData();
                if (!cardObject.getType().equals(COMMANDERS_HORN)) {
                    cardObject.setPowerCoefficient((int) (cardObject.getPowerCoefficient() * 2));
                }
            }
        }

    },

    LORD_COMMANDER_OF_THE_NORTH("lord commander of the north", 6, FactionsEnum.NORTHERN_REALMS, "if the power of the opponent's siege cards is greater than 10, it destroys the most powerful siege card", "fole:src/main/resources/Images/CommandersDetailed/realms_foltes_lordcommander.jpg", "file:src/main/resources/Images/CommandersNoText/realms_foltes_lordOfTheNorth.jpg") {
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
        @Override
        public void doAbility(Player player) {
            player = ApplicationController.game.getEnemyPlayer();
            int count = 0;
            for (AnchorPane card : player.getSiegeCombatUnits()) {
                Card cardObject = (Card) card.getUserData();
                count = 0;
                if (cardObject.getPower() > 10) {
                    count += 1;
                }
            }
            if (count == player.getRangedCombatUnits().size()){
                ArrayList<AnchorPane> mostPowerfulCards = getMostPowerfulCards(player.getSiegeCombatUnits());
                player.getSiegeCombatUnits().remove(mostPowerfulCards);
            }

        }
    },

    SON_OF_MEDELL("son of medell", 7, FactionsEnum.NORTHERN_REALMS, "if the power of the opponent's ranged cards is greater than 10,it destroys the most powerful ranged card", "file:src/main/resources/Images/CommandersDetailed/realms_foltest_son_of_medell.jpg", "file:src/main/resources/Images/CommandersNoText/realms_foltest_son_of_medell (1).jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    //Nilfgaard
    THE_WHITE_FLAME("the white falme", 8, FactionsEnum.NILFGAARD, "picks and plays a torrential rain card from your deck", "file:src/main/resources/Images/CommandersDetailed/nilfgaard_whiteFlame.jpg", "file:src/main/resources/Images/CommandersNoText/nilfgaard_emhyr_WhiteFlame.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    HIS_IMPERIAL_MAJESTY("his imperial majesty", 9, FactionsEnum.NILFGAARD, "shows three random cards from opponent's deck", "file:src/main/resources/Images/CommandersDetailed/nilfgaard_imperialMajesty.jpg", "file:src/main/resources/Images/CommandersNoText/nilfgaard_emhyr_EmperialMajesty.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    EMPEROR_OF_NILFGAARD("emperor of nilfgaard", 10, FactionsEnum.NILFGAARD, "cancels the ability of the opponent's commander", "file:src/main/resources/Images/CommandersDetailed/nilfgaard_emperor.jpg", "file:src/main/resources/Images/CommandersNoText/nilfgaard_emhyr_Emperor.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    THE_RELENTLESS("the relentless", 11, FactionsEnum.NILFGAARD, "takes a card from the opponent's dead cards of player's choice(not a hero card)", "file:src/main/resources/Images/CommandersDetailed/nilfgaard_relentless.jpg", "file:src/main/resources/Images/CommandersNoText/nilfgaard_emhyr_Relentless.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    INVADER_OF_THE_NORTH("invader of the north", 12, FactionsEnum.NILFGAARD, "returns a random card from dead cards to the game for both the player and opponent", "file:src/main/resources/Images/CommandersDetailed/nilfgaard_emhyr_invader_of_the_north.jpg", "file:src/main/resources/Images/CommandersNoText/nilfgaard_emhyr_invader_of_the_north (1).jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    //Monsters
    BRINGER_OF_DEATH("bringer of death", 13, FactionsEnum.MONSTERS, "the power of closed combat cards is doubled unless there is a close commander's Horn in that row", "file:src/main/resources/Images/CommandersDetailed/monsters_bringerOfDeath.jpg", "file:src/main/resources/Images/CommandersNoText/monsters_eredin_Bringer_of_death.jpg") {
        @Override
        public void doAbility(Player player) {
            for (AnchorPane card : player.getClosedCombatUnits()) {
                Card cardObject = (Card) card.getUserData();
                if (!cardObject.getType().equals(COMMANDERS_HORN)) {
                    cardObject.setPowerCoefficient((int) (cardObject.getPowerCoefficient() * 2));
                }
            }
        }
    },

    KING_OF_THE_WILD_HUNT("king of the wild hunt", 14, FactionsEnum.MONSTERS, "takes a card from the player's dead cards of player's choice(not a hero card)", "file:src/main/resources/Images/CommandersDetailed/monsters_wildHunt.jpg", "file:src/main/resources/Images/CommandersNoText/monsters_eredin_king_of_the_wild_hunt.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    DESTROYS_OF_WORLDS("destroys of worlds", 15, FactionsEnum.MONSTERS, "kills two of playable cards and takes a new card from player's deck", "file:src/main/resources/Images/CommandersDetailed/monsters_destroysOfWorlds.jpg", "file:src/main/resources/Images/CommandersNoText/monsters_eredin_Destroys_of_the_world.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    COMMANDER_OF_THE_RED_RIDERS("commander of the red riders", 16, FactionsEnum.MONSTERS, "chooses a weather card from player's deck and play it", "file:src/main/resources/Images/CommandersDetailed/monsters_redRiders.jpg", "file:src/main/resources/Images/CommandersNoText/monsters_eredin_commander_of_the_red_riders.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    THE_TREACHEROUS("the treacherous", 17, FactionsEnum.MONSTERS, "doubles the power of spy cards on both sides", "file:src/main/resources/Images/CommandersDetailed/monsters_eredin_the_treacherous.jpg", "file:src/main/resources/Images/CommandersNoText/monsters_eredin_the_treacherous (1).jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    //Scoiatael
    QUEEN_OF_DOL_BLATHANNA("queen of dol blathana", 18, FactionsEnum.SCOIATAEL, "if the power of close combat cards of opponent is greater than 10, it destroys the most powerful ranged card", "file:src/main/resources/Images/CommandersDetailed/scoiatael_Queen.jpg", "file:src/main/resources/Images/CommandersNoText/scoiatael_francesca_Queen.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    THE_BEAUTIFUL("the beautiful", 19, FactionsEnum.SCOIATAEL, "doubles the power of ranged combat cards unless there is a commander's horn card in that row", "file:src/main/resources/Images/CommandersDetailed/scoiatael_theBeautiful.jpg", "file:src/main/resources/Images/CommandersNoText/scoiatael_francesca_TheBeautifull.jpg") {
        @Override
        public void doAbility(Player player) {
            for (AnchorPane card : player.getRangedCombatUnits()) {
                Card cardObject = (Card) card.getUserData();
                if (!cardObject.getType().equals(COMMANDERS_HORN)) {
                    cardObject.setPowerCoefficient((int) (cardObject.getPowerCoefficient() * 2));
                }
            }
        }
    },

    DAISY_OF_THE_VALLEY("daisy of the valley", 20, FactionsEnum.SCOIATAEL, "at the beginning of the game, an extra card will be randomly assigned to player", "file:src/main/resources/Images/CommandersDetailed/scoiatael_daisyOfTheVlley.jpg", "file:src/main/resources/Images/CommandersNoText/scoiatael_francesca_Daisy_of_valley.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    PUREBLOOD_ELF("pureblood ELF", 21, FactionsEnum.SCOIATAEL, "chooses and plays a biting frost card from player's deck", "file:src/main/resources/Images/CommandersDetailed/scoiatael_PUREBLOOD_ELF.jpg", "file:src/main/resources/Images/CommandersNoText/scoiatael_francesca_PureBlood.jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    },

    HOPE_THE_AEN_SEIDHE("hope the aen siedhe", 22, FactionsEnum.SCOIATAEL, "takes the agile unit cards to a line where their power is maximized", "file:src/main/resources/Images/CommandersDetailed/scoiatael_francesca_hope_of_the_aen_seidhe.jpg", "file:src/main/resources/Images/CommandersNoText/scoiatael_francesca_hope_of_the_aen_seidhe (1).jpg") {
        @Override
        public void doAbility(Player player) {
            //ability
        }
    };

    private String name;
    private int id;
    private FactionsEnum faction;
    private String leaderAbilityDescription;
    private String preGameImage;
    private String inGameImage;

    CommandersEnum(String name, int id, FactionsEnum faction, String leaderAbilityDescription, String preGameImage, String inGameImage) {
        this.name = name;
        this.id = id;
        this.faction = faction;
        this.leaderAbilityDescription = leaderAbilityDescription;
        this.preGameImage = preGameImage;
        this.inGameImage = inGameImage;
    }

    public abstract <AnchorPane> void doAbility(Player player);

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public FactionsEnum getFaction() {
        return faction;
    }

    public String getLeaderAbilityDescription() {
        return leaderAbilityDescription;
    }

    public String getPreGameImage() {
        return preGameImage;
    }

    public String getInGameImage() {
        return inGameImage;
    }


}
