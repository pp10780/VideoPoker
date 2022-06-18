package dealer;

import java.util.*;

import card.*;
import player.*;

public class DealerSim implements Dealer{

	private Deck deck;
	private Discarded discarded;
	
	public DealerSim() {
		deck = new Deck();
	}

	public void deal(Player player) 
	{
		deck.shuffle();
		player.setHand(deck.draw(5));
	}
	
	public void draw(Player player, int n_cards) 
	{
		player.setHand(deck.draw(n_cards));
	}

	
	public void resetDeck(Player player) 
	{
		Collection<Card> disc = new LinkedList<Card>(discarded.discarded);
		Collection<Card> hand_c = new LinkedList<Card>(player.getHand().emptyHand());
		
		deck.deck.addAll(disc);
		deck.deck.addAll(hand_c);
	}

	public void discard(LinkedList<Card> discarded_cards) 
	{
		discarded = new Discarded(discarded_cards);
		//System.out.println("Discarded ->" + discarded_cards);
	}

}