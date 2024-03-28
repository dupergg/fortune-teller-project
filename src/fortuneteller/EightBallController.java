package fortuneteller;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;

public class EightBallController {

    @FXML
    private TextArea inputTextArea;

    @FXML
    private Text outputText;

    @FXML
    private Button submitButton;

    String userInput = "";

    public int eightBall() {
        int number = 0;

        Random rand = new Random();
        number = rand.nextInt(20) + 1;

        return number;
    }

    // Ask the eight ball a yes or no question
    // take the user's input, just delete it when the button is pressed
        // maybe save it to a log with the user's prompt(s) and the ball's answer
    // switch case for each of the numbers
    // display the ball's answer in a textArea
    // button to submit the question

    @FXML
    void submitButtonPressed(ActionEvent event) {
        // unused, here in case we want to print a log of user inputs and outputs
        userInput = inputTextArea.getText();

        switch (eightBall()) {
            case 1:

        }
    }



}
