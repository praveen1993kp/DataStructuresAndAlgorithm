package bruteForce_Arrays;

import org.junit.Test;

public class P11_RunningSumOf1DArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1480
	 * 
	 * Running Sum Of 1D Array
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
		int[] nums = {1,2,3,4,5};
		int[] output = {1,3,6,10,15};
		findRunningSum(nums);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,1,1,1};
		int[] output = {1,2,3,4};
		findRunningSum(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {10};
		int[] output = {10};
		findRunningSum(nums);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create array runningSum of size nums
	 * 2. Assign first element to nums first element
	 * 3. Traverse from i=1 till length of nums
	 * 4. For each value in runningSum, add previous element from runningSum and nums of current index
	 * 5. Return runningSum array
	 * 
	 */	
	
	private int[] findRunningSum(int[] nums) {
		int[] runningSum = new int[nums.length];
        runningSum[0] = nums[0];
        for(int i=1;i<nums.length;i++){
            runningSum[i] = runningSum[i-1] + nums[i];
        }
        return runningSum;	
	}

	
}
