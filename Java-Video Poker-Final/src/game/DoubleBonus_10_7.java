package game;

import player.Player;
/**
 * Responsible of the Double Bones 10/7 variation payment 
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 */
public class DoubleBonus_10_7 implements Payout{
	
	/**
	 * Sets player balance for specific condition defined by the variant played
	 * @param player Object with player's information
	 * @param betSize Bet value
	 * @param payoutSize Payout value 
	 */
	public void payment(Player player, int betSize, int payoutSize)
	{
		player.setBalance(payoutSize*betSize);
	}
}
