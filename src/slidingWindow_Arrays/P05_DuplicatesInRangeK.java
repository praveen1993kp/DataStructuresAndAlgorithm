package slidingWindow_Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Test;

public class P05_DuplicatesInRangeK {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Find duplicates within a range k
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
		int[] nums = {5,6,8,3,4,6,9};
		int k = 4;
		findDuplicates(nums,k);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {5,6,8,3,4,6,9};
		int k = 2;
		findDuplicates(nums,k);
		//maxAverage(nums,k);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,3,2,1};
		int k = 7;
		findDuplicates(nums,k);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Initialize left and right pointers and sum, maxSum variables
	 * 2. initialize maxAvg to double
	 * 3. Find the sum and average of first k elements
	 * 4. assign the sum to maxSum
	 * 5. Inside the loop, slide through
	 * 6. assign maxAvg based on maxSum
	 * 
	 */	
	
	private String findDuplicates(int[] nums, int k) {
		int left = 0, right = 1, element = 0;
		String result = "";
		while (right<nums.length) {
				if(nums[left]==nums[right]) {
					element = nums[left];
					result = "Duplicates found and duplicate element " + element;
					break;
				} 
				right++;
				if(right-left>k) {
					left++;
					right = left + 1;
				}
		}
		if (result=="") result = "Duplicates not found";
		System.out.println(result);
		return result;
	}
}
