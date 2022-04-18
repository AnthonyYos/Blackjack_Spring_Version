package com.anthony.game;

import com.anthony.player.CardHolder;
import com.anthony.player.Dealer;
import com.anthony.player.Player;

public class GameEvaluator {

	private GameEvaluator() {
	}

	static public void evaluateGame(Player player, Dealer dealer) {
		// Check for ties conditions
		if (checkTieGame(player, dealer))
			System.out.println("Tie");
		// Check for win conditions
		else if (checkPlayerWin(player, dealer))
			System.out.println(player.getName() + " wins!");
		// Else player lost by bust or lower hand value
		else
			System.out.println(dealer.getName() + " wins");
	}

	private static boolean checkTieGame(Player player, Dealer dealer) {
		return (player.getHandValue() == dealer.getHandValue() || checkBust(player) && checkBust(dealer));
	}

	private static boolean checkPlayerWin(Player player, Dealer dealer) {
		return (checkBust(dealer) || (player.getHandValue() > dealer.getHandValue() && !checkBust(player)));
	}

	private static boolean checkBust(CardHolder cardHolder) {
		int maxBlackjackHand = 21;
		return cardHolder.getHandValue() > maxBlackjackHand;
	}
}