package binarySearch_Arrays;

import org.junit.Test;

public class P02_SearchInsertPosition {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode No - 35
	 * 
	 * Given a sorted array of distinct integers and a target value, return the index if the target 
	 * is found. If not, return the index where it would be if it were inserted in order.
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
	 * 
	 * 
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem?  -- Yes
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
		int[] nums = {1,3,5,6};
		int k = 2;
		int output = 1;
		insertPosition(nums,k);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,3,5,6};
		int k = 5;
		int output = 2;
		insertPosition(nums,k);
	}
	
	

	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,3,5,6};
		int k = 7;
		int output = 4;
		insertPosition(nums,k);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach: Binary Search
	 * 
	 * For finding index if available:
	 * 1. Initiate left=0,right=nums.length-1 and mid = 0
	 * 2. Check the value of nums[mid]
	 * 3. Iterate till left < right. For each iteration, calculate mid
	 * 		3a. If the value is < k, update left = mid + 1;
	 * 		3b. If the value is > k, update right = mid - 1;
	 * 		3c. If the value == k, 
	 * 
	 * For finding insert index if the element not available,
	 * 4. Initiate a counter at the start itself. Update the counter if any match is found
	 * 		4a. If not found, return the index of left. (Refer excel Workout Session).
	 * 
	 * 
	 */	
	
	private int insertPosition(int[] nums, int k) {
		int left=0, right = nums.length-1, mid = 0, counter = 0;
		while(left<=right) {
			mid = (left+right)/2;    //alternate mid=low+(high-low)/2;
			if(nums[mid] == k) {
				System.out.println(mid);
				counter++;
				return mid;
			}
			else if (nums[mid] < k) left = mid + 1;
			else right = mid - 1;
		}
		if(counter==0) {
			System.out.println(left);
			return left;
		}
		return -1;
	}
}
