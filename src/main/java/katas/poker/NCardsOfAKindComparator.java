package katas.poker;

public abstract class NCardsOfAKindComparator extends HandComparatorTemplate {
    protected int whiteRankOfN;
    protected int blackRankOfN;
    protected int n;

    public NCardsOfAKindComparator(int n, PokerHand whiteHand, PokerHand blackHand) {
        this.n = n;
        whiteRankOfN = getRankOfN(whiteHand.getRankCounts());
        blackRankOfN = getRankOfN(blackHand.getRankCounts());
    }

    private int getRankOfN(int[] rankCounts) {
        for (int rank = 0; rank < rankCounts.length; rank++) {
            if (rankCounts[rank] == n) {
                return rank;
            }
        }
        return -1;
    }

    @Override
    protected String nameOfHand() {
        return "" + n + " of a kind";
    }

    @Override
    public boolean whiteIsApplicable() {
        return whiteRankOfN != -1;
    }

    @Override
    public boolean blackIsApplicable() {
        return blackRankOfN != -1;
    }

    @Override
    protected int compareHands() {
        if (whiteRankOfN < blackRankOfN) {
            return -1;
        } else if (whiteRankOfN > blackRankOfN) {
            return 1;
        }
        if (n > 2) {
            throw new IllegalArgumentException("In single deck, two equal " + nameOfHand()
                    + " hands not possible");
        }
        return 0;
    }
}
