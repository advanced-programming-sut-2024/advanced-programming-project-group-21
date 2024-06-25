package view.Commander;

import controller.ApplicationController;
import controller.CommanderController;
import enums.Card.CommandersEnum;
import enums.Card.FactionsEnum;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.PreGame;
import view.Pregame.PregameMenuView;

public class CommanderMenuViewController {
    public HBox firstHBox;
    public HBox secondHBox;
    public AnchorPane commanderCard;
    public Label abilityLabel;
    public VBox infoVBox;
    CommanderController controller = new CommanderController();

    public void initialize() {
        loadCommanders(ApplicationController.preGame.getFaction());
    }

    private void loadCommanders(FactionsEnum faction) {
        for (CommandersEnum commander : CommandersEnum.values()) {
            if (commander.getFaction().equals(faction)) {
                HBox hbox = new HBox();

                if (firstHBox.getChildren().size() < 3)
                    hbox = firstHBox;
                else
                    hbox = secondHBox;
                AnchorPane commanderPane = createCommander(commander);
                hbox.getChildren().add(commanderPane);
            }
        }
    }

    private AnchorPane createCommander(CommandersEnum commander){
        AnchorPane commanderPane = new AnchorPane();
        commanderPane.setId(commander.getName());
        commanderPane.setOnMouseEntered(event -> commanderEntered(event));
        commanderPane.setOnMouseExited(event -> commanderExited(event));
        commanderPane.setOnMouseClicked(event -> commanderClicked(event));

        commanderPane.setPrefHeight(300);
        commanderPane.setMinHeight(300);
        commanderPane.setMaxHeight(300);
        commanderPane.setPrefWidth(159);
        commanderPane.setMinWidth(159);
        commanderPane.setMaxWidth(159);

        ImageView cardImageView = getCardImageView(commander);
        commanderPane.getChildren().add(cardImageView);

        return commanderPane;
    }

    private ImageView getCardImageView(CommandersEnum commander) {
        ImageView imageView = new ImageView();
        imageView.setFitHeight(300);
        imageView.setFitWidth(159);
        imageView.setImage(new Image(commander.getPreGameImage()));
        return imageView;
    }

    private void commanderClicked(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getTarget();
        Node parent = node.getParent();
        AnchorPane commanderPane = (AnchorPane) parent;
        CommandersEnum commander = controller.getCommander(commanderPane.getId());
        ApplicationController.preGame.setCommander(commander);
        goToPreGame();
    }

    private void goToPreGame() {
        try {
            new PregameMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void commanderExited(MouseEvent mouseEvent) {
        infoVBox.setVisible(false);
    }

    private void commanderEntered(MouseEvent mouseEvent) {
        AnchorPane commanderPane = (AnchorPane) mouseEvent.getTarget();
        CommandersEnum commander = controller.getCommander(commanderPane.getId());
        showCommanderInfo(commander);
    }

    private void showCommanderInfo(CommandersEnum commander) {
        abilityLabel.setText(commander.getLeaderAbilityDescription());
        ((ImageView)(commanderCard.getChildren().get(0))).setImage(new Image(commander.getPreGameImage()));
        infoVBox.setVisible(true);
    }
}
