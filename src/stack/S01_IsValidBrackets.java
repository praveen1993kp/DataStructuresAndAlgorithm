package stack;

import java.util.HashMap;
import java.util.Stack;

import org.junit.Test;

import junit.framework.Assert;

public class S01_IsValidBrackets {

	
	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 20
	 * 
	 * Valid Parantheses
	 * 
	 * Given a String of brackets, find if each opening bracket has a valid closing bracket
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
		String s = "[(({{}}))]";
		boolean expected = true;
		Assert.assertEquals(expected, isValidBracket(s));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "{}";
		boolean expected = true;
		Assert.assertEquals(expected, isValidBracket(s));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "{{{}}]";
		boolean expected = false;
		Assert.assertEquals(expected, isValidBracket(s));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Convert input string into charArray
	 * 2. Add closing braces as key and opening braces as value
	 * 3. For the length of input charArray,
	 * 		3a. Add only the opening braces into stack
	 * 		3b. If any closing brace is found, check if it matches the value returned by that character in hashmap
	 * 		3c. If true, remove from stack
	 * 4. At the end, if the stack is empty, return true. Else false
	 * 
	 * 
	 */	
	
	private boolean isValidBracket(String s) {
		if(s.length()%2!=0) return false;
		char[] ch = s.toCharArray();
		Stack<Character> stack = new Stack<>();
		HashMap<Character,Character> hMap = new HashMap<>();
		hMap.put('}', '{');
		hMap.put(']', '[');
		hMap.put(')', '(');
		
		for(int i=0;i<ch.length;i++) {
			if(!hMap.containsKey(ch[i])) stack.push(ch[i]);
			else {
				if(stack.peek()==hMap.get(ch[i])) stack.pop();
			}
		}
		return stack.isEmpty();
	}
}
