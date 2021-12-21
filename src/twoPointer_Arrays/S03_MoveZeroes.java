package twoPointer_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class S03_MoveZeroes {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * LeetCode Problem No - 283
	 * 
	 * Given an integer array nums, move all 0's to the end of it while maintaining
	 * the relative order of non-zero elements.
	 * 
	 * Understanding:
	 * 1. Given 
	 * 	* Integer array nums
	 * 2. When
	 * 	* Array contains 0/multiple 0s,
	 * 3. Then
	 *  * Move all 0's to end of the array
	 * 4. Condition
	 *  * Maintain relative order of non-zero elements
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem?  - yes
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
	 * 3. Do I know to solve it?  - yes using two pointer
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
		int[] nums = {1,0,3,0,0,4,5,0,0,3,12,15};
		int[] outputArray = {1,3,4,5,3,12,15,0,0,0,0,0}; 
		Assert.assertTrue(Arrays.equals(outputArray, moveZeroesMethod(nums)));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = new int[5];
		nums[4] = 1;
		nums[3] = 2;		
		int[] outputArray = {2,1,0,0,0};
		Assert.assertTrue(Arrays.equals(outputArray, moveZeroesMethod(nums)));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,3,4,5,3,12,15};
		int[] nums2 = {0};
		int[] nums3 = {2,1};
		int[] nums4 = {0,1,0,3,12};
		int[] outputArray = {1,3,4,5,3,12,15};
		int[] outputArray2 = {0};
		int[] outputArray3 = {2,1};
		int[] outputArray4 = {1,3,12,0,0};
		Assert.assertTrue(Arrays.equals(outputArray3, moveZeroesMethod(nums3)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Create two variables pointer1 and pointer2. Initialize pointer1 to 0 and pointer2 to 1;
	 * 2. pointer1 = 0 and pointer2 != 0 --> swap them and increase pointer1 and pointer2 by 1
	 * 3. pointer1 = 0 and pointer2 == 0 --> increase pointer2 by 1
	 * 4. pointer1 !=0 --> increase pointer1 by 1;
	 */	
	
	public int[] moveZeroesMethod(int[] nums) {
		int pointer1 = 0;
		int pointer2 = 0;
		while(pointer2<nums.length) {
			if(nums[pointer2] != 0) {
				int temp = nums[pointer1];
				nums[pointer1++] = nums[pointer2];
				nums[pointer2++] = temp;
			} else if (nums[pointer1] == 0){
					pointer2++;
			} else {
					pointer1++;
			}			
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
