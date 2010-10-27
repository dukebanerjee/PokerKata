package katas.poker;


public class ComparatorFactory {
	private final PokerHand whiteHand;
	private final PokerHand blackHand;
	
	private enum HandClassification {
		STRAIGHT_FLUSH, FOUR_OF_A_KIND, FULL_HOUSE, FLUSH, STRAIGHT, THREE_OF_A_KIND, TWO_PAIR, PAIR, HIGH_CARD
	}

	public ComparatorFactory(PokerHand whiteHand, PokerHand blackHand) {
		this.whiteHand = whiteHand;
		this.blackHand = blackHand;
	}

	public int compare() {
		HandComparator comparator = null;
		int step = 0;
		int comparison = 0;
		HandClassification[] classifications = HandClassification.values();
		do {
			switch (classifications[step++]) {
			case STRAIGHT_FLUSH:
				comparator = new StraightFlushComparator(whiteHand, blackHand);
				break;
			case FOUR_OF_A_KIND:
				comparator = new FourOfAKindComparator(whiteHand, blackHand);
				break;
			case FULL_HOUSE:
				comparator = new FullHouseComparator(whiteHand, blackHand);
				break;
			case FLUSH:
				comparator = new FlushComparator(whiteHand, blackHand);
				break;
			case STRAIGHT:
				comparator = new StraightComparator(whiteHand, blackHand);
				break;
			case THREE_OF_A_KIND:
				comparator = new ThreeOfAKindComparator(whiteHand, blackHand);
				break;
			case TWO_PAIR:
				comparator = new TwoPairComparator(whiteHand, blackHand);
				break;
			case PAIR:
				comparator = new PairComparator(whiteHand, blackHand);
				break;
			case HIGH_CARD:
				comparator = new HighCardComparator(whiteHand, blackHand);
				return comparator.compare();
			}
		} while (!comparator.isApplicable() || (comparison = comparator.compare()) == 0);
		return comparison;
	}

}
