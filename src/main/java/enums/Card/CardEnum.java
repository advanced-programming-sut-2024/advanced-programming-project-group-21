package enums.Card;

public enum CardEnum {
    // name, id, faction, type, power, ability, hero, preGameImage, inGameImage, preGameCount

    // Neutral

    // Skelliege
    MARDOEME("Mardroeme", 1, FactionsEnum.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "file:src/main/resources/Images/CardsDetailed/special_mardroeme.jpg", "file:src/main/resources/Images/CardsNoText/special_mardroeme.jpg", 3),
    BERSEERKER("Berserker", 2, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 4, CardAbility.BERSEKER, false, "file:src/main/resources/Images/CardsDetailed/skellige_berserker.jpg", "file:", 1),
    VIDKAARL("Vidkaarl", 3, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 14, CardAbility.MORALE_BOOST,false, "file:src/main/resources/Images/CardsDetailed/skellige_vildkaarl.jpg", "file:", 1),
    SVANRIGE("Svanrige", 4, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_svanrige.jpg", "file:", 1),
    UDALRYK("Udalryk", 5, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_udalryk.jpg", "file:", 1),
    DONAR_AN_HINDAR("Donar an Hindar", 6, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_donar.jpg", "file:", 1),
    CLAN_AN_CRAITE("Clan an Craite Warrior", 7, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 6, CardAbility.TIGHT_BOND, false, "file:src/main/resources/Images/CardsDetailed/skellige_craite_warrior.jpg", "file:", 3),
    BLUEBOY_LUGOS("Blueboy Lugos", 8, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_blueboy.jpg", "file:", 1),
    MADMAN_LUGOS("Madman Lugos", 9, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 6, CardAbility.NONE, false, "file: src/main/resources/Images/CardsDetailed/skellige_madmad_lugos.jpg", "file:", 1),
    CERYS("Cerys", 10, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 10, CardAbility.MUSTER, true, "file: src/main/resources/Images/CardsDetailed/skellige_cerys.jpg", "file:", 1),
    KAMBI("Kambi", 11, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 11, CardAbility.TRANSFORMERMS, true, "file:src/main/resources/Images/CardsDetailed/skellige_kambi.jpg", "file:", 1),
    BIRNA("Birna Bran", 12, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,2, CardAbility.MEDIC, false, "file:src/main/resources/Images/CardsDetailed/skellige_birna.jpg", "file:", 1),
    CLAN_DRUMMOND_SHIELD_MAIDAN("Clan Drummond Shield Maiden", 13, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.TIGHT_BOND, false, "file:src/main/resources/Images/CardsDetailed/skellige_shield_maiden_2.jpg", "file:", 3),
    CLAN_TORDARACH_ARMORSMITH("Clan Tordarach Armorsmith", 14, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_tordarroch.jpg", "file:", 1),
    CLAN_DIMUN_PIRATE("Clan Dimun Pirate", 15, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 6, CardAbility.SCORCH, false, "file:src/main/resources/Images/CardsDetailed/skellige_dimun_pirate.jpg", "file:", 1),
    CLAN_BROKVAR("Clan Brokvar Archer", 16, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_brokva_archer.jpg", "file:", 3),
    ERMION("Ermion", 17, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT,8, CardAbility.MARDOEME,true, "file:src/main/resources/Images/CardsDetailed/skellige_ermion.jpg", "file:", 1),
    HJALMAR("Hjalmar", 18, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 10, CardAbility.NONE, true, "file:src/main/resources/Images/CardsDetailed/skellige_hjalmar.jpg", "file:", 1),
    YOUNG_BERSERKER("Young Berserker", 19, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 2, CardAbility.BERSEKER, false, "file:src/main/resources/Images/CardsDetailed/skellige_young_berserker.jpg", "file:", 3),
    YOUNG_VIDKAARL("Young Vidkaarl", 20, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT,8,CardAbility.TIGHT_BOND, false, "file:src/main/resources/Images/CardsDetailed/skellige_young_vildkaarl.jpg", "file:", 1),
    LIGHT_LONGSHIP("Light Longship", 21, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT,4,CardAbility.MUSTER, false, "file:src/main/resources/Images/CardsDetailed/skellige_light_longship.jpg", "file:", 3),
    HOLGER("Holger Blackhand", 22, FactionsEnum.SKELLIGE, CardType.SIEGE_UNIT,4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_holger.jpg", "file:", 1),
    WAR_LONGSHIP("War Longship", 23, FactionsEnum.SKELLIGE, CardType.SIEGE_UNIT,6, CardAbility.TIGHT_BOND, false, "file:src/main/resources/Images/CardsDetailed/skellige_war_longship.jpg", "file:", 3),
    DRAIG_BON_DHU("Draig Bon-Dhu", 24, FactionsEnum.SKELLIGE, CardType.SIEGE_UNIT,2, CardAbility.COMMANDERS_HORN, false, "file:src/main/resources/Images/CardsDetailed/skellige_draig.jpg", "file:", 1),
    OLAF("Olaf", 25, FactionsEnum.SKELLIGE, CardType.AGILE_UNIT,12, CardAbility.MORALE_BOOST, false, "file:src/main/resources/Images/CardsDetailed/skellige_olaf.jpg", "file:", 1),
    // Scoiatael
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
    // Northern Realms
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
    POOR_INFANTRY("poor infantry",59,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,1,CardAbility.TIGHT_BOND,false,"file:","file:",4),
    PRINCE_STENNIS("Prince Stennis",60,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.SPY,false,"file:","file:",1),
    REDANIAN_FOOT_SOLDIER("Redanian Foot Soldier",61,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,1,CardAbility.NONE,false,"file:","file:",2),
    SIEGFRIED_OF_DENESLE("Siegfried of Denesle",62,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    SIGISMUND("Sigismund Dijkstra",63,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.SPY,false,"file:","file:",1),
    VERNON("Vernon Roche",64,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.NONE,true,"file:","file:",1),
    Ves("Ves",65,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    YARPEN("Yarpen Zigrin",66,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    DRAGON_HUNTER("Dragon Hunter",67,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,5,CardAbility.TIGHT_BOND,false,"file:","file:",3),
    DETHMOLD("Dethmold",68,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,6,CardAbility.NONE,false,"file:","file:",1),
    KEIRA_METZ("Keira Metz",69,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    PHILIPPA("Philippa Eilhart",70,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,10,CardAbility.NONE,true,"file:","file:",1),
    SABRINA("Sabrina Glevissig",71,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,4,CardAbility.NONE,false,"file:","file:",1),
    SHELDON("Sheldon Skaggs",72,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,4,CardAbility.NONE,false,"file:","file:",1),
    SILE("Sile de Tansarville",73,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    // nilfgaard
    IMPERA_BRIGADE_GUARD("Impera Brigade Guard",74,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,3,CardAbility.TIGHT_BOND,false,"file:","file:",4),
    STEFAN("Stefan Skellen",75,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,9,CardAbility.SPY,false,"file:","file:",1),
    SHILARD("Shilard Fitz-Oesterlen",76,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,7,CardAbility.SPY,false,"file:","file:",1),
    YOUNG_EMISARY("Young Emissary",77,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.TIGHT_BOND,false,"file:","file:",2),
    CAHIR_MAWR("Cahir Mawr Dyffryn aep Ceallach",78,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.NONE,false,"file:","file:",1),
    VATTIER("Vattier de Rideaux",79,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.SPY,false,"file:","file:",1),
    MENNO("Menno Coehoorn",80,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.MEDIC,true,"file:","file:",1),
    LETHO_OF_GULET("Letho of Gulet",81,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.NONE,true,"file:","file:",1),
    MORTEISEN("Morteisen",82,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,3,CardAbility.NONE,false,"file:","file:",1),
    NAUSICAA("Nausicaa Cavalry Rider",83,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.TIGHT_BOND,false,"file:","file:",3),
    RAINFAARN("Rainfarn",84,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.NONE,false,"file:","file:",1),
    //VATTIER("Vattier de Rideaux",85,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.SPY,false,"file:","file:",1),
    VREEMDE("Vreemde",85,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    PUTTKAMER("Puttkamer",86,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,3,CardAbility.NONE,false,"file:","file:",1),
    ASSIRE_VAR_ANAHID("Assire var Anahid",87,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,6,CardAbility.NONE,false,"file:","file:",1),
    BLACK_INFANTRY_ARCHER("Black Infantry Archer",88,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,10,CardAbility.NONE,false,"file:","file:",2),
    TIBOR_EGGEBRACHT("Tibor Eggebracht",89,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,10,CardAbility.NONE,true,"file:","file:",1),
    RENUALD_AEP_MATSEN("Renuald aep Matsen",90,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    FRINGILLA("Fringilla Vigo",91,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,6,CardAbility.NONE,false,"file:","file:",1),
    ALBRICH("Albrich",92,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    CYNTHIA("Cynthia",93,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,4,CardAbility.NONE,false,"file:","file:",1),
    ETOLIAN_AUXILIARY("Etolian Auxiliary Archer",94,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,1,CardAbility.MEDIC,false,"file:","file:",2),
    SWEERS("Sweers",95,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    VANHEMAR("Vanhemar",96,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,4,CardAbility.NONE,false,"file:","file:",1),
    ROTTEN_MANGONEL("Rotten Mangonel",97,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,3,CardAbility.NONE,false,"file:","file:",1),
    HEAVY_ZERKANIAN_FIRE_SCORPION("Heavy Zerkanian Fire Scorpion",98,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,10,CardAbility.NONE,false,"file:","file:",1),
    ZERRIKANIAN_FIRE_SCORPION("Zerrikanian Fire Scorpion",99,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    SIEGE_ENGINEER("Siege Engineer",100,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,6,CardAbility.NONE,false,"file:","file:",1),
    MORVARN("Morvran Voorhis",101,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,10,CardAbility.NONE,true,"file:","file:",1),
    SIEGE_TECHNICIAN("Siege Technician",102,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,0,CardAbility.NONE,false,"file:","file:",1),
    // Monsters
    DRAUG("Draug",103,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.NONE,true,"file:","file:",1),
    IMLERITH("Imlerith",104,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.NONE,true,"file:","file:",1),
    LESHEN("Leshen",105,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.NONE,true,"file:","file:",1),
    CRONE_BREWESS("Crone: Brewess",106,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.MUSTER,false,"file:","file:",1),
    CRONE_WEAVESS("Crone: Weavess",107,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.MUSTER,false,"file:","file:",1),
    CRONE_WHISPESS("Crone: Whispess",108,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.MUSTER,false,"file:","file:",1),
    FIEND("Fiend",109,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.NONE,false,"file:","file:",1),
    FORKTAIL("Forktail",110,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    FRIGHTENER("Frightener",111,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    GRIFFIN("Griffin",112,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    PLAGUE_MAIDEN("Plague Maiden",113,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    VAMPIRE_KATAKAN("Vampire: Katakan",114,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.MUSTER,false,"file:","file:",1),
    WEREWOLF("Were-Wolf",115,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    ARACHAS("Arachas",116,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.MUSTER,false,"file:","file:",3),
    BOTCHLING("Botchling",117,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.NONE,false,"file:","file:",1),
    VAMPIRE_BRUXA("Vampire: Bruxa",118,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.MUSTER,false,"file:","file:",1),
    VAMPIRE_EKIMARRA("Vampire: Ekimmara",119,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.MUSTER,false,"file:","file:",1),
    VAMPIRE_FLEDER("Vampire: Fleder",120,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.MUSTER,false,"file:","file:",1),
    VAMPIRE_GARKAIN("Vampire: Garkain",121,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.MUSTER,false,"file:","file:",1),
    FOGLET("Foglet",122,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    NEKKER("Nekker",123,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.MUSTER,false,"file:","file:",3),
    GHOUL("Ghoul",124,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,1,CardAbility.MUSTER,false,"file:","file:",3),
    TOAD("Toad",125,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,7,CardAbility.SCORCH,false,"file:","file:",1),
    GRAVE_HAG("Grave Hag",126,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    COCKATRICE("Cockatrice",127,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    ENDREGA("Endrega",128,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    GARGOYLE("Gargoyle",129,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    WYVERN("Wyvern",130,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    KAYRAN("Kayran",131,FactionsEnum.MONSTERS,CardType.AGILE_UNIT,8,CardAbility.MORALE_BOOST,true,"file:","file:",1),
    CELAENO_HARPY("Celaeno Harpy",132,FactionsEnum.MONSTERS,CardType.AGILE_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    HARPY("Harpy",133,FactionsEnum.MONSTERS,CardType.AGILE_UNIT,2,CardAbility.NONE,false,"file:","file:",1),
    ARACHAS_BEHEMOTH("Arachas Behemoth",134,FactionsEnum.MONSTERS,CardType.SIEGE_UNIT,6,CardAbility.MUSTER,false,"file:","file:",1),
    EARTH_ELEMENTAL("Earth Elemental",135,FactionsEnum.MONSTERS,CardType.SIEGE_UNIT,6,CardAbility.NONE,false,"file:","file:",1),
    FIRE_ELEMENTAL("Fire Elemental",136,FactionsEnum.MONSTERS,CardType.SIEGE_UNIT,6,CardAbility.NONE,false,"file:","file:",1),
    ICE_GIANT("Ice Giant",137,FactionsEnum.MONSTERS,CardType.SIEGE_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    //NEUTRAL
    BITING_FROST("Biting Frost",138,FactionsEnum.NEUTRAL,CardType.WEATHER,0,CardAbility.NONE,false,"file:","file:",3),
    IMPENETRABLE_FOG("Impenetrable Fog",139,FactionsEnum.NEUTRAL,CardType.WEATHER,0,CardAbility.NONE,false,"file:","file:",3),
    TORRENTIAL_RAIN("Torrential Rain",140,FactionsEnum.NEUTRAL,CardType.WEATHER,0,CardAbility.NONE,false,"file:","file:",3),
    SKELLIGE_STORM("Skellige Storm",141,FactionsEnum.NEUTRAL,CardType.WEATHER,0,CardAbility.NONE,false,"file:","file:",3),
    CLEAR_WEATHER("Clear Weather",142,FactionsEnum.NEUTRAL,CardType.WEATHER,0,CardAbility.NONE,false,"file:","file:",3),
    SCORCH("Scorch",143,FactionsEnum.NEUTRAL,CardType.SPELL,0,CardAbility.SCORCH,false,"file:","file:",3),
    DECOY("Decoy",144,FactionsEnum.NEUTRAL,CardType.SPELL,0,CardAbility.DECOY,false,"file:","file:",3),
    COMMANDERS_HORN("Commander's Horn",145,FactionsEnum.NEUTRAL,CardType.SPELL,0,CardAbility.COMMANDERS_HORN,false,"file:","file:",3),
    DANDELION("Dandelion",146,FactionsEnum.NEUTRAL,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.COMMANDERS_HORN,false,"file:","file:",1),
    EMIEL_REGIS("Emiel Regis Rohellec Terzieff",147,FactionsEnum.NEUTRAL,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    GERALT_OF_RIVIA("Geralt of Rivia",148,FactionsEnum.NEUTRAL,CardType.CLOSED_COMBAT_UNIT,15,CardAbility.NONE,true,"file:","file:",1),
    MYSTERIOUS_ELF("Mysterious Elf",149,FactionsEnum.NEUTRAL,CardType.CLOSED_COMBAT_UNIT,0,CardAbility.SPY,true,"file:","file:",1),
    TRISS_MERIGOLD("Triss Merigold",150,FactionsEnum.NEUTRAL,CardType.CLOSED_COMBAT_UNIT,7,CardAbility.NONE,true,"file:","file:",1),
    VESEMIR("Vesemir",151,FactionsEnum.NEUTRAL,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.NONE,false,"file:","file:",1),
    VILLEN_TRETTMIR("Villentretenmerth",152,FactionsEnum.NEUTRAL,CardType.CLOSED_COMBAT_UNIT,7,CardAbility.SCORCH,false,"file:","file:",1),
    ZOLTAN_CHIVAY("Zoltan Chivay",153,FactionsEnum.NEUTRAL,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:","file:",1),
    COW("Cow",154,FactionsEnum.NEUTRAL,CardType.RANGED_UNIT,0,CardAbility.TRANSFORMERMS,false,"file:","file:",1),
    GAUNTER_ODIMM_DARKNESS("Gaunter O'Dimm: Darkness",155,FactionsEnum.NEUTRAL,CardType.RANGED_UNIT,4,CardAbility.MUSTER,false,"file:","file:",3),
    YENNEFER_OF_VENGERBERG("Yennefer of Vengerberg",156,FactionsEnum.NEUTRAL,CardType.RANGED_UNIT,7,CardAbility.MEDIC,true,"file:","file:",1),
    GAUNTER_ODIMM("Gaunter O'Dimm",157,FactionsEnum.NEUTRAL,CardType.SIEGE_UNIT,2,CardAbility.MUSTER,false,"file:","file:",1),
    OLGIERD_VON_EVEREC("Olgierd von Everec",158,FactionsEnum.NEUTRAL,CardType.AGILE_UNIT,6,CardAbility.MORALE_BOOST,false,"file:","file:",1);








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
