package slidingWindow_Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P02_MinSizeSubarraySum {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * 
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem? -- YES
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
		int[] nums = {2,3,1,2,4,3};
		int target = 7;
		int expectedOutput = 2;
		Assert.assertEquals(expectedOutput, minSubArray(nums,target));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {3,6,4,5,1,2,3,4,1,8,9,0};
		int target = 9;
		//int[] nums = {1,4,4};
		//int target = 4;
		int expectedOutput = 1;
		Assert.assertEquals(expectedOutput, minSubArray(nums,target));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2,3,1,2,4,3};
		int target = 32;
		int expectedOutput = 0;
		Assert.assertEquals(expectedOutput, minSubArray(nums,target));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	private int minSubArray(int[] nums, int target) {
		int pointer1 = 0, pointer2 = 0, minlen = Integer.MAX_VALUE, sum = 0, len = 0; 
		
		while(pointer2<nums.length) {
			sum += nums[pointer2];
			while(sum > target) sum -= nums[pointer1++];
			if (sum < target) pointer2++;
			else if (sum == target) {
				len = pointer2-pointer1+1;
				if (len <= minlen) minlen = len;
					sum -= nums[pointer1++];
					pointer2++;
			}
				
			}
		if(minlen==Integer.MAX_VALUE) minlen = 0;
		System.out.println(minlen);
		return minlen;
		}
		
	}
