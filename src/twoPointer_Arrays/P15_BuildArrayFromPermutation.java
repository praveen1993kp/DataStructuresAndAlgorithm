package twoPointer_Arrays;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P15_BuildArrayFromPermutation {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1920
	 * 
	 * Build Array From Permutation
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
		int[] nums = {0,2,1,5,3,4};
		int[] ans = {0,1,2,4,5,3};
		Assert.assertTrue(Arrays.equals(ans, buildArray(nums)));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {5,0,1,2,3,4};
		int[] ans = {4,5,0,1,2,3};
		Assert.assertTrue(Arrays.equals(ans, buildArray(nums)));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {5,4,3,2,1,0};
		int[] ans = {0,1,2,3,4,5};
		Assert.assertTrue(Arrays.equals(ans, buildArray(nums)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Algorithm : Two Pointer
	 * 
	 * 1. Create output array ans of size n
	 * 2. Create pointers left = 0, right = n-1 (Can be equidirectional, Also, can be done without twopointer also)
	 * 3. Traverse while left<=right
	 * 		3a. If left<right, assign right value as nums[nums[right]] and decrement right
	 * 		3b. assign left value as nums[nums[left]] and increment left
	 * 4. Return ans
	 * 
	 */	
	
	private int[] buildArray(int[] nums) {
		int[] ans = new int[nums.length];
        int left=0,right=nums.length-1;
        while(left<=right){
            if(left<right) ans[right] = nums[nums[right--]];
            ans[left] = nums[nums[left++]];      
        }
        return ans;
	}
}
