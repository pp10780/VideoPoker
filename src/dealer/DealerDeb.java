package dealer;

import java.util.LinkedList;

import card.*;
import player.*;

/**
 * Class that implements the Dealer Interface for the Debugging Mode
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 * */
public class DealerDeb implements Dealer{

	private LinkedList<Card> deb_cards = new LinkedList<Card>();
	
	/**
	 * Constructor of the DealerDeb class
	 * @param cards Array of strings with the cards read from the card-file
	 * */
	public DealerDeb(String[] cards) {
		char rank, suit;
		for(int i = 0; i < cards.length; i++)
		{
			rank = cards[i].toCharArray()[0];
			suit = cards[i].toCharArray()[1];
			deb_cards.add(new Card(rank, suit));
		}
			
	}
	
	/**
	 * Deals the initial hand to the player
	 * @param player Object that receives that hand dealt by the dealer
	 * */
	public void deal(Player player) {
		LinkedList<Card> new_hand = new LinkedList<Card>();
		
		for(int i = 0; i < 5; i++)
		{
			new_hand.add(deb_cards.removeFirst());
		}
		player.setHand(new_hand);
	}
	
	/**
	 * Draws the cards to complete the player's final hand
	 * @param player Object that receives the cards drawn by the dealer
	 * @param n_cards Number of cards that the dealer has to draw
	 * */
	public void draw(Player player, int n_cards) {
		LinkedList<Card> new_cards = new LinkedList<Card>();
		for(int i = 0; i < n_cards; i++)
		{
			new_cards.add(deb_cards.removeFirst());
		}
		player.setHand(new_cards);
	}
	
	/**
	 * Receives the discarded cards from the player
	 * @param discarded_cards Cards that were discarded by the player
	 * */
	public void discard(LinkedList<Card> discarded_cards) 
	{
		discarded_cards.clear();
	}

}