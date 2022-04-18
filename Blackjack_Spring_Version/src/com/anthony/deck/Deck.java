package com.anthony.deck;

import java.util.Collections;
import java.util.List;

public abstract class Deck {

	List<Card> cards;

	public void shuffle() {
		for (int i = 0; i < 5; i++)
			Collections.shuffle(cards);
	}

	public Card deal() {
		return cards.remove(0);
	}

	public void printDeck() {
		for (Card card : cards)
			System.out.println(card);
	}
}
