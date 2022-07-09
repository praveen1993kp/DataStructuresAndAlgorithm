package twoPointer_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class P23_3Sum {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode #15 - 3Sum
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
		int[] nums = {-1,0,1,2,-1,-4};
		System.out.println(findTriplets(nums));
	}
	
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {0,0,0,0,0,0};
		System.out.println(findTriplets(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Logic : Applying same logic as two Sum - II problem
	 * 
	 * 1. Sort the array
	 * 2. Create a list for output which can accomodate List<Integers> as generics
	 * 3. Traverse through the given array
	 * 4. For each element, starting from the next index, till last index of array, see if any two elements has sum equal to negative of current element
	 * 5. If sum less than target, increment left, else decrement right
	 * 6. If found, add them to outputlist 
	 * 7. To make sure there are no duplicates, increment left till same element is found
	 * 8. To make sure there are no duplicates, decrement right till same element is found
	 * 9. Increment left and decrement right to move to new element
	 * 10. Return output array
	 * 
	 */	
	
	public List<List<Integer>> findTriplets(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> lst = new ArrayList<>();
		for(int i=0;i<nums.length;i++) {
			if(i==0 || i>0 && nums[i-1] != nums[i]) {
				int target = -nums[i];
				int left = i+1,right=nums.length-1;
				while(left<right) {
					int sumValue = nums[left] + nums[right];
					if(sumValue==target) {
						lst.add(Arrays.asList(nums[i],nums[left],nums[right]));
						while(left<right && nums[left+1] == nums[left]) left++;
						while(left<right && nums[right-1] == nums[right]) right--;
						left++;
						right--;
					} else if (sumValue < target) left++;
					else right--;
				}
			}
		}
		return lst;
	}
}
