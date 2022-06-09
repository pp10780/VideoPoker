package Card;

public class Card {

	private char Rank;
	private char Suit;

	public Card(char _Rank, char _Suit) {
		Rank = _Rank;
		Suit = _Suit;
	}

	@Override
	public String toString() {
		return Rank + "" +  Suit;
	}
	
}