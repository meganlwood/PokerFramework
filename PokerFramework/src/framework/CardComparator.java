package framework;
import java.util.Comparator;

public class CardComparator implements Comparator<Card> {


	@Override
	public int compare(Card c1, Card c2) {
		// TODO Auto-generated method stub
		int val = c1.getValue() - c2.getValue();
		if (val != 0) return val;
		else {
			return getSuitVal(c1) - getSuitVal(c2);
		}
		
		//sort by Spades, Hearts, Clubs, Diamonds
	}
	
	public int getSuitVal(Card c) {
		switch (c.getSuit()) {
		case "Spades": return 4;
		case "Hearts": return 3;
		case "Clubs": return 2;
		case "Diamonds": return 1;
		default: return 0;
		}
	}

	
	
}
