package view.Pregame;

import controller.ApplicationController;
import controller.PreGameController;
import enums.Card.Factions;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Card;
import model.PreGame;

import java.util.ArrayList;

public class PregameMenuViewController {
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
            }

        }

    }

    private HBox createCardHBox() {
        HBox cardHBox = new HBox();
        return null;
    }


}
