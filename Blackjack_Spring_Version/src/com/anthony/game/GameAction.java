package com.anthony.game;

import java.util.Scanner;

import com.anthony.deck.Deck;
import com.anthony.player.CardHolder;
import com.anthony.player.Player;

public class GameAction {

	private GameAction() {
	}

	static Scanner input = new Scanner(System.in);

	static void hitOrStand(Player player, Deck deck) {
		while (player.getHandValue() < 21) {
			try {
				System.out.println("Do you want to hit or stand? Enter 'h' or 's'\n");
				player.showHand();
				char choice = Character.toLowerCase(input.next().charAt(0));
				if (choice == 'h')
					hit(player, deck);
				else if (choice == 's')
					break;
				else
					throw new Exception("Entered an invalid input");
			} catch (Exception e) {
				System.out.println(("Not a valid option\n"));
			}
		}
	}

	static void hit(CardHolder player, Deck deck) {
		player.addCard(deck.deal());
	}

	static boolean playAgain() {
		while (true) {
			try {
				System.out.println("\n\nDo you want to play again? Enter 'y' or 'n'");
				char choice = Character.toLowerCase(input.next().charAt(0));
				if (choice == 'y')
					return true;
				else if (choice == 'n') {
					return false;
				} else
					throw new Exception("Invalid input entered");
			} catch (Exception e) {
				System.out.println("\nYou entered an invalid choice");
			}
		}
	}

}
