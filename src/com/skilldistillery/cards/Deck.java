package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>(); 
	
	public Deck() {
		for(Suit suit : Suit.values()) {
			for(Rank rank : Rank.values()) {
				Card card = new Card(rank, suit);
				deck.add(card);
			}
		}
	}
	
	public int checkDeckSize() {
		return deck.size();
	}
	
	public Card dealCard() {
		return deck.remove(0);
	}
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
}
