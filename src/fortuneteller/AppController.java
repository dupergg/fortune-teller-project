package fortuneteller;

import java.io.IOException;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
    void infoButtonPressed(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        root = FXMLLoader.load(getClass().getResource("info.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void exitButtonPressed(ActionEvent event) {
        Platform.exit();
    }
}
