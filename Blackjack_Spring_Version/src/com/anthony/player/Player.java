package com.anthony.player;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;

import com.anthony.deck.Card;

public abstract class Player extends CardHolder {

	private String name;
	protected List<Card> hand;

	@Override
	@Value("${name.player}")
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public abstract void addCard(Card card);

	public void showCards() {
		for (Card card : hand)
			System.out.print(card + "\t");
		System.out.println();
	}

	public abstract int getHandValue();

	public abstract void showHand();

	public abstract void reset();

}
