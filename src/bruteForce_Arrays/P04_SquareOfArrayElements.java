package bruteForce_Arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P04_SquareOfArrayElements {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * LeetCode - 977
	 * 
	 * Given a sorted integer array in non-decreasing order, 
	 * return the array of the squares of each number sorted in non-decreasing order
	 * 
	 * Understandings:
	 * 1. The array contains only integers
	 * 2. The array is always sorted
	 * 3. Non - decreasing order --> Can have same elements in consecutive positions
	 * 4. Return --> Square of each number 
	 * 5. Return --> Return in non-decreasing order - Can have same elements in consecutive positions too
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
		int[] nums = {1,2,3,3,4,5};
		int[] outputExpected = {1,4,9,9,16,25};
		
		Assert.assertTrue(Arrays.equals(outputExpected, squareTwoPointer(nums)));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {-5,-4,-3,1,3,4};
		int[] outputExpected = {1,9,9,16,16,25};
		Assert.assertTrue(Arrays.equals(outputExpected, squareTwoPointer(nums)));
		
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {3};
		int[] outputExpected = {9};
		Assert.assertTrue(Arrays.equals(outputExpected, squareTwoPointer(nums)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Brute Force:
	 * 
	 * 1. Traverse through each element of the array using for loop
	 * 2. Multiply the number with same number
	 * 3. Store it in the same element of the array
	 * 4. After the end of for loop, sort using Arrays.sort() method
	 * 
	 * Two Pointer Algorithm :
	 * 1. Create an output array of size same that of input array
	 * 2. Create pointers left=0,right=outputArray.length-1 and index = outputArray.length-1;
	 * 3. Compare the values in nums[left] and nums[right]
	 * 		3a. Whenever one of the Math.abs values are greater, add the highest one to current index of new array.
	 * 		3b. Decrement the index and also decrement/increment right/left based on element added into another array.
	 * 		3c. When Math.abs values of left and right are equal, add any one of the value into new one and change its pointer value
	 * 4. Traverse through nums array till left is less than right
	 * 
	 */	
	
	public int[] squareMethod(int[] nums) {
		for(int i=0; i<nums.length; i++) 
			nums[i] = nums[i] * nums[i];
		Arrays.sort(nums); // Time Complexity is O[n log n]
		return nums;
	}
	
	public int[] squareTwoPointer(int[] nums) {
		int left=0,right=nums.length-1,insertPosition=nums.length-1;  //O[1]
		int[] outputArray = new int[nums.length];  //O[1]
		
		while(left<=right) {   //O[3n]
			if(Math.abs(nums[right])>=Math.abs(nums[left])) //O[1]
				outputArray[insertPosition--] = nums[right] * nums[right--]; //O[1]
			else 
				outputArray[insertPosition--] = nums[left] * nums[left++]; //O[1]
		}
		
		System.out.println(Arrays.toString(outputArray)); //O[1]
		return outputArray; //O[1]
		
	}
}
