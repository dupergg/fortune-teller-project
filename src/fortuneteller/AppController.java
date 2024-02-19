package fortuneteller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class AppController {

    @FXML
    private Button exitButton;

    @FXML
    private Button infoButton;

    @FXML
    private Button fortunesButton;

    @FXML
    void fortunesButtonPressed(ActionEvent event) {

    }

    @FXML
    void infoButtonPressed(ActionEvent event) {

    }

    @FXML
    void exitButtonPressed(ActionEvent event) {
        Platform.exit();
    }
}
