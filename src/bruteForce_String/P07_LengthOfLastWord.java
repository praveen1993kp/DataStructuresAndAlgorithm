package bruteForce_String;

import org.junit.Assert;
import org.junit.Test;

public class P07_LengthOfLastWord {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 58
	 * 
	 * Given a string s consisting of some words separated by some number of spaces, 
	 * return the length of the last word in the string.
	 * 
	 * A word is a maximal substring consisting of non-space characters only.
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
		String s = "Input World";
		int output = 5;
		Assert.assertEquals(output,findLengthOfLastWord(s));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "   fly me   to   the moon  ";
		int output = 4;
		Assert.assertEquals(output,findLengthOfLastWord(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "luffy is still joyboy";
		int output = 6;
		Assert.assertEquals(output,findLengthOfLastWord(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach 1 : Using string.split()
	 * 
	 * 1. Edge case - If s does not contain any white space, return s length
	 * 2. Split the given string by space
	 * 3. return the length of last element in split array
	 * 
	 * Approach 2 : Without using string.split()
	 * 
	 * 1. Edge case - If s does not contain any white space, return s length
	 * 2. Initiate index at the last of string
	 * 3. If last character in string is a character, reduce till a non space character is found
	 * 4. While index is greater than or equal to 0 and current character is not space
	 * 		4a. increment the count and decrement the index
	 * 5. Return the count
	 * 
	 */	
	
	private int findLengthOfLastWord_UsingStringSplit(String s) {
		if(!s.contains(" ")) return s.length();
        String[] str = s.split(" ");
        return str[str.length-1].length();
	}
	
	private int findLengthOfLastWord(String s) {
		if(!s.contains(" ")) return s.length();
        int index = s.length()-1,count=0;
        while(s.charAt(index)==' ') index--;
        while(index >=0 && s.charAt(index)!=' ') {
            count++;
            index--;
        }
        return count;
	}
	
}
