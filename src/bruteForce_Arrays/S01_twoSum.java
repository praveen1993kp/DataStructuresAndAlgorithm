package bruteForce_Arrays;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class S01_twoSum {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * LeetCode Problem - 1
	 * 
	 * Given the input int array, find the sum of any two distinct indices of the matching, given the target
	 * 
	 * Understanding:
	 * 1. Given - int array and target
	 * 2. When - target equals sum of any two elements in int array
	 * 3. Then - return the indices of two elements
	 * 
	 * 
	 */ 
	 
	/*
	 * 1. Did I understand the problem? - YES
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
		int[] nums = {2,3,4,1,6,0,5};
		int target = 6;
		int[][] expectedOutput = {{0,2},{3,6},{4,5}};
		twoSum(nums,target);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {2,-3,4,1,6,0,5,9,-12,18};
		int target = 6;
		int[][] expectedOutput = {{0,2},{1,7},{3,6},{4,5},{8,9}};
		twoSum(nums,target);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2,3,4,1,6,0,5};
		int target = 25;
		int[][] expectedOutput = {};
		twoSum(nums,target);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1. Traverse using an outer loop
	 * 2. Traverse using another loop which is outerloop +1
	 * 3. for each element in outer loop, if the sum of two loop elements matches the target, get the indices
	 * 4. Store the indices in a two dimensional array
	 * 5. Exit the loops
	 */	
	
	public void twoSum(int[] nums, int target) {
		for(int i=0; i<nums.length; i++) {
			for(int j=i+1; j<nums.length; j++) {
				if((nums[i] + nums[j]) == target){
					System.out.println(i+" "+j);
				}
			}
		}
		
		
	}
}
