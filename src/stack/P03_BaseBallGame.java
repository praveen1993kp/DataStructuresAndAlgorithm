package stack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P03_BaseBallGame {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 682
	 * 
	 * You are keeping score for a baseball game with strange rules. The game consists of several
	 * rounds, where the scores of past rounds may affect future rounds' score.
	 * 
	 * At the beginning of the game, you start with an empty record. You are given a list of
	 * strings ops, where ops[i] is the ith operation you must apply to the record and is one of 
	 * the following:
	 * 
	 * 1. An integer x - Record a new score of x.
	 * 2. "+" - Record a new score that is the sum of the previous two scores. 
	 * 		It is guaranteed there will always be two previous scores.
	 * 3. "D" - Record a new score that is double the previous score. 
	 * 		It is guaranteed there will always be a previous score.
	 * 4. "C" - Invalidate the previous score, removing it from the record. 
	 * 		It is guaranteed there will always be a previous score.
	 * 
	 * Return the sum of all the scores on the record.
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
		String[] ops = {"5","2","C","D","+"};
		int output = 30;
		Assert.assertEquals(output, scoreCalculation(ops));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		String[] ops = {"5","-2","4","C","D","9","+","+"};
		int output = 27;
		Assert.assertEquals(output, scoreCalculation(ops));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String[] ops = {"1"};
		int output = 1;
		Assert.assertEquals(output, scoreCalculation(ops));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * DS: Stack
	 * 
	 * 1. Create a Stack to accomodate Integer type
	 * --Loop Begins--
	 * 2. Traverse till length of ops
	 * 3. If current string equals +
	 * 		3a. Pop the element and store in variable
	 * 		3b. Peek and store previously popped + peek in a variable
	 * 		3c. Push popped variable
	 * 		3d. Push added variable
	 * 4. If current string equals D
	 * 		4a. Push peek value * 2
	 * 5. If current string equals C
	 * 		5a. Pop
	 * 6. Else, convert into integer and add in stack
	 * --Loop Ends--
	 * 7. While stack is not empty, add the values and return the sum
	 * 
	 */	
	
	private int scoreCalculation(String[] ops) {
		Stack<Integer> stack = new Stack<>();	
		int sum = 0;
		
		for(String str : ops) {
			if(str.equals("+")) {
				int valAtTop = stack.pop();
				int currentVal = valAtTop + stack.peek();
				stack.push(valAtTop);
				stack.push(currentVal);
			} else if (str.equals("D")) stack.push(stack.peek() * 2);
			else if (str.equals("C")) stack.pop();
			else stack.push(Integer.valueOf(str));
		}
		
		while(!stack.isEmpty()) {
			sum += stack.pop();
		}
		System.out.println(sum);
		return sum;
	}
	
	
}
