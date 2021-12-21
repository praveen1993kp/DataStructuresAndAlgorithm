package slidingWindow_Arrays;

import org.junit.Test;

public class S02_SubArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given an array of positive integers, find the subarrays that adds up to the given number (k)
	 * 
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem?  - Yes
	 * 	yes or no 
	 * 	If no ask the person to provide
	 * 	with more details with examples 
	 * 	If yes go to the next step What is the
	 * 	input(s)? What is the expected output? 
	 * 
	 * 	Do I have any constraints to solve the - Solve using sliding window
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
		int[] nums = {1,7,4,3,1,2,1,5,1};
	    int k = 7;
		//expectedOutput 1,1    2,3    3,6    6,8
	    maxConsecutiveSum(nums,k);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {21,27,24,23,1,1,2,1,3,1};
	    int k = 3;
	    subArray(nums,k);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,7,4,3,1,2,1,5,1};
	    int k = 32;
	    subArray(nums,k);
	}
	
	/*
	 * --- Pseudo Code ---
	 * /*
     * Start with first element If the sum is less than the desired sum, slide to
     * the next element [Grow] 
     * Again, sum that and check if it is lesser, equal or
     * greater 
     * If it is lesser, add the next element to slide [Grow] 
     * If it is greater, than shrink the last element on the left [Shrink] 
     * If it is equal, you got it and again do both Grow and Shrink [Slide]
     * 
     */
	 	
	
	public void subArray(int[] nums, int k) {
		int left = 0, right = 0, sum = 0;
		for(right=0;right<nums.length;right++) {
			sum += nums[right];
			while(sum>k) {
					sum -= nums[left];
					left++;
				}
			if(sum == k) {
				System.out.println(left+","+right);
			}
		}
	}
	
	private void  maxConsecutiveSum(int[] nums, int k) {
		int left = 0, right = 0, sum = 0;
		for(right = 0; right<nums.length;right++) {
			sum += nums[right];
			while(sum > k) {
				sum -= nums[left];
				left++;
			}
			if (sum == k){
				System.out.println(left + "," + right);
			}
		}
		
	}
}
