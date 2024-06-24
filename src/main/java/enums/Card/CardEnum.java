package enums.Card;

public enum CardEnum {
    // name, id, faction, type, power, ability, hero, preGameImage, inGameImage, preGameCount

    // Neutral

    // Skelliege
    MARDOEME("Mardroeme", 1, FactionsEnum.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "C:\\Users\\asus\\Pictures\\Roblox\\RobloxScreenShot20230413_160547132.png", "receipt-1716645588760.png", 3),
    MARDOEMEE("Mardroemee", 1, FactionsEnum.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "C:\\Users\\asus\\Pictures\\Roblox\\RobloxScreenShot20230413_160547132.png", "receipt-1716645588760.png", 3),
    MARDOEMEEE("Mardroemeee", 1, FactionsEnum.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "C:\\Users\\asus\\Pictures\\Roblox\\RobloxScreenShot20230413_160547132.png", "receipt-1716645588760.png", 3),
    MARDOEMEEEEE("Mardroemeeeee", 1, FactionsEnum.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "C:\\Users\\asus\\Pictures\\Roblox\\RobloxScreenShot20230413_160547132.png", "receipt-1716645588760.png", 3),
    MARDOEMEEEEEE("Mardroemeeeeee", 1, FactionsEnum.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "C:\\Users\\asus\\Pictures\\Roblox\\RobloxScreenShot20230413_160547132.png", "receipt-1716645588760.png", 3),
    MARDOEMEEEEEEE("Mardroemeeeeeee", 1, FactionsEnum.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "C:\\Users\\asus\\Pictures\\Roblox\\RobloxScreenShot20230413_160547132.png", "receipt-1716645588760.png", 3),
    MARDOEMEEEE("Mardroemeeee", 1, FactionsEnum.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "C:\\Users\\asus\\Pictures\\Roblox\\RobloxScreenShot20230413_160547132.png", "receipt-1716645588760.png", 3);

    private String name;
    private int id;
    private FactionsEnum faction;
    private CardType type;
    private int power;
    private CardAbility ability;
    private boolean hero;
    private String preGameImage;
    private String inGameImage;
    private int preGameCount;

    CardEnum(String name, int id, FactionsEnum faction, CardType type, int power, CardAbility ability, boolean hero, String preGameImage, String inGameImage, int preGameCount) {
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

    public FactionsEnum getFaction() {
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
