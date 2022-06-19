package dealer;

import java.util.LinkedList;

import card.Card;
import player.Player;

/**
 * General class that represents the dealer.
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 * */
public interface Dealer{

	void deal(Player player);
	void draw(Player player, int n_cards);
	void discard(LinkedList<Card> discarded_cards);
}