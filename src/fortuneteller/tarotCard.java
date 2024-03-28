package fortuneteller;

import javafx.scene.image.Image;

public class tarotCard {
    String cardName;
    Image cardImage;
    String cardMeaning;

    //Constructor
    public tarotCard(String name, String URL, String meaning) {
        cardName = name;
        cardImage = new Image(URL);
        cardMeaning = meaning;
    }

    //returns the name of the card
    public String getName() {
        return cardName;
    }

    //Returns the image for the card
    public Image getImage() {
        return cardImage;
    }

    //returns the meaning of the card
    public String getMeaning() {
        return cardMeaning;
    }

    // Stuff that is currently not being used
    // mainly related to adding a functionality for including reversed cards
    /*
    import java.util.Random;

    Image uprightImage;
    Image reversedImage;
    String uprightMeaning;
    String reversedMeaning;
    String currentPosition; //is the card upright or reversed?
    String cardImageURL;

    public void randomizePosition() {
        Random rand = new Random();
        int num = rand.nextInt(2);
        if (num == 0) {
            cardImage = uprightImage;
            cardMeaning = uprightMeaning;
        } else {
            cardImage = reversedImage;
            cardMeaning = reversedMeaning;
        }
    }
    */
}