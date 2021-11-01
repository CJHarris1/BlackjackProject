package com.skilldistillery.players;

import java.util.List;

import com.skilldistillery.cards.BlackJackHand;
import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Hand;

public class Player {
	protected BlackJackHand playerHand = new BlackJackHand();
	
	public Player() {
		
	}

	public Hand getPlayerHand() {
		return playerHand;
	}
	
	public boolean viewHandAndValue() {
		boolean hasBlackJack = false;
		System.out.print("Player's hand: ");
		List<Card> currentCards = playerHand.getCards();
		for (int i = 0; i < currentCards.size(); i++) {
			System.out.print(currentCards.get(i) + " ");
		}
		System.out.println();
		System.out.println("Hand value: " + playerHand.getHandValue() + "\n");
		if(playerHand.isBlackJack()) {
			System.out.println("Player has BlackJack! \n");
			hasBlackJack = true;
		}
		return hasBlackJack;
	}
	
	public boolean checkIfBust() {
		boolean Bust = false;
		if (playerHand.isBust()) {
			Bust = true;
		}
		return Bust;
	}
	
	public void updatedHand() {
		System.out.print("Player's hand: ");
		List<Card> currentCards = playerHand.getCards();
		for (int i = 0; i < currentCards.size(); i++) {
			System.out.print(currentCards.get(i) + "    ");
		}
		System.out.println();
		System.out.println("Hand value: " + playerHand.getHandValue() + "\n");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Player Hand: ").append(playerHand);
		return builder.toString();
	}
}
