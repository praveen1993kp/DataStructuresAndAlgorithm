package slidingWindow_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P07_FindAllAnagramsInAString {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 438
	 * 
	 * Given two strings s and p, return an array of all the start indices of p's anagrams in s.
	 * You may return the answer in any order.
	 * 
	 * An anagram is a word or phrase formed by rearranging the letters of a different word or
	 * phrase, typically using all the original letters exactly once
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
		String s = "cbaebabacd";
		String p = "abc";
		findAllAnagrams(s,p);
	}
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "abab";
		String p = "ab";
		findAllAnagrams(s,p);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "abcd";
		String p = "xyz";
		findAllAnagrams(s,p);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create 2 char arrays of size 26 each
	 * 2. Create an arraylist for output
	 * 3. Create two pointers left and right and initialize them to 0
	 * 4. Edge case: If the length of p is greater than s, return empty list
	 * 5. Traverse through initial p.length() elements and add the respective values to sArray and pArray
	 * 6. If sArray and pArray are equal, add the left index to arraylist
	 * 7. Slide through the p string
	 * 8. Remove left from sArray and add right to sArray
	 * 9. For each iteration, if sArray and pArray are equal, add the index to arraylist
	 * 
	 */	
	
	private List<Integer> findAllAnagrams(String s, String p) {
		char[] sArray = new char[26];
		char[] pArray = new char[26];
		int sLength = s.length();
		int pLength = p.length();
		ArrayList<Integer> al = new ArrayList<>();
		
		int left=0,right=0;
		while(right<pLength) {
			sArray[s.charAt(right) - 'a']++;
			pArray[p.charAt(right++) - 'a']++;
		}
		
		if(Arrays.equals(sArray, pArray)) al.add(left);

		while(right<sLength) {
			sArray[s.charAt(left++) - 'a']--;
			sArray[s.charAt(right++) - 'a']++;
			if(Arrays.equals(sArray, pArray)) al.add(left);
		}
	
		return al;
	}
}
