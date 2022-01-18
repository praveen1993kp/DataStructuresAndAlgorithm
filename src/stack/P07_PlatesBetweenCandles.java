package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P07_PlatesBetweenCandles {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 2055
	 * 
	 * Plates Between Candles
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
		String s = "***|**|*****|**||**|*";
		int[][] queries = {{1,17},{4,5},{14,17},{5,11},{15,16}};
		countNoOfPlates(s,queries);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		String s = "||**||**|*";
		int[][] queries = {{3,8}};
		countNoOfPlates(s,queries);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		String s = "**|**|***|";
		int[][] queries = {{2,5},{5,9}};
		countNoOfPlates(s,queries);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create a stack. Convert input string into charArray
	 * 2. Create an output array of int[] type to accomodate the no of plates
	 * 3. Traverse from start of the current single dimensional array till second element of the same array
	 * 4. If current element is * and stack size is not null, push the value
	 * 5. Increase the counter by 1
	 * 6. Else, push the value
	 * 7. After the loop, Verify if the last element is *, 
	 * 8. If so, traverse till we reach | and decrease the counter accordingly to return final counter
	 * 9. Follow steps 3-8 till the end of queries length
	 * 
	 * 
	 */	
	
	private int[] countNoOfPlates(String s,int[][] queries) {
		char[] ch = s.toCharArray();
		Stack<Character> stack;
		int[] output = new int[queries.length];
		for(int i=0;i<queries.length;i++) {
			stack = new Stack<>();
			output[i] = returnNoOfCandles(ch,queries[i],stack);
		}
		System.out.println(Arrays.toString(output));
		return output;
	}
	
	public int returnNoOfCandles(char[] ch,int[] currentArray,Stack<Character> stack) {
		int counter=0;
		
		for(int i=currentArray[0];i<=currentArray[1];i++) {
			if(ch[i]=='*') {
				if(!stack.isEmpty()) {
					stack.push(ch[i]);
					counter++;
				}
			} else stack.push(ch[i]);
		}
		
		if(!stack.isEmpty() && stack.peek()=='*') {
			while(stack.peek()=='*') {
				stack.pop();
				counter--;
			}
		}
		
		return counter;
	}
}
