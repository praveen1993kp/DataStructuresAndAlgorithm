package twoPointer_Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P12_PivotIndex {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 724
	 * 
	 * Find The Leftmost Pivot Index In Array
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
		int[] nums = {2,3,-1,8,4};
		int output = 3;
		Assert.assertEquals(output, findMiddleIndex(nums));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,-1,4};
		int output = 2;
		Assert.assertEquals(output, findMiddleIndex(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2,5};
		int output = -1;
		Assert.assertEquals(output, findMiddleIndex(nums));
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums = {1,7,3,6,5,6};
		int output = 3;
		Assert.assertEquals(output, findMiddleIndex(nums));
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		int[] nums = {1,2,3};
		int output = -1;
		Assert.assertEquals(output, findMiddleIndex(nums));
	}
	
	@Test
	public void example6() {
		//Negative Test Data
		int[] nums = {2,1,-1};
		int output = 0;
		Assert.assertEquals(output, findMiddleIndex(nums));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create variables index, leftSum, rightSum and sum
	 * 2. Find the total sum of given array
	 * 3. Traverse through each idex of given array
	 * 4. Find the leftSum for each element (excluding current index)
	 * 5. Find the rightSum as sum-leftSum-currentvalue
	 * 6. At any instance if leftSum==rightSum, return the index
	 * 7. Else return -1
	 * 
	 */	
	
	private int findMiddleIndex(int[] nums) {
		int index = 0,leftSum = 0,rightSum=0,sum=0;
		for(int i=0;i<nums.length;i++) {
			sum += nums[i];
		}
		while(index<nums.length) {
			if(index!=0)leftSum += nums[index-1];
			rightSum = sum - leftSum - nums[index];
			if(leftSum==rightSum) return index;
			index++;
		}
		return -1;
		
	}
}
