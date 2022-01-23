package twoPointer_Arrays;

import org.junit.Test;

public class P04_FindIfThereExistsTwoElementsWithTargetSum {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given a sorted array A (sorted in ascending order), having N integers, 
	 * find if there exists any pair of elements (A[i], A[j]) such that their sum is equal to X.
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
		int[] nums = {10,20,35,50,75,80};
		int target = 70;
		findSumIndices(nums,target);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {10,20,35,50,75,80};
		int target = 720;
		findSumIndices(nums,target);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {10,11,12,13,14,15,16};
		int target = 31;
		findSumIndices(nums,target);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Algorithm : Two Pointer (Opposite Directional)
	 * 
	 * 1. Traverse till left < right
	 * 2. left = 0 and right = array length-1
	 * 3. If sum > target, decrement right
	 * 4. Else if sum < target, increment right
	 * 5. Else return the indices
	 * 
	 */	
	
	private void findSumIndices(int[] nums, int target) {
		int left = 0,right = nums.length-1;
		
		while(left < right) {
			if(nums[left] + nums[right] > target) right--;
			else if (nums[left] + nums[right] < target) left++;
			else {
				System.out.println(left + " -- " + right);
				break;
			}
		}
		
	}
}
