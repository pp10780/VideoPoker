package dealer;

import java.util.LinkedList;

import card.*;
import player.*;

public class DealerDeb implements Dealer{

	private LinkedList<Card> deb_cards = new LinkedList<Card>();
	
	public DealerDeb(String[] cards) {
		char rank, suit;
		for(int i = 0; i < cards.length; i++)
		{
			//Validacao
			rank = cards[i].toCharArray()[0];
			suit = cards[i].toCharArray()[1];
			deb_cards.add(new Card(rank, suit));
		}
			
	}
	
	public void deal(Player player) {
		LinkedList<Card> new_hand = new LinkedList<Card>();
		
		for(int i = 0; i < 5; i++)
		{
			new_hand.add(deb_cards.removeFirst());
		}
		player.setHand(new_hand);
	}
	
	public void draw(Player player, int n_cards) {
		LinkedList<Card> new_cards = new LinkedList<Card>();
		for(int i = 0; i < n_cards; i++)
		{
			new_cards.add(deb_cards.removeFirst());
		}
		player.setHand(new_cards);
	}
	
	public void discard(LinkedList<Card> discarded_cards) 
	{
		discarded_cards.clear();
	}

}