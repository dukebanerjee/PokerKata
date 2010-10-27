package katas.poker;

public class FourOfAKindComparator extends NCardsOfAKindComparator {
	public FourOfAKindComparator(PokerHand whiteHand, PokerHand blackHand) {
		super(4, whiteHand, blackHand);
	}
}
