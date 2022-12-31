package interviewQuestions;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class anz_ReturnHighest4Characters {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
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
		char[] arr = {'a','u','v','s','b','c','t'};
		char[] output = {'v','u','t','s'};
		Assert.assertArrayEquals(highestChars_UsingAscii(arr), output);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		char[] arr = {'a','u','v'};
		char[] output = {'v','u','a',0};
		Assert.assertArrayEquals(highestChars_UsingAscii(arr), output);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		char[] arr = {'v','v','v','v','v','v','v'};
		char[] output = {'v','v','v','v'};
		Assert.assertArrayEquals(highestChars_UsingAscii(arr), output);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Brute Force:
	 * 
	 * 1. Sort the array
	 * 2. add last 4 elements into output array
	 * 3. Return the output array
	 * 
	 * 
	 * -- Better soln --
	 * 
	 * 1. Add all the characters into ascii array
	 * 2. Start from the end of ascii array. and add into output
	 * 3. If multiple occurrences found, add till cound becomes 0
	 * 
	 */	
	
	public char[] highestChars(char[] arr) {
		char[] output = new char[4];
		Arrays.sort(arr);
		
		int insertIndex = 0;
		int getIndex = arr.length-1;
		while(getIndex>=0 && insertIndex<output.length) 
			output[insertIndex++] = arr[getIndex--];
		
		return output;
	}
	
	public char[] highestChars_UsingAscii(char[] arr) {
		char[] output = new char[4];
		int[] ascii = new int[26];
		
		for(char ch : arr)
			ascii[ch-'a']++;
		
		int insertIndex = 3;
		for(int i=ascii.length-1;i>=0;i--) {
			if(ascii[i-'a'] != 0) {
				int currentVal = ascii[i-'a'];
				while(insertIndex>=0 && currentVal>=0) {
					output[insertIndex--] = (char)(currentVal - 'a');
				}
				if(insertIndex<0) break;
			}
		}
		
		return output;
	}
	
}
