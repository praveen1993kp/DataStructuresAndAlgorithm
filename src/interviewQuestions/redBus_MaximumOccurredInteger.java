package interviewQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class redBus_MaximumOccurredInteger {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * int[] arr = {1,2,3,2,3,2,3,4}
	 * output = 2,3
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
		
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] arr = {1,2,3,2,3,2,3,4,5,3,2,3};
		 //output = 2,3
		maxInteger(arr);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * If only one element needs to be returned
	 * 
	 * 1. Create left = 0, right = 0, sum = 0, maxSum = Integer.MIN_VALUE, number = 0;
	 * 2. Keep left as constant and right as moving pointer
	 * 3. Iterate through each element and count the value.
	 * 
	 * If all the elements needs to be returned
	 * 1. Add all the elements to hashMap
	 * 2. Iterate through the values and get maximum value
	 * 3. Iterate through the keys and return the keys which have maximum value
	 */	
	
	private void maxInteger(int[] nums) {
		int left = 0, maxCounter = Integer.MIN_VALUE;
		HashMap<Integer,Integer> hMap = new HashMap<>();
		while(left<nums.length) hMap.put(nums[left], hMap.getOrDefault(nums[left++], 0)+1);
		Iterator<Integer> vals = hMap.values().iterator();
		while(vals.hasNext()) maxCounter = Math.max(maxCounter, vals.next());	 
		Iterator<Integer> keys = hMap.keySet().iterator();
		while(keys.hasNext()) {
			Integer currentKey = keys.next();
			if(hMap.get(currentKey)==maxCounter) System.out.println(currentKey);
		}
	}
}
