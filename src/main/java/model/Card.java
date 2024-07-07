package model;

import enums.Card.*;
import javafx.scene.Scene;

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
    private CardPositions cardPosition = CardPositions.DECK;
    private double powerCoefficient = 1;
    private int powerModifier = 0;
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
        return ((int)(power*powerCoefficient))+powerModifier;
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

    public void setPowerCoefficient(double powerCoefficient) {
        this.powerCoefficient = powerCoefficient;
    }

    public void setPowerModifier(int powerModifier) {
        this.powerModifier = powerModifier;
    }

    public double getPowerCoefficient() {
        return powerCoefficient;
    }

    public int getPowerModifier() {
        return powerModifier;
    }

    public void setCardPosition(CardPositions cardPosition) {
        this.cardPosition = cardPosition;
    }

    public CardPositions getCardPosition() {
        return cardPosition;
    }
}
