package slidingWindow_Arrays;

import org.junit.Test;

public class P06_SubArraySizeKAndAvgGreaterThanOrEqualToThreshold {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 1343
	 * 
	 * Given an array of integers arr and two integers k and threshold, return the number of 
	 * sub-arrays of size k and average greater than or equal to threshold
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
		int[] nums = {2,2,2,2,5,5,8};
		int k = 3;
		int threshold = 4;
		findAverage(nums,k,threshold);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {11,13,17,23,29,31,7,5,2,3};
		int k = 3;
		int threshold = 5;
		findAverage(nums,k,threshold);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2,2,2,2,2,2,2};
		int k = 3;
		int threshold = 4;
		findAverage(nums,k,threshold);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create pointers left,right=0. Count=0 and sum=0
	 * 2. For first k elements, add the sum
	 * 3. If sum/k greater than or equal to threshold, increment the count
	 * 4. Traverse through the length of given array
	 * 5. Reduce the value of nums[left] from sum and increment the value of nums[right]
	 * 6. Increment left and right
	 * 7. If average is greater than or equal to threshold, increment the count
	 * 8. Return the count
	 * 
	 */	
	
	private int findAverage(int[] nums, int k, int threshold) {
		int left=0,right=0,count=0,sum=0;
        while(right<k)
            sum += nums[right++];
        
        if ((sum/k) >= threshold) count++;
        
        while(right<nums.length){
            sum += nums[right++] - nums[left++];
            if ((sum/k) >= threshold) count++;
        }
        return count;
	}
}
