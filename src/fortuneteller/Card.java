public class Card implements Comparable<Card>  {
    private Suit suit;
    private Rank rank;
    private String imagePath;

    // creates a card object with a suit and rank
    public Card(Suit suit, Rank rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public Card(Suit suit, Rank rank, String imagePath) {
        this(suit, rank);
        this.imagePath = imagePath;
    } 

    public Integer getRankValue() {
        return rank.rankValue;
    }

    public Suit getSuit() {
        return suit;
    }

    public Rank getRank() {
        return rank;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String toString() {
        return String.format("[%s of %s] (%d)", rank, suit, this.getRankValue());
    }
    
    @Override
    public int compareTo(Card o) {
        return this.getRankValue().compareTo(o.getRankValue());
    }
}
