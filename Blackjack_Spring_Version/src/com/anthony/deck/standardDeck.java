package com.anthony.deck;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class standardDeck extends Deck {

	public standardDeck(List<Card> cards) {
		this.cards = cards;
	}

	public void printDeck() {
		for (Card card : cards)
			System.out.println(card);
	}

}
