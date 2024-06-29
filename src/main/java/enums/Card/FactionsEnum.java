package enums.Card;

public enum FactionsEnum {
    // name, image, shield, description
    SKELLIGE("Skellige", "file:src/main/resources/Images/Factions/faction_skellige.jpg","file:src/main/resources/Images/Icons/deck_shield_skellige.png" ,"Two random cards from your graveyard will be placed randomly on the battlefield at the beginning of the third round."),
    NORTHERN_REALMS("Northern Realms", "file:src/main/resources/Images/Factions/faction_realms.jpg", "file:src/main/resources/Images/Icons/deck_shield_realms.png" ,"If the player wins the round, a card will be placed in the player's hand at the beginning of the next round."),
    NILFGAARD("Nilfgaard", "file:src/main/resources/Images/Factions/faction_nilfgaard.jpg", "file:src/main/resources/Images/Icons/deck_shield_nilfgaard.png" ,"If a round ends in a draw, nilfgaard will win the round."),
    MONSTERS("Monsters", "file:src/main/resources/Images/Factions/faction_monsters.jpg", "file:src/main/resources/Images/Icons/deck_shield_monsters.png" ,"After each round, monsters will randomly hold a card from the battlefield to the next round."),
    SCOIATAEL("Scoiatael", "file:src/main/resources/Images/Factions/faction_scoiatael.jpg", "file:src/main/resources/Images/Icons/deck_shield_scoiatael.png" ,"Player will always play the first card in the first round. If both players have this faction, first player will be chosen randomly."),
    NEUTRAL("Neutral", "file:src/main/resources/Images/Factions/faction_monsters.jpg", "file:src/main/resources/Images/Icons/deck_shield_monsters.png" ,"Neutral cards can be used by any faction.");

    private String name;
    private String image;
    private String shield;
    private String description;

    FactionsEnum(String name, String image,String shield, String description) {
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