package bruteForce_Arrays;

import java.util.Arrays;

import org.junit.Test;

import junit.framework.Assert;

public class P22_RotateArray_LeftRotation {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * 
	 * Hackerrank
	 * 
	 * A left rotation operation on an array of size  shifts each of the array's elements  
	 * unit to the left. Given an integer, 
	 * rotate the array that many steps left and return the result.
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
		int[] nums = {1,2,3,4,5,6,7};
		int d=3;
		int[] output = {4,5,6,7,1,2,3};
		Assert.assertTrue(Arrays.equals(rightRotateArray(nums,d),output));
	}
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {-1,-100,3,99};
		int d=2;
		int[] output = {3,99,-1,-100};
		Assert.assertTrue(Arrays.equals(rightRotateArray(nums,d),output));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,3,4,5,6,7};
		int d=1;
		int[] output = {2,3,4,5,6,7,1};
		Assert.assertTrue(Arrays.equals(rightRotateArray(nums,d),output));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Left rotation formula:
	 * 
	 * 1. Rotate elements from 0 to n-1
	 * 2. Rotate elements from 0 to n-d-1
	 * 3. Rotate elements from n-d to n-1
	 * 
	 */	
	
	private int[] rightRotateArray(int[] nums, int d) {
		int n=nums.length;
		rotateArray(0,n-1,nums);
		rotateArray(0,n-d-1,nums);
		rotateArray(n-d,n-1,nums);
		return nums;
	}
	
	public int[] rotateArray(int start,int end,int[] nums) {
		while(start<end) {
			int temp = nums[start];
			nums[start++] = nums[end];
			nums[end--] = temp;
		}
		return nums;
		
	}
}
