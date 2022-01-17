package sortingAlgorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class S02_InsertionSort {

	/*
	 * PROBLEM STATEMENT 
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
		int[] nums = {4,11,2,17,1,8,22,18};
		int[] expectedOutput = {1,2,4,8,11,17,18,22};
		Assert.assertTrue(Arrays.equals(expectedOutput, insertionSorting_approach2(nums)));
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {2,3,4,-1};
		int[] expectedOutput = {-1,2,3,4};
		Assert.assertTrue(Arrays.equals(expectedOutput, insertionSorting_approach2(nums)));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2,3,4,4,4,-1,-2,0};
		int[] expectedOutput = {-2,-1,0,2,3,4,4,4};
		Assert.assertTrue(Arrays.equals(expectedOutput, insertionSorting_approach2(nums)));
	}
	
	@Test
	public void example4() {
		//Negative Test Data
		int[] nums = {4,4,4,4,4};
		int[] expectedOutput = {4,4,4,4,4};
		Assert.assertTrue(Arrays.equals(expectedOutput, insertionSorting_approach2(nums)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach 1: // Might be slightly less than O(n^2) since we skip while loop few times
	 * 
	 * 1. Start from 0 element and iterate till i<nums.length-1
	 * 2. Compare current and next element, and swap accordingly
	 * 3. Only if there is a swap betwee current and next, check if all the previous elements are sorted
	 * 
	 * 
	 * Approach 2:  // O(n^2) for sure
	 * 
	 * 1. Start from 1 element and iterate till i<nums.length
	 * 2. Starting from current index, till the 0th element, make sure if all are swapped
	 * 3. 
	 *
	 * 
	 */	
	
	
	private int[] insertionSorting(int[] nums) {
		int currentIndex = 0,  temp = 0;
		for(int i=0;i<nums.length-1;i++) {
			if(nums[i] > nums[i+1]) {
				temp = nums[i];
				nums[i] = nums[i+1];
				nums[i+1] = temp;				
				
				currentIndex = i;
				
				while(currentIndex>0) {
					if(nums[currentIndex-1] > nums[currentIndex]) {
						temp = nums[currentIndex];
						nums[currentIndex] = nums[currentIndex-1];
						nums[currentIndex-1] = temp;
					}
					currentIndex--;
				}
			}	
			
		}
		
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	
	private int[] insertionSorting_approach2(int[] nums) {
		int currentIndex = 0,  temp = 0;
		for(int i=1;i<nums.length;i++) {
				currentIndex = i;	
				while(currentIndex>0) {
					if(nums[currentIndex-1] > nums[currentIndex]) {
						temp = nums[currentIndex];
						nums[currentIndex] = nums[currentIndex-1];
						nums[currentIndex-1] = temp;
					}
					currentIndex--;
				}
			
		}
		
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
