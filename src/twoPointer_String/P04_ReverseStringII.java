package twoPointer_String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P04_ReverseStringII {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 541
	 * 
	 * Given a string s and an integer k,reverse the first k characters for every 2k characters
	 * counting from the start of the string.
	 * 
	 * If there are fewer than k characters left, reverse all of them.
	 * 
	 * If there are less than 2k but greater than or equal to k characters, then reverse the first k 
	 * characters and leave the other as original.
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
		String s = "abcdefg";
		int k = 2;
		String output = "bacdfeg";
		Assert.assertEquals(output, reverseStringII(s,k));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "abcd";
		int k = 5;
		String output = "dcba";
		Assert.assertEquals(output, reverseStringII(s,k));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "abcd";
		int k = 3;
		String output = "cbad";
		Assert.assertEquals(output, reverseStringII(s,k));
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String s = "a";
		int k = 3;
		String output = "a";
		Assert.assertEquals(output, reverseStringII(s,k));
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		String s = "";
		int k = 3;
		String output = "";
		Assert.assertEquals(output, reverseStringII(s,k));
	}
	
	@Test
	public void example6() {
		//Negative Test Data
		String s = "hyzqyljrnigxvdtneasepfahmtyhlohwxmkqcdfehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
		int k = 39;
		String output = "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqllgsqddebemjanqcqnfkjmi";
		String output2 = "fdcqkmxwholhytmhafpesaentdvxginrjlyqzyhehybknvdmfrfvtbsovjbdhevlfxpdaovjgunjqlimjkfnqcqnajmebeddqsgl";
		Assert.assertEquals(output, reverseStringII(s,k));
	}
	
	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Algorithm : Two Pointer
	 * 
	 * 1. Convert given string into charArray
	 * 2. Create two pointers - left = 0 and right = k-1. Also to track of current position, have currentPosition
	 * 3. Traverse till left less than ch.length
	 * 4. While left is less than or equal to right, swap them
	 * 5. After the inner loop ends, increase currentPosition by 2k. Update left and right from the new currentPosition
	 * 
	 * Edge Cases:
	 * 
	 * Before outer loop - If ch.length <=1, return the given string itself
	 * Before outer looop - If k>given input length, reset k as input length-1
	 * 
	 * Inside outer loop - If right becomes greater than ch.length, reset right to ch.length-1 (example 6 scenario)
	 * 
	 */	
	
	private String reverseStringII(String s, int k) {
		char[] ch = s.toCharArray();
		if (ch.length<=1) return s;
		if(k>ch.length) k=ch.length;
		int left=0, currentPosition = 0, right = k-1;
		
		while(left<ch.length) {
			
			while(left<=right) {
				char temp = ch[left];
				ch[left++] = ch[right];
				ch[right--] = temp;
			}	
			
			currentPosition += (2*k);
			left = currentPosition;
			right = left + k-1;
			if(right > ch.length) right = ch.length-1;
		}
		
		//System.out.println(new String (ch));
		return new String (ch);
	}
}
