package katas.poker;

public class FlushComparator extends HandComparatorTemplate {
	private boolean whiteIsFlush;
	private boolean blackIsFlush;
	private HighCardComparator highCardComparator;

	public FlushComparator(PokerHand whiteHand, PokerHand blackHand) {
		whiteIsFlush = whiteHand.cardsHaveTheSameSuit();
		blackIsFlush = blackHand.cardsHaveTheSameSuit();
		highCardComparator = new HighCardComparator(whiteHand, blackHand);
	}

	@Override
	protected String nameOfHand() {
		return "flush";
	}

	@Override
	public boolean whiteIsApplicable() {
		return whiteIsFlush;
	}

	@Override
	public boolean blackIsApplicable() {
		return blackIsFlush;
	}

	@Override
	protected int compareHands() {
		return highCardComparator.compare();
	}
}
