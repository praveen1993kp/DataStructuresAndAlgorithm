package slidingWindow_Arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.TreeMap;

import org.junit.Test;

public class P08_KDiffPairsInAnArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 532
	 * 
	 * K-diff pairs in an array
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
		int[] nums = {3,1,4,1,5};
		int k = 2;
		int output = 2;
		findKDiffPairs(nums,k);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2,3,4,5};
		int k = 1;
		int output = 4;
		findKDiffPairs(nums,k);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,3,1,5,4};
		int k = 0;
		int output = 1;
		findKDiffPairs(nums,k);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Sort the given array
	 * 2. Initialize left=0 and right=1
	 * 3. If nums[right]-nums[left] > k, increment left
	 * 4. Else if nums[right]-nums[left] < k, increment right
	 * 5. Else if both are equal, add to set and increment both
	 * 6. Return the set size
	 * 
	 */	
	
	private void findKDiffPairs(int[] nums, int k) {
		int left=0,right=1,count=0;
		Arrays.sort(nums);
		String prevVal = "";
		while(right<nums.length) {
			if(Math.abs(nums[right]-nums[left]) < k) right++;
			else if (Math.abs(nums[right]-nums[left]) > k) left++;
			else {
				if(left!=right) {
					if(prevVal != ""+nums[left]+nums[right]) {
						prevVal = ""+nums[left++]+nums[right++];
						System.out.println(prevVal);
						count++;
					} else right++;	
				}	
			}
		}
		System.out.println(count);
	}
}
