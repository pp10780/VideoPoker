package dealer;

import java.util.LinkedList;

import card.*;

public class Discarded {

	LinkedList<Card> discarded;
	
	public Discarded(LinkedList<Card> discarded_cards) {
		discarded = discarded_cards;
	}
	
	public LinkedList<Card> getDiscarded()
	{
		return discarded;
	}
	
	@Override
	public String toString() {
		return "" + discarded;
	}

}