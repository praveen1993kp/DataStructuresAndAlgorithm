package stack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P06_BackspaceStringCompare {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 844
	 * 
	 * Backspace String Compare
	 * 
	 * Given two strings s and t, return true if they are equal when both are typed into empty text
	 * editors. '#' means a backspace character.
	 * 
	 * Note that after backspacing an empty text,the text will continue to apply
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
		String s = "ab#c";
		String t = "ad#c";
		boolean expected = true;
		Assert.assertEquals(expected, stringCompare(s,t));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "ab##";
		String t = "c#d#";
		Assert.assertEquals(true, stringCompare(s,t));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "#c#d";
		String t = "####d#";
		Assert.assertEquals(true, stringCompare(s,t));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * DS: Stack
	 * 
	 * 1. Create a stack
	 * --Loop Begins--
	 * 2. Traverse till length of s
	 * 3. If the current is '#' and stack is not empty, stack.pop
	 * 4. Else stack.push
	 * --Loop Ends--
	 * 5. Repeat the steps 2-4 for t
	 * 6. Compare stack.pop and stack.result and throw result
	 * 
	 */	
	
	private boolean stringCompare(String s, String t) {
		char[] sArray = s.toCharArray();
		char[] tArray = t.toCharArray();
		
		String s1 = returnFinalString(sArray);
		String s2 = returnFinalString(tArray);
		
		return s1.equals(s2);
	}
	
	public String returnFinalString(char[] chArray) {
		Stack<Character> stack = new Stack<>();
		
		for(char ch: chArray) {
			if(ch=='#') {
				if(!stack.isEmpty()) stack.pop();
			} else stack.push(ch);
		}
		StringBuilder sb = new StringBuilder();
		
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
	}
}
