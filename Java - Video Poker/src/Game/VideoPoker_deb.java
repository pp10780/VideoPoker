package Game;

import Dealer.Dealer_deb;
import Player.Player;

public class VideoPoker_deb implements VideoPoker{

	private Dealer_deb dealer;
	private Player player;
	private int previous_bet;
	private Strategy final_hand;
	private PerfectStrategy first_hand;
	
	
	public VideoPoker_deb(int credit, String[] cards) {
		player = new Player(credit);
		dealer = new Dealer_deb(cards);
		previous_bet = -1;
		final_hand = new Strategy();
	}

	public void execute_cmd(String[] cmd) {
		int value = 0, pos = 0, l;
		int[] pos_arr;
		int deb_cnt = 1;
		for(int i = 0; i < cmd.length; i++)
		{
			
			System.out.println("");
			if(cmd[i].equals("$"))
			{
				System.out.println("-cmd " + cmd[i]);
				credit();
			}
			else if(cmd[i].equals("d"))
			{
				System.out.println(deb_cnt++);
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
			else if(cmd[i].equals("a"))
			{
				System.out.println("-cmd " + cmd[i]);
				System.out.print("player should hold cards ");
				pos_arr = new int[5];
				first_hand = new PerfectStrategy();
				first_hand.fill_matrix(player.getHand());
				
				pos_arr = first_hand.decision(player.getHand());
				for(l = 0; l < pos_arr.length; l++)
				{
					if(pos_arr[l] == 1)
						System.out.print(l + 1 + " ");
				}
				System.out.println("");
			}
			else
			{
				System.out.println("Invalid Command! -> " + cmd[i]);
			}
		}
	}
	
	public void payment(String result)
	{
		if(result.equals("ROYAL FLUSH"))
		{
			if(player.getHand().getBetSize() == 5)
				player.setBalance(4000);
			else
				player.setBalance(player.getHand().getBetSize()*250);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("STRAIGHT FLUSH"))
		{
			player.setBalance(player.getHand().getBetSize()*50);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("FOUR ACES"))
		{
			player.setBalance(player.getHand().getBetSize()*160);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		
		else if(result.equals("FOUR 2–4"))
		{
			player.setBalance(player.getHand().getBetSize()*80);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("FOUR 5–K"))
		{
			player.setBalance(player.getHand().getBetSize()*50);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("FULL HOUSE"))
		{
			player.setBalance(player.getHand().getBetSize()*10);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("FLUSH"))
		{
			player.setBalance(player.getHand().getBetSize()*7);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("STRAIGHT"))
		{
			player.setBalance(player.getHand().getBetSize()*5);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("THREE OF A KIND"))
		{
			player.setBalance(player.getHand().getBetSize()*3);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("TWO PAIR"))
		{
			player.setBalance(player.getHand().getBetSize()*1);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}	
		else if(result.equals("JACKS OR BETTER"))
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