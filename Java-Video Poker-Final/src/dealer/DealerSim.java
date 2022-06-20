package dealer;

import java.util.*;

import card.*;
import player.*;

/**
 * Class that implements the Dealer Interface for the Simulation Mode
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 * */
public class DealerSim implements Dealer{

	private Deck deck;
	private LinkedList<Card> discardedCards;
	
	/**
	 * Constructor of the DealerSim class where the deck is created as an object of the class Deck
	 * */
	public DealerSim() {
		deck = new Deck();
	}
	
	
	/**
	 * Shuffles the deck and deals the initial hand of the player
	 * @param player Object that receives that hand dealt by the dealer
	 * */
	public void deal(Player player) 
	{
		deck.shuffle();
		player.setHand(deck.draw(5));
	}
	
	/**
	 * Draws the cards to complete the player's final hand
	 * @param player Object that receives the cards drawn by the dealer
	 * @param n_cards Number of cards that the dealer has to draw
	 * */
	public void draw(Player player, int n_cards) 
	{
		player.setHand(deck.draw(n_cards));
	}

	
	/**
	 * Adds the discarded cards and the player's final hand back to the deck
	 * @param player Object that has the hand.
	 * */
	public void resetDeck(Player player) 
	{
		Collection<Card> disc = new LinkedList<Card>(discardedCards);
		Collection<Card> hand_c = new LinkedList<Card>(player.getHand().emptyHand());
		
		deck.deck.addAll(disc);
		deck.deck.addAll(hand_c);
	}
	
	/**
	 * Receives the discarded cards from the player and stores them as an object of the Discarded class
	 * @param discarded_cards Cards that were discarded by the player
	 * */
	public void discard(LinkedList<Card> discarded_cards) 
	{
		discardedCards = discarded_cards;
	}

}