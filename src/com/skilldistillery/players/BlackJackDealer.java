package com.skilldistillery.players;

import java.util.List;

import com.skilldistillery.cards.Card;
import com.skilldistillery.cards.Deck;

public class BlackJackDealer extends Player {
	Deck deck = new Deck();
	
	public BlackJackDealer() {
		
	}
	
	public void shuffleDeck() {
		deck.shuffle();
	}
	
	public void dealCard(Player p) {
	p.getPlayerHand().getCards().add(deck.dealCard());
	}
	
	public boolean viewDealerHandAndValue() {
		boolean hasBlackJack = false;
		System.out.print("Dealer's hand: ");
		List<Card> currentCards = playerHand.getCards();
		
		Card showCard = currentCards.get(0);
		
		System.out.println("Dealer's hand: 1 flipped over card, " + showCard);
		System.out.println("Hand value: " + currentCards.get(0).getValue() + "\n");
		
		if(playerHand.isBlackJack()) {
			System.out.println("Dealer flips over second card to show the " + currentCards.get(1));
			System.out.println("Dealer has BlackJack! \n");
			hasBlackJack = true;
		}
		return hasBlackJack;
	}
	
	public void flipHiddenCard() {
		System.out.println("Dealer flips over second card to show the " + playerHand.getCards().get(1));
		System.out.println("Dealer's hand: " + playerHand.getCards().get(0) + "\t" + playerHand.getCards().get(1));
		System.out.println("Hand value: " + playerHand.getHandValue() + "\n");
	}
	
	public void showCurrentHand() {
		System.out.print("Dealer's hand: ");
		List<Card> currentCards = playerHand.getCards();
		for (int i = 0; i < currentCards.size(); i++) {
			System.out.print(currentCards.get(i) + "    ");
		}
		System.out.println();
		System.out.println("Hand value: " + playerHand.getHandValue() + "\n");
	}
	
	public void hit(Player p) {
		if(playerHand.getHandValue() < 17) {
			dealCard(p);
		}
	}
	
	public boolean stay() {
		boolean stay = false;
		if(playerHand.getHandValue() > 17 && playerHand.getHandValue() <= 21) {
			stay = true;
		}
		return stay;
	}
	
	public boolean doChecks() {
		boolean keepGoing = true;
		if (playerHand.isBust()) {
			System.out.println("BUST! Player loses");
			keepGoing = false;
		}
		return keepGoing;
	}
}