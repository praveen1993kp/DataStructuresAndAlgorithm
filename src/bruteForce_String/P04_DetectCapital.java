package bruteForce_String;

import org.junit.Test;

import junit.framework.Assert;

public class P04_DetectCapital {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 540
	 * 
	 * We define the usage of capitals in a word to be right when one of the following cases holds:
	 * 
	 * 1. All letters in this word are capitals, eg: USA
	 * 2. All letters in this word are not capitals, eg: leetcode
	 * 3. Only the first letter in this word is capital, eg: Google
	 * 
	 * Given a string word, return true if the usage of capitals in its right.
	 * 
	 * 
	 * Daily Leetcode Challenge - 24/01/2022
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
		String s = "USA";
		boolean expectedOutput = true;
		Assert.assertEquals(expectedOutput, detectCapital(s));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "leetcode";
		boolean expectedOutput = true;
		Assert.assertEquals(expectedOutput, detectCapital(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "Leetcode";
		boolean expectedOutput = true;
		Assert.assertEquals(expectedOutput, detectCapital(s));
	}
	
	
	@Test
	public void example4() {
		//Negative Test Data
		String s = "LEetcode";
		boolean expectedOutput = false;
		Assert.assertEquals(expectedOutput, detectCapital(s));
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		String s = "leetCODE";
		boolean expectedOutput = false;
		Assert.assertEquals(expectedOutput, detectCapital(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Using Ascii
	 * 
	 * 1. Get the length of given string
	 * 2. If length <2, return true
	 * 3. If given character is uppercase and next character is uppercase
	 * 		3a. If any of the consecutive characters are lower case, return false
	 * 4. If given character is uppercase and next is lowecase or vice versa
	 * 		4a. If any of the consecutive characters are upper case, return false
	 * 
	 * For checking if uppercase, we can use Character.isUpperCase
	 * 
	 * Alternative approach to check uppercase: 
	 * public boolean isCapital(char ch) {
	 *	return ch-'A'<26;
	 * }
	}
	 */	
	
	private boolean detectCapital(String s) {
		int len = s.length();
		if (len < 2) return true;
		if(Character.isUpperCase(s.charAt(0)) && Character.isUpperCase(s.charAt(1))) {
			for(int i=1;i<len;i++) if(!Character.isUpperCase(s.charAt(i))) return false;
		} else {
			for(int i=1;i<len;i++) if(Character.isUpperCase(s.charAt(i))) return false;
		}
		return true;				
	}
}
