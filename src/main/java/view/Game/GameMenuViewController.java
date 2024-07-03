package view.Game;

import controller.ApplicationController;
import controller.GameMenuController;
import enums.Card.CommandersEnum;
import enums.Card.FactionsEnum;
import enums.GameStates;
import javafx.collections.ObservableList;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.*;

import java.util.ArrayList;

public class GameMenuViewController {
    public AnchorPane enemyCommanderPane;
    public ImageView enemyCommanderActive;
    public AnchorPane userCommanderPane;
    public ImageView userCommanderActive;
    public VBox enemyCardHBoxes;
    public VBox userCardHBoxes;
    public HBox specialCardPlace;
    public AnchorPane enemyGraveyard;
    public AnchorPane enemyDeck;
    public AnchorPane userGraveyard;
    public AnchorPane userDeck;
    public AnchorPane enemyInfoPane;
    public Label enemyTotalPoints;
    public Label userTotalPoints;
    public AnchorPane userInfoPane;
    public HBox userCommanderHBox;
    public HBox enemyCommanderHBox;
    public HBox handHBox;
    public Label enemyCardCount;
    public Label userCardCount;
    public ImageView enemyLive1;
    public ImageView enemyLive2;
    public ImageView userLive1;
    public ImageView userLive2;
    public Label userName;
    public Label enemyName;
    public Label userFaction;
    public Label enemyFaction;
    public HBox userClosedHBox;
    public HBox userRangedHBox;
    public AnchorPane userRangedSpecial;
    public AnchorPane userClosedSpecial;
    public AnchorPane enemyClosedSpecial;
    public HBox enemyClosedHBox;
    public AnchorPane enemyRangeSpecial;
    public HBox enemyRangedHBox;
    public AnchorPane enemySiegeSpecial;
    public HBox enemySiegeHBox;
    public AnchorPane userSiegeSpecial;
    public HBox userSiegeHBox;
    public Label userSiegePoints;
    public Label userRangedPoints;
    public Label userClosedPoints;
    public Label enemySiegePoints;
    public Label enemyClosedPoints;
    public Label enemyRangedPoints;
    GameMenuController controller = new GameMenuController();

    public void initialize() {
        Game game = ApplicationController.game;
        if (game == null) {
            ApplicationController.game = new Game(ApplicationController.preGame);
            ApplicationController.preGame = null;
            controller.setCurrentPlayer();
            controller.shuffleDeckCards(ApplicationController.game.getPlayer1());
            controller.shuffleDeckCards(ApplicationController.game.getPlayer2());
            setDeckSizeLabel();
            createStartingHandPanes();
            ApplicationController.game.getPlayer1().setCommanderPane(createCommanderPane(ApplicationController.game.getPlayer1().getCommander()));
            ApplicationController.game.getPlayer2().setCommanderPane(createCommanderPane(ApplicationController.game.getPlayer2().getCommander()));
            ApplicationController.game.setGameState(GameStates.ROUND_1_STARTED);
            loadTable();
            loadHand();
        }
    }

    private void changeActivePlayer() {
        ApplicationController.game.switchPlayer();
        loadTable();
        loadHand();
    }

    private void loadTable() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        loadCards();
        loadSpecials();
        loadCommanders();
        loadInfo();
        setDeckSizeLabel();
        updateCardCount();
    }

    private void updateCardCount() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        int userCardCount = currentPlayer.getHand().size();
        int enemyCardCount = enemyPlayer.getHand().size();

        this.userCardCount.setText(Integer.toString(userCardCount));
        this.enemyCardCount.setText(Integer.toString(enemyCardCount));
    }

    private void loadInfo() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        userName.setText(currentPlayer.getNickname());
        enemyName.setText(enemyPlayer.getNickname());

        userFaction.setText(currentPlayer.getCurrentFaction().name());
        enemyFaction.setText(enemyPlayer.getCurrentFaction().name());

        int userLives = currentPlayer.getLives();
        int enemyLives = enemyPlayer.getLives();

        if (userLives == 2) {
            userLive1.setVisible(true);
            userLive2.setVisible(true);
        } else if (userLives == 1) {
            userLive1.setVisible(true);
            userLive2.setVisible(false);
        } else {
            userLive1.setVisible(false);
            userLive2.setVisible(false);
        }

        if (enemyLives == 2) {
            enemyLive1.setVisible(true);
            enemyLive2.setVisible(true);
        } else if (enemyLives == 1) {
            enemyLive1.setVisible(true);
            enemyLive2.setVisible(false);
        } else {
            enemyLive1.setVisible(false);
            enemyLive2.setVisible(false);
        }
    }

    private AnchorPane createCommanderPane(CommandersEnum commandersEnum) {
        AnchorPane commanderPane = new AnchorPane();
        commanderPane.setId(commandersEnum.name());
        commanderPane.setUserData(commandersEnum);

        setCardSize(commanderPane, 90, 63);

        ImageView commanderImageView = getImageView(commanderPane.getPrefHeight(), commanderPane.getPrefWidth(), commandersEnum.getInGameImage());
        commanderPane.getChildren().add(commanderImageView);

        return commanderPane;
    }



    private void loadCommanders() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        AnchorPane userCommander = currentPlayer.getCommanderPane();
        AnchorPane enemyCommander = enemyPlayer.getCommanderPane();

        userCommanderPane.getChildren().clear();
        userCommanderPane.getChildren().add(userCommander);

        enemyCommanderPane.getChildren().clear();
        enemyCommanderPane.getChildren().add(enemyCommander);

        if (currentPlayer.isDoneAction()) {
            userCommanderActive.setVisible(false);
        } else {
            userCommanderActive.setVisible(true);
        }

        if (enemyPlayer.isDoneAction()) {
            enemyCommanderActive.setVisible(false);
        } else {
            enemyCommanderActive.setVisible(true);
        }
    }

    private void loadSpecials() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        AnchorPane userClosed = currentPlayer.getClosedCombatSpecial();
        AnchorPane userRanged = currentPlayer.getRangedCombatSpecial();
        AnchorPane userSiege = currentPlayer.getSiegeCombatSpecial();

        AnchorPane enemyClosed = enemyPlayer.getClosedCombatSpecial();
        AnchorPane enemyRanged = enemyPlayer.getRangedCombatSpecial();
        AnchorPane enemySiege = enemyPlayer.getSiegeCombatSpecial();

        if (userClosed != null)
            userClosedSpecial = userClosed;
        if (userRanged != null)
            userRangedSpecial = userRanged;
        if (userSiege != null)
            userSiegeSpecial = userSiege;

        if (enemyClosed != null)
            enemyClosedSpecial = enemyClosed;
        if (enemyRanged != null)
            enemyRangeSpecial = enemyRanged;
        if (enemySiege != null)
            enemySiegeSpecial = enemySiege;
    }

    private void loadCards() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        ArrayList<AnchorPane> currentPlayerClosedCombatUnits = currentPlayer.getClosedCombatUnits();
        ArrayList<AnchorPane> currentPlayerRangedCombatUnits = currentPlayer.getRangedCombatUnits();
        ArrayList<AnchorPane> currentPlayerSiegeCombatUnits = currentPlayer.getSiegeCombatUnits();

        ArrayList<AnchorPane> enemyPlayerClosedCombatUnits = enemyPlayer.getClosedCombatUnits();
        ArrayList<AnchorPane> enemyPlayerRangedCombatUnits = enemyPlayer.getRangedCombatUnits();
        ArrayList<AnchorPane> enemyPlayerSiegeCombatUnits = enemyPlayer.getSiegeCombatUnits();

        loadPositions(currentPlayerClosedCombatUnits, currentPlayerRangedCombatUnits, currentPlayerSiegeCombatUnits, userClosedHBox, userRangedHBox, userSiegeHBox);

        loadPositions(enemyPlayerClosedCombatUnits, enemyPlayerRangedCombatUnits, enemyPlayerSiegeCombatUnits, enemyClosedHBox, enemyRangedHBox, enemySiegeHBox);

        loadPoints();
    }

    private void loadPoints() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        int userClosedPoints = currentPlayer.getClosedCombatPoints();
        int userRangedPoints = currentPlayer.getRangedCombatPoints();
        int userSiegePoints = currentPlayer.getSiegeCombatPoints();

        int enemyClosedPoints = enemyPlayer.getClosedCombatPoints();
        int enemyRangedPoints = enemyPlayer.getRangedCombatPoints();
        int enemySiegePoints = enemyPlayer.getSiegeCombatPoints();

        this.userClosedPoints.setText(Integer.toString(userClosedPoints));
        this.userRangedPoints.setText(Integer.toString(userRangedPoints));
        this.userSiegePoints.setText(Integer.toString(userSiegePoints));

        this.enemyClosedPoints.setText(Integer.toString(enemyClosedPoints));
        this.enemyRangedPoints.setText(Integer.toString(enemyRangedPoints));
        this.enemySiegePoints.setText(Integer.toString(enemySiegePoints));

        int userTotalPoints = userClosedPoints + userRangedPoints + userSiegePoints;
        int enemyTotalPoints = enemyClosedPoints + enemyRangedPoints + enemySiegePoints;

        this.userTotalPoints.setText(Integer.toString(userTotalPoints));
        this.enemyTotalPoints.setText(Integer.toString(enemyTotalPoints));
    }

    private void loadPositions(ArrayList<AnchorPane> currentPlayerClosedCombatUnits, ArrayList<AnchorPane> currentPlayerRangedCombatUnits, ArrayList<AnchorPane> currentPlayerSiegeCombatUnits, HBox userClosedHBox, HBox userRangedHBox, HBox userSiegeHBox) {
        userClosedHBox.getChildren().clear();
        for (AnchorPane card : currentPlayerClosedCombatUnits) {
            userClosedHBox.getChildren().add(card);
        }

        userRangedHBox.getChildren().clear();
        for (AnchorPane card : currentPlayerRangedCombatUnits) {
            userRangedHBox.getChildren().add(card);
        }

        userSiegeHBox.getChildren().clear();
        for (AnchorPane card : currentPlayerSiegeCombatUnits) {
            userSiegeHBox.getChildren().add(card);
        }
    }

    private void loadHand() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();

        ArrayList<AnchorPane> currentPlayerHand = new ArrayList<>();
        if (currentPlayer.equals(ApplicationController.game.getPlayer1())) {
            currentPlayerHand = ApplicationController.game.getPlayer1Hand();
        } else {
            currentPlayerHand = ApplicationController.game.getPlayer2Hand();
        }

        handHBox.getChildren().clear();

        for (AnchorPane card : currentPlayerHand) {
            handHBox.getChildren().add(card);
        }
    }

    private void createStartingHandPanes() {
        Player player1 = ApplicationController.game.getPlayer1();
        Player player2 = ApplicationController.game.getPlayer2();

        controller.createStartingHand();

        ArrayList<Card> player1Hand = player1.getHand();
        ArrayList<Card> player2Hand = player2.getHand();

        for (Card card : player1Hand) {
            AnchorPane cardAnchorPane = createCard(card);
            ApplicationController.game.getPlayer1Hand().add(cardAnchorPane);
        }

        for (Card card : player2Hand) {
            AnchorPane cardAnchorPane = createCard(card);
            ApplicationController.game.getPlayer2Hand().add(cardAnchorPane);
        }
    }

    private void setDeckSizeLabel() {
        Player userPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        int userDeckSize = userPlayer.getDeck().size();
        int enemyDeckSize = enemyPlayer.getDeck().size();

        ((Label) (userDeck.getChildren().get(2))).setText(Integer.toString(userDeckSize));
        ((Label) (enemyDeck.getChildren().get(2))).setText(Integer.toString(enemyDeckSize));
    }


    private AnchorPane createCard(Card card) {
        AnchorPane cardAnchorPane = new AnchorPane();
        cardAnchorPane.setId(card.getCardEnum().name());
        cardAnchorPane.setUserData(card);

        setCardSize(cardAnchorPane, 90, 63);

        ImageView cardImageView = getCardImageView(card, cardAnchorPane.getPrefHeight(), cardAnchorPane.getPrefWidth());
        cardAnchorPane.getChildren().add(cardImageView);

        cardImageView.setOnMouseClicked(event -> {

        });

        return cardAnchorPane;
    }

    private void showDetailedCard(){

    }

    private ImageView getCardImageView(Card card, double height, double width) {
        return getImageView(height, width, card.getInGameImage());
    }

    private ImageView getImageView(double height, double width, String inGameImage) {
        ImageView commanderImageView = new ImageView();
        Image commanderImage = new Image(inGameImage);

        commanderImageView.setFitHeight(height);
        commanderImageView.setFitWidth(width);
        commanderImageView.setPickOnBounds(true);
        commanderImageView.setPreserveRatio(true);
        commanderImageView.setImage(commanderImage);

        return commanderImageView;
    }

    private void setCardSize(AnchorPane card, double height, double width) {
        card.setPrefHeight(height);
        card.setMinHeight(height);
        card.setMaxHeight(height);
        card.setPrefWidth(width);
        card.setMinWidth(width);
        card.setMaxWidth(width);
    }
}
