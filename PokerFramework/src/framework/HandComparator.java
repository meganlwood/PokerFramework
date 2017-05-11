package framework;
import java.util.Comparator;

public class HandComparator implements Comparator<Hand> {

	@Override
	public int compare(Hand h1, Hand h2) {
		int diff = getHandValue(h1) - getHandValue(h2);
		if (diff != 0) return diff;
		else {
			switch (getHandValue(h1)) {
			case 10: return new CardComparator().compare(h1.getTopCard(), h2.getTopCard());
			case 9: return Utilities.containsIndex(Utilities.getValues(h1), 4) - Utilities.containsIndex(Utilities.getValues(h2), 4);
			case 8: return h1.getTopCard().getValue() - h2.getTopCard().getValue();
			case 7: return h1.getTopCard().getValue() - h2.getTopCard().getValue();
			case 6: return h1.getTopCard().getValue() - h2.getTopCard().getValue();
			case 5: return Utilities.containsIndex(Utilities.getValues(h1), 3) - Utilities.containsIndex(Utilities.getValues(h2), 3);
			case 4: return Utilities.containsMult(Utilities.getValues(h1), 2)[1] - Utilities.containsMult(Utilities.getValues(h2), 2)[1];
			case 3: return Utilities.containsIndex(Utilities.getValues(h1), 2) - Utilities.containsIndex(Utilities.getValues(h2),2);
			case 2: return h1.getTopCard().getValue() - h2.getTopCard().getValue();
			default: return 0;
			}
			
		}
	}
	
	public int getHandValue(Hand h) {
		switch (Utilities.evaluateHand(h)) {
		case "Straight Flush": return 10;
		case "Four of a Kind": return 9;
		case "Flush": return 8;
		case "Straight": return 7;
		case "Full House": return 6;
		case "Three of a Kind": return 5;
		case "Two Pair": return 4;
		case "Pair": return 3;
		case "Nothing": return 2;
		default: return 0;
		}
	}
	
	/*

	
	public boolean hasStraightFlush(Hand hand) {
		return hasStraight(hand) && hasFlush(hand);
	}
	
	public boolean hasFourOfAKind(Hand hand) {
		for (int i : getValues(hand)) if (i == 4) return true;
		return false;
	}
	
	public boolean hasFlush(Hand hand) {
		String suit = hand.getCards().get(0).getSuit();
		boolean flush = true;
		for (Card c : hand.getCards()) if (!c.getSuit().equals(suit)) flush = false;
		return flush;
	}
	
	public boolean hasStraight(Hand hand) {
		if (hand.getCards().get(0).getValue() == 14
				&& hand.getCards().get(1).getValue() == 2
				&& hand.getCards().get(2).getValue() == 3
				&& hand.getCards().get(3).getValue() == 4
				&& hand.getCards().get(4).getValue() == 5) return true;
		else {
			int start = hand.getCards().get(0).getValue();
			for (int i = 0; i < hand.getCards().size(); i++) {
				if (hand.getCards().get(i).getValue() != start + i) return false;
			}
			return true;
		}
	}
	
	
	public boolean hasFullHouse(Hand hand) {
		int[] values = getValues(hand);
		if (contains(values, 3) && contains(values, 2)) return true;
		else return false;
	}
	
	public boolean hasThreeOfAKind(Hand hand) {
		int[] values = getValues(hand);
		if (contains(values, 3)) return true;
		else return false;
	}
	
	public boolean hasTwoPair(Hand hand) {
		int numPairs = 0;
		for (int val : getValues(hand)) if (val == 2) numPairs++;
		if (numPairs == 2) return true;
		else return false;
	}
	
	public boolean hasPair(Hand hand) {
		int[] values = getValues(hand);
		if (contains(values, 2)) return true;
		else return false;
	}
	
	public int[] getValues(Hand hand) {
		int[] values = new int[14];
		for (Card c : hand.getCards()) {
			values[c.getValue()]++;
		}
		return values;
	}
	
	public boolean contains(int[] list, int value) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == value) return true;
		}
		return false;
	}
	*/
	
	

	
	
}
