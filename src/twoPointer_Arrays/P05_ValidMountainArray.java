package twoPointer_Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P05_ValidMountainArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 941
	 * 
	 * Valid Mountain Array
	 * 
	 * Given an array of integers arr, return true if and only if it is a valid mountain array
	 * 
	 * Recall that arr is a mountain array if and only if
	 * 
	 * arr.length >= 3
	 * 
	 * There exists some i with 0 < i < arr.length-1 such that
	 * 	arr[0] < arr[1] < .... < arr[i-1] < arr[i]
	 *  arr[i] > arr[i+1] .... > arr[nums.length-1]
	 * 
	 * Daily Leetcode Challenge - 25/01/2022
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
		int[] nums = {0,2,3,4,5,2,1,0};
		boolean expected = true;
		Assert.assertEquals(expected, ifValidMountain(nums));
	}
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2,3,4,5,6,5,4,3,2,1};
		boolean expected = true;
		Assert.assertEquals(expected, ifValidMountain(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {0,2};
		boolean expected = false;  //size less than 2
		Assert.assertEquals(expected, ifValidMountain(nums));
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums = {2,3,4,5,6};
		boolean expected = false;  //peak element at last
		Assert.assertEquals(expected, ifValidMountain(nums));
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		int[] nums = {8,5,4,3,2};
		boolean expected = false;  //peak element at first
		Assert.assertEquals(expected, ifValidMountain(nums));
	}
	
	@Test
	public void example6() {
		//Negative Test Data
		int[] nums = {3,5,5};
		boolean expected = false;  //peak element at first
		Assert.assertEquals(expected, ifValidMountain(nums));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Algorithm : Two Pointer - Opposite Direction
	 * 
	 * 1. Initialize variables maxIndex and maxNum
	 * 2. Find the maximum number and its index.
	 * 3. Traverse till left less than right
	 * 4. If left less than maxIndex, validate if the numbers are in strictly increasing order
	 * 5. If right greater than maxIndex, validate if the numbers are strictly in decreasing order (max till end)
	 * 
	 * Edge cases: 
	 * 1. If given array size less than two, return false
	 * 2. After finding maxIndex, if it is 0 or last element, return false
	 * 
	 */	
	
	private boolean ifValidMountain(int[] nums) {
		if(nums.length<3) return false;
		
		int maxIndex = -1, maxNum = -1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i] > maxNum) {
				maxNum = nums[i];
				maxIndex = i;
			}
		}
		if(maxIndex == 0 || maxIndex == nums.length-1) return false;
		
		int left = 0, right = nums.length-1;
		while(left<right) {
			if(left<maxIndex) {
				if(nums[left]>=nums[left+1]) return false;
				left++;
			}
			if(right>maxIndex) {
				if(nums[right]>=nums[right-1]) return false;
				right--;
			}
		}
		return true;
	}
}
