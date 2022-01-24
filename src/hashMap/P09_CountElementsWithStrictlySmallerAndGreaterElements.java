package hashMap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

import org.junit.Test;

import junit.framework.Assert;

public class P09_CountElementsWithStrictlySmallerAndGreaterElements {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 2148
	 * 
	 * Given an integer array nums, return the number of elements that have both a 
	 * strictly smaller and a strictly greater element appears in nums.
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
		int[] nums = {11,7,2,15};
		int output = 2;
		Assert.assertEquals(output, countElements(nums));
	}
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {-3,3,3,90};
		int output = 2;
		Assert.assertEquals(output, countElements(nums));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {3,3,3,3};
		int output = 0;
		Assert.assertEquals(output, countElements(nums));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * DS: TreeMap
	 * 
	 * 1. Add all elements into treeMap					
	 * 2. Get the distinct keys in a list					
	 * 3. Set the counter as length of input array. Get the first and last elements
	 * 4. If both are same, it means there is no in between number and set the counter as 0
	 * 5. Else, set counter by reducing the value of first and last elements				
	 * 6. Return the counter					
	 * 
	 */	
	
	private int countElements(int[] nums) {
		TreeMap<Integer,Integer> tMap = new TreeMap<>();
		
		for(int i=0;i<nums.length;i++) {
			tMap.put(nums[i], tMap.getOrDefault(nums[i], 0)+1);
		}
		
		ArrayList<Integer> keys = new ArrayList<> (tMap.keySet());
		
		int counter = nums.length;
		int firstElement = keys.get(0);
		int lastElement = keys.get(keys.size()-1);
		
		if(firstElement == lastElement) counter = 0;		
		else counter -= (tMap.get(firstElement) + tMap.get(lastElement));
		
		return counter;
	}
}
