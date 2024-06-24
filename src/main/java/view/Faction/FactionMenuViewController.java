package view.Faction;

import controller.FactionController;
import enums.Card.FactionsEnum;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

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
        AnchorPane factionPane = (AnchorPane) mouseEvent.getTarget();
    }

    private void showFactionInfo(FactionsEnum faction) {

        infoVBox.setVisible(true);
    }

    public void factionExited(MouseEvent mouseEvent) {
        infoVBox.setVisible(false);
    }
}
