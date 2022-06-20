package game;

import player.Player;

/**
 * Represents the game VideoPoker, is abstract and will be instanced as one of its subclasses: 
 * VideoPokerSim or VideoPokerDeb, which correspond to the implemented game modes
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 */
public abstract class VideoPoker {
	protected Player player;
	protected Variant currentHand;
	protected Payout payout;
	protected int betSize;
	
	/**
	 * Constructor of VideoPoker that receives as argument the initial balance of the player, the game variant, ie Double Bonus
	 * and the payout variant, ie 10/7
	 * 
	 * @param credit inicial balance of the player
	 * @param gameVariant game variant
	 * @param payVariant payout variant
	 */
	public VideoPoker(int credit, Variant gameVariant, Payout payVariant)
	{
		currentHand = gameVariant;
		payout = payVariant;
		player = new Player(credit);
	}
	
	/**
	 * Abstract method which is implemented by the subclasses VidePokerSim and VideoPokerDeb
	 */
	public abstract void initGame();

}