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
	
}
