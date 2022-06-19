package dealer;

import java.util.*;

import card.*;

/**
 * Represents the Deck of cards
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 * */
public class Deck {

	LinkedList<Card> deck;
	
	/**
	 * Constructor of the Deck Class where the whole deck is created
	 * */
	public Deck() {
		deck = new LinkedList<Card>();
		char[] auxSuit = {'S', 'C', 'H', 'D'};
		char[] auxRank = {'A','2', '3', '4', '5', '6', '7', '8', '9', 'T',  'J', 'Q', 'K'};
		
		for(char suit : auxSuit)
		{
			for(char rank : auxRank)
			{
				deck.add(new Card(rank, suit));
			}
		}
	}
	
	/**
	 * Shuffles the deck
	 * */
	public void shuffle() {
		Collections.shuffle(deck);
	}

	/**
	 * Draws cards from the deck
	 * @param n_cards Number of cards that are drawn
	 * @return LinkedList<Card> Cards that are drawn from the deck
	 * */
	public LinkedList<Card> draw(int n_cards) {
		LinkedList<Card> cards = new LinkedList<Card>();
		for(int i = 0; i < n_cards; i++)
		{
			cards.add(deck.removeFirst());
		}
		return cards;
	}

	/**
	 * Overrides the toString method to cast Linked List deck to a String
	 * @return String string with the deck of cards
	 * */
	@Override
	public String toString() {
		return  "" + deck;
	}
}