package hackerRank_Assessment2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P02_CircularPrinter {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 2. Circular Printer
	 * 
	 * A company has invented a new type of printing technology - a circular printer that looks like this.
	 * 
	 * It is a circular printer wheel with the letters A through Z in sequence. It wraps so A and Z are 
	 * adjacent. The printer has a pointer that is initially at 'A'. Moving from any character to any
	 * adjacent character takes 1 second. It can move in either direction. 
	 * 
	 * Given a string of letters, what is the minimum time needed to print the string?
	 * Note: Assume that printing does not take any time. Only consider the time it takes for the pointer
	 * to move.
	 * 
	 * Example:
	 * s = "BZA"
	 * Total time to print : 1+2+1 = 4 seconds.
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
		String s = "BZA";
		int expectedTime = 4;
		Assert.assertEquals(expectedTime, circularPattern(s));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "AZGB";
		int expectedTime = 13;
		Assert.assertEquals(expectedTime, circularPattern(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "ZNMD";
		int expectedTime = 23;
		Assert.assertEquals(expectedTime, circularPattern(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * DS: ASCII
	 * 
	 * example: AZGB
	 * 
	 * 1. Create two int variables diff and sum
	 * 2. Convert given String into charArray
	 * --Loop Starts--
	 * 3. Traverse till length of given char array
	 * 4. If first element, subtract the ascii of element from 'A' and assign it to diff --> 'Z'-'A'
	 * 5. else, subtract the ascii of element from previous element --> 'N' - 'Z'
	 * 6. Calculate Math.abs of diff (Since there could be negative)
	 * 7. As the pattern is circular and as we have to calculate minimum moves,
	 * 		7a. If diff is >13 (half the number of alphabets), subtract it from 26 (max no of alphabets).
	 * 8. sum += diff;
	 * --Loop Ends--	
	 *
	 */	
	
	private int circularPattern(String s) {
		int diff=0,sum=0;
		char[] ch = s.toCharArray();
		for(int i=0;i<ch.length;i++) {
			if(i==0) diff = ch[i]-'A';
			else diff = ch[i] - ch[i-1];
			diff = Math.abs(diff);
			if(diff>13) diff = 26-diff;
			sum += diff;
		}
		return sum;
	}
}
