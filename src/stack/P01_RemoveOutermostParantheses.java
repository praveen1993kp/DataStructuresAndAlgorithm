package stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class P01_RemoveOutermostParantheses {

	
	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode: 1021
	 * 
	 * Remove outermost parantheses
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
		String s = "(()())(())";
		remove(s);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "(()())(())(()(()))";
		String output = "()()()()(())";
		remove(s);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "()()";
		String output = "";
		remove(s);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 *  1. Create a stack, Convert input string into char array
	 *  2. For each character
	 *  	2a. Add ( to sb only if stack.size is greater than or equal to 1
	 *  	2b. Push into stack anyway.
	 *  	2c. When ) is found, and stack size is greater than 1, add to sb
	 *  	2d. Else, remove from stack

	 * 
	 * 
	 */	
	
	private String removeParantheses(String s) {
		Stack<Character> stack = new Stack<>();
		char[] ch = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for (char c : ch) {
			if(c=='(') {
				if(stack.size()>=1) sb.append(c);
				stack.push(c);
			} else {
				if(stack.size() > 1) sb.append(c);
				stack.pop();
			}
		}
		return sb.toString();
	}
	
	private String remove(String s) {
		Stack<Character> stack = new Stack<>();
		char[] ch = s.toCharArray();
		StringBuffer sb = new StringBuffer();
		
		for (char c : ch) {
			if(c=='(') {
				if(stack.size()>=1) sb.append(c);
					stack.push(c);
			} else {
				if(stack.size()>1) sb.append(c);
					stack.pop();
				}
			}
		System.out.println(sb.toString());
		return sb.toString();
		}
		
}
