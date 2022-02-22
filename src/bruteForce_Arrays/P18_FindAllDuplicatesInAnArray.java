package bruteForce_Arrays;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class P18_FindAllDuplicatesInAnArray {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 442
	 * 
	 * Find All Duplicates In An Array
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
		int[] nums = {4,3,2,7,8,2,3,1};
		findDuplicates(nums);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {1,1,2};
		findDuplicates(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {1};
		findDuplicates(nums);
	}
	
	

	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Sort the given array
	 * 2. Create output list
	 * 3. Create variables left and right
	 * 4. Traverse while right less than nums.length
	 * 5. If nums[left] == nums[right] add into arraylist
	 * 6. Return arraylist
	 */	
	
	private ArrayList<Integer> findDuplicates(int[] nums) {
		Arrays.sort(nums);
        ArrayList<Integer> al = new ArrayList<>();
        int left=0,right=1;
        while(right<nums.length)
            if(nums[left++] == nums[right++]) al.add(nums[left]);
        return al;
	}
}
