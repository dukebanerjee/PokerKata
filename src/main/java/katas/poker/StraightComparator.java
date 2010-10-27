package katas.poker;

import java.util.Iterator;

public class StraightComparator extends HandComparatorTemplate {
    private int whiteHighRank;
    private int blackHighRank;

    public StraightComparator(PokerHand whiteHand, PokerHand blackHand) {
        whiteHighRank = highRankForStraight(whiteHand);
        blackHighRank = highRankForStraight(blackHand);
    }

    private int highRankForStraight(PokerHand hand) {
        Iterator<Integer> ranks = hand.getDescendingRanksIterator();
        int highRank = ranks.next();
        for (int rank = highRank - 1; ranks.hasNext(); rank--) {
            if (!ranks.next().equals(rank)) {
                return -1;
            }
        }
        return highRank;
    }

    @Override
    protected String nameOfHand() {
        return "straight";
    }

    @Override
    public boolean whiteIsApplicable() {
        return whiteHighRank != -1;
    }

    @Override
    public boolean blackIsApplicable() {
        return blackHighRank != -1;
    }

    @Override
    protected int compareHands() {
        if (whiteHighRank < blackHighRank) {
            return -1;
        } else if (whiteHighRank > blackHighRank) {
            return 1;
        }
        return 0;
    }
}
