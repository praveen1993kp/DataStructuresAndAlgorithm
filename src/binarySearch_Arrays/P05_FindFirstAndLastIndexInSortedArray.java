package binarySearch_Arrays;

import java.util.Arrays;

import org.junit.Test;

public class P05_FindFirstAndLastIndexInSortedArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 34
	 * 
	 * Find first and last position of element in Sorted Array
	 * 
	 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending
	 * position of given target value.
	 * 
	 * If target is not found in the array return [-1,-1].
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
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
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		method1(nums,target);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {5,7,7,8,8,10};
		int target = 6;
		method1(nums,target);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2};
		int target = 2;
		method1(nums,target);
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums = {1,2,3};
		int target = 2;
		method1(nums,target);
	}
	
	@Test
	public void example5() {
		//Negative Test Data
		int[] nums = {3,3,3};
		int target = 3;
		method1(nums,target);
	}
	
	@Test
	public void example6() {
		//Negative Test Data
		int[] nums = {1,2,3};
		int target = 1;
		method1(nums,target);
	}
	
	@Test
	public void example7() {
		//Negative Test Data
		int[] nums = {3,3,3,3,3};
		int target = 3;
		method1(nums,target);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Since O(log n) is required, Binary Search algorithm must be implemented.
	 * 
	 * 1. Create variables, left, right and mid and assign values accordingly.
	 * 2. Create output array and add values -1,-1 by default (Since it has to be default value)
	 * 3. While left is less than or equal to right
	 * 		3a. Calculate mid with left+((right-left)/2)
	 * 		3b. When nums[mid] is less than target, left=mid+1;
	 * 		3c. When nums[mid] is greater than target, right=mid-1;
	 * 		3d. Else if nums[mid] == target
	 * 			3da. While nums[left] !=target increment it
	 * 			3db. While nums[right] !=target decrement it
	 * 			3dc. Return left and right as output[0] and output[1]
	 * 				3da and 3db are done since there might be instances where target could be available multiple
	 * 					times in the given array
	 * 4. Edge case: When nums
	 * 
	 * 
	 */	
	
	public int[] method1(int[] nums,int target) {
		int left=0,right=nums.length-1,mid=0;
        int[] output = {-1,-1};
            
        while(left<=right){
            mid = left + ((right-left)/2);
            if (nums[mid] < target) left=mid+1;
            else if (nums[mid] > target) right=mid-1;
            else {
            	while(nums[left]!=target) left++;
            	while(nums[right]!=target) right--;
            	output[0] = left;
            	output[1] = right;
            	//System.out.println("Left : " + left + " Mid : " + mid + " Right : " + right);
            	//System.out.println("*********************************");
            	break;
            }
        }
        System.out.println(Arrays.toString(output));
		return output;
       
    }
}

