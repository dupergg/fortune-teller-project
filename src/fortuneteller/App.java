package fortuneteller;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fortuneApp.fxml"));
        Scene scene = new Scene(root);
        
        // sets the css sheet to the scene
        // URL css = this.getClass().getResource("/css/fortuneApp.css");
        // if (css != null) {
        //     String fortuneAppCSS = css.toExternalForm();
        //     scene.getStylesheets().add(fortuneAppCSS);

        // } else {
        //     System.out.println("Error: fortuneApp.css not found");
        // }

        primaryStage.setTitle("Fortune Teller");
        primaryStage.getIcons().add(new Image("images/icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
        music();
        
    }

    MediaPlayer mediaPlayer;
    public void music() {
        try {
            URL musicResource = getClass().getResource("/fortuneteller/mystery.mp3");
            if (musicResource != null) {
                Media h = new Media(musicResource.toString());
                mediaPlayer = new MediaPlayer(h);
                mediaPlayer.play();
            } else {
                showAlert("Error: Music file not found.");
            }
            
        } catch (Exception e) {
            showAlert("Error: Failed to play music.");
            e.printStackTrace();
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}