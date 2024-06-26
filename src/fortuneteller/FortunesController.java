package fortuneteller;

import java.io.IOException;
// import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class FortunesController {

    // to add CSS to the project for prettiness, look at this link:
    // https://stackoverflow.com/questions/23975897/how-to-add-a-css-stylesheet-in-fxml

    @FXML
    private Button backButton;

    @FXML
    private Button fortuneTellerButton;

    @FXML
    private Button tarotCardButton;

    @FXML
    private Button eightBallButton;

    @FXML
    void fortuneTellerButtonPressed(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        root = FXMLLoader.load(getClass().getResource("fortuneTeller.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    //Opens the screen for tarot card readings
    @FXML
    void tarotCardButtonPressed(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        root = FXMLLoader.load(getClass().getResource("tarotCard.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    //Opens the screen for magic eight ball
    @FXML
    void eightBallButtonPressed(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        root = FXMLLoader.load(getClass().getResource("eightBall.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void backButtonPressed(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        root = FXMLLoader.load(getClass().getResource("fortuneApp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}