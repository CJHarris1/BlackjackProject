package com.skilldistillery.players;

import java.util.Scanner;

public class BlackJackApp {
Scanner scanner = new Scanner(System.in);
BlackJackDealer dealer = new BlackJackDealer();
Player player = new Player();

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		
		System.out.println("Welcome to BlackJack!");
		boolean playAgain = true;
		while(playAgain) {
		app.reset();
		app.run();
		playAgain = app.playAgain();
		}
		app.cleanUp();
	}
	
	public void run() {
		dealer.resetDeck();
		System.out.println("cards in deck: " + dealer.deck.checkDeckSize());
		shuffleAndDeal();
		boolean playerHasBlackJack = false;
		boolean dealerHasBlackJack = false;
		boolean hasTwoAces = false;
		
		
		//if either player has black jack, keepPlaying = false and game ends
		playerHasBlackJack = player.viewHandAndValue();
		dealerHasBlackJack = dealer.viewDealerHandAndValue();
		hasTwoAces = dealer.checkTwoAces(player, dealer);
		
	
		if(!playerHasBlackJack && !dealerHasBlackJack && !hasTwoAces) {
			while(playerTurn()) {
				continue;
				
			}
			if(!player.checkIfBust()) {
				dealer.flipHiddenCard();
				if(!playerHoldUnder17()) {
					while(dealerTurn()) {
						continue;
					}
				}
			}	
		}
	}
	
	public void shuffleAndDeal() {
		dealer.shuffleDeck();
		dealer.dealCard(player);
		dealer.dealCard(dealer);
		dealer.dealCard(player);
		dealer.dealCard(dealer);
	}
	
	public boolean playerTurn() {
		boolean playerTurn = true;
		System.out.println("Player, would you like to: \n" +
						   "1) Hit \n" +
						   "2) Stay \n");
		String input = scanner.nextLine();
		
		switch(input) {
		case "1":
			dealer.dealCard(player);
			player.updatedHand();
			if(player.checkIfBust()) {
				System.out.println("Player busted, Dealer wins! \n");
				playerTurn = false;
			}
			break;
		case "2":
			System.out.println("Player holds");
			playerTurn = false;
			break;
		}
		return playerTurn;
	}
	
	public boolean playerHoldUnder17() {
		boolean gameOver = false;
		if(dealer.playerHand.getHandValue() > player.playerHand.getHandValue()) {
			System.out.println("Dealer wins! \n");
			gameOver = true;
		}
		return gameOver;
	}
	
	public boolean dealerTurn() {
		boolean dealerTurn = true;
		
		if(dealer.stay()) {
			dealerTurn = false;
			checkWinner();
		}
		else if(!dealer.checkIfBust()) {
			dealer.hit(dealer);
			System.out.println();
			System.out.println("Dealer hits \n");
			dealer.showCurrentHand();
			
			if(dealer.stay()) {
				dealerTurn = false;
				checkWinner();
			}
			
			if(dealer.checkIfBust()) {
				System.out.println("Dealer busted, Player wins! \n");
				dealerTurn = false;
				
			}
		}
		return dealerTurn;
	}
	
	public void checkWinner() {
		if(player.playerHand.getHandValue() > dealer.playerHand.getHandValue()) {
			System.out.println("Player wins! \n");
		}
		else if(dealer.playerHand.getHandValue() > player.playerHand.getHandValue()) {
			System.out.println("Dealer wins! \n");
		}
		else {
			System.out.println("Push! \n");
		}
		
	}
	
	public boolean playAgain() {
		boolean playAgain = true;
		System.out.println("Play again? \n"
						 + "1) Yes \n"
						 + "2) No \n");
		String userChoice = scanner.nextLine();
		
		switch(userChoice) {
		case "1":
			break;
		case "2":
			playAgain = false;
			break;
		}
		return playAgain;
	}
	
	public void reset() {
		dealer.getPlayerHand().getCards().clear();
		player.getPlayerHand().getCards().clear();
	}
	
	public void cleanUp() {
		scanner.close();
	}
}
