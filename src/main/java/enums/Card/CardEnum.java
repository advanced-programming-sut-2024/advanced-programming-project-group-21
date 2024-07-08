package enums.Card;

public enum CardEnum {
    // name, id, faction, type, power, ability, hero, preGameImage, inGameImage, preGameCount

    // Neutral

    // Skelliege
    MARDOEME("Mardroeme", 1, FactionsEnum.SKELLIGE, CardType.SPELL, 0, CardAbility.MARDOEME, true, "file:src/main/resources/Images/CardsDetailed/special_mardroeme.jpg", "file:src/main/resources/Images/CardsNoText/special_mardroeme.jpg", 3),
    BERSEERKER("Berserker", 2, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 4, CardAbility.BERSEKER, false, "file:src/main/resources/Images/CardsDetailed/skellige_berserker.jpg", "file:src/main/resources/Images/CardsNoText/skellige_berserker (1).jpg", 1),
    VIDKAARL("Vidkaarl", 3, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 14, CardAbility.MORALE_BOOST,false, "file:src/main/resources/Images/CardsDetailed/skellige_vildkaarl.jpg", "file:src/main/resources/Images/CardsNoText/skellige_vildkaarl (1).jpg", 1),
    SVANRIGE("Svanrige", 4, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_svanrige.jpg", "file:src/main/resources/Images/CardsNoText/skellige_svanrige (1).jpg", 1),
    UDALRYK("Udalryk", 5, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_udalryk.jpg", "file:src/main/resources/Images/CardsNoText/skellige_udalryk (1).jpg", 1),
    DONAR_AN_HINDAR("Donar an Hindar", 6, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_donar.jpg", "file:src/main/resources/Images/CardsNoText/skellige_donar (1).jpg", 1),
    CLAN_AN_CRAITE("Clan an Craite Warrior", 7, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 6, CardAbility.TIGHT_BOND, false, "file:src/main/resources/Images/CardsDetailed/skellige_craite_warrior.jpg", "file:src/main/resources/Images/CardsNoText/skellige_craite_warrior (1).jpg", 3),
    BLUEBOY_LUGOS("Blueboy Lugos", 8, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_blueboy.jpg", "file:src/main/resources/Images/CardsNoText/skellige_blueboy (1).jpg", 1),
    MADMAN_LUGOS("Madman Lugos", 9, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 6, CardAbility.NONE, false, "file: src/main/resources/Images/CardsDetailed/skellige_madmad_lugos.jpg", "file:src/main/resources/Images/CardsNoText/skellige_madmad_lugos (1).jpg", 1),
    CERYS("Cerys", 10, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 10, CardAbility.MUSTER, true, "file: src/main/resources/Images/CardsDetailed/skellige_cerys.jpg", "file:src/main/resources/Images/CardsNoText/skellige_cerys (1).jpg", 1),
    KAMBI("Kambi", 11, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT, 11, CardAbility.TRANSFORMERMS, true, "file:src/main/resources/Images/CardsDetailed/skellige_kambi.jpg", "file:src/main/resources/Images/CardsNoText/skellige_kambi (1).jpg", 1),
    BIRNA("Birna Bran", 12, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,2, CardAbility.MEDIC, false, "file:src/main/resources/Images/CardsDetailed/skellige_birna.jpg", "file:src/main/resources/Images/CardsNoText/skellige_birna (1).jpg", 1),
    CLAN_DRUMMOND_SHIELD_MAIDAN("Clan Drummond Shield Maiden", 13, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.TIGHT_BOND, false, "file:src/main/resources/Images/CardsDetailed/skellige_shield_maiden_2.jpg", "file:src/main/resources/Images/CardsNoText/skellige_shield_maiden.jpg", 3),
    CLAN_TORDARACH_ARMORSMITH("Clan Tordarach Armorsmith", 14, FactionsEnum.SKELLIGE, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_tordarroch.jpg", "file:src/main/resources/Images/CardsNoText/skellige_tordarroch (1).jpg", 1),
    CLAN_DIMUN_PIRATE("Clan Dimun Pirate", 15, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 6, CardAbility.SCORCH, false, "file:src/main/resources/Images/CardsDetailed/skellige_dimun_pirate.jpg", "file:src/main/resources/Images/CardsNoText/skellige_dimun_pirate (1).jpg", 1),
    CLAN_BROKVAR("Clan Brokvar Archer", 16, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_brokva_archer.jpg", "file:src/main/resources/Images/CardsNoText/skellige_brokva_archer (1).jpg", 3),
    ERMION("Ermion", 17, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT,8, CardAbility.MARDOEME,true, "file:src/main/resources/Images/CardsDetailed/skellige_ermion.jpg", "file:src/main/resources/Images/CardsNoText/skellige_ermion (1).jpg", 1),
    HJALMAR("Hjalmar", 18, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 10, CardAbility.NONE, true, "file:src/main/resources/Images/CardsDetailed/skellige_hjalmar.jpg", "file:src/main/resources/Images/CardsNoText/skellige_hjalmar (1).jpg", 1),
    YOUNG_BERSERKER("Young Berserker", 19, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT, 2, CardAbility.BERSEKER, false, "file:src/main/resources/Images/CardsDetailed/skellige_young_berserker.jpg", "file:src/main/resources/Images/CardsNoText/skellige_young_berserker (1).jpg", 3),
    YOUNG_VIDKAARL("Young Vidkaarl", 20, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT,8,CardAbility.TIGHT_BOND, false, "file:src/main/resources/Images/CardsDetailed/skellige_young_vildkaarl.jpg", "file:src/main/resources/Images/CardsNoText/skellige_young_vildkaarl (1).jpg", 1),
    LIGHT_LONGSHIP("Light Longship", 21, FactionsEnum.SKELLIGE, CardType.RANGED_UNIT,4,CardAbility.MUSTER, false, "file:src/main/resources/Images/CardsDetailed/skellige_light_longship.jpg", "file:src/main/resources/Images/CardsNoText/skellige_light_longship (1).jpg", 3),
    HOLGER("Holger Blackhand", 22, FactionsEnum.SKELLIGE, CardType.SIEGE_UNIT,4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/skellige_holger.jpg", "file:src/main/resources/Images/CardsNoText/skellige_holger (1).jpg", 1),
    WAR_LONGSHIP("War Longship", 23, FactionsEnum.SKELLIGE, CardType.SIEGE_UNIT,6, CardAbility.TIGHT_BOND, false, "file:src/main/resources/Images/CardsDetailed/skellige_war_longship.jpg", "file:src/main/resources/Images/CardsNoText/skellige_war_longship (1).jpg", 3),
    DRAIG_BON_DHU("Draig Bon-Dhu", 24, FactionsEnum.SKELLIGE, CardType.SIEGE_UNIT,2, CardAbility.COMMANDERS_HORN, false, "file:src/main/resources/Images/CardsDetailed/skellige_draig.jpg", "file:src/main/resources/Images/CardsNoText/skellige_draig (1).jpg", 1),
    OLAF("Olaf", 25, FactionsEnum.SKELLIGE, CardType.AGILE_UNIT,12, CardAbility.MORALE_BOOST, false, "file:src/main/resources/Images/CardsDetailed/skellige_olaf.jpg", "file:src/main/resources/Images/CardsNoText/skellige_olaf (1).jpg", 1),
    // Scoiatael
    ELVEN_SKIRMISHER("Elven Skirmisher", 26, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,2, CardAbility.MUSTER, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_elven_skirmisher_2 (1).jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_elf_skirmisher.jpg", 3),
    LORVETH("Lorveth", 27, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,10, CardAbility.NONE, true, "file:src/main/resources/Images/CardsDetailed/scoiatael_iorveth.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_iorveth (1).jpg", 1),
    DOL_BLATHANNA("Dol Blathanna Archer", 28, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_dol_archer.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_dol_archer (1).jpg", 1),
    HAVEKAR_HEALER("Havekar Healer", 29, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,0, CardAbility.MEDIC, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_havekar_healer.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_havekar_nurse.jpg", 3),
    IDA("Ida Emean", 30, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_ida.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_ida (1).jpg", 1),
    RIORDAIN("Riordain", 31, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,1, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_riordain.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_riordain (1).jpg", 1),
    TORUVIEL("Toruviel", 32, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,2, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_toruviel.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_toruviel (1).jpg", 1),
    VERIHEDD_BRIGADE_RECRIUT("Verihedd Brigade Recruit", 33, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,4, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_vrihedd_Brigade_RECRUIT.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_vrihedd_cadet (1).jpg", 1),
    MILVA("Milva", 34, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,10, CardAbility.MORALE_BOOST, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_milva.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_milva (1).jpg", 1),
    SEASENTHESSIS("Seasenthesiss", 35, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,10, CardAbility.NONE, true, "file:src/main/resources/Images/CardsDetailed/scoiatael_saesenthessis.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_saskia (1).jpg", 1),
    EITHNE("Eithne", 36, FactionsEnum.SCOIATAEL, CardType.RANGED_UNIT,10, CardAbility.NONE, true, "file:src/main/resources/Images/CardsDetailed/scoiatael_eithne.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_eithne (1).jpg", 1),
    YAEVINN("Yaevinn", 37, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_yaevinn.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_yaevinn (1).jpg", 1),
    CIARAN_AEP("Ciaran aep Easnillen", 38, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,3, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_ciaran.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_ciaran (1).jpg", 1),
    DOL_BLATHANNA_SCOUT("Dol Blathanna Scout", 39, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_dol_blathanna.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_dol_infantry (1).jpg", 3),
    FILAVANDREL("Filavandrel", 40, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_filavandrel.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_filavandrel (1).jpg", 1),
    VERIHEDD_BRIGADE_VETERAN("Verihedd Brigade Veteran", 41, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,5, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_vrihedd_brigade_VETERAN.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_vrihedd_brigade (1).jpg", 2),
    BARCLAY("Barclay Els", 42, FactionsEnum.SCOIATAEL, CardType.AGILE_UNIT,6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_barclay.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_barclay (1).jpg", 1),
    DENNIS_CRANMER("Dennis Cranmer", 43, FactionsEnum.SCOIATAEL, CardType.CLOSED_COMBAT_UNIT,6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_dennis.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_dennis (1).jpg", 1),
    DWARVEN_SKIRMISHER("Dwarven Skirmisher", 44, FactionsEnum.SCOIATAEL, CardType.CLOSED_COMBAT_UNIT,3, CardAbility.MUSTER, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_dwarven_skirmisher.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_dwarf (1).jpg", 3),
    HAVEKAR_SMUGGLER("Havekar Smuggler", 45, FactionsEnum.SCOIATAEL, CardType.CLOSED_COMBAT_UNIT,5, CardAbility.MUSTER, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_havekar_smuggler.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_havekar_support (1).jpg", 3),
    MAHAKAM_DEFENDER("Mahakam Defender", 46, FactionsEnum.SCOIATAEL, CardType.CLOSED_COMBAT_UNIT,5, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_mahakam_defender.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_mahakam (1).jpg", 5),
    ISENGRIM_FAOILT("Isengrim Faoiltiarna", 47, FactionsEnum.SCOIATAEL, CardType.CLOSED_COMBAT_UNIT,10, CardAbility.MORALE_BOOST, true, "file:src/main/resources/Images/CardsDetailed/scoiatael_isengrim.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_isengrim (1).jpg", 1),
    SCHIRRU("Schirru", 48, FactionsEnum.SCOIATAEL, CardType.SIEGE_UNIT,8, CardAbility.SCORCH, false, "file:src/main/resources/Images/CardsDetailed/scoiatael_schirru.jpg", "file:src/main/resources/Images/CardsNoText/scoiatael_schirru (1).jpg", 1),
    // Northern Realms
    BALLISTA("Ballista", 49, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/realms_ballista.jpg", "file:src/main/resources/Images/CardsNoText/realms_ballista.jpg", 2),
    CATAPULT("Catapult", 50, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,8, CardAbility.TIGHT_BOND, false, "file:src/main/resources/Images/CardsDetailed/realms_catapult_1.jpg", "file:src/main/resources/Images/CardsNoText/realms_catapult_1.jpg", 2),
    DUN_BANNER("Dun Banner", 51, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,5, CardAbility.MEDIC, false, "file:src/main/resources/Images/CardsDetailed/realms_dun_banner.jpg", "file:src/main/resources/Images/CardsNoText/realms_banner_nurse.jpg", 1),
    KAEDWENI_SIEGE_EXPERT("Kaedweni Seargent expert", 52, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,1, CardAbility.MORALE_BOOST, false, "file:src/main/resources/Images/CardsDetailed/realms_kaedwen_siege.jpg", "file:src/main/resources/Images/CardsNoText/realms_kaedwen_siege.jpg", 3),
    SIEGE_TOWER("Siege Tower", 53, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/realms_siege_tower.jpg", "file:src/main/resources/Images/CardsNoText/realms_siege_tower.jpg", 1),
    THALER("Thaler", 54, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,1, CardAbility.SPY, false, "file:src/main/resources/Images/CardsDetailed/realms_thaler.jpg", "file:src/main/resources/Images/CardsNoText/realms_thaler.jpg", 1),
    TREBUCHET("Trebuchet", 55, FactionsEnum.NORTHERN_REALMS, CardType.SIEGE_UNIT,6, CardAbility.NONE, false, "file:src/main/resources/Images/CardsDetailed/realms_trebuchet.jpg", "file:src/main/resources/Images/CardsNoText/realms_trebuchet.jpg", 2),
    BLUE_STRIPES("Blue Stripes Commando", 56, FactionsEnum.NORTHERN_REALMS, CardType.CLOSED_COMBAT_UNIT,4, CardAbility.TIGHT_BOND, false, "file:src/main/resources/Images/CardsDetailed/realms_blue_stripes.jpg", "file:src/main/resources/Images/CardsNoText/realms_blue_stripes.jpg", 3),
    ESTERAD_THYSSEN("Esterad Thyssen", 57, FactionsEnum.NORTHERN_REALMS, CardType.CLOSED_COMBAT_UNIT,10, CardAbility.NONE, true, "file:src/main/resources/Images/CardsDetailed/realms_esterad.jpg", "file:src/main/resources/Images/CardsNoText/realms_esterad.jpg", 1),
    JOHN_NATALIS("John Natalis", 58, FactionsEnum.NORTHERN_REALMS, CardType.CLOSED_COMBAT_UNIT,10, CardAbility.NONE, true, "file:src/main/resources/Images/CardsDetailed/realms_john_natalis.jpg", "file:src/main/resources/Images/CardsNoText/realms_natalis.jpg", 1),
    POOR_INFANTRY("poor infantry",59,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,1,CardAbility.TIGHT_BOND,false,"file:src/main/resources/Images/CardsDetailed/realms_poor_infantry.jpg","file:src/main/resources/Images/CardsNoText/realms_poor_infantry.jpg",4),
    PRINCE_STENNIS("Prince Stennis",60,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.SPY,false,"file:src/main/resources/Images/CardsDetailed/realms_stennis.jpg","file:src/main/resources/Images/CardsNoText/realms_stennis.jpg",1),
    REDANIAN_FOOT_SOLDIER("Redanian Foot Soldier",61,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,1,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/realms_redania.jpg","file:src/main/resources/Images/CardsNoText/realms_redania.jpg",2),
    SIEGFRIED_OF_DENESLE("Siegfried of Denesle",62,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/realms_siegfried.jpg","file:src/main/resources/Images/CardsNoText/realms_siegfried.jpg",1),
    SIGISMUND_DIJKSTRA("Sigismund Dijkstra",63,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.SPY,false,"file:src/main/resources/Images/CardsDetailed/realms_dijkstra.jpg","file:src/main/resources/Images/CardsNoText/realms_dijkstra.jpg",1),
    VERNON_ROCHE("Vernon Roche",64,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.NONE,true,"file:src/main/resources/Images/CardsDetailed/realms_vernon.jpg","file:src/main/resources/Images/CardsNoText/realms_vernon.jpg",1),
    Ves("Ves",65,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/realms_ves.jpg","file:src/main/resources/Images/CardsNoText/realms_ves.jpg",1),
    YARPEN("Yarpen Zigrin",66,FactionsEnum.NORTHERN_REALMS,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/realms_yarpen.jpg","file:src/main/resources/Images/CardsNoText/realms_yarpen.jpg",1),
    DRAGON_HUNTER("Dragon Hunter",67,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,5,CardAbility.TIGHT_BOND,false,"file:src/main/resources/Images/CardsDetailed/realms_DRAGON_HUNTER.jpg","file:src/main/resources/Images/CardsNoText/realms_crinfrid.jpg",3),
    DETHMOLD("Dethmold",68,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,6,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/realms_dethmold.jpg","file:src/main/resources/Images/CardsNoText/realms_dethmold.jpg",1),
    KEIRA_METZ("Keira Metz",69,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/realms_keira.jpg","file:src/main/resources/Images/CardsNoText/realms_keira.jpg",1),
    PHILIPPA("Philippa Eilhart",70,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,10,CardAbility.NONE,true,"file:src/main/resources/Images/CardsDetailed/realms_philippa.jpg","file:src/main/resources/Images/CardsNoText/realms_philippa.jpg",1),
    SABRINA("Sabrina Glevissig",71,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,4,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/realms_sabrina.jpg","file:src/main/resources/Images/CardsNoText/realms_sabrina.jpg",1),
    SHELDON("Sheldon Skaggs",72,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,4,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/realms_sheldon.jpg","file:src/main/resources/Images/CardsNoText/realms_sheldon.jpg",1),
    SILE("Sile de Tansarville",73,FactionsEnum.NORTHERN_REALMS,CardType.RANGED_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/realms_sile_de_tansarville.jpg","file:src/main/resources/Images/CardsNoText/realms_sheala.jpg",1),
    // nilfgaard
    IMPERA_BRIGADE_GUARD("Impera Brigade Guard",74,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,3,CardAbility.TIGHT_BOND,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_imperal_brigade.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_imperal_brigade.jpg",4),
    STEFAN("Stefan Skellen",75,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,9,CardAbility.SPY,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_stefan.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_stefan.jpg",1),
    SHILARD("Shilard Fitz-Oesterlen",76,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,7,CardAbility.SPY,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_shilard.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_shilard.jpg",1),
    YOUNG_EMISSARY("Young Emissary",77,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.TIGHT_BOND,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_young_emissary.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_young_emissary.jpg",2),
    CAHIR_MAWR("Cahir Mawr Dyffryn aep Ceallach",78,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_cahir.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_cahir.jpg",1),
    VATTIER("Vattier de Rideaux",79,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.SPY,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_vattier.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_vattier.jpg",1),
    MENNO("Menno Coehoorn",80,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.MEDIC,true,"file:src/main/resources/Images/CardsDetailed/nilfgaard_menno.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_menno.jpg",1),
    LETHO_OF_GULET("Letho of Gulet",81,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.NONE,true,"file:src/main/resources/Images/CardsDetailed/nilfgaard_letho.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_letho.jpg",1),
    MORTEISEN("Morteisen",82,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,3,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_morteisen.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_morteisen.jpg",1),
    NAUSICAA("Nausicaa Cavalry Rider",83,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.TIGHT_BOND,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_nauzicaa_2.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_nauzicaa_2.jpg",3),
    RAINFAARN("Rainfarn",84,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_rainfarn.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_rainfarn.jpg",1),
    VREEMDE("Vreemde",85,FactionsEnum.NILFGAARD,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_vreemde.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_vreemde.jpg",1),
    PUTTKAMER("Puttkamer",86,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,3,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_puttkammer.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_puttkammer.jpg",1),
    ASSIRE_VAR_ANAHID("Assire var Anahid",87,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,6,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_assire.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_assire.jpg",1),
    BLACK_INFANTRY_ARCHER("Black Infantry Archer",88,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,10,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_black_archer.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_black_archer.jpg",2),
    TIBOR_EGGEBRACHT("Tibor Eggebracht",89,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,10,CardAbility.NONE,true,"file:src/main/resources/Images/CardsDetailed/nilfgaard_tibor.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_tibor.jpg",1),
    RENUALD_AEP_MATSEN("Renuald aep Matsen",90,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_renuald.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_renuald.jpg",1),
    FRINGILLA("Fringilla Vigo",91,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,6,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_fringilla.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_fringilla.jpg",1),
    ALBRICH("Albrich",92,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_albrich.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_albrich.jpg",1),
    CYNTHIA("Cynthia",93,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,4,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_cynthia.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_cynthia.jpg",1),
    ETOLIAN_AUXILIARY("Etolian Auxiliary Archer",94,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,1,CardAbility.MEDIC,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_etolian.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_archer_support.jpg",2),
    SWEERS("Sweers",95,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_sweers.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_sweers.jpg",1),
    VANHEMAR("Vanhemar",96,FactionsEnum.NILFGAARD,CardType.RANGED_UNIT,4,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_vanhemar.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_vanhemar.jpg",1),
    ROTTEN_MANGONEL("Rotten Mangonel",97,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,3,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_rotten.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_rotten.jpg",1),
    HEAVY_ZERKANIAN_FIRE_SCORPION("Heavy Zerkanian Fire Scorpion",98,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,10,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_heavy_zerri.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_heavy_zerri.jpg",1),
    ZERRIKANIAN_FIRE_SCORPION("Zerrikanian Fire Scorpion",99,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_zerri.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_zerri.jpg",1),
    SIEGE_ENGINEER("Siege Engineer",100,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,6,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_siege_engineer.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_siege_engineer.jpg",1),
    MORVARN("Morvran Voorhis",101,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,10,CardAbility.NONE,true,"file:src/main/resources/Images/CardsDetailed/nilfgaard_moorvran.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_moorvran.jpg",1),
    SIEGE_TECHNICIAN("Siege Technician",102,FactionsEnum.NILFGAARD,CardType.SIEGE_UNIT,0,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/nilfgaard_siege_tech.jpg","file:src/main/resources/Images/CardsNoText/nilfgaard_siege_support.jpg",1),
    // Monsters
    DRAUG("Draug",103,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.NONE,true,"file:src/main/resources/Images/CardsDetailed/monsters_draug.jpg","file:",1),
    IMLERITH("Imlerith",104,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.NONE,true,"file:src/main/resources/Images/CardsDetailed/monsters_imlerith.jpg","file:",1),
    LESHEN("Leshen",105,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,10,CardAbility.NONE,true,"file:","file:",1),
    CRONE_BREWESS("Crone: Brewess",106,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.MUSTER,false,"filesrc/main/resources/Images/CardsDetailed/monsters_Brewess.jpg:","file:",1),
    CRONE_WEAVESS("Crone: Weavess",107,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_weaves.jpg","file:",1),
    CRONE_WHISPESS("Crone: Whispess",108,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_witch_velen_2.jpg","file:",1),
    FIEND("Fiend",109,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,6,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_fiend.jpg","file:",1),
    FORKTAIL("Forktail",110,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_forktail.jpg","file:",1),
    FRIGHTENER("Frightener",111,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_frightener.jpg","file:",1),
    GRIFFIN("Griffin",112,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_gryffin.jpg","file:",1),
    PLAGUE_MAIDEN("Plague Maiden",113,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_mighty_maiden.jpg","file:",1),
    VAMPIRE_KATAKAN("Vampire: Katakan",114,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_katakan.jpg","file:",1),
    WEREWOLF("Were-Wolf",115,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_werewolf.jpg","file:",1),
    ARACHAS("Arachas",116,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_arachas.jpg","file:",3),
    BOTCHLING("Botchling",117,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_botchling.jpg","file:",1),
    VAMPIRE_BRUXA("Vampire: Bruxa",118,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_bruxa.jpg","file:",1),
    VAMPIRE_EKIMMARA("Vampire: Ekimmara",119,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_ekkima.jpg","file:",1),
    VAMPIRE_FLEDER("Vampire: Fleder",120,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_fleder.jpg","file:",1),
    VAMPIRE_GARKAIN("Vampire: Garkain",121,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,4,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_garkain.jpg","file:",1),
    FOGLET("Foglet",122,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_fogling.jpg","file:",1),
    NEKKER("Nekker",123,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,2,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_nekker.jpg","file:",3),
    GHOUL("Ghoul",124,FactionsEnum.MONSTERS,CardType.CLOSED_COMBAT_UNIT,1,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_ghoul.jpg","file:",3),
    TOAD("Toad",125,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,7,CardAbility.SCORCH,false,"file:src/main/resources/Images/CardsDetailed/monsters_toad.jpg","file:",1),
    GRAVE_HAG("Grave Hag",126,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_gravehag.jpg","file:",1),
    COCKATRICE("Cockatrice",127,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_cockatrice.jpg","file:",1),
    ENDREGA("Endrega",128,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_endrega.jpg","file:",1),
    GARGOYLE("Gargoyle",129,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_gargoyle.jpg","file:",1),
    WYVERN("Wyvern",130,FactionsEnum.MONSTERS,CardType.RANGED_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_wyvern.jpg","file:",1),
    KAYRAN("Kayran",131,FactionsEnum.MONSTERS,CardType.AGILE_UNIT,8,CardAbility.MORALE_BOOST,true,"file:src/main/resources/Images/CardsDetailed/monsters_kayran.jpg","file:",1),
    CELAENO_HARPY("Celaeno Harpy",132,FactionsEnum.MONSTERS,CardType.AGILE_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_celaeno_harpy.jpg","file:",1),
    HARPY("Harpy",133,FactionsEnum.MONSTERS,CardType.AGILE_UNIT,2,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_harpy.jpg","file:",1),
    ARACHAS_BEHEMOTH("Arachas Behemoth",134,FactionsEnum.MONSTERS,CardType.SIEGE_UNIT,6,CardAbility.MUSTER,false,"file:src/main/resources/Images/CardsDetailed/monsters_arachas_behemoth.jpg","file:",1),
    EARTH_ELEMENTAL("Earth Elemental",135,FactionsEnum.MONSTERS,CardType.SIEGE_UNIT,6,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_earth_elemental.jpg","file:",1),
    FIRE_ELEMENTAL("Fire Elemental",136,FactionsEnum.MONSTERS,CardType.SIEGE_UNIT,6,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_fire_elemental.jpg","file:",1),
    ICE_GIANT("Ice Giant",137,FactionsEnum.MONSTERS,CardType.SIEGE_UNIT,5,CardAbility.NONE,false,"file:src/main/resources/Images/CardsDetailed/monsters_frost_giant.jpg","file:",1),
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
