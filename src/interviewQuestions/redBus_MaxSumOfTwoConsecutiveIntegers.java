package interviewQuestions;

import org.junit.Test;

public class redBus_MaxSumOfTwoConsecutiveIntegers {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * int[] nums = {2, 43, 22, 44, 32, 56, 780, 23, 4, 12, 0, 789, 1}
	 * 
	 * output = 6,7
	 * Find the Sum of two consecutive integers which is highest in a given array - print those indexes
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
		int[] nums = {2, 43, 22, 44, 32, 56, 780, 23, 4, 12, 0, 789, 1};
		maxSumConsecutiveIndices(nums);
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {2, 43};
		maxSumConsecutiveIndices(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2};
		maxSumConsecutiveIndices(nums);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 */	
	
	private void maxSumConsecutiveIndices(int[] nums) {
		int left = 0, right = 1, sum = 0, maxSum = 0, index1 = 0;
		if(nums.length<2) throw new RuntimeException("Less than 2 elements found");
		sum = nums[0] + nums[1];
		right++;
		maxSum = sum;
		while(right<nums.length) {
			sum = sum + nums[right++] - nums[left++];
			if(sum > maxSum) {
				maxSum = sum;
				index1 = left;
			}
		}
		
		System.out.println(maxSum);
		System.out.println(index1 + "," + (index1+1));
		
	}
}
