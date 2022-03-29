package bruteForce_Arrays;

import java.util.HashSet;

import org.junit.Test;

public class P26_FindTheDuplicateNumber {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 287
	 * 
	 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
	 * 
	 * There is only one repeated number in nums, return this repeated number.
	 * 
	 * You must solve the problem without modifying the array nums and uses only constant extra space.
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
		int[] nums = {1,3,4,2,2};
		int output = 2;
		findDuplicateNumber_usingSet(nums);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {3,1,3,4,2};
		int output = 3;
		findDuplicateNumber_usingSet(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,1};
		int output = 1;
		findDuplicateNumber_usingSet(nums);	
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach 1 - Using Set
	 * 
	 * 1. Create hashSet
	 * 2. Traverse through given array
	 * 3. If the number is not added into hashset, return nums[i]
	 * 
	 * Approach 2 - Using Constant extra space
	 * 
	 * 1. Create an output array of size same as nums
	 * 2. Traverse through given array
	 * 3. If(ans[nums[i]==0) replace it with -1
	 * 4. Else return nums[i]
	 * 
	 */	
	
	private int findDuplicateNumber_usingSet(int[] nums) {
		HashSet<Integer> hSet = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!hSet.add(nums[i])) return nums[i];
        }
        return -1;	
	}
	
	private int findDuplicateNumber_usingConstantExtraSpace(int[] nums) {
		int[] ans = new int[nums.length];
        int i=0;
        while(i<nums.length){
            if(ans[nums[i]]==0) ans[nums[i++]] = -1;
            else return nums[i];
        }
        return -1;
	}

	
}
