package bruteForce_Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P12_LargestNumberTwiceOfOthers {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 747
	 * 
	 * You are given an integer array nums where the largest integer is unique.
	 * 
	 * Determine whether the largest element in the array is at least twice as much as
	 * every other number in the array. If it is, return the index of the largest element, or return -1 otherwise.
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
		int[] nums = {3,6,1,0};
		int index = 1;
		Assert.assertEquals(index, findIfTwice(nums));
	}
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2,3,4};
		int index = -1;
		Assert.assertEquals(index, findIfTwice(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1};
		int index = 0;
		Assert.assertEquals(index, findIfTwice(nums));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Find the maxNum in given array
	 * 2. Traverse through each element in array and if the current element is not maxNum,
	 * 		2a. If all the elements value * 2 are greater than or equal to maxNum, return the maxNum index
	 * 		2b. Else return -1
	 * 
	 */	
	
	private int findIfTwice(int[] nums) {
		int maxNum = Integer.MIN_VALUE;
		for(int i=0;i<nums.length;i++) 
			if(nums[i] > maxNum) maxNum = nums[i];
				
		for(int j=0;j<nums.length;j++) {
			if(nums[j]!=maxNum) {
				if(nums[j]*2 <= maxNum) continue;
				else return -1;
			}
		}		
		return 1;
	}
}
