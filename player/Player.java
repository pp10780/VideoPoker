package player;

import java.util.LinkedList;

import card.*;
import dealer.*;

/**
 * Represents a player who interacts with a hand, has a balance and keeps track of the amount he's wagered throughout the plays and how much he's earned
 * @author Sofia Silveira, Joana Afonso, Pedro Martins
 */
public class Player {

	private int balance;
	private int wagered;
	private int earnings;
	private Hand hand;
	
	/**
	 * Constructor of Player that receives as argument the initial balance of that player
	 * 
	 * @param _balance initial balance of the player
	 */
	public Player(int _balance) {
		balance = _balance;
		wagered = 0;
		earnings = 0;
		hand = new Hand();
	}
	
	/**
	 * Adds cards to the player's hand
	 * @param new_Cards cards to be added to the player's hand
	 */
	public void setHand(LinkedList<Card> new_Cards) {
		hand.setCards(new_Cards);
	}
	
	/**
	 * Returns the player's hand
	 * @return Hand player's hand
	 */
	public Hand getHand() {
		return hand;
	}
	
	/**
	 * Removes from the player's hand the cards chosen to be discarded according to the perfect strategy
	 * @param cards integer array that has '0' in index corresponding to the position of a card to be discarded from the hand
	 * @param dealer the dealer thats going to handle the discarded cards
	 * @return int number of discarded cards
	 */
	public int discard(int[] cards, Dealer dealer) {
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
		
		return cnt;
	}
	
	/**
	 * Removes the value of the bet from the player's balance and adds to the wagered amount
	 * @param value Value of the player's bet
	 */
	public void bet(int value) {
		balance -= value;
		wagered += value;
	}
	
	/**
	 * Increases the player's balance and adds to his earnings
	 * @param value value to be added to the player's balance and earnings
	 */
	public void setBalance(int value) {
		balance += value;
		earnings += value;
	}
	
	/**
	 * Returns the player's current balance
	 * @return int player's balance
	 */
	public int getBalance() {
		return balance;
	}
	
	/**
	 * Returns how much the player has wagered throughout the plays so far
	 * @return int player's wagered amount 
	 */
	public int getWagered()
	{
		return wagered;
	}
	
	/**
	 * Returns how much the player has earned throughout the plays so far
	 * @return int player's earnings
	 */
	public int getEarnings()
	{
		return earnings;
	}

}