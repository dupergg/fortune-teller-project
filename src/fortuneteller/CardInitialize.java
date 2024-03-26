import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.scene.control.ListView;

public class CardInitialize {
    private final ObservableList<Card> cards = FXCollections.observableArrayList();

    private ListView<Card> cardListView;

    // There has got to be an easier way of doing this... ...found it (hopefully)
    public void initializeCards() {

        for (int s = 0; s < Suit.values().length - 1; s++) {
            for (int r = 0; r < Rank.values().length - 1; r++) {
                Suit suit = Suit.values()[s];
                Rank rank = Rank.values()[r];
                cards.add(new Card(suit, rank, "images/cards/" + rank.rankName + "Of" + suit.suitName + ".png"));
            }
        }        

        cardListView.setItems(cards);
        cardListView.setOrientation(Orientation.HORIZONTAL);
    }

    public ListView<Card> getCardListView() {
        return cardListView;
    }
}
