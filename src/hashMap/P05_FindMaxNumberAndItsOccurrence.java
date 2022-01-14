package hashMap;

import java.util.HashMap;
import java.util.Map.Entry;

import org.junit.Test;

public class P05_FindMaxNumberAndItsOccurrence {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given an integer array nums, find the max frequency number and its occurrence.
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
		int[] nums = {1,2,2,3,4,5,4,2};
		findTheNumber(nums);
		
	}
	
	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,2,3,4,5,4,2};
		findTheNumber(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1,2,3,4,5};
		findTheNumber(nums);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * HashMap:
	 * 
	 * 1. Create a hashMap
	 * 2. Add all the elements into hashMap
	 * 3. Once its added, check if the count of current element is greater than maxFrequency
	 * 4. If so, assign max frequency to current element count
	 * 5. If only one element needs to be returned, return the maxNum
	 * 6. If all the elements with maxFrequency count has to be returned, use entryset
	 * 
	 */	
	
	private void findTheNumber(int[] nums) {
		HashMap<Integer,Integer> hMap = new HashMap<>();
		int maxNum = 0, maxFrequency = Integer.MIN_VALUE;
		
		for(int currentElement=0;currentElement<nums.length;currentElement++) {
			hMap.put(nums[currentElement], hMap.getOrDefault(nums[currentElement],0)+1);
			if(hMap.get(nums[currentElement])>maxFrequency) {
				maxFrequency = hMap.get(nums[currentElement]);
				maxNum = nums[currentElement];
			}
		}
		System.out.println(maxNum);
		System.out.println(maxFrequency);  // return only one element
		System.out.println("******");
		//return all the numbers with max Frequency
		
		for (Entry<Integer,Integer> entry : hMap.entrySet()) {
			if(entry.getValue() == maxFrequency){
				System.out.println("Element : " + entry.getKey() + " -- NoOfOccurrences : " + entry.getValue());
			}
		}
	}
}
