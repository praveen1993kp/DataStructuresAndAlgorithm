package queue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class S01_RotateKElements {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Rotate Initial K Elements in given array
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
		int[] nums  = {4,6,8,11,10,18};
		int k = 3;
		rotateKElementsInArray(nums,k);
		//output 8,6,4,11,10,18
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums  = {10,10,60,40,20,10,50};
		int k = 4;
		rotateKElementsInArray(nums,k);
		//output : 40,60,10,10,20,10,50
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums  = {4,6,8,11,10,18};
		int k = 6;
		rotateKElementsInArray(nums,k);
		//output : 18,10,11,8,6,4
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 *  1. deque.push adds element at the first
	 *  2. deque.offer adds element at the last
	 *  
	 *  1. Create a deque with Integer type
	 *  2. Traverse through the length of given array
	 *  3. If i less than k, do deque.push
	 *  4. Else, do deque.offer
	 * 
	 */	
	
	private void rotateKElementsInArray(int[] nums, int k) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		for(int i=0;i<nums.length;i++) {
			if(i<k) deque.push(nums[i]);
			else deque.offer(nums[i]);
		}
		System.out.println(deque);
	}

}
