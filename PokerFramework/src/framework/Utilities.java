package framework;
import java.util.ArrayList;
import java.util.Collections;

public class Utilities {

	public static String getName(int value) {
		switch(value) {
		//case 1: return "Ace";
		case 2: return "2";
		case 3: return "3";
		case 4: return "4";
		case 5: return "5";
		case 6: return "6";
		case 7: return "7";
		case 8: return "8";
		case 9: return "9";
		case 10: return "10";
		case 11: return "Jack";
		case 12: return "Queen";
		case 13: return "King";
		case 14: return "Ace";
		default: return "Unknown";
		}
	}
	
	public static int getValue(String name) {
		switch (name) {
		case "Ace": return 14;
		case "Two": return 2;
		case "Three": return 3;
		case "Four": return 4;
		case "Five": return 5;
		case "Six": return 6;
		case "Seven": return 7;
		case "Eight": return 8;
		case "Nine": return 9;
		case "Ten": return 10;
		case "Jack": return 11;
		case "Queen": return 12;
		case "King": return 13;
		default: return 0;
		}
	}
	
	public static ArrayList<Card> sort(ArrayList<Card> list) {
		Collections.sort(list, new CardComparator());
		return list;
	}
	
	public static String evaluateHand(Hand h) {
		if (hasStraightFlush(h)) return "Straight Flush";
		else if (hasFourOfAKind(h)) return "Four of a Kind";
		else if (hasFlush(h)) return "Flush";
		else if (hasStraight(h)) return "Straight";
		else if (hasFullHouse(h)) return "Full House";
		else if (hasThreeOfAKind(h)) return "Three of a Kind";
		else if (hasTwoPair(h)) return "Two Pair";
		else if (hasPair(h)) return "Pair";
		else return "Nothing";
	}
	
	public static boolean hasStraightFlush(Hand hand) {
		return hasStraight(hand) && hasFlush(hand);
	}
	
	public static boolean hasFourOfAKind(Hand hand) {
		for (int i : getValues(hand)) if (i == 4) return true;
		return false;
	}
	
	public static boolean hasFlush(Hand hand) {
		String suit = hand.getCards().get(0).getSuit();
		boolean flush = true;
		for (Card c : hand.getCards()) if (!c.getSuit().equals(suit)) flush = false;
		return flush;
	}
	
	public static boolean hasStraight(Hand hand) {
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
	
	
	public static boolean hasFullHouse(Hand hand) {
		int[] values = getValues(hand);
		if (contains(values, 3) && contains(values, 2)) return true;
		else return false;
	}
	
	public static boolean hasThreeOfAKind(Hand hand) {
		int[] values = getValues(hand);
		if (contains(values, 3)) return true;
		else return false;
	}
	
	public static boolean hasTwoPair(Hand hand) {
		int numPairs = 0;
		for (int val : getValues(hand)) if (val == 2) numPairs++;
		if (numPairs == 2) return true;
		else return false;
	}
	
	public static boolean hasPair(Hand hand) {
		int[] values = getValues(hand);
		if (contains(values, 2)) return true;
		else return false;
	}
	
	public static int[] getValues(Hand hand) {
		int[] values = new int[15];
		for (Card c : hand.getCards()) {
			values[c.getValue()]++;
		}
		return values;
	}
	
	public static boolean contains(int[] list, int value) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == value) return true;
		}
		return false;
	}
	
	public static int containsIndex(int[] list, int value) {
		for (int i = 0; i < list.length; i++) {
			if (list[i] == value) return i;
		}
		return -1;
	}
	
	public static int[] containsMult(int[] list, int value) {
		int[] indexes = new int[2];
		int plc = 0;
		for (int i = 0; i < list.length; i++) {
			if (list[i] == value) {
				indexes[plc] = i;
				plc++;
			}
		}
		return indexes;
	}
	
	
}
