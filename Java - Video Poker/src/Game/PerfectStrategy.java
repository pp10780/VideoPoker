package Game;

import Player.*;

public class PerfectStrategy extends Strategy {

	public PerfectStrategy() {
		super();
	}

	public int[] decision(Hand hand) {
		int result = 34;
		int c;
		
		result = this.isRest();
		
		if((c = this.isFlush()) < result)
			result = c;
			
		if((c = this.isStraight()) < result)
				result = c;
		
		 
		
		
		return null;
	}
	@Override
	public int isStraight() {
		return 34;
	}
	
	@Override
	public int isFlush() {
		int RF = 0, F = 0, n_HC = 0;
		for(int i = 0; i < 4; i++)
		{
			RF = super.sumRow(super.mat_hand[i], 8, 5);
			F = super.sumRow(super.mat_hand[i], 0, 13);
			n_HC = highcardCounter(i);
			if(RF == 5)
				return 1;
			else if(RF == 4)
				return 2;
			else if(F == 5)
				return 4;
			else if(F == 4)
				return 9;
			else if(RF == 3)
				return 10;
			else if(F == 3)
			{
				if(n_HC == 2)
					return 17;
				else if(n_HC == 1)
					return 25;
				else if(n_HC == 0)
					return 33;
			}

		}
		return 34;

	}
	@Override
	public int isRest() {
		return 34;
	}
	
	public int highcardCounter(int row)
	{
		return super.sumRow(super.mat_hand[row], 9, 4);
	}

}