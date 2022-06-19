package game;

import player.Player;

public class DoubleBonus_10_7 implements Payout{
	public DoubleBonus_10_7()
	{
		
	}
	
	public void payment(Player player, int betSize, int payoutSize)
	{
		player.setBalance(payoutSize*betSize);
	}
}
