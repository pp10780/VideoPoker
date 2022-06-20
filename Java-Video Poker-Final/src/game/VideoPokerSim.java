package game;

import dealer.DealerSim;

/**
 * Subclass of VideoPoker, represents the simulation game mode 
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 */
public class VideoPokerSim extends VideoPoker{

	private int nbDeals;
	private DealerSim dealer;
	
	/**
	 * Constructor of VideoPokerSim that receives as argument the initial balance of the player, the number of plays - bet, deal, decision of which to hold and payment in case of victory - to do, the bet size, the game variant, e.g Double Bonus and the payout variant, e.g 10/7
	 * 
	 * @param credit initial balance of the player
	 * @param _nbDeals number of plays to do
	 * @param _betSize size of the bet to be placed in each play
	 * @param gameVariant game variant
	 * @param payVariant payout variant
	 */
	public VideoPokerSim(int credit, int _nbDeals, int _betSize, Variant gameVariant, Payout payVariant) {
		super(credit, gameVariant, payVariant);
		nbDeals = _nbDeals;
		betSize = _betSize;
		dealer = new DealerSim();
	}
	
	/**
	 * Implements the abstract method initGame from VideoPoker: initiates the game, executes each play by betting, dealing and analysing the hands according to the perfect strategy and the double bonus 10/7 variant
	 */
	public void initGame()
	{
		int n_discarded = 0;
		for(int i = 0; i < nbDeals; i++)
		{
			player.bet(betSize);
			dealer.deal(player);
			currentHand.computeHand(player.getHand());
			
			n_discarded = player.discard(currentHand.perfectStrategy(player.getHand()), dealer);
			dealer.draw(player, n_discarded);
			
			currentHand.computeHand(player.getHand());
			currentHand.result(player, betSize, payout);
			dealer.resetDeck(player);
		}
		currentHand.Statistics(player);
	}
	
}