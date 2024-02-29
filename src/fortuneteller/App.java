package fortuneteller;

import java.net.URL;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("fortuneApp.fxml"));

        Scene scene = new Scene(root);

        // sets the css sheet to the scene
        URL css = this.getClass().getResource("/css/appStyle.css");
        if (css != null) {
            String appCSS = css.toExternalForm();
            scene.getStylesheets().add(appCSS);

        } else {
            System.out.println("Error: appStyle.css not found");
        }

        primaryStage.setTitle("Fortune Teller");
        primaryStage.getIcons().add(new Image("images/icon.png"));
        primaryStage.setScene(scene);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    public static void main(String[] args) {
        launch(args);
    }
}