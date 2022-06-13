package Game;

import java.util.Arrays;

import Dealer.Dealer_deb;
import Player.Player;

public class VideoPoker_deb implements VideoPoker{

	private Dealer_deb dealer;
	private Player player;
	private int previous_bet;
	private Strategy final_hand;
	
	
	public VideoPoker_deb(int credit, String[] cards) {
		player = new Player(credit);
		dealer = new Dealer_deb(cards);
		previous_bet = -1;
		final_hand = new Strategy();
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
				
				final_hand = new Strategy();
				final_hand.fill_matrix(player.getHand());
				
				payment(final_hand.result());
				
				//Discard hand
				for(int j = 4; j >= 0; j--)
				{
						player.getHand().getCards().remove();
				}
				
			}
			else
			{
				System.out.println("Invalid Command! -> " + cmd[i]);
			}
		}
	}
	
	public void payment(String result)
	{
		if(result.equals("Royal Flush"))
		{
			if(player.getHand().getBetSize() == 5)
				player.setBalance(4000);
			else
				player.setBalance(player.getHand().getBetSize()*250);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("Straight Flush"))
		{
			player.setBalance(player.getHand().getBetSize()*50);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("Four Aces"))
		{
			player.setBalance(player.getHand().getBetSize()*160);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		
		else if(result.equals("Four 2�4"))
		{
			player.setBalance(player.getHand().getBetSize()*80);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("Four 5�K"))
		{
			player.setBalance(player.getHand().getBetSize()*50);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("Full House"))
		{
			player.setBalance(player.getHand().getBetSize()*10);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("Flush"))
		{
			player.setBalance(player.getHand().getBetSize()*7);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("Straight"))
		{
			player.setBalance(player.getHand().getBetSize()*5);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("Three of a Kind"))
		{
			player.setBalance(player.getHand().getBetSize()*3);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("Two Pair"))
		{
			player.setBalance(player.getHand().getBetSize()*1);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}	
		else if(result.equals("Jacks or Better"))
		{
			player.setBalance(player.getHand().getBetSize()*1);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
		else
			System.out.println("player loses and his credit is " + player.getBalance());
	}

	public void bet(int value) {
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

	public void credit() {
		System.out.println("player's credit is " + player.getBalance());
	}

	public void deal() {
		dealer.deal(player);
		System.out.println("player's hand " + player.getHand());
	}

	public void hold(int[] cards) {
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