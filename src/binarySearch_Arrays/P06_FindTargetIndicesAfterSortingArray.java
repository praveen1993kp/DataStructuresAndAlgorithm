package binarySearch_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P06_FindTargetIndicesAfterSortingArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 2089
	 * 
	 * Find Target Indices After Sorting Array
	 * 
	 * // Use same logic as problem #34. Just apply sorting before
	 * 
	 * You are given a 0-indexed integer array nums and a target element target.
	 * 
	 * A target index is an index i such that nums[i] == target.
	 * 
	 * Return a list of the target indices of nums after sorting nums in non-decreasing order.
	 * If there are no target indices, return an empty list. The returned list must be sorted in increasing order.
	 * 
	 * If there are multiple, return all.
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
		int[] nums = {5,8,7,8,8,10};
		int target = 8;
		method1(nums,target);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {5,10,7,7,8,10};
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
		int[] nums = {3,2,1,-1};
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
	
	@Test
	public void example8() {
		//Negative Test Data
		int[] nums = {75,99,19,93,87,68,12,18,48,83,24,50,16,53,36,16,80,68,46,13,53,100,50,49,77,52,34,42,38,98,73,11,13,61,72,8,11,67,98,24,23,71,47,6,5,7,97,86,25,82,11,15,26,97,69,6,30,77,98,44,32,39,71,47,64,78,6,61,72,75};
		int target = 98;
		method1(nums,target);
	}
	
	
	
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 
	 * 1. Create variables, left, right and mid and assign values accordingly.
	 * 2. Sort the given array
	 * 3. Create output list.
	 * 4. While left is less than or equal to right
	 * 		4a. Calculate mid with left+((right-left)/2)
	 * 		4b. When nums[mid] is less than target, left=mid+1;
	 * 		4c. When nums[mid] is greater than target, right=mid-1;
	 * 		4d. Else if nums[mid] == target
	 * 			4da. While nums[left] !=target increment it
	 * 			4db. While nums[right] !=target decrement it
	 * 			4dc. While left<=right, add left to list
	 * 5. Edge case: When there are multiple indices, return all
	 * 
	 * 
	 */	
	
	public List<Integer> method1(int[] nums,int target) {
		Arrays.sort(nums);
		int left=0,right=nums.length-1,mid=0;
        List<Integer> output = new ArrayList<>();
        while(left<=right){
            mid = left + ((right-left)/2);
            if(nums[mid] < target) left = mid+1;
            else if (nums[mid] > target) right = mid-1;
            else {
            	while(nums[left] != target) left++;
            	while(nums[right] != target) right--;
            	while(left<=right) output.add(left++);
            	break;
            }   
        }
        System.out.println(output.toString());
		return output;
       
    }
}

