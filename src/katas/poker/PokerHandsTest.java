package katas.poker;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class PokerHandsTest {
	@Test
	public void testHighCardWhereWhiteHandHasHighCard() throws Exception {
		PokerHand whiteHand = new PokerHand("AC QC TC 5D 3D");
		PokerHand blackHand = new PokerHand("3H 5H 6S 7S 8S");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testHighCardWhereBlackHandHasHighCard() throws Exception {
		PokerHand whiteHand = new PokerHand("3H 5H 6S 7S 8S");
		PokerHand blackHand = new PokerHand("6C 8C TC QD AD");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}
	
	@Test
	public void testHighCardWhereBlackHandAndWhiteAndHaveSeveralMatchingHighCards() throws Exception {
		PokerHand whiteHand = new PokerHand("6C 8C TC QD AD");
		PokerHand blackHand = new PokerHand("3H 4H TS QS AS");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testHighCardHandsAreEqual() throws Exception {
		PokerHand whiteHand = new PokerHand("6C 8C TC QD AD");
		PokerHand blackHand = new PokerHand("6H 8H TS QS AS");

		assertTrue(whiteHand.compareTo(blackHand) == 0);
	}

	@Test
	public void testPairWhereWhiteHandHasPairWithHighestRank() throws Exception {
		PokerHand whiteHand = new PokerHand("8C 8S 6C 7D 5D");
		PokerHand blackHand = new PokerHand("3H 3H 6S 7S 5S");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testPairWherePairHasSameRankButBlackHasNonPairHighestRankCard() throws Exception {
		PokerHand whiteHand = new PokerHand("3H 3H 6S 7S 8S");
		PokerHand blackHand = new PokerHand("3C 3S TC QD AD");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}

	@Test
	public void testPairWhereBlackWithLowPairBeatsWhiteHighCardAndHigherRank() throws Exception {
		PokerHand whiteHand = new PokerHand("6C 8S TC QD AD");
		PokerHand blackHand = new PokerHand("3H 3H 6S 7S 8S");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}

	@Test
	public void testPairWhereWhiteWithLowPairBeatsBlackHighCardAndHigherRank() throws Exception {
		PokerHand whiteHand = new PokerHand("3H 3C 6S 7S 8S");
		PokerHand blackHand = new PokerHand("6C 8S TC QD AD");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testTwoPairWhereWhiteSecondPairHasHigherRankThanBlack() {
		PokerHand whiteHand = new PokerHand("3H 3C 6S 6H 8S");
		PokerHand blackHand = new PokerHand("2D 2S 6C 6D AD");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testTwoPairWhereBlackFirstPairHasHigherRankThanWhite() {
		PokerHand whiteHand = new PokerHand("3H 3C 6S 6H 8S");
		PokerHand blackHand = new PokerHand("9D 9S 6C 6D AD");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}

	@Test
	public void testTwoPairWhereWhiteWithTwoPairBeatsBlackWithHigherRankedSinglePair() {
		PokerHand whiteHand = new PokerHand("7H 7C 6S 6H 8S");
		PokerHand blackHand = new PokerHand("AH AC 3S 2H KS");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testTwoPairWhereBlackWithTwoPairBeatsWhiteWithHigherRankedSinglePair() {
		PokerHand whiteHand = new PokerHand("3H 4S 5S 6H AS");
		PokerHand blackHand = new PokerHand("3D 3S 4C 4D 8D");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}

	@Test
	public void testThreeOfAKindWhereWhiteBeatsBlack() {
		PokerHand whiteHand = new PokerHand("6H 6C 6S 7H 8S");
		PokerHand blackHand = new PokerHand("3D 3S 3C TD AD");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testThreeOfAKindWhereBlackBeatsWhite() {
		PokerHand whiteHand = new PokerHand("7H 7C 7S 6H 8S");
		PokerHand blackHand = new PokerHand("8D 8S 8C TD AD");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}

	@Test
	public void testThreeOfAKindBeatsTwoPair() {
		PokerHand whiteHand = new PokerHand("7H 7C 7S 6H 8S");
		PokerHand blackHand = new PokerHand("8D 8S 9C 9D AD");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testStraightWhiteBeatsBlackWithHighCard() {
		PokerHand whiteHand = new PokerHand("4H 5C 6S 7H 8S");
		PokerHand blackHand = new PokerHand("3D 4S 5D 6D 7D");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testStraightBlackBeatsWhiteWithHighCard() {
		PokerHand whiteHand = new PokerHand("3D 4S 5D 6D 7D");
		PokerHand blackHand = new PokerHand("4H 5C 6S 7H 8S");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}

	@Test
	public void testStraightWithWhiteLowCardBeatsBlackJustHighCard() {
		PokerHand whiteHand = new PokerHand("4H 5C 6S 7H 8S");
		PokerHand blackHand = new PokerHand("3D 4S 5D 6D AD");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testStraightWithBlackLowCardBeatsWhiteTreeOfAKind() {
		PokerHand whiteHand = new PokerHand("4H 5C 6S 7H 8S");
		PokerHand blackHand = new PokerHand("3D 4S 5D 6D AD");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testStraightsEqualHighCardAreTied() {
		PokerHand whiteHand = new PokerHand("4H 5C 6S 7H 8S");
		PokerHand blackHand = new PokerHand("4D 5S 6D 7D 8D");

		assertTrue(whiteHand.compareTo(blackHand) == 0);
	}

	@Test
	public void testFlushWithWhiteHandWithLowCardBeatsBlackHandWithJustHighCard() {
		PokerHand whiteHand = new PokerHand("3H 5H 6H 7H 8H");
		PokerHand blackHand = new PokerHand("6C 8C TC QD AD");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testFlushWithBlackHandWithLowCardBeatsWhiteHandWithJustHighCard() {
		PokerHand whiteHand = new PokerHand("6C 8C TC QD AD");
		PokerHand blackHand = new PokerHand("3H 5H 6H 7H 8H");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}

	@Test
	public void testFlushWithHighCardBeatsFlushWithLowCard() {
		PokerHand whiteHand = new PokerHand("3H 5H 6H 7H AH");
		PokerHand blackHand = new PokerHand("6C 8C TC QC AC");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}

	@Test
	public void testWhiteHandWithFullHouseBeatsBlackHandWithThreeOfAKind() {
		PokerHand whiteHand = new PokerHand("3H 3C 3S 2H 2S");
		PokerHand blackHand = new PokerHand("AH AC AS QC TC");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testBlackHandWithFullHouseBeatsWhiteHandWithThreeOfAKind() {
		PokerHand whiteHand = new PokerHand("AH AC AS QC TC");
		PokerHand blackHand = new PokerHand("3H 3C 3S 2H 2S");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}

	@Test
	public void testWhiteFullHouseBeatsWhiteHandWithHighCardOnThreeOfAKind() {
		PokerHand whiteHand = new PokerHand("4H 4C 4S 2C 2C");
		PokerHand blackHand = new PokerHand("3H 3C 3S QH QS");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testFourOfAKindWhiteHandWithLowCardBeatsBlackHandWithThreeOfAKindWithHighCard() {
		PokerHand whiteHand = new PokerHand("4H 4C 4S 4D 2C");
		PokerHand blackHand = new PokerHand("3H 3C 3S QH AS");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
	}

	@Test
	public void testFourOfAKindWithBlackHandWithLowCardBeatsWhiteHandWithThreeOfAKindWithHighCard() {
		PokerHand whiteHand = new PokerHand("3H 3C 3S QH AS");
		PokerHand blackHand = new PokerHand("4H 4C 4S 4D 2C");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
	}

	@Test
	public void testFullHouseBeatsHandWithHighCardOnFourOfAKind() {
		PokerHand whiteHand = new PokerHand("4H 4C 4S 4C 2C");
		PokerHand blackHand = new PokerHand("3H 3C 3S 3H AS");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
		assertTrue(blackHand.compareTo(whiteHand) < 0);
	}

	@Test
	public void testStraightFlushBeatsFourOfAKind() {
		PokerHand whiteHand = new PokerHand("2C 3C 4C 5C 6C");
		PokerHand blackHand = new PokerHand("AH AD AS AH 9S");

		assertTrue(whiteHand.compareTo(blackHand) > 0);
		assertTrue(blackHand.compareTo(whiteHand) < 0);
	}

	@Test
	public void testStraighFlushWinsOnHighCard() {
		PokerHand whiteHand = new PokerHand("2C 3C 4C 5C 6C");
		PokerHand blackHand = new PokerHand("3H 4H 5H 6H 7H");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
		assertTrue(blackHand.compareTo(whiteHand) > 0);
	}

	@Test
	public void testRoyalFlushBeatsStraightFlush() {
		PokerHand whiteHand = new PokerHand("2C 3C 4C 5C 6C");
		PokerHand blackHand = new PokerHand("TH JH QH KH AH");

		assertTrue(whiteHand.compareTo(blackHand) < 0);
		assertTrue(blackHand.compareTo(whiteHand) > 0);
	}
}
