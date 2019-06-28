package kata.saif.game;

import java.util.Arrays;
import java.util.function.IntPredicate;

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
		return Utils.scoreOccurence(2,  d1,  d2,  d3, d4,  d5);
	}

	public static int two_pair(int d1, int d2, int d3, int d4, int d5) {
		int[] counts = new int[6];
		counts[d1 - 1]++;
		counts[d2 - 1]++;
		counts[d3 - 1]++;
		counts[d4 - 1]++;
		counts[d5 - 1]++;
		int n = 0;
		int score = 0;
		for (int i = 0; i < 6; i += 1)
			if (counts[6 - i - 1] >= 2) {
				n++;
				score += (6 - i);
			}
		if (n == 2)
			return score * 2;
		else
			return 0;
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
		int[] tallies;
		boolean _2 = false;
		int i;
		int _2_at = 0;
		boolean _3 = false;
		int _3_at = 0;

		tallies = new int[6];
		tallies[d1 - 1] += 1;
		tallies[d2 - 1] += 1;
		tallies[d3 - 1] += 1;
		tallies[d4 - 1] += 1;
		tallies[d5 - 1] += 1;

		for (i = 0; i != 6; i += 1)
			if (tallies[i] == 2) {
				_2 = true;
				_2_at = i + 1;
			}

		for (i = 0; i != 6; i += 1)
			if (tallies[i] == 3) {
				_3 = true;
				_3_at = i + 1;
			}

		if (_2 && _3)
			return _2_at * 2 + _3_at * 3;
		else
			return 0;
	}
}
