package game;

import dealer.DealerDeb;

/**
 * Subclass of VideoPoker, represents the debug game mode 
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 */
public class VideoPokerDeb extends VideoPoker{

	private DealerDeb dealer;
	private String[] cmd;
	private int nCards;
	
	/**
	 * Constructor of VideoPokerDeb that receives as argument the initial balance of the player, what was read from the card file, what was read from the command file, the game variant, e.g Double Bonus and the payout variant, e.g 10/7
	 * 
	 * @param credit initial balance of the player
	 * @param cards array that contains the strings - cards - read from the card file
	 * @param cmd_line array that contains the strings - commands - read from the command file 
	 * @param gameVariant game variant
	 * @param payVariant payout variant
	 */
	public VideoPokerDeb(int credit, String[] cards, String[] cmd_line, Variant gameVariant, Payout payVariant) {
		super(credit, gameVariant, payVariant);
		betSize = 5;
		dealer = new DealerDeb(cards);
		cmd = cmd_line;
		nCards = cards.length;
		
	}
	
	/**
	 * Implements the abstract method initGame from VideoPoker: initiates the game, executes each command until the end of the command array
	 */
	public void initGame() {
		int value = 0, pos = 0, l;
		String result;
		int[] pos_arr;
		int cnt;
		
		if(nCards < 5)
		{
			System.out.println("Not Enough Cards in the Card File!");
			System.exit(0);
		}
		for(int i = 0; i < cmd.length; i++)
		{
			System.out.println("");
			if(cmd[i].equals("$"))
			{
				System.out.println("-cmd " + cmd[i]);
				System.out.println("player's credit is " + player.getBalance());
			}
			else if(cmd[i].equals("d"))
			{
				System.out.println("-cmd " + cmd[i]);
				
				if(nCards >= 5)
				{
					dealer.deal(player);
					nCards-=5;
				}
				else
				{
					System.out.println("Not enough cards left to deal a new hand!");
				}
				
				
				System.out.println("player's hand " + player.getHand());
			}
			else if(cmd[i].equals("b"))
			{
				System.out.print("-cmd " + cmd[i] + " ");
				if(i == cmd.length - 1)
				{
					System.out.println("");
					bet(-1);
				}
				else if(Character.isDigit(cmd[i+1].toCharArray()[0]) && i != cmd.length - 1)
				{
					value = Integer.parseInt(cmd[i+1]);
					System.out.println(value);
					if(value > 5 || value < 1)
						System.out.println("b: illegal amount");
					else
						bet(value);
					i++;
				}
				else
				{
					System.out.println("");
					bet(-1);
				}
			}
			else if(cmd[i].equals("h"))
			{
				if(player.getHand().getCards().size() != 5)
				{
					System.out.println("Player has less than 5 cards in its hand");
					continue;
				}
				pos_arr = new int[5];
				System.out.print("-cmd " + cmd[i] + " ");
				
				if(i != cmd.length - 1)
				{
					while(Character.isDigit(cmd[i+1].toCharArray()[0]))
					{
						try {
							pos = Integer.parseInt(cmd[i+1]);
						} catch(NumberFormatException e)
						{
							i++;
							if(i == cmd.length - 1)
								break;
							continue;
						}
						System.out.print(pos + " ");
						if(pos > 5 || pos < 1)
						{
							System.out.println("Invalid Cards!");
						}
						else
						{
							pos_arr[pos - 1] = 1;
						}
						i++;
						if(i == cmd.length - 1)
							break;
					}
					System.out.println("");
					cnt = player.discard(pos_arr, dealer);
					if(nCards >= cnt)
					{
						dealer.draw(player, cnt);
						currentHand.computeHand(player.getHand());
						
						result = currentHand.result(player, betSize, payout);
						
						if(!result.equals("NONE"))
							System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
						else
							System.out.println("player loses and his credit is " + player.getBalance());
						
						//Discard hand
						player.getHand().emptyHand();
						
						nCards-=cnt;
					}
					else
					{
						System.out.println();
						System.out.println("Not enough cards left!");
					}
				
					
				}
				else
				{
					System.out.println();
					System.out.println("Not enough cards left!");
				}
				
			}
			else if(cmd[i].equals("a"))
			{
				System.out.println("-cmd " + cmd[i]);
				System.out.print("player should hold cards ");
				
				currentHand.computeHand(player.getHand());
				pos_arr = currentHand.perfectStrategy(player.getHand());
				for(l = 0; l < pos_arr.length; l++)
				{
					if(pos_arr[l] == 1)
						System.out.print(l + 1 + " ");
				}
				System.out.println("");
			}
			else if(cmd[i].equals("s"))
			{
				System.out.println("-cmd " + cmd[i]);
				currentHand.Statistics(player);
			}
			else
			{
				System.out.println("Invalid Command! -> " + cmd[i]);
			}
		}
		System.out.println();
		System.out.println("End of Debug Mode");
	}
	
	/**
	 * Places a bet by deciding with which bet size to call the bet method from Player
	 * @param value value of the bet size, if value = -1 keep previous bet size, if not update the bet size with value
	 */
	public void bet(int value) {
		if(value != -1)
			betSize = value;
		
		System.out.println("player is betting " + betSize);
		player.bet(betSize);
			
	}
}