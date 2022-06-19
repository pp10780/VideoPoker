package game;

import player.Player;

public abstract class VideoPoker {
	protected Player player;
	protected Variant currentHand;
	protected Payout payout;
	protected int betSize;
	
	public VideoPoker(int credit, Variant gameVariant, Payout payVariant)
	{
		currentHand = gameVariant;
		payout = payVariant;
		player = new Player(credit);
	}
	
	public abstract void initGame();

}