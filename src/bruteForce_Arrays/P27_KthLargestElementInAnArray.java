package bruteForce_Arrays;

import java.util.Arrays;

import org.junit.Test;

public class P27_KthLargestElementInAnArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 215
	 * 
	 * Kth Largest Element In An Array
	 * 
	 * Given an integer array nums and an integer k, return the kth largest element in the array.
	 * Note that it is the kth largest element in the sorted order, not the kth distinct element.
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
		int[] nums = {3,2,1,5,6,4};
		int k=2;
		findKthLargestElementInAnArray(nums,k);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1};
		int k=1;
		findKthLargestElementInAnArray(nums,k);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {3,3,3,3,3,3};
		int k=2;
		findKthLargestElementInAnArray(nums,k);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Sort the given array
	 * 2. Return the kth element from last 
	 * 		2a. Obtained by nums.length-k
	 * 
	 */	
	
	public int findKthLargestElementInAnArray(int[] nums,int k) {
		Arrays.sort(nums);
        return nums[nums.length-k]; 
	}
}
