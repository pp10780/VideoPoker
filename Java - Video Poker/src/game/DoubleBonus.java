package game;

import card.Card;
import player.*;

public class DoubleBonus {

	protected int[][] matHand;
	private String[] winningHands;
	private int result;
	// matHand
	//	2	3	4	5	6	7	8	9	10	J Q K A
	//H : 0
	//D : 1
	//C : 2
	//S : 3
	public DoubleBonus(Hand hand) {
		matHand = new int[4][13];
		fill_matrix(hand);
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

	public void fill_matrix(Hand hand) {
		char s;
		int i = 1;
		int index = 0;
		
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
	
	public String result()
	{
		this.isEqualRank();
		this.isFlush();
		this.isStraight();
		//System.out.println("Result -> " + winningHands[result]);
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


	protected int sumRow(int[] array, int index, int length) {
		int result = 0;
		for(int i = index; i < index + length; i++)
		{
			if(array[i] > 0) 
				result++;
		}
			
		return result;
	}


	protected int sumCol(int col) {
		int result = 0;
		for(int i = 0; i < 4; i++)
		{
			if(matHand[i][col] > 0)
				result++;
		}
			
		return result;
	}
}