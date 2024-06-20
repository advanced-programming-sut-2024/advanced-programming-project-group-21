package view.Pregame;

import controller.ApplicationController;
import controller.PreGameController;
import enums.Card.Factions;
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
    PreGameController controller = new PreGameController();


    public void initialize() {

    }

    public void loadPregameCards(Factions faction) {
        ArrayList<Card> cards = controller.loadPregameCards(faction);
        PreGame preGame = ApplicationController.preGame;
        for (Card card : cards) {
            HBox cardHBox = preGame.getPreGameHBoxList().get(preGame.getPreGameHBoxList().size() - 1);
            if (preGame.getPreGameHBoxList().isEmpty() ||
                    cardHBox.getChildren().size() >= 3) {
                cardHBox = createCardHBox();
                preGame.getPreGameHBoxList().add(cardHBox);
                preGameVBox.getChildren().add(cardHBox);
            }

        }

    }

    private HBox createCardHBox() {
        HBox cardHBox = new HBox();
        cardHBox.setPrefHeight(260);
        cardHBox.setMinHeight(260);
        cardHBox.setMaxHeight(260);
        cardHBox.setPrefWidth(525);
        cardHBox.setMinWidth(525);
        cardHBox.setMaxWidth(525);

        cardHBox.setAlignment(javafx.geometry.Pos.CENTER);
        cardHBox.setSpacing(40);
        return null;
    }

    private AnchorPane createCard(Card card) {
        AnchorPane cardAnchorPane = new AnchorPane();

        cardAnchorPane.setPrefHeight(260);
        cardAnchorPane.setMinHeight(260);
        cardAnchorPane.setMaxHeight(260);
        cardAnchorPane.setPrefWidth(138);
        cardAnchorPane.setMinWidth(138);
        cardAnchorPane.setMaxWidth(138);

        ImageView cardImageView = new ImageView();
        cardImageView.setFitHeight(260);
        cardImageView.setFitWidth(138);
        cardImageView.setPickOnBounds(true);
        cardImageView.setPreserveRatio(true);
        Image cardImage = new Image(card.getPreGameImage());
        cardImageView.setImage(cardImage);
        cardAnchorPane.getChildren().add(cardImageView);

        ImageView countImageView = new ImageView();
        countImageView.setFitHeight(20);
        countImageView.setFitWidth(20);
        countImageView.setLayoutX(100);
        countImageView.setLayoutY(200);
        countImageView.setPickOnBounds(true);
        countImageView.setPreserveRatio(true);
        Image countImage = new Image("");
        countImageView.setImage(countImage);
        cardAnchorPane.getChildren().add(countImageView);

        Text countText = new Text();
        countText.setLayoutX(124);
        countText.setLayoutY(200);
        // countText.setText(card.);
        return cardAnchorPane;
    }


}
