package bitwiseOperator;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

public class P01_SingleNumberInAnUnsortedArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode #136 
	 * 
	 * Find Single Number in an Unsorted Array
	 * 
	 * Do it in linear time and space complexity
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
		int[] nums = {2,2,1};
		int output = 1;
		System.out.println(findSingleNumber_hashMap(nums));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {4,1,2,1,2};
		int output = 4;
		System.out.println(findSingleNumber_hashMap(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {4};
		int output = 4;
		System.out.println(findSingleNumber_hashMap(nums));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach 1 : Using BitWise Operator (Optimized method)
	 * 
	 * 1. Initialize val as 0
	 * 2. Iterate through each element of array and use bitwise operator for val ^= current element
	 * 3. Return val
	 * 
	 * 
	 * Approach 2 : Sort the Array and find unique value (Not advised since linear time/space is expected)
	 * 1. Sort the array
	 * 2. Initialize variables left and right to 0 and 1 respectively
	 * 3. Traverse through the array
	 * 4. If values are matching, increment left and right to current value +2
	 * 5. Else return nums[left]
	 * 6. Continue till right < nums.length
	 * 7. Return last element by default
	 * 
	 * 
	 * Approach 3 : Using HashMap (Not advised since linear space is expected)
	 * 1. Add the elements as keys and update values into HashMap
	 * 2. Find the value which has value as 1
	 * 3. Return the key
	 * 
	 * 
	 * 
	 */	
	
	private int findSingleNumber(int[] nums) {
		int val = 0;
		for(int i=0;i<nums.length;i++) 
			val ^= nums[i];
		return val;
		
	}
	
	private int findSingleNumber_sortingTheArray(int[] nums) {
		Arrays.sort(nums);
		int left = 0,right = 1;
		while(right<nums.length) {
			if(nums[left]==nums[right]) {
				left=left+2;
				right=right+2;
			}
			else return nums[left];
		}
		return nums[nums.length-1];
		
	}
	
	private int findSingleNumber_hashMap(int[] nums) {
		HashMap<Integer,Integer> hMap = new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			hMap.put(nums[i],hMap.getOrDefault(nums[i], 0)+1);
		}
		for(Entry<Integer,Integer> entry : hMap.entrySet()) {
			if(entry.getValue() == 1)
				return entry.getKey();
		}
		return -1;
		
	}

	
}
