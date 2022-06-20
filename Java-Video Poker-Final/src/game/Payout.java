package game;

import player.Player;

/**
 * Interface that defines the abstract method to perform the payment in different variations
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 */
public interface Payout {
	
	/**
	 * Abstract method which is implemented by the subclass DoubleBonus_10_7
	 * @param player Object with player's information
	 * @param betSize Size of the bet made by the player
	 * @param payoutSize Parameter associated with the payout quantity
	 */
	void payment(Player player, int betSize, int payoutSize);

}
