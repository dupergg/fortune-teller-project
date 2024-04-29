package fortuneteller;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;


// have to run chatty.py before you can recieve your fortunes
public class FortuneTellerController {

    @FXML
    private Button backButton;

    @FXML
    private Button submitButton;

    @FXML
    private TextArea outputTextArea;

    @FXML
    private TextArea inputTextArea;

    private String chatBotTest(String input) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create("http://localhost:5000/fortune"))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("{\"prompt\":\"" + input + "\"}"))
            .build();

        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            return response.body();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            return "Error: Unable to retrieve fortune... because you are stupid... make sure chatty.py is running";
        }
    }

    @FXML
    void submitButtonPressed(ActionEvent event) {
        String input = inputTextArea.getText();
        String output = chatBotTest(input);
        output = output.replace("\"", "").replace("{", "").replace("}", "");
        outputTextArea.setText(output);
    }

    
    @FXML
    void backButtonPressed(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        root = FXMLLoader.load(getClass().getResource("fortunes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        stage.setScene(scene);
        stage.show();
    }
}
