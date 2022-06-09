package Player;

import java.util.Collection;
import java.util.LinkedList;
import Card.*;

public class Hand {

	LinkedList<Card> hand;
	public Hand() {
		// TODO - implement Hand.Hand
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

	@Override
	public String toString() {
		return "" + hand;
	}
}