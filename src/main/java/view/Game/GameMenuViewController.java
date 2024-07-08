package view.Game;

import controller.ApplicationController;
import controller.GameMenuController;
import enums.Card.*;
import enums.GameStates;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import model.*;
import model.User.User;
import view.Faction.FactionMenuView;
import view.Main.MainMenuView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;

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
    public HBox userRangedSpecial;
    public HBox userClosedSpecial;
    public HBox enemyClosedSpecial;
    public HBox enemyClosedHBox;
    public HBox enemyRangedSpecial;
    public HBox enemyRangedHBox;
    public HBox enemySiegeSpecial;
    public HBox enemySiegeHBox;
    public HBox userSiegeSpecial;
    public HBox userSiegeHBox;
    public Label userSiegePoints;
    public Label userRangedPoints;
    public Label userClosedPoints;
    public Label enemySiegePoints;
    public Label enemyClosedPoints;
    public Label enemyRangedPoints;
    public ImageView detailCard;
    public Rectangle detailRectangle;
    public Label detailLabel;
    public AnchorPane vetoPane;
    public HBox firstHBox;
    public HBox secondHBox;
    public VBox infoVBox;
    public AnchorPane vetoDetailCard;
    public Label vetoAbility;
    public Label vetoDescription;
    public Label vetoPlayerName;
    public AnchorPane gamePane;
    public AnchorPane cardPaneToBeDragged;
    public Button skipTurnButton;
    public Button confirmTurnButton;
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
            loadVetoHandCards();
        }
    }

    private void clearVeto() {
        firstHBox.getChildren().clear();
        secondHBox.getChildren().clear();
    }

    private void loadVetoHandCards() {
        vetoPane.setVisible(true);
        for (AnchorPane hand : ApplicationController.game.getCurrentPlayer().getHand()) {
            HBox hbox = new HBox();
            if (firstHBox.getChildren().size() < 6) {
                hbox = firstHBox;
            } else
                hbox = secondHBox;
            Card card = (Card) hand.getUserData();
            AnchorPane cardPane = createVetoCard(card);
            hbox.getChildren().add(cardPane);
        }
        vetoPlayerName.setText(ApplicationController.game.getCurrentPlayer().getNickname());
    }

    private AnchorPane createVetoCard(Card card) {
        AnchorPane cardPane = new AnchorPane();
        cardPane.setUserData(card);
        cardPane.setId(card.getName());
        cardPane.setOnMouseEntered(event -> vetoCardEntered(event));
        cardPane.setOnMouseExited(event -> vetoCardExited(event));
        cardPane.setOnMouseClicked(event -> vetoCardClicked(event));

        cardPane.setPrefHeight(240);
        cardPane.setMinHeight(240);
        cardPane.setMaxHeight(240);
        cardPane.setPrefWidth(127);
        cardPane.setMinWidth(127);
        cardPane.setMaxWidth(127);

        ImageView cardImageView = getImageView(cardPane.getPrefHeight(), cardPane.getPrefWidth(), card.getPreGameImage());
        cardPane.getChildren().add(cardImageView);

        return cardPane;
    }

    private void vetoCardClicked(MouseEvent event) {
        Player player = ApplicationController.game.getCurrentPlayer();
        ImageView cardImage = (ImageView) event.getTarget();
        AnchorPane cardPane = (AnchorPane) cardImage.getParent();
        if (player.getAvailableVetoes() > 0) {
            AnchorPane newCard = createVetoCard(player.getDeck().get(0));
            for (AnchorPane handCard : player.getHand()) {
                if (handCard.getUserData().equals(cardPane.getUserData())) {
                    player.getHand().remove(handCard);
                    player.getHand().add(createCard(player.getDeck().get(0)));
                    player.getDeck().remove(0);
                    player.getDeck().add((Card) cardPane.getUserData());
                    player.setAvailableVetoes(player.getAvailableVetoes() - 1);
                    replaceVetoCard(cardPane, newCard);
                    clearVeto();
                    loadVetoHandCards();
                    break;
                }
            }
            if (player.getAvailableVetoes() == 0)
                skipVeto();
        }
    }


    public void skipVeto() {
        Player player = ApplicationController.game.getCurrentPlayer();
        player.setVetoed(true);
        changeActivePlayer();
        if (ApplicationController.game.getCurrentPlayer().isVetoed()) {
            deleteVeto();
            ApplicationController.game.setGameState(GameStates.ROUND_1_STARTED);
        } else {
            clearVeto();
            loadVetoHandCards();
        }

    }

    public void skipVetoButton() {
        skipVeto();
    }

    private void deleteVeto() {
        vetoPane.setVisible(false);
    }

    private void replaceVetoCard(AnchorPane cardPane, AnchorPane newCard) {
        HBox hbox = new HBox();
        if (firstHBox.getChildren().contains(cardPane))
            hbox = firstHBox;
        else
            hbox = secondHBox;
        hbox.getChildren().remove(cardPane);
        hbox.getChildren().add(newCard);
    }

    private void vetoCardExited(MouseEvent event) {
        infoVBox.setVisible(false);
    }

    private void vetoCardEntered(MouseEvent event) {
        AnchorPane cardPane = (AnchorPane) event.getTarget();
        Card card = (Card) cardPane.getUserData();
        vetoAbility.setText(card.getAbility().getName());
        vetoDescription.setText(card.getAbility().getDescription());
        ((ImageView) (vetoDetailCard.getChildren().get(0))).setImage(new Image(card.getPreGameImage()));
        infoVBox.setVisible(true);
    }

    private void changeActivePlayer() {
        ApplicationController.game.switchPlayer();
        ApplicationController.game.getEnemyPlayer().setDoneTurn(false);
        loadTable();
    }

    private void loadTable() {
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

        changeGems(userLives, userLive1, userLive2);

        changeGems(enemyLives, enemyLive1, enemyLive2);
    }

    private void changeGems(int userLives, ImageView userLive1, ImageView userLive2) {
        if (userLives == 2) {
            userLive1.setImage(new Image("file:src/main/resources/Images/Icons/icon_gem_on.png"));
            userLive2.setImage(new Image("file:src/main/resources/Images/Icons/icon_gem_on.png"));
        } else if (userLives == 1) {
            userLive1.setImage(new Image("file:src/main/resources/Images/Icons/icon_gem_on.png"));
            userLive2.setImage(new Image("file:src/main/resources/Images/Icons/icon_gem_off.png"));
        } else {
            userLive1.setImage(new Image("file:src/main/resources/Images/Icons/icon_gem_off.png"));
            userLive2.setImage(new Image("file:src/main/resources/Images/Icons/icon_gem_off.png"));
        }
    }

    private AnchorPane createCommanderPane(CommandersEnum commandersEnum) {
        AnchorPane commanderPane = new AnchorPane();
        commanderPane.setId(commandersEnum.name());
        commanderPane.setUserData(commandersEnum);

        setCardSize(commanderPane, 90, 63);

        ImageView commanderImageView = getImageView(commanderPane.getPrefHeight(), commanderPane.getPrefWidth(), commandersEnum.getInGameImage());
        commanderPane.getChildren().add(commanderImageView);

        commanderImageView.setOnMouseEntered(event -> {
            showDetailedCommander(commanderPane);
        });
        commanderImageView.setOnMouseExited(event -> {
            hideDetailedCommander();
        });

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

        loadPlayerSpecials(currentPlayer, userClosedSpecial, userRangedSpecial, userSiegeSpecial);
        loadPlayerSpecials(enemyPlayer, enemyClosedSpecial, enemyRangedSpecial, enemySiegeSpecial);
    }

    private void loadPlayerSpecials(Player player, HBox userClosedSpecial, HBox userRangedSpecial, HBox userSiegeSpecial) {
        userClosedSpecial.getChildren().clear();
        if (player.getClosedCombatSpecial() != null)
            userClosedSpecial.getChildren().add(player.getClosedCombatSpecial());
        userRangedSpecial.getChildren().clear();
        if (player.getRangedCombatSpecial() != null)
            userRangedSpecial.getChildren().add(player.getRangedCombatSpecial());
        userSiegeSpecial.getChildren().clear();
        if (player.getSiegeCombatSpecial() != null)
            userSiegeSpecial.getChildren().add(player.getSiegeCombatSpecial());
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
        loadHand();
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
            System.out.println(userClosedHBox.getChildren().size());
            System.out.println("loaded card" + (Card) card.getUserData());
        }

        userRangedHBox.getChildren().clear();
        for (AnchorPane card : currentPlayerRangedCombatUnits) {
            userRangedHBox.getChildren().add(card);
            System.out.println("loaded card" + (Card) card.getUserData());
        }

        userSiegeHBox.getChildren().clear();
        for (AnchorPane card : currentPlayerSiegeCombatUnits) {
            userSiegeHBox.getChildren().add(card);

            System.out.println("loaded card" + (Card) card.getUserData());
        }
        loadDrops();
    }

    private void loadDrops() {
        ArrayList<HBox> rows = new ArrayList<>();
        rows.add(userClosedHBox);
        rows.add(userRangedHBox);
        rows.add(userSiegeHBox);
        dropOnRow(rows);

        ArrayList<HBox> specials = new ArrayList<>();
        specials.add(userClosedSpecial);
        specials.add(userRangedSpecial);
        specials.add(userSiegeSpecial);
        dropOnSpecial(specials);
    }

    private void loadHand() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();

        ArrayList<AnchorPane> currentPlayerHand = currentPlayer.getHand();

        handHBox.getChildren().clear();

        for (AnchorPane card : currentPlayerHand) {
            handHBox.getChildren().add(card);
        }
    }

    private void createStartingHandPanes() {
        Player player1 = ApplicationController.game.getPlayer1();
        Player player2 = ApplicationController.game.getPlayer2();

        createStartingHand();
    }

    private void setDeckSizeLabel() {
        Player userPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        int userDeckSize = userPlayer.getDeck().size();
        int enemyDeckSize = enemyPlayer.getDeck().size();

        ((Label) (userDeck.getChildren().get(2))).setText(Integer.toString(userDeckSize));
        ((Label) (enemyDeck.getChildren().get(2))).setText(Integer.toString(enemyDeckSize));
    }


    public AnchorPane createCard(Card card) {
        AnchorPane cardAnchorPane = new AnchorPane();
        cardAnchorPane.setId(card.getCardEnum().name());
        cardAnchorPane.setUserData(card);

        setCardSize(cardAnchorPane, 79, 55);

        ImageView cardImageView = getCardImageView(card, cardAnchorPane.getPrefHeight(), cardAnchorPane.getPrefWidth());


        cardImageView.setOnMouseEntered(event -> {
            showDetailedCard(cardAnchorPane);
        });
        cardImageView.setOnMouseExited(event -> {
            hideDetailedCard();
        });
        cardImageView.setOnDragDetected(event -> {
            dragCard(cardImageView, event, cardAnchorPane);
        });
        cardImageView.setOnDragOver(
                event -> {
                    event.acceptTransferModes(TransferMode.MOVE);
                    event.consume();
                }
        );
        cardImageView.setOnDragDropped(
                event -> {
                    Card toBeDroppedCard = (Card) cardPaneToBeDragged.getUserData();
                    if ((card.getAbility().equals(CardAbility.DECOY))) {
                        playedTurn(cardPaneToBeDragged,cardAnchorPane);
                        event.setDropCompleted(true);
                        event.consume();
                    }
                }
        );
        cardAnchorPane.getChildren().add(cardImageView);

        return cardAnchorPane;
    }

    private void dragCard(ImageView cardImageView, MouseEvent event, AnchorPane cardAnchorPane) {
        Dragboard db = cardAnchorPane.startDragAndDrop(TransferMode.MOVE);
        ClipboardContent content = new ClipboardContent();
        content.putImage(cardImageView.getImage());
        db.setContent(content);
        cardPaneToBeDragged = cardAnchorPane;
        event.consume();
    }

    private void dropOnRow(ArrayList<HBox> rows) {
        for (HBox row : rows) {
            row.setOnDragOver(event -> {
                if (event.getGestureSource() != row && !ApplicationController.game.getCurrentPlayer().isDoneTurn()) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                event.consume();
            });

            row.setOnDragDropped(event -> {
                Dragboard db = event.getDragboard();
                boolean success = false;
                moveToRow(row, cardPaneToBeDragged);
                success = true;
                event.setDropCompleted(success);
                event.consume();
            });
        }
    }

    private void playedTurn(AnchorPane card, AnchorPane target) {
        ApplicationController.game.setGameState(GameStates.IN_GAME);
        skipTurnButton.setVisible(false);
        confirmTurnButton.setVisible(true);
        ((Card) card.getUserData()).getAbility().doAbility(card, target);
        ApplicationController.game.getCurrentPlayer().setDoneTurn(true);
    }

    private void dropOnSpecial(ArrayList<HBox> specials) {
        for (HBox row : specials) {
            row.setOnDragOver(event -> {
                Card card = (Card) cardPaneToBeDragged.getUserData();
                if (event.getGestureSource() != row && (
                        (card.getAbility().equals(CardAbility.MARDOEME) || card.getAbility().equals(CardAbility.COMMANDERS_HORN)))) {
                    event.acceptTransferModes(TransferMode.MOVE);
                }
                event.consume();
            });

            row.setOnDragDropped(event -> {

                Dragboard db = event.getDragboard();
                boolean success = false;
                moveToSpecial(row, cardPaneToBeDragged);
                success = true;
                event.setDropCompleted(success);
                event.consume();
            });
        }
    }

    private void moveToSpecial(HBox row, AnchorPane cardPaneToBeDragged) {
        Card card = (Card) cardPaneToBeDragged.getUserData();
        if (row.getChildren().size() == 0) {
            if (row.getId().equals("userClosedSpecial")) {
                ApplicationController.game.getCurrentPlayer().setClosedCombatSpecial(cardPaneToBeDragged);
                ApplicationController.game.getCurrentPlayer().removeFromHand(cardPaneToBeDragged);
                card.setCardPosition(CardPositions.CLOSED_COMBAT_SPECIAL);
                playedTurn(cardPaneToBeDragged, null);
            } else if (row.getId().equals("userRangedSpecial")) {
                ApplicationController.game.getCurrentPlayer().setRangedCombatSpecial(cardPaneToBeDragged);
                ApplicationController.game.getCurrentPlayer().removeFromHand(cardPaneToBeDragged);
                card.setCardPosition(CardPositions.RANGED_COMBAT_SPECIAL);
                playedTurn(cardPaneToBeDragged, null);
            } else if (row.getId().equals("userSiegeSpecial")) {
                ApplicationController.game.getCurrentPlayer().setSiegeCombatSpecial(cardPaneToBeDragged);
                ApplicationController.game.getCurrentPlayer().removeFromHand(cardPaneToBeDragged);
                card.setCardPosition(CardPositions.SIEGE_COMBAT_SPECIAL);
                playedTurn(cardPaneToBeDragged, null);
            }
        }

        ((ImageView) (cardPaneToBeDragged.getChildren().get(0))).setOnDragOver(null);
        ((ImageView) (cardPaneToBeDragged.getChildren().get(0))).setOnDragDropped(null);
        loadTable();
    }


    private void moveToRow(HBox row, AnchorPane cardAnchorPane) {
        Card card = (Card) cardAnchorPane.getUserData();
        if (card.getCardPosition().equals(CardPositions.HAND)) {
            if (!card.getAbility().equals(CardAbility.SPY)) {
                if (row.getId().equals("userClosedHBox") &&
                        (card.getType().equals(CardType.CLOSED_COMBAT_UNIT) || card.getType().equals(CardType.AGILE_UNIT))) {
                    ApplicationController.game.getCurrentPlayer().addToClosedCombatUnits(cardAnchorPane);
                    ApplicationController.game.getCurrentPlayer().removeFromHand(cardAnchorPane);
                    playedTurn(cardAnchorPane, null);
                } else if (row.getId().equals("userRangedHBox") &&
                        (card.getType().equals(CardType.RANGED_UNIT) || card.getType().equals(CardType.AGILE_UNIT))) {
                    ApplicationController.game.getCurrentPlayer().addToRangedCombatUnits(cardAnchorPane);
                    ApplicationController.game.getCurrentPlayer().removeFromHand(cardAnchorPane);
                    playedTurn(cardAnchorPane, null);
                } else if (row.getId().equals("userSiegeHBox") &&
                        card.getType().equals(CardType.SIEGE_UNIT)) {
                    ApplicationController.game.getCurrentPlayer().addToSiegeCombatUnits(cardAnchorPane);
                    ApplicationController.game.getCurrentPlayer().removeFromHand(cardAnchorPane);
                    playedTurn(cardAnchorPane, null);
                }
            } else {
                if (row.getId().equals("enemyClosedHBox") &&
                        (card.getType().equals(CardType.CLOSED_COMBAT_UNIT) || card.getType().equals(CardType.AGILE_UNIT))) {
                    ApplicationController.game.getEnemyPlayer().addToClosedCombatUnits(cardAnchorPane);
                    ApplicationController.game.getEnemyPlayer().removeFromHand(cardAnchorPane);
                    playedTurn(cardAnchorPane, null);
                } else if (row.getId().equals("enemyRangedHBox") &&
                        (card.getType().equals(CardType.RANGED_UNIT) || card.getType().equals(CardType.AGILE_UNIT))) {
                    ApplicationController.game.getEnemyPlayer().addToRangedCombatUnits(cardAnchorPane);
                    ApplicationController.game.getEnemyPlayer().removeFromHand(cardAnchorPane);
                    playedTurn(cardAnchorPane, null);
                } else if (row.getId().equals("enemySiegeHBox") &&
                        card.getType().equals(CardType.SIEGE_UNIT)) {
                    ApplicationController.game.getEnemyPlayer().addToSiegeCombatUnits(cardAnchorPane);
                    ApplicationController.game.getEnemyPlayer().removeFromHand(cardAnchorPane);
                    playedTurn(cardAnchorPane, null);
                }
            }
        }

        loadTable();
    }

    private void showDetailedCommander(AnchorPane commanderAnchorPane) {
        CommandersEnum commander = (CommandersEnum) commanderAnchorPane.getUserData();
        detailCard.setImage(new Image(commander.getInGameImage()));
        detailLabel.setText(commander.getLeaderAbilityDescription());
        detailCard.setVisible(true);
        detailLabel.setVisible(true);
        detailRectangle.setVisible(true);
    }

    private void hideDetailedCommander() {
        detailCard.setVisible(false);
        detailLabel.setVisible(false);
        detailRectangle.setVisible(false);
    }

    private void showDetailedCard(AnchorPane cardAnchorPane) {
        Card card = (Card) cardAnchorPane.getUserData();
        detailCard.setImage(new Image(card.getPreGameImage()));
        detailLabel.setText(card.getAbility().getDescription());
        detailCard.setVisible(true);
        detailLabel.setVisible(true);
        detailRectangle.setVisible(true);
    }

    private void hideDetailedCard() {
        detailCard.setVisible(false);
        detailLabel.setVisible(false);
        detailRectangle.setVisible(false);
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

    public void createStartingHand() {
        Player currentPlayer = ApplicationController.game.getCurrentPlayer();
        ArrayList<Card> deck = currentPlayer.getDeck();
        ArrayList<AnchorPane> hand = new ArrayList<>();

        System.out.println(currentPlayer.getDeck());

        for (int i = 9; i >= 0; i--) {
            deck.get(i).setCardPosition(CardPositions.HAND);
            hand.add(createCard(deck.get(i)));
            deck.remove(i);
        }

        currentPlayer.setHand(hand);

        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();
        deck = enemyPlayer.getDeck();
        hand = new ArrayList<>();

        for (int i = 9; i >= 0; i--) {
            deck.get(i).setCardPosition(CardPositions.HAND);
            hand.add(createCard(deck.get(i)));
            deck.remove(i);
        }

        enemyPlayer.setHand(hand);
    }

    public void skipTurn(MouseEvent mouseEvent) {
        ApplicationController.game.getCurrentPlayer().setPassedTurn(true);
        changeTurn();
    }

    public void confirmTurn(MouseEvent mouseEvent) {
        skipTurnButton.setVisible(true);
        confirmTurnButton.setVisible(false);
        changeTurn();
    }

    private void changeTurn() {
        if (ApplicationController.game.getEnemyPlayer().isPassedTurn()) {
            endRound();
        } else {
            changeActivePlayer();
        }
    }

    private void changeRound() {
        Game game = ApplicationController.game;
        if (game.getRound() == 1) {
            game.setRound(2);
            game.setGameState(GameStates.ROUND_2_STARTED);
        } else if (game.getRound() == 2 && game.getPlayer1().getLives() > 0 && game.getPlayer2().getLives() > 0) {
            game.setRound(3);
            game.setGameState(GameStates.ROUND_3_STARTED);
        } else {
            endGame();
            return;
        }
        game.getPlayer1().setDoneTurn(false);
        game.getPlayer2().setDoneTurn(false);
        game.getPlayer1().setPassedTurn(false);
        game.getPlayer2().setPassedTurn(false);
        clearBattlefield(game.getPlayer1());
        clearBattlefield(game.getPlayer2());
        doFactionAbility();
        addTransformers(game.getPlayer1());
        addTransformers(game.getPlayer2());
        loadTable();
    }

    private void clearBattlefield(Player player) {
        for (AnchorPane card : player.getClosedCombatUnits())
            player.addToDiscardPile(card);
        player.getClosedCombatUnits().clear();
        for (AnchorPane card : player.getRangedCombatUnits())
            player.addToDiscardPile(card);
        player.getRangedCombatUnits().clear();
        for (AnchorPane card : player.getSiegeCombatUnits())
            player.addToDiscardPile(card);
        player.getSiegeCombatUnits().clear();
        if (player.getClosedCombatSpecial() != null) {
            player.addToDiscardPile(player.getClosedCombatSpecial());
            player.setClosedCombatSpecial(null);
        }
        if (player.getRangedCombatSpecial() != null) {
            player.addToDiscardPile(player.getRangedCombatSpecial());
            player.setRangedCombatSpecial(null);
        }
        if (player.getSiegeCombatSpecial() != null) {
            player.addToDiscardPile(player.getSiegeCombatSpecial());
            player.setSiegeCombatSpecial(null);
        }
    }

    private void endRound() {
        Game game = ApplicationController.game;
        if (game.getRound() == 1) {
            game.setGameState(GameStates.ROUND_1_ENDED);
        } else if (game.getRound() == 2) {
            game.setGameState(GameStates.ROUND_2_ENDED);
        } else {
            game.setGameState(GameStates.ROUND_3_ENDED);
        }
        doFactionAbility();
        Player winner = null;
        if (game.getGameState().equals(GameStates.PLAYER_1_WON)) {
            winner = game.getPlayer1();
        } else if (game.getGameState().equals(GameStates.PLAYER_2_WON)) {
            winner = game.getPlayer2();
        } else {
            winner = getWinner();
        }

        System.out.println(winner.getNickname() + " " + winner.getTotalPower() + getLoser(winner).getNickname() + " " + getLoser(winner).getTotalPower());

        doEndRoundPlayerChanged(winner, game.getRound());
    }

    private void doEndRoundPlayerChanged(Player winner, int round) {
        Game game = ApplicationController.game;

        if (winner == null) {
            if (round == 1) {
                game.getPlayer1().setWonRound1(false);
                game.getPlayer2().setWonRound1(false);
            } else if (round == 2) {
                game.getPlayer1().setWonRound2(false);
                game.getPlayer2().setWonRound2(false);
            } else {
                game.getPlayer1().setWonRound3(false);
                game.getPlayer2().setWonRound3(false);
            }
            game.getPlayer1().setRoundsDrawn(game.getPlayer1().getRoundsDrawn() + 1);
            game.getPlayer2().setRoundsDrawn(game.getPlayer2().getRoundsDrawn() + 1);
            game.getPlayer1().setLives(game.getPlayer1().getLives() - 1);
            game.getPlayer2().setLives(game.getPlayer2().getLives() - 1);
            game.setGameState(GameStates.DRAW);
        } else {
            winner.setRoundsWon(winner.getRoundsWon() + 1);
            Player loser = getLoser(winner);
            loser.setLives(loser.getLives() - 1);
            loser.setRoundsLost(loser.getRoundsLost() + 1);
            setWonRounds(winner, loser);
        }

        changeRound();
    }

    private void setWonRounds(Player winner, Player loser) {
        int round = ApplicationController.game.getRound();
        if (round == 1) {
            winner.setWonRound1(true);
            loser.setWonRound1(false);
        } else if (round == 2) {
            winner.setWonRound2(true);
            loser.setWonRound2(false);
        } else {
            winner.setWonRound3(true);
            loser.setWonRound3(false);
        }
        winner.setTotalFinalPower(winner.getTotalFinalPower() + winner.getTotalPower());
        loser.setTotalFinalPower(loser.getTotalFinalPower() + loser.getTotalPower());

    }

    private Player getLoser(Player player) {
        if (player.equals(ApplicationController.game.getPlayer1())) {
            return ApplicationController.game.getPlayer2();
        }
        return ApplicationController.game.getPlayer1();
    }

    private Player getWinner() {
        Player player1 = ApplicationController.game.getPlayer1();
        Player player2 = ApplicationController.game.getPlayer2();
        if (player1.getTotalPower() > player2.getTotalPower()) {
            ApplicationController.game.setGameState(GameStates.PLAYER_1_WON);
            return player1;
        } else if (player1.getTotalPower() < player2.getTotalPower()) {
            ApplicationController.game.setGameState(GameStates.PLAYER_2_WON);
            return player2;
        }
        return null;
    }

    private void addTransformers(Player player) {
        for (AnchorPane card : player.getDiscardPile()) {
            Card cardObject = ((Card) card.getUserData());
            if (cardObject.getAbility().equals(CardAbility.TRANSFORMERMS)) {
                CardAbility.TRANSFORMERMS.doAbility(card, null);
            }
        }
    }


    private void endGame() {
        Player player = getTotalWinner();
        saveUserInfo(ApplicationController.game.getPlayer1(), ApplicationController.game.getPlayer2(), player);
        ApplicationController.game = null;
        goToMainMenu();
    }

    private void goToMainMenu() {
        try {
            new MainMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void saveUserInfo(Player userPlayer, Player enemyPlayer, Player winner) {
        HashMap<String, String> gameHistory = new HashMap<>();
        User user = userPlayer.getUser();

        gameHistory.put("enemy", enemyPlayer.getNickname());
        gameHistory.put("date", LocalDateTime.now().toString());
        gameHistory.put("roundScores",
                "user: " + userPlayer.getRound1power() + " " + userPlayer.getRound2power() + " " + userPlayer.getRound3power() +
                        " enemy: " + enemyPlayer.getRound1power() + " " + enemyPlayer.getRound2power() + " " + enemyPlayer.getRound3power());
        gameHistory.put("totalScores", "user: " + userPlayer.getTotalFinalPower() + " enemy: " + enemyPlayer.getTotalFinalPower());
        if (winner == null) {
            gameHistory.put("winner", "DRAW");
            user.setDraw(user.getDraw() + 1);
        } else if (winner.equals(userPlayer)) {
            gameHistory.put("winner", userPlayer.getNickname());
            user.setWins(user.getWins() + 1);
        } else {
            gameHistory.put("winner", enemyPlayer.getNickname());
            user.setLose(user.getLose() + 1);
        }
        if (userPlayer.getTotalFinalPower() > user.getHighestScore()) {
            user.setHighestScore(userPlayer.getTotalFinalPower());
        }

        user.setGamesPlayed(user.getGamesPlayed() + 1);


        user.addToGameHistories(gameHistory);
    }

    private Player getTotalWinner() {
        Player player1 = ApplicationController.game.getPlayer1();
        Player player2 = ApplicationController.game.getPlayer2();
        if (player1.getRoundsWon() > player2.getRoundsWon()) {
            return player1;
        } else if (player1.getRoundsWon() < player2.getRoundsWon()) {
            return player2;
        } else {
            if (player1.getTotalFinalPower() > player2.getTotalFinalPower()) {
                return player1;
            } else if (player1.getTotalFinalPower() < player2.getTotalFinalPower()) {
                return player2;
            } else {
                if (player1.getTotalPower() > player2.getTotalPower()) {
                    return player1;
                } else if (player1.getTotalPower() < player2.getTotalPower()) {
                    return player2;
                }
            }
        }
        return null;

    }

    private void doFactionAbility() {
        if (ApplicationController.game.getPlayer1().getCurrentFaction().equals(FactionsEnum.NILFGAARD)) {
            ApplicationController.game.getPlayer2().getCurrentFaction().doAbility(ApplicationController.game.getPlayer2());
            ApplicationController.game.getPlayer1().getCurrentFaction().doAbility(ApplicationController.game.getPlayer1());

        } else {
            ApplicationController.game.getPlayer1().getCurrentFaction().doAbility(ApplicationController.game.getPlayer1());
            ApplicationController.game.getPlayer1().getCurrentFaction().doAbility(ApplicationController.game.getPlayer2());

        }
    }


}
