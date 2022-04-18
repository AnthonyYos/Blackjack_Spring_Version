package com.anthony.player;

import org.springframework.beans.factory.annotation.Value;

import com.anthony.deck.Card;
import com.anthony.deck.Deck;


public abstract class Dealer extends CardHolder {

	private String name;

	public abstract Card deal(Deck deck);
	
	public abstract void addCard(Card card);

	public abstract int getHandValue();

	public abstract void showHand();

	public abstract void showCards();

	@Override
	@Value("${name.dealer}")
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void reset();

}
