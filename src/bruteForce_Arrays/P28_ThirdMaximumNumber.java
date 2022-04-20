package bruteForce_Arrays;

import org.junit.Test;

public class P28_ThirdMaximumNumber {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 414
	 * 
	 * Third Maximum Number
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
		int[] nums = {3,2,1};
		System.out.println(findThirdMaximum(nums));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {3,2};
		System.out.println(findThirdMaximum(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2,2,3,1};
		System.out.println(findThirdMaximum(nums));
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums = {1,1,2};
		System.out.println(findThirdMaximum(nums));
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create variables first, second and third of data type long and initialize to minimum of long
	 * 		1a. Creating long since Integer.MIN_VALUE could be a value in array itself
	 * 2. Traverse through the given array
	 * 3. If the element is greater than first, swap values of third second and first and assign first with nums[i]
	 * 4. If the element is greater than second and less than first, swap values of third and second and assign second with nums[i]
	 * 5. If the element is greater than third and less than second, assign third with nums[i]
	 * 6. After traversing through all elements, if the value of third is Long.MIN_VALUE, return first
	 * 7. Return third by default
	 * 
	 * 
	 */	
	
	private int findThirdMaximum(int[] nums) {
		long first = Long.MIN_VALUE;
		long second = Long.MIN_VALUE;
		long third = Long.MIN_VALUE;
		
		for(int i=0;i<nums.length;i++) {
			if(nums[i] > first) {
				third = second;
				second = first;
				first = nums[i];
			} else if (nums[i] > second && nums[i] < first) {
				third = second;
				second = nums[i];
			} else if (nums[i] > third && nums[i] < second) {
				third = nums[i];
			}
		}
		if(third == Long.MIN_VALUE) return (int)first;
		
		return (int)third;
		
	}
}
