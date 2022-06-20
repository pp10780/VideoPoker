package dealer;

import java.util.LinkedList;

import card.Card;
import player.Player;

/**
 * General class that represents the dealer.
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 * */
public interface Dealer{
	
	/**
	 * Abstract method which is implemented by the subclasses DealerDeb and DealerSim
	 * @param player Object that represents the player of the game
	 */
	void deal(Player player);
	
	/**
	 * Abstract method which is implemented by the subclasses DealerDeb and DealerSim
	 * @param player Object that represents the player of the game
	 * @param n_cards Number of cards to be drawn
	 */
	void draw(Player player, int n_cards);
	
	/**
	 * Abstract method which is implemented by the subclasses DealerDeb and DealerSim
	 * @param discarded_cards Linked List with the cards discarded by the player
	 */
	void discard(LinkedList<Card> discarded_cards);
}