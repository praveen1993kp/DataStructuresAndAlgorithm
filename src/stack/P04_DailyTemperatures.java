package stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Stack;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P04_DailyTemperatures {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 739
	 * 
	 * Given an array of integers temperatures represents the daily temperatures,
	 * return an array answer such that answer[i] is the number of days you have to wait
	 * after the ith day to get a warmer temperature. 
	 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
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
		int[] temp = {73,74,75,71,69,72,76,73};
		int[] diff = {1,1,4,2,1,1,0,0};
		Assert.assertTrue(Arrays.equals(diff, dailyTemp_stack(temp)));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] temp = {30,40,50,60};
		int[] diff = {1,1,1,0};
		Assert.assertTrue(Arrays.equals(diff, dailyTemp_stack(temp)));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] temp = {30,60,90};
		int[] diff = {1,1,0};
		Assert.assertTrue(Arrays.equals(diff, dailyTemp_stack(temp)));
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] temp = {30,29,28,27,26,25};
		int[] diff = {0,0,0,0,0,0};
		Assert.assertTrue(Arrays.equals(diff, dailyTemp_stack(temp)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * DS: Stack
	 * 
	 * 1. Create an empty stack. Create output array ans
	 * --Loop Begins--
	 * 2. Traverse till length of temperatures array
	 * 3. When stack is empty, push the index
	 * 4. When stack is not empty and temp of stack peek is less than current temp,
	 * 		4a. Add index-val in stack.pop index
	 * 		4b. Stack push current value index
	 */	
	
	private int[] dailyTemp_stack(int[] temp) {
		Stack<Integer> stack = new Stack<>();
		int[] ans = new int[temp.length];
		
		for(int index=0;index<temp.length;index++) {			
			while(!stack.isEmpty() && temp[stack.peek()] < temp[index]){
					int val = stack.pop();
					ans[val] = index - val; 		
			}
			stack.push(index);
		}
		System.out.println(Arrays.toString(ans));
		return ans;
	}
	
	private void dailyTemp_bruteForce(int[] temp) {
		int[] diffArray = new int[temp.length];
		
		for(int i=0;i<temp.length;i++) {
			INNER_LOOP: for(int j=i+1;j<temp.length;j++) {
				if(temp[i]<temp[j]) {
					diffArray[i] = j-i;
					break INNER_LOOP;
				}
			}
		}
		System.out.println(Arrays.toString(diffArray));
	}
	
	
	
	
}
