package game;

import card.Card;
import player.*;

public class PerfectStrategy {
	
	private DoubleBonus doubleBonus;
	private int flushSuit;
	private int straightBeg;
	private int eqRank;
	private int eqRank2;
	private int resultStrat;
	private Hand hand;
	
	public PerfectStrategy(Hand _hand) {
		doubleBonus = new DoubleBonus();
		doubleBonus.computeHand(_hand);
		hand = _hand;
		eqRank = -1;
		eqRank2 = -1;
		flushSuit = -1;
		straightBeg = -1;
		resultStrat = 34;
	}

	public int[] decision() {
		int[] holdCards = new int[5];
		int[] suits = new int[] {'H', 'D', 'C', 'S'};
		int[] ranks = new int[] {'2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'};
		int aceException = 0;
		int acePos;
		int i = 0;
		
		this.isUnsuited();
		this.isSuited();
		this.isEqualRank();
		this.isFlush();
		this.isStraight();
		//System.out.println("Strat -> " + resultStrat);
		if(resultStrat == 1 || resultStrat == 4)
		{
			for(i = 0; i < 5; i++)
				holdCards[i] = 1;
		}
		else if(resultStrat == 2 || resultStrat == 10)
		{
			for(Card card: hand.getCards())
			{
				if((card.getRank() == 'A' || card.getRank() == 'K' || card.getRank() == 'Q' || card.getRank() == 'J' || card.getRank() == 'T') && card.getSuit() == suits[flushSuit])
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 3 || resultStrat == 29)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'A')
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 5 || resultStrat == 8 || resultStrat == 12)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == ranks[eqRank])
					holdCards[i] = 1;
				i++;
			}	
		}
		else if(resultStrat == 6 || resultStrat == 14 || resultStrat == 20 || resultStrat == 27)
		{
			for(i = straightBeg; i < straightBeg + 5; i++)
			{
				if(doubleBonus.matHand[flushSuit][i] != 0)
				{
					holdCards[doubleBonus.matHand[flushSuit][i] - 1] = 1;
				}
				if(i == 0 && doubleBonus.matHand[flushSuit][12] != 0)
				{
					holdCards[doubleBonus.matHand[flushSuit][12] - 1] = 1;
				}
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
		else if(resultStrat == 9 || resultStrat == 17 || resultStrat == 18 || resultStrat == 25 || resultStrat == 33)
		{
			for(Card card: hand.getCards())
			{
				if(card.getSuit() == suits[flushSuit])
					holdCards[i] = 1;
				i++;
			}
		}
		else if(resultStrat == 11)
		{	
			for(Card card: hand.getCards())
			{
				for(int j = straightBeg; j < straightBeg + 5; j++)
				{
					if(card.getRank() == ranks[j])
					{
						holdCards[i] = 1;
						ranks[j] = '-';
					}		
				}
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
		else if(resultStrat == 15 || resultStrat == 19 || resultStrat == 21 || resultStrat == 32)
		{
			if(straightBeg == 0 && (acePos = doubleBonus.sumCol(12)) != 0)
			{
				aceException = 1;
				holdCards[acePos] = 1;
			}
			for(Card card: hand.getCards())
			{
				for(int j = straightBeg; j < straightBeg + 5 - aceException; j++)
				{
					if(card.getRank() == ranks[j])
					{
						holdCards[i] = 1;
						ranks[j] = '-';
					}
						
				}
				i++;
			}	
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
		else if(resultStrat == 26)
		{
			for(Card card: hand.getCards())
			{
				if(card.getRank() == 'Q' || card.getRank() == 'T')
					holdCards[i] = 1;
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
		
		return holdCards;
	}
	public void isStraight() {
		int straight = 0;
		int straight_flush = 0;
		int aceException = 0;
		int nHC = 0;
		int nGaps = 0;
		
		for(int i = 0; i < 4; i++)
		{
			for(int j = -1; j < 9; j++)
			{
				nHC = 0;
				straight_flush = 0;
				straight = 0;
				if(j == -1)
				{
					aceException = 1;
					if(doubleBonus.matHand[i][12] != 0)
						straight_flush++;
					straight_flush += doubleBonus.sumRow(doubleBonus.matHand[i], 0, 4);
					
					if(doubleBonus.sumCol(12) != 0)
						straight++;
					for(int k = 0; k < 4; k++)
					{
						if(doubleBonus.sumCol(k) != 0)
							straight++;
					}
				}
				else
				{
					aceException = 0;
					straight_flush += doubleBonus.sumRow(doubleBonus.matHand[i], j, 5);
				
					for(int k = 0; k < 5; k++)
					{
						if(doubleBonus.sumCol(j + k) != 0)
							straight++;
					}
				}
				
				if(straight_flush == 5)
				{
					if(resultStrat > 1)
					{
						resultStrat = 1;
					}
				}
				if(straight == 5)
				{
					if(resultStrat > 4)
					{
						resultStrat = 4;
					}
				}	
				if(straight_flush == 4)
				{
					if(resultStrat > 6)
					{
						straightBeg = j + aceException;
						flushSuit = i;
						resultStrat = 6;
					}
				}
				if(straight == 4)
				{
					int ace = j + aceException;
					nGaps = gapCounterCol(j + aceException);
					if(aceException != 0)
						ace = 12;
					if(((doubleBonus.sumCol(ace) != 0 && (doubleBonus.sumCol(j  + aceException + 4)) == 0) || (doubleBonus.sumCol(ace) == 0  &&(doubleBonus.sumCol(j  + aceException + 4)) != 0)) && j + aceException + 4 != 12 && nGaps == 0)
					{
						if(resultStrat > 11)
						{
							straightBeg = j + aceException;
							resultStrat = 11;
						}
					}		
					else if((doubleBonus.sumCol(j + aceException) != 0 && doubleBonus.sumCol(j + aceException + 4) != 0) || (j + aceException == 0 && doubleBonus.sumCol(12) > 0 && doubleBonus.sumCol(j + aceException + 4) == 0) || (j + aceException == 8 && doubleBonus.sumCol(12) > 0 && doubleBonus.sumCol(j + aceException) == 0))
					{
						
						nHC = 0;
						for(int l = j + aceException; l < j + aceException + 5; l++)
						{
							if(isHighCard(l))
								nHC++;
						}
						if(nHC == 3 && resultStrat > 15)
						{
							straightBeg = j + aceException;
							resultStrat = 15;
						}
						if(nHC == 2 && resultStrat > 19)
						{
							straightBeg = j + aceException;
							resultStrat = 19;
						}	
						if(nHC == 1 && resultStrat > 21)
						{
							straightBeg = j + aceException;
							resultStrat = 21;
						}
							
						if(nHC == 0 && resultStrat > 32)
						{
							straightBeg = j + aceException;
							resultStrat = 32;
						}
							
					}
				}
				if(straight_flush == 3)
				{
					nHC = highcardCounter(i);
					nGaps = gapCounter(i, j + aceException);
					if(nHC >= nGaps && resultStrat > 14)
					{
						straightBeg = j + aceException;
						flushSuit = i;
						resultStrat = 14;
					}
					else if(((nGaps == 1) || (nGaps == 2 && nHC == 1) || (j == -1 && doubleBonus.matHand[i][12] != 0) || (doubleBonus.matHand[i][0] != 0 && doubleBonus.matHand[i][1] != 0 &&  doubleBonus.matHand[i][2] != 0)) && resultStrat > 20)
					{
						straightBeg = j + aceException;
						flushSuit = i;
						resultStrat = 20;
					}
						
					else if(nGaps == 2 && nHC == 0 && resultStrat > 27)
					{
						straightBeg = j + aceException;
						flushSuit = i;
						resultStrat = 27;
					}
						
				}
			}
		}
	}
	
	public void isFlush() {
		int RF = 0, F = 0, n_HC = 0;
		for(int i = 0; i < 4; i++)
		{
			RF = doubleBonus.sumRow(doubleBonus.matHand[i], 8, 5);
			F = doubleBonus.sumRow(doubleBonus.matHand[i], 0, 13);
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
			sum = doubleBonus.sumCol(i);
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
		int suitedHC = -1;
		int nHC = -1;
		for(int i = 0; i < 4; i++)
		{
			if(nHC != 2)
			{
				nHC = highcardCounter(i);
				suitedHC = i;
			}
			for(int j = 8; j < 13; j++)
			{
				if(doubleBonus.matHand[i][j] != 0)
					highCards[j - 8] = i;
			}
		}
		
		if(highCards[1] == highCards[2] && resultStrat > 16)
		{
			flushSuit = highCards[1];
			resultStrat = 16;
		}	
		else if(nHC == 2 && resultStrat > 18)
		{
			flushSuit = suitedHC;
			resultStrat = 18;
		}
		else if(highCards[0] == highCards[1] && resultStrat > 23)
		{
			flushSuit = highCards[1];
			resultStrat = 23;
		}
			
		else if(highCards[0] == highCards[2] && resultStrat > 26)
		{
			flushSuit = highCards[0];
			resultStrat = 26;
		}
			
		else if(highCards[0] == highCards[3] && resultStrat > 30)
		{
			flushSuit = highCards[0];
			resultStrat = 30;	
		}
			
	}
	
	public void isUnsuited()
	{
		int[] highCards = new int[]{-4, -3, -2, -1}; // J, Q, K, A

		for(int j = 9; j < 13; j++)
		{
			if(doubleBonus.sumCol(j) == 1)
				highCards[j - 9] = 1;
		}
		if(doubleBonus.sumRow(highCards, 0, 4) == 4 && resultStrat > 13)
			resultStrat = 13;
		else if(doubleBonus.sumRow(highCards, 0, 3) == 3 && resultStrat > 22)
			resultStrat = 22;
		else if(doubleBonus.sumRow(highCards, 0, 2) == 2 && resultStrat > 24)
			resultStrat = 24;
		else if((doubleBonus.sumRow(highCards, 1, 2) == 2 || highCards[0] == highCards[2]) && resultStrat > 28)
			resultStrat = 28;
		else if(highCards[3] == 1 && resultStrat > 29)
			resultStrat = 29;
		else if((highCards[0] == 1 || highCards[1] == 1|| highCards[2] == 1) && resultStrat > 31)
			resultStrat = 31;

	}
	
	private int highcardCounter(int row)
	{
		return doubleBonus.sumRow(doubleBonus.matHand[row], 9, 4);
	}
	
	private boolean isHighCard(int col)
	{
		if(col < 9)
			return false;
		
		return doubleBonus.sumCol(col) > 0 ? true : false;
	}
	
	private int gapCounter(int row, int col)
	{
		int nGaps = 0;
		for(int i = col + 1; i < col+4; i++)
		{
			if(doubleBonus.matHand[row][i] == 0)
				nGaps++;
		}
		return nGaps;
	}

	private int gapCounterCol(int col)
	{
		int nGaps = 0;
		for(int i = col + 1; i < col+4; i++)
		{
			if(doubleBonus.sumCol(i) == 0)
				nGaps++;
		}
		return nGaps;
	}
}