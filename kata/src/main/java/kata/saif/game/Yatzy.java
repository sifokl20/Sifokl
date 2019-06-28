package kata.saif.game;

import java.util.Arrays;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

import kata.saif.types.TypeStraight;
import kata.saif.utils.Utils;

public class Yatzy {

	public static int chance(int d1, int d2, int d3, int d4, int d5) {
		return Utils.sumInts(d1, d2, d3, d4, d5);
	}

	public static int yatzy(int... dice) {
		int firstElement = dice[0];
		IntPredicate p1 = i -> (i == firstElement);
		if (Arrays.stream(dice).allMatch(p1)) {
			return 50;
		}
		return 0;
	}

	public static int ones(int d1, int d2, int d3, int d4, int d5) {
		return Utils.sumSame(1, d1, d2, d3, d4, d5);
	}

	public static int twos(int d1, int d2, int d3, int d4, int d5) {
		return Utils.sumSame(2, d1, d2, d3, d4, d5);
	}

	public static int threes(int d1, int d2, int d3, int d4, int d5) {
		return Utils.sumSame(3, d1, d2, d3, d4, d5);
	}

	protected int[] dice;

	public Yatzy(int d1, int d2, int d3, int d4, int _5) {
		dice = new int[5];
		dice[0] = d1;
		dice[1] = d2;
		dice[2] = d3;
		dice[3] = d4;
		dice[4] = _5;
	}

	public int fours() {

		return Utils.sumSame(4, dice);
	}

	public int fives() {
		return Utils.sumSame(5, dice);
	}

	public int sixes() {
		return Utils.sumSame(6, dice);
	}

	public static int score_pair(int d1, int d2, int d3, int d4, int d5) {
		return Utils.scoreOccurence(2, d1, d2, d3, d4, d5);
	}

	public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
		return Utils.scoreTwoPairs(d1,d2,d3,d4,d5);
	}

	public static int four_of_a_kind(int _1, int _2, int d3, int d4, int d5) {
		return Utils.scoreOccurence(4, _1, _2, d3, d4, d5);
	}

	public static int three_of_a_kind(int d1, int d2, int d3, int d4, int d5) {
		return Utils.scoreOccurence(3, d1, d2, d3, d4, d5);
	}

	public static int smallStraight(int d1, int d2, int d3, int d4, int d5) {

		return Utils.scoreStraight(TypeStraight.SMALL, d1, d2, d3, d4, d5);
	}

	public static int largeStraight(int d1, int d2, int d3, int d4, int d5) {
		return Utils.scoreStraight(TypeStraight.LARGE, d1, d2, d3, d4, d5);

	}

	public static int fullHouse(int d1, int d2, int d3, int d4, int d5) {
		//fast way to calculate lenght of distnct elements to know if it s
		// full house or not
		//mainly used to exclude the two combinations : 2,2,3,3,4  and 4,4,4,4,4
		int lenghtOfDistinctElements = IntStream.of(  new int[]{d1,d2,d3, d4, d5}).distinct().toArray().length;
		
		
		if (Utils.scoreOccurence(2, d1, d2, d3, d4, d5) > 0
				&& Utils.scoreOccurence(3, d1, d2, d3, d4, d5) > 0
				&& lenghtOfDistinctElements == 2) {
			return Utils.sumInts(d1, d2, d3, d4, d5);
		}
		return 0;
	}
}
