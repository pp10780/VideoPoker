package card;

public class Card {

	private char Rank;
	private char Suit;

	public Card(char _Rank, char _Suit) {
		Rank = _Rank;
		Suit = _Suit;
	}
	
	public char getRank()
	{
		return Rank;
	}
	
	public char getSuit()
	{
		return Suit;
	}

	@Override
	public String toString() {
		return Rank + "" +  Suit;
	}
	
}