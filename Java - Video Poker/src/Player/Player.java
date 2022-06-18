package Player;

import java.util.LinkedList;
import Card.*;
import Dealer.*;

public class Player {

	private int balance;
	private int wagered;
	private int earnings;
	private Hand hand;

	public Player(int _balance) {
		// TODO - implement Player.Player
		balance = _balance;
		wagered = 0;
		earnings = 0;
		hand = new Hand();
		
	}

	public void setHand(LinkedList<Card> new_Cards) {
		hand.setCards(new_Cards);
	}

	public Hand getHand() {
		return hand;
	}

	public void discard(int[] cards, Dealer_sim dealer) {
		LinkedList<Card> discarded = new LinkedList<Card>();
		int cnt = 0;
		for(int i = cards.length - 1; i >= 0; i--)
		{
			if(cards[i] == 0)
			{
				discarded.add(hand.getCards().remove(i));
				cnt++;
			}
				
		}
		dealer.discard(discarded);
		dealer.draw(this, cnt);
	}

	public void bet(int value) {
		balance -= value;
		wagered += value;
		hand.setBetSize(value);
	}

	public void setBalance(int value) {
		balance += value;
		earnings += value;
	}

	public int getBalance() {
		return balance;
	}
	
	public int getWagered()
	{
		return wagered;
	}
	
	public int getEarnings()
	{
		return earnings;
	}

}