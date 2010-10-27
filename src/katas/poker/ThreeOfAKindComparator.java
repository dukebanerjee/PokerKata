package katas.poker;

public class ThreeOfAKindComparator extends NCardsOfAKindComparator {
	public ThreeOfAKindComparator(PokerHand whiteHand, PokerHand blackHand) {
		super(3, whiteHand, blackHand);
	}
}
