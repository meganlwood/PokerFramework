package framework;
import java.util.ArrayList;

public class Hand implements Comparable<Hand> {

	private ArrayList<Card> cardsInHand;
	
	public Hand() {
		cardsInHand = new ArrayList<Card>();
	}
	
	public Hand(ArrayList<Card> hand) {
		cardsInHand = hand;
	}
	
	public String toString() {
		String hand = "";
		for (int i = 0; i < cardsInHand.size(); i++) {
			if (i == 0) hand += cardsInHand.get(0);
			else hand += ",\n" + cardsInHand.get(i);
		}
		return hand;
	}
	
	public void addCard(Card c) {
		cardsInHand.add(c);
	}
	
	public void sort() {
		cardsInHand = Utilities.sort(cardsInHand);
	}
	
	public ArrayList<Card> getCards() {
		return cardsInHand;
	}
	
	public Card getTopCard() {
		return cardsInHand.get(cardsInHand.size() - 1);
	}

	@Override
	public int compareTo(Hand other) {
		return new HandComparator().compare(this, other);
	}
	
	
}
