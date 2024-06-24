package enums.Card;

public enum CommandersEnum {
    // name, id, faction, leader ability description, preGameImage, inGameImage

    // Skellige
    CRACHE_AN_CRAITE("Crache an Craite", 1, FactionsEnum.SKELLIGE, "Spawn a Clan an Craite Warrior on each side of this unit.", "file:src/main/resources/Images/CommandersDetailed/skellige_crach_an_craite.jpg", "file:src/main/resources/Images/CommandersDetailed/skellige_crach_an_craite.jpg");


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
