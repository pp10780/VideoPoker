package Dealer;

import java.util.LinkedList;
import Player.*;
import Card.*;

public class Dealer_deb extends Dealer{

	private LinkedList<Card> deb_cards = new LinkedList<Card>();
	
	public Dealer_deb(String[] cards) {
		char rank, suit;
		for(int i = 0; i < cards.length; i++)
		{
			rank = cards[i].toCharArray()[0];
			suit = cards[i].toCharArray()[1];
			deb_cards.add(new Card(rank, suit));
		}
			
	}
	
	@Override
	public void deal(Player player) {
		LinkedList<Card> new_hand = new LinkedList<Card>();
		
		for(int i = 0; i < 5; i++)
		{
			new_hand.add(deb_cards.removeFirst());
		}
		player.setHand(new_hand);
	}
	
	@Override
	public void draw(Player player, int n_cards) {
		LinkedList<Card> new_cards = new LinkedList<Card>();
		for(int i = 0; i < n_cards; i++)
		{
			new_cards.add(deb_cards.removeFirst());
		}
		player.setHand(new_cards);
	}

}