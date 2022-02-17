package slidingWindow_String;

import org.junit.Test;

import junit.framework.Assert;

public class P02_MinimumWindowSubstring {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 76
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
		String s = "ADOBECODEBANC";
		String t = "ABC";
		//Assert.assertEquals(counter, minWindowSubstring(s,t));
		minWindowSubstring(s,t);
	}
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "a";
		String t = "a";
		minWindowSubstring(s,t);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "a";
		String t = "";
		minWindowSubstring(s,t);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Last test case failing
	 * 
	 */	
	
	private String minWindowSubstring(String s,String t) {
		int[] sAscii = new int[62];
		int[] tAscii = new int[62];
		int left=0,right=0,minLength = s.length();
		String sub = "";
		if(t.length() > s.length()) return "";
		for(right=0;right<t.length();right++) {
			sAscii[s.charAt(right)-'A']++;
			tAscii[t.charAt(right)-'A']++;
		}
		
		while(right<=s.length()) {
			if(isMatching(sAscii,tAscii,t)) {
				if((right-left+1) < minLength) {
					sub = s.substring(left, right);
					System.out.println(sub);
				}
				sAscii[s.charAt(left++)-'A']--;
			} else {
				if(right<s.length()) sAscii[s.charAt(right++)-'A']++;
				else right++;
			}		
		}
		return sub;
	}
	
	public boolean isMatching(int[] sAscii, int[] tAscii,String t) {
		for(int i=0;i<t.length();i++) {
			if(sAscii[t.charAt(i)-'A'] < tAscii[t.charAt(i)-'A']) return false;
		}
		return true;
	}
}
