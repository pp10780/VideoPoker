package game;

import dealer.DealerSim;

public class VideoPokerSim extends VideoPoker{

	private int nbDeals;
	private DealerSim dealer;
	
	public VideoPokerSim(int credit, int _nbDeals, int _betSize, Variant gameVariant, Payout payVariant) {
		super(credit, gameVariant, payVariant);
		nbDeals = _nbDeals;
		betSize = _betSize;
		dealer = new DealerSim();
	}
	
	public void initGame()
	{
		int n_discarded = 0;
		for(int i = 0; i < nbDeals; i++)
		{
			
			//currentHand.computeHand(player.getHand());
			
			player.bet(betSize);
			dealer.deal(player);
			currentHand.computeHand(player.getHand());
			//System.out.println("1st hand ->" + player.getHand());
			n_discarded = player.discard(currentHand.perfectStrategy(player.getHand()), dealer);
			dealer.draw(player, n_discarded);
			//System.out.println("2nd hand ->" + player.getHand());
			currentHand.computeHand(player.getHand());
			currentHand.result(player, betSize, payout);
			dealer.resetDeck(player);
		}
		currentHand.Statistics(player);
	}
	
}