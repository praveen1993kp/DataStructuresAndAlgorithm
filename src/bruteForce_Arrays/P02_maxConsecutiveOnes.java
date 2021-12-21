package bruteForce_Arrays;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P02_maxConsecutiveOnes {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * LeetCode Problem No - 485
	 * 
	 * 485. Given a binary array nums, return the maximum number of consecutive 1's in the array
	 * 
	 * Understanding:
	 * 1. Binary array - Can contain only 1s and 0s
	 * 2. Output - Maximum number of consecutive 1s
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
		int[] nums = {1,0,1,1,1,1,0};
		int expectedOutput = 4;
		Assert.assertEquals(expectedOutput,maxConsecOnes(nums));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,0,1,1,0,1,1,1,0,1,1,1};
		int expectedOutput = 3;
		Assert.assertEquals(expectedOutput,maxConsecOnes(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {0,0,0,0,0,0};
		int expectedOutput = 0;
		Assert.assertEquals(expectedOutput,maxConsecOnes(nums));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Initialize Counter and tempCounter variables to 0
	 * 2. Traverse using for loop for each element in array
	 * 3. Traverse using for loop for each element in outerloop + 1
	 * 4. If current element == 1, set the counter as 1
	 * 5. If consecutive elements are 1, add the tempCounter by 1 and continue the loop
	 * 6. At the end of inner loop, compare Counter and tempCounter values and assign latest value to counter
	 * 
	 *
	 */	
	
	public int maxConsecOnes(int[] nums) {
		int tempCounter = 0; //1
		int counter = 0; //1
		for(int i=0; i<nums.length; i++) { //n
			if (nums[i]==1) tempCounter = 1; //2
			for(int j=i+1; j<nums.length; j++) { //n
				if ((nums[i] == 1) && (nums[j] == 1)) tempCounter+=1; //2
				else break; //1
			}
			if(tempCounter>counter) counter = tempCounter; //1	
		}
		return counter; //1
	}
}
