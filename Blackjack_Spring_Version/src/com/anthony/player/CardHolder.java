package com.anthony.player;

import com.anthony.deck.Card;

public abstract class CardHolder {

	protected abstract void setName(String name);

	public abstract String getName();

	public abstract void addCard(Card card);

	public abstract void showCards();

	public abstract int getHandValue();

	public abstract void showHand();

	public abstract void reset();
}
