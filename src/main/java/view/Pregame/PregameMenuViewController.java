package view.Pregame;

import controller.ApplicationController;
import controller.PreGameController;
import enums.Card.Factions;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Card;
import model.PreGame;

import java.util.ArrayList;

public class PregameMenuViewController {
    public VBox preGameVBox;
    public VBox deckVBox;
    PreGameController controller = new PreGameController();


    public void initialize() {
        PreGame preGame = new PreGame();
        ApplicationController.preGame = preGame;
        loadPregameCards(Factions.SKELLIGE);
    }

    public void loadPregameCards(Factions faction) {
        ArrayList<Card> cards = controller.loadPregameCards(faction);
        PreGame preGame = ApplicationController.preGame;
        HBox cardHBox = new HBox();
        for (Card card : cards) {
            if (preGame.getPreGameHBoxList().isEmpty() ||
                    cardHBox.getChildren().size() >= 3) {
                cardHBox = createCardHBox();
                preGame.getPreGameHBoxList().add(cardHBox);
                preGameVBox.getChildren().add(cardHBox);
            } else {
                cardHBox = preGame.getPreGameHBoxList().get(preGame.getPreGameHBoxList().size() - 1);
            }
            AnchorPane preGameCardPane = getPreGameCard(card.getName());
            if (preGameCardPane == null) {
                preGameCardPane = createCard(card, false);
                cardHBox.getChildren().add(preGameCardPane);
            } else {
                increaseCountText(preGameCardPane);
            }
        }

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
        cardAnchorPane.setId(card.getName());

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
            });
        else {
            cardAnchorPane.setOnMouseClicked(event -> {
                controller.moveCardToPreGame(card);
                moveCardToPreGame(cardAnchorPane, card);
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

    private void removeFromPreGame(AnchorPane cardAnchorPane) {
        PreGame preGame = ApplicationController.preGame;
        for (HBox hbox : preGame.getPreGameHBoxList()) {
            for (Node node : hbox.getChildren()) {
                if (node.getId().equals(cardAnchorPane.getId())) {
                    if (((Text) cardAnchorPane.getChildren().get(2)).getText().equals("1")) {
                        hbox.getChildren().remove(node);
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
        Image countImage = new Image(card.getPreGameImage());
        countImageView.setImage(countImage);

        return countImageView;
    }

    private Text getCountText1(Card card) {
        Text countText = new Text();
        countText.setLayoutX(124);
        countText.setLayoutY(200);
        countText.setText("1");

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


}
