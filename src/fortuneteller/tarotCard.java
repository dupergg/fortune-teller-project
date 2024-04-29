package fortuneteller;

import javafx.scene.image.Image;

public class tarotCard {
    String cardName;
    Image cardImage;
    String cardMeaning;
    String cardReversedMeaning;

    //Constructor
    public tarotCard(String name, String imageURL, String meaning, String reverseMeaning) {
        cardName = name;
        cardImage = new Image(imageURL);
        cardMeaning = meaning;
        cardReversedMeaning = reverseMeaning;
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

    //returns the reversed meaning of the card
    public String getReversedMeaning() {
        return cardReversedMeaning;
    }

    public void print() {
        System.out.println(cardName);
        System.out.println("    Meaning: " + cardMeaning);
        System.out.println("    Reversed Meaning: " + cardReversedMeaning);
        System.out.println("    Image URL: " + cardImage.getUrl());
    }
}