package fortuneteller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import jep.Interpreter;
import jep.SharedInterpreter;



public class FortuneTellerController {

    @FXML
    private Button backButton;

    @FXML
    private Button testButton;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private TextArea inputTextArea;

    String chatBotTest(String message) throws FileNotFoundException, URISyntaxException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream stdout = System.out;
        System.setOut(ps);

        try (Interpreter interp = new SharedInterpreter()) {
            interp.exec("from chatterbot import ChatBot"); 
            interp.exec("chatbot = ChatBot(\"Ron Obvious\")");

            interp.exec("from chatterbot.trainers import ListTrainer");

            interp.exec("conversation = [\"Hello\",\"Hi there!\",\"How are you doing?\",\"I'm doing great.\",\"That is good to hear\",\"Thank you.\",\"You're welcome.\"]");

            interp.exec("trainer = ListTrainer(chatbot)");

            interp.exec("trainer.train(conversation)");

            //Just testing some things, feel free to change this - Alanna
            interp.exec("conv2 = [\"Good Morning!\", \"Good Morning\"]");
            interp.exec("response1 = [\"How will my day go?\", \"You will have a great day today!\"]");
            interp.exec("response2 = [\"How will my day go?\", \"You may face challenges today.\"]");
            interp.exec("response3 = [\"How will my day go?\", \"You will have a relaxed day.\"]");
            interp.exec("trainer.train(conv2)");
            interp.exec("trainer.train(response1)");
            interp.exec("trainer.train(response2)");
            interp.exec("trainer.train(response3)");

            interp.exec("response = chatbot.get_response(" + "\"" + message + "\"" + ")"); // this amalgamation is how we can use Strings and put it into the chatterbot
            interp.exec("print(response)");

            String output = baos.toString();
    
            // reset back to standard out
            System.out.flush();
            System.setOut(stdout);
            
            return output;
        }
        
    }

    // currently does not work the way I want it to - Bryce
    @FXML
    void testButtonPressed(ActionEvent event) {
        String input = inputTextArea.getText();
        inputTextArea.clear();
        try {
            String output = chatBotTest(input);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.err.println("FILE NOT FOUND");
        } catch (URISyntaxException e) {
            e.printStackTrace();
            System.err.println("INCORRECT URI SYNTAX");
        }
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
