package slidingWindow_Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P03_ContainsDuplicateII {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 219
	 * 
	 * Given an integer array nums and an integer k,
	 *  return true if there are two distinct indices i and j in the array 
	 *  such that nums[i] == nums[j] and abs(i - j) <= k.
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
		int[] nums = {1,2,3,1};
		int k = 3;
		boolean expectedOutput = true;
		Assert.assertEquals(expectedOutput, containsDuplicate(nums,k));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,1,3,1,2,1,1};
		int k = 2;
		boolean expectedOutput = true;
		Assert.assertEquals(expectedOutput, containsDuplicate(nums,k));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,1,3,1,2,1,1};
		int k = 8;
		boolean expectedOutput = false;
		Assert.assertEquals(expectedOutput, containsDuplicate(nums,k));
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Create two pointers left=0, right=1 and variable leng
	 * 2. while both pointers are less than given array size, iterate
	 * 3. when second pointer reaches the array size, increase first pointer by 1 and assign right = left +1;
	 * 4. When elements are found, calculate length and use Math.abs to see if the diff is matching with k;
	 * 5. If true, break. else run till a result is found or loop is completed. 
	 */	
	
	private boolean containsDuplicate(int[] nums, int k) {
		int left = 0, right = 1, leng = 0;
		boolean result = false;
		while(right<nums.length && left<nums.length) {
			if(nums[left] == nums[right]) {
				leng = left-right;
				result = Math.abs(leng)==k;	
				if (result) break;
			}
			right++;
			if(right==nums.length) {
				left++;
				right = left+1;
			}	
		}
		System.out.println(result);
		return result;
	}
}
