package bruteForce_Arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P25_ProductOfArrayExceptSelf {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * Leetcode - 238
	 * 
	 * Product Of Array Except Self
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
		int[] nums = {1,2,3,4};
		int[] output = {24,12,8,6};
		Assert.assertTrue(Arrays.equals(output, findProduct(nums)));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {-1,-2,-3,-4};
		int[] output = {-24,-12,-8,-6};
		Assert.assertTrue(Arrays.equals(output, findProduct(nums)));
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {5};
		int[] output = {1};
		Assert.assertTrue(Arrays.equals(output, findProduct(nums)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 
	 * Approach : Dynamic Programming
	 * 
	 * 1. Create an output array of size same as that of nums
	 * 2. Create pointers leftProduct and rightProduct
	 * 3. Traverse from 0 till end of array
	 * 4. Add ans[i] as leftProduct
	 * 5. Multiply leftProduct with ans[i]
	 * 6. Once traversing is done, traverse in the reverse direction(From n-1 till 0)
	 * 7. Repeat steps 4-5 for right values
	 * 8. Return ans
	 * 
	 */	
	
	private int[] findProduct(int[] nums) {
		int[] ans = new int[nums.length];
        int leftProduct=1,rightProduct=1;
        for(int i=0;i<nums.length;i++){
            ans[i] = leftProduct;
            leftProduct *= nums[i];    
        }
        
        for(int j=nums.length-1;j>=0;j--){
            ans[j] *= rightProduct;
            rightProduct *= nums[j];    
        }
        return ans;
	}
}
