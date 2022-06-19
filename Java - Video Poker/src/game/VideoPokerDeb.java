package game;

import dealer.DealerDeb;

public class VideoPokerDeb extends VideoPoker{

	private DealerDeb dealer;
	private String[] cmd;
	
	public VideoPokerDeb(int credit, String[] cards, String[] cmd_line, Variant gameVariant, Payout payVariant) {
		super(credit, gameVariant, payVariant);
		betSize = 5;
		dealer = new DealerDeb(cards);
		cmd = cmd_line;
		
	}

	public void initGame() {
		int value = 0, pos = 0, l;
		String result;
		int[] pos_arr;
		int cnt;
		
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
				dealer.deal(player);
				System.out.println("player's hand " + player.getHand());
			}
			else if(cmd[i].equals("b"))
			{
				System.out.print("-cmd " + cmd[i] + " ");
				if(Character.isDigit(cmd[i+1].toCharArray()[0]))
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
				pos_arr = new int[5];
				System.out.print("-cmd " + cmd[i] + " ");
				while(Character.isDigit(cmd[i+1].toCharArray()[0]))
				{
					pos = Integer.parseInt(cmd[i+1]);
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
				dealer.draw(player, cnt);
				
				currentHand.computeHand(player.getHand());
				
				result = currentHand.result(player, betSize, payout);
				
				if(!result.equals("NONE"))
					System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
				else
					System.out.println("player loses and his credit is " + player.getBalance());
				
				//Discard hand
				player.getHand().emptyHand();
				
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
	}

	public void bet(int value) {
		if(value != -1)
			betSize = value;
		
		System.out.println("player is betting " + betSize);
		player.bet(betSize);
			
	}
}