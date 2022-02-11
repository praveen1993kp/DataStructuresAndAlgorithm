package hashMap;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P12_FindTheDifferenceCharacter {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 389
	 * 
	 * Find the Difference
	 * 
	 * You are given two strings s and t.
	 * 
	 * String t is generated by random shuffling string s and then add one more letter at a 
	 * random position.
	 * 
	 * Return the letter that was added to t.
	 * 
	 * Leetcode Daily Challenge - 07/02/2022
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
		String s = "abcd";
		String t = "abced";
		findDifferenceCharacter(s,t);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "";
		String t = "a";
		findDifferenceCharacter(s,t);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "abcdefg";
		String t = "abcdefgh";
		findDifferenceCharacter(s,t);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		String s = "a";
		String t = "aa";
		findDifferenceCharacter(s,t);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Using Ascii:
	 * 
	 * 1. Create an int[] array of size 26
	 * 2. Add all the characters of s into int array
	 * 3. For each element in t array, if the value is already available, decrement by one.
	 * 4. Step 3 -> To handle edge case s="a" and t = "aa"
	 * 5. If the value at any character index is already 0, return the character
	 * 
	 * 6. Same solution can be achieved using hashMap too with almost similar steps
	 * 
	 * 
	 */	
	
	private char findDifferenceCharacter(String s, String t) {
		int[] output = new int[26];
		char out = 0;
		for(char ch: s.toCharArray()) {
			output[ch-'a']++;
		}
		
		for(char ch: t.toCharArray()) {
			if(output[ch-'a']==0) {
				out = ch;
				break;
			} else output[ch-'a']--;
		}
		System.out.println(out + "aa");
		return out ;
	
	}
}