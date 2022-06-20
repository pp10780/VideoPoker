package player;

import java.util.Collection;
import java.util.LinkedList;

import card.*;

/**
 * Represents a Hand of cards
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 *
 */
public class Hand {

	private LinkedList<Card> hand;
	
	/**
	 * Constructor of Hand that creates an empty linked list of Cards
	 */
	public Hand() {
		hand = new LinkedList<Card>();
	}
	
	/**
	 * Returns the linked list of cards that constitutes the hand
	 * @return LinkedList linked list of cards corresponding to the hand
	 */
	public LinkedList<Card> getCards()
	{
		return hand;
	}
	
	/**
	 * Adds cards to hand
	 * @param new_cards cards to be added to the hand
	 */
	public void setCards(LinkedList<Card> new_cards)
	{
		Collection<Card> new_cards_c = new LinkedList<Card>(new_cards);
		hand.addAll(new_cards_c);
	}
	
	/**
	 * Empties hand
	 * @return LinkedList the cards that were in the hand
	 */
	public LinkedList<Card> emptyHand()
	{
		LinkedList<Card> oldHand = new LinkedList<Card>();
		
		for(int i = 0; i < 5; i++)
		{
			oldHand.add(hand.removeFirst());
		}
		return oldHand;
	}
	
	/**
	 * Overrides the toString method 
	 * @return String return a string with the cards of player's hand
	 */
	@Override
	public String toString() {
		String sHand = new String();
		for(Card c: hand)
		{
			sHand += c.getRank();
			sHand += c.getSuit();
			sHand += " ";
		}
			
		return sHand;
	}
}