package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> cards = new ArrayList<>();
	
	
	public Hand() {
		
	}
	
	abstract int getHandValue();


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Current Hand: ").append(cards);
		return builder.toString();
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	

	
	
	
	
	
}
