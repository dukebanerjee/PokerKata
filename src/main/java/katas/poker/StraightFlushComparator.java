package katas.poker;

public class StraightFlushComparator extends HandComparatorTemplate {
    private StraightComparator straightComparator;
    private FlushComparator flushComparator;

    public StraightFlushComparator(PokerHand whiteHand, PokerHand blackHand) {
        straightComparator = new StraightComparator(whiteHand, blackHand);
        flushComparator = new FlushComparator(whiteHand, blackHand);
    }

    @Override
    protected String nameOfHand() {
        return "straight flush";
    }

    @Override
    public boolean whiteIsApplicable() {
        return straightComparator.whiteIsApplicable() && flushComparator.whiteIsApplicable();
    }

    @Override
    public boolean blackIsApplicable() {
        return straightComparator.blackIsApplicable() && flushComparator.blackIsApplicable();
    }

    @Override
    protected int compareHands() {
        return straightComparator.compare();
    }
}
