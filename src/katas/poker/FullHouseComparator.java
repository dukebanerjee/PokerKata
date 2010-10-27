package katas.poker;

public class FullHouseComparator extends HandComparatorTemplate {
	private ThreeOfAKindComparator threeOfAKindComparator;
	private PairComparator pairComparator;

	public FullHouseComparator(PokerHand whiteHand, PokerHand blackHand) {
		threeOfAKindComparator = new ThreeOfAKindComparator(whiteHand, blackHand);
		pairComparator = new PairComparator(whiteHand, blackHand);
	}

	@Override
	protected String nameOfHand() {
		return "full house";
	}

	@Override
	public boolean whiteIsApplicable() {
		return threeOfAKindComparator.whiteIsApplicable() && pairComparator.whiteIsApplicable();
	}

	@Override
	public boolean blackIsApplicable() {
		return threeOfAKindComparator.blackIsApplicable() && pairComparator.blackIsApplicable();
	}

	@Override
	protected int compareHands() {
		return threeOfAKindComparator.compare();
	}
}
