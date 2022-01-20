package slidingWindow_Arrays;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class P04_CountAbsoluteDistinctValues {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Given an array or sorted integers that may contain several duplicate elements,
	 * count the total number of distinct values in it
	 * 
	 * Input:  { -1, -1, 0, 1, 1, 1 }
		Output: The total number of distinct absolute values is 2 (0 and 1)
 
 
		Input:  { -2, -1, 0, 1, 2, 3 }
		Output: The total number of distinct absolute values is 4 (0, 1, 2 and 3)
 
 
		Input:  { -1, -1, -1, -1 }
		Output: The total number of distinct absolute values is 1 (only 1
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
		int[] nums = {-1,-1,0,1,1,1};
		distinctValues(nums);
	}

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {-2,-1,0,1,2,3};
		distinctValues(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {-1,-1,-1,-1};
		distinctValues(nums);
	}
	
	/*
	 * --- Pseudo Code ---
	 * DS: Set
	 * 
	 * 1. Create a set
	 * 2. Push the absolute values into set
	 * 3. Return the size of set
	 */	
	
	private int distinctValues(int[] nums) {
		HashSet<Integer> hSet = new HashSet<>();
		for(int i=0;i<nums.length;i++) hSet.add(Math.abs(nums[i]));
		System.out.println(hSet.size());
		return hSet.size();
	}

}
