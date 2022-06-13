package Player;

import java.util.LinkedList;
import Card.*;
import Dealer.*;

public class Player {

	private int balance;
	private int wagered;
	private Hand hand;

	public Player(int _balance) {
		// TODO - implement Player.Player
		balance = _balance;
		wagered = 0;
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
		for(int i = 0; i < cards.length; i++)
		{
			discarded.add(hand.getCards().remove(cards[i] - 1));
		}
		dealer.discard(discarded);
	}

	public void bet(int value) {
		balance -= value;
		wagered += value;
		hand.setBetSize(value);
	}

	public void setBalance(int value) {
		balance += value;
	}

	public int getBalance() {
		return balance;
	}
	
	public int getWagered()
	{
		return wagered;
	}

}