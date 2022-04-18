package com.anthony.deck;

public class standardCard extends Card {

	private Suit suit;
	private Rank rank;

	public standardCard(Suit suit, Rank rank) {
		this.suit = suit;
		this.rank = rank;
	}

	@Override
	public String toString() {
		return suit + "-" + rank;
	}

	@Override
	public int getValue() {
		return rank.getValue();
	}

	@Override
	public String getRank() {
		return rank.toString();
	}

}
