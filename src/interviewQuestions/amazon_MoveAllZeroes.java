package interviewQuestions;

import java.util.Arrays;

import org.junit.Test;

public class amazon_MoveAllZeroes {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Write an optimized program to move all the zeroes to the first.
	 * 
	 * 
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
		int[] nums = {1,0,5,9,0,0,6,8};
		int[] output = {0,0,0,1,5,9,6,8};
		moveZeroesToFront(nums);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {0,0,0,0,1,0};
		int[] output = {0,0,0,0,0,1};
		moveZeroesToFront(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,3,4,5};
		int[] output = {1,2,3,4,5};
		moveZeroesToFront(nums);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create two pointers left=0 and right = 1.
	 * 2. Traverse through input array for right<nums.length
	 * 3. if nums[right] == 0, swap and increment both
	 * 4. else, move right till 0 is found or right reaches length of array
	 * 5. If right less than nums length and till left<right, swap right and right-1 and decrement right
	 * 6. Continue steps 3-5 till right<nums.length
	 * 
	 */	
	
	private int[] moveZeroesToFront(int[] nums) {
		int left=0,right=1;
		while(right<nums.length) {
			if(nums[right]==0) {
				int temp = nums[left];
				nums[left++] = nums[right];
				nums[right++] = temp;
			} else {
				while(right<nums.length && nums[right] != 0) right++;
				while(right<nums.length && left<right) {
					int temp = nums[right];
					nums[right] = nums[right-1];
					nums[right-1] = temp;
					right--;
				}
			}
		}	
		System.out.println(Arrays.toString(nums));
		return nums;
	}

	
	
	
}
