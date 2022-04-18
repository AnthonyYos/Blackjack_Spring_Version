package com.anthony.game;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.anthony.deck.Deck;
import com.anthony.deck.DeckFactory;
import com.anthony.player.Dealer;
import com.anthony.player.Player;

@Component
public class BlackjackGame extends Game {

	private Player player;
	private Dealer dealer;
	private Deck deck;
	final private int blackjack = 21;
	final private int minDealerHandValue = 17;
	private boolean playGame = true;

	@Autowired
	public BlackjackGame(Player player, Dealer dealer) {
		System.out.println("BlackjackGame: inside param constructor");
		this.player = player;
		this.dealer = dealer;
	}

	@Override
	void setUp() {
		System.out.println("BlackjackGame: inside setup()");
		player.reset();
		dealer.reset();
		deck = DeckFactory.createDeck();
		deck.shuffle();
	}

	void showHands() {
		player.showHand();
		dealer.showHand();
	}

	@Override
	public void play() {
		while (playGame) {
			setUp();
			System.out.println("BlackjackGame: inside play()");

			// Deal initial cards to player and dealer
			for (int i = 0; i < 2; i++) {
				player.addCard(deck.deal());
				dealer.addCard(deck.deal());
			}

			showHands();

			// Player asked to hit if possible/wanted
			if (player.getHandValue() < blackjack) {
				GameAction.hitOrStand(player, deck);
			}

			// Show dealer hands before their hits
			dealer.showHand();
			while (dealer.getHandValue() < minDealerHandValue)
				GameAction.hit(dealer, deck);

			// Print final hand values
			System.out.println("Final Hands:");
			showHands();

			// Display winner and check if users wants to play again
			GameEvaluator.evaluateGame(player, dealer);
			playGame = GameAction.playAgain();
		}
		System.out.println("\nEnd of Game");
	}
}
