package com.anthony.deck;

import java.util.ArrayList;
import java.util.List;

public class DeckFactory {
	private static List<Card> cards = new ArrayList<Card>();
	private static int standardDeckSize = 52;

	public static void createCards() {
		for (Suit cardSuit : Suit.values()) {
			for (Rank cardRank : Rank.values())
				cards.add(new standardCard(cardSuit, cardRank));
		}
	}

	public static void printCards() {
		for (Card card : cards)
			System.out.println(card);
	}

	public static standardDeck createDeck() {
		if (cards.size() != standardDeckSize)
			createCards();
		return new standardDeck(cards);
	}
}
