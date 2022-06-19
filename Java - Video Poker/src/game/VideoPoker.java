package game;

import player.Player;

public abstract class VideoPoker {
	protected Player player;
	protected DoubleBonus final_hand;
	protected PerfectStrategy first_hand;
	protected int[] Nb;
	protected int betSize;
	
	public VideoPoker(int credit)
	{
		player = new Player(credit);
		Nb = new int[12];
	}
	
	void initGame(String[] cmd) {};
	
	public void payment(String result)
	{
		if(result.equals("ROYAL FLUSH"))
		{
			Nb[8]++;
			if(betSize == 5)
				player.setBalance(4000);
			else
				player.setBalance(betSize*250);
		}
			
		else if(result.equals("STRAIGHT FLUSH"))
		{
			Nb[7]++;
			player.setBalance(betSize*50);
		}
			
		else if(result.equals("FOUR ACES"))
		{
			Nb[6]++;
			player.setBalance(betSize*160);
		}
			
		
		else if(result.equals("FOUR 2-4"))
		{
			Nb[6]++;
			player.setBalance(betSize*80);
		}
			
		else if(result.equals("FOUR 5-K"))
		{
			Nb[6]++;
			player.setBalance(betSize*50);
		}
			
		else if(result.equals("FULL HOUSE"))
		{
			Nb[5]++;
			player.setBalance(betSize*10);
		}
			
		else if(result.equals("FLUSH"))
		{
			Nb[4]++;
			player.setBalance(betSize*7);
		}
			
		else if(result.equals("STRAIGHT"))
		{
			Nb[3]++;
			player.setBalance(betSize*5);
		}
			
		else if(result.equals("THREE OF A KIND"))
		{
			Nb[2]++;
			player.setBalance(betSize*3);
		}
			
		else if(result.equals("TWO PAIR"))
		{
			Nb[1]++;
			player.setBalance(betSize*1);
		}	
		else if(result.equals("JACKS OR BETTER"))
		{
			Nb[0]++;
			player.setBalance(betSize*1);
		}
		else
		{
			Nb[9]++;
		}
		Nb[10]++;
	}
	/*
	 * 
	 * @param earnings ola
	 * @return nada
	 * 
	 * 
	 * 
	 */
	public void Statistics()
	{
		Nb[11] = player.getBalance();
		float earnings = player.getEarnings();
		float wagered = player.getWagered();
		
		float final_percent = (earnings/ wagered) * 100;
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