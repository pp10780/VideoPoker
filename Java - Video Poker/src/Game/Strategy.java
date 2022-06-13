package Game;

import java.util.Arrays;

import Card.Card;
import Player.*;

public class Strategy {

	protected int[][] mat_hand;
	private String[] winning_hands;
	// mat_hand
	//	2	3	4	5	6	7	8	9	10	J Q K A
	//H : 0
	//D : 1
	//C : 2
	//S : 3
	public Strategy() {
		mat_hand = new int[4][13];
		winning_hands = new String[]{"Royal Flush",
						 "Straight Flush",
				         "Four Aces",
						 "Four 2–4",
						 "Four 5–K",
						 "Full House",
						 "Flush",
						 "Straight",
						 "Three of a Kind",
						 "Two Pair",
						 "Jacks or Better",
						 "None"};
	}

	public void fill_matrix(Hand hand) {
		char s;
		int index = 0;
		
		for(Card c: hand.getCards())
		{
			s = c.getSuit();
			if(Character.isDigit(c.getRank()))
			{
				if(s == 'H')
					mat_hand[0][Character.getNumericValue(c.getRank())] = 1;
				else if(s == 'D')
					mat_hand[1][Character.getNumericValue(c.getRank())] = 1;
				else if(s == 'C')
					mat_hand[2][Character.getNumericValue(c.getRank())] = 1;
				else if(s == 'S')
					mat_hand[3][Character.getNumericValue(c.getRank())] = 1;
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
					mat_hand[0][index] = 1;
				if(s == 'D')
					mat_hand[1][index] = 1;
				if(s == 'C')
					mat_hand[2][index] = 1;
				if(s == 'S')
					mat_hand[3][index] = 1;
			}
		}
	}
	
	public String result()
	{
		int result = 11;
		int c;
		
		result = this.isRest();
		
		if(result == 11)
		{
			result = this.isFlush();
			
			if((c = this.isStraight()) < result)
				result = c;
		}
		return winning_hands[result];
	}
	
	//Royal Flush         - 0
	//Straight Flush      - 1
	//Four Aces           - 2
	//Four 2–4            - 3
	//Four 5–K            - 4
	//Full House          - 5
	//Flush               - 6
	//Straight            - 7
	//Three of a Kind     - 8
	//Two Pair            - 9
	//Jacks or Better     - 10

	public int isStraight() 
	{
		int straight_flush = 0;
		int straight = 0;
		for(int i = 0; i < 4; i++)
		{
			straight_flush = 0;
			straight = 0;
			for(int j = 0; j < 13; j++)
			{
				if(mat_hand[i][j] == 1)
					straight_flush++;
				else
					straight_flush = 0;
				
				if(sumCol(j) == 1 && i == 0)
					straight++;
				else
					straight = 0;
				
				if(straight_flush == 5)
					return 1;
				else if(straight == 5)
					return 7;
			}
		}
		return 11;
		
	}

	public int isFlush() 
	{
		for(int i = 0; i < 4; i++)
		{
			if(sumRow(mat_hand[i], 8, 5) == 5)
				return 0;
			else if(sumRow(mat_hand[i], 0, 13) == 5)
			{
				return 6;
			}
		}
		return 11;
	}
	


	public int isRest() 
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
		
		if(i == 12 && sum == 4)
			return 2;
		else if(i < 3 && sum == 4)
			return 3;
		else if(i >= 3 && sum == 4)
			return 4;
		else if(cnt3 == 1)
		{
			if(cnt2 == 1)
				return 5;
			else
				return 8;
		 }
		 else if(cnt2 == 2)
			 return 9;
		 else if(cnt2 == 1 && j > 8)
			 return 10;
		
		return 11; 
}


	protected int sumRow(int[] array, int index, int length) {
		int result = 0;
		for(int i = index; i < index + length; i++)
			result += array[i];
		return result;
	}


	protected int sumCol(int col) {
		int result = 0;
		for(int i = 0; i < 4; i++)
			result += mat_hand[i][col];
		return result;
	}

}