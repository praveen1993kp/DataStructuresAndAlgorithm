package twoPointer_Arrays;

import org.junit.Test;

public class P17_ShuffleTheString {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1470
	 * 
	 * Shuffle The Array
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
		int[] nums = {2,5,1,3,4,7};
		int n=3;
		shuffleTheArray(nums,n);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2,3,4,4,3,2,1};
		int n=4;
		shuffleTheArray(nums,n);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,1,2,2};
		int n=2;
		shuffleTheArray(nums,n);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create an output array of same size as that of nums
	 * 2. Create pointers left, right and index
	 * 3. Traverse till right crosses nums
	 * 4. In the new array, add elements from left and right in consecutive indices and increment respectively
	 * 5. Repeat till step 3 is achieved
	 * 6. Return the new array
	 * 
	 */	
	
	private int[] shuffleTheArray(int[] nums, int n) {
		// TODO Auto-generated method stub
		int[] arr = new int[2*n];
        int left=0,right=n,index=0;
        while(right<nums.length){
            arr[index++] = nums[left++];
            arr[index++] = nums[right++];
        }
        return arr;
	}
}
