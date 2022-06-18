package Player;

import java.util.Collection;
import java.util.LinkedList;
import Card.*;

public class Hand {

	private LinkedList<Card> hand;
	private int bet_size;
	
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
	
	public void emptyHand()
	{
		hand.clear();
	}
	
	public int getBetSize()
	{
		return bet_size;
	}
	
	public void setBetSize(int _bet)
	{
		bet_size = _bet;
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