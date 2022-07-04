package slidingWindow_Arrays;

import java.util.Arrays;

import org.junit.Test;

public class P12_TwoSumII {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 167
	 * 
	 * Two Sum II - Input Array Is Sorted
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
		int[] numbers = {2,7,11,15};
		int target = 22;
		System.out.println(Arrays.toString(findIndices(numbers,target)));
	}	

	@Test
	public void example2() {
		//Edge Case Test Data
		int[] numbers = {3,24,50,79,88,150,345};
		int target = 200;
		System.out.println(Arrays.toString(findIndices(numbers,target)));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] numbers = {-1,0};
		int target = -1;
		System.out.println(Arrays.toString(findIndices(numbers,target)));
		
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * 1. Create pointers left,right and initialize them to 0 and numbers.length-1 respectively
	 * 2. Create an output array of size 2
	 * 3. Traverse while left<right
	 * 4. Calculate the sum as numbers[left] + numbers[right]
	 * 		4a. If the sum is less than target, increment left (Incrementing the lowest value)
	 * 		4b. If the sum is greater than target, decrement right (Decrementing the highest value)
	 * 		4c. If the sum and target are equal, update the output array as index values +1 and break
	 * 5. Return the output array as default	
	 * 
	 * 
	 */	
	
	private int[] findIndices(int[] numbers, int target) {
		int left = 0,right=numbers.length-1;
        int[] output = {-1,-1};
        while(left<right){
            int sum = numbers[left] + numbers[right];
            if(sum < target) left++;
            else if (sum > target) right--;
            else {
                output[0] = left+1;
                output[1] = right+1;
                return output;
            }
        }
        return output;
	}
}
