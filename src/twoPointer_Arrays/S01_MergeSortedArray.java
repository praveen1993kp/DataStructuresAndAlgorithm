package twoPointer_Arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class S01_MergeSortedArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.

		Merge nums1 and nums2 into a single array sorted in non-decreasing order.

		The final sorted array should not be returned by the function, 
		but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
	 * 
	 * 
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
	 * 	problem? Do I have all the information to go to the next steps  - O[n]
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
		int[] nums1 = {1,2,3};
		int[] nums2 = {2,5,6};
		int[] expectedOutput = {1,2,2,3,5,6};
		Assert.assertTrue(Arrays.equals(expectedOutput, mergeSortedArray(nums1,nums2)));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums1 = {1};
		int[] nums2 = {-1,1,3,5};
		int[] expectedOutput = {-1,1,1,3,5};
		Assert.assertTrue(Arrays.equals(expectedOutput, mergeSortedArray(nums1,nums2)));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums1 = {};
		int[] nums2 = {1,3,5};
		int[] expectedOutput = {1,3,5};
		Assert.assertTrue(Arrays.equals(expectedOutput, mergeSortedArray(nums1,nums2)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Get the size of two arrays and create a new array of size m+n
	 * 2. while(nums1[pointer1] < nums2[pointer2]) --> add least one to new array
	 * 3. increase least one ++;
	 * 
	 * 
	 * 
	 */	
	
	public int[] mergeSortedArray(int[] nums1,int[] nums2) {
		int pointer1 = 0;
		int pointer2 = 0;
		int m = nums1.length;
		int n = nums2.length;
		int index = 0;
		int[] newArray = new int[m + n];
		while (pointer1 < m || pointer2 < n) {
			if(pointer1 == m) newArray[index++] = nums2[pointer2++];
			else if (pointer2 == n) newArray[index++] = nums1[pointer1++];
			else if (nums1[pointer1] <= nums2[pointer2]) {
				newArray[index++] = nums1[pointer1++];
			} else {
				newArray[index++] = nums2[pointer2++];
			}
		}
		System.out.println(Arrays.toString(newArray));
		return newArray;
	}
}
