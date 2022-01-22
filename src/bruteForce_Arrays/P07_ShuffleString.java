package bruteForce_Arrays;

import java.util.Arrays;

import org.junit.Test;

public class P07_ShuffleString {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode - 1528
	 * 
	 * You are given a string s and an integer array indices of same length. The string s will be
	 * shuffled such that the character at the ith position moves to indices[i] in the shuffled string.
	 * 
	 * Return the shuffled string
	 * 
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem? 
	 * 	yes or no 
	 * 	If no ask the person to provide
	 * 	with more details with examples 
	 * 	If yes go to the next step What is the
	 * 	input(s)? What is the expected output? 
	 * 
	 * 	Do I have any constraints to solve the
	 * 	problem? Do I have all the information to go to the next steps 
	 * 	How big is your test data set will be? 
	 * 
	 * 2. Test data set Minimum 3 data set including positive, negative and edge
	 * Validate with the interviewer if the data set is fine by his/ her assumptions
	 * 
	 * 
	 * 3. Do I know to solve it? 
	 * 	Yes- great is there an alternate ? 
	 * 	No - can I break the problem into sub problems?
	 * 
	 * 
	 * 4. Ask for hint (if you dont know how to solve
	 * this) 
	 * 
	 * 5. Do I know alternate solutions as well Yes- what are those? No- that
	 * is still fine, proceed to solve by what you know 
	 * 
	 * 6. If you know the alternate
	 * solution find out the O-notations (performance) 
	 * 
	 * 
	 * 7. Then, explain either both are the best (depends on
	 * the time) 
	 * 	Approach 1:- start with the worst-> improve (optimize) -> End up
	 * with the best 
	 * 	Approach 2: Write down the options and benefits and code the
	 * best 
	 * 
	 * 8. Start always with the Pseudo code 
	 * 
	 * 9. Test against different test data
	 * 
	 * 10. If it fails then debug to solve it
	 */
	
	@Test
	public void example1() {
		//Positive Test Data
		String s = "codeleet";
		int[] indices = {4,5,6,7,0,2,1,3};
		shuffleString_BetterSoln(s,indices);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "abc";
		int[] indices = {0,1,2};
		shuffleString_BetterSoln(s,indices);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "123456789";
		int[] indices = {1,3,5,7,0,2,4,6,8};
		shuffleString_BetterSoln(s,indices);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create an output string null
	 * 2. Create a char array
	 * 3. Traverse till length of indices array
	 * 4. Assign character at ith position to expected array position
	 * 5. Return the character array converted as string
	 * 
	 * Better Solution
	 * 
	 * 1. 
	 * 
	 */	
	
	private String shuffleString(String s, int[] indices) {
		String output = "";
		char[] ch = new char[indices.length];
		for(int i=0;i<indices.length;i++) {
			ch[indices[i]] = s.charAt(i);
		}
		output = new String(ch);
		System.out.println(output);
		return output;
	}
	
	private String shuffleString_BetterSoln(String s, int[] indices) {
		char[] ch = new char[indices.length];
		for(int i=0;i<indices.length;i++) ch[indices[i]] = s.charAt(i);
		return new String(ch);
	}
}
