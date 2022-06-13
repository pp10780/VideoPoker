package Game;

import Dealer.Dealer_deb;
import Player.Player;

public class VideoPoker_deb implements VideoPoker{

	private Dealer_deb dealer;
	private Player player;
	private int previous_bet;
	
	
	public VideoPoker_deb(int credit, String[] cards) {
		player = new Player(credit);
		dealer = new Dealer_deb(cards);
		previous_bet = -1;
	}

	public void execute_cmd(String[] cmd) {
		int value = 0, pos = 0;
		int[] pos_arr;
		for(int i = 0; i < cmd.length; i++)
		{
			System.out.println("");
			//System.out.println("----------->   -cmd " + cmd[i]);
			if(cmd[i].equals("$"))
			{
				System.out.println("-cmd " + cmd[i]);
				credit();
			}
			else if(cmd[i].equals("d"))
			{
				System.out.println("-cmd " + cmd[i]);
				deal();
			}
			else if(cmd[i].equals("b"))
			{
				System.out.print("-cmd " + cmd[i] + " ");
				if(Character.isDigit(cmd[i+1].toCharArray()[0]))
				{
					value = Integer.parseInt(cmd[i+1]);
					i+=1;
					System.out.println(value);
					if(value > 5 || value < 1)
					{
						System.out.println("b: illegal amount");
					}
					else
					{
						bet(value);
					}
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
				hold(pos_arr);
				result();
			}
			else
			{
				System.out.println("Invalid Command! -> " + cmd[i]);
			}
		}
	}
	
	public void result()
	{
		Strategy final_hand = new Strategy();
		int result = 11;
		int c;
		final_hand.fill_matrix(player.getHand());
		
		result = final_hand.isRest();
		
		if(result == 11)
		{
			result = final_hand.isFlush();
			
			if((c = final_hand.isStraight()) < result)
				result = c;
		}
		
		payment(result);
		
		
		for(int j = 4; j >= 0; j--)
		{
				player.getHand().getCards().remove();
		}
	}
	
	public void payment(int result)
	{
		if(result == 0)
		{
			if(player.getHand().getBetSize() == 5)
				player.setBalance(4000);
			else
				player.setBalance(player.getHand().getBetSize()*250);
			
			System.out.println("player wins with a ROYAL FLUSH and his credit is " + player.getBalance());
		}
			
		else if(result == 1)
		{
			player.setBalance(player.getHand().getBetSize()*50);
			
			System.out.println("player wins with a STRAIGHT FLUSH and his credit is " + player.getBalance());
		}
			
		else if(result == 2)
		{
			player.setBalance(player.getHand().getBetSize()*160);
			
			System.out.println("player wins with a FOUR ACES and his credit is " + player.getBalance());
		}
			
		
		else if(result == 3)
		{
			player.setBalance(player.getHand().getBetSize()*80);
			
			System.out.println("player wins with a FOUR 2-4 and his credit is " + player.getBalance());
		}
			
		else if(result == 4)
		{
			player.setBalance(player.getHand().getBetSize()*50);
			
			System.out.println("player wins with a FOUR 5-K and his credit is " + player.getBalance());
		}
			
		else if(result == 5)
		{
			player.setBalance(player.getHand().getBetSize()*10);
			
			System.out.println("player wins with a FULL HOUSE and his credit is " + player.getBalance());
		}
			
		else if(result == 6)
		{
			player.setBalance(player.getHand().getBetSize()*7);
			
			System.out.println("player wins with a FLUSH and his credit is " + player.getBalance());
		}
			
		else if(result == 7)
		{
			player.setBalance(player.getHand().getBetSize()*5);
			
			System.out.println("player wins with a STRAIGHT and his credit is " + player.getBalance());
		}
			
		else if(result == 8)
		{
			player.setBalance(player.getHand().getBetSize()*3);
			
			System.out.println("player wins with a THREE OF A KIND and his credit is " + player.getBalance());
		}
			
		else if(result == 9)
		{
			player.setBalance(player.getHand().getBetSize()*1);
			
			System.out.println("player wins with a TWO PAIR and his credit is " + player.getBalance());
		}	
		else if(result == 10)
		{
			player.setBalance(player.getHand().getBetSize()*1);
			
			System.out.println("player wins with a JACKS OR BETTER and his credit is " + player.getBalance());
		}
		else
			System.out.println("player loses and his credit is " + player.getBalance());
	}

	private void bet(int value) {
		if(value == -1)
		{
			if (previous_bet == -1)
			{
				System.out.println("player is betting 5");
				player.bet(5);
			}
			else
			{
				System.out.println("player is betting " + previous_bet);
				player.bet(previous_bet);
			}
		}
		else
		{
			System.out.println("player is betting " + value);
			player.bet(value);
			previous_bet = value;
		}
			
	}

	private void credit() {
		System.out.println("player's credit is " + player.getBalance());
	}

	private void deal() {
		dealer.deal(player);
		System.out.println("player's hand " + player.getHand());
	}

	private void hold(int[] cards) {
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
		System.out.println("player's hand " + player.getHand());

	}
	
	

}