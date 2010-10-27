package katas.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class PokerHand implements Comparable<PokerHand> {
	private List<Integer> cardRanks;
	private boolean cardsHaveTheSameSuit;

	public PokerHand(String specification) {
		parseSpecification(specification);
	}

	private void parseSpecification(String handSpecification) {
		char suit = 0;
		cardsHaveTheSameSuit = true;
		cardRanks = new ArrayList<Integer>(5);
		for (String cardSpecification : handSpecification.split(" ")) {
			cardRanks.add(decodeRank(cardSpecification.charAt(0)));
			suit = updateSuit(suit, cardSpecification);
		}
		Collections.sort(cardRanks, Collections.reverseOrder());
	}

	private int decodeRank(char rankCode) {
		return "23456789TJQKA".indexOf(rankCode);
	}

	private char updateSuit(char suit, String cardSpecification) {
	    if (suit == 0) {
	    	suit = cardSpecification.charAt(1);
	    } else if (suit != cardSpecification.charAt(1)) {
	    	cardsHaveTheSameSuit = false;
	    }
	    return suit;
    }

	public int compareTo(PokerHand theirHand) {
		return new ComparatorFactory(this, theirHand).compare();
	}

	public Iterator<Integer> getDescendingRanksIterator() {
		return Collections.unmodifiableCollection(cardRanks).iterator();
	}

	public int[] getRankCounts() {
		int[] rankCounts = new int[13];
		for (Iterator<Integer> ranks = cardRanks.iterator(); ranks.hasNext();) {
			rankCounts[ranks.next()]++;
		}
		return rankCounts;
	}

	public boolean cardsHaveTheSameSuit() {
		return cardsHaveTheSameSuit;
	}
}
