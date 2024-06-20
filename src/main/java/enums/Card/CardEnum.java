package enums.Card;

public enum CardEnum {
    // name, id, faction, type, power, ability, hero, preGameImage, inGameImage, preGameCount

    // Skelliege
    MARDOEME("Mardroeme", 1, Factions.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "mardroeme.png", "mardroeme.png", 3);

    private String name;
    private int id;
    private Factions faction;
    private CardType type;
    private int power;
    private CardAbility ability;
    private boolean hero;
    private String preGameImage;
    private String inGameImage;
    private int preGameCount;

    CardEnum(String name, int id, Factions faction, CardType type, int power, CardAbility ability, boolean hero, String preGameImage, String inGameImage, int preGameCount) {
        this.name = name;
        this.id = id;
        this.faction = faction;
        this.type = type;
        this.power = power;
        this.ability = ability;
        this.hero = hero;
        this.preGameImage = preGameImage;
        this.inGameImage = inGameImage;
        this.preGameCount = preGameCount;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public Factions getFaction() {
        return faction;
    }

    public CardType getType() {
        return type;
    }

    public int getPower() {
        return power;
    }

    public CardAbility getAbility() {
        return ability;
    }

    public boolean isHero() {
        return hero;
    }

    public String getPreGameImage() {
        return preGameImage;
    }

    public String getInGameImage() {
        return inGameImage;
    }

    public int getPreGameCount() {
        return preGameCount;
    }

}
