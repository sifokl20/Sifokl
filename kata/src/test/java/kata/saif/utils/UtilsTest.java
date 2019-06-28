package kata.saif.utils;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilsTest {

	@Test
	public void sumInts_Zeros_test() {
		int expected = 0;
		int calculated = Utils.sumInts(0,0,0);
		assertEquals("error sumInts :  expected "+expected+" , calculated "+calculated+" ; ",expected,calculated);
	}
	@Test
	public void sumInts_Non_Zeros_test() {
		int expected = 1;
		int calculated = Utils.sumInts(1,0,0);
		assertEquals("error sumInts :  expected "+expected+" , calculated "+calculated+" ; ",expected,calculated);
	}
	
	
	@Test
	public void sumSame_Zero_test (){
		int expected = 0;
		int calculated = Utils.sumSame(100, 1,2,3,4,5,6);
		assertEquals("error sumSame :  expected "+expected+" , calculated "+calculated+" ; ",expected,calculated);
	}
	
	@Test
	public void sumSame_Non_Zero_test (){
		int expected = 12;
		int calculated = Utils.sumSame(4, 1,2,4,4,5,4);
		assertEquals("error sumSame :  expected "+expected+" , calculated "+calculated+" ; ",expected,calculated);
	}
	
	@Test
	public void sumSame_with_array_test (){
		
		int[] data = {1,2,2,2,4,6};
		
		int expected = 6;
		int calculated = Utils.sumSame(2, data);
		assertEquals("error sumSame :  expected "+expected+" , calculated "+calculated+" ; ",expected,calculated);
	}
	
	@Test
	public void sumSame_with_array_non_initialized_test (){
		
		int[] data = new int[5]; //filled with zeros
		
		int expected = 0;
		int calculated = Utils.sumSame(2, data);
		assertEquals("error sumSame :  expected "+expected+" , calculated "+calculated+" ; ",expected,calculated);
	}
	

}
