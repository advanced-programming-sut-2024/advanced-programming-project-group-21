package enums.Card;

public enum CardEnum {
    // name, id, faction, type, power, ability, hero, preGameImage, inGameImage, preGameCount

    // Neutral

    // Skelliege
    MARDOEME("Mardroeme", 1, FactionsEnum.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "file:src/main/resources/Images/CardsDetailed/special_mardroeme.jpg", "file:src/main/resources/Images/CardsNoText/special_mardroeme.jpg", 3),
    BERSEERKER("Berserker", 2, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 4, CardAbility.BERSEKER, false, "file:", "file:", 1),
    VIDKAARL("Vidkaarl", 3, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 14, CardAbility.MORALE_BOOST,false, "file:", "file:", 1),
    SVANRIGE("Svanrige", 4, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 4, CardAbility.NONE, false, "file:", "file:", 1),
    UDALRYK("Udalryk", 5, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.NONE, false, "file:", "file:", 1),
    DONAR_AN_HINDAR("Donar an Hindar", 6, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 4, CardAbility.NONE, false, "file:", "file:", 1),
    CLAN_AN_CRAITE("Clan an Craite Warrior", 7, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 6, CardAbility.TIGHT_BOND, false, "file:", "file:", 3),
    BLUEBOY_LUGOS("Blueboy Lugos", 8, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 6, CardAbility.NONE, false, "file:", "file:", 1),
    MADMAN_LUGOS("Madman Lugos", 9, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 6, CardAbility.NONE, false, "file:", "file:", 1),
    CERYS("Cerys", 10, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 10, CardAbility.MUSTER, true, "file:", "file:", 1),
    KAMBI("Kambi", 11, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 11, CardAbility.TRANSFORMERMS, true, "file:", "file:", 1),
    BIRNA("Birna", 12, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,2, CardAbility.MEDIC, false, "file:", "file:", 1),
    CLAN_DRUMMOND("Clan Drummond Shield Maiden", 13, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.TIGHT_BOND, false, "file:", "file:", 3),
    CLAN_TORDARACH("Clan Tordarach Shieldsmith", 14, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.NONE, false, "file:", "file:", 1),
    CLAN_DIMUN("Clan Dimun Pirate", 15, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 6, CardAbility.SCORCH, false, "file:", "file:", 1),
    CLAN_BROKVAR("Clan Brokvar Archer", 16, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 6, CardAbility.NONE, false, "file:", "file:", 3),
    ERMION("Ermion", 17, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT,8, CardAbility.MARDOEME,true, "file:", "file:", 1),
    HJALMAR("Hjalmar", 18, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 10, CardAbility.NONE, true, "file:", "file:", 1),
    YOUNG_BERSERKER("Young Berserker", 19, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 2, CardAbility.BERSEKER, false, "file:", "file:", 3),
    YOUNG_VIDKAARL("Young Vidkaarl", 20, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT,8,CardAbility.TIGHT_BOND, false, "file:", "file:", 1),
    LIGHT_LONGSHIP("Light Longship", 21, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT,4,CardAbility.MUSTER, false, "file:", "file:", 3),
    HOLGER("Holger Blackhand", 22, FactionsEnum.SKELLIGE, CardType.SIEGE_UNIT,4, CardAbility.NONE, false, "file:", "file:", 1),
    WAR_LONGSHIP("War Longship", 23, FactionsEnum.SKELLIGE, CardType.SIEGE_UNIT,6, CardAbility.TIGHT_BOND, false, "file:", "file:", 3),
    DRAIG_BON_DHU("Draig Bon-Dhu", 24, FactionsEnum.SKELLIGE, CardType.SIEGE_UNIT,2, CardAbility.COMMANDERS_HORN, false, "file:", "file:", 1),
    OLAF("Olaf", 25, FactionsEnum.SKELLIGE, CardType.AGILE_UNIT,12, CardAbility.MORALE_BOOST, false, "file:", "file:", 1),
    ELVEN_SKIRMISHER("Elven Skirmisher", 26, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,2, CardAbility.MUSTER, false, "file:", "file:", 3),
    LORVETH("Lorveth", 27, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,10, CardAbility.NONE, true, "file:", "file:", 1),
    DOL_BLAITHAN("Dol Blathanna Archer", 28, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,4, CardAbility.NONE, false, "file:", "file:", 1),
    HAVEKAR_HEALER("Havekar Healer", 29, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,0, CardAbility.MEDIC, false, "file:", "file:", 3),
    IDA("Ida Emean", 30, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,6, CardAbility.NONE, false, "file:", "file:", 1),
    RIODRAN("Riodran", 31, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,1, CardAbility.NONE, false, "file:", "file:", 1),
    TORUVIEL("Toruviel", 32, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,2, CardAbility.NONE, false, "file:", "file:", 1),
    VERIHEDD_BRIGADE_RECRIUT("Verihedd Brigade Recruit", 33, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,4, CardAbility.NONE, false, "file:", "file:", 1),
    MILVA("Milva", 34, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,10, CardAbility.MORALE_BOOST, false, "file:", "file:", 1),
    SEASENTHESSIS("Seasenthesiss", 35, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,10, CardAbility.NONE, true, "file:", "file:", 1),
    EITHNE("Eithne", 36, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,10, CardAbility.NONE, true, "file:", "file:", 1),
    YAEVIN("Yaevinn", 37, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,6, CardAbility.NONE, false, "file:", "file:", 1),
    CIARAN_AEP("Ciaran aep Easnillen", 38, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,3, CardAbility.NONE, false, "file:", "file:", 1),
    DOL_BLATHANNA_SCOUT("Dol Blathanna Scout", 39, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,6, CardAbility.NONE, false, "file:", "file:", 3),
    FILAVANDREL("Filavandrel", 40, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,6, CardAbility.NONE, false, "file:", "file:", 1),
    VERIHEDD_BRIGADE_VETERAN("Verihedd Brigade Veteran", 41, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,5, CardAbility.NONE, false, "file:", "file:", 2),
    BARCLAY("Barclay Els", 42, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,6, CardAbility.NONE, false, "file:", "file:", 1),
    DENNIS_CRANMER("Dennis Cranmer", 43, FactionsEnum.SCOIATAEL, CardType.CLOSED_COMBAT_UNIT,6, CardAbility.NONE, false, "file:", "file:", 1),
    DWARVEN_SKIRMISHER("Dwarven Skirmisher", 44, FactionsEnum.SCOIATAEL, CardType.CLOSED_COMBAT_UNIT,3, CardAbility.MUSTER, false, "file:", "file:", 3),
    HAVEKAR_SMUGGLER("Havekar Smuggler", 45, FactionsEnum.SCOIATAEL, CardType.CLOSED_COMBAT_UNIT,5, CardAbility.MUSTER, false, "file:", "file:", 3),
    MAHAKAM_DEFENDER("Mahakam Defender", 46, FactionsEnum.SCOIATAEL, CardType.CLOSED_COMBAT_UNIT,5, CardAbility.NONE, false, "file:", "file:", 5),
    ISENGRIM_FAOILT("Isengrim Faoiltiarna", 47, FactionsEnum.SCOIATAEL, CardType.CLOSED_COMBAT_UNIT,10, CardAbility.MORALE_BOOST, true, "file:", "file:", 1),
    SCHIRRU("Schirru", 48, FactionsEnum.SCOIATAEL, CardType.SIEGE_UNIT,8, CardAbility.SCORCH, false, "file:", "file:", 1),
    BALLISTA("Ballista", 49, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,6, CardAbility.NONE, false, "file:", "file:", 2),
    CATAPULT("Catapult", 50, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,8, CardAbility.TIGHT_BOND, false, "file:", "file:", 2),
    DUN_BANNER("Dun Banner", 51, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,5, CardAbility.MEDIC, false, "file:", "file:", 1),
    KADWENI_SIEGE_EXPERT("Kaedweni Seargent expert", 52, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,1, CardAbility.MORALE_BOOST, false, "file:", "file:", 3),
    SIEGE_TOWER("Siege Tower", 53, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,6, CardAbility.NONE, false, "file:", "file:", 1),
    THALER("Thaler", 54, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,1, CardAbility.SPY, false, "file:", "file:", 1),
    TREBUCHET("Trebuchet", 55, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,6, CardAbility.NONE, false, "file:", "file:", 2),
    BLUE_STRIPES("Blue Stripes Commando", 56, FactionsEnum.NORTHERN_REALMS, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.TIGHT_BOND, false, "file:", "file:", 3),
    ESTERAD_THYSSEN("Esterad Thyssen", 57, FactionsEnum.NORTHERN_REALMS, CardType.CLOSED_COMBAT_UNIT,10, CardAbility.NONE, true, "file:", "file:", 1),
    JOHN_NATALIS("John Natalis", 58, FactionsEnum.NORTHERN_REALMS, CardType.CLOSED_COMBAT_UNIT,10, CardAbility.NONE, true, "file:", "file:", 1),
    POOR_INFANTRY("poor infantry",59,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,1,CardAbility.TIGHT_BOND,false,"file:","file:",4);

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
