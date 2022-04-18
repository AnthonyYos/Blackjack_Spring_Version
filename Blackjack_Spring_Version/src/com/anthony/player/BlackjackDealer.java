package com.anthony.player;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.anthony.deck.Card;
import com.anthony.deck.Deck;

@Component
public class BlackjackDealer extends Dealer {

	private List<Card> hand;
	private int handValue;
	private int aces;

	public BlackjackDealer() {
		hand = new ArrayList<Card>();
		handValue = 0;
		aces = 0;
	}

	@Override
	public Card deal(Deck deck) {
		return deck.deal();
	}

	@Override
	public void addCard(Card card) {
		int maxBlackjackHand = 21;
		hand.add(card);
		handValue += card.getValue();
		String aceRank = "Ace";
		if (aceRank.equals(card.getRank()))
			aces += 1;
		if (aces > 0 && handValue > maxBlackjackHand)
			adjustForAce();
	}

	private void adjustForAce() {
		handValue -= 10;
		aces -= 1;
	}

	public int getHandValue() {
		return handValue;
	}

	public void showCards() {
		for (Card card : hand)
			System.out.print(card + "\t");
		System.out.println();
	}

	@Override
	public void showHand() {
		System.out.println(getName() + "'s Hand");
		showCards();
		System.out.println(getHandValue());
		System.out.println();
	}

	@Override
	public void reset() {
		hand = new ArrayList<Card>();
		handValue = 0;
		aces = 0;
	}

}
