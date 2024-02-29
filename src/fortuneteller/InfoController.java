package fortuneteller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class InfoController implements Initializable {

    @FXML
    private Button backButton;

    @FXML
    private TextArea infoTextArea;

    @FXML
    void backButtonPressed(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        root = FXMLLoader.load(getClass().getResource("fortuneApp.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        // sets the css sheet to the scene
        URL css = this.getClass().getResource("/css/appStyle.css");
        if (css != null) {
            String appCSS = css.toExternalForm();
            scene.getStylesheets().add(appCSS);

        } else {
            System.out.println("Error: appStyle.css not found");
        }

        URL defaultCSS = this.getClass().getResource("/css/defaults.css");
        if (defaultCSS != null) {
            String defCSS = defaultCSS.toExternalForm();
            scene.getStylesheets().add(defCSS);

        } else {
            System.out.println("Error: defaults.css not found");
        }

        stage.setScene(scene);
        stage.show();
    }

    // helper method to read text from file and display in TextArea
    // if you need to change the text for the TextArea, change it in the 
    // "infoText.txt" file in the src directory
    private void setInfoText() throws FileNotFoundException, URISyntaxException {
        URL fileURL = this.getClass().getResource("infoText.txt");
        File file = new File(fileURL.toURI());
        Scanner sc = new Scanner(file);

        sc.useDelimiter("\\Z");

        infoTextArea.setText(sc.next());
        sc.close();
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        // read in text from the text file and error handling
        try {
            setInfoText();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("FILE NOT FOUND");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.err.println("INCORRECT URI SYNTAX");
        }
    }
}