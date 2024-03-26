import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ShuffleDeck {
		private int i;
		private Integer[] Deck;
	
	//my thoughts are we could make a new class/method of identifying the worth of the card and have
	//a picture identifying what the card looks like. because its blackjack the suits shouldn't matter too much
	
	//after card is drawn we can find out how much that one card is worth. dividing by 13 and getting the remainder should work.
	public ShuffleDeck() {
		//ace will be 1, 14, 27, and 40. the next number up will be two and so forth.
		//order of suit will be Clubs(0-12), Diamonds(13-25), Hearts(26-38), and Spades(39-51)
		
		
		
		Integer[] Deck = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16,
				17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34,
				35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51};

		List<Integer> Suffler = Arrays.asList(Deck);
		Collections.shuffle(Suffler);
		Suffler.toArray(Deck);
		this.Deck=Deck;
		i = 0;
		
		//in case you need to see the order
//		System.out.println(Arrays.toString(Deck));
		
		
		
		
		
	}
	public int drawCard() {
		
		int j = Deck[i];
		i++;	
		return j;
			
		}
	public Integer[] getDeck() {
		return Deck;
	}
	
}