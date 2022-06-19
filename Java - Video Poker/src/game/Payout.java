package game;

import player.Player;

public interface Payout {
	void payment(Player player, int betSize, int payoutSize);

}
