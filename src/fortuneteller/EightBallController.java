package fortuneteller;

import java.io.IOException;
import java.net.URL;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EightBallController {

    @FXML
    private TextArea inputTextArea;

    @FXML
    private Text outputText;

    @FXML
    private Button submitButton;

    @FXML
    private Button resetButton;

    String userInput = "";

    public int eightBallRandNum() {
        int number = 0;

        Random rand = new Random();
        number = rand.nextInt(20) + 1;

        // System.out.println(number); // debug purposes only

        return number;
    }

    // Ask the Orb a yes or no question
    // take the user's input, just delete it when the button is pressed
        // maybe save it to a log with the user's prompt(s) and the ball's answer
    // switch case for each of the numbers
    // display the ball's answer in a textArea
    // button to submit the question

    @FXML
    void submitButtonPressed(ActionEvent event) {
        // unused, here in case we want to print a log of user inputs and outputs
        userInput = inputTextArea.getText();
        int num = eightBallRandNum();

        // wait for three seconds, for effect
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (num) {
            case 1:
                outputText.setText("The magic Orb says: It is certain.");
                break;
            case 2:
                outputText.setText("The magic Orb says: It is decidedlly so.");
                break;
            case 3:
                outputText.setText("The magic Orb says: Without a doubt.");
                break;
            case 4:
                outputText.setText("The magic Orb says: Yes definitely.");
                break;
            case 5:
                outputText.setText("The magic Orb says: You may rely on it.");
                break;
            case 6:
                outputText.setText("The magic Orb says: As I see it, yes.");
                break;
            case 7:
                outputText.setText("The magic Orb says: Most likely.");
                break;
            case 8:
                outputText.setText("The magic Orb says: Outlook good.");
                break;
            case 9:
                outputText.setText("The magic Orb says: Yes.");
                break;
            case 10:
                outputText.setText("The magic Orb says: Signs point to yes.");
                break;
            case 11:
                outputText.setText("The magic Orb says: Reply hazy, try again.");
                break;
            case 12:
                outputText.setText("The magic Orb says: Ask again later.");
                break;
            case 13:
                outputText.setText("The magic Orb says: Better not tell you now.");
                break;
            case 14:
                outputText.setText("The magic Orb says: Cannot predict now.");
                break;
            case 15:
                outputText.setText("The magic Orb says: Concentrate and ask again.");
                break;
            case 16:
                outputText.setText("The magic Orb says: Don't count on it.");
                break;
            case 17:
                outputText.setText("The magic Orb says: My reply is no.");
                break;
            case 18:
                outputText.setText("The magic Orb says: My sources say no.");
                break;
            case 19:
                outputText.setText("The magic Orb says: Outlook not so good.");
                break;
            case 20:
                outputText.setText("The magic Orb says: Very doubtful.");
                break;
            default:
                outputText.setText("The magic Orb says: Error, try again.");
                break;
        }

        // set button to invisible so user doesn't press it again until
        // reset button is pressed
        submitButton.setVisible(false);
        resetButton.setVisible(true);
    }

    @FXML
    void resetButtonPressed(ActionEvent event) {
        // clear the text in the question box
        inputTextArea.setText("");

        // clear Orb text and set it back to default
        outputText.setText("The Orb says:");

        // make the buttons visible and invisible again
        submitButton.setVisible(true);
        resetButton.setVisible(false);
    }

    @FXML
    void backButtonPressed(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        root = FXMLLoader.load(getClass().getResource("fortunes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

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
}
