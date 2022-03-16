package stack;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P09_ValidateStackSequences {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 946
	 * 
	 * Validate Stack Sequences
	 * 
	 * Given two integer arrays pushed and popped each with distinct values, return true if this 
	 * could have been the result of a sequence of push and pop operations on an intially 
	 * empty stack, or false otherwise.
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
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,5,3,2,1};
		validateStack(pushed,popped);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] pushed = {0,2,1};
		int[] popped = {0,1,2};
		validateStack(pushed,popped);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] pushed = {2,1,0};
		int[] popped = {1,0,2};
		validateStack(pushed,popped);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] pushed = {1,2,3,4,5};
		int[] popped = {2,1,3,5,4};
		validateStack(pushed,popped);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a stack. Create variables left and right
	 * 2. Traverse till left crosses pushed length
	 * 3. Push pushed[left] by default
	 * 4. while popped[right] equals stack peek and stack is not empty  and right < n stack pop, increment right
	 * 5. Increment left after while condition
	 * 6. Return if right==n
	 * 
	 */	
	
	private boolean validateStack(int[] pushed, int[] popped) {
		int n = popped.length;
        Stack<Integer> stack = new Stack<>();
        int left=0,right=0;
        while(left<pushed.length){
            stack.push(pushed[left]);
            while(!stack.isEmpty() && right<n && stack.peek()==popped[right]){
                    stack.pop();
                    right++;
            }
            left++;
        }
        return right==n;
		
	}
}
