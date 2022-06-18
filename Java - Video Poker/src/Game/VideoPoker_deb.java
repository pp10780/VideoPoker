package Game;

import Dealer.Dealer_deb;
import Player.Player;

public class VideoPoker_deb implements VideoPoker{

	private Dealer_deb dealer;
	private Player player;
	private int previous_bet;
	private Strategy final_hand;
	private PerfectStrategy first_hand;
	private int[] Nb;
	private float final_percent;
	
	
	public VideoPoker_deb(int credit, String[] cards) {
		player = new Player(credit);
		dealer = new Dealer_deb(cards);
		previous_bet = -1;
		final_hand = new Strategy();
		Nb = new int[12];
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
			else if(cmd[i].equals("s"))
			{
				System.out.println("-cmd " + cmd[i]);
				Statistics();
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
			Nb[8]++;
			if(player.getHand().getBetSize() == 5)
				player.setBalance(4000);
			else
				player.setBalance(player.getHand().getBetSize()*250);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("STRAIGHT FLUSH"))
		{
			Nb[7]++;
			player.setBalance(player.getHand().getBetSize()*50);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("FOUR ACES"))
		{
			Nb[6]++;
			player.setBalance(player.getHand().getBetSize()*160);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		
		else if(result.equals("FOUR 2–4"))
		{
			Nb[6]++;
			player.setBalance(player.getHand().getBetSize()*80);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("FOUR 5–K"))
		{
			Nb[6]++;
			player.setBalance(player.getHand().getBetSize()*50);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("FULL HOUSE"))
		{
			Nb[5]++;
			player.setBalance(player.getHand().getBetSize()*10);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("FLUSH"))
		{
			Nb[4]++;
			player.setBalance(player.getHand().getBetSize()*7);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("STRAIGHT"))
		{
			Nb[3]++;
			player.setBalance(player.getHand().getBetSize()*5);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("THREE OF A KIND"))
		{
			Nb[2]++;
			player.setBalance(player.getHand().getBetSize()*3);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
			
		else if(result.equals("TWO PAIR"))
		{
			Nb[1]++;
			player.setBalance(player.getHand().getBetSize()*1);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}	
		else if(result.equals("JACKS OR BETTER"))
		{
			Nb[0]++;
			player.setBalance(player.getHand().getBetSize()*1);
			
			System.out.println("player wins with a " + result + " and his credit is " + player.getBalance());
		}
		else
		{
			Nb[9]++;
			System.out.println("player loses and his credit is " + player.getBalance());
		}
		Nb[10]++;
			
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
	
	public void Statistics()
	{
		Nb[11] = player.getBalance();
		float earnings = player.getEarnings();
		float wagered = player.getWagered();
		
		final_percent = (earnings/ wagered) * 100;
		System.out.println();
		System.out.println("  "+"Hand                             Nb");
		System.out.println("  "+"------------------------------------");
		System.out.println("  "+"Jacks or Better                  "+Nb[0]+"");
		System.out.println("  "+"Two Pair                         "+Nb[1]+"");
		System.out.println("  "+"Three of a kind                  "+Nb[2]+"");
		System.out.println("  "+"Straight                         "+Nb[3]+"");
		System.out.println("  "+"Flush                            "+Nb[4]+"");
		System.out.println("  "+"Full House                       "+Nb[5]+"");
		System.out.println("  "+"Four of a Kind                   "+Nb[6]+"");
		System.out.println("  "+"Straight Flush                   "+Nb[7]+"");
		System.out.println("  "+"Royal Flush                      "+Nb[8]+"");
		System.out.println("  "+"Other                            "+Nb[9]+"");
		System.out.println("  "+"------------------------------------");
		System.out.println("  "+"Total                            "+Nb[10]+"");
		System.out.println("  "+"------------------------------------");
		System.out.println("  "+"Credit                 "+Nb[11]+"("+String.format("%.1f", final_percent)+"%)");
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