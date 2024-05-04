package model;

import java.util.ArrayList;

public class GameBoard {
    private static Player player1;
    private static Player player2;
    private static ArrayList<Card> player1FirstRow = new ArrayList<>();
    private static ArrayList<Card> player1SecondRow = new ArrayList<>();
    private static ArrayList<Card> player1ThirdRow = new ArrayList<>();
    private static ArrayList<Card> player2FirstRow = new ArrayList<>();
    private static ArrayList<Card> player2SecondRow = new ArrayList<>();
    private static ArrayList<Card> player3ThirdRow = new ArrayList<>();
    private static ArrayList<Spell> spellCards = new ArrayList<>();
    private static Commander player1Commander;
    private static Commander player2Commander;

    public static ArrayList<Card> getPlayer1FirstRow() {
        return player1FirstRow;
    }

    public static void setPlayer1FirstRow(ArrayList<Card> player1FirstRow) {
        GameBoard.player1FirstRow = player1FirstRow;
    }

    public static ArrayList<Card> getPlayer1SecondRow() {
        return player1SecondRow;
    }

    public static void setPlayer1SecondRow(ArrayList<Card> player1SecondRow) {
        GameBoard.player1SecondRow = player1SecondRow;
    }

    public static ArrayList<Card> getPlayer1ThirdRow() {
        return player1ThirdRow;
    }

    public static void setPlayer1ThirdRow(ArrayList<Card> player1ThirdRow) {
        GameBoard.player1ThirdRow = player1ThirdRow;
    }

    public static ArrayList<Card> getPlayer2FirstRow() {
        return player2FirstRow;
    }

    public static void setPlayer2FirstRow(ArrayList<Card> player2FirstRow) {
        GameBoard.player2FirstRow = player2FirstRow;
    }

    public static ArrayList<Card> getPlayer2SecondRow() {
        return player2SecondRow;
    }

    public static void setPlayer2SecondRow(ArrayList<Card> player2SecondRow) {
        GameBoard.player2SecondRow = player2SecondRow;
    }

    public static ArrayList<Card> getPlayer3ThirdRow() {
        return player3ThirdRow;
    }

    public static void setPlayer3ThirdRow(ArrayList<Card> player3ThirdRow) {
        GameBoard.player3ThirdRow = player3ThirdRow;
    }

    public static Commander getPlayer1Commander() {
        return player1Commander;
    }

    public static void setPlayer1Commander(Commander player1Commander) {
        GameBoard.player1Commander = player1Commander;
    }

    public static Commander getPlayer2Commander() {
        return player2Commander;
    }

    public static void setPlayer2Commander(Commander player2Commander) {
        GameBoard.player2Commander = player2Commander;
    }

    public static Player getPlayer1() {
        return player1;
    }

    public static void setPlayer1(Player player1) {
        GameBoard.player1 = player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static void setPlayer2(Player player2) {
        GameBoard.player2 = player2;
    }

    public static ArrayList<Spell> getSpellCards() {
        return spellCards;
    }

    public static void setSpellCards(ArrayList<Spell> spellCards) {
        GameBoard.spellCards = spellCards;
    }
}
