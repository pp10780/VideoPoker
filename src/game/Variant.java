package game;

import player.Hand;
import player.Player;

/**
 * Defines the abstract methods to be used in specific game variations
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 */
public abstract class Variant {
	protected Payout payout;
	
	/**
	 * Abstract method which is implemented by the subclass DoubleBonus
	 * @param hand Hand of the current play
	 */
	public abstract void computeHand(Hand hand);
	
	/**
	 * Abstract method which is implemented by the subclass DoubleBonus
	 * @param player Object that represents the player of the game
	 * @param betSize Size of the bet made by the player
	 * @param payout Object that contains variant chosen
	 * @return String returns the result
	 */
	public abstract String result(Player player, int betSize, Payout payout);
	
	/**
	 * Abstract method which is implemented by the subclass DoubleBonus
	 * @param player Object that represents the player of the game
	 */
	public abstract void Statistics(Player player);
	
	/**
	 * Abstract method which is implemented by the subclass DoubleBonus
	 * @param hand Hand of the current play
	 * @return int[] Array that shows which cards to discard and which cards to hold
	 */
	public abstract int[] perfectStrategy(Hand hand);
}
