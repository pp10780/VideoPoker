package player;

import java.util.Collection;
import java.util.LinkedList;

import card.*;

public class Hand {

	private LinkedList<Card> hand;
	
	public Hand() {
		hand = new LinkedList<Card>();
	}
	
	public LinkedList<Card> getCards()
	{
		return hand;
	}
	
	public void setCards(LinkedList<Card> new_cards)
	{
		Collection<Card> new_cards_c = new LinkedList<Card>(new_cards);
		hand.addAll(new_cards_c);
	}
	
	public LinkedList<Card> emptyHand()
	{
		LinkedList<Card> oldHand = new LinkedList<Card>();
		
		for(int i = 0; i < 5; i++)
		{
			oldHand.add(hand.removeFirst());
		}
		return oldHand;
	}
	
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