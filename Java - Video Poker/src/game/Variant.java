package game;

import player.Hand;
import player.Player;

public abstract class Variant {
	protected Payout payout;
	
	public abstract void computeHand(Hand hand);
	public abstract String result(Player player, int betSize, Payout payout);
	public abstract void Statistics(Player player);
	public abstract int[] perfectStrategy(Hand hand);
}
