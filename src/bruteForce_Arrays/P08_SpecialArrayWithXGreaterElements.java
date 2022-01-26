package bruteForce_Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P08_SpecialArrayWithXGreaterElements {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1608
	 * 
	 * Special Array With X Elements Greater Than or Equal to X
	 * 
	 * You are given an array nums of non-negative integers. nums is considered special if there
	 * exists a number x such that there are exactly x numbers in nums that are greater than or 
	 * equal to x.
	 * 
	 * Notice that x does not have to be an element in nums.
	 * 
	 * Return x if the array is special, otherwise return -1. 
	 * 
	 * It can be proven that nums is special, the value for x is unique.
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
		int[] nums = {0,2,3,2,4,5};
		int output = 3;
		//Assert.assertEquals(output, returnSpecialArrayNum(nums));
		returnSpecialArrayNum(nums);
	}
		

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {2,3};
		int output = 2;
		//Assert.assertEquals(output, returnSpecialArrayNum(nums));
		returnSpecialArrayNum(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100,100};
		int output = 100;
		returnSpecialArrayNum(nums);
	}
	
	
	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Find the maxNumber
	 * 2. Traverse the outerloop till maxNum
	 * 3. Create a inner loop to traverse through array elements
	 * 4. Find the number of elements greater than or equal to outerloop
	 * 5. If counter becomes greater than outer loop, break the inner loop
	 * 6. If counter is equal to j, return the counter
	 * 
	 */	
	
	private int returnSpecialArrayNum(int[] nums) {
		int counter=0, maxNum = Integer.MIN_VALUE;
        for(int k=0;k<nums.length;k++){
            if(nums[k] > maxNum) maxNum = nums[k];
        }
        
		for(int j=0;j<=maxNum;j++) {
			counter = 0;
			INNER_LOOP : for(int i=0;i<nums.length;i++) {	
				if(nums[i]>=j) counter++;
				if(counter>j) break INNER_LOOP;
			}
		if(j==counter) return counter;
		}
        return -1;
	}
}
