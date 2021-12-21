package bruteForce_Arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P03_MajorityElement {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * LeetCode Problem No - 169
	 * 
	 * Given an array nums of size n, return the majority element.
	 * The majority element is the element that appears more than n/2 times. You may assume that majority element always exists in the array.
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem?  - YES
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
	 * Are negative values allowed ? 
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
		int[] nums = {6,6,6,7,7};
		int expected = 6;
		Assert.assertEquals(expected, majorityElement(nums));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1};
		int expected = 1;
		Assert.assertEquals(expected, majorityElement(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {6,6,6};
		int expected = 6;
		Assert.assertEquals(expected, majorityElement(nums));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Create counter and tempCounter variables
	 * 2. Create two loops for traversing
	 * 3. Whenever values from loops matches, add tempCounter by 1
	 * 4. At the end of inner loop, update counter value
	 * 5. Create a condition for arraysize 1;
	 */	
	
	public int majorityElement(int[] nums) {
		int counter = 1;
		int tempCounter = 1;
		int maxNumber = Integer.MIN_VALUE;
		if(nums.length == 1) maxNumber=nums[0];
		else {
			for(int i=0;i<nums.length;i++) {
				tempCounter = 1;
				for(int j=i+1;j<nums.length;j++) {
					if(nums[i] == nums[j]) tempCounter += 1;
				}
				if(tempCounter>counter) {
					counter=tempCounter;
					maxNumber = nums[i];
				}
			}
		}
		System.out.println(maxNumber);
		return maxNumber;
	}
}
