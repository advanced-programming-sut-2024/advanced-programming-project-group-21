package view.Pregame;

import controller.ApplicationController;
import controller.PreGameController;
import enums.Card.CardEnum;
import enums.Card.CardType;
import enums.Card.CommandersEnum;
import enums.Card.FactionsEnum;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Card;
import model.Player;
import model.PreGame;
import view.Commander.CommanderMenuView;
import view.Faction.FactionMenu;
import view.Faction.FactionMenuView;
import view.Game.GameMenuView;

import java.util.ArrayList;

public class PregameMenuViewController {
    public VBox preGameVBox;
    public VBox deckVBox;
    public AnchorPane commanderCard;
    public ImageView commanderImage;
    public Label totalDeck;
    public Label totalUnit;
    public Label totalSpecial;
    public Label totalStrength;
    public Label totalHero;
    public ImageView shieldImage;
    public Label factionLabel;
    public Label factionAbility;
    public Label outOf22;
    public Label outOf10;
    public Button nextButton;
    PreGameController controller = new PreGameController();


    public void initialize() {
        PreGame preGame = ApplicationController.preGame;
        if (preGame == null) {
            preGame = new PreGame();
            ApplicationController.preGame = preGame;
            preGame.setFaction(FactionsEnum.SKELLIGE);
            setDefaultCommander();
            controller.createPlayers();
        }
        if (!preGame.isFirstPlayer()) {
            nextButton.setText("Start game");
        }
        clearCardsForNewFactionLoaded(preGame.getFaction());
        loadPregameCards(preGame.getFaction());
        loadDeckCards(preGame.getFaction());
        loadCommander(preGame.getCommander());
        loadStats();
    }

    private void loadStats() {
        PreGame preGame = ApplicationController.preGame;
        factionAbility.setText(preGame.getFaction().getDescription());
        factionLabel.setText(preGame.getFaction().getName());
        shieldImage.setImage(new Image(preGame.getFaction().getShield()));
        totalDeck.setText(Integer.toString(preGame.getDeckCards().size()));
        totalHero.setText("0");
        totalSpecial.setText("0");
        totalUnit.setText("0");
        totalStrength.setText("0");
        for (Card card : preGame.getDeckCards()) {
            loadStat(card);
        }
    }

    private void loadStat(Card card) {
        PreGame preGame = ApplicationController.preGame;
        if (card.isHero()) {
            totalHero.setText(Integer.toString(Integer.parseInt(totalHero.getText()) + 1));
        }
        if (card.getType().equals(CardType.SPELL) || card.getType().equals(CardType.WEATHER)) {
            totalSpecial.setText(Integer.toString(Integer.parseInt(totalSpecial.getText()) + 1));
            if (Integer.parseInt(totalSpecial.getText()) > 10) {
                // TODO: set outOf10 and totalSpecial color to red
                preGame.setValidSpecials(false);
            } else {
                // TODO: set outOf10 and totalSpecial color to default
                preGame.setValidSpecials(true);
            }
        } else {
            totalUnit.setText(Integer.toString(Integer.parseInt(totalUnit.getText()) + 1));
            totalStrength.setText(Integer.toString(Integer.parseInt(totalStrength.getText()) + card.getPower()));
            if (Integer.parseInt(totalUnit.getText()) >= 22) {
                preGame.setEnoughUnits(true);
                outOf22.setVisible(false);
            } else {
                preGame.setEnoughUnits(false);
                outOf22.setVisible(true);
            }
        }
    }

    private void loadCommander(CommandersEnum commander) {
        if (commander == null || !commander.getFaction().equals(ApplicationController.preGame.getFaction())) {
            for (CommandersEnum commandersEnum : CommandersEnum.values()) {
                if (commandersEnum.getFaction().equals(ApplicationController.preGame.getFaction())) {
                    commander = commandersEnum;
                    ApplicationController.preGame.setCommander(commander);
                    break;
                }
            }
        }
        commanderImage.setImage(new Image(commander.getPreGameImage()));
    }

    public void loadPregameCards(FactionsEnum faction) {
        controller.loadPregameCards(faction);
        PreGame preGame = ApplicationController.preGame;
        ArrayList<Card> preGameCards = preGame.getPreGameCards();
        System.out.println(preGameCards.size());
        HBox cardHBox = new HBox();
        for (Card card : preGameCards) {
            if (preGame.getPreGameHBoxList().isEmpty() ||
                    cardHBox.getChildren().size() >= 3) { // TODO: this line creates an extra hbox when last card is > 1
                cardHBox = createCardHBox();
                preGame.getPreGameHBoxList().add(cardHBox);
                preGameVBox.getChildren().add(cardHBox);
            } else {
                cardHBox = preGame.getPreGameHBoxList().get(preGame.getPreGameHBoxList().size() - 1);
            }
            AnchorPane preGameCardPane = getPreGameCard(card.getCardEnum().name());
            if (preGameCardPane == null) {
                preGameCardPane = createCard(card, false);
                cardHBox.getChildren().add(preGameCardPane);
            } else {
                increaseCountText(preGameCardPane);
            }
            System.out.println(preGame.getPreGameHBoxList().size() + " " + cardHBox.getChildren().size() + " " + card.getCardEnum().name());
        }
    }

    private void loadDeckCards(FactionsEnum faction) {
        PreGame preGame = ApplicationController.preGame;
        ArrayList<Card> deckCards = preGame.getDeckCards();
        HBox cardHBox = new HBox();
        for (Card card : deckCards) {
            if (preGame.getDeckHBoxList().isEmpty() ||
                    cardHBox.getChildren().size() >= 3) {
                cardHBox = createCardHBox();
                preGame.getDeckHBoxList().add(cardHBox);
                deckVBox.getChildren().add(cardHBox);
            } else {
                cardHBox = preGame.getDeckHBoxList().get(preGame.getDeckHBoxList().size() - 1);
            }
            AnchorPane deckCardPane = getDeckCard(card.getCardEnum().name());
            if (deckCardPane == null) {
                deckCardPane = createCard(card, true);
                cardHBox.getChildren().add(deckCardPane);
            } else {
                increaseCountText(deckCardPane);
            }
            System.out.println(preGame.getDeckHBoxList().size() + " " + cardHBox.getChildren().size() + " " + card.getCardEnum().name());
        }
    }

    private void clearCardsForNewFactionLoaded(FactionsEnum faction) {
        PreGame preGame = ApplicationController.preGame;
        preGame.setPreGameHBoxList(new ArrayList<>());
        preGame.setDeckHBoxList(new ArrayList<>());
    }


    private AnchorPane getPreGameCard(String name) {
        PreGame preGame = ApplicationController.preGame;
        for (HBox hbox : preGame.getPreGameHBoxList()) {
            for (Node node : hbox.getChildren()) {
                if (node.getId().equals(name)) {
                    return (AnchorPane) node;
                }
            }
        }
        return null;
    }

    private AnchorPane getDeckCard(String name) {
        PreGame preGame = ApplicationController.preGame;
        for (HBox hbox : preGame.getDeckHBoxList()) {
            for (Node node : hbox.getChildren()) {
                if (node.getId().equals(name)) {
                    return (AnchorPane) node;
                }
            }
        }
        return null;
    }

    private HBox createCardHBox() {
        HBox cardHBox = new HBox();
        cardHBox.setPrefHeight(260);
        cardHBox.setMinHeight(260);
        cardHBox.setMaxHeight(260);
        cardHBox.setPrefWidth(525);
        cardHBox.setMinWidth(525);
        cardHBox.setMaxWidth(525);

        cardHBox.setAlignment(Pos.CENTER_LEFT);
        cardHBox.setSpacing(40);
        return cardHBox;
    }

    private AnchorPane createCard(Card card, boolean isForDeck) {
        AnchorPane cardAnchorPane = new AnchorPane();
        cardAnchorPane.setId(card.getCardEnum().name());

        cardAnchorPane.setPrefHeight(260);
        cardAnchorPane.setMinHeight(260);
        cardAnchorPane.setMaxHeight(260);
        cardAnchorPane.setPrefWidth(138);
        cardAnchorPane.setMinWidth(138);
        cardAnchorPane.setMaxWidth(138);

        ImageView cardImageView = getCardImageView(card);
        cardAnchorPane.getChildren().add(cardImageView);

        ImageView countImageView = getCountImageView(card);
        cardAnchorPane.getChildren().add(countImageView);

        Text countText = getCountText1(card);
        cardAnchorPane.getChildren().add(countText);

        if (!isForDeck)
            cardAnchorPane.setOnMouseClicked(event -> {
                controller.moveCardToDeck(card);
                moveCardToDeck(cardAnchorPane, card);
                loadStats();
            });
        else {
            cardAnchorPane.setOnMouseClicked(event -> {
                controller.moveCardToPreGame(card);
                moveCardToPreGame(cardAnchorPane, card);
                loadStats();
            });
        }
        return cardAnchorPane;
    }

    private void moveCardToDeck(AnchorPane cardAnchorPane, Card card) {
        PreGame preGame = ApplicationController.preGame;
        HBox cardHBox = new HBox();
        if (preGame.getDeckHBoxList().size() > 0) {
            cardHBox = preGame.getDeckHBoxList().get(preGame.getDeckHBoxList().size() - 1);
        }
        AnchorPane deckCardPane = getDeckCard(cardAnchorPane.getId());
        if (preGame.getDeckHBoxList().isEmpty() ||
                (cardHBox.getChildren().size() >= 3 && deckCardPane == null)) {
            cardHBox = createCardHBox();
            preGame.getDeckHBoxList().add(cardHBox);
            deckVBox.getChildren().add(cardHBox);
            System.out.println("a");
        }
        removeFromPreGame(cardAnchorPane);
        if (deckCardPane == null) {
            deckCardPane = createCard(card, true);
            cardHBox.getChildren().add(deckCardPane);
        } else {
            increaseCountText(deckCardPane);
        }
        System.out.println("Deck size: " + preGame.getDeckCards().size());
        System.out.println("Pregame size: " + preGame.getPreGameCards().size());
    }

    private void moveCardToPreGame(AnchorPane cardAnchorPane, Card card) {
        PreGame preGame = ApplicationController.preGame;
        HBox cardHBox = new HBox();
        if (preGame.getPreGameHBoxList().size() > 0) {
            cardHBox = preGame.getPreGameHBoxList().get(preGame.getPreGameHBoxList().size() - 1);
        }
        AnchorPane preGameCardPane = getPreGameCard(cardAnchorPane.getId());
        if (preGame.getPreGameHBoxList().isEmpty() ||
                (cardHBox.getChildren().size() >= 3 && preGameCardPane == null)) {
            cardHBox = createCardHBox();
            preGame.getPreGameHBoxList().add(cardHBox);
            preGameVBox.getChildren().add(cardHBox);
        }
        removeFromDeck(cardAnchorPane);
        if (preGameCardPane == null) {
            preGameCardPane = createCard(card, false);
            cardHBox.getChildren().add(preGameCardPane);
        } else {
            increaseCountText(preGameCardPane);
        }
        System.out.println("Deck size: " + preGame.getDeckCards().size());
        System.out.println("Pregame size: " + preGame.getPreGameCards().size());

    }

    private void removeFromDeck(AnchorPane cardAnchorPane) {
        PreGame preGame = ApplicationController.preGame;
        for (HBox hbox : preGame.getDeckHBoxList()) {
            for (Node node : hbox.getChildren()) {
                if (node.getId().equals(cardAnchorPane.getId())) {
                    if (((Text) cardAnchorPane.getChildren().get(2)).getText().equals("1")) {
                        hbox.getChildren().remove(node);
                        if (preGame.getDeckHBoxList().indexOf(hbox) < preGame.getDeckHBoxList().size() - 1) {
                            resortDeckCards(preGame.getDeckHBoxList().indexOf(hbox));
                        }
                        if (hbox.getChildren().size() == 0) {
                            deckVBox.getChildren().remove(hbox);
                            preGame.getDeckHBoxList().remove(hbox);
                        }
                    } else {
                        decreaseCountText(cardAnchorPane);
                    }
                    return;
                }
            }
        }
    }

    private void resortDeckCards(int indexOf) {
        ArrayList<HBox> deckHBoxList = ApplicationController.preGame.getDeckHBoxList();
        for (int i = indexOf; i < deckHBoxList.size() - 1; i++) {
            Node node = deckHBoxList.get(i + 1).getChildren().get(0);
            deckHBoxList.get(i + 1).getChildren().remove(0);
            deckHBoxList.get(i).getChildren().add(node);
            if (deckHBoxList.get(i + 1).getChildren().isEmpty()) {
                deckVBox.getChildren().remove(deckHBoxList.get(i + 1));
                deckHBoxList.remove(i + 1);
            }
        }
    }

    private void removeFromPreGame(AnchorPane cardAnchorPane) {
        PreGame preGame = ApplicationController.preGame;
        for (HBox hbox : preGame.getPreGameHBoxList()) {
            for (Node node : hbox.getChildren()) {
                if (node.getId().equals(cardAnchorPane.getId())) {
                    if (((Text) cardAnchorPane.getChildren().get(2)).getText().equals("1")) {
                        hbox.getChildren().remove(node);
                        if (preGame.getPreGameHBoxList().indexOf(hbox) < preGame.getPreGameHBoxList().size() - 1) {
                            resortPregameCards(preGame.getPreGameHBoxList().indexOf(hbox));
                        }
                        if (hbox.getChildren().size() == 0) {
                            preGameVBox.getChildren().remove(hbox);
                            preGame.getPreGameHBoxList().remove(hbox);
                        }
                    } else {
                        decreaseCountText(cardAnchorPane);
                    }
                    return;
                }
            }
        }
    }

    private void resortPregameCards(int indexOf) {
        ArrayList<HBox> preGameHBoxList = ApplicationController.preGame.getPreGameHBoxList();
        for (int i = indexOf; i < preGameHBoxList.size() - 1; i++) {
            Node node = preGameHBoxList.get(i + 1).getChildren().get(0);
            preGameHBoxList.get(i + 1).getChildren().remove(0);
            preGameHBoxList.get(i).getChildren().add(node);
            if (preGameHBoxList.get(i + 1).getChildren().isEmpty()) {
                preGameVBox.getChildren().remove(preGameHBoxList.get(i + 1));
                preGameHBoxList.remove(i + 1);
            }
        }
    }

    private ImageView getCardImageView(Card card) {
        ImageView cardImageView = new ImageView();
        cardImageView.setFitHeight(260);
        cardImageView.setFitWidth(138);
        cardImageView.setPickOnBounds(true);
        cardImageView.setPreserveRatio(true);
        Image cardImage = new Image(card.getPreGameImage());
        cardImageView.setImage(cardImage);

        return cardImageView;
    }

    private ImageView getCountImageView(Card card) {
        ImageView countImageView = new ImageView();
        countImageView.setFitHeight(20);
        countImageView.setFitWidth(20);
        countImageView.setLayoutX(100);
        countImageView.setLayoutY(200);
        countImageView.setPickOnBounds(true);
        countImageView.setPreserveRatio(true);
        Image countImage = new Image("file:src/main/resources/Images/Icons/icon_card_count.png");
        countImageView.setImage(countImage);

        return countImageView;
    }

    private Text getCountText1(Card card) {
        Text countText = new Text();
        countText.setLayoutX(118);
        countText.setLayoutY(215);
        countText.setText("1");
        // set font to 20 pixel
        countText.setStyle("-fx-font: 18 arial;");

        return countText;
    }

    private void increaseCountText(AnchorPane anchorPane) {
        Text text = (Text) anchorPane.getChildren().get(2);
        int value = Integer.parseInt(text.getText());
        text.setText(Integer.toString(value + 1));
    }

    private void decreaseCountText(AnchorPane anchorPane) {
        Text text = (Text) anchorPane.getChildren().get(2);
        int value = Integer.parseInt(text.getText());
        text.setText(Integer.toString(value - 1));
    }


    public void goToFaction(MouseEvent mouseEvent) {
        try {
            new FactionMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void goToCommander(MouseEvent mouseEvent) {
        try {
            new CommanderMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void nextPhase(MouseEvent mouseEvent) {
        PreGame preGame = ApplicationController.preGame;
        controller.saveToPlayer();
        if (preGame.isFirstPlayer()) {
            preGame.setFirstPlayer(false);
            preGame.setCurrentPlayer(preGame.getPlayer2());
            cleanPregame();
            try {
                new PregameMenuView().start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try{
                new GameMenuView().start(ApplicationController.getStage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    private void cleanPregame() {
        PreGame preGame = ApplicationController.preGame;
        preGame.setPreGameCards(new ArrayList<>());
        preGame.setDeckCards(new ArrayList<>());
        preGame.setPreGameHBoxList(new ArrayList<>());
        preGame.setDeckHBoxList(new ArrayList<>());
        preGame.setFaction(FactionsEnum.SKELLIGE);
        setDefaultCommander();
    }

    public void setDefaultCommander(){
        PreGame preGame = ApplicationController.preGame;
        FactionsEnum faction = preGame.getFaction();
        if(faction.equals(FactionsEnum.SKELLIGE)){
            preGame.setCommander(CommandersEnum.CRACHE_AN_CRAITE);
        }
//        else if(faction.equals(FactionsEnum.NILFGAARD)){
//            preGame.setCommander(CommandersEnum.EMHYR_VAR_EMREIS);
//        }
//        else if(faction.equals(FactionsEnum.NORTHERN_REALMS)){
//            preGame.setCommander(CommandersEnum.FOLTEST);
//        }
//        else if(faction.equals(FactionsEnum.MONSTERS)){
//            preGame.setCommander(CommandersEnum.EREDIN);
//        }
//        else if(faction.equals(FactionsEnum.SCOIATAEL)){
//            preGame.setCommander(CommandersEnum.FRANCESCA_FINDABAIR);
//        }
    }

    public void downloadDeck(MouseEvent mouseEvent) {
    }

    public void uploadDeck(MouseEvent mouseEvent) {
    }
}
