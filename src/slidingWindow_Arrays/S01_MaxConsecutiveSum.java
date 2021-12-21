package slidingWindow_Arrays;

import org.junit.Assert;
import org.junit.Test;

public class S01_MaxConsecutiveSum {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given an int array nums and target element k,
	 * 	find the maximum sum that can be obtained by
	 * 	adding k elements in the array
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
		int[] nums = {1,5,2,3,7,1};
		int k = 3;
		int expectedOutput = 12;
		//Assert.assertEquals(expectedOutput,maxConsecutiveSum(nums,k));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,5,2,3,7,1};
		int k = 1;
		int expectedOutput = 7;
		//Assert.assertEquals(expectedOutput,maxConsecutiveSum(nums,k));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {3,5,2,3,7,2};
		int k = 6;
		int expectedOutput = 22;
		//Assert.assertEquals(expectedOutput,maxConsecutiveSum(nums,k));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Find the sum of first k elements
	 * 2. Assign it to maxSum
	 * 3. 
	 * 
	 */	
	private int  maxConsecutiveSum(int[] nums, int k) {
		int left = 0, right = k, sum = 0, maxSum = 0;
		while(left<k) {
			sum += nums[left];
			left++;
		}
		maxSum = sum;
		for(right = k;right<nums.length;right++) {
			sum = sum - nums[right-k] + nums[right];
			if(sum > maxSum) maxSum = sum;
		}
		System.out.println(maxSum);
		return maxSum;
	}
	
}
