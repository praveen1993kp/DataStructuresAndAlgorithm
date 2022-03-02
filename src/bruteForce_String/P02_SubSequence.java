package bruteForce_String;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import junit.framework.Assert;

public class P02_SubSequence {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode No - 392
	 * 
	 * Given two strings s and t, return true if s is subsequence of t, or falce otherwise.
	 * 
	 * A subsequence of a string is a new string that formed from the original string by deleting some (can be none)
	 * of the characters without disturbing the relative positions of the remaining characters (i.e. 'ace' is a subsequence
	 * of 'abcde' while 'aec' is not).
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
		String s = "ab";
		String t = "baab";
		boolean expected = true;
		Assert.assertEquals(expected, subSequence(s,t));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		
		String s = "abc";
		String t = "and bag catch";
		s = "aaaaaa";
		t = "bbaaaa";
		boolean expected = false;
		Assert.assertEquals(expected, subSequence(s,t));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "acb";
		String t = "ahbgdc";
		boolean expected = false;
		Assert.assertEquals(expected, subSequence(s,t));
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Check if length of s is less than t.
	 * 2. If character at i == character at j, increment both and move to next element
	 * 3. Else, increment right and see if there is any match found
	 * 4. Handle edge cases
	 * 	4a. If either of strings is null, return false
	 * 	4b. If length of s>t, return false
	 * 	4c. If length of s and t are equal, check if both are equal, else return false
	 * 
	 * Approach 2 - Two Pointer
	 * 
	 * 1. Create pointers sPointer and tPointer and assign them to s and t strings respectively.
	 * 2. If the length of s is greater than t length, return false
	 * 3. Traverse till tPointer cross t length and sPointer crosses s length
	 * 4. if s.charAt(sPointer) equals t.charAt(tPointer) increment sPointer
	 * 5. By default increment tPointer
	 * 6. Return the result of sPointer==s.length()
	 * 
	 *  
	 * 
	 */	
	
	public boolean subSequence(String s, String t) {
		boolean result = false;
		String outputString = "";
		if((s==null)||(t==null)) result = false;
			else if (s.length()>t.length()) result = false;
				else if (s.length()==t.length()) result = s.equals(t);
					else if (s.length() < t.length()) {
						int j=0;
						for(int i=0;i<s.length()&&j<t.length();) {
							if(s.charAt(i)==t.charAt(j)) {
								outputString = outputString + t.charAt(j);
								i++;
								j++;
							}
							else {
								j++;
							}
						}
					}
		System.out.println(s);
		System.out.println(outputString);
		result = s.equals(outputString);
		
	return result;	
	}
	
	public boolean subSequence_TwoPointer(String s, String t) {
		int sPointer=0,tPointer=0;
        if(s.length()>t.length()) return false;
        while(tPointer<t.length() && sPointer<s.length()){
            if(s.charAt(sPointer)==t.charAt(tPointer))
                sPointer++; 
            tPointer++;
        }
        return (sPointer==s.length());
	}
}
	
