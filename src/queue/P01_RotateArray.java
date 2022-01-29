package queue;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P01_RotateArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 189
	 * 
	 * Given an array, rotate the array to the right by k steps, where k is non-negative.
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
		int[] nums = {1,2,3,4,5,6,7};
		int k = 3;
		//output = {5,6,7,1,2,3,4};
		rotateArrayToRight(nums,k);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2,3,4,5,6,7};
		int k = 6;
		//output = {2,3,4,5,6,7,1};
		rotateArrayToRight(nums,k);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {-1,-100,3,99};
		int k = 2;
		//output = {3,99,-1,-100};
		rotateArrayToRight(nums,k);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	private String rotateArrayToRight(int[] nums, int k) {
		ArrayDeque<Integer> deque = new ArrayDeque<>();
		
		int index=nums.length-1;
		int kIndex = k;
		while(kIndex>0) {
			deque.push(nums[index--]);
			kIndex--;
		}
		for(int i=0;i<nums.length-k;i++) deque.offer(nums[i]);
		//System.out.println(deque);
		
		return deque.toString();
	}

}
