package enums.Card;

public enum CommandersEnum {
    // name, id, faction, leader ability description, preGameImage, inGameImage

    // Skellige
    CRACHE_AN_CRAITE("Crache an Craite", 1, FactionsEnum.SKELLIGE, "Brings back cards to deck from the graveyard.", "file:src/main/resources/Images/CommandersDetailed/skellige_crach_an_craite.jpg", "file:src/main/resources/Images/CommandersDetailed/skellige_crach_an_craite.jpg"),
    KING_BRAN("king bran", 1, FactionsEnum.SKELLIGE, "soldiers only lose half their power under the weather", "file:src/main/resources/Images/CommandersDetailed/skellige_king_bran.jpg","file:src/main/resources/Images/CommandersDetailed/skellige_king_bran.jpg"),
    //Northen realms
    THE_SIEGEMASTER("the siegemaster", 2, FactionsEnum.NORTHERN_REALMS,"selects and plays a impenetrable fog card from your deck","file:src/main/resources/Images/CommandersDetailed/realms_foltes_siegemaster.jpg","file:src/main/resources/Images/CommandersDetailed/realms_foltes_siegemaster.jpg"),
    THE_STEEL_FORGED("the steel forged", 2,FactionsEnum.NORTHERN_REALMS,"removes the effect of weather","file:src/main/resources/Images/CommandersDetailed/realms_foltes_steelforged.jpg","file:src/main/resources/Images/CommandersDetailed/realms_foltes_steelforged.jpg"),
    KING_OF_TEMERIA("king of temeria", 2,FactionsEnum.NORTHERN_REALMS,"doubles the power of siege cards unless there is a commander's horn card in that row","file:src/main/resources/Images/CommandersDetailed/realms_foltes_kingoftameria.jpg","file:src/main/resources/Images/CommandersDetailed/realms_foltes_kingoftameria.jpg"),
    LORD_COMMANDER_OF_THE_NORTH("lord commander of the north",2,FactionsEnum.NORTHERN_REALMS, "if the power of the opponent's siege cards is greater than 10, it destroys the most powerful siege card","fole:src/main/resources/Images/CommandersDetailed/realms_foltes_lordcommander.jpg","file:src/main/resources/Images/CommandersDetailed/realms_foltes_lordcommander.jpg"),
    SON_OF_MEDELL("son of medell", 2,FactionsEnum.NORTHERN_REALMS, "if the power of the opponent's ranged cards is greater than 10,it destroys the most powerful ranged card","file:src/main/resources/Images/CommandersDetailed/realms_foltest_son_of_medell.jpg","file:src/main/resources/Images/CommandersDetailed/realms_foltest_son_of_medell.jpg"),
    THE_WHITE_FLAME("the white falme", 3,FactionsEnum.NILFGAARD, "picks and plays a torrential rain card from your deck","file:src/main/resources/Images/CommandersDetailed/nilfgaard_whiteFlame.jpg","file:src/main/resources/Images/CommandersDetailed/nilfgaard_whiteFlame.jpg"),
    HIS_IMPERIAL_MAJESTY("his imperial majesty", 3,FactionsEnum.NILFGAARD,"shows three random cards from opponent's deck","file:src/main/resources/Images/CommandersDetailed/nilfgaard_imperialMajesty.jpg","file:src/main/resources/Images/CommandersDetailed/nilfgaard_imperialMajesty.jpg"),
    EMPEROR_OF_NILFGAARD("emperor of nilfgaard",3,FactionsEnum.NILFGAARD,"cancels the ability of the opponent's commander","file:src/main/resources/Images/CommandersDetailed/nilfgaard_emperor.jpg","file:src/main/resources/Images/CommandersDetailed/nilfgaard_emperor.jpg"),
    THE_RELENTLESS("the relentless",3,FactionsEnum.NILFGAARD,"takes a card from the opponent's dead cards of player's choice(not a hero card)","file:src/main/resources/Images/CommandersDetailed/nilfgaard_relentless.jpg","file:src/main/resources/Images/CommandersDetailed/nilfgaard_relentless.jpg)"),
    INVADER_OF_THE_NORTH("invader of the north",3,FactionsEnum.NILFGAARD,"returns a random card from dead cards to the game for both the player and opponent","file:src/main/resources/Images/CommandersDetailed/nilfgaard_emhyr_invader_of_the_north.jpg","file:src/main/resources/Images/CommandersDetailed/nilfgaard_emhyr_invader_of_the_north.jpg"),
    BRINGER_OF_DEATH("bringer of death",4,FactionsEnum.MONSTERS,"the power of siege cards is doubled unless there is a close combat card in that row","file:src/main/resources/Images/CommandersDetailed/monsters_bringerOfDeath.jpg","f"),
    KING_OF_THE_WILD_HUNT("king of the wild hunt",4,FactionsEnum.MONSTERS, "takes a card from the player's dead cards of player's choice(not a hero card)","file:src/main/resources/Images/CommandersDetailed/monsters_wildHunt.jpg","file:src/main/resources/Images/CommandersDetailed/monsters_wildHunt.jpg"),
    DESTROYS_OF_WORLDS("destroys of worlds",4,FactionsEnum.MONSTERS,"kills two of playable cards and takes a new card from player's deck","file:src/main/resources/Images/CommandersDetailed/monsters_destroysOfWorlds.jpg","file:src/main/resources/Images/CommandersDetailed/monsters_destroysOfWorlds.jpg"),
    COMMANDER_OF_THE_RED_RIDERS("commander of the red riders",4,FactionsEnum.MONSTERS,"chooses a weather card from player's deck and play it","file:src/main/resources/Images/CommandersDetailed/monsters_redRiders.jpg","file:src/main/resources/Images/CommandersDetailed/monsters_redRiders.jpg"),
    THE_TREACHEROUS("the treacherous",4,FactionsEnum.MONSTERS,"doubles the power of spy cards on both sides","file:src/main/resources/Images/CommandersDetailed/monsters_eredin_the_treacherous.jpg","file:src/main/resources/Images/CommandersDetailed/monsters_eredin_the_treacherous.jpg"),
    QUEEN_OF_DOL_BLATHANNA("queen of dol blathana", 5,FactionsEnum.SCOIATAEL,"if the power of close combat cards of opponent is greater than 10, it destroys the most powerful ranged card","file:src/main/resources/Images/CommandersDetailed/scoiatael_Queen.jpg","file:src/main/resources/Images/CommandersDetailed/scoiatael_Queen.jpg"),
    THE_BEAUTIFUL("the beautiful",5,FactionsEnum.SCOIATAEL,"doubles the power of ranged combat cards unless there is a commander's horn card in that row","file:src/main/resources/Images/CommandersDetailed/scoiatael_theBeautiful.jpg","file:src/main/resources/Images/CommandersDetailed/scoiatael_theBeautiful.jpg"),
    DAISY_OF_THE_VALLEY("daisy of the valley",5,FactionsEnum.SCOIATAEL,"at the beginning of the game, an extra card will be randomly assigned to player","file:src/main/resources/Images/CommandersDetailed/scoiatael_daisyOfTheVlley.jpg","file:src/main/resources/Images/CommandersDetailed/scoiatael_daisyOfTheVlley.jpg"),
    PUREBLOOD_ELF("pureblood ELF",5,FactionsEnum.SCOIATAEL,"chooses and plays a biting frost card from player's deck","file:src/main/resources/Images/CommandersDetailed/scoiatael_PUREBLOOD_ELF.jpg","file:src/main/resources/Images/CommandersDetailed/scoiatael_PUREBLOOD_ELF.jpg"),
    HOPE_THE_AEN_SEIDHE("hope the aen siedhe",5,FactionsEnum.SCOIATAEL,"takes the agile unit cards to a line where their power is maximized","file:src/main/resources/Images/CommandersDetailed/scoiatael_francesca_hope_of_the_aen_seidhe.jpg","file:src/main/resources/Images/CommandersDetailed/scoiatael_francesca_hope_of_the_aen_seidhe.jpg");



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
