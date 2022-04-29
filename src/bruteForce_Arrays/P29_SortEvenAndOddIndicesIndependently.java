package bruteForce_Arrays;

import org.junit.Test;

public class P29_SortEvenAndOddIndicesIndependently {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 2164
	 * 
	 * Sort Even And Odd Indices Independently
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
		int[] nums = {10,1,9,2,8,3,7,4,6,5};
		sortEvenAndOddIndices(nums);
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {4,1,2,3};
		sortEvenAndOddIndices(nums);
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {2,1};
		sortEvenAndOddIndices(nums);
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Traverse through the given array
	 * 2. Create variable val and initialize it to i
	 * 3. If i is odd, check for minimum number index and swap the current index value with that
	 * 4. If i is even, check for maximum number index and swap the current index value with that
	 * 5. Return nums
	 * 
	 */	
	
	private int[] sortEvenAndOddIndices(int[] nums) {
		for(int i=0;i<nums.length;i++){
	           int val = i;
	           if(i%2==0){
	               for(int j=i+2;j<nums.length;j=j+2){
	                   if(nums[j] < nums[val]) val = j;
	               }    
	           } else {
	               for(int j=i+2;j<nums.length;j=j+2){
	                   if(nums[j] > nums[val]) val = j;
	               } 
	           }
	           int temp = nums[i];
	           nums[i] = nums[val];
	           nums[val] = temp;
	       }
	   return nums;
	}
}
