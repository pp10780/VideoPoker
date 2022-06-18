package dealer;

import java.util.*;

import card.*;

public class Deck {

	LinkedList<Card> deck;
	
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

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public LinkedList<Card> draw(int n_cards) {
		LinkedList<Card> cards = new LinkedList<Card>();
		for(int i = 0; i < n_cards; i++)
		{
			cards.add(deck.removeFirst());
		}
		return cards;
	}
	
	public LinkedList<Card> getDeck()
	{
		return deck;
	}

	@Override
	public String toString() {
		return  "" + deck;
	}
}