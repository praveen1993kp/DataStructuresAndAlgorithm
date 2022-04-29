package bruteForce_Arrays;

import org.junit.Test;

public class P30_SortArrayElementsByParity {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 905
	 * 
	 * Sort Array Elements By Parity
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
		int[] nums = {3,1,2,4};
		sortArrayByParity(nums);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {0};
		sortArrayByParity(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2,4,6,6};
		sortArrayByParity(nums);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach 1 :
	 * 
	 * 1. Create outputarray of same size as nums
	 * 2. Create variable insertIndex
	 * 3. Add all the even elements first
	 * 4. Add all the odd elements 
	 * 5. Return output array
	 * 
	 * Approach 2 - Two Pointers:
	 * 
	 * 1. Create outputarray of same size as nums
	 * 2. Create pointers evenIndex=0 and oddIndex = nums.length-1;
	 * 3. If even element found, add in its index and increment the insertIndex
	 * 4. If odd element found, add in its index and decrement the insertIndex
	 * 5. Return the output array
	 * 
	 */	
	
	private int[] sortArrayByParity(int[] nums) {
		int insertIndex=0;
        int[] output = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0) output[insertIndex++] = nums[i];
        }
        for(int j=0;j<nums.length;j++){
            if(nums[j]%2!=0) output[insertIndex++] = nums[j];
        }
        return output;
	}
	
	private int[] sortArrayByParity_TwoPointers(int[] nums) {
		int[] output = new int[nums.length];
		int evenIndex=0,oddIndex=nums.length-1;
		for(int i=0;i<nums.length;i++) {
			if(nums[i]%2==0) output[evenIndex++] = nums[i];
			else output[oddIndex--] = nums[i];
		}
		return output;
	}
}
