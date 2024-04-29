package fortuneteller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class TarotCardController {
    
    @FXML
    private CheckBox checkbox;

    @FXML
    private Button backButton;

    @FXML
    private Button giveReadingButton;

    @FXML
    private ImageView tarotCard1;

    @FXML
    private ImageView tarotCard2;

    @FXML 
    private ImageView tarotCard3;

    @FXML
    private Text cardName1;

    @FXML
    private Text cardName2;

    @FXML
    private Text cardName3;

    @FXML
    private Text cardMeaning1;

    @FXML
    private Text cardMeaning2;

    @FXML
    private Text cardMeaning3;

    List<tarotCard> cards = new ArrayList<tarotCard>();

    //When the class loads, load all of values from a file into the "cards" list
    public TarotCardController() throws FileNotFoundException {
        try {
            File file = new File("src\\fortuneteller\\tarotCards.txt");
            
            Scanner scan = new Scanner(file);
            
            while (scan.hasNextLine()) {
                String input = scan.nextLine();
                if (Character.compare(input.charAt(0), '/') == 0) {
                    continue;
                }
                String[] info = input.split(" ~ ");
                tarotCard card = new tarotCard(info[0], info[1], info[2], info[3]);
                cards.add(card);
            }
            scan.close();
        } catch(Exception e) {
            System.out.println("Error trying to load file");
            System.out.println(e);
            System.exit(0);
        }
    }

    //Sets the relevent FXML stuff to info from three random cards from the "cards" list
    public void tarotReading() {
        Collections.shuffle(cards);
        setCard(tarotCard1, cardName1, cardMeaning1, cards.get(0));
        setCard(tarotCard2, cardName2, cardMeaning2, cards.get(1));
        setCard(tarotCard3, cardName3, cardMeaning3, cards.get(2));
    }

    //Sets the given ImageView & Text of the values in the given tarotCard
    public void setCard(ImageView image, Text name, Text meaning, tarotCard card) {
        Random r = new Random();
        int reverse = r.nextInt(2);

        if (checkbox.isSelected() && reverse == 0) {
            if (image.getRotate() == 0) {
                image.setRotate(180);
            }
            image.setImage(card.getImage());
            name.setText(card.getName());
            meaning.setText(card.getReversedMeaning());
        } else {
            if (image.getRotate() == 180) {
                image.setRotate(0);
            }
            image.setImage(card.getImage());
            name.setText(card.getName());
            meaning.setText(card.getMeaning());
        }
    }

    //Opens the Fortunes screen
    @FXML
    void backButtonPressed(ActionEvent event) throws IOException {
        Stage stage;
        Scene scene;
        Parent root;

        root = FXMLLoader.load(getClass().getResource("fortunes.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);

        // sets the css sheet to the scene
        URL fortuneCSS = this.getClass().getResource("/css/fortunes.css");
        if (fortuneCSS != null) {
            String fortCSS = fortuneCSS.toExternalForm();
            scene.getStylesheets().add(fortCSS);

        } else {
            System.out.println("Error: fortunes.css not found");
        }

        stage.setScene(scene);
        stage.show();
    }

}