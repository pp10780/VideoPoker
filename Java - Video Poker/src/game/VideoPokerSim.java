package game;

import dealer.DealerSim;

public class VideoPokerSim extends VideoPoker{

	private int nbDeals;
	private DealerSim dealer;
	
	public VideoPokerSim(int credit, int _nbDeals, int _betSize) {
		super(credit);
		nbDeals = _nbDeals;
		betSize = _betSize;
		dealer = new DealerSim();
	}
	
	public void initGame(String[] args)
	{
		Simulation();
	}
	
	public void Simulation()
	{
		int n_discarded = 0;
		for(int i = 0; i < nbDeals; i++)
		{
			first_hand = new PerfectStrategy(player.getHand());
			
			
			player.bet(betSize);
			dealer.deal(player);
			first_hand = new PerfectStrategy(player.getHand());
			//System.out.println("1st hand ->" + player.getHand());
			n_discarded = player.discard(first_hand.decision(player.getHand()), dealer);
			dealer.draw(player, n_discarded);
			//System.out.println("2nd hand ->" + player.getHand());
			final_hand = new WinningHands(player.getHand());
			payment(final_hand.result());
			dealer.resetDeck(player);
		}
		Statistics();
	}
	
}