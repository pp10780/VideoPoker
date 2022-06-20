package card;
/**
 * Represents a single card in use in the game
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 */
public class Card {

	private char Rank;
	private char Suit;
	
	/**
	 * Card constructor, which receives as argument the Rank and Suit of the card to create
	 * @param _Rank Rank of the specific card to create
	 * @param _Suit Suit of the specific card to create 
	 */
	public Card(char _Rank, char _Suit) {
		Rank = _Rank;
		Suit = _Suit;
	}
	
	/**
	 * Gets the Rank of a specific card
	 * @return char Rank of the card
	 */
	public char getRank()
	{
		return Rank;
	}
	
	/**
	 * Gets the Suit of a specific card
	 * @return char Suit of the card
	 */
	public char getSuit()
	{
		return Suit;
	}
	
	/**
	 * Prints the attributes of a card and overrides the toString method
	 */
	@Override
	public String toString() {
		return Rank + "" +  Suit;
	}
	
}