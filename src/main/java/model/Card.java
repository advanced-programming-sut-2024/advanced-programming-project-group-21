package model;

import enums.Card.CardAbility;
import enums.Card.CardEnum;
import enums.Card.CardType;
import enums.Card.Factions;

public class Card{
    private String name;
    private int id;
    private Factions faction;
    private CardType type;
    private int power;
    private CardAbility ability;
    private boolean hero;
    private String preGameImage;
    private String inGameImage;
    public Card(CardEnum cardEnum) {
        this.name = cardEnum.getName();
        this.id = cardEnum.getId();
        this.faction = cardEnum.getFaction();
        this.type = cardEnum.getType();
        this.power = cardEnum.getPower();
        this.ability = cardEnum.getAbility();
        this.hero = cardEnum.isHero();
        this.preGameImage = cardEnum.getPreGameImage();
        this.inGameImage = cardEnum.getInGameImage();

    }
}
