package stack;

import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class S02_RemoveAllAdjacentDuplicates {

	
	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Leetcode - 1047
	 * 
	 * You are given a string s consisting of lowercase English letters. 
	 * A duplicate removal consists of choosing two adjacent and equal letters and removing them.
	 * We repeatedly make duplicate removals on s until we no longer can.
	 * Return the final string after all such duplicate removals have been made. 
	 * It can be proven that the answer is unique.
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
		String s = "abbaca";
		String output = "ca";
		Assert.assertEquals(output, removeDuplicates(s));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "azxxzy";
		String output = "ay";
		Assert.assertEquals(output, removeDuplicates(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "azxszy";
		String output = "azxszy";
		Assert.assertEquals(output, removeDuplicates(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Convert input string into charArray
	 * 2. For the length of input charArray,
	 * 		2a. If the stack is empty (Edge case) or latest element of stack is not equal to current element, add it
	 * 		2b. Else, remove the last element from stack
	 * 3. Convert stack into string and return
	 * 
	 */	
	
	private String removeDuplicates(String s) {
		Stack<Character> stack = new Stack<>();
		char[] inputAsArray = s.toCharArray();
		
		for(int i=0;i<inputAsArray.length;i++) {
			if(stack.isEmpty()) stack.push(inputAsArray[i]);
			else if (stack.peek()!=inputAsArray[i]) stack.push(inputAsArray[i]);
			else stack.pop();
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			sb.append(stack.pop());
		}
		return sb.reverse().toString();
		
		// For loop for string building creates more space
		
	}
}
