package katas.poker;

public class PairComparator extends NCardsOfAKindComparator {
    public PairComparator(PokerHand whiteHand, PokerHand blackHand) {
        super(2, whiteHand, blackHand);
    }

    @Override
    protected String nameOfHand() {
        return "pair";
    }
}
