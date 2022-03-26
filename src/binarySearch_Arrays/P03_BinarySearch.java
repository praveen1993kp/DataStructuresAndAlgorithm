package binarySearch_Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P03_BinarySearch {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 704
	 * 
	 * Given an array of integers nums which is sorted in ascending order, 
	 * and an integer target, write a function to search target in nums.
	 * 
	 * If target exists, then return its index. Otherwise return -1
	 * 
	 * Write an algorithm in O(log n) time complexity.
	 * 
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem?   - Yes
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
		int[] nums = {-1,0,3,5,9,12};
		int target = 0;
		int expected = 1;
		Assert.assertEquals(expected, findTarget(nums,target));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {-1,0,3,5,9,12,13,14,15,16,17,18,19,20,21,22,23,24,26,27,28,30};
		int target = 2;
		int expected = -1;
		Assert.assertEquals(expected, findTarget(nums,target));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {-1,0,3,5,9,12};
		int target = 0;
		int expected = 1;
		Assert.assertEquals(expected, findTarget(nums,target));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create pointers left=0,right=nums.length-1 and mid = 0
	 * 2. Traverse till left<=right
	 * 3. If nums[mid] == target, return mid
	 * 4. Else if nums[mid] > target, decrement right
	 * 5. Else increment left
	 * 6. return -1 by default
	 * 
	 */	
	
	private int findTarget(int[] nums, int target) {
		int left=0,right=nums.length-1,mid=0;
		while(left<=right) {
			mid = (left+right)/2;
			if(nums[mid]>target) right = mid - 1;
			else if (nums[mid]<target) left = mid + 1;
			else return mid;
		}
		return -1;
	}
}
