package model;

import controller.ApplicationController;
import enums.Card.CardPositions;
import enums.Card.CommandersEnum;
import enums.Card.FactionsEnum;
import javafx.scene.layout.AnchorPane;
import model.Commanders.Commander;
import model.Factions.Faction;
import model.User.User;

import java.util.ArrayList;
import java.util.List;

public class Player extends User {
    private ArrayList<AnchorPane> hand = new ArrayList<>();
    private ArrayList<AnchorPane> discardPile = new ArrayList<>();
    private ArrayList<Card> deck = new ArrayList<>();



    private User user;
    private int availableCards = 0;
    private CommandersEnum commander;
    private FactionsEnum currentFaction;
    private int roundsWon = 0;
    private int roundsLost = 0;
    private int roundsDrawn = 0;
    private int lives = 2;

    private ArrayList<AnchorPane> closedCombatUnits = new ArrayList<>();
    private ArrayList<AnchorPane> rangedCombatUnits = new ArrayList<>();
    private ArrayList<AnchorPane> siegeCombatUnits = new ArrayList<>();

    // rawPower, a, b    power = a*rawPower+b
    private int closedCombatUnitsPower = 0;
    private int rangedCombatUnitsPower = 0;
    private int siegeCombatUnitsPower = 0;
    private int totalPower = 0;

    private AnchorPane closedCombatSpecial;
    private AnchorPane rangedCombatSpecial;
    private AnchorPane siegeCombatSpecial;
    private AnchorPane commanderPane;

    private boolean doneAction = false;
    private int availableVetoes = 2;
    private boolean vetoed;
    private boolean passedTurn = false;
    private boolean wonRound1 = false;
    private boolean wonRound2 = false;
    private boolean wonRound3 = false;
    private boolean doneTurn = false;
    private int round1power = 0;
    private int round2power = 0;
    private int round3power = 0;
    private int totalFinalPower = 0;

    public Player(User user) {
        super(user.getUsername(), user.getNickname(), user.getPassword(), user.getEmail());
        this.user = user;
    }

    public ArrayList<AnchorPane> getHand() {
        return this.hand;
    }

    public void setHand(ArrayList<AnchorPane> hand) {
        this.hand = hand;
    }

    public ArrayList<Card> getDeck() {
        return this.deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getAvailableCards() {
        return availableCards;
    }

    public void setAvailableCards(int availableCards) {
        this.availableCards = availableCards;
    }

    public CommandersEnum getCommander() {
        return commander;
    }

    public void setCommander(CommandersEnum commander) {
        this.commander = commander;
    }

    public FactionsEnum getCurrentFaction() {
        return currentFaction;
    }

    public void setCurrentFaction(FactionsEnum currentFaction) {
        this.currentFaction = currentFaction;
    }

    public int getRoundsDrawn() {
        return roundsDrawn;
    }

    public void setRoundsDrawn(int roundsDrawn) {
        this.roundsDrawn = roundsDrawn;
    }

    public int getRoundsLost() {
        return roundsLost;
    }

    public void setRoundsLost(int roundsLost) {
        this.roundsLost = roundsLost;
    }

    public int getRoundsWon() {
        return roundsWon;
    }

    public void setRoundsWon(int roundsWon) {
        this.roundsWon = roundsWon;
    }

    public ArrayList<AnchorPane> getClosedCombatUnits() {
        return closedCombatUnits;
    }

    public ArrayList<AnchorPane> getRangedCombatUnits() {
        return rangedCombatUnits;
    }

    public ArrayList<AnchorPane> getSiegeCombatUnits() {
        return siegeCombatUnits;
    }

    public AnchorPane getClosedCombatSpecial() {
        return closedCombatSpecial;
    }

    public AnchorPane getRangedCombatSpecial() {
        return rangedCombatSpecial;
    }

    public AnchorPane getSiegeCombatSpecial() {
        return siegeCombatSpecial;
    }

    public void setClosedCombatSpecial(AnchorPane closedCombatSpecial) {
        this.closedCombatSpecial = closedCombatSpecial;
    }

    public void setRangedCombatSpecial(AnchorPane rangedCombatSpecial) {
        this.rangedCombatSpecial = rangedCombatSpecial;
    }

    public void setSiegeCombatSpecial(AnchorPane siegeCombatSpecial) {
        this.siegeCombatSpecial = siegeCombatSpecial;
    }

    public boolean isDoneAction() {
        return doneAction;
    }

    public void setDoneAction(boolean doneAction) {
        this.doneAction = doneAction;
    }

    public void addToHand(AnchorPane card) {
        ((Card)card.getUserData()).setCardPosition(CardPositions.HAND);
        this.hand.add(card);
    }

    public void removeFromHand(AnchorPane card) {
        this.hand.remove(card);
    }

    public void addToClosedCombatUnits(AnchorPane card) {
        ((Card)card.getUserData()).setCardPosition(CardPositions.CLOSED_COMBAT);
        this.closedCombatUnits.add(card);
    }

    public void removeFromClosedCombatUnits(AnchorPane card) {
        this.closedCombatUnits.remove(card);
    }

    public void addToRangedCombatUnits(AnchorPane card) {
        ((Card)card.getUserData()).setCardPosition(CardPositions.RANGED_COMBAT);
        this.rangedCombatUnits.add(card);
    }

    public void removeFromRangedCombatUnits(AnchorPane card) {
        this.rangedCombatUnits.remove(card);
    }

    public void addToSiegeCombatUnits(AnchorPane card) {
        ((Card)card.getUserData()).setCardPosition(CardPositions.SIEGE_COMBAT);
        this.siegeCombatUnits.add(card);
    }

    public void removeFromSiegeCombatUnits(AnchorPane card) {
        this.siegeCombatUnits.remove(card);
    }

    public void addToDeck(Card card) {
        this.deck.add(card);
    }

    public void removeFromDeck(Card card) {
        this.deck.remove(card);
    }

    public void addToClosedCombatSpecial(AnchorPane card) {
        ((Card)card.getUserData()).setCardPosition(CardPositions.CLOSED_COMBAT_SPECIAL);
        this.closedCombatSpecial = card;
    }

    public void removeFromClosedCombatSpecial(AnchorPane card) {
        this.closedCombatSpecial = null;
    }

    public void addToRangedCombatSpecial(AnchorPane card) {
        ((Card)card.getUserData()).setCardPosition(CardPositions.RANGED_COMBAT_SPECIAL);
        this.rangedCombatSpecial = card;
    }

    public void removeFromRangedCombatSpecial(AnchorPane card) {
        this.rangedCombatSpecial = null;
    }

    public void addToSiegeCombatSpecial(AnchorPane card) {
        ((Card)card.getUserData()).setCardPosition(CardPositions.SIEGE_COMBAT_SPECIAL);
        this.siegeCombatSpecial = card;
    }

    public void removeFromSiegeCombatSpecial(AnchorPane card) {
        this.siegeCombatSpecial = null;
    }

    public int getClosedCombatPoints() {
        return getRowPoints(closedCombatUnits);
    }

    public int getRangedCombatPoints() {
        return getRowPoints(rangedCombatUnits);
    }

    public int getSiegeCombatPoints() {
        return getRowPoints(siegeCombatUnits);
    }

    private int getRowPoints(ArrayList<AnchorPane> units) {
        if (units.isEmpty()) {
            return 0;
        }
        int result = 0;
        for (AnchorPane card : units) {
            Card cardObject = (Card) card.getUserData();
            cardObject.getPower();
            result += cardObject.getPower();
        }
        return result;
    }
    public int getRoundTotalPower() {
        return getClosedCombatPoints() + getRangedCombatPoints() + getSiegeCombatPoints();
    }

    public AnchorPane getCommanderPane() {
        return commanderPane;
    }

    public void setCommanderPane(AnchorPane commanderPane) {
        this.commanderPane = commanderPane;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public int getClosedPower(){
        closedCombatUnitsPower=0;
        for(AnchorPane card: closedCombatUnits){
            Card cardObject = (Card) card.getUserData();
            closedCombatUnitsPower += cardObject.getPower();
        }
        return closedCombatUnitsPower;
    }

    public int getRangedPower(){
        rangedCombatUnitsPower=0;
        for(AnchorPane card: rangedCombatUnits){
            Card cardObject = (Card) card.getUserData();
            rangedCombatUnitsPower += cardObject.getPower();
        }
        return rangedCombatUnitsPower;
    }

    public int getSiegePower(){
        siegeCombatUnitsPower=0;
        for(AnchorPane card: siegeCombatUnits){
            Card cardObject = (Card) card.getUserData();
            siegeCombatUnitsPower += cardObject.getPower();
        }
        return siegeCombatUnitsPower;
    }

    public int getTotalPower(){
        totalPower = getClosedPower()+getRangedPower()+getSiegePower();
        return totalPower;
    }

    public ArrayList<AnchorPane> getDiscardPile() {
        return discardPile;
    }

    public void setDiscardPile(ArrayList<AnchorPane> discardPile) {
        this.discardPile = discardPile;
    }

    public void addToDiscardPile(AnchorPane card) {
        ((Card)card.getUserData()).setCardPosition(CardPositions.DISCARD_PILE);
        ((Card)card.getUserData()).setPowerModifier(0);
        ((Card)card.getUserData()).setPowerCoefficient(1);
        this.discardPile.add(card);
    }

    public int getAvailableVetoes() {
        return availableVetoes;
    }

    public void setAvailableVetoes(int availableVetoes) {
        this.availableVetoes = availableVetoes;
    }

    public boolean isVetoed() {
        return vetoed;
    }

    public void setVetoed(boolean vetoed) {
        this.vetoed = vetoed;
    }

    public boolean isPassedTurn() {
        return passedTurn;
    }

    public void setPassedTurn(boolean passedTurn) {
        this.passedTurn = passedTurn;
    }

    public boolean isWonRound1() {
        return wonRound1;
    }

    public void setWonRound1(boolean wonRound1) {
        this.wonRound1 = wonRound1;
    }

    public boolean isWonRound2() {
        return wonRound2;
    }

    public void setWonRound2(boolean wonRound2) {
        this.wonRound2 = wonRound2;
    }

    public boolean isWonRound3() {
        return wonRound3;
    }

    public void setWonRound3(boolean wonRound3) {
        this.wonRound3 = wonRound3;
    }

    public void removeFromDiscardPile(AnchorPane card) {
        this.discardPile.remove(card);
    }

    public boolean isDoneTurn() {
        return doneTurn;
    }

    public void setDoneTurn(boolean doneTurn) {
        this.doneTurn = doneTurn;
    }

    public int getTotalFinalPower() {
        return totalFinalPower;
    }

    public void setTotalFinalPower(int totalFinalPower) {
        this.totalFinalPower = totalFinalPower;
    }

    public int getRound1power() {
        return round1power;
    }

    public void setRound1power(int round1power) {
        this.round1power = round1power;
    }

    public int getRound2power() {
        return round2power;
    }

    public void setRound2power(int round2power) {
        this.round2power = round2power;
    }

    public int getRound3power() {
        return round3power;
    }

    public void setRound3power(int round3power) {
        this.round3power = round3power;
    }
}
