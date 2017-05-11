package framework;
import java.util.ArrayList;
import java.util.Random;

public class Deck {

	private ArrayList<Card> cards = new ArrayList<Card>();
	private int placeInDeck;
	
	public Deck() {
		placeInDeck = -1;
		for (int i = 2; i < 15; i++) {
			cards.add(new Card(i, "Spades"));
			cards.add(new Card(i, "Hearts"));
			cards.add(new Card(i, "Clubs"));
			cards.add(new Card(i, "Diamonds"));
		}
	}
	
	public void shuffle() {
		for (int i = 0; i < 1000; i++) {
			Random rand = new Random();
			int place = rand.nextInt(52);
			Card temp = cards.get(place);
			cards.remove(place);
			cards.add(temp);
		}
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}
	
	public Card nextCard() {
		placeInDeck++;
		if (placeInDeck == 52) {
			shuffle();
			placeInDeck = 0;
		}
		return cards.get(placeInDeck);

	}
	
	
	
	
}
