package twoPointer_String;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P11_NumberOfMatchingSubsequences {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 792
	 * 
	 * Given a string s and an array of strings words, return the number of words[i] that is a subsequence of s.

		A subsequence of a string is a new string generated from the original string with some characters 
		(can be none) deleted without changing the relative order of the remaining characters.

		For example, "ace" is a subsequence of "abcde".
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
		String s = "abcde";
		String[] words = {"a","bb","acd","ace"};
		findNumberOfMatchingSubsequences(s,words);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "dsahjpjauf";
		String[] words = {"ahjpjau","ja","ahbwzgqnuk","tnmlanowax"};
		findNumberOfMatchingSubsequences(s,words);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "abcde";
		String[] words = {"ca","bb","adc","aec"};
		findNumberOfMatchingSubsequences(s,words);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Convert s into charArray
	 * 2. Traverse for each word in words
	 * 3. Edge case : if word length is greater than s length, continue to next iteration
	 * 4. Create pointers left=0 and right = 0
	 * 5. If the character at left index of s and right index of word are same, increment both pointers
	 * 6. Else increment left
	 * 7. Edge case: To handle edge case, increment left till the current character is repeated
	 * 8. Increment counter if right==word.length
	 * 9. Repeat the iteration for each word in words
	 * 10. Return counter
	 * 
	 */	
	
	private int findNumberOfMatchingSubsequences(String s, String[] words) {
		char[] sch = s.toCharArray();
        int counter = 0;
        for(String word : words){
            if(word.length() > sch.length) continue;
            char[] ch = word.toCharArray();
            int left=0,right=0;
            while(left < sch.length && right<ch.length){
                char crtr = sch[left];
                if(sch[left]==ch[right]) {
                    right++;
                    left++;
                } else 
                    while(left < sch.length && sch[left]==crtr) left++;
            }
            if (right==word.length()) counter++; 
        }
        return counter;
	}
}
