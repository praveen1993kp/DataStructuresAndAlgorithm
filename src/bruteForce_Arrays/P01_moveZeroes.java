package bruteForce_Arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import junit.framework.Assert;

public class P01_moveZeroes {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * LeetCode Problem No - 283
	 * 
	 * Given an integer array nums, move all 0's to the end of it while maintaining
	 * the relative order of non-zero elements.
	 * 
	 * Understanding:
	 * 1. Given 
	 * 	* Integer array nums
	 * 2. When
	 * 	* Array contains 0/multiple 0s,
	 * 3. Then
	 *  * Move all 0's to end of the array
	 * 4. Condition
	 *  * Maintain relative order of non-zero elements
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem?  - yes
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
		int[] nums = {1,0,3,0,0,4,5,0,0,3,12,15};
		int[] outputArray = {1,3,4,5,3,12,15,0,0,0,0,0}; 
		Assert.assertTrue(Arrays.equals(outputArray, moveZeroesTwoPointer(nums)));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = new int[5];
		nums[2] = 1;
		nums[1] = 2;		
		int[] outputArray = {2,1,0,0,0};
		Assert.assertTrue(Arrays.equals(outputArray, moveZeroesTwoPointer(nums)));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,3,4,5,3,12,15};
		int[] nums2 = {0};
		int[] outputArray = {1,3,4,5,3,12,15};
		int[] outputArray2 = {0};
		Assert.assertTrue(Arrays.equals(outputArray2, moveZeroesTwoPointer(nums2)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Brute Force:
	 * 
	 * 1. Create two arraylists, al1 and al2
	 * 2. Iterate through array
	 * 3. If element is not "0", add to al1
	 * 4. Else, add to al2
	 * 5. using list.addAll() method, add al2 to al1
	 * 6. Convert list to array
	 * 
	 * Time Complexity : O[n] + O[n] = O[n]
	 *
	 * Two Pointer Algorithm
	 * 
	 * 1. Create two pointers left and right. Left = 0 and right = left+1
	 * 2. Traverse while right is less than input array length
	 * 3. nums[left] == 0 && nums[right] !=0, 
	 *		3a. Swap the values
	 *		3b. Increment left and right
	 * 4. nums[left] != 0 
	 * 		4a. Increment left and right
	 * 5. nums[left] == 0 && nums[right] ==0
	 * 		5a. Increment only right
	 * 
	 * Time Complexity : <O[n]
	 */	
	
	public int[] moveZeroesMethod(int[] nums) {
		
		List<Integer> al1 = new ArrayList<Integer>(); //O[1]
		List<Integer> al2 = new ArrayList<Integer>(); //O[1]
		for(int i=0; i<nums.length; i++) { //O[n]
			if(nums[i] != 0) al1.add(nums[i]); //O[2]
			else al2.add(nums[i]); //O[1]
		}
		al1.addAll(al2); //O[1];
		for (int j=0; j<al1.size(); j++) { //O[n]
			nums[j] = al1.get(j); //O[1]
		}
		return nums; //O[1]
		
		//O[1] + //O[1] + O[n] + //O[2] + //O[1] + //O[1] + O[n] + //O[1]
		//O[n] + //O[n]
		//O[n]  -- Final time complexity
		
	}
	
	public int[] moveZeroesTwoPointer(int[] nums) {
		int left = 0,right = 1;   //O[1]
		
		while(right<nums.length) { //<O[n]
			if(nums[left]==0) { //O[1]
				if(nums[right] !=0) { //O[1]
					int temp = nums[left]; //O[1]
					nums[left++] = nums[right]; //O[1]
					nums[right] = temp; //O[1]
				}	
			} else left++; //O[1]
			right++; //O[1]
		}
		
		System.out.println(Arrays.toString(nums));
		return nums;
	}
}
