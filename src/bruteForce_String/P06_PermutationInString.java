package bruteForce_String;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P06_PermutationInString {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 567
	 * 
	 * Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false
	 * otherwise.
	 * 
	 * In other words, return true if one of s1's permutations is the substring of s2.
	 * 
	 * Permutation in a string - Same as anagrams but should be adjacent characters
	 * 
	 * Leetcode daily challenge - 11/02/2022
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
		String s1 = "ab";
		String s2 = "eidbaooo";
		Assert.assertEquals(true, findIfPermutationOfAnotherString(s1,s2));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s1 = "ab";
		String s2 = "a";
		Assert.assertEquals(false, findIfPermutationOfAnotherString(s1,s2));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s1 = "ab";
		String s2 = "eidaoboo";
		Assert.assertEquals(false, findIfPermutationOfAnotherString(s1,s2));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two int arrays of size 26
	 * 2. Create two pointers and initiate them to 0
	 * 3. For the initial length of s1, add values to respective ascii arrays
	 * 4. If both arrays are equal, return true
	 * 5. Traverse through s2 array starting from s1length + 1
	 * 6. Remove the left value and ad the right value
	 * 7. Compare both arrays. If both are same, return true
	 * 8. Continue steps 5-7 till right crosses length of s2
	 * 9. Return false by default
	 * Edge Case:
	 * 10. If length of s1 > s2, return false at the beginning itself
	 * 
	 */	
	
	private boolean findIfPermutationOfAnotherString(String s1, String s2) {
		if(s1.length() > s2.length()) return false;
        
		int[] asciiS1 = new int[26];
		int[] asciiS2 = new int[26];
        
        int left=0,right=0;
		while(right<s1.length()) {
			asciiS1[s1.charAt(right)-'a']++;
            asciiS2[s2.charAt(right++)-'a']++;
		}
        
		if(Arrays.equals(asciiS1, asciiS2)) return true;
		
		while(right<s2.length()) {
			asciiS2[s2.charAt(left++)-'a']--;
			asciiS2[s2.charAt(right++)-'a']++;
			if(Arrays.equals(asciiS1, asciiS2)) return true;
		}
		
		return false;
	}
}
