package Dealer;

import java.util.*;
import Player.*;
import Card.*;

public class Dealer_sim extends Dealer{

	Deck deck;
	Discarded discarded;
	public Dealer_sim() {
		deck = new Deck();
	}

	@Override
	public void deal(Player player) 
	{
		deck.shuffle();
		player.setHand(deck.draw(5));
		
		
	}
	@Override
	public void draw(Player player, int n_cards) 
	{
		player.setHand(deck.draw(n_cards));
	}

	
	public void resetDeck(Hand hand) 
	{
		Collection<Card> disc = new LinkedList<Card>(discarded.getDiscarded());
		Collection<Card> hand_c = new LinkedList<Card>(hand.getCards());
		
		deck.getDeck().addAll(disc);
		deck.getDeck().addAll(hand_c);
		
	}

	public void discard(LinkedList<Card> discarded_cards) 
	{
		discarded = new Discarded(discarded_cards);
	}

}