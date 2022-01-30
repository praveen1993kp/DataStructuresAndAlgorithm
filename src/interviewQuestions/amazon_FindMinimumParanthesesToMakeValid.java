package interviewQuestions;

import java.util.Stack;

import org.junit.Test;

public class amazon_FindMinimumParanthesesToMakeValid {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Write a program to convert how many more paranthesis needed to make it valid paranthesis.
	 * 
	 * Leetcode - 921
	 * 
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
		
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String input = "))((";
		findCount_WithoutStack(input);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String input = ")(())()()))";
		findCount_WithoutStack(input);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * DS: Stack
	 * 
	 * 1. Create an empty stack
	 * 2. Loop to each character in given string
	 * 3. If stack is empty, push the character into stack
	 * 4. If the stack is not empty,
	 * 		4a. If character == '(', push
	 * 		4b. Else
	 * 			4ba. If stack.peek is '(', stack.pop()
	 * 			4bb. Else stack.push
	 * 5. Return stack size
	 * 
	 * 
	 * Approach 2: Without Stack
	 * 
	 * 1.Create two pointers left and right
	 * 2. If character is '(', increment left counter
	 * 3. Else
	 * 		3a. if left counter >0, decrement it
	 * 		3b. Else increment right counter
	 * 4. Return sum of left and right
	 * 
	 */	
	
	private int findCount(String input) {
		Stack<Character> stack = new Stack<>();
		
		for(char ch: input.toCharArray()) {
			if(stack.isEmpty()) stack.push(ch);
			else {
				if(ch=='(') stack.push(ch);
				else {
					if(stack.peek()=='(') stack.pop();
					else stack.push(ch);
				}
			}
		}
		System.out.println(stack);
		
		return stack.size();
	}
	
	private int findCount_WithoutStack(String input) {
		int left=0,right=0;
		
		for(char ch: input.toCharArray()) {
			if(ch=='(') left++;
			else {
				if(left>0) left--;
				else right++;
			}
		}
		System.out.println(left+right);
		return left+right;
	}
}
