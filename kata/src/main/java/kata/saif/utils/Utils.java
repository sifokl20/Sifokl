package kata.saif.utils;

import java.util.Arrays;

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
	
	private static int[] initilizeTab(int d1, int d2, int d3, int d4, int d5) {

		int[] counts = new int[6];
		counts[d1 - 1]++;
		counts[d2 - 1]++;
		counts[d3 - 1]++;
		counts[d4 - 1]++;
		counts[d5 - 1]++;

		return counts;

	}
	
}
