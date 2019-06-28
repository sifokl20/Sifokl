package kata.saif.utils;

import java.util.Arrays;

import kata.saif.types.TypeStraight;

public class Utils {
	public static int sumInts(int... ints) {

		int total = Arrays.stream(ints).sum();
		return total;
	}

	public static int sumSame(int value , int... ints) {
		
		int total = Arrays.stream(ints).filter(i -> i == value).sum();
		 return total;
	}
	
	public static int scoreOccurence(int occurence, int... ints) {

		int[] counts = initilizeTab(ints[0], ints[1], ints[2], ints[3], ints[4]);
		int at;
		for (at = 0; at != 6; at++)
			if (counts[6 - at - 1] >= occurence)
				return (6 - at) * occurence;
		return 0;
	}
	
	public static int scoreTwoPairs(int... ints){
		
		int[] data = initilizeTab(ints[0], ints[1], ints[2], ints[3], ints[4]);
		int n = 0;
		int score = 0;
		for (int i = 0; i < 6; i += 1)
			if (data[6 - i - 1] >= 2) {
				n++;
				score += (6 - i);
			}
		if (n == 2)
			return score * 2;
		else
			return 0;
		
		
	}
	
	
	private static int[] initilizeTab(int d1, int d2, int d3, int d4, int d5) {

		int[] counts = new int[6];
		counts[d1 - 1]++;
		counts[d2 - 1]++;
		counts[d3 - 1]++;
		counts[d4 - 1]++;
		counts[d5 - 1]++;

		return counts;

	}
	
	public static int scoreStraight(TypeStraight type , int... ints){
		int[] counts = initilizeCounterTab(ints[0], ints[1], ints[2], ints[3], ints[4]);
		switch (type){
		case SMALL : 
			return scoreStraight(0,4, counts, 15);
		default :
		 return scoreStraight(1,5, counts , 20);
		}
	}

	private static int scoreStraight(int from, int to, int[] tallies, int expectedScore) {

		for(int i = from ; i<to; i++){
			if(tallies[i+1]!=1) return 0;
		}
		return expectedScore;
	}
	private static int[] initilizeCounterTab(int d1, int d2, int d3, int d4, int d5) {

		int[] tallies;
		tallies = new int[6];
		tallies[d1 - 1] += 1;
		tallies[d2 - 1] += 1;
		tallies[d3 - 1] += 1;
		tallies[d4 - 1] += 1;
		tallies[d5 - 1] += 1;

		return tallies;

	}
	
}
