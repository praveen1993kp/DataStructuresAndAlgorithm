package twoPointer_Arrays;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

public class P01_SquareOfArrayElements {

	/*
	 * PROBLEM STATEMENT 
	 * 
	 * LeetCode - 977
	 * 
	 * Given a sorted integer array in non-decreasing order, 
	 * return the array of the squares of each number sorted in non-decreasing order
	 * 
	 * Understandings:
	 * 1. The array contains only integers
	 * 2. The array is always sorted
	 * 3. Non - decreasing order --> Can have same elements in consecutive positions
	 * 4. Return --> Square of each number 
	 * 5. Return --> Return in non-decreasing order - Can have same elements in consecutive positions too
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
		int[] nums = {1,2,3,3,4,5};
		int[] outputExpected = {1,4,9,9,16,25};
		
		Assert.assertTrue(Arrays.equals(outputExpected, squareMethod(nums)));
	}
	
	@Test
	public void example2() {
		//Edge Case Test Data
		int[] nums = {-5,-4,-3,1,3,4};
		int[] outputExpected = {1,9,9,16,16,25};
		//Assert.assertTrue(Arrays.equals(outputExpected, squareMethod(nums)));
		Assert.assertTrue(Arrays.equals(outputExpected, square(nums)));
		
	}
	
	@Test
	public void example3() {
		//Negative Test Data
		int[] nums = {3};
		int[] outputExpected = {9};
		Assert.assertTrue(Arrays.equals(outputExpected, square(nums)));
	}
	
	/*
	 * --- Pseudo Code ---
	 * 1) Create a new array of same size and value
		2) left = 0, right = len-1
		3) insertIndex = len - 1 (bigger number at end)
		4) while (left <= right) 
    		a) If left absolute is smaller than right absolute
         --> insert the squared value of left in the insert index
    		b) else insert the squared value of right in the insert index
	 */	
	
	public int[] squareMethod(int[] nums) {
		int i=0;
		while (i<nums.length) {
			nums[i] = nums[i] * nums[i];
			i++;
		}
		Arrays.sort(nums);
		return nums;
	}
	
	private int[] twoPointer(int[] nums) {
		int p1 = 0;
		int p2 = 1;
		
		int i = 0;
		while(i<nums.length) {
			nums[i] = nums[i] * nums[i];
			i++;
		}
		while(p2<nums.length) {
			if(nums[p1]>nums[p2]) {
				int temp = nums[p1];
				nums[p1] = nums[p2];
				nums[p2] = temp;
				p2++; 
			} else if (nums[p1]<nums[p2]){
					p1++;
					p2--;
			} else p1++;
				
			
			System.out.print(Arrays.toString(nums));
			System.out.println(p1 +","+p2);
		}
		System.out.println(Arrays.toString(nums));
		return nums;
	}
	
	private int[] square(int[] nums) {
		//twoPointer	
		int pointer1 = 0, pointer2 = nums.length-1, index = nums.length-1;
		int[] outputArray = new int[nums.length];
		while(pointer1<=pointer2) {
			if(Math.abs(nums[pointer1]) < Math.abs(nums[pointer2])){
				outputArray[index--] = nums[pointer2] * nums[pointer2--];
			} else {
				outputArray[index--] = nums[pointer1] * nums[pointer1++];
			}
		}
		System.out.println(Arrays.toString(outputArray));
		return outputArray;
	}
	
	private int[] square_OptimizedSoln(int[] nums) {
		//twoPointer	
		int left=0,right=nums.length-1,index=right;
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            nums[i] *= nums[i];
        }
        while(left<=right){
            ans[index--] = nums[left] < nums[right] ? nums[right--] : nums[left++];
        }
        return ans;	
	}
}
