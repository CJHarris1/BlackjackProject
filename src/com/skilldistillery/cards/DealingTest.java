package com.skilldistillery.cards;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class DealingTest {
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		DealingTest dealer = new DealingTest();
		dealer.deal();
	}

	public void deal() {
		Deck deck = new Deck();
		deck.shuffle();
		System.out.print("How many cards would you like? ");
		try {
			int howManyCards = scanner.nextInt();
			scanner.nextLine();

			if (howManyCards > 52) {
				throw new InputMismatchException();
			}

			List<Card> hand = new ArrayList<>(howManyCards);
			int handValue = 0;
			for (int i = 0; i < howManyCards; i++) {
				Card cardVal = deck.dealCard();
				handValue += cardVal.getValue();
				hand.add(cardVal);
			}
			printHandAndValue(hand, handValue);
		} catch (InputMismatchException e) {
			System.out.println("That is not a valid amount of cards. Please try again.");
		} finally {
			scanner.close();
		}

	}

	private void printHandAndValue(List<Card> hand, int value) {
		for (Card card : hand) {
			System.out.println(card);
		}
		System.out.println("Total value: " + value);
	}
}
