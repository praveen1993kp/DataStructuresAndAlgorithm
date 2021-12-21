package slidingWindow_Arrays;

import org.junit.Test;

public class P01_MaxAverage {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 643
	 * 
	 * You are given an integer array nums consisting of n elements, and an integer k.
	 * 
	 * Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. 
	 * Any answer with a calculation error less than 10^-5 will be accepted.
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
		int[] nums = {1,12,-5,-6,50,3};
		int k = 4;
		maxAverage(nums,k);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {5};
		int k = 1;
		maxAverage(nums,k);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2147483647,-2147483647,2147483647,2147483646,2147483620};
		int k = 3;
		maxAverage(nums,k);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Initialize left and right pointers and sum, maxSum variables
	 * 2. initialize maxAvg to double
	 * 3. Find the sum and average of first k elements
	 * 4. assign the sum to maxSum
	 * 5. Inside the loop, slide through
	 * 6. assign maxAvg based on maxSum
	 * 
	 */	
	
	private double maxAverage(int[] nums, int k) {
		int left = 0, right = k, sum = 0, maxSum = 0;
		double maxAvg = 0.00000;
		for(int i=0;i<k;i++) {
			sum += nums[i];
		}
		maxSum = sum;
		maxAvg = (double)maxSum/(double)k;
		for(right = k; right<nums.length;right++) {
			sum = sum - nums[left] + nums[right];
			if(maxSum < sum) {
				maxSum = sum;
				maxAvg = (double)sum/(double)k;
			}
			left++;
		}
		System.out.println(maxAvg);
		return maxAvg;
	}
}
