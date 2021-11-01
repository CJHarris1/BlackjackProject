package com.skilldistillery.cards;

public class BlackJackHand extends Hand{
	
	public BlackJackHand() {
		
	}
	
	@Override
	public int getHandValue() {
		int handVal = 0;
		for(int i = 0; i < cards.size(); i++) {
			handVal += cards.get(i).getValue();
		}
		
		return handVal;
	}
	
	public boolean isBlackJack() {
		boolean isBlackJack = false;
		int handVal = 0;
		for(int i = 0; i < cards.size(); i++) {
			handVal += cards.get(i).getValue();
		}
		if(handVal == 21) {
			isBlackJack = true;
		}
		return isBlackJack;
		
	}
	
	public boolean isBust() {
		boolean isBust = false;
		int handVal = 0;
		for(int i = 0; i < cards.size(); i++) {
			handVal += cards.get(i).getValue();
		}
		if(handVal > 21) {
			isBust = true;
		}
		return isBust;
	}
}