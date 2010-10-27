package katas.poker;

public class TwoPairComparator extends HandComparatorTemplate {
	private int[] whiteRanks;
	private int[] blackRanks;

	public TwoPairComparator(PokerHand whiteHand, PokerHand blackHand) {
		whiteRanks = getRankOfTwoPairs(whiteHand.getRankCounts());
		blackRanks = getRankOfTwoPairs(blackHand.getRankCounts());
	}

	@Override
	protected String nameOfHand() {
		return "two pair";
	}

	private int[] getRankOfTwoPairs(int[] rankCounts) {
		int rankCount = 0;
		int[] ranksOfPair = new int[] { -1, -1 };
		for (int rank = 0; rank < rankCounts.length && rankCount < 2; rank++) {
			if (rankCounts[rank] == 2) {
				ranksOfPair[rankCount++] = rank;
			}
		}
		return ranksOfPair;
	}

	@Override
	public boolean whiteIsApplicable() {
		return whiteRanks[0] != -1 && whiteRanks[1] != -1;
	}

	@Override
	public boolean blackIsApplicable() {
		return blackRanks[0] != -1 && blackRanks[1] != -1;
	}

	@Override
	protected int compareHands() {
		for(int i = 0; i < 2; i++) {
			if (whiteRanks[i] < blackRanks[i]) {
				return -1;
			}
			if (whiteRanks[i] > blackRanks[i]) {
				return 1;
			}
		}
		return 0;
    }
}
