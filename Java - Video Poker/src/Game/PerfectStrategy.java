package Game;

import Card.Card;
import Player.*;

public class PerfectStrategy extends Strategy {
	
	private int flushSuit;
	private int straightBeg;
	private int eqRank;
	private int eqRank2;
	private int resultStrat;
	
	public PerfectStrategy() {
		super();
		eqRank = -1;
		eqRank2 = -1;
		flushSuit = -1;
		straightBeg = -1;
		resultStrat = 34;
	}

	public int[] decision(Hand hand) {
		int[] holdCards = new int[5];
		int[] suits = new int[] {'H', 'D', 'C', 'S'};
		int[] ranks = new int[] {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
		int i = 0;
		
		this.isUnsuited();
		this.isSuited();
		this.isEqualRank();
		this.isFlush();
		this.isStraight();
		
		if(resultStrat == 1)
		{
			for(i = 0; i < 4; i++)
				holdCards[i] = 1;
		}
		else if(resultStrat == 2)
		{
			for(Card card: hand.getCards())
			{
				if((card.getRank() == 'A' || card.getRank() == 'K' || card.getRank() == 'Q' || card.getRank() == 'J' || card.getRank() == 'T') && card.getSuit() == suits[flushSuit])
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 3)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'A')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 4)
		{
			for(i = 0; i < 4; i++)
				holdCards[i] = 1;
		}
		else if(resultStrat == 5)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == ranks[eqRank])
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 6)
		{
			for(i = straightBeg; i < 5; i++)
			{
				if(mat_hand[flushSuit][i] != 0)
				{
					holdCards[mat_hand[flushSuit][i] - 1] = 1;
				}
				i++;
			}
		}
		else if(resultStrat == 7)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == ranks[eqRank] || card.getRank() == ranks[eqRank2])
					holdCards[i] = 1;
				i++;
			}
		}
		else if(resultStrat == 8)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == ranks[eqRank])
					holdCards[i] = 1;
				i++;
			}
		}
		else if(resultStrat == 9)
		{
			for(Card card: hand.getCards())
			{
				if(card.getSuit() == suits[flushSuit])
					holdCards[i] = 1;
				i++;
			}
		}
		else if(resultStrat == 10)
		{
			for(Card card: hand.getCards())
			{
				if((card.getRank() == 'A' || card.getRank() == 'K' || card.getRank() == 'Q' || card.getRank() == 'J' || card.getRank() == 'T') && card.getSuit() == suits[flushSuit])
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 11)
		{
			
		}
		else if(resultStrat == 12)
		{
			
			for(Card card: hand.getCards())
			{
				if(card.getRank() == ranks[eqRank])
					holdCards[i] = 1;
				i++;
			}
			
		}
		else if(resultStrat == 13)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'A' || card.getRank() == 'K' || card.getRank() == 'Q' || card.getRank() == 'J')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 14)
		{
			for(i = straightBeg; i < 5; i++)
			{
				if(mat_hand[flushSuit][i] != 0)
				{
					holdCards[mat_hand[flushSuit][i] - 1] = 1;
				}
				i++;
			}
		}
		else if(resultStrat == 15)
		{
			
		}
		else if(resultStrat == 16)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'Q' || card.getRank() == 'J')
					holdCards[i] = 1;
				i++;
			}
		}
		else if(resultStrat == 17)
		{
			for(Card card: hand.getCards())
			{
				if(card.getSuit() == suits[flushSuit])
					holdCards[i] = 1;
				i++;
			}
		}
		else if(resultStrat == 18)
		{
			for(Card card: hand.getCards())
			{
				if(card.getSuit() == suits[flushSuit])
					holdCards[i] = 1;
				i++;
			}
		}
		else if(resultStrat == 19)
		{
			
		}
		else if(resultStrat == 20)
		{
			for(i = straightBeg; i < 5; i++)
			{
				if(mat_hand[flushSuit][i] != 0)
				{
					holdCards[mat_hand[flushSuit][i] - 1] = 1;
				}
				i++;
			}
		}
		else if(resultStrat == 21)
		{
			
		}
		else if(resultStrat == 22)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'K' || card.getRank() == 'Q' || card.getRank() == 'J')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 23)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'T' || card.getRank() == 'J')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 24)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'Q' || card.getRank() == 'J')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 25)
		{
			for(Card card: hand.getCards())
			{
				if(card.getSuit() == suits[flushSuit])
					holdCards[i] = 1;
				i++;
			}
		}
		else if(resultStrat == 26)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'Q' || card.getRank() == 'T')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 27)
		{
			for(i = straightBeg; i < 5; i++)
			{
				if(mat_hand[flushSuit][i] != 0)
				{
					holdCards[mat_hand[flushSuit][i] - 1] = 1;
				}
				i++;
			}
		}
		else if(resultStrat == 28)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'K' || card.getRank() == 'Q' || card.getRank() == 'J')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 29)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'A')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 30)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'K' || card.getRank() == 'T')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 31)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'K' || card.getRank() == 'Q' || card.getRank() == 'J')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 32)
		{
			
		}
		else if(resultStrat == 33)
		{
			for(Card card: hand.getCards())
			{
				if(card.getSuit() == suits[flushSuit])
					holdCards[i] = 1;
				i++;
			}
		}
		
		return holdCards;
	}
	@Override
	public void isStraight() {
		int straight = 0;
		int straight_flush = 0;
		int nHC = 0;
		int nGaps = 0;
		int resultStrat = 34;
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = 0; j < 9; j++)
			{
				nHC = 0;
				straight_flush = 0;
				straight = 0;
				if(j == 0 && mat_hand[i][12] != 0)
					straight_flush++;
					
				straight_flush = super.sumRow(mat_hand[i], j, 5);
				for(int k = 0; k < 5; k++)
				{
					if(j == 0 && super.sumCol(12) > 0)
						straight++;
					if(super.sumCol(j + k) != 0)
						straight++;
				}
				if(straight_flush == 5)
					if(resultStrat > 1)
					{
						resultStrat = 1;
					}
						
				else if(straight == 5)
					if(resultStrat > 4)
					{
						resultStrat = 4;
					}
						
				else if(straight_flush == 4)
					if(resultStrat > 6)
					{
						flushSuit = i;
						resultStrat = 6;
					}
						
				else if(straight == 4)
				{
					if((super.sumCol(j) == 0 || super.sumCol(j + 4) == 0) && j + 4 != 12)
						if(resultStrat > 11)
						{
							straightBeg = j;
							resultStrat = 11;
						}
							
					else if((super.sumCol(j) == 1 && super.sumCol(j + 4) == 1) || (j == 0 && super.sumCol(12) > 1 && super.sumCol(j + 4) == 0) || (j == 8 && super.sumCol(12) > 1 && super.sumCol(j) == 0))
					{
						nHC = 0;
						for(int l = 0; l < 4; l++)
							nHC += highcardCounter(l);
						if(nHC == 3 && resultStrat > 15)
						{
							straightBeg = j;
							resultStrat = 15;
						}
						if(nHC == 2 && resultStrat > 19)
						{
							straightBeg = j;
							resultStrat = 19;
						}	
						if(nHC == 1 && resultStrat > 21)
						{
							straightBeg = j;
							resultStrat = 21;
						}
							
						if(nHC == 0 && resultStrat > 32)
						{
							straightBeg = j;
							resultStrat = 32;
						}
							
					}
				}
				else if(straight_flush == 3)
				{
					nHC = highcardCounter(i);
					nGaps = gapCounter(i, j);
					if(nHC >= nGaps && resultStrat > 14)
					{
						straightBeg = j;
						flushSuit = i;
						resultStrat = 14;
					}
					else if((nGaps == 1 || (nGaps == 2 && nHC == 1) || (j == 0 && mat_hand[i][12] != 0) || (mat_hand[i][3] == 0 && j == 0 &&  mat_hand[i][12] == 0)) && resultStrat > 20)
					{
						straightBeg = j;
						flushSuit = i;
						resultStrat = 20;
					}
						
					else if(nGaps == 2 && nHC == 0 && resultStrat > 20)
					{
						straightBeg = j;
						flushSuit = i;
						resultStrat = 27;
					}
						
				}
			}
		}
	}
	
	@Override
	public void isFlush() {
		int RF = 0, F = 0, n_HC = 0;
		for(int i = 0; i < 4; i++)
		{
			RF = super.sumRow(super.mat_hand[i], 8, 5);
			F = super.sumRow(super.mat_hand[i], 0, 13);
			n_HC = highcardCounter(i);
			if(RF == 5 && resultStrat > 1)
			{
				resultStrat = 1;
			}
		
			else if(RF == 4 && resultStrat > 2)
			{
				flushSuit = i;
				resultStrat = 2;
			}
				
			else if(F == 5 && resultStrat > 4)
			{
				resultStrat = 4;
			}
				
			else if(F == 4 && resultStrat > 9)
			{
				flushSuit = i;
				resultStrat = 9;
			}
				
			else if(RF == 3 && resultStrat > 10)
			{
				flushSuit = i;
				resultStrat = 10;
			}
			else if(F == 3)
			{
				if(n_HC == 2 && resultStrat > 17)
				{
					flushSuit = i;
					resultStrat = 17;
				}
				else if(n_HC == 1 && resultStrat > 25)
				{
					flushSuit = i;
					resultStrat = 25;
				}
				else if(n_HC == 0 && resultStrat > 33)
				{
					flushSuit = i;
					resultStrat = 33;
				}
			}
		}
	}
	
	@Override
	public void isEqualRank() 
	{
		int i = 0;
		int[] j = new int[]{-1, -1};
		int isAce = -1;
		int sum = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		
		for(i = 0; i < 13; i++)
		{
			sum = sumCol(i);
			if(sum == 4 && resultStrat > 1)
				resultStrat = 1;
			else if(sum == 3)
			{
				cnt3 = 1;
				isAce = i;
			}
				
			else if(sum == 2)
			{
				cnt2++;
				
				if(j[0] != -1)
					j[1] = i;
				else
					j[0] = i;
			}
		}
		
		if(cnt3 == 1)
		{
			if(isAce == 12 && resultStrat > 3)
			{
				resultStrat = 3;
			}
			if(cnt2 == 1 && resultStrat > 4)
			{
				resultStrat = 4;
			}
			else if(resultStrat > 5)
			{
				eqRank = isAce;
				resultStrat = 5;
			}
		 }
		 else if(cnt2 == 2 && resultStrat > 7)
		 {
			 eqRank = j[0];
			 eqRank2 = j[1];
			 resultStrat = 7;
		 }
		 else if(cnt2 == 1 && j[0] > 8 && resultStrat > 8)
		 {
			 eqRank = j[0];
			 resultStrat = 8;
		 }
			
		 else if(cnt2 == 1 && j[0] <= 8 && resultStrat > 12)
		 {
			 eqRank = j[0];
			 resultStrat = 12;
		 }
			 
}
	
	public void isSuited()
	{
		int[] highCards = new int[]{-5, -4, -3, -2, -1}; // T, J, Q, K, A
		int nHC = -1;
		for(int i = 0; i < 4; i++)
		{
			if(nHC != 2)
				nHC = highcardCounter(i);
			for(int j = 8; j < 13; j++)
			{
				if(super.mat_hand[i][j] != 0)
					highCards[j - 8] = i;
			}
		}
		
		if(highCards[1] == highCards[2] && resultStrat > 16)
			resultStrat = 16;
		else if(nHC == 2 && resultStrat > 18)
			resultStrat = 18;
		else if(highCards[0] == highCards[1] && resultStrat > 23)
			resultStrat = 23;
		else if(highCards[0] == highCards[2] && resultStrat > 26)
			resultStrat = 26;
		else if(highCards[0] == highCards[3] && resultStrat > 30)
			resultStrat = 30;	
	}
	
	public void isUnsuited()
	{
		int[] highCards = new int[]{-4, -3, -2, -1}; // J, Q, K, A

		for(int j = 9; j < 13; j++)
		{
			if(super.sumCol(j) == 1)
				highCards[j - 8] = 1;
		}
		if(super.sumRow(highCards, 0, 4) == 4 && resultStrat > 13)
			resultStrat = 13;
		else if(super.sumRow(highCards, 0, 3) == 3 && resultStrat > 22)
			resultStrat = 22;
		else if(super.sumRow(highCards, 0, 2) == 2 && resultStrat > 24)
			resultStrat = 24;
		else if((super.sumRow(highCards, 1, 2) == 2 || highCards[0] == highCards[2]) && resultStrat > 28)
			resultStrat = 28;
		else if(highCards[3] == 1 && resultStrat > 29)
			resultStrat = 29;
		else if((highCards[0] == 1 || highCards[1] == 1|| highCards[2] == 1) && resultStrat > 31)
			resultStrat = 31;

	}
	
	public int highcardCounter(int row)
	{
		return super.sumRow(super.mat_hand[row], 9, 4);
	}
	
	public int gapCounter(int row, int col)
	{
		int nGaps = 0;
		
		for(int i = col + 1; i < col+4; i++)
		{
			if(mat_hand[row][i] == 0)
				nGaps++;
		}
		return nGaps;
	}

}