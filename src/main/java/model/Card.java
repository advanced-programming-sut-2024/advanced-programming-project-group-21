package model;

import enums.Card.CardAbility;
import enums.Card.CardEnum;
import enums.Card.CardType;
import enums.Card.FactionsEnum;

public class Card{
    private String name;
    private int id;
    private FactionsEnum faction;
    private CardType type;
    private int power;
    private CardAbility ability;
    private boolean hero;
    private String preGameImage;
    private String inGameImage;
    private CardEnum cardEnum;
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
        this.cardEnum = cardEnum;

    }

    public String getPreGameImage() {
        return preGameImage;
    }

    public String getName() {
        return name;
    }

    public CardEnum getCardEnum() {
        return cardEnum;
    }

    public FactionsEnum getFaction() {
        return faction;
    }

    public int getId() {
        return id;
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

    public String getInGameImage() {
        return inGameImage;
    }
}
