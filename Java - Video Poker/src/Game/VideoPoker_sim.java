package Game;

import Dealer.Dealer_sim;
import Player.Player;

public class VideoPoker_sim implements VideoPoker{

	private int nbDeals;
	private int betSize;
	private Dealer_sim dealer;
	private Player player;
	private Strategy final_hand;
	private PerfectStrategy first_hand;
	private int[] Nb;
	private float final_percent;
	
	public VideoPoker_sim(int credit, int _nbDeals, int _betSize) {
		nbDeals = _nbDeals;
		betSize = _betSize;
		Nb = new int[12];
		dealer = new Dealer_sim();
		player = new Player(credit);
	}
	
	public void execute_cmd(String[] args)
	{
		Simulation();
	}
	
	public void Simulation()
	{
		for(int i = 0; i < nbDeals; i++)
		{
			first_hand = new PerfectStrategy();
			final_hand = new Strategy();
			player.bet(betSize);
			dealer.deal(player);
			//System.out.println("1st hand ->" + player.getHand());
			first_hand.fill_matrix(player.getHand());
			player.discard(first_hand.decision(player.getHand()), dealer);
			//System.out.println("2nd hand ->" + player.getHand());
			final_hand.fill_matrix(player.getHand());
			payment(final_hand.result());
			dealer.resetDeck(player.getHand());
		}
		Statistics();
	}
	
	public void hold(int[] cards) {
		int n_cards_discarded = 0;
		for(int i = 4; i >= 0; i--)
		{
			if(cards[i] == 0)
			{
				n_cards_discarded++;
				player.getHand().getCards().remove(i);
			}
		}
		dealer.draw(player, n_cards_discarded);
	}
	
	public void payment(String result)
	{
		if(result.equals("ROYAL FLUSH"))
		{
			Nb[8]++;
			if(player.getHand().getBetSize() == 5)
				player.setBalance(4000);
			else
				player.setBalance(player.getHand().getBetSize()*250);
		}
			
		else if(result.equals("STRAIGHT FLUSH"))
		{
			Nb[7]++;
			player.setBalance(player.getHand().getBetSize()*50);
		}
			
		else if(result.equals("FOUR ACES"))
		{
			Nb[6]++;
			player.setBalance(player.getHand().getBetSize()*160);
		}
			
		
		else if(result.equals("FOUR 2–4"))
		{
			Nb[6]++;
			player.setBalance(player.getHand().getBetSize()*80);
		}
			
		else if(result.equals("FOUR 5–K"))
		{
			Nb[6]++;
			player.setBalance(player.getHand().getBetSize()*50);
		}
			
		else if(result.equals("FULL HOUSE"))
		{
			Nb[5]++;
			player.setBalance(player.getHand().getBetSize()*10);
		}
			
		else if(result.equals("FLUSH"))
		{
			Nb[4]++;
			player.setBalance(player.getHand().getBetSize()*7);
		}
			
		else if(result.equals("STRAIGHT"))
		{
			Nb[3]++;
			player.setBalance(player.getHand().getBetSize()*5);
		}
			
		else if(result.equals("THREE OF A KIND"))
		{
			Nb[2]++;
			player.setBalance(player.getHand().getBetSize()*3);
		}
			
		else if(result.equals("TWO PAIR"))
		{
			Nb[1]++;
			player.setBalance(player.getHand().getBetSize()*1);
		}	
		else if(result.equals("JACKS OR BETTER"))
		{
			Nb[0]++;
			player.setBalance(player.getHand().getBetSize()*1);
		}
		else
		{
			Nb[9]++;
		}
		Nb[10]++;
			
	}
	
	public void Statistics()
	{
		Nb[11] = player.getBalance();
		float earnings = player.getEarnings();
		float wagered = player.getWagered();
		
		final_percent = (earnings/ wagered) * 100;
		System.out.println();
		System.out.println("  "+"Hand                             Nb");
		System.out.println("  "+"------------------------------------");
		System.out.println("  "+"Jacks or Better                  "+Nb[0]+"");
		System.out.println("  "+"Two Pair                         "+Nb[1]+"");
		System.out.println("  "+"Three of a kind                  "+Nb[2]+"");
		System.out.println("  "+"Straight                         "+Nb[3]+"");
		System.out.println("  "+"Flush                            "+Nb[4]+"");
		System.out.println("  "+"Full House                       "+Nb[5]+"");
		System.out.println("  "+"Four of a Kind                   "+Nb[6]+"");
		System.out.println("  "+"Straight Flush                   "+Nb[7]+"");
		System.out.println("  "+"Royal Flush                      "+Nb[8]+"");
		System.out.println("  "+"Other                            "+Nb[9]+"");
		System.out.println("  "+"------------------------------------");
		System.out.println("  "+"Total                            "+Nb[10]+"");
		System.out.println("  "+"------------------------------------");
		System.out.println("  "+"Credit                 "+Nb[11]+"("+String.format("%.1f", final_percent)+"%)");
	}
}