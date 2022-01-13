package twoPointer_String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P02_CheckIfNumbersAreInAscendingOrder {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode : 2042
	 * 
	 * Check if numbers are ascending in a sentence
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
		String s = "1 box has 3 blue 4 red 6 green and 12 yellow marbles";
		groupOccurrences(s);
	}
		

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "hello world 5 x 5";
		groupOccurrences(s);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "sunset is at 7 51 pm overnight lows will be in the low 50 and 60 s";
		groupOccurrences(s);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String s = "a puppy has 2 eyes and 4 legs";
		groupOccurrences(s);
	}
	
	
	
	@Test
	public void example5() {
		//Negative Test Data
		String s = "walk 14 swing 15 hit work";
		groupOccurrences(s);
	}
	/*
	 * --- Pseudo Code ---
	 * 
	 * Two Pointer algorithm - Equidirectional
	 * 
	 * 1. Initialize left to 0, right to 1
	 * 2. Split the input array using space
	 * 3. Traverse to the length of splitarray till right is less than array length
	 * 4. While left is not a number, increment it.
	 * 5. While right is not a number and right less than length of array, increment it.
	 * 6. If current values are number and left not equal to right, validate the condition.
	 * 7. If the condition breaks, assign result as false and break the loop
	 * 8. Else continue till last element or till false is found
	 * 
	 */	
	
	private boolean groupOccurrences(String s) {
		int left=0,right=1;
		String[] splitArray = s.split(" ");
		boolean result = true;
		while(right<splitArray.length) {
			
			while(!splitArray[left].matches("\\d*")) left++;
			while(!splitArray[right].matches("\\d*") && right<splitArray.length-1) right++;		
			
			if(splitArray[left].matches("\\d*") && splitArray[right].matches("\\d*") && left != right) {
				if(Integer.valueOf(splitArray[left]) >= Integer.valueOf(splitArray[right])) {
					result = false;
					break;
				}	
			}
			left=right;
			right++;		
		}
		System.out.println(result);
		return result;
	}
}
