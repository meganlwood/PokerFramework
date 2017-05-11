package framework;

public class Card {

	private int value;
	private String suit;
	private String name;
	
	public Card(int value, String suit) {
		this.value = value;
		this.suit = suit;
		this.name = Utilities.getName(value);
	}
	
	public int getValue() {
		return value;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return name + " of " + suit;
	}
	
	
}
