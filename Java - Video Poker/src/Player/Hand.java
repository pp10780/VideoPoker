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
		return "" + hand;
	}
}