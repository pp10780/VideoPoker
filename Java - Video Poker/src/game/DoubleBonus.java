package game;

import card.Card;
import player.*;

public class DoubleBonus extends Variant{

	
	int[][] matHand;
	private PerfectStrategy perfectStrategy;
	private String[] winningHands;
	private int result;
	private int[] Nb;
	// matHand
	//	2	3	4	5	6	7	8	9	10	J Q K A
	//H : 0
	//D : 1
	//C : 2
	//S : 3
	public DoubleBonus() {
		Nb = new int[12];
		result = 11;
		winningHands = new String[]{"ROYAL FLUSH",
				 "STRAIGHT FLUSH",
		         "FOUR ACES",
				 "FOUR 2-4",
				 "FOUR 5-K",
				 "FULL HOUSE",
				 "FLUSH",
				 "STRAIGHT",
				 "THREE OF A KIND",
				 "TWO PAIR",
				 "JACKS OR BETTER",
				 "NONE"};
	}
	
	public int[] perfectStrategy(Hand hand)
	{
		perfectStrategy = new PerfectStrategy(hand);
		return perfectStrategy.decision();
	}

	public void computeHand(Hand hand) {
		char s;
		int i = 1;
		int index = 0;
		matHand = new int[4][13];
		for(Card c: hand.getCards())
		{
			s = c.getSuit();
			if(Character.isDigit(c.getRank()))
			{
				if(s == 'H')
					matHand[0][Character.getNumericValue(c.getRank()) - 2] = i;
				else if(s == 'D')
					matHand[1][Character.getNumericValue(c.getRank()) - 2] = i;
				else if(s == 'C')
					matHand[2][Character.getNumericValue(c.getRank()) - 2] = i;
				else if(s == 'S')
					matHand[3][Character.getNumericValue(c.getRank()) - 2] = i;
			}
			else 
			{
				if(c.getRank() == 'T')
					index = 8;
				else if(c.getRank() == 'J')
					index = 9;
				else if(c.getRank() == 'Q')
					index = 10;
				else if(c.getRank() == 'K')
					index = 11;
				else if(c.getRank() == 'A')
					index = 12;
				if(s == 'H')
					matHand[0][index] = i;
				if(s == 'D')
					matHand[1][index] = i;
				if(s == 'C')
					matHand[2][index] = i;
				if(s == 'S')
					matHand[3][index] = i;
			
			}
			i++;
		}
	}
	
	public String result(Player player, int betSize, Payout payout)
	{
		result = 11;
		this.isEqualRank();
		this.isFlush();
		this.isStraight();
		
		if(winningHands[result].equals("ROYAL FLUSH"))
		{
			Nb[8]++;
			if(betSize == 5)
				player.setBalance(4000);
			else
				payout.payment(player, betSize, 250);
		}
			
		else if(winningHands[result].equals("STRAIGHT FLUSH"))
		{
			Nb[7]++;
			payout.payment(player, betSize, 50);
		}
			
		else if(winningHands[result].equals("FOUR ACES"))
		{
			Nb[6]++;
			payout.payment(player, betSize, 160);
		}
			
		
		else if(winningHands[result].equals("FOUR 2-4"))
		{
			Nb[6]++;
			payout.payment(player, betSize, 80);
		}
			
		else if(winningHands[result].equals("FOUR 5-K"))
		{
			Nb[6]++;
			payout.payment(player, betSize, 50);
		}
			
		else if(winningHands[result].equals("FULL HOUSE"))
		{
			Nb[5]++;
			payout.payment(player, betSize, 10);
		}
			
		else if(winningHands[result].equals("FLUSH"))
		{
			Nb[4]++;
			payout.payment(player, betSize, 7);
		}
			
		else if(winningHands[result].equals("STRAIGHT"))
		{
			Nb[3]++;
			payout.payment(player, betSize, 5);
		}
			
		else if(winningHands[result].equals("THREE OF A KIND"))
		{
			Nb[2]++;
			payout.payment(player, betSize, 3);
		}
			
		else if(winningHands[result].equals("TWO PAIR"))
		{
			Nb[1]++;
			payout.payment(player, betSize, 1);
		}	
		else if(winningHands[result].equals("JACKS OR BETTER"))
		{
			Nb[0]++;
			payout.payment(player, betSize, 1);
		}
		else
		{
			Nb[9]++;
		}
		Nb[10]++;
		
		return winningHands[result];
	}

	public void isStraight() 
	{
		int straight_flush = 0;
		int straight = 0;
		for(int i = 0; i < 4; i++)
		{
			straight_flush = 0;
			straight = 0;
			for(int j = 0; j < 13; j++)
			{
				if(j == 0 && matHand[i][12] != 0)
					straight_flush++;
				if(matHand[i][j] != 0)
					straight_flush++;
				else
					straight_flush = 0;
				
				if(j == 0 && sumCol(12) == 1 && i == 0)
					straight++;
				if(sumCol(j) == 1 && i == 0)
					straight++;
				else
					straight = 0;
				
				if(straight_flush == 5 && result > 1)
					result = 1;
				else if(straight == 5 && result > 7)
					result = 7;
			}
		}
	}

	public void isFlush() 
	{
		for(int i = 0; i < 4; i++)
		{
			if(sumRow(matHand[i], 8, 5) == 5 && result > 0)
				result = 0;
			else if(sumRow(matHand[i], 0, 13) == 5 && result > 6)
				result = 6;
		}
	}
	


	public void isEqualRank() 
	{
		int i = 0;
		int j = -1;
		int sum = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		for(i = 0; i < 13; i++)
		{
			sum = sumCol(i);
			if(sum == 4)
				break;
			else if(sum == 3)
				cnt3 = 1;
			else if(sum == 2)
			{
				cnt2++;
				j = i;
			}
		}
		
		if(i == 12 && sum == 4 && result > 2)
			result = 2;
		else if(i < 3 && sum == 4 && result > 3)
			result = 3;
		else if(i >= 3 && sum == 4 && result > 4)
			result = 4;
		else if(cnt3 == 1)
		{
			if(cnt2 == 1 && result > 5)
				result = 5;
			else if(result > 8)
				result = 8;
		 }
		 else if(cnt2 == 2 && result > 9)
			 result = 9;
		 else if(cnt2 == 1 && j > 8 && result > 10)
			 result = 10;
	}
	
	public void Statistics(Player player)
	{
		Nb[11] = player.getBalance();
		float earnings = player.getEarnings();
		float wagered = player.getWagered();
		float final_percent = (earnings/ wagered) * 100;
		int nDigits = -3;
		int biggestNumber = Nb[10];
		
		while(biggestNumber != 0)
		{
			biggestNumber /= 10;
			nDigits++;
		}
			
		System.out.println();
		System.out.println("  "+"Hand                             Nb");
		System.out.print("  "+"------------------------------------");for(int i = 0; i < nDigits; i++)System.out.print("-");System.out.println("");
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
		System.out.print("  "+"------------------------------------");for(int i = 0; i < nDigits; i++)System.out.print("-");System.out.println("");
		System.out.println("  "+"Total                            "+Nb[10]+"");
		System.out.print("  "+"------------------------------------");for(int i = 0; i < nDigits; i++)System.out.print("-");System.out.println("");
		System.out.println("  "+"Credit                 "+Nb[11]+"("+String.format("%.1f", final_percent)+"%)");
	}


	public int sumRow(int[] array, int index, int length) {
		int result = 0;
		for(int i = index; i < index + length; i++)
		{
			if(array[i] > 0) 
				result++;
		}
			
		return result;
	}


	public int sumCol(int col) {
		int result = 0;
		for(int i = 0; i < 4; i++)
		{
			if(matHand[i][col] > 0)
				result++;
		}
			
		return result;
	}
}