package view.Game;

import controller.ApplicationController;
import controller.GameMenuController;
import enums.Card.FactionsEnum;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import model.Card;
import model.Game;
import model.Player;
import model.PreGame;

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
    GameMenuController controller = new GameMenuController();

    public void initialize() {
        Game game = ApplicationController.game;
        if (game == null) {
            ApplicationController.game = new Game(ApplicationController.preGame);
            ApplicationController.preGame = null;
            controller.shuffleDeckCards(ApplicationController.game.getPlayer1());
            controller.shuffleDeckCards(ApplicationController.game.getPlayer2());
            setDeckSizeLabel();
            createStartingHandPanes();
        }
    }

    private void createStartingHandPanes() {
        Player userPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        for (int i = 0; i < 10; i++) {
            Card userCard = userPlayer.getDeck().get(i);
            Card enemyCard = enemyPlayer.getDeck().get(i);

            AnchorPane userCardAnchorPane = createCard(userCard);
            AnchorPane enemyCardAnchorPane = createCard(enemyCard);

            ApplicationController.game.addToPlayer1Hand(userCardAnchorPane);
            ApplicationController.game.addToPlayer2Hand(enemyCardAnchorPane);
        }
    }

    private void setDeckSizeLabel() {
        Player userPlayer = ApplicationController.game.getCurrentPlayer();
        Player enemyPlayer = ApplicationController.game.getEnemyPlayer();

        int userDeckSize = userPlayer.getDeck().size();
        int enemyDeckSize = enemyPlayer.getDeck().size();

        ((Label)(userDeck.getChildren().get(2))).setText(Integer.toString(userDeckSize));
        ((Label)(enemyDeck.getChildren().get(2))).setText(Integer.toString(enemyDeckSize));
    }


    private AnchorPane createCard(Card card) {
        AnchorPane cardAnchorPane = new AnchorPane();
        cardAnchorPane.setId(card.getCardEnum().name());

        setCardSize(cardAnchorPane,90,63);

        ImageView cardImageView = getCardImageView(card, cardAnchorPane.getHeight(), cardAnchorPane.getWidth());
        cardAnchorPane.getChildren().add(cardImageView);

        return cardAnchorPane;
    }

    private ImageView getCardImageView(Card card,double height, double width) {
        ImageView cardImageView = new ImageView();
        cardImageView.setFitHeight(height);
        cardImageView.setFitWidth(width);
        cardImageView.setPickOnBounds(true);
        cardImageView.setPreserveRatio(true);
        Image cardImage = new Image(card.getInGameImage());
        cardImageView.setImage(cardImage);

        return cardImageView;
    }

    private void setCardSize(AnchorPane card, double height, double width){
        card.setPrefHeight(height);
        card.setMinHeight(height);
        card.setMaxHeight(height);
        card.setPrefWidth(width);
        card.setMinWidth(width);
        card.setMaxWidth(width);

    }
}
