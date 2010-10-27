package katas.poker;

import java.util.Iterator;

public class HighCardComparator implements HandComparator {
	private final PokerHand whiteHand;
	private final PokerHand blackHand;

	public HighCardComparator(PokerHand whiteHand, PokerHand blackHand) {
		this.whiteHand = whiteHand;
		this.blackHand = blackHand;
	}

	@Override
	public boolean isApplicable() {
		return true;
	}

	@Override
	public int compare() {
		Iterator<Integer> myCardRanks = whiteHand.getDescendingRanksIterator();
		Iterator<Integer> theirCardRanks = blackHand.getDescendingRanksIterator();

		int comparison = 0;
		while (myCardRanks.hasNext() && theirCardRanks.hasNext() && comparison == 0) {
			Integer myHighestRankedCard = myCardRanks.next();
			Integer theirHighestRankedCard = theirCardRanks.next();
			comparison = myHighestRankedCard.compareTo(theirHighestRankedCard);
		}
		return comparison;
	}
}
