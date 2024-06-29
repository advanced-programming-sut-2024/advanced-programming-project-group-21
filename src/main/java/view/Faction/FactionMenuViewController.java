package view.Faction;

import controller.ApplicationController;
import controller.FactionController;
import enums.Card.FactionsEnum;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import model.PreGame;
import view.Pregame.PregameMenuView;

public class FactionMenuViewController {
    public AnchorPane factionCard;
    public Label titleLabel;
    public Label descriptionLabel;
    public VBox infoVBox;
    FactionController controller = new FactionController();

    public void factionEntered(MouseEvent mouseEvent) {
        AnchorPane factionPane = (AnchorPane) mouseEvent.getTarget();
        FactionsEnum faction = controller.getFaction(factionPane.getId());
        showFactionInfo(faction);
    }


    public void factionClicked(MouseEvent mouseEvent) {
        Node node = (Node) mouseEvent.getTarget();
        Node parent = node.getParent();
        AnchorPane factionPane = (AnchorPane) parent;
        FactionsEnum faction = controller.getFaction(factionPane.getId());
        ApplicationController.preGame.setFaction(faction);
        goToPreGame();

    }

    private void showFactionInfo(FactionsEnum faction) {
        ((ImageView)(factionCard.getChildren().get(0))).setImage(new Image(faction.getImage()));
        titleLabel.setText(faction.getName());
        descriptionLabel.setText(faction.getDescription());
        infoVBox.setVisible(true);
    }

    public void factionExited(MouseEvent mouseEvent) {
        infoVBox.setVisible(false);
    }

    private void goToPreGame() {
        try {
            new PregameMenuView().start(ApplicationController.getStage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
